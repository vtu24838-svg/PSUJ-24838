import java.util.*;
import java.lang.*;
import java.io.*;

class W5_S1_T2 { //Task2:https://www.codechef.com/problems/LAPIN
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            String str = sc.next();
            int n = str.length();
            int mid = n / 2;

            String left = str.substring(0, mid);
            String right;

            if (n % 2 == 0)
                right = str.substring(mid);
            else
                right = str.substring(mid + 1);

            int[] freq = new int[26];

            for (char c : left.toCharArray())
                freq[c - 'a']++;

            for (char c : right.toCharArray())
                freq[c - 'a']--;

            boolean ok = true;

            for (int f : freq) {
                if (f != 0) {
                    ok = false;
                    break;
                }
            }

            System.out.println(ok ? "YES" : "NO");
        }

        sc.close();
    }
}

