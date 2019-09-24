package mobileUtlity;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class MobileDriverWrapper {

    private String BUTTON_XPATH = "//android.widget.Button[@text='%s']";
    private String TEXT_XPATH = "//android.widget.TextView[@text='%s']";

    @Value("${waitTime}")
    long Wait_Time;

    @Value("${app.activityName}")
    String appActivity;


    @Value(("${app.noReset:true}"))
    boolean appReset;

    @Autowired
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
            androidDriver.quit();
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

}

