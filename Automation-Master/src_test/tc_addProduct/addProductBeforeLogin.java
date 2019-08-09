package tc_addProduct;

import static org.openqa.selenium.remote.RemoteWebDriver.*;
import static org.testng.Assert.assertTrue;

import java.io.*;
import java.util.Date;
import java.util.Iterator;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import configTc.ControllerTest;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.CellType;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;

import assertObject.assertAddProduct;
import assertObject.assertHome;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import pageObjects.cartPage;
import pageObjects.categoryPage;
import pageObjects.checkoutPage;
import pageObjects.ProductPage;
import pageObjects.addproductpage;
import pageObjects.homepage;
import pageObjects.login;
import resources.Controller;
import resources.support;
//import configTc.support;

public class addProductBeforeLogin extends Controller {

    public static Logger log = LogManager.getLogger(support.class.getName());

    public RemoteWebDriver driver = null;
    public static WebElement main = null;
    public static Properties prop = null;

    public String UrlLogin = null;

    @BeforeTest
    @Parameters({"browser"})
    public void setUp(String browser, ITestContext suitename) throws IOException {
        System.out.println("*******************");
//        suitename.getCurrentXmlTest().getName();
        driver = Controller.getDriver(browser, suitename);
        System.out.println(suitename);

    }

    @Test(dataProvider = "getDataApply")
    public void scenario_satu(String email, String password, String alamat, String telepon) throws Exception {

        support supp = new support();
        homepage home = new homepage(driver);
        login logpro = new login(driver);
        addproductpage productpage = new addproductpage(driver);

        categoryPage cat = new categoryPage(driver);
        ProductPage prod = new ProductPage(driver);
        cartPage cpage = new cartPage(driver);
        checkoutPage checkout = new checkoutPage(driver);

        assertHome asser = new assertHome(driver);
        assertAddProduct asserAddProd = new assertAddProduct(driver);

        prop = new Properties();
        FileInputStream fis = new FileInputStream(workingDir + "//src_controller//resources//data.properties");
        prop.load(fis);
        String testenv = prop.getProperty("testlocation");

        if (testenv.equalsIgnoreCase("prod")) {
            driver.navigate().to("http://femaledaily.com/");  //https://dev.uangteman.com/a/NHeHv
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        } else {
            driver.navigate().to("http://femaledaily.net/");  //https://dev.uangteman.com/a/NHeHv
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }

        driver.manage().window().setSize(new Dimension(1650, 1200));

        //click hamburger
        home.Hamburger().click();

        home.clickMenuReview().click();
//		asser.waitNewestReview();

        WebElement getmenu = home.getAddProduct(); //xpath megamenu nya
        Actions act = new Actions(driver);
        act.moveToElement(getmenu).perform();

        asser.addproducttodisplay();

        WebElement clickElement= home.clickAddProduct(); //xpath sub megamenu nya
		act.moveToElement(clickElement).click().perform();

		Thread.sleep(3000);

		UrlLogin = driver.getCurrentUrl();
		System.out.println(UrlLogin);
		assertTrue(UrlLogin.contains("account.femaledaily"));

        logpro.fillusername().sendKeys(email);
        logpro.fillpassword().sendKeys(password);
        logpro.clickbuttonlogin().click();
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

    @DataProvider
    public static Object[][] getDataApply(){
        Object[][] data = null;

        //kiri for numbers of times testcase must execute
        //kanan for no parameter you send
        data = new Object[1][4];

        data[0][0]= "myjne013@gmail.com";
        data[0][1]= "test123";
        data[0][2]= "test123";
        data[0][3]= "automationfirst";

        return data;
    }

}