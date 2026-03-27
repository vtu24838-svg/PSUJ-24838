import java.util.*;

// Base class
class Payment {
    String processPayment(double amount) {
        return "";
    }
}

// Credit Card
class CreditCardPayment extends Payment {
    String processPayment(double amount) {
        double total = amount + (amount * 0.02);
        return String.format("Processed CreditCard payment: Total Amount = %.2f", total);
    }
}

// PayPal
class PayPalPayment extends Payment {
    String processPayment(double amount) {
        double total = amount + 1.50;
        return String.format("Processed PayPal payment: Total Amount = %.2f", total);
    }
}

// UPI
class UPIPayment extends Payment {
    String processPayment(double amount) {
        return String.format("Processed UPI payment: Total Amount = %.2f", amount);
    }
}

public class task15 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            char type = sc.next().charAt(0);
            double amount = sc.nextDouble();

            Payment p;

            if (type == 'C') p = new CreditCardPayment();
            else if (type == 'P') p = new PayPalPayment();
            else p = new UPIPayment();

            System.out.println(p.processPayment(amount));
        }
    }
}
