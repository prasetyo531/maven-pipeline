package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

public class addproductpage {
	
	public RemoteWebDriver driver=null;
	
	By yessure=By.cssSelector("input[value='Yes, I’m sure']");
	
	//step1
	By uploadphoto=By.id("addproduct-button-upload");
	By inserturlphoto=By.id("addproduct-image-url");
	By croparea=By.cssSelector("#modal-crop-showed > div > div.ReactCrop.ReactCrop--fixed-aspect > img");
	By btncrop=By.xpath("//*[@id='modal-crop-showed']/div/div[2]/button[1]");
	By show=By.id("addproduct-button-show-image");
	By nextstep1=By.id("addproduct-button-next");
	
	//step2
	By brandname=By.id("react-select-2--value");
	By editbrandname=By.xpath("//*[@id='react-select-7--value']/div[1]");
	By productcat=By.id("react-select-3--value");
	By productsubcat=By.id("react-select-4--value");
	By productsubcat2=By.id("react-select-5--value");
	By productname=By.id("addproduct-input-product-name");
	By productshade=By.id("addproduct-input-product-shade");
	By nextstep2=By.id("addproduct-button-submit");
	
	//step3
	By rating1=By.id("star-1");
	By rating2=By.id("star-2");
	By rating3=By.id("star-3");
	By rating4=By.id("star-4");
	By rating5=By.id("star-5");
	By productpricevalurformoney=By.id("rating-price-1");
	By productpricejsutright=By.id("rating-price-2");
	By productpricexpensive=By.id("rating-price-3");
	By packagequalitypoor=By.id("rating-quality-1");
	By packagequalityimproved=By.id("rating-quality-2");
	By packagequalityokay=By.id("rating-quality-3");
	By packagequalitygood=By.id("rating-quality-4");
	By packagequalityperfect=By.id("rating-quality-5");
	By repurchaseyes=By.id("repurchase-yes");
	By repurchaseno=By.id("repurchase-no");
	By writereview=By.id("review-field");
	By nextstep3=By.id("product-rating-button-submit");
	
	//step4
	By matauang=By.id("react-select-8--value");
	By price=By.id("number-format");
	By descr=By.id("description-field");
	By producttags=By.xpath("//*[@id='top-page']/div[5]/div[2]/form/div[1]/div[5]");
	By submit=By.id("product-info-button-submit");
	
	//header label
	By headerstep1=By.xpath("//*[@id='top-page']/div[2]/div[1]/span");
	By headerstep2=By.xpath("//*[@id='top-page']/div[3]/div[1]/span");
	By headerstep3=By.xpath("//*[@id='top-page']/div[4]/div[1]/span");

	
	public addproductpage(RemoteWebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
		
	}
	
	public WebElement clickCloseModal(){
		
		return driver.findElement(yessure);
	}
	
	//=================================STEP 1======================================//
	
	public WebElement clickUploadPhoto(){
		
		return driver.findElement(uploadphoto);
	}
	
	public WebElement insertUrl(){
		
		return driver.findElement(inserturlphoto);
	}
	
	public WebElement findCropArea(){
		
		return driver.findElement(croparea);
	}
	
	
	public WebElement cropPicture(){
		
		return driver.findElement(btncrop);
	}
	
	public WebElement clickShowLinkImage(){
		
		return driver.findElement(show);
	}
	
	public WebElement nextStep1(){
		
		return driver.findElement(nextstep1);
	}
	
	//=================================STEP 2======================================//
	
	public WebElement selectBrand(){
		
		return driver.findElement(brandname);
	}
	
	public WebElement editBrand(){
		
		return driver.findElement(editbrandname);
	}
	
	public WebElement selectProductCat(){
		
		return driver.findElement(productcat);
	}
	
	public WebElement insertProductSubCat(){
		
		return driver.findElement(productsubcat);
	}
	
	public WebElement insertProductName(){
		
		return driver.findElement(productname);
	}
	
	public WebElement insertProductShade(){
		
		return driver.findElement(productshade);
	}
	
	public WebElement nextStep2(){
		
		return driver.findElement(nextstep2);
	}
	
	//=================================STEP 3======================================//
	
	public WebElement chooseRating(){
		
		return driver.findElement(rating2);
	}
	
	public WebElement choosePackagequality(){
		
		return driver.findElement(packagequalitypoor);
	}
	
	public WebElement chooseRepurchase(){
		
		return driver.findElement(repurchaseyes);
	}
	
	public WebElement inputWritereview(){
		
		return driver.findElement(writereview);
	}
	
	public WebElement nextStep3(){
		
		return driver.findElement(nextstep3);
	}
	
	//=================================STEP 4======================================//
	
	public WebElement selectCurency(){
		
		return driver.findElement(matauang);
	}
	
	public WebElement inputPrice(){
		
		return driver.findElement(price);
	}
	
	public WebElement inputDescription(){
		
		return driver.findElement(descr);
	}
	
	public WebElement inputTags(){
		
		return driver.findElement(producttags);
	}
	
	public WebElement clickSubmit(){
		
		return driver.findElement(submit);
	}
	
	//=================================edit step======================================//
	
	public WebElement editStep1(){
		
		return driver.findElement(headerstep1);
	}
	
	public WebElement editStep2(){
		
		return driver.findElement(headerstep2);
	}
	
	public WebElement editStep3(){
		
		return driver.findElement(headerstep3);
	}
	
}
