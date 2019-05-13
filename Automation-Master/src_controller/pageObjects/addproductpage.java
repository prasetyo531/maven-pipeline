package pageObjects;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;

public class addproductpage {
	
	public RemoteWebDriver driver=null;
	Faker faker = new Faker();
	
	By yessure=By.cssSelector("input[value='Yes, I’m sure']");
	
	//step1
	public @FindBy(id ="addproduct-button-upload") WebElement uploadPhoto;
	public @FindBy(id ="addproduct-button-show-image") WebElement showLink;
	public @FindBy(id ="") WebElement nextstep1;

	//step2
	public @FindBy(id ="react-select-2--value") WebElement brandname;
	public @FindBy(id ="react-select-3--value") WebElement productcat;
	public @FindBy(id ="react-select-4--value") WebElement productsubcat;
	public @FindBy(id ="react-select-5--value") WebElement productsubcat2;
	public @FindBy(id ="addproduct-input-product-name") WebElement productname;
	public @FindBy(id ="addproduct-input-product-shade") WebElement productshade;
	public @FindBy(id ="addproduct-button-submit") WebElement nextstep2;

	By uploadphoto=By.id("addproduct-button-upload");
	By inserturlphoto=By.id("addproduct-image-url");
	By croparea=By.cssSelector("#modal-crop-showed > div > div.ReactCrop.ReactCrop--fixed-aspect > img");
	By btncrop=By.xpath("//*[@id='modal-crop-showed']/div/div[2]/button[1]");
	
	//step2
	By editbrandname=By.xpath("//*[@id='react-select-7--value']/div[1]");
	
	//step3
	public @FindBy(id ="star-1") WebElement rating1;
	public @FindBy(id ="star-2") WebElement rating2;
	public @FindBy(id ="star-3") WebElement rating3;
	public @FindBy(id ="star-4") WebElement rating4;
	public @FindBy(id ="star-5") WebElement rating5;

	public @FindBy(id ="rating-price-1") WebElement productpricevalurformoney;
	public @FindBy(id ="rating-price-2") WebElement productpricejsutright;
	public @FindBy(id ="rating-price-3") WebElement productpricexpensive;
	public @FindBy(id ="rating-quality-1") WebElement packagequalitypoor;
	public @FindBy(id ="rating-quality-2") WebElement packagequalityimproved;
	public @FindBy(id ="rating-quality-3") WebElement packagequalityokay;
	public @FindBy(id ="rating-quality-4") WebElement packagequalitygood;
	public @FindBy(id ="rating-quality-5") WebElement packagequalityperfect;
	public @FindBy(id ="repurchase-yes") WebElement repurchaseyes;
	public @FindBy(id ="repurchase-no") WebElement repurchaseno;
	public @FindBy(id ="review-field") WebElement writereview;
	public @FindBy(id ="product-rating-button-submit") WebElement nextstep3;
	
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

	public addproductpage()throws IOException {

		super();
	}

	public WebElement clickCloseModal(){
		
		return driver.findElement(yessure);
	}
	
	//=================================STEP 1======================================//
	
//	public WebElement clickUploadPhoto(){
//
//		return driver.findElement(uploadPhoto);
//	}

	public addproductpage clickUploadPhoto()throws Exception{

		uploadPhoto.click();

		return new addproductpage();

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
	
	public addproductpage clickShowLinkImage() throws Exception{

		showLink.click();

		return new addproductpage();
	}
	
	public addproductpage nextStep1() throws Exception {

		nextstep1.click();

		return new addproductpage();
	}
	
	//=================================STEP 2======================================//

	public addproductpage selectBrand() throws Exception {

		WebElement focusbrand= brandname; //xpath megamenu nya
		Actions onfocusbrand = new Actions(driver);
		onfocusbrand.moveToElement(focusbrand).click();
		onfocusbrand.sendKeys("warda", Keys.ENTER);
		onfocusbrand.build().perform();

		return new addproductpage();
	}
	
	public WebElement editBrand(){
		
		return driver.findElement(editbrandname);
	}
	
	public addproductpage selectProductCat() throws Exception {

		WebElement focusprodcat= productcat(); //xpath megamenu nya
		Actions onfocusprodcat = new Actions(driver);
		onfocusprodcat.moveToElement(focusprodcat).click();
		onfocusprodcat.sendKeys("frag", Keys.ENTER);
		onfocusprodcat.build().perform();

		return new addproductpage();
	}
	
	public addproductpage insertProductSubCat() throws Exception {

		WebElement focusProductSubCat= productsubcat(); //xpath megamenu nya
		Actions onfocusProductSubCat = new Actions(driver);
		onfocusProductSubCat.moveToElement(focusProductSubCat).click();
		onfocusProductSubCat.sendKeys("edp", Keys.ENTER);
		onfocusProductSubCat.build().perform();

		return new addproductpage();
	}
	
	public addproductpage insertProductName() throws Exception {

		WebElement focusProductName= productname(); //xpath megamenu nya
		Actions onfocusProductName = new Actions(driver);
		onfocusProductName.moveToElement(focusProductName).click();
		onfocusProductName.sendKeys("test name" + faker.name(5).firstName());
		onfocusProductName.build().perform();

		return new addproductpage();
	}
	
	public addproductpage insertProductShade() throws Exception {

		WebElement focusProductShade= productshade(); //xpath megamenu nya
		Actions onfocusProductShade = new Actions(driver);
		onfocusProductShade.moveToElement(focusProductShade).click();
		onfocusProductShade.sendKeys("test shade" + faker.name(5).firstName());
		onfocusProductShade.build().perform();

		return new addproductpage();
	}
	
	public addproductpage nextStep2() throws Exception {

		nextstep2.click();

		return new addproductpage();
	}
	
	//=================================STEP 3======================================//
	
	public addproductpage chooseRating() throws Exception {

		rating2.click();

		return new addproductpage();
	}
	
	public addproductpage choosePackagequality() throws Exception {

		packagequalitypoor.click();

		return new addproductpage();
	}
	
	public addproductpage chooseRepurchase() throws Exception {

		repurchaseyes.click();

		return new addproductpage();
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
