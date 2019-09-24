package Steps.UiSteps;

import Enums.Browser;
import Framework.BrowserDriver.BrowserFactory;
import Pages.GeneralEventsPage;
import Pages.HomePage;
import Pages.InstaPage;
import Utilities.UIUtilities;
import org.jbehave.core.annotations.BeforeStories;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LogInSteps {

    WebDriver driver;
    UIUtilities utilities = new UIUtilities();
    HomePage homePage;
    GeneralEventsPage eventsPage;
    InstaPage Instapage;
   @BeforeStories
    public void beforeStory() {
        if (driver == null)
            driver = BrowserFactory.getDriver(Browser.FIREFOX);
         homePage = new HomePage(driver);
         eventsPage = new GeneralEventsPage(driver);
       Instapage = new InstaPage(driver);
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
        utilities.scrollFullPage(driver);
        utilities.takeScreenShot(driver);
    }

    @Given("I click on posts tab")
    public void givenIClickOnPostsTab() {
        Instapage.closebutton();
        Instapage.clickOnPosts();
        utilities.waitForPageLoad(driver,10);
    }

    @Given("wait till all the posts loaded")
    public void givenWaitTillAllThePostsLoaded() {
        //utilities.scrollFullPage(driver);
    }

    @Then("get all posts likes and name")
    public void thenGetAllPostsLikesAndName() {

        utilities.scrollFullPage(driver);

        /*List<WebElement> li= driver.findElements(By.xpath("//div[contains(@style,'flex-direction')]/div"));
        System.out.println("Size:"+li.size());
        utilities.scrollToElement(driver,li.get(li.size()-1));
        List<WebElement> li1= driver.findElements(By.xpath("//div[contains(@style,'flex-direction')]/div"));*/
        /*Set<String> s=new HashSet<String>();
        int initial=0, latest=0;
        while(true){
            //initial=driver.findElements(By.xpath("//div[contains(@style,'flex-direction')]/div")).size();
            List<WebElement> li= driver.findElements(By.xpath("//div[contains(@style,'flex-direction')]/div"));
            System.out.println("Size:"+li.size());

          //  utilities.scrollToElement(driver,li.get(i));
            latest=driver.findElements(By.xpath("//div[contains(@style,'flex-direction')]/div")).size();
            for(int i=1;i<=li.size();i++){
                for(int j=1;j<=3;j++){

                    System.out.println(driver.findElement(By.xpath("//div[contains(@style,'flex-direction')]/div["+i+"]/div["+j+"]//img")).getAttribute("src"));
                    s.add(driver.findElement(By.xpath("//div[contains(@style,'flex-direction')]/div["+i+"]/div["+j+"]//img")).getAttribute("src"));
                }

            }
            if(!driver.findElement(By.xpath("//div[contains(@style,'flex-direction')]/div["+(latest+1)+"]")).isDisplayed()){
                break;
            }

        }
        System.out.println("List sizze:: "+s.size());*/
    }
}
