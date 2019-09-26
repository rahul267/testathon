package mobileUtlity;

import Framework.BrowserDriver.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class WebDriverWrapper {

    public ThreadLocal<WebDriver> driverDeleget = new ThreadLocal();
    private String BUTTON_XPATH = "//android.widget.Button[@text='%s']";
    private String TEXT_XPATH = "//android.widget.TextView[@text='%s']";

    @Value("${waitTime:1000}")
    long Wait_Time;

    @Value(("${app.noReset:true}"))
    boolean appReset;

    @Value("${web.Browser}")
    private String webBrowser;

    public WebDriver getWebDriver() {
        WebDriver webDriver = driverDeleget.get();
        if (webDriver == null) {
            driverDeleget.set(BrowserFactory.getDriver(webBrowser));
            webDriver = driverDeleget.get();
        }
        return webDriver;
    }


    public WebElement waitForVisibilityOf(By locator) {
        WebDriverWait wait = new WebDriverWait(getWebDriver(), Wait_Time);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    private WebElement waitForClickabilityOf(By locator) {
        return waitForClickabilityOf(locator, Wait_Time);
    }

    private WebElement waitForClickabilityOf(By locator, long waitTime) {
        WebDriverWait wait = new WebDriverWait(getWebDriver(), waitTime);
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void clickOnButtonByText(String text) {
        waitForClickabilityOf(By.xpath(String.format(BUTTON_XPATH, text))).click();
    }

    public void clickOnTextViewByText(String text) {
        waitForClickabilityOf(By.xpath(String.format(TEXT_XPATH, text))).click();
    }

    public void close() {
        if (getWebDriver() != null)
            getWebDriver().close();
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
        getWebDriver().get(url);
    }

    public void scrollUp() {
        JavascriptExecutor jse = (JavascriptExecutor) getWebDriver();
        jse.executeScript("scroll(0, +250);");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        getWebDriver().close();
    }

}

