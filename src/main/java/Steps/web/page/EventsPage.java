package Steps.web.page;

import mobileUtlity.WebDriverWrapper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class EventsPage {

    private WebDriverWrapper webDriverWrapper;

    @FindBy(id = "new_event_btn")
    WebElement NewEventButton;

    @FindBy(xpath = "//input[@class= 'uui-form-element large ']")
    WebElement NewEventName;

    @FindBy(xpath = "//input[@name='start']")
    WebElement EventDayStart;
    @FindBy(xpath = "//input[@name='end']")
    WebElement EventDayEnd;

    @FindBy(xpath = "//th[@class='next']")
    WebElement nextMonth;

    @FindBy(xpath = "//td[@class='day']")
    WebElement nextMonthDay;
    WebDriverWait wait ;


    @FindBy(xpath = "//button[@class= 'uui-button lime-green next-button']")
    WebElement Next;

    public EventsPage(@Autowired WebDriverWrapper webDriverWrapper) {
        this.webDriverWrapper = webDriverWrapper;
        PageFactory.initElements(webDriverWrapper.getWebDriver(), this);
    }

    public void clickEventButton()
    {
        NewEventButton.click();
    }

    public void fillTextTitle(String title)
    {
        NewEventName.sendKeys(title);
    }

    public void fillsuggestedURL(String url)
    {

    }
    public void fillEventDays(String title1 , String title2)
    {
        EventDayStart.sendKeys(title1);
        nextMonth.click();
        nextMonthDay.click();

       // EventDayEnd.sendKeys(title2);
    }
    public void clickNext()
    {
       // wait.until(ExpectedConditions.elementToBeClickable(Next)) ;
        Next.click();
    }




}
