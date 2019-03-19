package buchen.bananagrams;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    private final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    @Test
    public void generateRandomUppercaseLetters() {
        // given
        Player player = new Player(ALPHABET.length());
        String letters = player.getLettersAsString();

        // when

        //then
        for (int i = 0; i < letters.length(); i++) {
            assertTrue(Character.isAlphabetic(letters.charAt(i)) && Character.isUpperCase(letters.charAt(i)));
        }
    }

    @Test
    public void setLettersForTest() {
        // given
        Player player = new Player(ALPHABET);
        String letters = player.getLettersAsString();

        // when

        // then
        for (int i = 0; i < ALPHABET.length(); i++) {
            assertEquals((int) ALPHABET.charAt(i), letters.charAt(i));
        }
    }

    @Test
    public void updatesLettersArrayProperly() {
        Player player = new Player(ALPHABET);
        int[] tiles = player.getLettersAsArray();
        for (int i = 0; i < tiles.length; i++) {
            assertEquals(1, tiles[i]);
        }
    }
}