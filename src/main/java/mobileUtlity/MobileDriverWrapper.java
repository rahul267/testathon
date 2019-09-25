package mobileUtlity;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class MobileDriverWrapper {

    private String BUTTON_XPATH = "//android.widget.Button[@text='%s']";
    private String TEXT_XPATH = "//android.widget.TextView[@text='%s']";

    @Value("${waitTime:1000}")
    long Wait_Time;

    @Value(("${app.noReset:true}"))
    boolean appReset;

    @Autowired
    @Qualifier("MobileDriver")
    private AndroidDriver androidDriver;

    public void closeApp() {
        if (androidDriver != null)
            androidDriver.closeApp();
    }

    public void relaunchApp() {
        if (androidDriver != null)
            androidDriver.launchApp();
    }

    public WebElement waitForVisibilityOf(By locator) {
        WebDriverWait wait = new WebDriverWait(androidDriver, Wait_Time);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    private WebElement waitForClickabilityOf(By locator) {
        return waitForClickabilityOf(locator, Wait_Time);
    }

    private WebElement waitForClickabilityOf(By locator, long waitTime) {
        WebDriverWait wait = new WebDriverWait(androidDriver, waitTime);
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void clickOnButtonByText(String text) {
        waitForClickabilityOf(By.xpath(String.format(BUTTON_XPATH, text))).click();
    }

    public void clickOnTextViewByText(String text) {
        waitForClickabilityOf(By.xpath(String.format(TEXT_XPATH, text))).click();
    }

    public void close() {
        if (androidDriver != null)
            androidDriver.close();
    }

    public void clickOnButtonByTextIfAvailable(String text, long waitTime) {
        WebElement element = null;
        try {
            element = waitForClickabilityOf(By.xpath(String.format(BUTTON_XPATH, text)), waitTime);
            element.click();
        } catch (Exception e) {
        }
    }

    public void clickOnTextViewByTextIfAvailable(String text, long waitTime) {
        WebElement element = null;
        try {
            element = waitForClickabilityOf(By.xpath(String.format(TEXT_XPATH, text)), waitTime);
            element.click();
        } catch (Exception e) {
        }
    }
    public void openWebPage(String url) {
        androidDriver.get(url);
    }

    public void scrollUp() {
        JavascriptExecutor jse = (JavascriptExecutor) androidDriver;
        jse.executeScript("scroll(0, +250);");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        androidDriver.close();
    }

}

