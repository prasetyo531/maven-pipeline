package assertObject;

import static org.testng.Assert.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class assertAddProduct {
	
public RemoteWebDriver driver= null;
	
	public assertAddProduct(RemoteWebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
		
	}
	
	//---------------add product
	public void attentionmodal(){
		(new WebDriverWait(driver, 5)).until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[value='Yes, I’m sure'")));
	}
	
	public void buttonnext1enable(){
		(new WebDriverWait(driver, 5)).until(ExpectedConditions.elementToBeClickable(By.id("addproduct-button-next")));
	}
	

}
