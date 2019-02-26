package buchen.dictionary;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Dictionary {
    private ArrayList<String> dictionary;
    private Scanner file;

    public Dictionary(String filePath) throws FileNotFoundException {
        file = new Scanner(new File(filePath));
        dictionary = new ArrayList<>();
        load();
        file.close();
    }

    private void load() {
        while (file.hasNext()) {
            dictionary.add(file.next());
            file.nextLine();
        }
    }

    public int size() {
        return dictionary.size();
    }

    public boolean contains(String word)
    {
        return dictionary.contains(word.toUpperCase());
    }

    public boolean isPalindrome(String word) {
        word = word.toUpperCase();
        for (int i = 0; i < word.length() / 2; i++) {
            int j = word.length() - 1 - i;
            if (word.charAt(i) != word.charAt(j) || word.charAt(i) == ' ') {
                return false;
            }
        }

        if (word.length() % 2 != 0) { // make sure this is only one word
            return word.charAt(word.length() / 2) != ' ';
        }

        return true;
    }

    public List<String> getPalindromes() {
        ArrayList<String> palindromes = new ArrayList<>();
        for (String word : dictionary) {
            if (isPalindrome(word)) {
                palindromes.add(word);
            }
        }
        return palindromes;
    }
}
