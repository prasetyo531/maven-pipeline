package testcase;

import static org.testng.Assert.assertTrue;

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
import org.openqa.selenium.Dimension;
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

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import pageObjects.completeProfile;
import pageObjects.cartPage;
import pageObjects.categoryPage;
import pageObjects.checkoutPage;
import pageObjects.ProductPage;
import pageObjects.addproductpage;
import pageObjects.homepage;
import pageObjects.login;
import pageObjects.productdetail;
import pageObjects.productlist;
import resources.ConnectDB;
import resources.controller;
import resources.support;
import assertObject.assertHome;
import assertObject.assertCompProfile;

public class createAccount extends controller {
	
	/*
	 * please make sure
	 * 1. you already created the email in mailinator for data in xls
	 * 2. ensure username is new
	 */
	
	String productName = "testing";
	String brandName = "wardah";
	
	public static Logger log =LogManager.getLogger(support.class.getName());
	
	public static RemoteWebDriver driver= null;
	public static WebElement main= null;
	public static Properties prop=null;
	
	public String UrlLogin = null;
	public String UrlPageDetail = null;
	public String emailCreator = null;
	public String usernameCreator = null;
	public String passCreator = null;
	public String conPassCreator = null;
	
	@BeforeTest
	@Parameters({ "browser" })
	public void setUp(String browser) throws IOException {
		System.out.println("*******************");
		driver = controller.getDriver(browser);
		
	}
	
