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

        WordTrainer wordTrainer = new WordTrainer();

        assertEquals(14, wordTrainer.getTotal());
        assertEquals(7, wordTrainer.getWordImages().size());
        assertEquals(7, wordTrainer.getCorrect());
        assertEquals("Auto", wordTrainer.getWordImages().get(0).getWord());
    }

    @Test
    @DisplayName("Test 2 - testing the store methode")
    public void test2() {
        WordTrainer wordTrainer = new WordTrainer();

        wordTrainer.setTotal(14);
        wordTrainer.store();
        wordTrainer.load();
        assertEquals(14, wordTrainer.getTotal());
    }
}
