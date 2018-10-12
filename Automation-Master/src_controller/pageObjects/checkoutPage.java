package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

public class checkoutPage {

	
	public RemoteWebDriver driver;
	
	By emailId=By.id("customer-email");
	By password=By.id("customer-password");
	
	By addaddress=By.cssSelector("#address-form-modal");
	By firstname=By.cssSelector("input[name='firstname']");
	By lastname=By.cssSelector("input[name='lastname']");
	By address1=By.cssSelector("input[name='street[0]']");
	By address2=By.cssSelector("input[name='street[1]']");
	By regionId=By.cssSelector("select[name='region_id']");
	By telephone=By.cssSelector("input[name='telephone']");
	By discount=By.id("discount-code");
	By edd=By.cssSelector("#section-order-review > div.group-content.section-order-review > div.onestep-order-review > div.aw-sidebar-product-card > div.aw-sidebar-product-description-container > div.aw-sidebar-product-description.row > div.aw-sidebar-product-name.col-lg-4.col-12 > span:nth-child(3) > small > span:nth-child(2)");
	By section1=By.cssSelector("[id='user_email']");
	By section2=By.cssSelector("[type='password']");
	By section3=By.cssSelector("#btn-next-orderreview > div > button");
	By placeOrder=By.id("btn-place-order");
	By logGoogle=By.cssSelector("[type='password']");
	By logfacebook=By.cssSelector("[value='Log In']");
	
	By banktransfer=By.id("banktransfer");
	By snap=By.id("fabelio_snap");
	
	By orderId=By.cssSelector("#maincontent > div.columns > div > div.checkout-success.col-lg-12.col-md-12.col-12 > div > div.success-message-wrapper.col-lg-12.col-md-12.col-12 > label");
	
	
	public checkoutPage(RemoteWebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
		
	}

	//SECTION 1
	public WebElement emailId()
	{
		return driver.findElement(emailId);
	}
	
	public WebElement password()
	{
		return driver.findElement(password);
	}
	
	public WebElement nextSection1()
	{
		return driver.findElement(section1);
	}
	
	//SECTION 2
	public WebElement addAddress()
	{
		return driver.findElement(addaddress);
	}
	
	public WebElement firstname()
	{
		return driver.findElement(firstname);
	}
	
	public WebElement lastname()
	{
		return driver.findElement(lastname);
	}
	
	public WebElement address1()
	{
		return driver.findElement(address1);
	}
	
	public WebElement address2()
	{
		return driver.findElement(address2);
	}
	
	public WebElement regionId()
	{
		return driver.findElement(regionId);
	}
	
	public WebElement telephoneNo()
	{
		return driver.findElement(telephone);
	}
	
	public WebElement discountId()
	{
		return driver.findElement(discount);
	}
	
	public WebElement nextSection2()
	{
		return driver.findElement(section1);
	}
	
	public WebElement nextSection3()
	{
		return driver.findElement(section3);
	}
	
	public WebElement placeOrder()
	{
		return driver.findElement(placeOrder);
	}
	
	public WebElement loginGoogle()
	{
		return driver.findElement(logGoogle);
	}
	
	public WebElement LoginFacebook()
	{
		return driver.findElement(logfacebook);
	}
	
	public WebElement banktransfer()
	{
		return driver.findElement(banktransfer);
	}
	
	public WebElement snap()
	{
		return driver.findElement(snap);
	}
	
	//success page
	public WebElement getOrderId()
	{
		return driver.findElement(orderId);
	}
}
