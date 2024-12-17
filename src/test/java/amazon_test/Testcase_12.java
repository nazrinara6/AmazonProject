package amazon_test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import amazon_source.CheckoutPage;
import amazon_source.DDT;
import amazon_source.HomePage;
import amazon_source.LoginPage;
import amazon_source.ProceedPage;
import amazon_source.ProductDetail;
import amazon_source.ShoppingCartPage;

public class Testcase_12 extends LaunchQuit
{
	@Test(retryAnalyzer = amazon_source.Retry_Analyzer.class)
	public void payment_method() throws InterruptedException, EncryptedDocumentException, IOException
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
		s1.proceed();
		
		CheckoutPage c1 = new CheckoutPage(driver);
		//c1.change();
		//Thread.sleep(1000);
		c1.address_select();
		Thread.sleep(1000);
		c1.address_button();
		Thread.sleep(1000);
		
		c1.amazonPayment();
		Thread.sleep(3000);
		c1.visa();
		Thread.sleep(3000);
		c1.cardPay();
		Thread.sleep(3000);
		c1.netBanking();
	    Thread.sleep(3000);
		c1.otherUPI();
		Thread.sleep(3000);
		c1.emi();
		Thread.sleep(3000);
		c1.cash();	
		Thread.sleep(2000);
		
		try 
	    {
	    	WebElement paymentbutton = driver.findElement(By.xpath("(//span[@class='a-declarative'])[8]"));
	    	
	    	Assert.assertEquals(true, paymentbutton.isEnabled());
			
		} catch (Exception e) 
	    {
			System.out.println(e);
		}
	}

}
