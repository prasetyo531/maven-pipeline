package testcase;

import java.awt.AWTException;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import jxl.read.biff.BiffException;

import controller.controller;
import controller.configapp;

public class FilterSortWishlistAddCart extends controller {
	
	public String productFilterSortWishlistAddCart ="Jobi Armchair";
	
	  public static String createRandom(int Digits) {
	        String result = new String();
	        Random rand = new Random();
	        for (int i = 0; i < Digits; i++)
	        {
	            result = result + rand.nextInt(9);
	        }
	        return result;
	    }

		public void waittoLoad(WebElement w, WebDriverWait wait) {

	    wait.until((WebDriver driver) -> w);
		}
		
	    //@Test(dataProvider="data",dataProviderClass=datatest.class) 
	    //@Test(enable=false) untuk option run sebuah test case atau engga
		//@Test(timeout=45000) untuk kasih timeout
		
		@Test //(dataProvider="CustRegistration")
		public void scenario_satu() throws Exception {
	  
	      
		  main = driver.findElement(By.cssSelector("div[class='wrapper']"));
		  main = driver.findElement(By.cssSelector("div[class='page']"));
		  main = driver.findElement(By.cssSelector("div[class='header-container type11']"));
		  main = driver.findElement(By.cssSelector("div[class='container-fluid bottom-header']"));
		  main = driver.findElement(By.cssSelector("li[class='menu-full-width']"));
		  Thread.sleep(5000);
		  
		  WebElement getmenu= driver.findElement(By.xpath("html/body/div[5]/div/div[1]/div[1]/div[2]/div/div/div/div[1]/div/div/div/div/div/ul/li[1]/a"));
		  
		  Actions act = new Actions(driver);
		  act.moveToElement(getmenu).perform();
	      
		  //category page
		  driver.findElement(By.linkText("Armchair")).sendKeys(Keys.ENTER);
		  System.out.println("click armchair");
		  //driver.findElement(By.cssSelector("a[href='https://staging.uangteman.com/loan-calculator")).click();
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  
		  //product page
		  driver.findElement(By.linkText(this.productFilterSortWishlistAddCart)).click();
		  
		  //select swatches
		  driver.findElement(By.xpath("//*[@id='product-options-wrapper']/div[1]/span[2]/span[1]/span")).click();
		  
		  Select dropdown = new Select(driver.findElement(By.id("select-swatches")));
		  dropdown.selectByVisibleText("Ruby");
		  
		  //add to cart
		  driver.findElement(By.xpath("//*[@id='product_addtocart_form']/div[1]/div/div[2]/div[5]/div/div[3]/div/div[5]/span[1]/div")).click();
		  
		  //explicit(driver, "//*[@id='success-message-container");
		  //verify product on cart
		  waitForElement("//*[@id='success-message-container']");
		  
		  String cartBox = driver.findElement(By.xpath("//*[@id='success-message-container']")).getText();
		  
		  System.out.println(cartBox);
		  
		  if(cartBox.contains(this.productFilterSortWishlistAddCart)) {
			  System.out.println("Cart Apply-Success");
		  } else {
			  System.out.println("FAIL");
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