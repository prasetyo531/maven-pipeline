package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

public class brandPage {
	
	public RemoteWebDriver driver=null;

	By topProductNivea=By.xpath("//*[@id='__next']/div/div/div[3]/div[3]/div[3]/img");
	By sortBrand=By.xpath("//*[@id='__next']/div/div/div[3]/div[5]/div[1]/div/button");
	By mostReview=By.xpath("//*[@id='__next']/div/div/div[3]/div[5]/div[1]/div/div/a[1]");
	By logoHome=By.xpath("//*[@id='__next']/div/div/div[1]/a");
	
	By firstProduct=By.xpath("//*[@id='__next']/div/div/div[3]/div[3]/div/div/div[2]/div[1]/div/h1/a");
	////*[@id="__next"]/div/div/div[3]/div[3]/div/div/div[2]/div[1]/div/h1/a
	By sortBrandList=By.xpath("//*[@id='__next']/div/div/div[3]/div[3]/div/div/div[1]/div[2]/button");
	
	//matching query
	By getTextbrandmosproductfromA=By.xpath("//*[@id='__next']/div/div/div[3]/div[6]/div/div[1]/div[1]/a");
	By gettextbrandmostreviewFromA=By.xpath("//*[@id='__next']/div/div/div[3]/div[6]/div/div[1]/div[1]/a");
	
	By chooseNewestSort=By.xpath("//*[@id='__next']/div/div/div[3]/div[3]/div/div/div[1]/div[2]/div/a[2]");
	

	
	public brandPage(RemoteWebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
		
	}	

	public WebElement clickSortBrand(){
		
		return driver.findElement(sortBrand);
	}	
	
	public WebElement clickChooseMostReview(){
		
		return driver.findElement(mostReview);
	}
	
	public WebElement clickNivea(){
		
		return driver.findElement(topProductNivea);
	}
	
	public WebElement clicksortBrandList(){
		
		return driver.findElement(sortBrandList);
	}
	
	public WebElement clickLogoHome(){
		
		return driver.findElement(logoHome);
	}
	
	public WebElement chooseNewestSort(){
		
		return driver.findElement(chooseNewestSort);
	}
	
	
	//vaidasi sql
	public WebElement getTextBrandMosProductFromA(){
		
		return driver.findElement(getTextbrandmosproductfromA);
	}
	
	public WebElement getTextBrandMosReviewFromA(){
		
		return driver.findElement(gettextbrandmostreviewFromA);
	}
	
	public WebElement getAlwaysFirstProduct(){
		
		return driver.findElement(firstProduct);
	}
	
	//getAlwaysFirstProductNewest
	public WebElement getAlwaysFirstProductNewest(){
		
		return driver.findElement(firstProduct);
	}
	
	
}