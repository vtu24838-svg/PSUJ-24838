import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

 public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        String [] pair_left = new String[t];
        String [] pair_right = new String[t];
        
        for (int i = 0; i < t; i++) {
            pair_left[i] = s.next();
            pair_right[i] = s.next();
        }
// Write your code here
HashSet<String> set = new HashSet<>(t);
for (int i = 0; i < t; i++) {
    // Adding a unique separator and trimming inputs to avoid hidden space issues
    set.add(pair_left[i].trim() + " " + pair_right[i].trim());
    System.out.println(set.size());
}

    }
}
