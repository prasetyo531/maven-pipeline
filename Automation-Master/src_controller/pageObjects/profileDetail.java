package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

public class profileDetail {
	
public static RemoteWebDriver driver=null;
	
	By catBalm=By.cssSelector("#top-page > div.jsx-2784532334.ctg-cover > div.jsx-2784532334.ctg-left > div.jsx-17482050.filter-category-desktop > a:nth-child(3)");
	By getFollower=By.cssSelector("#top-page > div > div.jsx-1832169295.proftop-cover > div.jsx-1832169295.proftop > div.jsx-1832169295.proftop-col > div.jsx-1832169295.proftop-row2 > div.jsx-1832169295.proftop-detail > a:nth-child(1) > span.jsx-1832169295.proftop-number");
	By getFollowing=By.cssSelector("#top-page > div > div.jsx-1832169295.proftop-cover > div.jsx-1832169295.proftop > div.jsx-1832169295.proftop-col > div.jsx-1832169295.proftop-row2 > div.jsx-1832169295.proftop-detail > a:nth-child(2) > span.jsx-1832169295.proftop-number");
	By tabReviews=By.cssSelector("#top-tab > div > a:nth-child(2)");
	By qtyReviews=By.cssSelector("#top-page > div > div.jsx-4143613589.tabcontent-mobile > div > h3");
	By tabPost=By.cssSelector("#top-tab > div > a:nth-child(1)");
	
	
	public profileDetail(RemoteWebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
		
	}
	
	public WebElement clicskFootCream(){
		
		return driver.findElement(catBalm);
	}
	
	public WebElement countFollower(){
		
		return driver.findElement(getFollower);
	}
	
	public WebElement countFollowing(){
		
		return driver.findElement(getFollowing);
	}
	
	public WebElement clickTabReviews(){
		
		return driver.findElement(tabReviews);
	}
	
	public WebElement countReviews(){
		
		return driver.findElement(qtyReviews);
	}
	
	public WebElement clickTabPost(){
		
		return driver.findElement(tabPost);
	}

}
