import java.util.*;

interface PerformOperation {
    boolean check(int a);
}

class MyMath {

    PerformOperation isOdd() {
        return a -> a % 2 != 0;
    }

    PerformOperation isPrime() {
        return a -> {
            if (a < 2) return false;
            for (int i = 2; i * i <= a; i++) {
                if (a % i == 0) return false;
            }
            return true;
        };
    }

    PerformOperation isPalindrome() {
        return a -> {
            int temp = a, rev = 0;
            while (temp > 0) {
                rev = rev * 10 + temp % 10;
                temp /= 10;
            }
            return rev == a;
        };
    }
}

public class task2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MyMath obj = new MyMath();

        int t = sc.nextInt();

        while (t-- > 0) {
            int ch = sc.nextInt();
            int num = sc.nextInt();

            PerformOperation op;

            if (ch == 1) {
                op = obj.isOdd();
                System.out.println(op.check(num) ? "ODD" : "EVEN");
            } else if (ch == 2) {
                op = obj.isPrime();
                System.out.println(op.check(num) ? "PRIME" : "COMPOSITE");
            } else {
                op = obj.isPalindrome();
                System.out.println(op.check(num) ? "PALINDROME" : "NOT PALINDROME");
            }
        }
    }
}
