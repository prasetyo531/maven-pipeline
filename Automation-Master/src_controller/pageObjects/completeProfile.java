package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

public class completeProfile {
	
	public RemoteWebDriver driver=null;

	//birthdate
	By dob_month=By.xpath("//*[@id='birthday']/div[2]/div/div[1]");
	By dob_date=By.xpath("//*[@id='birthday']/div[2]/div/div[2]");
	By dob_year=By.xpath("//*[@id='birthday']/div[2]/div/div[3]");
	By btdob_next=By.xpath("//*[@id='birthday']/div[2]/button[2]");
	By btdob_back=By.xpath("//*[@id='birthday']/div[2]/button[1]");
	
	//skin_type
	By skintype_normal=By.cssSelector("div[data-value='4']");
	By skintype_dry=By.cssSelector("div[data-value='3']");
	By skintype_combination=By.cssSelector("div[data-value='5']");
	By skintype_oily=By.cssSelector("div[data-value='7']");
	By btstype_back=By.xpath("//*[@id='skin-type']/div[2]/button[1]");
	By btstype_next=By.xpath("//*[@id='skin-type']/div[2]/button[2]");
	
	//skin_tone
	By skintone_light=By.cssSelector("div[data-value='1']");
	By skintone_mediumlight=By.cssSelector("div[data-value='2']");
	By skintone_medium=By.cssSelector("div[data-value='3']");
	By skintone_mediumdark=By.cssSelector("div[data-value='6']");
	By skintone_dark=By.cssSelector("div[data-value='7']");
	By btstone_back=By.xpath("//*[@id='skin-tone']/div[2]/button[1]");
	By btstone_next=By.xpath("//*[@id='skin-tone']/div[2]/button[2]");
	
	//skin_undertone 
	By skinundertone_cool=By.cssSelector("div[data-value='1']"); 
	By skinundertone_neutral=By.cssSelector("div[data-value='2']");
	By skinundertone_warm=By.cssSelector("div[data-value='3']");
	By btsutone_back=By.xpath("//*[@id='skin-undertone']/div[2]/button[1]");
	By btsutone_next=By.xpath("//*[@id='skin-undertone']/div[2]/button[2]");
	
	//hair_type
	By hairtype_wavy=By.cssSelector("div[data-value='1']");
	By hairtype_straight=By.cssSelector("div[data-value='2']");
	By hairtype_curly=By.cssSelector("div[data-value='3']");
	By bthairtype_back=By.xpath("//*[@id='hair-type']/div[2]/button[1]");
	By bthairtype_next=By.xpath("//*[@id='hair-type']/div[2]/button[2]");
	
	//hair_color
	By haircolor_yes=By.cssSelector("div[data-value='1']");
	By haircolor_no=By.cssSelector("div[data-value='2']");
	By bthaircolor_back=By.xpath("//*[@id='colored-hair']/div[2]/button[1]");
	By bthaircolor_next=By.xpath("//*[@id='colored-hair']/div[2]/button[2]");
	
	//hijab
	By hijab_yes=By.cssSelector("div[data-value='1']");
	By hijab_no=By.cssSelector("div[data-value='2']");
	By bthijab_back=By.xpath("//*[@id='hijaber']/div[2]/button[1]");
	By bthijab_next=By.xpath("//*[@id='hijaber']/div[2]/button[2]");
	
	//skin_concerns
	By skincon_acne=By.cssSelector("div[data-value='3']");
	By skincon_scars=By.cssSelector("div[data-value='11']");
	By skincon_bwheads=By.cssSelector("div[data-value='14']");
	By skipchooseskin=By.xpath("//*[@id='skin-concern']/p[2]/span/a");
	By btskincon_back=By.xpath("//*[@id='skin-concern']/div[2]/button[1]");
	By btskincon_next=By.xpath("//*[@id='skin-concern']/div[2]/button[2]");
	
