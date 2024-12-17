package amazon_test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import amazon_source.DDT;
import amazon_source.HomePage;
import amazon_source.LoginPage;

public class Testcase_05 extends LaunchQuit
{
	@Test(retryAnalyzer = amazon_source.Retry_Analyzer.class)
	public void searching_products() throws EncryptedDocumentException, IOException 
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

		Assert.assertEquals(driver.getTitle(), "Amazon.in : Shoes");
	}

}
