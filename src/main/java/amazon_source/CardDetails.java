package amazon_source;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CardDetails extends DDT
{
    public static WebDriver driver;
	
	//step 1
    @FindBy(xpath = "//input[@name='addCreditCardNumber']")
    WebElement card_number_tf;
    
    @FindBy(xpath = "//input[@name='ppw-accountHolderName']")
    WebElement name_tf;
    
    @FindBy(xpath = "//select[@name='ppw-expirationDate_month']")
    WebElement expiry_month;
    
    @FindBy(xpath = "//select[@name='ppw-expirationDate_month']")
    WebElement expiry_year;
    
    @FindBy(xpath = "//input[@name='ppw-widgetEvent:AddCreditCardEvent']")
    WebElement enter;
    
	@FindBy(name = "ApxSecureIframe")
	WebElement iframe;
	
	@FindBy(name = "apx-secure-field-addCreditCardVerificationNumber")
	WebElement iframe_cvv;
	
	@FindBy(xpath = "//input[@id='field']")
	WebElement cvv;
  
	//step 2
    public void iframe_switch(WebDriver driver)
	{
    	driver.switchTo().frame(iframe);
	}
    public void iframe_switch_cvv(WebDriver driver)
	{
    	driver.switchTo().frame(iframe_cvv);
	}
    public void cvv()
	{
		cvv.sendKeys(card_cvv);
	}
	public void cardNumber()
	{
		card_number_tf.sendKeys(card_number);;
	}
	
	public void name()
	{
		name_tf.sendKeys(card_name);;
	}
	
	public void expiryMonth()
	{
		Select s1 = new Select(expiry_month);
		s1.selectByIndex(5);
	}
	public void expiryYear()
	{
		Select s2 = new Select(expiry_year);
		s2.selectByIndex(1);
	}
	public void enterDetails()
	{
		enter.click();
	}
	public void switchtodefault(WebDriver driver)
	{
		driver.switchTo().defaultContent();
	}
		
	//step 3
	public CardDetails(WebDriver driver)
	{
	    PageFactory.initElements(driver, this);
	}

}
