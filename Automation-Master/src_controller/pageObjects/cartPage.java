package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

public class cartPage {

	
	public RemoteWebDriver driver=null;
	
	By section1=By.cssSelector("[id='user_email']");
	By section2=By.cssSelector("[type='password']");
	By section3=By.cssSelector("[value='Log In']");
	By placeOrder=By.cssSelector("[id='user_email']");
	By lanjutkan=By.xpath("//*[@id='maincontent']/div[2]/div/div[4]/ul/li/button");
	
	
	
	
	public cartPage(RemoteWebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
		
	}




	public WebElement incQty()
	{
		return driver.findElement(section1);
	}
	

	public WebElement decQty()
	{
		return driver.findElement(section1);
	}
	
	public WebElement hapusTroli()
	{
		return driver.findElement(section3);
	}
	
	public WebElement clickTrash()
	{
		return driver.findElement(placeOrder);
	}
	
	public WebElement lanjutkanCart()
	{
		return driver.findElement(lanjutkan);
	}
	
}
