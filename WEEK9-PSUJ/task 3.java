import java.util.Scanner;

// Base Class
class Payment {
    public String processPayment(double amount) {
        return "Processed generic payment: Total Amount = " + String.format("%.2f", amount);
    }
}

// Subclass for Credit Card
class CreditCardPayment extends Payment {
    @Override
    public String processPayment(double amount) {
        double total = amount + (amount * 0.02); // 2% fee
        return "Processed CreditCard payment: Total Amount = " + String.format("%.2f", total);
    }
}

// Subclass for PayPal
class PayPalPayment extends Payment {
    @Override
    public String processPayment(double amount) {
        double total = amount + 1.50; // Flat $1.50 fee
        return "Processed PayPal payment: Total Amount = " + String.format("%.2f", total);
    }
}

// Subclass for UPI
class UPIPayment extends Payment {
    @Override
    public String processPayment(double amount) {
        // No extra fee
        return "Processed UPI payment: Total Amount = " + String.format("%.2f", amount);
    }
}

public class UPI {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double amount = sc.nextDouble();
            
            // Polymorphic Reference
            Payment payment;
            
            switch (type.toUpperCase()) {
                case "C":
                    payment = new CreditCardPayment();
                    break;
                case "P":
                    payment = new PayPalPayment();
                    break;
                case "U":
                    payment = new UPIPayment();
                    break;
                default:
                    payment = new Payment();
            }
            
            // Polymorphic call: The JVM decides which version to run at runtime
            System.out.println(payment.processPayment(amount));
        }
        sc.close();
    }
}
