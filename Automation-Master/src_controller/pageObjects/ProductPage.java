package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ProductPage {

	
	public RemoteWebDriver driver=null;
	
	By lanjutkan=By.xpath("//*[@id='minicart-content-wrapper']/div[3]/a");
	By deliver=By.cssSelector("[id='user_email']");
	By incqty=By.cssSelector("[type='password']");
	By decqty=By.cssSelector("[value='Log In']");
	By beli=By.id("product-addtocart-button");
	By wishlist=By.cssSelector("[id='user_email']");
	By review=By.cssSelector("[type='password']");
	By question=By.cssSelector("[value='Log In']");
	
	
	
	
	public ProductPage(RemoteWebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
		
	}

	public WebElement clickcartnotif()
	{
		return driver.findElement(lanjutkan);
	}
	
	public WebElement selectDelivery()
	{
		return driver.findElement(deliver);
	}
	

	public WebElement incQty()
	{
		return driver.findElement(incqty);
	}
	

	public WebElement decQty()
	{
		return driver.findElement(decqty);
	}
	
	public WebElement clickbeli()
	{
		return driver.findElement(beli);
	}
	
	public WebElement prodWishlist(){
		
		return driver.findElement(wishlist);
	}
	
	public WebElement writeRewiew(){
		
		return driver.findElement(review);
	}
	
	public WebElement askQuestion(){
		
		return driver.findElement(question);
	}
	
}
