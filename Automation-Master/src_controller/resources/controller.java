package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.logging.Level;

import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.os.WindowsUtils;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import resources.ConnectDB;

//import net.jsourcerer.webdriver.jserrorcollector.JavaScriptError;


public class controller {

	//ensure the geckodriver located in same folder with selenium server
	
	
	public static String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	public static Properties prop=null;

	public static final RemoteWebDriver getDriver(String browser) throws IOException {
		
		prop= new Properties();
		FileInputStream fis=new FileInputStream("//Users//mac//Documents//Automation//mavenjob//Automation-Master//src_controller//resources//data.properties");
		
		prop.load(fis);
		String url1=prop.getProperty("machine1");
		
		return new RemoteWebDriver(new URL(url1), getBrowserCapabilities(browser));
	}
	
	public static final RemoteWebDriver getDriver2(String browser2) throws IOException {
		
		prop= new Properties();
		FileInputStream fis=new FileInputStream("//Users//mac//Documents//Automation//mavenjob//Automation-Master//src_controller//resources//data.properties");
		
		prop.load(fis);
		String url2=prop.getProperty("machine2");
		
		return new RemoteWebDriver(new URL(url2), getBrowserCapabilities2(browser2));
	}

	public static final RemoteWebDriver getDriver3(String browser3) throws IOException {
		
		prop= new Properties();
		FileInputStream fis=new FileInputStream("//Users//mac//Documents//Automation//mavenjob//Automation-Master//src_controller//resources//data.properties");
		
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
}
