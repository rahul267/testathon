package Utilities;

import Steps.ApiTestSteps.GetEventPageDetailsSteps;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

public class UIUtilities {

    private static final Logger log = LoggerFactory.getLogger(GetEventPageDetailsSteps.class);

public void waitForPageLoad(WebDriver driver,int waitTime){
    WebDriverWait wait = new WebDriverWait(driver, waitTime);
    wait.until(new ExpectedCondition<Boolean>() {
        public Boolean apply(WebDriver driver) {
            return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
        }
    });
}
    public void waitForElement(WebDriver driver, String element, int waitTime){
        WebDriverWait wait = new WebDriverWait(driver, waitTime);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(element)));
    }
public void takeScreenShot(WebDriver driver){

    log.info("Taking screen shot of the page");

    File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    try {

        FileUtils.copyFile(screenshotFile, new File("D:\\TestAthonGitHub\\testathon\\src\\main\\resources\\snapshot.jpg"));
    }
    catch(IOException e){
        e.getMessage();
    }
}
    public void scrollToElement(WebDriver driver){
        ((JavascriptExecutor) driver)
                .executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

}
