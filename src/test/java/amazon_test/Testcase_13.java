package amazon_test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import amazon_source.DDT;
import amazon_source.HomePage;
import amazon_source.LoginPage;
import amazon_source.ProceedPage;
import amazon_source.ProductDetail;
import amazon_source.ShoppingCartPage;

public class Testcase_13 extends LaunchQuit
{

	@Test(retryAnalyzer = amazon_source.Retry_Analyzer.class)
	public void coupon_code() throws EncryptedDocumentException, IOException
	{
		DDT d1 = new DDT();
		d1.ddt_login();
		d1.ddt_search();
		
		HomePage h1 = new HomePage(driver);
		h1.aandl(driver);
		h1.signin();
		
		LoginPage l1 = new LoginPage(driver);
		l1.email();
		l1.continue_un();
		l1.pass();
		l1.sign_in_to_amazon();
		
		h1.search();
		
		ProductDetail p1 = new ProductDetail(driver);
		
	    p1.addItemstocart(driver);
	    
	    ProceedPage p2 = new ProceedPage(driver);
		p2.gotoCart();
	    
	    ShoppingCartPage s1 = new ShoppingCartPage(driver);
	    
	    s1.couponCode();
	    
	    try 
	    {
	    	WebElement giftMessage = driver.findElement(By.xpath("//span[@class='sc-invisible-when-no-js sc-gift-option-container']"));
	    	
	    	Assert.assertEquals(true, giftMessage.isDisplayed());
			
		} catch (Exception e) 
	    {
			System.out.println(e);
		}
		
	}

}
