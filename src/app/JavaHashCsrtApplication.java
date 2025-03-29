package app;

import generator.JavaHashCsrtGenerator;
import model.JavaHashGeneratorItem;

public class JavaHashCsrtApplication {

	public static void main(String[] args) {

		Long idCsrt = JavaHashGeneratorItem.ID_CSRT_DEFAULT;
		String csrt = JavaHashGeneratorItem.CSRT_VALUE_DEFAULT;
		String keyAccess = JavaHashGeneratorItem.KEY_ACCESS_DEFAULT;

		JavaHashGeneratorItem parameters = JavaHashCsrtGenerator.createJavaHashGeneratorItem(idCsrt, csrt, keyAccess);
		System.out.println("Generating Hash CSRT...");

		if (parameters != null) {

			System.out.println("Hash CSRT generated success!");
			System.out.println("Result " + parameters.getHashCsrt());
		} else
			System.out.println("Fail to trying generate Hash CSRT.");
	}

}
