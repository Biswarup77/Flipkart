package pagePackage;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Page_Home {
		
		public WebDriver driver;		
		public WebDriverWait wait;
		
		private String deviceNameLocal;
		
		@FindBy(xpath="//a[contains(text(),'New to Flipkart? Create an account')]")
		private WebElement createAccountLink;
			
		@FindBy(xpath="//button[contains(text(),'✕')]")
		private WebElement removeLoginPopUp;
				
		@FindBy(xpath="//input[contains(@title,'Search for products, brands and more')]")
		private WebElement searchBar;
		
		@FindBy(xpath="//button[contains(@type,'submit')]")
		private WebElement submitButton;
		
		
		
		
		public Page_Home(WebDriver driver, String deviceName)
		{
			
			this.driver = driver;
			PageFactory.initElements(driver, this);
			
			wait = new WebDriverWait(driver,Duration.ofSeconds(20));
			
			this.deviceNameLocal = deviceName;
			
		}
		
		
	
		public void perform_HomePageActivity()
		{
			
			
			if(createAccountLink.isDisplayed()==true)
			{
				
				wait.until(ExpectedConditions.elementToBeClickable(removeLoginPopUp)).click();
				
				System.out.println("Check");
				
			}
			
			
			wait.until(ExpectedConditions.visibilityOf(searchBar)).sendKeys(deviceNameLocal);
			
			
			wait.until(ExpectedConditions.elementToBeClickable(submitButton)).click();
			
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	
}
