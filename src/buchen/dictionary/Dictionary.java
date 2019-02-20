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

    }

    public List<String> getPalindromes() {

    }
}
