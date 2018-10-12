package assertObject;


import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class assertHome {

	public RemoteWebDriver driver= null;
	
	public assertHome(RemoteWebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver=driver;    
		
	}
	
	//wait Welcome username !
	public void welcomingpopup(){
		(new WebDriverWait(driver, 5)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='__next']/div/div/div[2]/h1")));
	}
	
	//---------------add product
	public void addproducttodisplay(){
		(new WebDriverWait(driver, 5)).until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Add Product")));
	}
	
	public void searchResultBrand(){
		(new WebDriverWait(driver, 15)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='top-page']/div[2]/div/div[2]/div[1]/div/div")));
	}
	
	public void hamburgerMenu(){
		(new WebDriverWait(driver, 15)).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("body > div:nth-child(7) > div > div.jsx-1757651050.new-menu > div.jsx-1757651050.new-menu-header")));
	}
	
	//confirmation modal add product
	public void modalAddproduct(){
		(new WebDriverWait(driver, 15)).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("body > div:nth-child(7) > div > div.jsx-1750402829.modal-add-product-contain > form")));
	}
	
	
	//myaccount element
	public void loggedInAfterLogout(){
		(new WebDriverWait(driver, 5)).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#__next > div > div > div.jsx-1986071017.gbheader > div.jsx-1986071017.gbheader-right > div.gbheader-userprofile")));
	}
	
	//reviews page
	public void waitNewestReview(){
		(new WebDriverWait(driver, 5)).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#top-page > div:nth-child(2)")));
	}
	
	public void waitPopularProducts(){
		(new WebDriverWait(driver, 20)).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#top-page > div.jsx-2475539403.add-review-item-container > div.jsx-2475539403.cardsi-list")));
	}
	
	public void getDataNewestReviewList(){
		
		List<WebElement> myList=driver.findElements(By.xpath("//div[@class='jsx-1569223425 cardrv-content']//div//div//div//a")); //get price from array, xpath sampe atributes yg mau diambil
		List<String> url=new ArrayList<>();

		for(int i=0; i<myList.size(); i++){

		url.add(myList.get(i).getAttribute("href"));	//loading text of each element in to array all_elements_text
		if (myList.get(i).getAttribute("href") != null){	//if there is null, will not printed

		System.out.println(myList.get(i).getAttribute("href"));	//to print directly
			}
		 }
		}
	
	public void waitPopularProductReviewsPage(){
		(new WebDriverWait(driver, 20)).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#top-page > div.jsx-2292723732.add-review-item-container > div.jsx-2292723732.cardsi-list")));
	}
	
	
	
	//product list
	public void getDataProductList(){
		
	List<WebElement> myList=driver.findElements(By.xpath("//div[@class='jsx-1103970675 product-card-catalog']//a")); //get price from array, xpath sampe atributes yg mau diambil
	List<String> url=new ArrayList<>();

	for(int i=0; i<myList.size(); i++){

	url.add(myList.get(i).getAttribute("href"));	//loading text of each element in to array all_elements_text
	if (myList.get(i).getAttribute("href") != null){	//if there is null, will not printed

	System.out.println(myList.get(i).getAttribute("href"));	//to print directly
		}
	 }
	}
	
	public void waitSortOption(){
		(new WebDriverWait(driver, 30)).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#top-page > div.jsx-2784532334.ctg-cover > div.jsx-2784532334.ctg-right > div.jsx-2784532334.sorter-cover > div > div")));
	}
	
	public void getDataProductRating(){
		
		List<WebElement> myList=driver.findElements(By.xpath("//div[@class='jsx-1103970675 product-card-catalog']//div//h3//span")); //get price from array, xpath sampe atributes yg mau diambil
		List<String> url=new ArrayList<>();

		for(int i=0; i<myList.size(); i++){

		url.add(myList.get(i).getAttribute("class"));	//loading text of each element in to array all_elements_text
		if (myList.get(i).getAttribute("class") != null){	//if there is null, will not printed

		System.out.println(myList.get(i).getAttribute("class"));	//to print directly
			}
		 }
		}
	
	
	//product detail
	public void getDataWavyLIst(){
		
		List<WebElement> myList=driver.findElements(By.xpath("//div")); //get price from array, xpath sampe atributes yg mau diambil
		List<String> url=new ArrayList<>();

		for(int i=0; i<myList.size(); i++){

		url.add(myList.get(i).getAttribute("class"));	//loading text of each element in to array all_elements_text
		if (myList.get(i).getAttribute("class") != null){	//if there is null, will not printed

		System.out.println(myList.get(i).getAttribute("class"));	//to print directly
			}
		 }
		}
	
	public void waitPageDetail(){
		(new WebDriverWait(driver, 30)).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#top-page > div.jsx-2790062022.cover-tabrev > div.jsx-2790062022.prodlist-review-cover > div > div")));
	}
	
	public void waitReviewForm(){
		(new WebDriverWait(driver, 30)).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#form-add-review")));
	}
	
	public void waitReviewSubmitted(){
		(new WebDriverWait(driver, 30)).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#top-page > div.jsx-2790062022.cover-tabrev > div.jsx-2790062022.prodlist-review-cover > div:nth-child(1) > div")));
	}
	
	//product review desc page
	public void waitPageReviewDesc(){
		(new WebDriverWait(driver, 30)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/div/div[2]/div/div[2]/div/div[1]")));
		
	}
	
	//reviewer profile page
	public void waitProfilePage(){
		(new WebDriverWait(driver, 30)).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#top-page > div > div.jsx-1832169295.proftop-cover > div.jsx-1832169295.profile-beauty-id-container")));
		
	}
	
	//get post list
	public void getdatapostlist(){
		
		List<WebElement> myList=driver.findElements(By.xpath("//div[@class='jsx-553015127 desktop-post']//div//img")); //get price from array, xpath sampe atributes yg mau diambil
		List<String> url=new ArrayList<>();

		for(int i=0; i<myList.size(); i++){

		url.add(myList.get(i).getAttribute("src"));	//loading text of each element in to array all_elements_text
		if (myList.get(i).getAttribute("src") != null){	//if there is null, will not printed

		System.out.println(myList.get(i).getAttribute("src"));	//to print directly
			}
		 }
		}
	
	//register warning
	public void waitWarningRegister(){
		(new WebDriverWait(driver, 50)).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#__next > div > div > div.jsx-3296557956._1jmxl8o.register > form > div.jsx-3296557956.register-warning > p")));
	}
	
	//register success
	public void registerIsSuccess(){
		(new WebDriverWait(driver, 30)).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='birthday']/div[2]/div/div[1]/div")));
	}

	//forgot password success
	public void forgotPasswordSuccess(){
		(new WebDriverWait(driver, 30)).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#__next > div > div > div.jsx-3767551361._1jmxl8o.forgot-password")));
	}
	
	//CATEGORY PAGE
	public void getdatasku(){
		
	List<WebElement> myList=driver.findElements(By.xpath("//li[@class='item product product-item col-lg-4 col-sm-6 col-12 nopadding']//div")); //get price from array, xpath sampe atributes yg mau diambil
	List<String> url=new ArrayList<>();

	for(int i=0; i<myList.size(); i++){

	url.add(myList.get(i).getAttribute("data-sku"));	//loading text of each element in to array all_elements_text
	if (myList.get(i).getAttribute("data-sku") != null){	//if there is null, will not printed

	System.out.println(myList.get(i).getAttribute("data-sku"));	//to print directly
		}
	 }
	}
	
	public void assertcatheader(){
		(new WebDriverWait(driver, 3)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='maincontent']/div[2]/div[2]/div/h1")));
		
	}
	
	public void asserttextsofal(){
		
		String getheadercatpage = driver.findElement(By.xpath("//*[@id='maincontent']/div[2]/div[2]/div/h1")).getText();
        System.out.println(getheadercatpage);
        
        if(getheadercatpage.equals("Sofa L")){
        	System.out.println("PASS");
        } else {
        	System.out.println("FAIL");
        	driver.close();
        }
	}
	
	//brand
	public void waitBrandPage(){
		(new WebDriverWait(driver, 30)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='__next']/div/div/div[3]/div[6]/div")));
	}
	public void waitBrandDetailPage(){
		(new WebDriverWait(driver, 30)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='top-page']/div/div[1]")));
	}
	
	//PRODUCT PAGE
	public void waitmainimage(){
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='maincontent']/div[2]/div/div[2]/div/div[2]/div[2]/div[2]/div/div[2]/div[1]")));
	}
	
	public void assertbelienable(){
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.id("product-addtocart-button")));
	}
	
	public void assertbeliclicked(){
		(new WebDriverWait(driver, 15)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='cart-add-notification']/div")));
	}
	
	public void assertcartnotif() throws InterruptedException{
		Thread.sleep(3000);
		(new WebDriverWait(driver, 15)).until(ExpectedConditions.elementToBeClickable(By.cssSelector("#cart-add-notification > div")));
	}
	
	
	
	//CART PAGE
	public void getlinksku(){
		
		List<WebElement> myCart=driver.findElements(By.xpath("//tbody[@class='cart item']//tr//td//a"));
		List<String> cart=new ArrayList<>();
		
		for(int i=0; i<myCart.size(); i++){
	
	        //loading text of each element in to array all_elements_text
			cart.add(myCart.get(i).getAttribute("href"));
	    	//if there is null, will not printed
	    	if (myCart.get(i).getAttribute("href") != null){
	
	        //to print directly
	        System.out.println(myCart.get(i).getAttribute("href"));
	    	}
		}
	}
	
	public void checkproductqtycart(){
		
		if(driver.findElement(By.xpath("//*[@id='maincontent']/div[2]/div/div[3]"))!= null){  //check if cart-summary displaying
	    	System.out.println("Element Cart Summary is Present");
	    	}else{
	    	System.out.println("Element Cart Summary is Missing");
	    	}
	}
	
	public void assertuntiltotal(){
		(new WebDriverWait(driver, 20)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='cart-totals']/div/table/tbody/tr[1]/th")));
	}
	
	public void assertsubtotal(){
		assertTrue(driver.findElement(By.xpath("//*[@id='cart-totals']/div/table/tbody/tr[1]/th")).getText().matches("Sub Total"));
	}
	
	public void asserttotal(){
		assertTrue(driver.findElement(By.xpath("//*[@id='cart-totals']/div/table/tbody/tr[2]/th/span")).getText().contains("Shipping"));
	}
	
	
	//CHECKOUT PAGE
	//section 1
	public void waitgoogle(){
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='section-login']/div[2]/div/div[3]/ul/li[1]/a")));
	}
	
	public void waitcheckbtnemail(){
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='btn-checkemail']")));
	}
	
	public void waitcheckbtnpassword(){
		(new WebDriverWait(driver, 5)).until(ExpectedConditions.elementToBeClickable(By.id("customer-password")));
	}
	
	public void waitbtnpasswordenable(){
		(new WebDriverWait(driver, 15)).until(ExpectedConditions.elementToBeClickable(By.id("next-step")));
	}
	
	//section 2
	public void checkdefaultaddress(){
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#shipping-address-items > li.shipping-address-item.selected-item"))); //CHECK DEFAULT ADDRESS
	    (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#address-form-modal"))); //CHECK ADD ADDRESS
	}
	
	public void waitpopupaddress(){
		(new WebDriverWait(driver, 5)).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("aside.modal-popup:nth-child(2) > div:nth-child(2)")));
	}
	
	public void waitbtnnextsec2(){
		(new WebDriverWait(driver, 5)).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#btn-next-address > div:nth-child(1) > button:nth-child(1)")));
	}
	
	//section 3
	public void waitbtnnextsec3(){
		(new WebDriverWait(driver, 40)).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#btn-next-orderreview > div > button")));
	}
	
	//section 4
	public void assertsection4(){	
		assertTrue(driver.findElement(By.cssSelector("#section-payment-method > div.group-content.section-payment-method > div:nth-child(3) > div.aw-onestep-sidebar-block.aw-sidebar-summary > div.aw-onestep-sidebar-block_content > table > tbody > tr.totals.sub > th")).getText().matches("Cart Subtotal"));     	
	    assertTrue(driver.findElement(By.cssSelector("#section-payment-method > div.group-content.section-payment-method > div:nth-child(3) > div.aw-onestep-sidebar-block.aw-sidebar-summary > div.aw-onestep-sidebar-block_content > table > tbody > tr.totals.shipping.excl > th > span.label")).getText().matches("Shipping"));
	    assertTrue(driver.findElement(By.cssSelector("#section-payment-method > div.group-content.section-payment-method > div:nth-child(3) > div.aw-onestep-sidebar-block.aw-sidebar-summary > div.aw-onestep-sidebar-block_content > table > tbody > tr.totals.shipping.excl > td > strong > span")).getText().matches("GRATIS"));	  
	}
	
	public void waitplaceorder(){
		(new WebDriverWait(driver, 30)).until(ExpectedConditions.elementToBeClickable(By.id("btn-place-order")));
	}
	
	//success page
	public void successpage(){
		
		(new WebDriverWait(driver, 50)).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#maincontent > div.columns > div > div.checkout-success.col-lg-12.col-md-12.col-12 > div > div.success-message-wrapper.col-lg-12.col-md-12.col-12 > label")));
		
	}
}
