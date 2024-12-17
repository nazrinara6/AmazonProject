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
import amazon_source.ProductDetail;

public class Testcase_07 extends LaunchQuit
{

	@Test(retryAnalyzer = amazon_source.Retry_Analyzer.class)
	public void product_description() throws EncryptedDocumentException, IOException
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
		p1.price(driver);
		p1.review(driver);
		p1.description(driver);	
		
		try 
	    {
	    	WebElement description = driver.findElement(By.xpath("//div[@id='productDescription_feature_div']"));
	    	
	    	Assert.assertEquals(true, description.isDisplayed());
			
		} catch (Exception e) 
	    {
			System.out.println(e);
		}
		
	}

}
