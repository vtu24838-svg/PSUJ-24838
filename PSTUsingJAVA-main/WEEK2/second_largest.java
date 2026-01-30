
import java.util.*;

public class second_largest {

	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);

	        int n = sc.nextInt();
	        List<Integer> list = new ArrayList<>();

	        for (int i = 0; i < n; i++) {
	            list.add(sc.nextInt());
	        }

	        int secondHighest = list.stream()
	                .distinct()
	                .sorted((a,b)->b-a)
	                .skip(1)
	                .findFirst()
	                .orElse(-1);

	        System.out.println(secondHighest);
	    }

	}