package mobileUtlity;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

@Component
@Lazy
public class MobileDriverWrapper {

    @Value("${app.packageName}")
    String appPackage;

    @Value("${waitTime}")
    long Wait_Time;

    @Value("${app.activityName}")
    String appActivity;

    @Value("${device.Name}")
    String deviceName;

    @Value("${device.platformName}")
    String platformName;

    @Value("${appium.server}")
    String appiumServer;

    @Value("${appium.automationName}")
    String automationName;

    @Value("${app.apkPath:AlreadyInstalled}")
    String appApkPath;

    @Value(("${app.noReset:true}"))
    boolean appReset;

    private AndroidDriver androidDriver;
    private DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

    private void setDriverCapabilities() {
        if (!appApkPath.equals("AlreadyInstalled")) {
            if (!(new File(appApkPath).isFile())) {
                throw new RuntimeException("No Such File");
            } else {
                desiredCapabilities.setCapability("app", appApkPath);
            }
        }
        desiredCapabilities.setCapability("deviceName", deviceName);
        desiredCapabilities.setCapability("platformName", platformName);
        desiredCapabilities.setCapability("appPackage", appPackage);
        desiredCapabilities.setCapability("appActivity", appActivity);
        desiredCapabilities.setCapability("automationName", automationName);
        desiredCapabilities.setCapability("noReset", appReset);
    }


    public void launchApplication() throws MalformedURLException {
        setDriverCapabilities();
        androidDriver = new AndroidDriver(new URL(appiumServer), desiredCapabilities);
    }


    public void closeApp() {
        androidDriver.closeApp();

    }

    public void relaunchApp() {
        try {
            androidDriver.launchApp();
        } catch (Exception e) {
        }
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


    private String BUTTON_XPATH = "//android.widget.Button[@text='%s']";
    private String TEXT_XPATH = "//android.widget.TextView[@text='%s']";

    public void openBrowser(String browser) throws MalformedURLException, InterruptedException {
        setDriverCapabilities(browser);
        AndroidDriver driver = new AndroidDriver(new URL(appiumServer), desiredCapabilities);
        driver.get("http://www.youtube.com");
        Thread.sleep(10000);
        System.out.println(
                driver.findElementByXPath("(//*[@id=\"app\"]//ytm-large-media-item//h3)[1]").getText());

        TouchActions action = new TouchActions(driver);
        action.scroll(10, 100);
        action.perform();

        Thread.sleep(10000);
        driver.close();
    }

    private void setDriverCapabilities(String app) {
        if (app.contains("Chrome")) {
            desiredCapabilities.setCapability("deviceName", deviceName);
            desiredCapabilities.setCapability("platformName", platformName);
            desiredCapabilities.setCapability("browserName", "Chrome");
            desiredCapabilities.setCapability("noReset", appReset);
            return;
        }
    }
}

