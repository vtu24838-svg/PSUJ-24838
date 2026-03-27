package pst;
import java.util.*;

public class task10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input text and pattern
        String text = sc.next();
        String pattern = sc.next();

        int result = countAnagrams(text, pattern);
        System.out.println(result);
    }

    public static int countAnagrams(String text, String pattern) {
        int[] freq = new int[26];

        // Store pattern frequency
        for (char c : pattern.toCharArray()) {
            freq[c - 'a']++;
        }

        int k = pattern.length();
        int count = 0;
        int result = 0;

        // Count distinct characters in pattern
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) count++;
        }

        int i = 0, j = 0;

        while (j < text.length()) {

            // Include current character
            char ch = text.charAt(j);
            freq[ch - 'a']--;

            if (freq[ch - 'a'] == 0) {
                count--;
            }

            // Window size < k
            if (j - i + 1 < k) {
                j++;
            }
            // Window size == k
            else if (j - i + 1 == k) {

                // Check if anagram found
                if (count == 0) {
                    result++;
                }

                // Remove left character
                char left = text.charAt(i);
                freq[left - 'a']++;

                if (freq[left - 'a'] == 1) {
                    count++;
                }

                i++;
                j++;
            }
        }

        return result;
    }
}
