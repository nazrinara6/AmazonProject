package amazon_test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import amazon_source.DDT;
import amazon_source.HomePage;

public class Testcase_01 extends LaunchQuit
{
	@Test(retryAnalyzer = amazon_source.Retry_Analyzer.class)
	public void signup_to_amazon() throws InterruptedException, EncryptedDocumentException, IOException
	{
		DDT d1 = new DDT();
		d1.ddt_signup();
		
		HomePage h1 = new HomePage(driver);
		h1.aandl(driver);
		h1.signup();
		h1.name();
		h1.mobile();
		h1.pwd();
		h1.verify();	
		
	    try 
	    {
	    	WebElement errorMessageBox = driver.findElement(By.xpath("//div[@id='auth-error-message-box']"));
	    	
	    	Assert.assertEquals(true, errorMessageBox.isDisplayed());
			
		}
	    catch (Exception e) 
	    {
			System.out.println(e);
		}
	}

}
