package buchen.bananagrams;

import buchen.dictionary.Dictionary;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class GramsTest {

    @Test
    public void getWords_HELEN() throws FileNotFoundException {
        // given
        Dictionary dictionary = new Dictionary("dictionary.txt");
        Grams grams = new Grams(dictionary);

        // when
        List<String> words = grams.getWords("HELEN");

        // then
        assertEquals(10, words.size());
        // TODO add more asserts
    }

    @Test
    public void getWords() {
        // given
        Dictionary dictionary = mock(Dictionary.class);
        doReturn(Arrays.asList("CAB", "EEL", "CMA")).when(dictionary).getList();
        Grams grams = new Grams(dictionary);

        // when
        List<String> words = grams.getWords("ABCDE");

        // then
        assertEquals(1, words.size());
        assertEquals("CAB", words.get(0));
        verify(dictionary).getList();
    }
}