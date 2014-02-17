package euler;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Problem8 {
	public static void Main() throws IOException {
		int max = 0;
		File file = new File("Problem8.file");
		FileReader fr = new FileReader(file);
		char[] digits = new char[(int) file.length()];
		fr.read(digits);

		System.out.println("Problem 8: " + max);
	}

}