	//body_concerns
	By bodycon_acne=By.cssSelector("div[data-value='6']");
	By bodycon_cellulite=By.cssSelector("div[data-value='5']");
	By bodycon_dryness=By.cssSelector("div[data-value='3']");
	By skipchoosebody=By.xpath("//*[@id='body-concern']/p[2]/span/a");
	By btbodycon_back=By.xpath("//*[@id='body-concern']/div[2]/button[1]");
	By btbodycon_next=By.xpath("//*[@id='body-concern']/div[2]/button[2]");
	
	//hair_concerns
	By haircon_damaged=By.cssSelector("div[data-value='8']");
	By haircon_dandruf=By.cssSelector("div[data-value='1']");
	By haircon_dryness=By.cssSelector("div[data-value='3']");
	By skipchoosehair=By.xpath("//*[@id='hair-concern']/p[2]/span/a");;
	By bthaircon_back=By.xpath("//*[@id='hair-concern']/div[2]/button[1]");
	By bthaircon_next=By.xpath("//*[@id='hair-concern']/div[2]/button[2]");
	
	//summary page
	By addphoto=By.xpath("//*[@id='summary']/form/div[1]/div[1]/div[2]/div/span");
	By fullname=By.cssSelector("input[data-element-id='desktop-taste-input-field']");
	By dobsummary=By.xpath("//*[@id='summary']/form/div[1]/div[1]/div[3]/a");
	By location=By.cssSelector("div[class='Select-placeholder'");
	By phoneno=By.cssSelector("input[placeholder='Phone Number'");
	By bio=By.xpath("//*[@id='summary']/form/div[1]/div[1]/div[4]/div[1]/div/textarea");
	By favbrand=By.cssSelector("div[class='Select-placeholder']");
	By finish=By.cssSelector("input[data-element-id='button-red']");
	
	//edit beauty profile
	By edit_skintype=By.xpath("//*[@id='summary']/form/div[1]/div[2]/div[1]/div[1]/p/a");
	By edit_skintone=By.xpath("//*[@id='summary']/form/div[1]/div[2]/div[1]/div[2]/p/a");
	By edit_skinuntone=By.xpath("//*[@id='summary']/form/div[1]/div[2]/div[1]/div[3]/p/a");
	By edit_hairtype=By.xpath("//*[@id='summary']/form/div[1]/div[2]/div[2]/div[1]/p/a");
	By edit_colhair=By.xpath("//*[@id='summary']/form/div[1]/div[2]/div[2]/div[2]/p/a");
	By edit_hijaber=By.xpath("//*[@id='summary']/form/div[1]/div[2]/div[2]/div[3]/p/a");
	
	//edit beauty concern
	By edit_skincon=By.xpath("//*[@id='summary']/form/div[1]/div[3]/div/div[1]/p/a");
	By edit_bodcon=By.xpath("//*[@id='summary']/form/div[1]/div[3]/div/div[2]/p/a");
	By edit_haircon=By.xpath("//*[@id='summary']/form/div[1]/div[3]/div/div[3]/p/a");
	
	//find_friends
	By btn_done=By.cssSelector("input[data-element-id='button-red'");
	
	//beauty journey
	By btn_startmybeautyjourney=By.cssSelector("input[data-element-id='button-red'");
	
	public completeProfile(RemoteWebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
		
	}
	
	//birthday page
	public WebElement filldatedob(){
		
		return driver.findElement(dob_date);
	}
	
	public WebElement fillmonthdob(){
		
		return driver.findElement(dob_month);
	}
	
	public WebElement fillyeardob(){
		
		return driver.findElement(dob_year);
	}

	public WebElement clicknextdob(){
		
		return driver.findElement(btdob_next);
	}
	
	//skin_type page
	public WebElement choosenormal(){
		
		return driver.findElement(skintype_normal);
		
	}
	
	public WebElement clicknextskin_type(){
		
		return driver.findElement(btstype_next);
	}
	
	//skin_tone page
	public WebElement chooselight(){
		
		return driver.findElement(skintone_light);
	}
	
	public WebElement clicknextskin_tone(){
		
		return driver.findElement(btstone_next);
	}
	
