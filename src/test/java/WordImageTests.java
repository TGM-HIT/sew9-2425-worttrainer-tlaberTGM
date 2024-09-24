import at.tlaber.model.WordImage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class WordImageTests {

    @Test
    @DisplayName("Test 1 - Creating a WordImageobject")
    void test1() {
        WordImage wordImage = new WordImage("Handy", "https://pixabay.com/de/vectors/smartphone-apfel-mobiltelefon-153650/");
        assertEquals("Handy", wordImage.getWord());
    }

    @Test
    @DisplayName("Test 2 - Null word paramter")
    void test2() {
        assertThrows(IllegalArgumentException.class, () -> {
            WordImage wordImage = new WordImage(null, "https://pixabay.com/de/vectors/smartphone-apfel-mobiltelefon-153650/"); }
        );
    }

    @Test
    @DisplayName("Test 3 - Empty word paramter")
    void test3() {
        assertThrows(IllegalArgumentException.class, () -> {
            WordImage wordImage = new WordImage("", "https://pixabay.com/de/vectors/smartphone-apfel-mobiltelefon-153650/");
        });
    }

    @Test
    @DisplayName("Test 4 - Null Url paramter")
    void test4() {
        assertThrows(IllegalArgumentException.class, () -> {
            WordImage wordImage = new WordImage("Handy", null);
        });
    }

    @Test
    @DisplayName("Test 5 - Empty url paramter")
    void test5() {
        assertThrows(IllegalArgumentException.class, () -> {
            WordImage wordImage = new WordImage("Handy", null);
        });
    }
}
