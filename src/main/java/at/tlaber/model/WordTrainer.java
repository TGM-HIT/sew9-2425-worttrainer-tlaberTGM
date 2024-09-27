package at.tlaber.model;

import java.util.List;
import java.util.Random;


/**
 * WordTrainer Klasse
 * @author Thomas Laber
 * @version 2024-09-23
 */
public class WordTrainer {
    private int current;
    private List<WordImage> words;
    private int total;
    private int correct;
    private StorageSystem storage = new JSONStorage();

    /**
     * Constructor for WordTrainer
     *
     * @throws IllegalStateException if the words have an illegal state, to ensure safe access to the word size
     */
    public WordTrainer() {
        this.storage.load(this);

        if(words==null || words.isEmpty()) {
            throw new IllegalStateException("Word List is still empty or null after loading");
        }
        this.current = new Random().nextInt(words.size());
    }

    /**
     * getter Methode for current
     * @return current Word
     */
    public WordImage getCurrent() {
        return words.get(this.current);
    }

    /**
     * getter Methode for WordImages
     * @return all WordImages
     */
    public List<WordImage> getWordImages() {
        return words;
    }

    /**
     * setter for WordImages
     * @param words a List of WordImages
     * @throws IllegalArgumentException if the list is empty
     */
    public void setWordImages(List<WordImage> words) throws IllegalArgumentException{
        if(words == null || words.size() == 0) {
            throw new IllegalArgumentException("Word images cannot be empty");
        }
        this.words = words;
    }

    /**
     * getter Methode for Total
     * @return the total guesses
     */
    public int getTotal() {
        return total;
    }

    /**
     * setter Methode for total
     * @param total the total guesses the user has taken
     * @throws IllegalArgumentException if total is negative
     */
    public void setTotal(int total) throws IllegalArgumentException {
        if(total < 0) {
            throw new IllegalArgumentException("Total must be a positive integer");
        }
        this.total = total;
    }

    /**
     * getter Methode for correct
     * @return the correct guesses
     */
    public int getCorrect() {
        return correct;
    }

    /**
     * setter Methode for correct
     * @param correct the correct guesses the user has taken
     * @throws IllegalArgumentException if correct is negative
     */
    public void setCorrect(int correct) throws IllegalArgumentException {
        if(correct < 0) {
            throw new IllegalArgumentException("Correct must be a positive integer");
        }
        this.correct = correct;
    }

    /**
     * a loading Methode for the Wordtrainer
     */
    public void load() {
        this.storage.load(this);
        changeCurrent();
    }

    /**
     * a store methode for the Wordtrainer
     */
    public void store() {
        this.storage.store(this);
    }

    /**
     * a Methode to check the users input with the correct answer
     * @param input the users guess
     * @return if the guess was correct or not
     */
    public boolean check(String input) {
        return input.toLowerCase().equals(getCurrent().getWord().toLowerCase());
    }

    /**
     * a Methode to change the current picture
     */
    public void changeCurrent() {
        int random;
        do {
            random = new Random().nextInt(words.size());
        } while (random == current);
        current = random;
    }
}
