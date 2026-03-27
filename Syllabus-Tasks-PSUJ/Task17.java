import java.util.*;

class InsufficientStockException extends Exception {
    InsufficientStockException(String msg) {
        super(msg);
    }
}

public class task17 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int id = sc.nextInt();
            String product = sc.next();
            int quantity = sc.nextInt();
            int stock = sc.nextInt();

            try {
                if (quantity > stock) {
                    throw new InsufficientStockException("Insufficient stock");
                }
                System.out.println("Order " + id + " processed successfully");
            } catch (Exception e) {
                System.out.println("Order " + id + " failed: " + e.getMessage());
            }
        }
    }
}
