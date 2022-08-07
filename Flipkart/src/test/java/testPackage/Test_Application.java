package testPackage;

import org.testng.annotations.Test;

import basePackage.BaseClass;
import pagePackage.Page_Cart;
import pagePackage.Page_Home;
import pagePackage.Page_Result;

public class Test_Application extends BaseClass{
		
	
	
	
		@Test
		public void perfromAppTest()
		{
			
			String deviceName1 = "POCO C31";
			
			String deviceName2 = "Canon EOS 3000D DSLR Camera";
			
			
			Page_Home pg_Home = new Page_Home(driver,deviceName1);			
			pg_Home.perform_HomePageActivity();
			
			Page_Result pg_Result = new Page_Result(driver,deviceName1);
			pg_Result.perform_ResultPageActivity();
						
//			Page_Home pg_Home2 = new Page_Home(driver,deviceName2);			
//			pg_Home2.perform_HomePageActivity();
			
			Page_Result pg_Result2 = new Page_Result(driver,deviceName2);
			pg_Result2.search_ResultPage();
			pg_Result2.perform_ResultPageActivity();
			
			Page_Cart pg_Cart = new Page_Cart(driver,deviceName2);							
			pg_Cart.perform_cartPageActivity();
			
		}
	
	
	
	
}
