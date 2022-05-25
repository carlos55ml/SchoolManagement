package c.log;

import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;    

public class Log {
	private static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd--HH:mm:ss"); 
	private static LocalDateTime now;
	
	public static void debug(String s) {
		now = LocalDateTime.now(); 
		System.out.println("[DEBUG - "+dtf.format(now)+"]: "+s);
	}
	
	public static void warn(String s) {
		now = LocalDateTime.now(); 
		System.out.println("[WARN - "+dtf.format(now)+"]: "+s);
	}
	public static void error(String s) {
		now = LocalDateTime.now(); 
		System.out.println("[ERROR - "+dtf.format(now)+"]: "+s);
	}
}
