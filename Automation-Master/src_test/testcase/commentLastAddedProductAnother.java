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
import org.openqa.selenium.Alert;
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


public class commentLastAddedProductAnother extends controller {
	
	String productName = "testing";
	String brandName = "wardah";
	
	public static Logger log =LogManager.getLogger(support.class.getName());
	
	public static RemoteWebDriver driver= null;
	public static WebElement main= null;
	public static Properties prop=null;
	
	public String UrlLogin = null;
	public String UrlPageDetail = null;
	
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
		
		home.clickLogin().click();
		UrlLogin = driver.getCurrentUrl();
		Assert.assertEquals(UrlLogin, "http://account.femaledaily.net/" );
		
		logpro.fillusername().sendKeys("putwid");
		logpro.fillpassword().sendKeys("tester123");
		logpro.clickbuttonlogin().click();
		
		asser.welcomingpopup();
		
		WebElement getmenu= home.getAddProduct(); //xpath megamenu nya  
		Actions act = new Actions(driver);
		act.moveToElement(getmenu).perform();
		
		asser.addproducttodisplay();
		WebElement clickElement= home.clickAddProduct(); //xpath sub megamenu nya
		act.moveToElement(clickElement).click().perform();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		System.out.println(UrlLogin);
		
		//step 1
		WebElement focusInputUrl= productpage.insertUrl(); //insert invalid url
	    Actions onfocusInputUrl = new Actions(driver);
	    onfocusInputUrl.moveToElement(focusInputUrl).click();
	    onfocusInputUrl.sendKeys("https://blog.adioma.com/wp-content/uploads/2014/10/How-Steve-Jobs-Started-apple-founder-infographic-700x466.jpg");
	    onfocusInputUrl.build().perform();
	    
	    productpage.clickShowLinkImage().click();
	    
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
       onfocusProductName.sendKeys(productName);
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
       productpage.inputWritereview().sendKeys("review by qa, barang barang barang barang barang barang barang barang barang barang barang barang barang bagus barang bagus barang bagus barang bagus barang bagus barang bagus barang bagus barang bagus barang bagus barang bagus barang bagus barang bagus barang bagus barang bagus barang bagus barang bagus");
       productpage.nextStep3().click();
       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       
       //step 4
       productpage.inputPrice().click();
       productpage.inputPrice().sendKeys("100000");
       productpage.inputDescription().click();
       productpage.inputDescription().sendKeys("huba huba");
       productpage.clickSubmit().click();
       
       asser.waitPageDetail();
       
       UrlPageDetail = driver.getCurrentUrl();
       System.out.println(UrlPageDetail);
       if (UrlPageDetail.contains("/edp/wardah/")) {//asert contain expected text
    	   System.out.println("pass");
       } else {
    	   System.out.println("fail");
       }
       
       String breadcrumb = proddet.findBreadcrumb().getText();
       System.out.println(breadcrumb);
       assertTrue(driver.findElement(By.cssSelector("#top-page > div.jsx-2093859422.contain-cover > div")).getText().contains("EDP"));
       
       String pname = proddet.findProductName().getText();
       System.out.println(pname);
       assertTrue(proddet.findProductName().getText().contains(pname));
       
       String bname = proddet.findBrandName().getText();
       System.out.println(bname);
       assertTrue(proddet.findBrandName().getText().contains(bname));
       
       //proccess comment
       proddet.clickComment().click();
       asser.waitPageReviewDesc();
       proddet.findCommentField().sendKeys("comment 1");
       Thread.sleep(2000);
       
       proddet.clickPostComment().click();
       Thread.sleep(2000);
       
       WebElement getCloseProDesc= proddet.closeModal();
       Actions actCloseProDesc = new Actions(driver);
       actCloseProDesc.moveToElement(getCloseProDesc).click().build().perform();
       
//       main = driver.findElement(By.cssSelector("div[class='jsx-3475087559']"));
//       main = driver.findElement(By.cssSelector("div[class='jsx-3475087559 modal-review']"));
//       main = driver.findElement(By.cssSelector("div[class='='jsx-3475087559]"));
//       main = driver.findElement(By.cssSelector("div[class='='jsx-3475087559 modal-feed-scroll']"));
//       main = driver.findElement(By.cssSelector("div[class='jsx-3475087559 modal-feed-outer']"));
//       main = driver.findElement(By.cssSelector("div[class='jsx-3475087559 modal-review-cv']"));
//       asser.waitPageReviewDesc();
       
       
//       proddet.findCommentField().sendKeys("comment 1");
//       proddet.clickPostComment().click();
       
       //logout
       WebElement getLogin= home.pointUserLoginHeader(); //xpath megamenu nya  
       Actions actLogin = new Actions(driver);
       actLogin.moveToElement(getLogin).perform();
		
       (new WebDriverWait(driver, 3)).until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Logout")));
       WebElement clickLoginLogout1= driver.findElement(By.linkText("Logout"));//xpath sub megamenu nya
       actLogin.moveToElement(clickLoginLogout1).click().perform();
       
       asser.waitPageDetail();
       
       //login again
       proddet.clickLoginProdDet().click();
       UrlLogin = driver.getCurrentUrl();
       Assert.assertEquals(UrlLogin, "http://account.femaledaily.net/" );
		
       logpro.fillusername().sendKeys("qapras");
       logpro.fillpassword().sendKeys("test123");
       logpro.clickbuttonlogin().click();
		
       asser.loggedInAfterLogout();
       
       proddet.clickComment().click();
//       proddet.clickAddComment().click();
//       
       asser.waitPageReviewDesc();
       proddet.clickAddComment().click();
       proddet.findNextCommentField().sendKeys("comment 2");
       Thread.sleep(2000);
      
       proddet.clickPostNextComment().click();
	
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
