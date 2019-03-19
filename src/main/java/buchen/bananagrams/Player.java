package buchen.bananagrams;

import java.util.Random;

public class Player {

    public static final int ALPHABET_SIZE = 26;
    public static final char FIRST_CHAR = 'A';
    private final Random RANDOM = new Random();
    private final int NUM_LETTERS;
    private int[] letters;
    private StringBuilder builder;

    public Player(int numLetters) {
        NUM_LETTERS = numLetters;
        construct();
        generateRandomLetters();
    }

    Player(String chosenLetters) { //ONLY TO BE USED FOR PURPOSES OF TESTING
        NUM_LETTERS = chosenLetters.length();
        construct();
        setLetters(chosenLetters);
    }

    private void construct() {
        letters = new int[ALPHABET_SIZE];
        builder = new StringBuilder();
    }

    private void generateRandomLetters() {
        for (int i = 0; i < NUM_LETTERS; i++) {
            int index = RANDOM.nextInt(ALPHABET_SIZE);
            updateInfo(index);
        }
    }

    private void setLetters(String chosenLetters) { //ONLY TO BE USED FOR PURPOSES OF TESTING
        chosenLetters = chosenLetters.toUpperCase();
        for (int i = 0; i < chosenLetters.length(); i++) {
            int index = (int) chosenLetters.charAt(i) - FIRST_CHAR;
            updateInfo(index);
        }
    }

    private void updateInfo(int index) {
        letters[index]++;
        builder.append((char) (index + FIRST_CHAR));
    }

    public String getLettersAsString() {
        return builder.toString();
    }

    public int[] getLettersAsArray() {
        return letters;
    }
}
