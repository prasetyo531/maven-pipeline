package workbench;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class cekbrokenlinks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		cekbrokenlinks testBrokenLink = new cekbrokenlinks();
		
		/* Parse out all same domain page links.*/
		List<String> pageLinkList = testBrokenLink.parseOutAllUrlLinksInWebPage("https://devm2.fabelio.com/");
		
		/* Loop in the list to check each link http response status code. */
		int size = pageLinkList.size();
		for(int i=0;i<size;i++)
		{
			String pageUrl = pageLinkList.get(i);
			int httpStatusCode = testBrokenLink.getHttpResponseStatusCode(pageUrl);
		}
	}
	
	private List<String> parseOutAllUrlLinksInWebPage(String pageUrl)
	{
		List<String> retList = new ArrayList<String>();
		
		if(pageUrl!=null && !"".equals(pageUrl.trim()))
		{
			/* Get current page belongs domain. */
			String urlDomain = this.getPageBelongDomain(pageUrl);
			
			WebDriver ffDriver = new FirefoxDriver();
			/* Maximize the Firefox browser window. */
			ffDriver.manage().window().maximize();
			/* Get the web page.*/ 
			ffDriver.get(pageUrl);
			
			/* First parse out all a tag href urls. */
			By byUrlLink = By.tagName("a");
			List<WebElement> aLinkList = ffDriver.findElements(byUrlLink);
			
			if(aLinkList!=null)
			{
				int aLinkSize = aLinkList.size();
				for(int i=0;i<aLinkSize;i++)
				{
					WebElement aLink = aLinkList.get(i);
					String href = aLink.getAttribute("href");
					
					if(href!=null && !"".equals(href.trim()))
					{
						/* Only return same domain page url. */
						if(href.toLowerCase().startsWith("http://"+urlDomain) || href.toLowerCase().startsWith("https://"+urlDomain))
						{
							retList.add(href);
						}
					}
				}
			}
			
			By byImg = By.tagName("img");
			List<WebElement> imgList = ffDriver.findElements(byImg);
			
			if(imgList!=null)
			{
				int imgSize = imgList.size();
				for(int i=0;i<imgSize;i++)
				{
					WebElement imgElement = imgList.get(i);
					String src = imgElement.getAttribute("src");
					
					if(src!=null && !"".equals(src.trim()))
					{
						/* Only return same domain page url. */
						if(src.toLowerCase().startsWith("http://"+urlDomain) || src.toLowerCase().startsWith("https://"+urlDomain))
						{
							retList.add(src);
						}
					}
				}
			}
			
			ffDriver.quit();
			
		}
		
		System.out.println("Parse out url completed successfully.");
		return retList;
	}
	
	/* Return domain value in the pageUrl*/
	private String getPageBelongDomain(String pageUrl)
	{
		String ret = "";
		
		if(pageUrl!=null && !"".equals(pageUrl.trim()))
		{
			pageUrl = pageUrl.toLowerCase();
			int startIdx = 0;
			if(pageUrl.startsWith("http://"))
			{
				startIdx = "http://".length();
			}else if(pageUrl.startsWith("https://"))
			{
				startIdx = "https://".length();
			}
			
			int endIdx = pageUrl.indexOf("/", startIdx);
			
			ret = pageUrl.substring(startIdx, endIdx);
		}
		
		System.out.println("The pageUrl : " + pageUrl + " , belonged domain : " + ret);
		return ret;
	}
	
	/* Get http response status code for a pageUrl connection. */
	private int getHttpResponseStatusCode(String pageUrl)
	{
		int ret = -1;
		
		try
		{
			if(pageUrl!=null && !"".equals(pageUrl.trim()))
			{
				URL urlObj = new URL(pageUrl.trim());
				
				HttpURLConnection httpConn = (HttpURLConnection)urlObj.openConnection();
				
				httpConn.setRequestMethod("HEAD");
				
				httpConn.connect();
				
				ret = httpConn.getResponseCode();
			}
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}finally
		{
			System.out.println("Http Status Code : " + ret +  " , Url : " + pageUrl);
			return ret;
		}
	}

}
