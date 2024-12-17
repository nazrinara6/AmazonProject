package amazon_test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import amazon_source.CardDetails;
import amazon_source.CheckoutPage;
import amazon_source.DDT;
import amazon_source.HomePage;
import amazon_source.LoginPage;
import amazon_source.ProceedPage;
import amazon_source.ProductDetail;
import amazon_source.ShoppingCartPage;

public class Testcase_11 extends LaunchQuit
{
	@Test(retryAnalyzer = amazon_source.Retry_Analyzer.class)
	public void checkout_process() throws InterruptedException, EncryptedDocumentException, IOException
	{
		DDT d1 = new DDT();
		d1.ddt_login();
		d1.ddt_search();
		d1.ddt_cardInfo();
		
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
		s1.proceed();
		
		CheckoutPage c1 = new CheckoutPage(driver);
		c1.address_select();
		c1.address_button();
	//	c1.save_gift();
		c1.cardPayment();
		
		CardDetails c2 = new CardDetails(driver);
		
		c2.iframe_switch_cvv(driver);
		
	/*	//card details
	  
	    c2.iframe_switch(driver);
		
		c2.cardNumber();
		c2.name();
		c2.expiryMonth();
		c2.expiryYear();
		c2.enterDetails();
		
		c2.switchtodefault(driver); 
    */
		
		c2.cvv();
		Thread.sleep(1000);
		c2.switchtodefault(driver);
		
		c1.use_thisPaymentMethod();
		Thread.sleep(2000);
	//    c1.orderReview();
		
	//	c1.place_order_and_pay();
			
		try 
	    {
	    	WebElement paymentbutton = driver.findElement(By.xpath("(//input[@class='a-button-input a-button-text'])[3]"));
	    	
	    	Assert.assertEquals(true, paymentbutton.isEnabled());
			
		} catch (Exception e) 
	    {
			System.out.println(e);
		}
		
	}
	

}
