package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

public class reviewsPage {
	
public static RemoteWebDriver driver=null;
	
	By addReviewButton=By.xpath("//*[@id='top-page']/div[1]/button");
	
	By getReviewerName=By.cssSelector("#top-page > div:nth-child(2) > div > div > div:nth-child(2) > div > div.card-review-new-detail > div.card-review-new-detail-row1 > div.card-review-new-userdet > div.card-review-new-username > a:nth-child(1)");
	By getReviewDesc=By.cssSelector("#top-page > div:nth-child(2) > div > div > div:nth-child(2) > div > div.card-review-new-detail > div.card-review-new-coment");
	By addProductDet=By.cssSelector("#top-page > div:nth-child(2) > div > div > div.jsx-3189481442.product-card-default > a > img");
	By getPage3=By.cssSelector("#top-page > div.jsx-2599477350.cover-pagination > div > div.jsx-557237353.paging-number > div.jsx-557237353.paging-list-number > a:nth-child(3) > span");
	By getPrevPage=By.cssSelector("#top-page > div.jsx-2599477350.cover-pagination > div > div.jsx-557237353.paging-number > a:nth-child(1)");
	By getNextPage3=By.cssSelector("#top-page > div.jsx-2599477350.cover-pagination > div > div.jsx-557237353.paging-number > a:nth-child(3)");
	By backToTop=By.cssSelector("#top-page > div.jsx-2599477350.cover-pagination > div > div.jsx-557237353.paging-totop > img");	
	
	By alwaysGetPopularLastProduct=By.xpath("//*[@id='top-page']/div[2]/div[2]/div[20]/div[1]");	
	By selectProduct=By.xpath("//*[@id='top-page']/div[2]/div[2]/div[20]/div[1]/div/button");	
	
	
	public reviewsPage(RemoteWebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
		
	}
	
	public WebElement clickAddReview(){
		
		return driver.findElement(addReviewButton);
	}
	
	public WebElement clickReviewerName(){
		
		return driver.findElement(getReviewerName);
	}
	
	public WebElement clickReviewDetail(){
		
		return driver.findElement(addProductDet);
	}
	
	public WebElement clickPage3(){
		
		return driver.findElement(getPage3);
	}
	
	public WebElement clickPrevPage(){
		
		return driver.findElement(getReviewDesc);
	}
	
	public WebElement clickNextPage(){
		
		return driver.findElement(getReviewDesc);
	}
	
	public WebElement clickToTop(){
		
		return driver.findElement(backToTop);
	}
	
	//write a reviews
	public WebElement LastPopularProd(){
		
		return driver.findElement(alwaysGetPopularLastProduct);
	}
	
	public WebElement clickSelectProduct(){
		
		return driver.findElement(selectProduct);
	}
	
	

}