package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

public class categoryPage {

	public String product = "product-8602";
	
	public RemoteWebDriver driver=null;
	
	By header=By.xpath("//*[@id='maincontent']/div[2]/div[2]/div/h2");
	By filter=By.cssSelector("a[href*='sign_in']");
	By category=By.xpath("//*[@id='maincontent']/div[2]/div[2]/div/h2");
	By sortrendah=By.cssSelector(".nav.navbar-nav.navbar-right>li>a");
	By sorttinggi=By.cssSelector(".nav.navbar-nav.navbar-right>li>a");
	By sortreset=By.cssSelector(".nav.navbar-nav.navbar-right>li>a");
	By productId=By.id(this.product);
	
	public categoryPage(RemoteWebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
		
	}
	
	public WebElement getHeaderCat(){
		
		return driver.findElement(header);
	}
	
	public WebElement clickFilter(){
		
		return driver.findElement(filter);
	}
	
	public WebElement clickCategory(){
		
		return driver.findElement(category);
	}
	
	//SORT
	public WebElement SortRendah(){
		
		return driver.findElement(sortrendah);
	}
	
	public WebElement SortTinggi(){
		
		return driver.findElement(sorttinggi);
	}
	
	public WebElement SortReset(){
		
		return driver.findElement(sortreset);
	}
	
	public WebElement catWishlist(){
		
		return driver.findElement(sortreset);
	}
	
	public WebElement clickProduct(){
		
		return driver.findElement(productId);
	}
	
}
