package generator;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Base64;

import logger.Logger;
import model.JavaHashGeneratorItem;
import utils.StringUtils;

public class JavaHashCsrtGenerator {

	private static final String SHA_1 = "SHA-1";
	private static final Logger logger = Logger.getInstance();

	public static JavaHashGeneratorItem createJavaHashGeneratorItem(Long idCsrt, String csrt, String keyAccess) {

		JavaHashGeneratorItem javaHashGeneratorItem = new JavaHashGeneratorItem();
		javaHashGeneratorItem.setIdCsrt(idCsrt);
		javaHashGeneratorItem.setCsrt(csrt);
		javaHashGeneratorItem.setKeyAccess(keyAccess);

		logger.info("Generating Hash CSRT...");

		String hashCsrtGenerated = generateHashCsrt(csrt, keyAccess);
		javaHashGeneratorItem.setHashCsrt(hashCsrtGenerated);

		if (hashCsrtGenerated != null && !hashCsrtGenerated.isBlank()) {

			logger.info("Hash CSRT generated successfully");
			logger.info("Result " + javaHashGeneratorItem.getHashCsrt());
		} else
			logger.error("Fail to trying generate Hash CSRT.");

		return javaHashGeneratorItem;
	}

	private static String generateHashCsrt(String csrt, String keyAccess) {

		String csrtKeyAccessConcatenated = StringUtils.concatenateStrings(csrt, keyAccess);

		String sha1Hash = null;
		MessageDigest messageDigest = null;
		try {

			messageDigest = MessageDigest.getInstance(SHA_1);
			messageDigest.reset();
			messageDigest.update(csrtKeyAccessConcatenated.getBytes("utf8"));
			sha1Hash = String.format("%040x", new BigInteger(1, messageDigest.digest()));
		} catch (Exception e) {
			e.getStackTrace();
			e.getCause();
		}

		byte[] sha1ConvertedToBase64Bytes = hexadecimalStringToByteArray(sha1Hash);
		String sha1ConvertedToBase64 = Base64.getEncoder().encodeToString(sha1ConvertedToBase64Bytes);

		String result = sha1ConvertedToBase64;

		return result;
	}

	private static byte[] hexadecimalStringToByteArray(String hexValue) {

		int length = hexValue.length();
		byte[] data = new byte[length / 2];

		for (int i = 0; i < length; i += 2) {
			data[i / 2] = (byte) ((Character.digit(hexValue.charAt(i), 16) << 4)
					+ Character.digit(hexValue.charAt(i + 1), 16));
		}

		return data;
	}

}
