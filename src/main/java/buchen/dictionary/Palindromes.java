package buchen.dictionary;

import java.util.ArrayList;
import java.util.List;

public class Palindromes {

    public boolean isPalindrome(String word) {
        return getReverse(word).equalsIgnoreCase(word);
    }

    private String getReverse(String word) {
        return new StringBuilder(word).reverse().toString();
    }

    public List<String> getPalindromes(Dictionary dictionary) {
        ArrayList<String> palindromes = new ArrayList<>();
        for (String word : dictionary.getList()) {
            if (isPalindrome(word)) {
                palindromes.add(word);
            }
        }
        return palindromes;
    }
}
