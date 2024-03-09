package reusableComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Utilities {
	
	static String strFileName = "config.properties";
	
	public static String getProperty() throws InterruptedException, FileNotFoundException {
		Thread.sleep(10);
		File f = new File(strFileName);
		if (f.exists()) {
			FileInputStream in = new FileInputStream(f);
			
		}
		return strFileName;

	}

}
