package pagePackage;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Page_Result {
	
	public WebDriver driver;		
	public WebDriverWait wait;
	
	private String deviceNameLocal;
	
	
	//Change Test2
	
//	@FindBy(xpath="(//div[contains(text(),'"+deviceNameLocal+"')])[1]")
//	private WebElement mobileLinkResultPage;
	
//	@FindBy(xpath="//span[contains(text(),'POCO C31')]")
//	private WebElement mobileNameProductPage;
	
	//@FindBy(xpath="(//ul[@class='row']//button)[1]")
	
	@FindBy(xpath="//button[text()='Add to Cart']")	
	private WebElement buttonAddtoCart;
	
	@FindBy(xpath="//input[contains(@title,'Search for products, brands and more')]")
	private WebElement searchBar_ReultPage;
	
	@FindBy(xpath="//button[contains(@type,'submit')]")
	private WebElement submitButton_ReultPage;
	
	@FindBy(xpath="//span[contains(text(),'Place Order')]")
	private WebElement placeOrder_Button;
	
	
	public Page_Result(WebDriver driver, String deviceName)
	{
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
		wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		
		deviceNameLocal = deviceName;
	}
	
	

	public void perform_ResultPageActivity()
	{
		
		//wait.until(ExpectedConditions.elementToBeClickable(mobileLinkResultPage)).click();
		
		
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("(//div[contains(text(),'"+deviceNameLocal+"')])[1]")))).click();          
		
		Set<String>	win_Handler =driver.getWindowHandles();
		
		Iterator<String> it_Str = win_Handler.iterator();
		
		String paret_WH = it_Str.next();
		String child_WH = it_Str.next();
		
		driver.switchTo().window(child_WH);
		
		wait.until(ExpectedConditions.elementToBeClickable(buttonAddtoCart));
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		if(driver.findElement(By.xpath("//span[contains(text(),'"+deviceNameLocal+"')]")).isDisplayed()==true)
		{
			
			buttonAddtoCart.click();
			
			
			wait.until(ExpectedConditions.elementToBeClickable(placeOrder_Button));
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		driver.close();
		
		driver.switchTo().window(paret_WH);
		
		driver.navigate().refresh();	
		
		//driver.navigate().back();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	public void search_ResultPage()
	{
		
		searchBar_ReultPage.clear();
		searchBar_ReultPage.sendKeys(deviceNameLocal);
		
		submitButton_ReultPage.click();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	

}
