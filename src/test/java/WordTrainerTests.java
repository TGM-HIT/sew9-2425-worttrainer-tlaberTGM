import at.tlaber.model.WordImage;
import at.tlaber.model.WordTrainer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class WordTrainerTests {

    @Test
    @DisplayName("Test 1 - Creating a WordTrainer Object and testing the check Methode")
    void test1() {
        List<WordImage> wordImages = new ArrayList<>();
        wordImages.add(new WordImage("Handy", "https://pixabay.com/de/vectors/smartphone-apfel-mobiltelefon-153650/"));

        WordTrainer wordTrainer = new WordTrainer();
        wordTrainer.setWordImages(wordImages);

        String word = wordTrainer.getCurrent().getWord();

        assertEquals(true, wordTrainer.check(word));
        assertEquals(false, wordTrainer.check("Auto"));
    }

    @Test
    @DisplayName("Test 2 - testing setWordImages methode with null")
    void test2() {
        assertThrows(IllegalArgumentException.class, () -> new WordTrainer().setWordImages(null));
    }

    @Test
    @DisplayName("Test 3 - testing setWordImages method with empty list")
    void test3() {
        assertThrows(IllegalArgumentException.class, () -> new WordTrainer().setWordImages(new ArrayList<>()));
    }

    @Test
    @DisplayName("Test 4 - testing setTotal methode")
    void test4() {
        assertThrows(IllegalArgumentException.class, () -> new WordTrainer().setTotal(-1));
    }

    @Test
    @DisplayName("Test 5 - testing setCorrect methode")
    void test5() {
        assertThrows(IllegalArgumentException.class, () -> new WordTrainer().setCorrect(-1));
    }
}
