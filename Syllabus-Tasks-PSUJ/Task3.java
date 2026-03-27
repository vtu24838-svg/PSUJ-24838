import java.util.*;
import java.util.stream.*;

class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    static boolean isOlder(Person p, int limit) {
        return p.age > limit;
    }
}

public class task3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Person> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(new Person(sc.next(), sc.nextInt()));
        }

        int ageLimit = sc.nextInt();

        // Sorted names
        list.stream()
            .map(p -> p.name)
            .sorted()
            .forEach(name -> System.out.print(name + " "));
        System.out.println();

        // Filter older
        list.stream()
            .filter(p -> Person.isOlder(p, ageLimit))
            .map(p -> p.name)
            .forEach(name -> System.out.print(name + " "));
        System.out.println();

        // Uppercase
        list.stream()
            .map(p -> p.name)
            .map(String::toUpperCase)
            .forEach(name -> System.out.print(name + " "));
    }
}
