package buchen.dictionary;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Bananagrams {

    private final int ALPHABET_SIZE = 26;
    private final char FIRST_CHAR = 'A';
    private final Random RANDOM = new Random();
    private final int NUM_LETTERS;
    private final Dictionary DICTIONARY;
    private int[] letters;
    private StringBuilder builder;

    public Bananagrams(int numLetters, Dictionary dictionary) {
        NUM_LETTERS = numLetters;
        DICTIONARY = dictionary;
        letters = new int[ALPHABET_SIZE];
        builder = new StringBuilder();
        generateRandomLetters();
    }

    public Bananagrams(int numLetters, Dictionary dictionary, String chosenLetters) {
        NUM_LETTERS = numLetters;
        DICTIONARY = dictionary;
        letters = new int[ALPHABET_SIZE];
        builder = new StringBuilder();
        chosenLetters = chosenLetters.toUpperCase();
        for (int i = 0; i < chosenLetters.length(); i++) {
            int index = (int) chosenLetters.charAt(i) - FIRST_CHAR;
            letters[index]++;
            updateString(index);
        }
    }

    void setLetters(String chosenLetters) { //ONLY TO BE USED FOR PURPOSES OF TESTING
        builder.delete(0, builder.length());
        chosenLetters = chosenLetters.toUpperCase();
        letters = new int[ALPHABET_SIZE];
        for (int i = 0; i < chosenLetters.length(); i++) {
            int index = (int) chosenLetters.charAt(i) - FIRST_CHAR;
            letters[index]++;
            updateString(index);
        }
    }

    private void generateRandomLetters() {
        for (int i = 0; i < NUM_LETTERS; i++) {
            int index = RANDOM.nextInt(ALPHABET_SIZE);
            letters[index]++;
            updateString(index);
        }
    }

    private void updateString(int index) {
        builder.append((char) (index + FIRST_CHAR));
    }

    public String getLetters() {
        return builder.toString();
    }

    /**
     *
     * @return a List of words in the Dictionary that are a subset of these letters
     */
    public List<String> getWords() {
        ArrayList<String> possibleWords = new ArrayList<>();
        for (String word : DICTIONARY.getList()) {
            if (word.length() <= NUM_LETTERS && isPossibleWord(word)) {
                possibleWords.add(word);
            }
        }
        return possibleWords;
    }

    public boolean isPossibleWord(String word) {
        word = word.toUpperCase();
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
