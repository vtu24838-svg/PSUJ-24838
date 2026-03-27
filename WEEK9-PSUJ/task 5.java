import java.util.Scanner;

// Custom Exception for Stock issues
class InsufficientStockException extends Exception {
    public InsufficientStockException(String message) {
        super(message);
    }
}

class Order {
    int orderId;
    String productName;
    int quantity;
    int availableStock;

    public Order(int orderId, String productName, int quantity, int availableStock) {
        this.orderId = orderId;
        this.productName = productName;
        this.quantity = quantity;
        this.availableStock = availableStock;
    }

    // Method that uses exception-driven flow control
    public void processOrder() throws InsufficientStockException {
        if (quantity > availableStock) {
            throw new InsufficientStockException("Order " + orderId + " failed: Insufficient stock");
        }
        System.out.println("Order " + orderId + " processed successfully");
    }
}

public class STK {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        if (sc.hasNextInt()) {
            int n = sc.nextInt();

            for (int i = 0; i < n; i++) {
                int id = sc.nextInt();
                String name = sc.next();
                int qty = sc.nextInt();
                int stock = sc.nextInt();

                Order currentOrder = new Order(id, name, qty, stock);

                // Exception-driven flow control: handle failure and continue
                try {
                    currentOrder.processOrder();
                } catch (InsufficientStockException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        sc.close();
    }
}
