package tc_addProduct;

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
import java.util.Random;
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

import assertObject.assertAddProduct;
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
import resources.ConnectDB;

public class addProductEditBrand extends controller {
	
	String productName = "testing";
	String brandName = "wardah";
	private static final char[] characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
	 private static final Random random = new Random(new Date().getTime());
	
	public static Logger log =LogManager.getLogger(support.class.getName());
	
	public static RemoteWebDriver driver= null;
	public static WebElement main= null;
	public static Properties prop=null;
	
	public String UrlLogin = null;
	public String UrlPageDetail = null;
	
	 private static String createRandomString(int length) {
	        final StringBuffer stringBuffer = new StringBuffer();
	        for (int i = 0; i < length; i++) {
	            String randomValue;
	            if (random.nextInt(2) == 1) {
	                randomValue = String.valueOf(random.nextInt(10));
	            } else {
	                randomValue = Character.toString(characters[random.nextInt(26)]);
	            }
	            stringBuffer.append(randomValue);
	        }
	        return stringBuffer.toString();
	    }
	
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
		productdetail proddet = new productdetail(driver);;
		
		categoryPage cat = new categoryPage(driver);
		ProductPage prod = new ProductPage(driver);
		cartPage cpage = new cartPage(driver);
		checkoutPage checkout = new checkoutPage(driver);
		
		assertHome asser = new assertHome(driver);
		assertAddProduct asserAddProd = new assertAddProduct(driver);
		
		prop= new Properties();
		FileInputStream fis=new FileInputStream(workingDir+"//src_controller//resources//data.properties");
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
		
		home.clickLogin().click();
		UrlLogin = driver.getCurrentUrl();
		Assert.assertEquals(UrlLogin, "http://account.femaledaily.net/" );
		
		logpro.fillusername().sendKeys("putwid");
		logpro.fillpassword().sendKeys("tester123");
		logpro.clickbuttonlogin().click();
		
		//query check beauty points before add product
		Integer beautyPointsnow =  (Integer) ConnectDB.get_dataPoint("SELECT user_total_point FROM nubr_userappos WHERE username='putwid'", "staging");
		System.out.println(beautyPointsnow);
		Integer beautyPointexpected =  beautyPointsnow+25+10;
		System.out.println(beautyPointexpected);
		
		asser.welcomingpopup();
		
		//click hamburger
		home.Hamburger().click();;
		
		home.clickMenuReview().click();
		asser.waitNewestReview();
		
		WebElement getmenu= home.getAddProduct(); //xpath megamenu nya  
		Actions act = new Actions(driver);
		act.moveToElement(getmenu).perform();
		
		asser.addproducttodisplay();
		WebElement clickElement= home.clickAddProduct(); //xpath sub megamenu nya
		act.moveToElement(clickElement).click().perform();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		asser.modalAddproduct();
		
		//on page add product
		productpage.clickCloseModal().click();
		
		//step 1
		WebElement focusInputUrl= productpage.insertUrl(); //insert invalid url
	    Actions onfocusInputUrl = new Actions(driver);
	    onfocusInputUrl.moveToElement(focusInputUrl).click();	//insert valid url
	    onfocusInputUrl.sendKeys("https://i.kinja-img.com/gawker-media/image/upload/s--nncnCKWW--/c_scale,f_auto,fl_progressive,q_80,w_800/17hyh5lm9yhjvjpg.jpg");
	    onfocusInputUrl.build().perform();
		
		productpage.clickShowLinkImage().click();
		
		asserAddProd.buttonnext1enable();
		
		JavascriptExecutor je = (JavascriptExecutor) driver;
	    WebElement elementnext = productpage.nextStep1();
	    je.executeScript("arguments[0].scrollIntoView(true);",elementnext);
       
//       JavascriptExecutor js = (JavascriptExecutor) driver;
//       js.executeScript("window.scrollBy(0,1000)");
       
