package resources;

import java.io.FileInputStream;

import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.logging.Level;

import org.openqa.selenium.*;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.BeforeTest;

//import java.io.File;
//import java.text.SimpleDateFormat;
//import java.net.MalformedURLException;
//import java.io.FileNotFoundException;
//import io.restassured.RestAssured;
//import io.restassured.response.Response;
//import java.util.Date;
//import java.util.concurrent.TimeUnit;
//import java.util.function.Consumer;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.firefox.FirefoxOptions;
//import org.openqa.selenium.firefox.FirefoxProfile;
//import org.openqa.selenium.firefox.internal.ProfilesIni;
//import org.openqa.selenium.ie.InternetExplorerDriver;
//import org.openqa.selenium.logging.LogEntries;
//import org.openqa.selenium.logging.LogEntry;
//import org.openqa.selenium.safari.SafariDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.annotations.DataProvider;
//import org.testng.annotations.Parameters;
//import org.testng.annotations.Test;
//import jxl.Cell;
//import jxl.Sheet;
//import jxl.Workbook;
//import jxl.read.biff.BiffException;
//import net.jsourcerer.webdriver.jserrorcollector.JavaScriptError;=
//import org.apache.commons.io.FileUtils;
//import org.apache.commons.lang3.RandomStringUtils;
//import resources.ConnectDB;
//import net.jsourcerer.webdriver.jserrorcollector.JavaScriptError;


public class Controller {

    //ensure the geckodriver located in same folder with selenium server

    public static String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    public static Properties prop=null;
    public static String workingDir = System.getProperty("user.dir");

    public static final RemoteWebDriver getDriver(String browser, ITestContext tc) throws IOException {

        prop= new Properties();
        FileInputStream fis=new FileInputStream(workingDir+"//src_controller//resources//data.properties");

        prop.load(fis);
        String url1=prop.getProperty("machine1");

        return new RemoteWebDriver(new URL(url1), getBrowserCapabilities(browser, tc));
    }

    public static final RemoteWebDriver getDriver2(String browser2) throws IOException {

        prop= new Properties();
        FileInputStream fis=new FileInputStream(workingDir+"//src_controller//resources//data.properties");

        prop.load(fis);
        String url2=prop.getProperty("machine2");

        return new RemoteWebDriver(new URL(url2), getBrowserCapabilities2(browser2));
    }

    public static final RemoteWebDriver getDriver3(String browser3) throws IOException {

        prop= new Properties();
        FileInputStream fis=new FileInputStream(workingDir+"//src_controller//resources//data.properties");

        prop.load(fis);
        String url3=prop.getProperty("machine3");

        return new RemoteWebDriver(new URL(url3), getBrowserCapabilities3(browser3));
    }

    private static DesiredCapabilities getBrowserCapabilities(String browserType, ITestContext tc) {
        switch (browserType) {
            case "firefox":
                System.out.println("Opening firefox driver");
                DesiredCapabilities dcf = DesiredCapabilities.firefox();

                String testName = tc.getCurrentXmlTest().getName();
                dcf.setCapability("name", testName);

                return DesiredCapabilities.firefox();
            case "chrome":
                System.out.println("Opening chrome driver");
                DesiredCapabilities dcc = DesiredCapabilities.chrome();

                LoggingPreferences loggingprefs = new LoggingPreferences();
                loggingprefs.enable(LogType.BROWSER, Level.ALL);
                dcc.setCapability(CapabilityType.BROWSER_NAME, BrowserType.CHROME);
                dcc.setCapability(CapabilityType.LOGGING_PREFS, loggingprefs);
                dcc.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true); //handle http
                dcc.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true); //handle ssl

                String tcname = tc.getCurrentXmlTest().getName();
                dcc.setCapability("name", "myTestName");
                System.out.println(tcname);
                //WindowsUtils.killByName("");
                return DesiredCapabilities.chrome();
            case "safari":
                System.out.println("Opening safari driver");
                DesiredCapabilities capabilitiesSafari = new DesiredCapabilities();
                capabilitiesSafari.setCapability(CapabilityType.BROWSER_NAME, BrowserType.SAFARI);
                capabilitiesSafari.setPlatform(Platform.MAC);
                capabilitiesSafari.acceptInsecureCerts();

