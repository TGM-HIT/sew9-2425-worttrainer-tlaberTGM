package at.tlaber.model;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * WordImage class
 * @author Thomas Laber
 * @version 2024-09-23
 */
public class WordImage {
    private String word;
    private String url;

    /**
     * WordImage Contructor
     * @param word the Word which the user is trying to guess
     * @param url the URL which links to the picture relating to the Word
     */
    public WordImage(String word, String url) {
        setWord(word);
        setUrl(url);
    }

    /**
     * getter Methode for word
     * @return the word which the user is trying to guess
     */
    public String getWord() {
        return word;
    }

    /**
     * setter Methode for word
     * @param word the word the user is trying to guess
     * @throws IllegalArgumentException if word is empty
     */
    public void setWord(String word) throws IllegalArgumentException {
        if( word == null || word.isEmpty() ) {
            throw new IllegalArgumentException("Word cannot be null or empty");
        }
        this.word = word;
    }

    /**
     * getter Methode for url
     * @return the url which contains the picture related to the word
     */
    public String getUrl() {
        return url;
    }

    /**
     * setter Method for url
     * @param url the url which contains the related picture to the word
     * @throws IllegalArgumentException if the url is empty or is not accepted as a valid url
     */
    public void setUrl(String url) throws IllegalArgumentException {
        if( url == null || url.isEmpty() || !validateUrl(url)) {
            throw new IllegalArgumentException("URL cannot be null or empty or is an invalid URL");
        }
        this.url = url;
    }

    /**
     * a Methode to validate the url
     * @param url the url which contains the related picture to the word
     * @return true or false depending on if the url is valid or not
     */
    public boolean validateUrl(String url) {
        try {
            URL urlNew = new URL(url);
            return true;
        }
         catch (MalformedURLException e) {
            return false;
        }
    }
}
