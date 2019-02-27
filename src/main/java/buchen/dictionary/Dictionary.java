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
        return getReverse(word).equalsIgnoreCase(word);
    }

    private String getReverse(String word) {
        StringBuilder reversed = new StringBuilder();
        reversed.append(word);
        return reversed.reverse().toString();
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
