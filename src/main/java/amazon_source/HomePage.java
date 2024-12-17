package amazon_source;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends DDT
{
	public static WebDriver driver;
	
	//step 1	
	@FindBy(xpath = "//div[@class='nav-line-1-container']")
	WebElement accountAndlist;
	
	@FindBy(xpath = "//a[.='Start here.']")
	WebElement startHere;
	
	@FindBy(id = "ap_customer_name")
	WebElement yourName;
	
	@FindBy(name = "email")
	WebElement mobileNumber;
	
	@FindBy(name = "password")
	WebElement password;
	
	@FindBy(id = "continue")
	WebElement verifyNumber;
	
	@FindBy(xpath = "(//span[.='Sign in'][1])")
	WebElement signIn;
	
	@FindBy(xpath = "//span[.='Your Account']")
	WebElement yourAccount;
	
	@FindBy(id = "twotabsearchtextbox")
	WebElement search_tf;
	
	@FindBy(xpath = "(//div[@class='a-section a-spacing-mini sf-range-slider-row'])[2]")
	WebElement price_range;
	
	@FindBy(xpath = "//span[@id='a-autoid-84']")
	WebElement go;
	
	@FindBy(xpath = "//span[.='Mens Stride RunnerRunning Shoe']")
	WebElement coordinate_forCategory;
	
	@FindBy(xpath = "//li[@id='n/9780816031']")
	WebElement category;
	
	//step 2
	public void aandl(WebDriver driver)
	{
		Actions a1 = new Actions(driver);
		a1.moveToElement(accountAndlist).perform();
	}
	public void signup() throws InterruptedException
	{
		startHere.click();
		Thread.sleep(2000);
	}
	public void name() throws InterruptedException
	{
		yourName.sendKeys(your_name);
		Thread.sleep(2000);
	}
	public void mobile() throws InterruptedException
	{
		mobileNumber.sendKeys(mobile);
		Thread.sleep(2000);
	}
	public void pwd() throws InterruptedException
	{
		password.sendKeys(password_signup);
		Thread.sleep(2000);
	}
	public void verify()
	{
		verifyNumber.click();
	}
	public void signin()
	{
		signIn.click();
	}
	public void your_account()
	{
		yourAccount.click();
	}
	public void search()
	{
		search_tf.sendKeys(searchItem + Keys.ENTER);
	}
	public void search2()
	{
		search_tf.sendKeys(searchItem2 + Keys.ENTER);
	}
	public void price_range(WebDriver driver) throws AWTException, InterruptedException
	{
		Actions a1 = new Actions(driver);
		a1.contextClick(price_range);
		Robot r1 = new Robot();
		for (int i=0;i<=30;i++)
		{
		    r1.keyPress(KeyEvent.VK_LEFT);
		    Thread.sleep(500);
		}
		go.click();
		
	}
	public void category(WebDriver driver) throws InterruptedException
	{
		Point p1= coordinate_forCategory.getLocation();
		int y = p1.getY();
		Thread.sleep(2000);
		
		JavascriptExecutor j1 = (JavascriptExecutor) driver;
		j1.executeScript("window.scrollBy(0,"+y+")");
	
		
		category.click();
	}
	//step 3
	
	public HomePage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
}
