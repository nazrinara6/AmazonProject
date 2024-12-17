package amazon_source;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ShoppingCartPage 
{
    public static WebDriver driver;
	
	//step 1
	@FindBy(xpath = "//span[@class='a-icon a-icon-small-add']")
	WebElement update_qty;
	
	@FindBy(xpath = "//button[@class='a-declarative'][1]")
	WebElement remove_qty;
	
	@FindBy(xpath = "//span[@id='sc-buy-box-ptc-button']")
	WebElement proceedtobuy;
	
	@FindBy(xpath = "//span[@class='sc-invisible-when-no-js sc-gift-option-container']")
	WebElement couponcode_gift;
	
	//step 2
	public void update() throws InterruptedException
	{
		update_qty.click();	
	}
	public void remove() throws InterruptedException
	{
		Thread.sleep(2000);
		remove_qty.click();
	}
	
	public void proceed()
	{
		proceedtobuy.click();
	}
	
	public void couponCode()
	{
		couponcode_gift.click();
	}
		
	//step 3
	public ShoppingCartPage(WebDriver driver)
	{
	    PageFactory.initElements(driver, this);
	}

}
