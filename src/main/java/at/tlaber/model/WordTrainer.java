package at.tlaber.model;

import java.util.List;
import java.util.Random;

public class WordTrainer {
    private int current;
    private List<WordImage> words;
    private int total;
    private int correct;

    public WordTrainer() {
        //TODO loading to be done
    }

    public WordImage getCurrent() {
        return words.get(this.current);
    }

    public List<WordImage> getWordImages() {
        return words;
    }

    public void setWordImages(List<WordImage> words) throws IllegalArgumentException{
        if(words == null || words.size() == 0) {
            throw new IllegalArgumentException("Word images cannot be empty");
        }
        this.words = words;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) throws IllegalArgumentException {
        if(total < 0) {
            throw new IllegalArgumentException("Total must be a positive integer");
        }
        this.total = total;
    }

    public int getCorrect() {
        return correct;
    }

    public void setCorrect(int correct) throws IllegalArgumentException {
        if(correct < 0) {
            throw new IllegalArgumentException("Correct must be a positive integer");
        }
        this.correct = correct;
    }

    public void load() {
        //TODO implement loading
    }

    public void store() {
        //TODO implement storing
    }

    public boolean check(String input) {
        return input.toLowerCase().equals(getCurrent().getWord().toLowerCase());
    }

    public void changeCurrent() {
        int random;
        do {
            random = new Random().nextInt(words.size());
        } while (random == current);
        current = random;
    }
}
