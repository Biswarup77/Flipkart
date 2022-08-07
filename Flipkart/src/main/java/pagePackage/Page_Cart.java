package pagePackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Page_Cart {
	
	
	
	public WebDriver driver;		
	public WebDriverWait wait;
	
	private String deviceNameLocal;
	
	
	@FindBy(xpath="//span[contains(text(),'Cart')]")
	private WebElement cart_Button;
	
	
	@FindBy(xpath="//span[contains(text(),'Place Order')]")
	private WebElement placeOrder_Button;
	
	
	@FindBy(xpath="//div[contains(text(),'Cancel')]/following-sibling::div[contains(text(),'Remove')]")
	private WebElement removePopUp_Button;
	
	
	
	
	
	public Page_Cart(WebDriver driver, String deviceName)
	{
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
		wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		
		deviceNameLocal = deviceName;
	}
	
	

	public void perform_cartPageActivity()
	{
		
		
		wait.until(ExpectedConditions.elementToBeClickable(cart_Button)).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(placeOrder_Button));
		
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		driver.findElement(By.xpath("(//a[contains(text(),'"+deviceNameLocal+"')]/following::div[contains(text(),'Remove')])[1]")).click();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		wait.until(ExpectedConditions.elementToBeClickable(removePopUp_Button)).click();
		
		
	}
	
	
	
	
	

}
