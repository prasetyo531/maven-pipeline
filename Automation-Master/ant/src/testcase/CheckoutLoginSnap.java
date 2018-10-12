package testcase;

import static org.testng.Assert.assertTrue;
import java.awt.AWTException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import jxl.read.biff.BiffException;

import controller.controller;
import controller.controller.HttpResponseCode;
import io.restassured.response.Response;
import controller.configapp;

public class CheckoutLoginSnap extends controller {

public String productSelectAddCart ="Jobi Armchair";
	
    public static String createRandom(int Digits) {
        String result = new String();
        Random rand = new Random();
        for (int i = 0; i < Digits; i++)
        {
            result = result + rand.nextInt(9);
        }
        return result;
    }
    
    public void getResponse() {
	    
	    int response = new HttpResponseCode().httpResponseCodeViaPost("https://fabelio.com/checkout/");{
		
		if(response == 302){
		 System.out.println(response + " " + "is redirect");
		} if(response == 200){
		 System.out.println(response + " "+ "is ok");	
		} else {
		 System.out.println(response + " "+ "is internal server error");
		}
    }
    }
	
    //@Test(dataProvider="data",dataProviderClass=datatest.class) 
    //@Test(enable=false) untuk option run sebuah test case atau engga
	//@Test(timeout=45000) untuk kasih timeout
	
