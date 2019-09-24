package Pages;

import Utilities.UIUtilities;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class GeneralEventsPage {

    private WebDriver driver;
    private WebElement element;
    private WebDriverWait wait ;
    UIUtilities uiutil=new UIUtilities();
    @FindBy(xpath = "//span[contains(text(),'More Filters')]")
    WebElement eventsLink;
    String filter="//span[contains(text(),'More Filters')]";

    @FindBy(xpath="//span[contains(text(),'Past Events')]")
    WebElement pastEvents;
    @FindBy(xpath="//div[class='evnt-global-loader']")
    WebElement loader;
    String pastEvent="//span[contains(text(),'More Filters')]";
    public boolean verifyFilerOptionIsPresent() {

        try {
            Thread.sleep(10000);
            uiutil.waitForElement(driver, filter, 60);




        } catch (Exception e) {

        }
        return eventsLink.isDisplayed() ? true : false;
    }

    public GeneralEventsPage (WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnFilerOption() {
        eventsLink.click();
    }
    public void clickOnPastEvents() {
        uiutil.waitForElement(driver,pastEvent,60);
        pastEvents.click();
    }

}
