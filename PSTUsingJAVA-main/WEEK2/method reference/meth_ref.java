package method_ref;
import java.util.*;
public class meth_ref {
	public static void main(String[] args) {
		List<person> persons =new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		int n =sc.nextInt();
		for(int i=0;i<n;i++) {
			String name =sc.next();
			int age =sc.nextInt();
			persons.add(new person(name,age));
		}
		int ageLimit = sc.nextInt();
		persons.stream().map(person::getName).sorted(person::compare).forEach(name->System.out.print(name+" "));
		System.out.println();
		persons.stream().filter(p->p.age>ageLimit).map(person::getName).forEach(name->System.out.print(name+" "));
		System.out.println();
		persons.stream().map(person::getName).map(String::toUpperCase).forEach(name->System.out.print(name+" "));
		sc.close();
		
	}

}