	//skin_undertone
	public WebElement choosecool(){
		
		return driver.findElement(skinundertone_cool);
	}
	
	public WebElement clicknextskin_undertone(){
		
		return driver.findElement(btsutone_next);
	}
	
	//hair type
	public WebElement choosewavy(){
		
		return driver.findElement(hairtype_wavy);
	}
	
	public WebElement clicknexthair_type(){
		
		return driver.findElement(bthairtype_next);
	}
	
	//hair_color
	public WebElement choosecoloredhair_yes(){
		
		return driver.findElement(haircolor_yes);
	}
	
	public WebElement clicknexthair_color(){
		
		return driver.findElement(bthaircolor_next);
	}
	
	//hijab
	public WebElement choosewearhijab_yes(){
		
		return driver.findElement(hijab_yes);
	}

	public WebElement clicknexthijab_yes(){
		
		return driver.findElement(bthijab_next);
	}
	
	//skin_concerns
	public WebElement chooseskinacne(){
		
		return driver.findElement(skincon_acne);
	}
	
	public WebElement fillthislaterskin(){
		
		return driver.findElement(skipchooseskin);
	}
	
	public WebElement clicknextskin_concern(){
		
		return driver.findElement(btskincon_next);
	}
	
	//body_concerns
	public WebElement choosebodyacne(){
		
		return driver.findElement(bodycon_acne);
	}
	
	public WebElement fillthislaterbody(){
		
		return driver.findElement(skipchoosebody);
	}
	
	public WebElement clicknextbody_concern(){
		
		return driver.findElement(btbodycon_next);
	}
	
	//hair_concerns
	public WebElement choosedamaged(){
		
		return driver.findElement(haircon_damaged);
	}
	
	public WebElement fillthislaterhair(){
		
		return driver.findElement(skipchoosehair);
	}
	
	public WebElement clicknexthair_concern(){
		
		return driver.findElement(bthaircon_next);
	}
	
	//-------------summary page--------------------------------------
	public WebElement clickuploadphoto(){
		
		return driver.findElement(addphoto);
		
	}
	
	public WebElement fillfullname(){
		
		return driver.findElement(fullname);
		
	}
	
	public WebElement clickdob(){
		
		return driver.findElement(dobsummary);
		
	}
	
	public WebElement clicklocation(){
		
		return driver.findElement(location);
		
	}
	
	public WebElement fillphoneno(){
		
		return driver.findElement(phoneno);
		
	}

	public WebElement fillbio(){
	
		return driver.findElement(bio);
	
	}

	public WebElement choosefavbrand(){
	
		return driver.findElement(favbrand);
	
	}
	
	public WebElement clickfinishprofile(){
		
		return driver.findElement(finish);
	
	}
	
	public WebElement clickdonefindfriends(){
		
		return driver.findElement(btn_done);
	
	}
	
	public WebElement clickstartjourney(){
		
		return driver.findElement(btn_startmybeautyjourney);
	
	}
	
	//-------------------choosen detail skin----------------
	public WebElement editskintype(){
		
		return driver.findElement(edit_skintype);
		
	}
	
	public WebElement editskintone(){
		
		return driver.findElement(edit_skintone);
		
	}
	
	public WebElement editskinutone(){
		
		return driver.findElement(edit_skinuntone);
		
	}
	
	public WebElement edithairtype(){
		
		return driver.findElement(edit_hairtype);
		
	}
	
	public WebElement editcolhair(){
		
		return driver.findElement(edit_colhair);
		
	}
	
	public WebElement edithijaber(){
		
		return driver.findElement(edit_hijaber);
		
	}
	
	public WebElement editskincon(){
		
		return driver.findElement(edit_skincon);
		
	}
	
	public WebElement editbodcan(){
		
		return driver.findElement(edit_bodcon);
		
	}
	
	public WebElement edithaircon(){
		
		return driver.findElement(edit_haircon);
		
	}

	public String getTextLocationField() {
		// TODO Auto-generated method stub
		return driver.findElement(edit_haircon).getText();
	}
	
}
