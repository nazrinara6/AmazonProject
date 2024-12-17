package amazon_test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import amazon_source.DDT;
import amazon_source.HomePage;
import amazon_source.LoginPage;


public class Testcase_03 extends LaunchQuit
{
	@Test(retryAnalyzer = amazon_source.Retry_Analyzer.class)
	public void login_with_incorrect_un_pwd() throws InterruptedException, EncryptedDocumentException, IOException
	{
		DDT d1 = new DDT();
		d1.ddt_login();
		HomePage h1 = new HomePage(driver);
		h1.aandl(driver);
		h1.signin();
		LoginPage l1 = new LoginPage(driver);
		l1.email();
		l1.continue_un();
		l1.pass_incorrect();
		l1.sign_in_to_amazon();
		
		Assert.assertEquals(driver.getTitle(), "Amazon Sign In");
	}

}
