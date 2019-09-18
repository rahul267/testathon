package Utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UIUtilities {

public void waitForPageLoad(WebDriver driver,int waitTime){
    WebDriverWait wait = new WebDriverWait(driver, waitTime);
    wait.until(new ExpectedCondition<Boolean>() {
        public Boolean apply(WebDriver driver) {
            return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
        }
    });
}


}
