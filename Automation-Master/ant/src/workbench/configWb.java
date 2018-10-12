package workbench;

import java.awt.AWTException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.*;
import java.util.Properties;
import java.util.Random;
import org.openqa.selenium.support.ui.WebDriverWait;

import controller.controller;
import controller.configapp;


public class configWb extends configapp{
	
	public WebDriver driver;
	public WebElement main;
	
	//public static String emailwb ="myjne002@gmail.com";
	
	public String sms_auth;
	public String testlocationWb= "staging";
	
	
	public static String getWb() throws IOException {
		
		Properties SetEmail=new Properties();
		FileInputStream browser=new FileInputStream("//Users//prasetyo//Documents//automation//automation-udemy-framework//workspace2//UTFramework//src//workbench//data.properties");
		SetEmail.load(browser);
		String value = SetEmail.getProperty("email");
		return value;
	}
	
	public static String getAuthCode() throws ClassNotFoundException, SQLException {
	    //Accessing driver from the JAR file 
	    Class.forName("com.mysql.jdbc.Driver");
	    //System.out.println("Oracle JDBC driver loaded ok.");

	    Connection con=DriverManager.getConnection("jdbc:mysql://103.58.100.148/utstag2015","qaeng","7y@#ER7654#$%7ytf~!@#$%^87y");
	    //System.out.println("DB Connected Successfuly");

	    Statement stmt = con.createStatement();

	    ResultSet result = stmt.executeQuery("SELECT bua_auth_code FROM bo_auth_log ORDER BY bua_id DESC LIMIT 1;");

	    String account = null;
	    while(result.next()){
	        account = result.getString("bua_auth_code");

	        //System.out.println("BAID: " + account);

	        }
	    con.close();
	    return account;
	}
	
	public static Integer getAppliId() throws ClassNotFoundException, SQLException, IOException {
		//Accessing driver from the JAR file 
	    Class.forName("com.mysql.jdbc.Driver");
	    //System.out.println("Oracle JDBC driver loaded ok.");

	    Connection con=DriverManager.getConnection("jdbc:mysql://103.58.100.148/utstag2015","qaeng","7y@#ER7654#$%7ytf~!@#$%^87y");
	    //System.out.println("DB Connected Successfuly");

	    Statement stmt = con.createStatement();

	    ResultSet result = stmt.executeQuery("SELECT a.apli_id FROM application_data as a INNER JOIN applicant_data as b on a.apli_ap_id=b.ap_id WHERE b.ap_email_address='"+getWb()+"';");

	    Integer account2 = null ;
	    while(result.next()){
	        account2 = result.getInt("apli_id");

	        //System.out.println("BAID: " + account);

	        }
	    con.close();
	    //return account2;
		return account2;
		
	}
	
	public static String getManager() throws ClassNotFoundException, SQLException, IOException {
		//Accessing driver from the JAR file 
	    Class.forName("com.mysql.jdbc.Driver");
	    //System.out.println("Oracle JDBC driver loaded ok.");

	    Connection con=DriverManager.getConnection("jdbc:mysql://103.58.100.148/utstag2015","qaeng","7y@#ER7654#$%7ytf~!@#$%^87y");
	    //System.out.println("DB Connected Successfuly");

	    Statement stmt = con.createStatement();

	    ResultSet result = stmt.executeQuery("SELECT b.bu_name FROM workload_manager AS a INNER JOIN bo_users AS b ON a.bu_id=b.bu_id WHERE a.apli_id='"+getAppliId()+"';");

	    String account3 = null ;
	    while(result.next()){
	        account3 = result.getString("bu_name");

	        //System.out.println("BAID: " + account);

	        }
	    con.close();
	    //return account2;
		return account3;
		
	}
	
