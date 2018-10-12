package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

public class productlist {

	
public static RemoteWebDriver driver=null;
	
	By catBalm=By.cssSelector("#top-page > div.jsx-2784532334.ctg-cover > div.jsx-2784532334.ctg-left > div.jsx-17482050.filter-category-desktop > a:nth-child(3)");
	By catFootCream=By.cssSelector("#top-page > div.jsx-2784532334.ctg-cover > div.jsx-2784532334.ctg-left > div.jsx-17482050.filter-category-desktop > a:nth-child(3)");
	By brand100pure=By.cssSelector("#top-page > div.jsx-2784532334.ctg-cover > div.jsx-2784532334.ctg-left > div.jsx-727148539.filter-brand-desktop > div.jsx-727148539.scroll-menu > a:nth-child(1)");
	By akin=By.cssSelector("#top-page > div.jsx-2784532334.ctg-cover > div.jsx-2784532334.ctg-left > div.jsx-727148539.filter-brand-desktop > div.jsx-727148539.scroll-menu > a");
	By searchbrand=By.cssSelector("#top-page > div.jsx-2784532334.ctg-cover > div.jsx-2784532334.ctg-left > div.jsx-727148539.filter-brand-desktop > input");
	
	By page3=By.cssSelector("#top-page > div.jsx-2784532334.ctg-cover > div.jsx-2784532334.ctg-right > div.jsx-557237353.paging > div.jsx-557237353.paging-number > div > a:nth-child(4)");
	By prevpage=By.cssSelector("#top-page > div.jsx-2784532334.ctg-cover > div.jsx-2784532334.ctg-right > div.jsx-557237353.paging > div.jsx-557237353.paging-number > a:nth-child(1)");
	By nextpage=By.cssSelector("#top-page > div.jsx-2784532334.ctg-cover > div.jsx-2784532334.ctg-right > div.jsx-557237353.paging > div.jsx-557237353.paging-number > a:nth-child(3)");
	By totop=By.cssSelector("#top-page > div.jsx-2784532334.ctg-cover > div.jsx-2784532334.ctg-right > div.jsx-557237353.paging > div.jsx-557237353.paging-totop");
	static By href=By.xpath("//div[@class='jsx-1103970675 product-card-catalog']//a");
	
	By hoverProductList=By.cssSelector("#top-page > div.jsx-2784532334.ctg-cover > div.jsx-2784532334.ctg-right > div.jsx-2784532334.ctg-list-item > div:nth-child(1) > a > img");
	By productHimalayan=By.cssSelector("#top-page > div.jsx-2784532334.ctg-cover > div.jsx-2784532334.ctg-right > div.jsx-2784532334.ctg-list-item > div:nth-child(5) > a > img");
	By sortoption=By.cssSelector("#top-page > div.jsx-2784532334.ctg-cover > div.jsx-2784532334.ctg-right > div.jsx-2784532334.sorter-cover > div > button");
	By sorthighestrating=By.cssSelector("#top-page > div.jsx-2784532334.ctg-cover > div.jsx-2784532334.ctg-right > div.jsx-2784532334.sorter-cover > div > div > a:nth-child(3)");
	By foundAddReviewButton=By.cssSelector("#top-page > div.jsx-2784532334.ctg-cover > div.jsx-2784532334.ctg-right > div.jsx-2784532334.ctg-list-item > div:nth-child(1) > a > div > button");
	
	
	public productlist(RemoteWebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
		
	}
	
	public WebElement clickFootCream(){
		
		return driver.findElement(catFootCream);
	}
	
	public WebElement clickBalm(){
		
		return driver.findElement(catBalm);
	}
	
	public WebElement clickBrand100Pure(){
		
		return driver.findElement(brand100pure);
	}
	
	public WebElement clickAkin(){
		
		return driver.findElement(akin);
	}
	
	public WebElement clickSearchBrand(){
		
		return driver.findElement(searchbrand);
	}
	
	public WebElement pointAddReviewProdList(){
		
		return driver.findElement(hoverProductList);
	}
	
	public WebElement pointProdHimalayan(){
		
		return driver.findElement(productHimalayan);
	}
	
	public WebElement foundAddReviewProdList(){
		
		return driver.findElement(foundAddReviewButton);
	}
	
	public WebElement clickSortProdList(){
		
		return driver.findElement(sortoption);
	}
	
	public WebElement chooseSortHighest(){
		
		return driver.findElement(sorthighestrating);
	}
	
	public WebElement clickPage3(){
		
		return driver.findElement(page3);
	}
	
	public WebElement clickPrevPage(){
		
		return driver.findElement(prevpage);
	}
	
	public WebElement clickNextPage(){
		
		return driver.findElement(nextpage);
	}
	
	public WebElement toTop(){
		
		return driver.findElement(totop);
	}
	
	public static WebElement findProduct1(){
		
		return driver.findElement(href);
	}

}