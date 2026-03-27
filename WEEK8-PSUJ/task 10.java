import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            // Read two integers
            int x = sc.nextInt();
            int y = sc.nextInt();
            
            // Perform division and print result
            System.out.println(x / y);
            
        } catch (InputMismatchException e) {
            // Catches non-integer inputs (e.g., "Hello" or "23.323")
            System.out.println(e.getClass().getName());
        } catch (ArithmeticException e) {
            // Catches division by zero
            System.out.println(e);
        } finally {
            sc.close();
        }
    }
}
