package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

public class login {
	
	public RemoteWebDriver driver=null;

	By username=By.cssSelector("input[placeholder='Email / Username']");
	By password=By.cssSelector("input[placeholder='Password']");
	By rememberme=By.xpath("//*[@id='__next']/div/div/div[2]/div/form/div[4]/div[1]/div/span");
	By forgotPassword=By.linkText("Forgot Password?");
	By emailForgotPassword=By.cssSelector("input[placeholder='Email']");
	By sendEmailForgotPass=By.cssSelector("input[value='SEND AN EMAIL']");
	By warningMesssage=By.xpath("//*[@id='__next']/div/div/div[2]/div/form/div[1]");
	By buttonlogin=By.cssSelector("input[value='Login']");
	By buttonloginFb=By.cssSelector("input[value='Login with Facebook']");
	
	
	By createaccount=By.cssSelector("input[value='Create Account']");
	By emailReg=By.cssSelector("input[placeholder='Email']");
	By usernameReg=By.cssSelector("input[placeholder='Username']");
	By confirmPasswordReg=By.cssSelector("input[placeholder='Confirm Password']");
	By checklistAgree=By.cssSelector("span[data-element-id='register-checkbox']");
	By syaratKondisi=By.linkText("Syarat & Kondisi");
	By createAccountRegisterPage=By.cssSelector("input[value='create account']");
	
	By clickfacebook=By.cssSelector("input[value='Login with Facebook']");
	
	public login(RemoteWebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
		
	}
	
	public WebElement fillusername(){
		
		return driver.findElement(username);
	}
	
	public WebElement fillpassword(){
		
		return driver.findElement(password);
	}
	
	public WebElement clickForgotPassword(){
		
		return driver.findElement(forgotPassword);
	}
	
	public WebElement clicButtonSendEmailForgotPassword(){
		
		return driver.findElement(sendEmailForgotPass);
	}
	
	public WebElement clickbuttonlogin(){
		
		return driver.findElement(buttonlogin);
	}
	
	//register page
	public WebElement clickCreateAccount(){
		
		return driver.findElement(createaccount);
	}
	
	public WebElement fillEmail(){
		
		return driver.findElement(emailReg);
	}
	
	public WebElement fillUsername(){
		
		return driver.findElement(usernameReg);
	}
	
	public WebElement fillPassword(){
		
		return driver.findElement(password);
	}
	
	public WebElement fillConfirmPasword(){
		
		return driver.findElement(confirmPasswordReg);
	}
	
	public WebElement tickAggrement(){
		
		return driver.findElement(checklistAgree);
	}
	
	public WebElement syaratKondisi(){
		
		return driver.findElement(syaratKondisi);
	}
	
	public WebElement clickCreateAccountRe(){
		
		return driver.findElement(createAccountRegisterPage);
	}
	
	public WebElement getWarningRegister(){
		
		return driver.findElement(warningMesssage);
	}
	
	public WebElement fillEmailForgotPass(){
		
		return driver.findElement(emailForgotPassword);
	}
	
	public WebElement GetWarningMessage(){
		
		return driver.findElement(warningMesssage);
	}	
	
	public WebElement registerFacebook(){
		
		return driver.findElement(clickfacebook);
	}
}