	@Test //(dataProvider="CustRegistration")
	public void scenario_satu() throws Exception {
  
		main = driver.findElement(By.cssSelector("div[class='page-wrapper']"));
		main = driver.findElement(By.cssSelector("div[class='sections nav-sections']"));
		main = driver.findElement(By.cssSelector("div[class='section-items nav-sections-items']"));
		main = driver.findElement(By.cssSelector("div[id='store.menu']"));
		main = driver.findElement(By.cssSelector("nav[class='navigation']"));
		main = driver.findElement(By.cssSelector("ul[id='ui-id-1']"));
		main = driver.findElement(By.cssSelector("li[class='level0 nav-1 first level-top parent ui-menu-item']"));
		Thread.sleep(5000);
		
		WebElement getmenu= driver.findElement(By.xpath("//*[@id='ui-id-2']/span[2]")); //xpath megamenu nya
		  
		Actions act = new Actions(driver);
		act.moveToElement(getmenu).perform();
		
		Thread.sleep(3000);
		WebElement clickElement= driver.findElement(By.linkText("Sofa L"));//xpath sub megamenu nya
		act.moveToElement(clickElement).click().perform();
			
        String getheadercatpage = driver.findElement(By.xpath("//*[@id='maincontent']/div[2]/div[2]/div/h2")).getText();
        System.out.println(getheadercatpage);
        
        if(getheadercatpage.equals("Sofa L")){
        	System.out.println("PASS");
        } else {
        	afterMethod();
        }
        
        //get price from array, xpath sampe atributes yg mau diambil
        List<WebElement> myList=driver.findElements(By.xpath("//li[@class='item product product-item col-lg-4 col-sm-6 col-12 nopadding']//div"));
    	List<String> url=new ArrayList<>();
    
    	for(int i=0; i<myList.size(); i++){

        //loading text of each element in to array all_elements_text
    	url.add(myList.get(i).getAttribute("data-sku"));
    	//if there is null, will not printed
    	if (myList.get(i).getAttribute("data-sku") != null){

        //to print directly
        System.out.println(myList.get(i).getAttribute("data-sku"));
    	}
      }
    	
    //go to product page	
    driver.findElement(By.id("product-8477")).click();
    
    
    //click beli sekarang
    Thread.sleep(8000);
    driver.findElement(By.id("product-addtocart-button")).click();
    
    //verify cart notification is present
    if(driver.findElement(By.xpath("//*[@id='cart-add-notification']"))!= null){ 
    	System.out.println("Element Cart Notification is Present");
    	}else{
    	System.out.println("Element Cart Notification is Missing");
    	}
    
    //click cart notification
    driver.findElement(By.xpath("html/body/div[3]/header/div[1]/div[1]/a")).click();
    
    //click view dan edit cart
    (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/header/div[1]/div[1]/div[1]/div/div/div[2]/div[5]/div/a")));
    boolean clickBeli = driver.findElement(By.xpath("/html/body/div[3]/header/div[1]/div[1]/div[1]/div/div/div[2]/div[5]/div/a")).isEnabled();
    if (clickBeli == true){
    	driver.findElement(By.xpath("/html/body/div[3]/header/div[1]/div[1]/div[1]/div/div/div[2]/div[5]/div/a")).click();
    } else {
    	driver.close();
    }
    
    //CART PAGE
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
    
	//check if cart-summary displaying
	if(driver.findElement(By.xpath("//*[@id='maincontent']/div[2]/div/div[3]"))!= null){ 
    	System.out.println("Element Cart Summary is Present");
    	}else{
    	System.out.println("Element Cart Summary is Missing");
    	}
		
 	//verify subtotal and total on cart summary should display
	assertTrue(driver.findElement(By.xpath("//*[@id='cart-totals']/div/table/tbody/tr[1]/th")).getText().matches("Sub Total"));
	assertTrue(driver.findElement(By.xpath("/html/body/div[3]/main/div[2]/div/div[3]/div[3]/div/table/tbody/tr[3]")).getText().contains("Total"));
	
	
	//click lanjutkan on cart page
	driver.findElement(By.xpath("//*[@id='maincontent']/div[2]/div/div[3]/ul/li/button")).click();
	driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	
	//CHECKOUT PAGE
	waitSeconds(8);
	
	driver.findElement(By.id("customer-email")).click();
	driver.findElement(By.id("customer-email")).sendKeys(this.email); // isi email
	waitSeconds(3);
	driver.findElement(By.xpath("//*[@id='btn-checkemail']")).click();
	waitSeconds(3);
	driver.findElement(By.id("customer-password")).sendKeys(this.password, Keys.ENTER);
	
	waitSeconds(10);
	
	 //section 2
	boolean existingAddress = driver.findElement(By.xpath("/html/body/div[3]/main/div[2]/div/div[2]/div[2]/ul[1]/li[2]/div[2]/div[2]/div[1]/div/div/ol/li/span[1]")).isDisplayed();
	boolean newAddress = driver.findElement(By.xpath("//*[@id='address-form-modal']")).isDisplayed(); 
	
	Thread.sleep(5000); //check default selection
	
	 if (existingAddress==true && newAddress==true){

	 driver.findElement(By.xpath("//*[@id='address-form-modal']")).click(); // add new address
	 
     waitSeconds(3);
 	
		if(driver.findElement(By.cssSelector("aside.modal-popup:nth-child(2) > div:nth-child(2)"))!= null){ // isi address
			System.out.println("Element input addresss is Present");
 		}else{
 			System.out.println("Element input addresss is Missing");
 		}
		
		main = driver.findElement(By.cssSelector("aside.modal-popup:nth-child(2)"));
		main = driver.findElement(By.cssSelector("aside.modal-popup:nth-child(2) > div:nth-child(2)"));
		main = driver.findElement(By.cssSelector("aside.modal-popup:nth-child(2) > div:nth-child(2) > div:nth-child(2)"));
		main = driver.findElement(By.cssSelector("#address-form-popup"));
		
		driver.findElement(By.cssSelector("input[name='firstname']")).sendKeys(this.firstname);
		driver.findElement(By.cssSelector("input[name='lastname']")).sendKeys(this.lasttname);
		driver.findElement(By.cssSelector("input[name='street[0]']")).sendKeys("alamat saya 1");
		driver.findElement(By.cssSelector("input[name='street[1]']")).sendKeys("alamat saya 2");
		
		driver.findElement(By.cssSelector("select[name='region_id']")).sendKeys("D", Keys.ENTER); //state-province 
		
		waitSeconds(6);
		//(new WebDriverWait(driver, 15)).until(ExpectedConditions.elementToBeClickable(By.cssSelector("select[name='city_id']")));  //city
		main = this.driver.findElement(By.cssSelector("select[name='city_id']"));
        main.findElement(By.cssSelector("option[value='2']")).click(); // Kota Jakarta Utara
		
        waitSeconds(6);
        //(new WebDriverWait(driver, 15)).until(ExpectedConditions.elementToBeClickable(By.cssSelector("select[name='subdistrict_id']")));
        main = this.driver.findElement(By.cssSelector("select[name='subdistrict_id']"));
        main.findElement(By.cssSelector("option[value='10']")).click(); // Kelapa Gading
		
        driver.findElement(By.cssSelector("input[name='telephone']")).sendKeys("08129381293");
        
        //save address
        (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[class='action primary']")));
        driver.findElement(By.cssSelector("button[class='action primary']")).click();
		
        //get DOM section 2
        main = driver.findElement(By.cssSelector("div[class='page-wrapper']"));
        main = driver.findElement(By.cssSelector("main[id='maincontent']"));
        main = driver.findElement(By.cssSelector("div[id='checkout']"));
        main = driver.findElement(By.cssSelector("div[class='aw-onestep aw-onestep-main']"));
        main = driver.findElement(By.cssSelector("ul[class='aw-onestep-groups']"));
        main = driver.findElement(By.cssSelector("li[id='section-shipping-address']"));
        main = driver.findElement(By.cssSelector("div[class='group-content section-shipping-address showHide']"));
        main = driver.findElement(By.cssSelector("div[class='onestep-shipping-address']"));
        main = driver.findElement(By.cssSelector("div[id='btn-next-address']"));
        main = driver.findElement(By.cssSelector("div[class='primary']")); 
        main = driver.findElement(By.cssSelector("button[class='button action continue primary']")); 
        
        //click next section 2
        (new WebDriverWait(driver, 15)).until(ExpectedConditions.elementToBeClickable(By.cssSelector("#btn-next-address > div:nth-child(1) > button:nth-child(1)")));
        main = driver.findElement(By.cssSelector("#btn-next-address > div:nth-child(1) > button:nth-child(1)"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", main);
        
        //click next section 3
        waitSeconds(15);
        //(new WebDriverWait(driver, 15)).until(ExpectedConditions.elementToBeClickable(By.cssSelector("#btn-next-orderreview > div:nth-child(1) > button:nth-child(1)")));
		//waitForElement("#btn-next-orderreview > div:nth-child(1) > button:nth-child(1)");
		
        main = driver.findElement(By.cssSelector("#btn-next-orderreview > div:nth-child(1) > button:nth-child(1)"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", main);
		
        
		//get dom section 4
        main = driver.findElement(By.cssSelector("div[class='page-wrapper']"));
        main = driver.findElement(By.cssSelector("main[id='maincontent']"));
        main = driver.findElement(By.cssSelector("div[id='checkout']"));
        main = driver.findElement(By.cssSelector("div[class='aw-onestep aw-onestep-main']"));
        main = driver.findElement(By.cssSelector("ul[class='aw-onestep-groups']"));
        main = driver.findElement(By.cssSelector("li[id='section-payment-method']"));
        main = driver.findElement(By.cssSelector("div[class='group-content section-payment-method']"));
        main = driver.findElement(By.cssSelector("div[data-bind='if:isAddressSelected']"));
        main = driver.findElement(By.cssSelector("div[class='payment-methods-box']"));
        main = driver.findElement(By.cssSelector("div[class='row']"));
        waitSeconds(2);
		driver.findElement(By.id("fabelio_snap")).click(); //select payment method
		
		//get dom place order
	    main = driver.findElement(By.cssSelector("div[class='page-wrapper']"));
	    main = driver.findElement(By.cssSelector("main[id='maincontent']"));
	    main = driver.findElement(By.cssSelector("div[id='checkout']"));
	    main = driver.findElement(By.cssSelector("div[class='aw-onestep aw-onestep-main']"));
	    main = driver.findElement(By.cssSelector("ul[class='aw-onestep-groups']"));
	    main = driver.findElement(By.cssSelector("li[id='section-payment-method']"));
	    main = driver.findElement(By.cssSelector("div[class='group-content section-payment-method']"));
	    main = driver.findElement(By.cssSelector("div[data-bind='if:isAddressSelected']"));
	    main = driver.findElement(By.cssSelector("div[class='aw-onestep-sidebar-block aw-sidebar-summary']"));
	    main = driver.findElement(By.cssSelector("div[class='aw-onestep-sidebar-block_content']"));
	    
	    assertTrue(driver.findElement(By.cssSelector("div.aw-onestep-sidebar-block:nth-child(3) > div:nth-child(2) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > th:nth-child(1)")).getText().matches("Cart Subtotal"));     	
	    assertTrue(driver.findElement(By.cssSelector("div.aw-onestep-sidebar-block:nth-child(3) > div:nth-child(2) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(2) > th:nth-child(1) > span:nth-child(1)")).getText().matches("Shipping"));
	    assertTrue(driver.findElement(By.cssSelector("div.aw-onestep-sidebar-block:nth-child(3) > div:nth-child(2) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(2) > td:nth-child(2) > strong:nth-child(1) > span:nth-child(1)")).getText().matches("GRATIS"));	
	    
	    main = driver.findElement(By.cssSelector("div[class='page-wrapper']"));
	    main = driver.findElement(By.cssSelector("main[id='maincontent']"));
	    main = driver.findElement(By.cssSelector("div[id='checkout']"));
	    main = driver.findElement(By.cssSelector("div[class='aw-onestep aw-onestep-main']"));
	    main = driver.findElement(By.cssSelector("ul[class='aw-onestep-groups']"));
	    main = driver.findElement(By.cssSelector("li[id='section-payment-method']"));
	    main = driver.findElement(By.cssSelector("div[class='group-content section-payment-method']"));
	    main = driver.findElement(By.cssSelector("div[data-bind='if:isAddressSelected']"));
	    main = driver.findElement(By.cssSelector("div[class='actions-toolbar']"));
	    
	    //click place order
	    driver.findElement(By.id("btn-place-order")).click();
	    waitSeconds(5);
	    getResponse();
	 }else{
		 System.out.println("element is enabled");
		 driver.close();
	 }
	}
  
	@BeforeMethod
	public void beforeMethod() throws InterruptedException, IOException {	  
		OpenBrowser();

	}
  
  @AfterMethod
  public void afterMethod() {  
	  
  }
}

