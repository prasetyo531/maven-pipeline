package base;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import resources.controller;
import resources.support;

import java.io.FileInputStream;
import java.io.IOException;
import org.testng.annotations.*;
import pageObjects.*;
import java.net.URL;
import java.util.Date;
import java.util.Properties;
import java.util.logging.Level;

public class testBase {

    public static Logger log = LogManager.getLogger(support.class.getName());

    public static RemoteWebDriver driver= null;
    public static WebElement main= null;
    public static Properties prop=null;
    public String UrlLogin = null;
    public String UrlPageDetail = null;
    public String UrlProdDetPage3 = null;
    public String UrlProdDetPagePrev = null;
    public String UrlProdDetPageNext = null;
    //ensure the geckodriver located in same folder with selenium server
    public static String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    public static String workingDir = System.getProperty("user.dir");

    public testBase(){
        try{
            prop = new Properties();
            FileInputStream fis=new FileInputStream(workingDir+"//src_controller//resources//data.properties");
            prop.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static final RemoteWebDriver getDriver(String browser) throws IOException {

        prop= new Properties();
        FileInputStream fis=new FileInputStream(workingDir+"//src_controller//resources//data.properties");

        prop.load(fis);
        String url1=prop.getProperty("machine1");

        return new RemoteWebDriver(new URL(url1), getBrowserCapabilities(browser));
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

    private static DesiredCapabilities getBrowserCapabilities(String browserType) {
        switch (browserType) {
            case "firefox":
                System.out.println("Opening firefox driver");
                FirefoxProfile profile = new FirefoxProfile();
//			try {
//				JavaScriptError.addExtension(profile);
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}

                return DesiredCapabilities.firefox();
            case "chrome":
                System.out.println("Opening chrome driver");
                DesiredCapabilities capabilities = DesiredCapabilities.chrome();
                LoggingPreferences loggingprefs = new LoggingPreferences();
                loggingprefs.enable(LogType.BROWSER, Level.ALL);
                capabilities.setCapability(CapabilityType.LOGGING_PREFS, loggingprefs);
                capabilities.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true); //handle http
                capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true); //handle ssl

                //WindowsUtils.killByName("");

                return DesiredCapabilities.chrome();
            case "IE":
                System.out.println("Opening IE driver");
                return DesiredCapabilities.internetExplorer();
            default:
                System.out.println("browser : " + browserType + " is invalid, Launching Firefox as browser of choice..");
                return DesiredCapabilities.firefox();
        }
    }

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

    public void ExtractJSLogs() {
        LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
        for (LogEntry entry : logEntries) {
            System.out.println(new Date(entry.getTimestamp()) + " " + entry.getLevel() + " " + entry.getMessage());
        }
    }

    public static void initialization() throws IOException, InterruptedException {
        String testenv=prop.getProperty("testlocation");
        String platform = prop.getProperty("platformName");
        String serverLoc = prop.getProperty("server");
        String portNumber = prop.getProperty("port");
    }

    @BeforeTest
    @Parameters({ "browser" })
    public void setUp(String browser) throws IOException {
        System.out.println("*******************");
        driver = controller.getDriver(browser);

    }

    @AfterMethod
    public void tearDown() {
        if(driver!=null) {
            System.out.println("Closing browser");
            //driver.close();
        }
    }

}
