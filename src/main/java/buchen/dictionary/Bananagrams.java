package buchen.dictionary;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Bananagrams {

    private final int ALPHABET_SIZE;
    private final int NUM_LETTERS;
    private final char FIRST_CHAR;
    private int[] letters;
    private Random random;
    private StringBuilder string;

    public Bananagrams(int numLetters) {
        ALPHABET_SIZE = 26;
        NUM_LETTERS = numLetters;
        FIRST_CHAR = 'A';
        letters = new int[ALPHABET_SIZE];
        random = new Random();
        string = new StringBuilder();
        generateRandomLetters();
    }

    private void generateRandomLetters() {
        for (int i = 0; i < NUM_LETTERS; i++) {
            int index = random.nextInt(ALPHABET_SIZE);
            letters[index]++;
            string.append((char) (index + FIRST_CHAR));
        }
    }

    public String getLetters() {
        return string.toString();
    }

    public List<String> getPossibleWords(Dictionary dictionary) {
        ArrayList<String> possibleWords = new ArrayList<>();
        for (String word : dictionary.getList()) {
            if (word.length() <= NUM_LETTERS && isPossibleWord(word)) {
                possibleWords.add(word);
            }
        }
        return possibleWords;
    }

    public boolean isPossibleWord(String word) {
        int[] wordLetters = new int[letters.length];

        for (int i = 0; i < word.length(); i++) {
            int letter = (int) word.charAt(i) - FIRST_CHAR;
            wordLetters[letter]++;
            if (wordLetters[letter] > letters[letter]) {
                return false;
            }
        }
        return true;
    }
}
