package controller;

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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
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
import org.testng.annotations.Test;

import controller.controller.HttpResponseCode;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;

public class controller {
	
	public WebDriver driver= null;
	public WebElement main= null;
	String driverPath = "/Users/mac/Documents/download/lib/";
	
	public String testlocation ="qa";
	public String browser ="firefox";
	
	//	<-data test-->
	public String email ="myjne001@gmail.com";
	public String password ="test123";
	public String firstname ="test";
	public String lasttname ="satu";
	
	
	public void waitForElement(String item) {
	    WebDriverWait wait = new WebDriverWait(driver,15);
	    WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("")));
	}
	
	public void getscreenshot() throws Exception 
    {
		File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			 // now copy the  screenshot to desired location using copyFile //method
			FileUtils.copyFile(src, new File("/Users/mac/Downloads/kerja/mono-fidler/"+ timestamp() + ".png"));
			}
			 
			catch (IOException e)
			 {
			  System.out.println(e.getMessage());
			 
			 }
    }
	
	public String timestamp() {
	     return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
	 }
	
	public static void waitSeconds(int secons) {
	    System.out.print("Pausing for " + secons + " seconds: ");
	    try {
	      Thread.currentThread();		
	      int x = 1;
	      while(x <= secons) {
	        Thread.sleep(1000);
	        System.out.print(" " + x );
	        x = x + 1;
	      }
	      System.out.print('\n');
	    } catch (InterruptedException ex) {
	      ex.printStackTrace();
	    }	
	  }
	
	public class HttpResponseCode {
		 
	    public int httpResponseCodeViaGet(String url) {
	            return RestAssured.get(url).statusCode();
	    }
	 
	    public int httpResponseCodeViaPost(String url) {
	        return RestAssured.post(url).statusCode();
	    }
	}
	

	@DataProvider	  
	public Object[][] CustRegistration() throws Exception {
	     
	FileInputStream filepath = new FileInputStream("//Users//mac//Downloads//kerja//fabelio//automatio-fabelio-branch1//workspace2//UTFramework//Workbook1.xls");

	Workbook wb = Workbook.getWorkbook(filepath);
	Sheet sheet = wb.getSheet("datadriven");

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
	
	public void startDriver(String browser) throws InterruptedException {
        switch (browser) {
            case "firefox":
            	
            	System.setProperty("webdriver.gecko.driver", driverPath+"geckodriver");
            	String firebugFilePath = "/Users/mac/Documents/download/lib/JSErrorCollector.xpi";   //path add ons
//            	FirefoxOptions optionss = new FirefoxOptions();
//            	optionss.addArguments("--disable-notifications");        	
            	
            	driver = new FirefoxDriver();
            	FirefoxProfile fp = new FirefoxProfile();
            	
                fp.setPreference("browser.startup.homepage", "about:blank");
                fp.setPreference("startup.homepage_welcome_url", "about:blank");
                fp.setPreference("startup.homepage_welcome_url.additional", "about:blank");
                fp.setPreference("dom.webnotifications.enabled", false);
                fp.setPreference("geo.enabled", false);
                fp.addExtension(new File(firebugFilePath));
                
                if(this.testlocation=="prod"){
                	driver.get("http://fabelio.com/");  //https://dev.uangteman.com/a/NHeHv
                	 driver.manage().window().maximize(); //pras
                     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                	} else {
                		driver.get("http://" + this.testlocation + ".fabelio.com/");  //https://dev.uangteman.com/a/NHeHv
                		driver.manage().window().maximize(); //pras
                        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                	}


                break;
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "/Users/mac/Downloads/kerja/fabelio/automatio-fabelio-branch1/automatio-fabelio-branch1/chromedriver2");
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--disable-notifications");
                
                driver = new ChromeDriver(options);
                driver.get("http://" + this.testlocation + ".fabelio.com/");  //https://dev.uangteman.com/a/NHeHv
                driver.manage().window().maximize(); //pras
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                
                break;
            case "safari":
                this.driver = new SafariDriver();
                
                driver.get("http://" + this.testlocation + ".fabelio.com/");  //https://dev.uangteman.com/a/NHeHv
                driver.manage().window().maximize(); //pras
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                
                	  main = this.driver.findElement(By.cssSelector("div[class='static-page']"));
                	  main = this.driver.findElement(By.cssSelector("div[id='pinjaman-online']"));
        		      main.findElement(By.id("btnAjukanPinjaman")).click();
        		                          
            	default:

                break;
        }
    }
	
	// episode how to deal with reusable code
	public void OpenBrowser() throws IOException, InterruptedException {
		
		this.startDriver(browser);
	}
}