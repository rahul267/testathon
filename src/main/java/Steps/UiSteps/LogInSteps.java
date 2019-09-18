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
    HomePage homePage = new HomePage(driver);
    GeneralEventsPage eventsPage = new GeneralEventsPage(driver);

    @BeforeStories
    public void beforeStory() {
        if (driver == null)
            driver = BrowserFactory.getDriver(Browser.FIREFOX);
    }

    @Given("i login to the $site")
    public void givenILoginToTheSite(@Named("site") String site) {

        driver.get(site);
        driver.manage().window().maximize();
        utilities.waitForPageLoad(driver,30);
    }


    @Given("I click on events tab")
    public void givenIClickOnEventsTab() {
        homePage.clickOnEventsTab();
        utilities.waitForPageLoad(driver,30);

    }

    @Given("click on More Filters option")
    public void givenClickOnMoreFiltersOption() {
       if (eventsPage.verifyFilerOptionIsPresent()){
           eventsPage.clickOnFilerOption();
       }
    }
}
