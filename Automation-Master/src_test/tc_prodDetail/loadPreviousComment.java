package tc_prodDetail;

import static org.testng.Assert.assertTrue;

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


public class loadPreviousComment extends Controller {
	
	String productName = "testing";
	String brandName = "wardah";
	
	public static Logger log =LogManager.getLogger(support.class.getName());
	
	public static RemoteWebDriver driver= null;
	public static WebElement main= null;
	public static Properties prop=null;
	
	public String UrlLogin = null;
	public String UrlPageDetail = null;
	public String UrlProdDetPage3 = null;
	public String UrlProdDetPagePrev = null;
	public String UrlProdDetPageNext = null;

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
		FileInputStream fis=new FileInputStream(workingDir+"//Users//mac//Documents//Automation//mavenjob//Automation-Master//src_controller//resources//data.properties");
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
		
		home.clickLogin().click();
		UrlLogin = driver.getCurrentUrl();
		Assert.assertEquals(UrlLogin, "http://account.femaledaily.net/" );
		
		logpro.fillusername().sendKeys("putwid");
		logpro.fillpassword().sendKeys("tester123");
		logpro.clickbuttonlogin().click();
		
		asser.welcomingpopup();
		
		//homepage
		WebElement getmenu= home.getMenuSkincare(); //xpath megamenu nya
		Actions act = new Actions(driver);
		act.moveToElement(getmenu).perform();
		
		(new WebDriverWait(driver, 3)).until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Wash-Off")));

		WebElement clickElement= driver.findElement(By.linkText("Wash-Off"));//xpath sub megamenu nya
		act.moveToElement(clickElement).click().perform();
		
		asser.getDataProductList();
		
		WebElement getaddreview= prodlist.pointProdHimalayan();
		Actions act2 = new Actions(driver);
		act2.moveToElement(getaddreview).perform();
		(new WebDriverWait(driver, 5)).until(ExpectedConditions.visibilityOfElementLocated(By.linkText("ADD REVIEW")));
		WebElement clickElemen2= driver.findElement(By.linkText("ADD REVIEW"));//xpath sub megamenu nya
		act.moveToElement(clickElemen2).click().perform();
		
		proddet.clickFilterBySkin().click();
		proddet.chooseSkinOily().click();
		Thread.sleep(2000);
		
		proddet.clickFilterByAge().click();
		proddet.chooseAge30till34().click();
		Thread.sleep(2000);
		
		proddet.clickSortProDett().click();
		proddet.chooseMostLike().click();
		Thread.sleep(2000);
		
		proddet.clickComment().click();
	    asser.waitPageReviewDesc();
	    
	    Thread.sleep(2000);
	    
	    main = driver.findElement(By.cssSelector("div[class='jsx-3475087559']"));
	    main = driver.findElement(By.cssSelector("div[class='jsx-3475087559 modal-review']"));
	    main = driver.findElement(By.cssSelector("div[class='jsx-3475087559 modal-feed-scroll']"));
	    
	    JavascriptExecutor js = ((JavascriptExecutor) driver);
	    js.executeScript("window.scrollTo(1306,1158, document.body.scrollHeight);");
	    
	    proddet.clickLoadMoreCommentButton().click();
		
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
	     
		FileInputStream filepath = new FileInputStream(workingDir+"//Users//mac//Documents//Automation//mavenjob//Automation-Master//Workbook1.xls");

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
