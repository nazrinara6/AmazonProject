package amazon_source;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage extends DDT
{
    public static WebDriver driver;
	
	//step 1
    @FindBy(xpath = "//div[@class='a-column a-span4 a-text-right a-spacing-base a-span-last']")
	WebElement change;
    
	@FindBy(xpath = "//input[@name='submissionURL'][1]")
	WebElement address_select;
	
	@FindBy(xpath = "//span[@id='shipToThisAddressButton']")
	WebElement use_this_address_button;
	
	@FindBy(xpath = "//span[@class='pmts-instrument-selector']")
	WebElement credit_or_debit_card_option;
	
	@FindBy(xpath = "(//span[@class='pmts-instrument-selector'])[2]")
	WebElement cardPay;
			
	@FindBy(xpath = "(//span[@class='pmts-instrument-selector'])[1]")
	WebElement visaCard;
	
	@FindBy(xpath = "(//span[@id='apx-add-credit-card-action-test-id'])[1]")
    WebElement enter_card_details;
	
	@FindBy(xpath = "//span[@class='pmts-instrument-selector pmts-apb-radio-button']")
	WebElement amazon_payment;
	
	@FindBy(xpath = "//div[@class='a-radio a-spacing-top-mini']")
	WebElement net_banking;
	
	@FindBy(xpath = "(//div[@class='a-radio'])[3]")
	WebElement other_upi_apps;
	
	@FindBy(xpath = "(//div[@class='a-fixed-left-grid-col a-col-left'])[13]")
	WebElement emi;
	
	@FindBy(xpath = "(//div[@class='a-radio'])[4]")
	WebElement cash_on_delivery;
	
	@FindBy(xpath = "//input[@id='field']")
	WebElement cvv;
	
	@FindBy(xpath = "(//input[@class='a-button-input a-button-text'])[3]")
	WebElement use_this_payment;
	
	@FindBy(xpath = "//input[@id='setOrderingPrefsCheckbox']")
	WebElement order_review;
	
	@FindBy(xpath = "(//input[@name='placeYourOrder1'])[1]")
	WebElement placeorderandpay;
	
	@FindBy(xpath = "(//div[@class='a-box-inner'])[2]")
	WebElement saveGift;
	
	//step 2
	public void change()
	{
		change.click();
	}
	public void address_select()
	{
		address_select.click();
	}
	public void address_button()
	{
		use_this_address_button.click();
	}
	public void visa() throws InterruptedException
	{
		visaCard.click();
		//credit_or_debit_card_option.click();
		//Thread.sleep(2000);
        //enter_card_details.click();     		
	}
	public void amazonPayment()
	{
		amazon_payment.click();
	}
	public void cardPay()
	{
		cardPay.click();
	}
	public void cardPayment()
	{
		credit_or_debit_card_option.click();
	}
	public void netBanking()
	{
		net_banking.click();
	}
	public void otherUPI()
	{
		other_upi_apps.click();
	}	
	public void emi()
	{
		emi.click();
	}	
	public void cash()
	{
		cash_on_delivery.click();
	}
	
	public void cvv()
	{
		cvv.sendKeys(card_cvv);
	}
	
	public void use_thisPaymentMethod()
	{
		use_this_payment.click();
	}
	
	public void orderReview()
	{
		order_review.click();
	}
	public void place_order_and_pay()
	{
		placeorderandpay.click();
	}
	public void save_gift()
	{
		saveGift.click();
	}
	//step 3
	public CheckoutPage(WebDriver driver)
	{
	    PageFactory.initElements(driver, this);
	}

}
