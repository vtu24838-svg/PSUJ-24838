import java.util.Scanner;

// The Interface - defines the contract
interface Notification {
    void sendNotification(String message);
}

// Implementation for Email
class EmailNotification implements Notification {
    @Override
    public void sendNotification(String message) {
        System.out.println("Sent Email notification: " + message);
    }
}

// Implementation for SMS
class SMSNotification implements Notification {
    @Override
    public void sendNotification(String message) {
        System.out.println("Sent SMS notification: " + message);
    }
}

// Implementation for Push Notifications
class PushNotification implements Notification {
    @Override
    public void sendNotification(String message) {
        System.out.println("Sent Push notification: " + message);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Read the number of notifications
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String message = sc.next();
            
            // Interface Reference
            Notification notification = null;
            
            // Selecting the implementation based on input
            switch (type.toUpperCase()) {
                case "E":
                    notification = new EmailNotification();
                    break;
                case "S":
                    notification = new SMSNotification();
                    break;
                case "P":
                    notification = new PushNotification();
                    break;
            }
            
            // Polymorphic call
            if (notification != null) {
                notification.sendNotification(message);
            }
        }
        sc.close();
    }
}
