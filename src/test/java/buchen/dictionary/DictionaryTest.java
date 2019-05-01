package buchen.dictionary;

import org.junit.jupiter.api.Test;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class DictionaryTest {

    @Test
    public void containsTrue() throws FileNotFoundException {
        // given
        Dictionary dictionary = new Dictionary("src/main/resources/dictionary.txt");

        // when
        // then
        assertTrue(dictionary.contains("WONDERFUL"));
    }

    @Test
    public void containsTrueLowerCase() throws FileNotFoundException {
        // given
        Dictionary dictionary = new Dictionary("src/main/resources/dictionary.txt");

        // when
        // then
        assertTrue(dictionary.contains("wonderful"));
    }

    @Test
    public void containsTrueMixedCase() throws FileNotFoundException {
        // given
        Dictionary dictionary = new Dictionary("src/main/resources/dictionary.txt");

        // when
        // then
        assertTrue(dictionary.contains("WOnDeRfUL"));
    }

    @Test
    public void containsFalse() throws FileNotFoundException {
        // given
        Dictionary dictionary = new Dictionary("src/main/resources/dictionary.txt");

        // when
        // then
        assertFalse(dictionary.contains("buchen"));
    }

    @Test
    public void correctSize() throws FileNotFoundException {
        // given
        Dictionary dictionary = new Dictionary("src/main/resources/dictionary.txt");
        int actualSize = 167964;

        // when
        // then
        assertEquals(actualSize, dictionary.size());
    }

    @Test
    public void isPalindromeTrueOdd() throws FileNotFoundException {
        // given
        Dictionary dictionary = new Dictionary("src/main/resources/dictionary.txt");

        // when
        // then
        assertTrue(dictionary.isPalindrome("racecar"));
    }

    @Test
    public void isPalindromeTrueEven() throws FileNotFoundException {
        // given
        Dictionary dictionary = new Dictionary("src/main/resources/dictionary.txt");

        // when
        // then
        assertTrue(dictionary.isPalindrome("toot"));
    }

    @Test
    public void isPalindromeTrueMixedCase() throws FileNotFoundException {
        // given
        Dictionary dictionary = new Dictionary("src/main/resources/dictionary.txt");

        // when
        // then
        assertTrue(dictionary.isPalindrome("racecar"));
    }

    @Test
    public void isPalindromeTrueUpperCase() throws FileNotFoundException {
        // given
        Dictionary dictionary = new Dictionary("src/main/resources/dictionary.txt");

        // when
        // then
        assertTrue(dictionary.isPalindrome("RACECAR"));
    }

    @Test
    public void isPalindromeFalse() throws FileNotFoundException {
        // given
        Dictionary dictionary = new Dictionary("src/main/resources/dictionary.txt");

        // when
        // then
        assertFalse(dictionary.isPalindrome("dictionary"));
    }

    @Test
    public void getPalindromesTestFile() throws FileNotFoundException {
        // given
        Dictionary testDictionary = new Dictionary("src/main/resources/dictionaryTest.txt");
        ArrayList<String> expectedPalindromes = new ArrayList<>();
        expectedPalindromes.add("dad");
        expectedPalindromes.add("mom");
        expectedPalindromes.add("racecar");
        expectedPalindromes.add("yay");

        List<String> palindromes = testDictionary.getPalindromes();

        // when
        // then
        assertEquals(expectedPalindromes.size(), palindromes.size());
        for (String word : expectedPalindromes) {
            assertTrue(palindromes.contains(word));
        }
    }
}