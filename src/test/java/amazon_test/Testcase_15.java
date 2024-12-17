package amazon_test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import amazon_source.DDT;
import amazon_source.HomePage;
import amazon_source.ProceedPage;
import amazon_source.ProductDetail;
import amazon_source.ShoppingCartPage;

public class Testcase_15 extends LaunchQuit
{
	@Test(retryAnalyzer = amazon_source.Retry_Analyzer.class)
	public void withoutLogin() throws EncryptedDocumentException, IOException, InterruptedException
	{
		DDT d1 = new DDT();
		d1.ddt_search();
		
		HomePage h1 = new HomePage(driver);
		h1.search();
		
		ProductDetail p1 = new ProductDetail(driver);
		p1.addItemstocart(driver);
		
		ProceedPage p2 = new ProceedPage(driver);
		p2.gotoCart();
		
		ShoppingCartPage s1 = new ShoppingCartPage(driver);
		s1.proceed();
		Thread.sleep(1000);
		Assert.assertEquals(driver.getTitle(), "Amazon Sign In");
		
	}

}
