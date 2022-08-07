package basePackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass {
	
	
		public WebDriver driver;
	
		@BeforeClass
		public WebDriver initializeDriver()
		{
			
			
			ConfigReader cd = new ConfigReader();
			String browser = cd.getKeyVal_ConfigReader("Browser");
			String url = cd.getKeyVal_ConfigReader("URL");
			
			if(browser.equalsIgnoreCase("Firefox"))
			{
				
				System.setProperty("webdriver.gecko.driver", ".\\Driver\\geckodriver.exe");
				driver = new FirefoxDriver();
				
				driver.manage().window().maximize();
				driver.get(url);
								
			}
			return driver;
			
		}
		
//		@AfterClass
//		public void closeApplication()
//		{
//			
//			driver.close();
//			driver.quit();
//			
//		}
	
	

}
