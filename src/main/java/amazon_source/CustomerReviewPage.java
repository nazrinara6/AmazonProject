package amazon_source;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerReviewPage 
{
	public static WebDriver driver;
	
	//step 1
	@FindBy(xpath = "//a[.='Write a product review']")
	WebElement writereview;
	
	@FindBy(xpath = "(//button[@class='ryp__star__button'])[5]")
	WebElement fivestar;
	
	@FindBy(xpath = "//button[.='Submit']")
	WebElement submit;
	
	//step 2
	public void writeReview()
	{
		writereview.click();
	}
	
	public void fiveStar() throws InterruptedException
	{
		fivestar.click();
		Thread.sleep(2000);
	}
	
	public void submitButton()
	{
		submit.click();
	}
		
	//step 3
	public CustomerReviewPage(WebDriver driver)
	{
	    PageFactory.initElements(driver, this);
	}

}

