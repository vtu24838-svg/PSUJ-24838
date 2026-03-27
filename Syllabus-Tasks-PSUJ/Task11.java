package pst;
import java.util.*;

public class task11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input N and K
        int N = sc.nextInt();
        int K = sc.nextInt();

        int count = 0;

        // Read N numbers
        for (int i = 0; i < N; i++) {
            int Ai = sc.nextInt();

            if (Ai % K == 0) {
                count++;
            }
        }

        // Output result
        System.out.println(count);

        sc.close();
    }
}
