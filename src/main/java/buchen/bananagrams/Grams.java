package buchen.bananagrams;

import buchen.dictionary.Dictionary;

import java.util.ArrayList;
import java.util.List;

public class Grams {

    private Dictionary dictionary;

    public Grams(Dictionary dictionary) {
        this.dictionary = dictionary;
    }

    /**
     *
     * @param tiles
     * @return a List of words in the Dictionary that are a subset of these letters
     */
    public List<String> getWords(String tiles) {
        // TODO this method is too long, break it up
        List<String> foundWords = new ArrayList<>();

        int[] tilesArray = new int[256];
        tiles = tiles.toUpperCase();
        for (char c : tiles.toCharArray()) {
            tilesArray[c]++;
        }

        for (String word : dictionary.getList()) {
            int wordArray[] = new int[256];
            boolean found = true;
            for (char c : word.toCharArray()) {
                wordArray[c]++;
                if (wordArray[c] > tilesArray[c]) {
                    found = false;
                }
            }
            if (found) {
                foundWords.add(word);
            }
        }

        return foundWords;
    }
}