                return DesiredCapabilities.safari();
            default:
                System.out.println("browser : " + browserType + " is invalid, Launching Firefox as browser of choice..");

                return DesiredCapabilities.firefox();
        }
    }

//    @BeforeTest
//    private static DesiredCapabilities getBrowserCapabilities(String browserType, ITestContext tc) {
//
//        try{
//            if(browserType.equalsIgnoreCase("chrome")){
//                System.out.println("Opening chrome driver");
//
//                DesiredCapabilities capabilitiesChrome = new DesiredCapabilities();
//                LoggingPreferences loggingprefs = new LoggingPreferences();
//                loggingprefs.enable(LogType.BROWSER, Level.ALL);
//                capabilitiesChrome.setCapability(CapabilityType.BROWSER_NAME, BrowserType.CHROME);
//                capabilitiesChrome.setCapability(CapabilityType.LOGGING_PREFS, loggingprefs);
//                capabilitiesChrome.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true); //handle http
//                capabilitiesChrome.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true); //handle ssl
//
//                String tcname = tc.getCurrentXmlTest().getName();
//                capabilitiesChrome.setCapability("name",tcname);
//                System.out.println(tcname);
//
//                return DesiredCapabilities.chrome();
//            } else if(browserType.equalsIgnoreCase("firefox")){
//                System.out.println("Opening firefox driver");
//
//                DesiredCapabilities capabilitiesFirefox = new DesiredCapabilities();
//                LoggingPreferences loggingprefs = new LoggingPreferences();
//                loggingprefs.enable(LogType.BROWSER, Level.ALL);
//                capabilitiesFirefox.setCapability(CapabilityType.BROWSER_NAME, BrowserType.FIREFOX);
//
//                String tcname = tc.getCurrentXmlTest().getName();
//                capabilitiesFirefox.setCapability("name",tcname);
//                System.out.println(tcname);
//
//                return DesiredCapabilities.firefox();
//            } else if(browserType.equalsIgnoreCase("safari")){
//                System.out.println("Opening safari driver");
//                DesiredCapabilities capabilitiesSafari = new DesiredCapabilities();
//                capabilitiesSafari.setCapability(CapabilityType.BROWSER_NAME, BrowserType.SAFARI);
//                capabilitiesSafari.setPlatform(Platform.MAC);
//                capabilitiesSafari.acceptInsecureCerts();
//
//                String tcname = tc.getCurrentXmlTest().getName();
//                capabilitiesSafari.setCapability("name",tcname);
//                System.out.println(tcname);
//
//                return DesiredCapabilities.safari();
//            }
//
//        }
//        catch(Exception e) {
//            e.printStackTrace();
//        }
//        return DesiredCapabilities.chrome();
//    }

    private static DesiredCapabilities getBrowserCapabilities2(String browserType2) {
        switch (browserType2) {
            case "firefox":
                System.out.println("Opening firefox driver");
                return DesiredCapabilities.firefox();
            case "chrome":
                System.out.println("Opening chrome driver");
                return DesiredCapabilities.chrome();
            case "IE":
                System.out.println("Opening IE driver");
                return DesiredCapabilities.internetExplorer();
            default:
                System.out.println("browser : " + browserType2 + " is invalid, Launching Firefox as browser of choice..");
                return DesiredCapabilities.firefox();
        }
    }

    private static DesiredCapabilities getBrowserCapabilities3(String browserType3) throws IOException {
        switch (browserType3) {
            case "firefox":
                System.out.println("Opening firefox driver");
                return DesiredCapabilities.firefox();
            case "chrome":
                System.out.println("Opening chrome driver");
                return DesiredCapabilities.chrome();
            case "IE":
                System.out.println("Opening IE driver");
                return DesiredCapabilities.internetExplorer();
            default:
                System.out.println("browser : " + browserType3 + " is invalid, Launching Firefox as browser of choice..");
                return DesiredCapabilities.firefox();
        }
    }
}
