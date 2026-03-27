package pst;
import java.util.*;

// Interface
interface Notification {
    void sendNotification(String message);
}

class EmailNotification implements Notification {
    public void sendNotification(String message) {
        System.out.println("Sent Email notification: " + message);
    }
}

class SMSNotification implements Notification {
    public void sendNotification(String message) {
        System.out.println("Sent SMS notification: " + message);
    }
}

class PushNotification implements Notification {
    public void sendNotification(String message) {
        System.out.println("Sent Push notification: " + message);
    }
}

public class task16 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            char type = sc.next().charAt(0);
            String msg = sc.next();

            Notification n1;

            if (type == 'E') n1 = new EmailNotification();
            else if (type == 'S') n1 = new SMSNotification();
            else n1 = new PushNotification();

            n1.sendNotification(msg);
        }
    }
}
