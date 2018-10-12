package testcase;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;
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
import pageObjects.homepage;
import pageObjects.login;
import pageObjects.productdetail;
import pageObjects.productlist;
import resources.controller;
import resources.support;

public class sortingProductList extends controller {
	
	public static Logger log =LogManager.getLogger(support.class.getName());
	
	public static RemoteWebDriver driver= null;
	public static WebElement main= null;
	public static Properties prop=null;
	
	public String UrlPage1 = null;
	
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
	
		//on browser
		home.letmejoinletter().click();
		
		WebElement getmenu= home.getMenuBody(); //xpath megamenu nya
		Actions act = new Actions(driver);
		act.moveToElement(getmenu).perform();
		
		(new WebDriverWait(driver, 3)).until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Hand Cream")));

		WebElement clickElement= driver.findElement(By.linkText("Hand Cream"));//xpath sub megamenu nya
		act.moveToElement(clickElement).click().perform();
		
		UrlPage1 = driver.getCurrentUrl();
		Assert.assertEquals(UrlPage1, "http://reviews.femaledaily.net/hand-foot/hand-cream?brand=&order=popular&page=1" );
		
		asser.getDataProductList();
		
		prodlist.clickSortProdList().click();
		asser.getDataProductList();
		
		System.out.println("                                                                                             ");
		System.out.println("                                                                                             ");
		
		asser.waitSortOption();
		prodlist.chooseSortHighest().click();
		Thread.sleep(2000);
		asser.getDataProductList();
		
		System.out.println("                                                                                             ");
		System.out.println("                                                                                             ");
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

