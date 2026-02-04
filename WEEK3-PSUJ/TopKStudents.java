import java.util.*;
import java.util.stream.*;

class Student {
    String name;
    int marks;

    Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }
}

public class TopKStudents {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        List<Student> students = new ArrayList<>();

        
        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().split(" ");
            String name = parts[0];
            int marks = Integer.parseInt(parts[1]);
            students.add(new Student(name, marks));
        }

        int k = sc.nextInt();

        
        List<String> topK = students.stream()
                .sorted((s1, s2) -> {
                    if (s2.marks != s1.marks)
                        return s2.marks - s1.marks; // descending marks
                    else
                        return s1.name.compareTo(s2.name); // ascending name
                })
                .limit(k)
                .map(s -> s.name)  // directly access field
                .collect(Collectors.toList());

        System.out.println(String.join(" ", topK));

        sc.close();
    }
}