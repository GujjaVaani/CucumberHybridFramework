package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ConfigReader {

	public Properties intializeProperties() {
		
	Properties prop = new Properties();
	File propfile = new File(System.getProperty("user.dir")+"\\src\\test\\resources\\config\\config.properties");
	try {
		FileInputStream fis= new FileInputStream(propfile);
		prop.load(fis);
	} catch (Throwable e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return prop;
		
		
	}	
}
