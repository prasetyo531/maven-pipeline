package utility;

import base.testBase;
import base.testBase.*;

public class testUtil extends testBase {

    public static long PAGE_LOAD_TIMEOUT = 30;
    public static long IMPLICIT_WAIT = 30;

    public void switchToFrame(){
        driver.switchTo().frame("fakk");
    }

}
