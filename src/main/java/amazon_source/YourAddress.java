package amazon_source;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.ui.Select;


public class YourAddress extends DDT 
{
	public static WebDriver driver;
	
	@FindBy(xpath = "(//select[@class='a-native-dropdown a-spacing-none a-declarative'])[1]")
	WebElement country;
	//select[@class='a-native-dropdown a-spacing-none a-declarative']
	@FindBy(xpath = "//input[@id='address-ui-widgets-enterAddressFullName']")
	WebElement name;
	
	@FindBy(xpath = "//input[@id='address-ui-widgets-enterAddressCity']")
	WebElement city;
	
	@FindBy(xpath = "//input[@id='address-ui-widgets-enterAddressLine1']")
	WebElement streetnumber;
	
	@FindBy(xpath = "//input[@id='address-ui-widgets-enterAddressStateOrRegion']")
	WebElement state;
	
	@FindBy(xpath = "//input[@id='address-ui-widgets-enterAddressPhoneNumber']")
	WebElement mobile;
	
	@FindBy(xpath = "//input[@id='address-ui-widgets-enterAddressPostalCode']")
	WebElement pin;
	
	@FindBy(xpath = "//input[@name='address-ui-widgets-enterAddressPhoneNumber']")
	WebElement phoneNumber;
	
	@FindBy(xpath = "(//span[@class='a-button-inner'])[9]")
	WebElement addAddress;
	
	//step 2 
	public void country() throws InterruptedException
	{
		Select s1 = new Select(country);
		s1.selectByIndex(18);
		Thread.sleep(2000);
	}
	public void name()
	{
		name.sendKeys(your_name2);	
	}
	public void city_name()
	{
		city.sendKeys(city_name);	
	}
	public void mobile()
	{
		mobile.sendKeys(mobile2);	
	}
	public void sn()
	{
		streetnumber.sendKeys(street_name);	
	}
	public void state()
	{
		state.sendKeys(street_name);	
	}
	public void pin()
	{
		pin.sendKeys(pinCode);	
	}
	
	public void phone()
	{
		phoneNumber.sendKeys(mobile2);	
	}
	
	public void addAddress_button()
	{
		addAddress.click();	
	}
		
	//step 3
	public YourAddress(WebDriver driver) 
	{
	
		PageFactory.initElements(driver, this);
	}

}
