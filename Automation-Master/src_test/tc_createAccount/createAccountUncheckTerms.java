package tc_createAccount;

import static org.testng.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import assertObject.assertCompProfile;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import pageObjects.cartPage;
import pageObjects.categoryPage;
import pageObjects.completeProfile;
import pageObjects.ProductPage;
import pageObjects.addproductpage;
import pageObjects.homepage;
import pageObjects.login;
import pageObjects.productdetail;
import pageObjects.productlist;
import resources.Controller;
import resources.support;

public class createAccountUncheckTerms extends Controller {
	
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
	public String messageErrorRegister = null;

	@BeforeTest
	@Parameters({"browser"})
	public void setUp(String browser, ITestContext tc) throws IOException {
		System.out.println("*******************");
		driver = Controller.getDriver(browser, tc);

	}
	
	@Test(dataProvider="usernameless")
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
		
		//login page
		home.clickLogin();
		UrlLogin = driver.getCurrentUrl();
		Assert.assertEquals(UrlLogin, "http://account.femaledaily.net/");
		
		logpro.clickCreateAccount().click();
		
		//register page
		logpro.fillEmail().sendKeys(email);
		logpro.fillUsername().sendKeys(username);
		logpro.fillPassword().sendKeys(password);
		logpro.fillConfirmPasword().sendKeys(confirm_password);
		
		logpro.clickCreateAccountRe().click();
		
		String errormessage = logpro.GetWarningMessage().getText();
		Assert.assertEquals(errormessage, "You must agree to the terms and conditions before register");
		
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
	public Object[][] usernameless() throws Exception {
	     
		FileInputStream filepath = new FileInputStream(workingDir+"//Workbook1.xls");

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
