package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;

import io.restassured.RestAssured;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class support {

	public static RemoteWebDriver driver= null;
	public static WebElement main= null;
	public static String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	
	
	public void getFailedScreenshot(String result) throws IOException{
		
		driver = (RemoteWebDriver) new Augmenter().augment(driver);
		
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		    FileUtils.copyFile(srcFile, new File("//Users//mac//Documents//File//Screenshot automation//Fail//skrin.png"));
		
	}
	
	public class HttpResponseCode {
		 
	    public int httpResponseCodeViaGet(String url) {
	            return RestAssured.get(url).statusCode();
	    }
	 
	    public int httpResponseCodeViaPost(String url) {
	        return RestAssured.post(url).statusCode();
	    }
	}
	
	public void getResponse() {
	    
	    int response = new HttpResponseCode().httpResponseCodeViaPost("https://fabelio.com/checkout/");{
		
		if(response == 302){
		 System.out.println(response + " " + "is redirect");
		} if(response == 200){
		 System.out.println(response + " "+ "is ok");	
		} else {
		 System.out.println(response + " "+ "is internal server error");
			}
	     }
    	}
	
	public static String randomAlphaNumeric(int count) {
		StringBuilder builder = new StringBuilder();
		while (count-- != 0) {
		int character = (int)(Math.random()*ALPHA_NUMERIC_STRING.length());
		builder.append(ALPHA_NUMERIC_STRING.charAt(character));
		}
		return builder.toString();
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
	
	public static String createRandom(int Digits) {
        String result = new String();
        Random rand = new Random();
        for (int i = 0; i < Digits; i++)
        {
            result = result + rand.nextInt(9);
        }
        return result;
    }
	
	@DataProvider	  
	public Object[][] existingCust() throws Exception {
	     
	FileInputStream filepath = new FileInputStream("//Users//mac//Documents//Automation//mavenjob//Automation-Master//Workbook1.xls");

	Workbook wb = Workbook.getWorkbook(filepath);
	Sheet sheet = wb.getSheet("existing");

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
	
	}
