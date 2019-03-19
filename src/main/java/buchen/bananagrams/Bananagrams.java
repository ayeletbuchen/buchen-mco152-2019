package buchen.bananagrams;

import buchen.dictionary.Dictionary;

import java.util.ArrayList;
import java.util.List;

public class Bananagrams {

    private final Dictionary dictionary;

    public Bananagrams(Dictionary dictionary) {
        this.dictionary = dictionary;
    }

    /**
     *
     * @param player
     * @return a List of words in the Dictionary that are a subset of these letters
     */
    public List<String> getWords(Player player) {
        ArrayList<String> possibleWords = new ArrayList<>();
        for (String word : dictionary.getList()) {
            if (isPossibleWord(player, word)) {
                possibleWords.add(word);
            }
        }
        return possibleWords;
    }

    /**
     *
     * @param player
     * @param word
     * @return boolean value indicating whether or not the given word is possible for the given player
     */
    public boolean isPossibleWord(Player player, String word) {
        if (word.length() == 0) {
            return false;
        }
        int[] tiles = player.getLettersAsArray();
        int[] wordLetters = new int[tiles.length];
        char firstChar = player.FIRST_CHAR;
        word = word.toUpperCase();

        for (int i = 0; i < word.length(); i++) {
            int letter = (int) word.charAt(i) - firstChar;
            wordLetters[letter]++;
            if (wordLetters[letter] > tiles[letter]) {
                return false;
            }
        }
        return true;
    }
}
