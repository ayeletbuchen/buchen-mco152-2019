package buchen.dictionary;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

class BananagramsTest {

    private final int NUM_LETTERS = 26;
    private final int FIRST_CHAR = 'A';
    private final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    Dictionary dictionary = new Dictionary("dictionary.txt");

    BananagramsTest() throws FileNotFoundException {
    }

    @Test
    public void generateRandomUppercaseLetters() {
        // given
        Bananagrams bananagrams = new Bananagrams(NUM_LETTERS, dictionary);
        String letters = bananagrams.getLetters();

        // when

        //then
        for (int i = 0; i < letters.length(); i++) {
            assertTrue(Character.isAlphabetic(letters.charAt(i)) && Character.isUpperCase(letters.charAt(i)));
        }
    }

    @Test
    public void setLettersForTest() {
        // given
        Bananagrams bananagrams = new Bananagrams(NUM_LETTERS, dictionary);

        // when
        bananagrams.setLetters(ALPHABET);
        String letters = bananagrams.getLetters();

        // then
        for (int i = 0; i < ALPHABET.length(); i++) {
            assertEquals((int) ALPHABET.charAt(i), letters.charAt(i));
        }
    }

    @Test
    public void isPossibleWordTrue() {
        // given
        Bananagrams bananagrams = new Bananagrams(NUM_LETTERS, dictionary);

        // when
        bananagrams.setLetters(ALPHABET);

        // then
        assertTrue(bananagrams.isPossibleWord("ABCDEFGHIJKLMNOPQRSTUVWXYZ"));
    }

    @Test
    public void isPossibleWordFalse() {
        // given
        Bananagrams bananagrams = new Bananagrams(NUM_LETTERS, dictionary);

        // when
        bananagrams.setLetters(ALPHABET);

        // then
        assertFalse(bananagrams.isPossibleWord("ZOO"));
        assertFalse(bananagrams.isPossibleWord("AABCDEFGHIJKLMNOPQRSTUVWXYZ"));
    }

    @Test
    public void isPossibleWordUpperCase() {
        // given
        Bananagrams bananagrams = new Bananagrams(NUM_LETTERS, dictionary);

        // when
        bananagrams.setLetters("ABCDEFGHIJKLMNOPQRSTUVWXYZ");

        // then
        assertTrue(bananagrams.isPossibleWord("WONDERFUL"));
    }

    @Test
    public void isPossibleWordLowerCase() {
        // given
        Bananagrams bananagrams = new Bananagrams(NUM_LETTERS, dictionary);

        // when
        bananagrams.setLetters("ABCDEFGHIJKLMNOPQRSTUVWXYZ");

        // then
        assertTrue(bananagrams.isPossibleWord("abcdefghijklmnopqrstuvwxyz"));
    }

    @Test
    public void isPossibleWordMixedCase() {
        // given
        Bananagrams bananagrams = new Bananagrams(NUM_LETTERS, dictionary);

        // when
        bananagrams.setLetters("ABCDEFGHIJKLMNOPQRSTUVWXYZ");

        // then
        assertTrue(bananagrams.isPossibleWord("WoNdERfuL"));
    }

    @Test
    public void isPossibleWordEmptyString() {
        // given
        Bananagrams bananagrams = new Bananagrams(NUM_LETTERS, dictionary);

        // when

        // then
        assertTrue(bananagrams.isPossibleWord(""));
    }

    @Test
    public void getPossibleWords() {
        // given
        Dictionary words = mock(Dictionary.class);
        List<String> wordList = Arrays.asList("WONDER","GREAT","CAR","FAINT","ZOO","b", "beautiful");
        doReturn(wordList).when(words).getList();
        Bananagrams bananagrams = new Bananagrams(NUM_LETTERS, words);


        // when
        bananagrams.setLetters(ALPHABET);
        List<String> possibleWords = bananagrams.getWords();

        // then
        assertEquals(5, possibleWords.size());
        assertTrue(possibleWords.contains("WONDER"));
        assertTrue(possibleWords.contains("GREAT"));
        assertTrue(possibleWords.contains("CAR"));
        assertTrue(possibleWords.contains("FAINT"));
        assertFalse(possibleWords.contains("ZOO"));
    }
}