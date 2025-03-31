package app;

import generator.JavaHashCsrtGenerator;
import model.JavaHashGeneratorItem;

public class JavaHashCsrtApplication {

	public static void main(String[] args) {

		Long idCsrt = JavaHashGeneratorItem.ID_CSRT_DEFAULT;
		String csrt = JavaHashGeneratorItem.CSRT_VALUE_DEFAULT;
		String keyAccess = JavaHashGeneratorItem.KEY_ACCESS_DEFAULT;

		JavaHashCsrtGenerator.createJavaHashGeneratorItem(idCsrt, csrt, keyAccess);

	}
}
