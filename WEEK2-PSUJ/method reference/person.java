package method_ref;

public class person {
	String name;
	int age;
	person(String name,int age){
		this.name=name;
		this.age=age;
	}
	String getName() {
		return this.name;
	}
	static int compare(String a,String b) {
		return a.compareToIgnoreCase(b);
	}

}
