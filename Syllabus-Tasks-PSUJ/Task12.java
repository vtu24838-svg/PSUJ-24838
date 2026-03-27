package pst;
import java.util.*;

public class task12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();
        System.out.println(encrypt(s));

        sc.close();
    }

    public static String encrypt(String s) {
        StringBuilder result = new StringBuilder();

        int i = 0;
        int n = s.length();

        while (i < n) {
            char current = s.charAt(i);
            int count = 0;

            // Count consecutive characters
            while (i < n && s.charAt(i) == current) {
                count++;
                i++;
            }

            // Convert count to lowercase hexadecimal
            String hex = Integer.toHexString(count);

            // Append char + hex
            result.append(current).append(hex);
        }

        // Reverse final string
        return result.reverse().toString();
    }
}
