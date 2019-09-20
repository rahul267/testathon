package Steps.UiSteps;

import Enums.Browser;
import Framework.BrowserDriver.BrowserFactory;
import Pages.GeneralEventsPage;
import Pages.HomePage;
import Utilities.UIUtilities;
import org.jbehave.core.annotations.BeforeStories;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.openqa.selenium.WebDriver;

public class LogInSteps {

    WebDriver driver;
    UIUtilities utilities = new UIUtilities();
    HomePage homePage;
    GeneralEventsPage eventsPage;
    @BeforeStories
    public void beforeStory() {
        if (driver == null)
            driver = BrowserFactory.getDriver(Browser.FIREFOX);
         homePage = new HomePage(driver);
         eventsPage = new GeneralEventsPage(driver);

    }

    @Given("i login to the $site")
    public void givenILoginToTheSite(@Named("site") String site) {

        driver.get(site);
        driver.manage().window().maximize();
        utilities.waitForPageLoad(driver,30);
        utilities.takeScreenShot(driver);
    }


    @Given("I click on events tab")
    public void givenIClickOnEventsTab() {
        System.out.println("Title of the page is"+driver.getCurrentUrl());
        homePage.clickOnEventsTab();
        utilities.waitForPageLoad(driver,30);
        System.out.println("Title of the page is"+driver.getCurrentUrl());


    }

    @Given("click on More Filters option")
    public void givenClickOnMoreFiltersOption() {
        utilities.waitForPageLoad(driver,60);
       if (eventsPage.verifyFilerOptionIsPresent()){
           eventsPage.clickOnFilerOption();
       }
    }

    @Given("click on past events")
    public void givenClickOnPastEvents() {
        eventsPage.clickOnPastEvents();
        utilities.waitForPageLoad(driver,60);
        utilities.scrollToElement(driver);
        utilities.takeScreenShot(driver);
    }
}
