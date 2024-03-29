package tc_categoryList;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestResult;
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
import resources.Controller;
import resources.support;

public class browseProductAnotherPage extends Controller {
	
public static Logger log =LogManager.getLogger(support.class.getName());
	
	public static RemoteWebDriver driver= null;
	public static WebElement main= null;
	public static Properties prop=null;
	
	public String UrlPage1 = null;
	public String UrlAfterPage3 = null;
	public String UrlAfterPrev3 = null;
	public String UrlAfterNext2 = null;
	public String firstProduct = null;
	public String MatchProduct = null;

	@BeforeTest
	@Parameters({"browser"})
	public void setUp(String browser, ITestContext tc) throws IOException {
		System.out.println("*******************");
		driver = Controller.getDriver(browser, tc);

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

		driver.manage().window().setSize(new Dimension(1650, 1200));

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
		
		prodlist.clickPage3().click();
		Thread.sleep(2000);
		UrlAfterPage3 = driver.getCurrentUrl();
		Assert.assertEquals(UrlAfterPage3, "http://reviews.femaledaily.net/hand-foot/hand-cream?brand=&order=popular&page=4");
		
		firstProduct = productlist.findProduct1().getAttribute("href");
		System.out.println("link of the first product is:- " +firstProduct);
		
		prodlist.clickPrevPage().click();
		UrlAfterPrev3 = driver.getCurrentUrl();
		Assert.assertEquals(UrlAfterPrev3, "http://reviews.femaledaily.net/hand-foot/hand-cream?brand=&order=popular&page=3");
		
		prodlist.clickNextPage().click();
		Thread.sleep(2000);
		UrlAfterNext2 = driver.getCurrentUrl();
		Assert.assertEquals(UrlAfterNext2, "http://reviews.femaledaily.net/hand-foot/hand-cream?brand=&order=popular&page=5");
		
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(900, document.body.scrollHeight);");
		
		prodlist.toTop().click();
		
		MatchProduct = productlist.findProduct1().getAttribute("href");
		Assert.assertEquals(MatchProduct, "http://reviews.femaledaily.net/hand-foot/hand-cream/loccitane/roses-et-reines-hand-and-nails-cream?tab=reviews&cat=&cat_id=0&age_range=&skin_type=&skin_tone=&skin_undertone=&hair_texture=&hair_type=&order=newest&page=1");
		
		
	}

	@AfterMethod
	public void afterMethod(ITestResult result)
	{
		try
		{
			if(result.getStatus() == ITestResult.SUCCESS)
			{

				//Do something here
				Cookie cookie = new Cookie("zaleniumTestPassed", "true");
				driver.manage().addCookie(cookie);
				System.out.println("passed **********");
			}

			else if(result.getStatus() == ITestResult.FAILURE)
			{
				//Do something here
				Cookie cookie = new Cookie("zaleniumTestPassed", "false");
				driver.manage().addCookie(cookie);
				System.out.println("Failed ***********");

			}

			else if(result.getStatus() == ITestResult.SKIP ){

				System.out.println("Skiped***********");

			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
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
