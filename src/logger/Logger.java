package logger;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {

	private static volatile Logger instance;
	private static final Object lock = new Object();
	private static final String INFO = "INFO";
	private static final String ERROR = "ERROR";

	private Logger() {
	}

	public static Logger getInstance() {

		if (instance == null)
			synchronized (lock) {
				return new Logger();
			}

		return instance;
	}

	public void log(String level, String message) {

		String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		String log = String.format(" [ %s ] [ %s ] [ %s ] ", timestamp, level, message);

		System.out.println(log);
	}

	public void info(String message) {
		log(INFO, message);
	}

	public void error(String message) {
		log(ERROR, message);
	}

}
