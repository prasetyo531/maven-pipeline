package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

public class homepage_dua {

    public RemoteWebDriver driver=null;

    @FindBy(className="i[class='jsx-696978944 icon-ic_close close'\"")
    WebElement tooltip;

    @FindBy(how = How.XPATH, using = "//*[@id='__next']/div/div/div[1]/div/div[1]/div[2]/div/a\"")
    WebElement clicklogin;//xpath = "//*[@id='__next']/div/div/div[1]/div/div[1]/div[2]/div/a"

    //tooltip
//	By tooltip=By.cssSelector("i[class='jsx-696978944 icon-ic_close close'");

    // hamburger element
    By hamburger=By.xpath("//*[@id='__next']/div/div/div[1]/div/div[1]/div[1]/span");
    By reviews=By.linkText("Reviews");
    //

    By homepage=By.xpath("//*[@id='__next']/div/div/div[1]/a");
    By footerBrand=By.linkText("Brands");

    By joinletter=By.xpath("/html/body/div[4]/div/div/div[2]/p[2]/a");
    By joinletterReviewPage=By.cssSelector("body > div:nth-child(6) > div > div > div.jsx-3828308350.modal-join-content-right > p:nth-child(3) > a");
    By pointaddproduct=By.cssSelector("div[class='gbheader-add-area']");
    By pointloginlogout=By.cssSelector("#__next > div > div > div.jsx-1986071017.gbheader > div.jsx-1986071017.gbheader-right > div.gbheader-userprofile");
    By clickaddproduct=By.linkText("Add Product");
    //	By clicklogin=By.xpath("//*[@id='__next']/div/div/div[1]/div/div[1]/div[2]/div/a");
    By searchelement=By.xpath("//*[@id='__next']/div/div/div[2]/div[2]/form/input");
    By menuBody=By.cssSelector("#__next > div > div > div.jsx-746878661.gtmenu > div.jsx-746878661.gtmenu-menu-main > div.jsx-746878661.gtmenu-menu-left > div > div > div:nth-child(2) > a");
    By menuHair=By.cssSelector("#__next > div > div > div.jsx-746878661.gtmenu > div.jsx-746878661.gtmenu-menu-main > div.jsx-746878661.gtmenu-menu-left > div > div > div:nth-child(1) > a");
    By menuSkincare=By.cssSelector("#__next > div > div > div.jsx-746878661.gtmenu > div.jsx-746878661.gtmenu-menu-main > div.jsx-746878661.gtmenu-menu-left > div > div > div:nth-child(3) > a");
    By findaddreview=By.cssSelector("#__next > div > div > div.jsx-1787593642.home-content > div.jsx-1787593642.home-column.margin-bottom-30 > div.jsx-1787593642.home-one-quarter > div.jsx-1787593642.home-reviews-content > button");

    public homepage(RemoteWebDriver driver) {
        // TODO Auto-generated constructor stub

        this.driver=driver;

    }

    public void closeTooltip(){

        tooltip.click();
    }

    public WebElement Hamburger(){

        return driver.findElement(hamburger);
    }

    public WebElement letmejoinletter(){

        return driver.findElement(joinletter);
    }

    public WebElement letmejoinletter2(){

        return driver.findElement(joinletterReviewPage);
    }

    public WebElement clickMenuReview(){

        return driver.findElement(reviews);
    }

    public WebElement getMenuBody(){

        return driver.findElement(menuBody);
    }

    public WebElement getMenuHair(){

        return driver.findElement(menuHair);
    }

    public WebElement getMenuSkincare(){

        return driver.findElement(menuSkincare);
    }

    public WebElement getAddProduct(){

        return driver.findElement(pointaddproduct);
    }

    public WebElement clickAddProduct(){

        return driver.findElement(clickaddproduct);
    }

    //login
    public void clickLogin(){

        clicklogin.click();
    }
}