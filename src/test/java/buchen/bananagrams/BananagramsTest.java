package buchen.bananagrams;

import buchen.dictionary.Dictionary;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BananagramsTest {


    Dictionary dictionary;
    Player player;
    final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    Bananagrams bananagrams;

    @BeforeEach
    public void setUpMock() {
        dictionary = mock(Dictionary.class);
        List<String> wordList = Arrays.asList("WONDER","GREAT", "CAR", "FAINT", "ZOO", "b", "beautiful");
        doReturn(wordList).when(dictionary).getList();

        player = mock(Player.class);
        int[] tiles = new int[ALPHABET.length()];
        for (int i = 0; i < tiles.length; i++) {
            tiles[i] = 1;
        }
        doReturn(tiles).when(player).getLettersAsArray();
        bananagrams = new Bananagrams(dictionary);
    }


    @Test
    public void isPossibleWordTrue() {
        // given

        // when

        // then
        assertTrue(bananagrams.isPossibleWord(player, ALPHABET));
    }

    @Test
    public void isPossibleWordFalse() {
        // given

        // when

        // then
        assertFalse(bananagrams.isPossibleWord(player,"ZOO"));
        assertFalse(bananagrams.isPossibleWord(player,"A" + ALPHABET));
    }

    @Test
    public void isPossibleWordUpperCase() {
        // given

        // when

        // then
        assertTrue(bananagrams.isPossibleWord(player, "WONDERFUL"));
    }

    @Test
    public void isPossibleWordLowerCase() {
        // given

        // when

        // then
        assertTrue(bananagrams.isPossibleWord(player, ALPHABET.toLowerCase()));
    }

    @Test
    public void isPossibleWordMixedCase() {
        // given

        // when

        // then
        assertTrue(bananagrams.isPossibleWord(player, "WoNdERfuL"));
    }

    @Test
    public void isPossibleWordEmptyStringFalse() {
        // given

        // when

        // then
        assertFalse(bananagrams.isPossibleWord(player,""));
    }

    @Test
    public void getPossibleWords() {
        // given
        List<String> possibleWords = bananagrams.getWords(player);

        // when

        // then
        assertEquals(5, possibleWords.size());
        assertTrue(possibleWords.contains("WONDER"));
        assertTrue(possibleWords.contains("GREAT"));
        assertTrue(possibleWords.contains("CAR"));
        assertTrue(possibleWords.contains("FAINT"));
        assertTrue(possibleWords.contains("b"));
        assertFalse(possibleWords.contains("beautiful"));
        assertFalse(possibleWords.contains("ZOO"));
    }

    @Test
    public void getWords_HELEN() throws FileNotFoundException {
        // given
        Dictionary dict = new Dictionary("dictionary.txt");
        Bananagrams grams = new Bananagrams(dict);
        int[] helen = new int[ALPHABET.length()];
        helen[7] = 1;   // h
        helen[4] = 2;   // two e's
        helen[11] = 1;  // l
        helen[13] = 1;  // n

        // when
        doReturn(helen).when(player).getLettersAsArray();
        List<String> words = grams.getWords(player);

        // then
        assertEquals(10, words.size());
        // TODO add more asserts
    }

    @Test
    public void getWords() {
        // given
        doReturn(Arrays.asList("CAB", "EEL", "CMA")).when(dictionary).getList();
        Bananagrams grams = new Bananagrams(dictionary);
        int[] abcde = new int[ALPHABET.length()];
        abcde[0] = 1; // a
        abcde[1] = 1; // b
        abcde[2] = 1; // c
        abcde[3] = 1; // d
        abcde[4] = 1; // e

        // when
        doReturn(abcde).when(player).getLettersAsArray();
        List<String> words = grams.getWords(player);

        // then
        assertEquals(1, words.size());
        assertEquals("CAB", words.get(0));
        verify(dictionary).getList();
    }
}