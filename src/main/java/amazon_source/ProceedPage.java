package amazon_source;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProceedPage 
{
	public static WebDriver driver;
	
	//step 1
	@FindBy(xpath = "//span[@id='sw-gtc']")
	WebElement gotocart;
	
	@FindBy(xpath = "//div[@id='NATC_SMART_WAGON_CONF_MSG_SUCCESS']")
	WebElement addedtocart;
	
	
	//step 2
	public void gotoCart()
	{
		gotocart.click();
	}
	public void addedtocart()
	{
		addedtocart.isDisplayed();
	}
		
	//step 3
	public ProceedPage(WebDriver driver)
	{
	    PageFactory.initElements(driver, this);
	}

}
