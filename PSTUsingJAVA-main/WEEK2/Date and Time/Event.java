package dateTime;
import java.time.*;
import java.time.temporal.ChronoUnit;
public class Event {
	String name;
	LocalDate d;
	Event(String name,LocalDate d){
		this.name=name;
		this.d=d;
	}
	static int compare(Event d1,Event d2) {
		return (int)ChronoUnit.DAYS.between(d2.d, d1.d);
	}

}
