package shinobi;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Date {

	static void dateTime() {
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter df;
		df = DateTimeFormatter.ofPattern("dd.MM.yyyy kk:mm:ss");
		System.out.println("---Time--- :" + now.format(df));

	}

}
