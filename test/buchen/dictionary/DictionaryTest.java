package buchen.dictionary;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class DictionaryTest {

    @Test
    public void containsTrue() throws FileNotFoundException {
        // given
        Dictionary dictionary = new Dictionary("dictionary.txt");

        // when
        // then
        assertTrue(dictionary.contains("WONDERFUL"));
    }

    @Test
    public void containsTrueLowerCase() throws FileNotFoundException {
        // given
        Dictionary dictionary = new Dictionary("dictionary.txt");

        // when
        // then
        assertTrue(dictionary.contains("wonderful"));
    }

    @Test
    public void containsTrueMixedCase() throws FileNotFoundException {
        // given
        Dictionary dictionary = new Dictionary("dictionary.txt");

        // when
        // then
        assertTrue(dictionary.contains("WOnDeRfUL"));
    }

    @Test
    public void containsFalse() throws FileNotFoundException {
        // given
        Dictionary dictionary = new Dictionary("dictionary.txt");

        // when
        // then
        assertFalse(dictionary.contains("buchen"));
    }
}