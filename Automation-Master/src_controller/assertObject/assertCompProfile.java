package assertObject;

import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class assertCompProfile {
	
public RemoteWebDriver driver= null;
	
	public assertCompProfile(RemoteWebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
		
	}
	
	//register warning
	public void waitWarningRegister(){
		(new WebDriverWait(driver, 50)).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#__next > div > div > div.jsx-3296557956._1jmxl8o.register > form > div.jsx-3296557956.register-warning > p")));
	}
	
	//register success
	public void registerIsSuccess(){
		(new WebDriverWait(driver, 30)).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='birthday']/div[2]/div/div[1]/div")));
	}
	
	//female daily
	//complete profile
	//skin_type
	public void waitskintypeload(){
		(new WebDriverWait(driver, 50)).until(ExpectedConditions.urlContains("/completing-profile?step=skin_type"));
		
		(new WebDriverWait(driver, 5)).until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[data-value='4']")));
	}
		
		//skin_tone
	public void waitskintoneload(){
		(new WebDriverWait(driver, 50)).until(ExpectedConditions.urlContains("/completing-profile?step=skin_tone"));
		
		(new WebDriverWait(driver, 5)).until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[data-value='1']")));
	}
		
	//skin_undertone
	public void waitskinundertoneload(){
		(new WebDriverWait(driver, 50)).until(ExpectedConditions.urlContains("/completing-profile?step=skin_undertone"));
		
		(new WebDriverWait(driver, 5)).until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[data-value='1']")));
	}
		
	//hair_type
	public void waithairtypeload(){
		(new WebDriverWait(driver, 50)).until(ExpectedConditions.urlContains("/completing-profile?step=hair_type"));
		
		(new WebDriverWait(driver, 5)).until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[data-value='1']")));
	}
		
	//hair_color
	public void waithaircolorload(){
		(new WebDriverWait(driver, 50)).until(ExpectedConditions.urlContains("/completing-profile?step=hair_color"));
		
		(new WebDriverWait(driver, 5)).until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[data-value='2']")));
	}
		
	//hijab
	public void waithijabload(){
		(new WebDriverWait(driver, 50)).until(ExpectedConditions.urlContains("/completing-profile?step=hijab"));
		
		(new WebDriverWait(driver, 5)).until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[data-value='1']")));
	}
		
	//skin_concerns
	public void waitskinconcernsload(){
		(new WebDriverWait(driver, 50)).until(ExpectedConditions.urlContains("/completing-profile?step=skin_concerns"));
		
		(new WebDriverWait(driver, 5)).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='skin-concern']/p[2]/span/a")));
		
		(new WebDriverWait(driver, 5)).until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[data-value='3']")));
	}
		
	//body_concerns
	public void waitbodyconcernsload(){
		(new WebDriverWait(driver, 50)).until(ExpectedConditions.urlContains("/completing-profile?step=body_concerns"));
		
		(new WebDriverWait(driver, 5)).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='body-concern']/p[2]/span/a")));
		
		(new WebDriverWait(driver, 5)).until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[data-value='6']")));
	}
		
	//hair_concerns
	public void waithair_concernsload(){
		(new WebDriverWait(driver, 50)).until(ExpectedConditions.urlContains("/completing-profile?step=hair_concerns"));
		
		(new WebDriverWait(driver, 5)).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='hair-concern']/p[2]/span/a")));
		
		(new WebDriverWait(driver, 5)).until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[data-value='8']")));
	}
		
	//summary page
	public void waitsummaryload(){
		(new WebDriverWait(driver, 50)).until(ExpectedConditions.urlContains("/completing-profile?step=summary"));
		
		(new WebDriverWait(driver, 5)).until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[data-element-id='desktop-taste-input-field']")));
	}
		
	//follow
	public void waitsuggestfollowload(){
		(new WebDriverWait(driver, 50)).until(ExpectedConditions.urlContains("/completing-profile?step=find_friends"));
	}
		
	//start my beuty journey
	public void waitbeautyjourneyload(){
		(new WebDriverWait(driver, 50)).until(ExpectedConditions.urlContains("/completing-profile?step=last_step"));
	}

}
