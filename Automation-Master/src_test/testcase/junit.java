package testcase;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class junit {
	
	@Test
	public void testing(){
		System.setProperty("webdriver.chrome.driver", "/Users/mac/Downloads/kerja/fabelio/automatio-fabelio-branch1/automatio-fabelio-branch1/chromedriver2");
		WebDriver driver= new ChromeDriver();
		driver.get("http://fabelio.com");
		
		String strPageTitle = driver.getTitle();
		System.out.print(strPageTitle);
		
		assertEquals("Toko Furniture Online, Minimalis & Murah | Fabelio.com ®", strPageTitle);
		
		
		
	}

}
