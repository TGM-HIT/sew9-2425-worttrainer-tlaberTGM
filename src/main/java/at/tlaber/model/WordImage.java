package at.tlaber.model;

import java.net.MalformedURLException;
import java.net.URL;

public class WordImage {
    private String word;
    private String url;

    public WordImage(String word, String url) {
        setWord(word);
        setUrl(url);
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) throws IllegalArgumentException {
        if( word == null || word.isEmpty() ) {
            throw new IllegalArgumentException("Word cannot be null or empty");
        }
        this.word = word;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) throws IllegalArgumentException {
        if( url == null || url.isEmpty() || !validateUrl(url)) {
            throw new IllegalArgumentException("URL cannot be null or empty or is an invalid URL");
        }
        this.url = url;
    }

    public boolean validateUrl(String url) {
        try {
            URL urlNew = new URL(url);
            return true;
        }
        catch(MalformedURLException e) {
            return false;
        }
    }
}
