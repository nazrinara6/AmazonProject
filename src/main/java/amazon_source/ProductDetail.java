package amazon_source;

import static org.testng.Assert.assertEquals;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ProductDetail 
{
	public static WebDriver driver;
	//step 1	
		@FindBy(xpath = "//a[@class='a-link-normal s-no-outline']")
		WebElement selectShoe;
		
		@FindBy(xpath = "(//span[@class='a-price-whole'])[1]")//span[.='549']
		WebElement price;
		
		@FindBy(xpath = "//a[@class='a-popover-trigger a-declarative']")
		WebElement rating;
		
		@FindBy(xpath = "//div[@id='averageCustomerReviews']")
		WebElement customerReviews;
		
		@FindBy(xpath = "//h3[@class='a-spacing-medium a-spacing-top-large']")
		WebElement reviews;
		
		@FindBy(xpath = "//div[@id='productDescription_feature_div']")
		WebElement description;
		
		@FindBy(xpath = "//select[@name='s']")
		WebElement sort;
		
		@FindBy(xpath = "//div[@class='a-section aok-relative s-image-tall-aspect'][1]")
		WebElement add_Item;
		
		@FindBy(xpath = "//input[@id='add-to-cart-button']")
		WebElement add_to_cart;
		
		@FindBy(xpath = "//select[@name='quantity']")
		WebElement quantity;
		
		@FindBy(xpath = "//a[@class='a-size-base a-link-emphasis']")
		WebElement seecustomerreview;
		
	//step 2
		public void price(WebDriver driver)
		{
			selectShoe.click();
			Set<String> s1 = driver.getWindowHandles();
	  
	        Iterator<String> a1 = s1.iterator();
	        String parentid =a1.next();
	        String childid =a1.next();
	        
	        driver.switchTo().window(childid);	
	        boolean b3 = price.isDisplayed();
			System.out.println(b3);
		}
		
		public void review(WebDriver driver)
		{
			Set<String> s1 = driver.getWindowHandles();
			  
	        Iterator<String> a1 = s1.iterator();
	        String parentid =a1.next();
	        String childid =a1.next();
	        
	        driver.switchTo().window(childid);
			Actions a2 = new Actions(driver);
			a2.moveToElement(rating).perform();
			customerReviews.click();
			boolean b2 = reviews.isDisplayed();
			System.out.println(b2);
					
		}
		
		public void description(WebDriver driver)
		{	
	        assertEquals(price.isDisplayed(), true);
			Point p1= description.getLocation();
			int y = p1.getY();
	
			JavascriptExecutor j1 = (JavascriptExecutor) driver;
			j1.executeScript("window.scrollBy(0,"+y+")");
			boolean b1 = description.isDisplayed();
			System.out.println(b1);
			
		}
		
		public void sort_product_by_relevance() throws InterruptedException
		{
			Select s1 = new Select(sort);	
			Thread.sleep(1000);
			s1.selectByIndex(0);
			Thread.sleep(2000);
		}
		public void sort_product_by_price() throws InterruptedException
		{
			Select s1 = new Select(sort);	
			Thread.sleep(1000);
			s1.selectByIndex(2);
			Thread.sleep(2000);
		}
		
		public void sort_product_by_customer_review() throws InterruptedException
		{
			Select s1 = new Select(sort);	
			Thread.sleep(1000);
			s1.selectByIndex(3);
			Thread.sleep(2000);
				    
		}
		public void addItemstocart(WebDriver driver)
		{
			add_Item.click();
			Set<String> s1 = driver.getWindowHandles();
			  
	        Iterator<String> a1 = s1.iterator();
	        String parentid =a1.next();
	        String childid =a1.next();
	        
	        driver.switchTo().window(childid);
	        add_to_cart.click();
	       
		}
		public void addItems(WebDriver driver)
		{
			add_Item.click();
			Set<String> s1 = driver.getWindowHandles();
			  
	        Iterator<String> a1 = s1.iterator();
	        String parentid =a1.next();
	        String childid =a1.next();
	        
	        driver.switchTo().window(childid);
	       
		}
		public void qty_update() throws InterruptedException
		{
			Select s1 = new Select(quantity);
			s1.selectByIndex(1);
			Thread.sleep(2000);
		}
		public void qty_remove() throws InterruptedException
		{
			Select s1 = new Select(quantity);
			s1.selectByIndex(0);
			Thread.sleep(2000);
		}
		public void customerReview()
		{
			seecustomerreview.click();
		}
		
		//step 3
		public ProductDetail(WebDriver driver) 
		{
			PageFactory.initElements(driver, this);
		}
		

}
