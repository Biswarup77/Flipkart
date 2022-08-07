package basePackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	public FileInputStream fis;
	public Properties prop;
	
	public ConfigReader()
	{
		
		
		try {
			fis = new FileInputStream(".\\config.Property");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		prop = new Properties();
		try {
			prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	public String getKeyVal_ConfigReader(String key)
	{
		
		return prop.getProperty(key);
		
		
	}
	
	
	
}
