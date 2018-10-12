package testcase;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.Date;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import assertObject.assertHome;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import pageObjects.cartPage;
import pageObjects.categoryPage;
import pageObjects.checkoutPage;
import pageObjects.ProductPage;
import pageObjects.addproductpage;
import pageObjects.brandPage;
import pageObjects.homepage;
import pageObjects.login;
import pageObjects.productdetail;
import pageObjects.productlist;
import pageObjects.profileDetail;
import resources.ConnectDB;
import resources.controller;
import resources.support;

public class searchBrand extends controller {
	
public static Logger log =LogManager.getLogger(support.class.getName());
	
	public static RemoteWebDriver driver= null;
	public static WebElement main= null;
	public static Properties prop=null;
	
	public String UrlLogin = null;
	public String UrlReviewerProfDetail = null;
	public String nameReviewer = null;
	public String countFollower = null;
	public String coungFollowing = null;
	
	@BeforeTest
	@Parameters({ "browser" })
	public void setUp(String browser) throws IOException {
		System.out.println("*******************");
		driver = controller.getDriver(browser);
		
	}
	
	@Test(dataProvider="existingCust")
	public void scenario_satu(String email,String password,String alamat,String telepon) throws Exception {
		
		support supp= new support();
		homepage home = new homepage(driver);
		login logpro = new login(driver);
		addproductpage productpage = new addproductpage(driver);
		productlist prodlist = new productlist(driver);
		productdetail proddet = new productdetail(driver);
		profileDetail profdet = new profileDetail(driver);
		brandPage brand = new brandPage(driver);
		ConnectDB conn = new ConnectDB();
		
		assertHome asser = new assertHome(driver);
		categoryPage cat = new categoryPage(driver);
		ProductPage prod = new ProductPage(driver);
		cartPage cpage = new cartPage(driver);
		checkoutPage checkout = new checkoutPage(driver);
		
		prop= new Properties();
		FileInputStream fis=new FileInputStream("//Users//mac//Documents//Automation//mavenjob//Automation-Master//src_controller//resources//data.properties");
		prop.load(fis);
		String testenv=prop.getProperty("testlocation");
		
		if(testenv.equalsIgnoreCase("prod")){
        	driver.navigate().to("http://femaledaily.com/");  //https://dev.uangteman.com/a/NHeHv
             driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        	} else {
        		driver.navigate().to("http://femaledaily.net/");  //https://dev.uangteman.com/a/NHeHv
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        	}
		
		driver.manage().window().maximize();
		String strPageTitle = driver.getTitle();
		System.out.println(strPageTitle);
		
//		String getTextIseng = conn.getfromDatabaseBrands_productType("SELECT brands_item FROM nubr_brands WHERE brands_item LIKE'A%' ORDER BY brands_total_review_num DESC LIMIT 5;", "staging");
//	    System.out.println("SASDAS"+" "+getTextIseng);
	    
		
		String handle= driver.getWindowHandle(); //get window 1
		System.out.println(handle);
	
		//on browser
		home.letmejoinletter().click();
		
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", home.clickBrandFooter());
		Thread.sleep(4000);
		
		home.clickBrandFooter().click();
		
		Set handles = driver.getWindowHandles();
		 
        System.out.println(handles);
        
        for (String handle1 : driver.getWindowHandles()) {
        	 System.out.println(handle1);
        	 driver.switchTo().window(handle1);
        	 String page2 = driver.getCurrentUrl();
             System.out.println(page2);
        	}
        
        asser.waitBrandPage();
        
        brand.clickNivea().click();
        asser.waitBrandDetailPage();
        
        String UrlBrand1 = driver.getCurrentUrl();
        Assert.assertEquals(UrlBrand1, "http://reviews.femaledaily.net/brands/nivea?tab=products&page=1");
        
        brand.clickLogoHome().click(); //go bck to homepage
		home.letmejoinletter().click();
		
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", home.clickBrandFooter());
		Thread.sleep(4000);
		
		home.clickBrandFooter().click();
		
		Set handles2 = driver.getWindowHandles();
		
		System.out.println(handles2);
        
        for (String handle2 : driver.getWindowHandles()) {
        	 System.out.println(handle2);
        	 driver.switchTo().window(handle2);
        	 String page3 = driver.getCurrentUrl();
             System.out.println(page3);
        	}
        
        asser.waitBrandPage();
        	
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", brand.clickSortBrand());
        
        //verify most product
        String mostProductFromA = (String) conn.db_brandsItem("SELECT brands_item FROM nubr_brands WHERE brands_item LIKE'A%' ORDER BY brands_total_product DESC LIMIT 1;", "staging");
        System.out.println("database"+" "+mostProductFromA);
	    
	    String matchMostProduct = brand.getTextBrandMosProductFromA().getText();
	    System.out.println(matchMostProduct);
	    		
	    Assert.assertEquals(matchMostProduct, mostProductFromA);

        brand.clickSortBrand().click();
		brand.clickChooseMostReview().click();
		
		String matchMostReview = brand.getTextBrandMosProductFromA().getText();
		System.out.println(matchMostReview);
		
		//verify most review
		String mostReviewFromA = (String) conn.db_brandsItem("SELECT brands_item FROM nubr_brands WHERE brands_item LIKE'A%' ORDER BY brands_total_review_num DESC LIMIT 1;", "staging");
	    System.out.println("database"+" "+mostReviewFromA);
	    
	    Assert.assertEquals(matchMostReview, mostReviewFromA);
	    
	    home.clickSearch().sendKeys(mostReviewFromA, Keys.ENTER);
	    
	    asser.searchResultBrand();
	    
	    String getTextBrand = driver.findElement(By.xpath("//*[@id='top-page']/div[2]/div/div[2]/div[1]/div/div/div/div[2]/h1/a")).getText();
	    Assert.assertEquals(getTextBrand, mostReviewFromA);
	    
	}
	
	@AfterMethod
	public void tearDown() {
		if(driver!=null) {
			System.out.println("Closing browser");
			//driver.close();
		}
	}
	
	public void ExtractJSLogs() {
        LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
        for (LogEntry entry : logEntries) {
            System.out.println(new Date(entry.getTimestamp()) + " " + entry.getLevel() + " " + entry.getMessage());
        }
    }
	
	@DataProvider	  
	public Object[][] existingCust() throws Exception {
	     
		FileInputStream filepath = new FileInputStream("//Users//mac//Documents//Automation//mavenjob//Automation-Master//Workbook1.xls");

		Workbook wb = Workbook.getWorkbook(filepath);
		Sheet sheet = wb.getSheet("existing");

		int row = sheet.getRows();
		System.out.println("number of rows"+row);
		int column = sheet.getColumns();
		System.out.println("number of columns"+column);
		String Testdata[][] = new String[row-1][column];
		int count=0;

		     for (int i = 1; i < row; i++)
		     	{
		    	 for (int j = 0; j < column; j++)
		    	 {
		    		 Cell cell = sheet.getCell(j, i);
		    		 Testdata[count][j] = cell.getContents();
		     	}
		    	 count++;
		       }
		     filepath.close();
		     return Testdata;
		     }

}