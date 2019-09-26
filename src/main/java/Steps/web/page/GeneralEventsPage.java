package Steps.web.page;

import Utilities.UIUtilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
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
