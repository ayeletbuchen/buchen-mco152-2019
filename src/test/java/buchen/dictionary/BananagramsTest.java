package buchen.dictionary;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.internal.util.reflection.FieldSetter;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

class BananagramsTest {

    private final int NUM_LETTERS = 26;
    private final int FIRST_CHAR = 'A';

    @Test
    public void generateRandomUppercaseLetters() {
        // given
        Bananagrams bananagrams = new Bananagrams(NUM_LETTERS);
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
        Bananagrams bananagrams = new Bananagrams(NUM_LETTERS);

        // when
        bananagrams.setLettersForTest();
        String letters = bananagrams.getLetters();

        // then
        for (int i = 0; i < NUM_LETTERS; i++) {
            assertEquals((int) FIRST_CHAR + i, letters.charAt(i));
        }
    }

    @Test
    public void isPossibleWordTrue() {
        // given
        Bananagrams bananagrams = new Bananagrams(NUM_LETTERS);

        // when
        bananagrams.setLettersForTest();

        // then
        assertTrue(bananagrams.isPossibleWord("ABCDEFGHIJKLMNOPQRSTUVWXYZ"));
    }

    @Test
    public void isPossibleWordFalse() {
        // given
        Bananagrams bananagrams = new Bananagrams(NUM_LETTERS);

        // when
        bananagrams.setLettersForTest();

        // then
        assertFalse(bananagrams.isPossibleWord("ZOO"));
        assertFalse(bananagrams.isPossibleWord("AABCDEFGHIJKLMNOPQRSTUVWXYZ"));
    }

    @Test
    public void isPossibleWordUpperCase() {
        // given
        Bananagrams bananagrams = new Bananagrams(NUM_LETTERS);

        // when
        bananagrams.setLettersForTest();

        // then
        assertTrue(bananagrams.isPossibleWord("WONDERFUL"));
    }

    @Test
    public void isPossibleWordLowerCase() {
        // given
        Bananagrams bananagrams = new Bananagrams(NUM_LETTERS);

        // when
        bananagrams.setLettersForTest();

        // then
        assertTrue(bananagrams.isPossibleWord("abcdefghijklmnopqrstuvwxyz"));
    }

    @Test
    public void isPossibleWordMixedCase() {
        // given
        Bananagrams bananagrams = new Bananagrams(NUM_LETTERS);

        // when
        bananagrams.setLettersForTest();

        // then
        assertTrue(bananagrams.isPossibleWord("WoNdERfuL"));
    }

    @Test
    public void isPossibleWordEmptyString() {
        // given
        Bananagrams bananagrams = new Bananagrams(NUM_LETTERS);

        // when

        // then
        assertTrue(bananagrams.isPossibleWord(""));
    }

    @Test
    public void getPossibleWords() {
        // given
        Bananagrams bananagrams = new Bananagrams(NUM_LETTERS);

        Dictionary dictionary = mock(Dictionary.class);
        List<String> wordList = Arrays.asList("WONDER","GREAT","CAR","FAINT","ZOO");


        // when
        bananagrams.setLettersForTest();
        doReturn(wordList).when(dictionary).getList();
        List<String> possibleWords = bananagrams.getPossibleWords(dictionary);

        // then
        assertEquals(4, possibleWords.size());
        assertTrue(possibleWords.contains("WONDER"));
        assertTrue(possibleWords.contains("GREAT"));
        assertTrue(possibleWords.contains("CAR"));
        assertTrue(possibleWords.contains("FAINT"));
        assertFalse(possibleWords.contains("ZOO"));
    }
}