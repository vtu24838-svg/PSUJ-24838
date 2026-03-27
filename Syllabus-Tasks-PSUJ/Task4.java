import java.util.*;
import java.time.*;

class Event {
    String name;
    LocalDate date;

    Event(String name, String date) {
        this.name = name;
        this.date = LocalDate.parse(date);
    }
}

public class task4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Event> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(new Event(sc.next(), sc.next()));
        }

        int month = sc.nextInt();

        // Sort
        list.sort(Comparator.comparing(e -> e.date));

        list.forEach(e -> System.out.print(e.name + " "));
        System.out.println();

        // Earliest
        System.out.println(list.get(0).name);

        // Latest
        System.out.println(list.get(list.size() - 1).name);

        // Filter by month
        list.stream()
            .filter(e -> e.date.getMonthValue() == month)
            .forEach(e -> System.out.print(e.name + " "));
    }
}