	public void startDriver(String browser) throws AWTException {
        switch (browser) {
            case "firefox":

                FirefoxProfile fp = new FirefoxProfile();
                fp.setPreference("browser.startup.homepage", "about:blank");
                fp.setPreference("startup.homepage_welcome_url", "about:blank");
                fp.setPreference("startup.homepage_welcome_url.additional", "about:blank");

                this.driver = new FirefoxDriver(fp);
                this.driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
                driver.manage().window().maximize(); //pras
        
                break;
            
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "/Users/prasetyo/Documents/automation/automation-udemy-framework/workspace2/UTFramework/ant/lib/chromedriver");
                this.driver = new ChromeDriver();
                this.driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
                break;
            default:

                break;
        }
    }
	
	
	public String workbenchLogin(String user) throws ClassNotFoundException, SQLException {
        try {

            this.startDriver("firefox");
            this.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            WebDriverWait wait = new WebDriverWait(driver, 10);

            driver.manage().window().maximize(); //pras
            //Open the page
            this.driver.get("http://" + this.testlocationWb + ".uangteman.com/admin");
            //this.driver.get("localhost:80/uang-teman/admin");
            
            //String sms_code=null;
            
            WebElement main;
            switch (user) {
                case ("finance"):
                    this.driver.findElement(By.name("bu_name")).sendKeys("ddebora_fi");
                    break;
                case ("admin"):     
                    this.driver.findElement(By.name("bu_name")).sendKeys("pras_admin");
                    break;
                case ("staff"):
                    this.driver.findElement(By.name("bu_name")).sendKeys("rendys_staff");
                    break;
                case ("fraudcheck"):
                    this.driver.findElement(By.name("bu_name")).sendKeys("pras_fc");
                    break;
                case ("customerservice"):
                    this.driver.findElement(By.name("bu_name")).sendKeys("ingga");
                    break;
                case ("pras_supermanager"):
                    this.driver.findElement(By.name("bu_name")).sendKeys("pras_supermanager");
                    break;
                case ("supermanager_redho"):
                    this.driver.findElement(By.name("bu_name")).sendKeys("redho");
                    break;       
                case ("fauzan"):
                    this.driver.findElement(By.name("bu_name")).sendKeys("fauzan");
                    break;
                case ("rendi"):
                    this.driver.findElement(By.name("bu_name")).sendKeys("rendi");
                    break;    
                case ("rio"):
                    this.driver.findElement(By.name("bu_name")).sendKeys("rio");
                    break;
                case ("fahmy_manager"):
                    this.driver.findElement(By.name("bu_name")).sendKeys("fahmy_manager");
                    break;   
                case ("eka"):
                    this.driver.findElement(By.name("bu_name")).sendKeys("eka");
                    break; 
                case ("marista"):
                    this.driver.findElement(By.name("bu_name")).sendKeys("marista");
                    break; 
                case ("collection"):
                    this.driver.findElement(By.name("bu_name")).sendKeys("kevincol");
                    break;
              default:
                    throw new Exception("No user");
            }
            this.driver.findElement(By.name("bu_passwd")).sendKeys("testing");
            main = this.driver.findElement(By.cssSelector("button[class='btn btn-orange btn-squared pull-right ladda-button']"));
            main.submit();

			if (!this.testlocationWb.equals("dev")) {
                Thread.sleep(5000);

                //sms_code = (String) config.getfromDatabase("SELECT bua_auth_code FROM bo_auth_log ORDER BY bua_id DESC LIMIT 1;", this.testlocation);
                //sms_auth = (String) config.getfromDatabase("SELECT bua_auth_code FROM bo_auth_log ORDER BY bua_id DESC LIMIT 1;", testlocationWb);
                
                this.driver.findElement(By.name("authcode")).sendKeys(getAuthCode());

                this.driver.findElement(By.cssSelector("button[class='btn btn-bricky btn-squared pull-right ladda-button']")).click();
            }   
            
        } catch (Exception e) {
            System.out.println("TestScript Login-Error: " + e.getMessage());
            
        }  
            return getAuthCode();
        
    }
}