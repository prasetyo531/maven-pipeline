package tc_addProduct;

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
import org.testng.ITestContext;
import org.testng.ITestResult;
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
import resources.ConnectDB;
import resources.Controller;
import resources.support;

public class addProductBeforeLoginThenLogin extends Controller {

	public static Logger log =LogManager.getLogger(support.class.getName());

	public static RemoteWebDriver driver= null;
	public static WebElement main= null;
	public static Properties prop=null;

	public String UrlLogin = null;
	public String UrlPageDetail = null;

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

		driver.manage().window().setSize(new Dimension(1650, 1200));

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

		UrlLogin = driver.getCurrentUrl();
		assertTrue(UrlLogin.contains("http://account.femaledaily"));

		logpro.fillusername().sendKeys("putwid");
		logpro.fillpassword().sendKeys("tester123");
		logpro.clickbuttonlogin().click();

		//query check beauty points before add product
		Integer beautyPointsnow =  (Integer) ConnectDB.get_dataPoint("SELECT user_total_point FROM nubr_userappos WHERE username='putwid'", "staging");
		System.out.println(beautyPointsnow);
		Integer beautyPointexpected =  beautyPointsnow+25+10;
		System.out.println(beautyPointexpected);

//		asser.welcomingpopup();

		WebElement getmenu2= home.getAddProduct(); //xpath megamenu nya  
		Actions act2 = new Actions(driver);
		act2.moveToElement(getmenu2).perform();

		asser.addproducttodisplay();
		WebElement clickElement2= home.clickAddProduct(); //xpath sub megamenu nya
		act2.moveToElement(clickElement2).click().perform();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		asserAddProd.attentionmodal();

		//on page add product
		productpage.clickCloseModal().click();

		//step 1
		WebElement focusInputUrl= productpage.insertUrl(); //insert invalid url
		Actions onfocusInputUrl = new Actions(driver);
		onfocusInputUrl.moveToElement(focusInputUrl).click();	//insert valid url
		onfocusInputUrl.sendKeys("https://i.kinja-img.com/gawker-media/image/upload/s--nncnCKWW--/c_scale,f_auto,fl_progressive,q_80,w_800/17hyh5lm9yhjvjpg.jpg");
		onfocusInputUrl.build().perform();

		productpage.clickShowLinkImage();

		asserAddProd.buttonnext1enable();

		JavascriptExecutor je = (JavascriptExecutor) driver;
		WebElement elementnext = (WebElement) productpage.nextStep1();
		je.executeScript("arguments[0].scrollIntoView(true);",elementnext);

//       JavascriptExecutor js = (JavascriptExecutor) driver;
//       js.executeScript("window.scrollBy(0,1000)");

		productpage.nextStep1();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		//step 2
		productpage.selectBrand();

		productpage.selectProductCat();

		productpage.insertProductSubCat();

		productpage.insertProductName();

		productpage.insertProductShade();

		productpage.nextStep2();

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		//step 3
		productpage.chooseRating();
		productpage.choosePackagequality();
		productpage.chooseRepurchase();
		productpage.inputWritereview();
		productpage.nextStep3();

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		//step 4
		productpage.inputPrice();
		productpage.inputPrice();
		productpage.inputDescription();

		//submit
		productpage.clickSubmit();

		UrlPageDetail = driver.getCurrentUrl();
		System.out.println(UrlPageDetail);
		if (UrlPageDetail.contains("/fragrance/edp/wardah")) {//asert contain expected text
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
