package amazon_test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import amazon_source.CustomerReviewPage;
import amazon_source.DDT;
import amazon_source.HomePage;
import amazon_source.LoginPage;
import amazon_source.ProductDetail;

public class Testcase_14 extends LaunchQuit
{
	@Test(retryAnalyzer = amazon_source.Retry_Analyzer.class)
	public void ratings() throws InterruptedException, EncryptedDocumentException, IOException
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
		Thread.sleep(2000);
		
		ProductDetail p1 = new ProductDetail(driver);
		p1.addItems(driver);
		p1.review(driver);
		p1.customerReview();
		
		CustomerReviewPage c3 = new CustomerReviewPage(driver);
		c3.writeReview();
		Thread.sleep(2000);
		c3.fiveStar();
		c3.submitButton();
		
		Assert.assertEquals(driver.getTitle(), "Review Your Purchases");
	}

}
