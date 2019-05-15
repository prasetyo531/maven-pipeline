package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.logging.Level;

import org.openqa.selenium.Platform;
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
    public static String workingDir = System.getProperty("user.dir");

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
                DesiredCapabilities capabilitiesChrome = DesiredCapabilities.chrome();
                LoggingPreferences loggingprefs = new LoggingPreferences();
                loggingprefs.enable(LogType.BROWSER, Level.ALL);
                capabilitiesChrome.setCapability(CapabilityType.LOGGING_PREFS, loggingprefs);
                capabilitiesChrome.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true); //handle http
                capabilitiesChrome.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true); //handle ssl

                //WindowsUtils.killByName("");

                return DesiredCapabilities.chrome();
            case "IE":
                System.out.println("Opening IE driver");
                DesiredCapabilities capabilitiesIE = DesiredCapabilities.internetExplorer();
                capabilitiesIE.setPlatform(Platform.WINDOWS);
                capabilitiesIE.acceptInsecureCerts();
                return DesiredCapabilities.internetExplorer();
            case "safari":
                System.out.println("Opening safari driver");
                DesiredCapabilities capabilitiesSafari = DesiredCapabilities.safari();
                capabilitiesSafari.setPlatform(Platform.MAC);
                capabilitiesSafari.acceptInsecureCerts();
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
                DesiredCapabilities capabilities2Chrome = DesiredCapabilities.chrome();
                LoggingPreferences loggingprefs = new LoggingPreferences();
                loggingprefs.enable(LogType.BROWSER, Level.ALL);
                capabilities2Chrome.setCapability(CapabilityType.LOGGING_PREFS, loggingprefs);
                capabilities2Chrome.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true); //handle http
                capabilities2Chrome.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true); //handle ssl
                return DesiredCapabilities.chrome();
            case "IE":
                System.out.println("Opening IE driver");
                DesiredCapabilities capabilities2IE = DesiredCapabilities.internetExplorer();
                capabilities2IE.setPlatform(Platform.WINDOWS);
                capabilities2IE.acceptInsecureCerts();
                return DesiredCapabilities.internetExplorer();
            case "safari":
                System.out.println("Opening safari driver");
                DesiredCapabilities capabilities2Safari = DesiredCapabilities.safari();
                capabilities2Safari.setPlatform(Platform.MAC);
                capabilities2Safari.acceptInsecureCerts();
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
                DesiredCapabilities capabilities3Chrome = DesiredCapabilities.chrome();
                LoggingPreferences loggingprefs = new LoggingPreferences();
                loggingprefs.enable(LogType.BROWSER, Level.ALL);
                capabilities3Chrome.setCapability(CapabilityType.LOGGING_PREFS, loggingprefs);
                capabilities3Chrome.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true); //handle http
                capabilities3Chrome.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true); //handle ssl
                return DesiredCapabilities.chrome();
            case "IE":
                System.out.println("Opening IE driver");
                DesiredCapabilities capabilities3IE = DesiredCapabilities.internetExplorer();
                capabilities3IE.setPlatform(Platform.WINDOWS);
                capabilities3IE.acceptInsecureCerts();
                return DesiredCapabilities.internetExplorer();
            case "safari":
                System.out.println("Opening safari driver");
                DesiredCapabilities capabilities3Safari = DesiredCapabilities.safari();
                capabilities3Safari.setPlatform(Platform.MAC);
                capabilities3Safari.acceptInsecureCerts();
                return DesiredCapabilities.safari();
            default:
                System.out.println("browser : " + browserType3 + " is invalid, Launching Firefox as browser of choice..");
                return DesiredCapabilities.firefox();
        }
    }
}
