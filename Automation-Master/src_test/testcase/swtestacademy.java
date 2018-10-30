package testcase;

import assertObject.assertHome;
import base.testBase;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.*;
import resources.support;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class swtestacademy extends testBase {

    private support supp;
    private homepage home;
    private login logpro;
    private addproductpage productpage;
    private productlist prodlist;
    private productdetail proddet;
    private assertHome asser;
    private categoryPage cat;
    private ProductPage prod;

    @BeforeMethod
    public void setUp() throws IOException, InterruptedException {
        initialization();

        supp= new support();
        home = new homepage(driver);
        logpro = new login(driver);
        productpage = new addproductpage(driver);
        prodlist = new productlist(driver);
        proddet = new productdetail(driver);
        asser = new assertHome(driver);
        cat = new categoryPage(driver);
        prod = new ProductPage(driver);
    }

    @Test(dataProvider="existingCust")
    public void scenario_satu(String email,String password,String alamat,String telepon) throws Exception {

        if((testBase.prop.getProperty("testlocation")).equalsIgnoreCase("prod")){
            driver.navigate().to("http://femaledaily.com/");  //https://dev.uangteman.com/a/NHeHv
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        } else {
            driver.navigate().to("http://femaledaily.net/");  //https://dev.uangteman.com/a/NHeHv
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }

        driver.manage().window().maximize();
        String strPageTitle = driver.getTitle();
        System.out.println(strPageTitle);

        home.clickLogin().click();
        UrlLogin = driver.getCurrentUrl();
        Assert.assertEquals(UrlLogin, "http://account.femaledaily.net/" );

        logpro.fillusername().sendKeys("putwid");
        logpro.fillpassword().sendKeys("tester123");
        logpro.clickbuttonlogin().click();

        asser.welcomingpopup();

        //homepage
        WebElement getmenu= home.getMenuSkincare(); //xpath megamenu nya
        Actions act = new Actions(driver);
        act.moveToElement(getmenu).perform();

        (new WebDriverWait(driver, 3)).until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Wash-Off")));

        WebElement clickElement= driver.findElement(By.linkText("Wash-Off"));//xpath sub megamenu nya
        act.moveToElement(clickElement).click().perform();

        asser.getDataProductList();

        WebElement getaddreview= prodlist.pointProdHimalayan();
        Actions act2 = new Actions(driver);
        act2.moveToElement(getaddreview).perform();
        (new WebDriverWait(driver, 5)).until(ExpectedConditions.visibilityOfElementLocated(By.linkText("ADD REVIEW")));
        WebElement clickElemen2= driver.findElement(By.linkText("ADD REVIEW"));//xpath sub megamenu nya
        act.moveToElement(clickElemen2).click().perform();

        proddet.clickFilterBySkin().click();
        proddet.chooseSkinOily().click();
        Thread.sleep(2000);

        proddet.clickFilterByAge().click();
        proddet.chooseAge30till34().click();
        Thread.sleep(2000);

        proddet.clickSortProDett().click();
        proddet.chooseMostLike().click();
        Thread.sleep(2000);

        proddet.clickComment().click();
        asser.waitPageReviewDesc();

        Thread.sleep(2000);

        main = driver.findElement(By.cssSelector("div[class='jsx-3475087559']"));
        main = driver.findElement(By.cssSelector("div[class='jsx-3475087559 modal-review']"));
        main = driver.findElement(By.cssSelector("div[class='jsx-3475087559 modal-feed-scroll']"));

        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("window.scrollTo(1306,1158, document.body.scrollHeight);");

        proddet.clickLoadMoreCommentButton().click();

    }

    @DataProvider
    public Object[][] existingCust() throws Exception {

        FileInputStream filepath = new FileInputStream(workingDir+"//Workbook1.xls");

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
