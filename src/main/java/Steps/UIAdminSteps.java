package Steps;

import Enums.Browser;
import Framework.BrowserDriver.BrowserFactory;
import Pages.AdminPage;
import Pages.EventGeneralPage;
import Pages.EventTemplateChooser;
import Pages.EventsPage;
import Utilities.ContextVariable;
import org.jbehave.core.annotations.AfterStories;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.openqa.selenium.WebDriver;

public class UIAdminSteps {
    WebDriver driver;
    AdminPage adminPage;
    EventsPage eventsPage;
    EventTemplateChooser eventsPageSecond;
    EventGeneralPage eventGeneralPage;


    public UIAdminSteps() {
    }

    @AfterStories
    public void afterStory() {
        if (driver != null)
            driver.close();
    }

    @Given("i login to Login to events platform as Event Owner Internal")
    public void givenILoginToLoginToEventsPlatformAsEventOwnerInternal() {
        //driver = BrowserFactory.getDriver(Browser.CHROMEGRID); // if you need to run it on grid .
        driver = BrowserFactory.getDriver(Browser.MOBILECHROME);
        driver.get("www.youtube.com");
        System.out.println("Ok");
       // driver = BrowserFactory.getDriver(Browser.CHROME);
        //adminPage = new AdminPage(driver);
       // adminPage.goToApp();
    }

    @Given("Click on Profile photo at the top right corner with Admin")
    public void givenClickOnProfilePhotoAtTheTopRightCornerWithAdmin() {
        adminPage.goToAdmin();
    }

    @Then("Click 'Admin Area'\"")
    public void thenClickAdminArea() {
    }

    @Given("i  Click 'New Event' button")
    public void givenIClickNewEventButton() {
        eventsPage = new EventsPage(driver);
        eventsPage.clickEventButton();
    }


    @Then("Set both start and end dates in the future (start and end dates should be equal)")
    public void thenSetBothStartAndEndDatesInTheFuturestartAndEndDatesShouldBeEqual() {
        eventsPage.fillEventDays("06262039", "06262039");
        eventsPage.fillTextTitle("");
    }

    @Then("Set Empty Template and create event")
    public void thenSetEmptyTemplate() {

        eventsPageSecond = new EventTemplateChooser(driver);
        eventsPageSecond.CompleteCreateEvent();
    }

    @Then("Click Create Event\"")
    public void thenClickCreateEvent() {
        eventsPage.clickNext();
    }

    @Then("Set Public privacy setting")

    public void thenSetPublicPrivacySetting() {
        // PENDING
    }

    @Then("Click Next")
    public void thenClickNext() {

        eventsPage.clickNext();
    }

    @Then("Set any title $title")
    public void setTile(@Named("title") String title) {
        String titleName = title + Long.toHexString(Double.doubleToLongBits(Math.random()));
        ContextVariable.getInstance().saveContextData(title, titleName);
        eventsPage.fillTextTitle(titleName);
    }

    @Then("verify that title  <title> , SuggestedURL <suggestedURL> , StartEndDate <StartEndDate> and PrivacySettings<PrivacySettings> are found")
    public void verifySteps(@Named("title") String title, @Named("suggestedURL") String suggestedURL,
                            @Named("StartEndDate") String StartEndDate, @Named("PrivacySettings") String PrivacySettings) {
        eventGeneralPage = new EventGeneralPage(driver);
        eventGeneralPage.checkFormFields(title, suggestedURL, StartEndDate, StartEndDate, PrivacySettings);

    }

    @Then("Add proposed talk page")
    public void addTalk() {
        eventGeneralPage.addProposedTalkPage();
    }


    @Then("Publish the event")
    public void publishEvent() {
        eventGeneralPage.publishPage();
    }


    @Given("I Store event Id in context variable $EventId")
    public void saveEventID(@Named("EventID") String eventID) {
        eventGeneralPage.saveEventID(eventID);
    }

}