	@Test(dataProvider="existingCust")
	public void scenario_satu(String email,String password,String confirm_password,String username) throws Exception {
		
		support supp= new support();
		homepage home = new homepage(driver);
		login logpro = new login(driver);
		addproductpage productpage = new addproductpage(driver);
		productlist prodlist = new productlist(driver);
		productdetail proddet = new productdetail(driver);;
		
		completeProfile comprof = new completeProfile(driver);
		categoryPage cat = new categoryPage(driver);
		ProductPage prod = new ProductPage(driver);
		cartPage cpage = new cartPage(driver);
		
		assertCompProfile asserComProf = new assertCompProfile(driver);
//		AssertElement asser = new AssertElement(driver);
		
		prop= new Properties();
		FileInputStream fis=new FileInputStream("//Users//mac//Documents//Automation//mavenjob//Automation-Master//src_controller//resources//data.properties");
		prop.load(fis);
		String testenv=prop.getProperty("testlocation");
		
		if(testenv.equalsIgnoreCase("prod")){
        	driver.navigate().to("http://femaledaily.net/");  //https://dev.uangteman.net/a/NHeHv
             driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        	} else {
        		driver.navigate().to("http://femaledaily.net/");  //https://dev.uangteman.net/a/NHeHv
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        	}
		
		driver.manage().window().maximize();
		String strPageTitle = driver.getTitle();
		System.out.println(strPageTitle);
		
		//login page
		home.clickLogin().click();
		UrlLogin = driver.getCurrentUrl();
		Assert.assertEquals(UrlLogin, "http://account.femaledaily.net/");
		
		logpro.clickCreateAccount().click();
		
		//register page
		logpro.fillEmail().sendKeys(email);
		logpro.fillUsername().sendKeys(username);
		logpro.fillPassword().sendKeys(password);
		logpro.fillConfirmPasword().sendKeys(confirm_password);
		logpro.tickAggrement().click();
		logpro.clickCreateAccountRe().click();
		
		asserComProf.registerIsSuccess();
		
		String getDataUsername = (String) ConnectDB.get_dataUsername("SELECT username FROM nubr_userappos ORDER BY usrapo_id DESC LIMIT 1", "staging");
		
		//check beaut points after signup = 10
		Integer beautyPoints =  (Integer) ConnectDB.get_dataPoint("SELECT user_total_point FROM nubr_userappos WHERE username='"+getDataUsername+"'", "staging");
		
		if(beautyPoints.equals(10)){
			assertTrue(beautyPoints.equals(10));
			System.out.println("signup point is correct the points="+""+beautyPoints);
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		comprof.fillmonthdob().click();
		String dobsummonth = driver.findElement(By.xpath("//*[@id='birthday']/div[2]/div/div[1]/div/div[2]")).getText();
		assertTrue(dobsummonth.contains("January"));
		if(dobsummonth.contains("January")){
			System.out.println(dobsummonth);
			comprof.filldatedob().click();
			String dobsumdate = driver.findElement(By.xpath("//*[@id='birthday']/div[2]/div/div[2]/div/div[2]")).getText();
			assertTrue(dobsumdate.contains("1"));
				if(dobsumdate.contains("1")){
				System.out.println(dobsumdate);
				comprof.fillyeardob().click();
				String dobsumyear = driver.findElement(By.xpath("//*[@id='birthday']/div[2]/div/div[3]/div/div[2]")).getText();
				assertTrue(dobsumyear.contains("1940"));
				System.out.println(dobsumyear);
					if(dobsumyear.contains("1940")){
				    comprof.clicknextdob();
					}else{
						driver.close();
					}
				}else{
					driver.close();
				}
				
		}else{
			driver.close();
		}
		
		comprof.clicknextdob().click();
		
		//skin_type page
//		asserComProf.waitskintypeload();
		(new WebDriverWait(driver, 50)).until(ExpectedConditions.urlContains("/completing-profile?step=skin_type"));
		
		comprof.choosenormal().click();
		comprof.clicknextskin_type().click();
		
		//skin_tone page
		asserComProf.waitskintoneload();
		
		comprof.chooselight().click();
		comprof.clicknextskin_tone().click();
		
		//skin_undertone
		asserComProf.waitskinundertoneload();
		
		comprof.choosecool().click();
		comprof.clicknextskin_undertone().click();
		
		//hair_type
		asserComProf.waithairtypeload();
		
		comprof.choosewavy().click();
		comprof.clicknexthair_type().click();
		
		//hair_color
		asserComProf.waithaircolorload();
		
		comprof.choosecoloredhair_yes().click();
		comprof.clicknexthair_color().click();
		
		//hijab
		asserComProf.waithijabload();
		
		comprof.choosewearhijab_yes().click();
		comprof.clicknexthijab_yes().click();
		
		//cek db beuty points
		Integer beautyPoints1 =  (Integer) ConnectDB.get_dataPoint("SELECT user_total_point FROM nubr_userappos WHERE username='"+getDataUsername+"'", "staging");
		
		if(beautyPoints1.equals(20)){
			assertTrue(beautyPoints1.equals(20));
			System.out.println("signup point is correct the points="+""+beautyPoints1);
		}
		
		//skin_concerns
		asserComProf.waitskinconcernsload();
		
		comprof.chooseskinacne().click();
		comprof.clicknextskin_concern().click();
		
		//body_concerns
		asserComProf.waitbodyconcernsload();
		
		comprof.choosebodyacne().click();
		comprof.clicknextbody_concern().click();
		
		//hair_concern
		asserComProf.waithair_concernsload();
		
		comprof.choosedamaged().click();
		comprof.clicknexthair_concern().click();
		
		//cek db beuty points
		Integer beautyPoints2 =  (Integer) ConnectDB.get_dataPoint("SELECT user_total_point FROM nubr_userappos WHERE username='"+getDataUsername+"'", "staging");
		
		if(beautyPoints2.equals(30)){
			assertTrue(beautyPoints2.equals(30));
			System.out.println("signup point is correct the points="+""+beautyPoints2);
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//upload photo
		asserComProf.waitsummaryload();
		
		comprof.clickuploadphoto().click();
		
		File photo = new File("/Users/mac/Documents/multimedia/background/DMDIKcyWsAEsKDj.jpg");
        StringSelection stringSelection1= new StringSelection(photo.getAbsolutePath());
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection1, null);
		
        Robot robot1 = new Robot();
        
        // Cmd + Tab is needed since it launches a Java app and the browser looses focus
       
       robot1.keyPress(KeyEvent.VK_META);
       robot1.keyPress(KeyEvent.VK_TAB);
       robot1.keyRelease(KeyEvent.VK_META);
       robot1.keyRelease(KeyEvent.VK_TAB);
       robot1.delay(800);
       //Open Goto window
       robot1.keyPress(KeyEvent.VK_META);
       robot1.keyPress(KeyEvent.VK_SHIFT);
       robot1.keyPress(KeyEvent.VK_G);
       robot1.keyRelease(KeyEvent.VK_META);
       robot1.keyRelease(KeyEvent.VK_SHIFT);
       robot1.keyRelease(KeyEvent.VK_G);
       //Paste the clipboard value
       robot1.keyPress(KeyEvent.VK_META);
       robot1.keyPress(KeyEvent.VK_V);
       robot1.keyRelease(KeyEvent.VK_META);
       robot1.keyRelease(KeyEvent.VK_V);
       //Press Enter key to close the Goto window and Upload window
       robot1.keyPress(KeyEvent.VK_ENTER);
       robot1.keyRelease(KeyEvent.VK_ENTER);
       robot1.delay(800);
       robot1.keyPress(KeyEvent.VK_ENTER);
       robot1.keyRelease(KeyEvent.VK_ENTER);
       Thread.sleep(5000);
       
       //fill username
       comprof.fillfullname().sendKeys("usernametest");
       
       //fill locations
       comprof.clicklocation().click();
       String cityloc = comprof.getTextLocationField();;
       assertTrue(cityloc.contains("Yogyakarta"));
       
       //fill phone no
       comprof.fillphoneno().sendKeys("081284915951");
       
       comprof.fillbio().sendKeys("ikigai");
       
       Actions actions = new Actions(driver);
       actions.moveToElement(comprof.choosefavbrand());
       actions.click();
       actions.sendKeys("body", Keys.ENTER);
       actions.build().perform();
       
       //scroll to element
       JavascriptExecutor je = (JavascriptExecutor) driver;
       WebElement element = comprof.clickfinishprofile();
       je.executeScript("arguments[0].scrollIntoView(true);",element);
       
       comprof.clickfinishprofile().click();
       
       //cek db beuty points after fill photo,location
       Integer beautyPoints3 =  (Integer) ConnectDB.get_dataPoint("SELECT user_total_point FROM nubr_userappos WHERE username='"+getDataUsername+"'", "staging");
       assertTrue(beautyPoints3.equals(40));
       System.out.println(beautyPoints3);
       
       //find_friends
       asserComProf.waitsuggestfollowload();
       comprof.clickdonefindfriends().click();
       
       //last_step
       asserComProf.waitbeautyjourneyload();
       comprof.clickstartjourney().click();
	
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
		Sheet sheet = wb.getSheet("Create account success");

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
