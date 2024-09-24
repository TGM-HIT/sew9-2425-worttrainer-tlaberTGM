package at.tlaber.model;

import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * JSONStrorage class
 * @author Thomas Laber
 * @version 2024-09-24
 */
public class JSONStorage implements StorageSystem {
    /**
     * JSONStorage Constructor
     */
    public JSONStorage() {}

    /**
     * methode to load a wordTrainer json
     * @param wordTrainer the wordtrainer object in which the saved state will be loaded into
     */
    @Override
    public void load(WordTrainer wordTrainer) {
        try {
            String content = new String(Files.readAllBytes(Paths.get("wordTrainer.json")));
            JSONObject jsonObject = new JSONObject(content);

            int total;
            try {
                total = jsonObject.getInt("total");
            } catch (JSONException e) {
                total = 0;
            }
            wordTrainer.setTotal(total);

            int correct;
            try {
                correct = jsonObject.getInt("correct");
            } catch (JSONException e) {
                correct = 0;
            }
            wordTrainer.setCorrect(correct);

            JSONArray words = jsonObject.getJSONArray("words");
            ArrayList<WordImage> images = new ArrayList<>();
            for(Object o : words) {
                JSONObject word = (JSONObject) o;
                String wordString = word.getString("word");
                String urlString = word.getString("url");
                images.add(new WordImage(wordString, urlString));
            }
            wordTrainer.setWordImages(images);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * the methode to store a wordTrainer state
     * @param wordTrainer the wordTrainer state which will be stored
     */
    @Override
    public void store(WordTrainer wordTrainer) {
        try {
            JSONObject jsonObject = new JSONObject();

            jsonObject.put("total", wordTrainer.getTotal());

            jsonObject.put("correct", wordTrainer.getCorrect());

            JSONArray words = new JSONArray();
            for (WordImage wi : wordTrainer.getWordImages()) {
                JSONObject wordObject = new JSONObject();
                wordObject.put("word", wi.getWord());
                wordObject.put("url", wi.getUrl());
                words.put(wordObject);
            }

            jsonObject.put("words", words);

            Files.write(Paths.get("wordTrainer.json"), jsonObject.toString(4).getBytes());
        } catch(Exception e) {
            e.printStackTrace();
        }
    }


}
