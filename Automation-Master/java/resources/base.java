package resources;

import java.io.File;
import java.io.FileInputStream;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.logging.Level;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import controller.controller.HttpResponseCode;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;

public class base {

	public static WebDriver driver= null;
	public Properties prop;
	
	public WebDriver initializeDriver() throws IOException {
	
		prop= new Properties();
		FileInputStream fis=new FileInputStream("//Users//mac//Downloads//kerja//fabelio//automatio-fabelio-branch1//automatio-fabelio-branch1//E2EProject//src//main//java//resources//data.properties");
		
		prop.load(fis);
		String browserName=prop.getProperty("browser");
		String testlocation=prop.getProperty("testlocation");
		System.out.println(browserName);
		
		if(browserName.equals("chrome")) {
			
			System.setProperty("webdriver.chrome.driver", "/Users/mac/Downloads/kerja/fabelio/automatio-fabelio-branch1/automatio-fabelio-branch1/chromedriver");
	        ChromeOptions options = new ChromeOptions();
	        options.addArguments("--disable-notifications");
	        
	        driver = new ChromeDriver(options);
	        driver.get("http://" + testlocation + ".fabelio.com/");  //https://dev.uangteman.com/a/NHeHv
	        driver.manage().window().maximize(); //pras
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
		}
		else if (browserName.equals("firefox")) {
			
			System.setProperty("webdriver.gecko.driver", "/Users/mac/Downloads/kerja/fabelio/automatio-fabelio-branch1/automatio-fabelio-branch1/geckodriver");
        	FirefoxOptions optionss = new FirefoxOptions();
        	optionss.addArguments("--disable-notifications");        	
        	
        	driver = new FirefoxDriver();
        	FirefoxProfile fp = new FirefoxProfile();
        	
            fp.setPreference("browser.startup.homepage", "about:blank");
            fp.setPreference("startup.homepage_welcome_url", "about:blank");
            fp.setPreference("startup.homepage_welcome_url.additional", "about:blank");
            fp.setPreference("dom.webnotifications.enabled", false);
            fp.setPreference("geo.enabled", false);
            
            driver.get("http://" + testlocation + ".fabelio.com/");
    		driver.manage().window().maximize(); //pras
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            
		}
		else if (browserName.equals("safari")) {
			
			   driver.get("http://" + testlocation + ".fabelio.com/");  //https://dev.uangteman.com/a/NHeHv
               driver.manage().window().maximize(); //pras
               driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            
		}
	
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
		
	
	}
	
	
	public void getScreenshot(String result) throws IOException
	{
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C://test//"+result+"screenshot.png"));
		
	}
	
	
	}