       productpage.nextStep1().click();
       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       
       //step 2
       WebElement focusbrand= productpage.selectBrand(); //xpath megamenu nya  
       Actions onfocusbrand = new Actions(driver);
       onfocusbrand.moveToElement(focusbrand).click();
       onfocusbrand.sendKeys("warda", Keys.ENTER);
       onfocusbrand.build().perform();
       
       WebElement focusprodcat= productpage.selectProductCat(); //xpath megamenu nya  
       Actions onfocusprodcat = new Actions(driver);
       onfocusprodcat.moveToElement(focusprodcat).click();
       onfocusprodcat.sendKeys("frag", Keys.ENTER);
       onfocusprodcat.build().perform();

       WebElement focusProductSubCat= productpage.insertProductSubCat(); //xpath megamenu nya  
       Actions onfocusProductSubCat = new Actions(driver);
       onfocusProductSubCat.moveToElement(focusProductSubCat).click();
       onfocusProductSubCat.sendKeys("edp", Keys.ENTER);
       onfocusProductSubCat.build().perform();
       
       WebElement focusProductName= productpage.insertProductName(); //xpath megamenu nya  
       Actions onfocusProductName = new Actions(driver);
       onfocusProductName.moveToElement(focusProductName).click();
       onfocusProductName.sendKeys(createRandomString(8));
       onfocusProductName.build().perform();
       
       WebElement focusProductShade= productpage.insertProductShade(); //xpath megamenu nya  
       Actions onfocusProductShade = new Actions(driver);
       onfocusProductShade.moveToElement(focusProductShade).click();
       onfocusProductShade.sendKeys("female");
       onfocusProductShade.build().perform();
       
       productpage.nextStep2().click();
       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       
       //step 3
       productpage.chooseRating().click();
       productpage.choosePackagequality().click();
       productpage.chooseRepurchase().click();
       productpage.inputWritereview().sendKeys("barang bagus barang bagus barang bagus barang bagus barang bagus barang bagus barang bagus barang bagus barang bagus barang bagus barang bagus barang bagus barang bagus barang bagus barang bagus barang bagus");
       productpage.nextStep3().isEnabled();
       productpage.nextStep3().click();
       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       
       //step 4
       productpage.inputPrice().click();
       productpage.inputPrice().sendKeys("100000");
       productpage.inputDescription().click();
       productpage.inputDescription().sendKeys("add product edit brand");
       
       //edit step 2
       productpage.editStep2().click();
       WebElement focuseditbrand= productpage.editBrand(); //xpath megamenu nya  
       Actions onfocuseditbrand = new Actions(driver);
       onfocusbrand.moveToElement(focuseditbrand).click();
       onfocusbrand.sendKeys("goldwell", Keys.ENTER);
       onfocusbrand.build().perform();
       
       //click next step 2
       productpage.nextStep2().click();
       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       
       //click next step 3
       productpage.nextStep3().click();
       
       //click submit
       productpage.clickSubmit().click();
       
       UrlPageDetail = driver.getCurrentUrl();
       System.out.println(UrlPageDetail);
       if (UrlPageDetail.contains("/fragrance/edp/goldwell")) {//asert contain expected text
    	   System.out.println("pass");
       } else {
    	   System.out.println("fail");
       }
       
       //check beauuty points after add product
       Integer beautyPointscurrent =  (Integer) ConnectDB.get_dataPoint("SELECT user_total_point FROM nubr_userappos WHERE username='putwid'", "staging");
       Integer beautyPointsactual =  beautyPointscurrent+10;
       System.out.println(beautyPointsactual);
       assertTrue(beautyPointsactual.equals(beautyPointexpected));
       
	}
	
	@AfterMethod
	public void tearDown() {
		if(driver!=null) {
			System.out.println("Closing browser");
//			driver.close();
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
	     
		FileInputStream filepath = new FileInputStream(workingDir+"//Workbook1.xls");

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