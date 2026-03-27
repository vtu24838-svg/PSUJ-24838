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

public class task5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Student> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(new Student(sc.next(), sc.nextInt()));
        }

        int k = sc.nextInt();

        list.stream()
            .sorted((a, b) -> {
                if (b.marks != a.marks)
                    return b.marks - a.marks;
                return a.name.compareTo(b.name);
            })
            .limit(k)
            .map(s -> s.name)
            .forEach(name -> System.out.print(name + " "));
    }
}
