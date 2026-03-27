import java.util.*;

class Record {
    String category, item;
    int amount;

    Record(String c, String i, int a) {
        category = c;
        item = i;
        amount = a;
    }
}

public class task6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Record> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(new Record(sc.next(), sc.next(), sc.nextInt()));
        }

        LinkedHashMap<String, List<Record>> map = new LinkedHashMap<>();

        for (Record r : list) {
            map.putIfAbsent(r.category, new ArrayList<>());
            map.get(r.category).add(r);
        }

        for (String cat : map.keySet()) {
            List<Record> recs = map.get(cat);

            int total = recs.stream().mapToInt(r -> r.amount).sum();

            Record max = recs.stream()
                    .max(Comparator.comparing(r -> r.amount))
                    .get();

            System.out.println(cat + " " + total + " " + max.item);
        }
    }
}
