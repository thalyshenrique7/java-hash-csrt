package utils;

public class StringUtils {

	public static String concatenateStrings(String value1, String value2) {

		if (value1.isBlank() || value2.isBlank())
			return null;

		String result = value1.concat(value2);

		return result;
	}

}
