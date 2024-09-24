import at.tlaber.model.WordImage;
import at.tlaber.model.WordTrainer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JSONStorageTests {

    @Test
    @DisplayName("Test 1 - testing the load methode")
    public void test1() {
        List<WordImage> wordImages = new ArrayList<>();
        wordImages.add(new WordImage("Handy", "https://pixabay.com/de/vectors/smartphone-apfel-mobiltelefon-153650/"));

        WordTrainer wordTrainer = new WordTrainer();
        wordTrainer.setWordImages(wordImages);
        wordTrainer.setTotal(10);
        wordTrainer.setCorrect(7);

        assertEquals(10, wordTrainer.getTotal());
        assertEquals(1, wordTrainer.getWordImages().size());
        assertEquals(7, wordTrainer.getCorrect());
        assertEquals("Handy", wordTrainer.getWordImages().get(0).getWord());
    }

    @Test
    @DisplayName("Test 2 - testing the store methode")
    public void test2() {
        WordTrainer wordTrainer = new WordTrainer();
        List<WordImage> wordImages = new ArrayList<>();
        wordImages.add(new WordImage("Handy", "https://pixabay.com/de/vectors/smartphone-apfel-mobiltelefon-153650/"));
        wordImages.add(new WordImage("Auto", "https://pixabay.com/de/vectors/smartphone-apfel-mobiltelefon-153650/"));
        wordTrainer.setWordImages(wordImages);
        wordTrainer.setTotal(14);
        wordTrainer.setCorrect(7);
        wordTrainer.store();
        wordTrainer.load();
        assertEquals(14, wordTrainer.getTotal());
    }
}
