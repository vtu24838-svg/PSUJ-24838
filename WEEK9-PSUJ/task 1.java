import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

class EntityRecord {
    int enrollmentId;
    String student;
    String course;
    String instructor;
    String startDate;
    int duration;

    // Constructor to initialize the record
    public EntityRecord(int id, String student, String course, String instructor, String date, int duration) {
        this.enrollmentId = id;
        this.student = student;
        this.course = course;
        this.instructor = instructor;
        this.startDate = date;
        this.duration = duration;
    }

    // Method to display the record in the required format
    public void display() {
        System.out.println("Enrollment_ID: " + enrollmentId + 
                           ", Student: " + student + 
                           ", Course: " + course + 
                           ", Instructor: " + instructor + 
                           ", Start Date: " + startDate + 
                           ", Duration: " + duration + " weeks");
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<EntityRecord> records = new ArrayList<>();

        // Read the number of records
        if (sc.hasNextInt()) {
            int n = sc.nextInt();

            // Read each record's details
            for (int i = 0; i < n; i++) {
                int id = sc.nextInt();
                String student = sc.next();
                String course = sc.next();
                String instructor = sc.next();
                String date = sc.next();
                int duration = sc.nextInt();

                records.add(new EntityRecord(id, student, course, instructor, date, duration));
            }

            // Display all stored records
            for (EntityRecord record : records) {
                record.display();
            }
        }
        sc.close();
    }
}
