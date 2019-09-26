package Steps.web;

import Steps.web.page.GeneralEventsPage;
import Steps.web.page.HomePage;
import Steps.web.page.InstaPage;
import Utilities.UIUtilities;
import mobileUtlity.WebDriverWrapper;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class LogInSteps {

    @Autowired
    WebDriverWrapper driver;

    @Autowired
    UIUtilities utilities ;

    HomePage homePage;

    GeneralEventsPage eventsPage;

    InstaPage Instapage;

    @Given("i login to the $site")
    public void givenILoginToTheSite(@Named("site") String site) {

        driver.getWebDriver().get(site);
        driver.getWebDriver().manage().window().maximize();
        utilities.waitForPageLoad( driver.getWebDriver(),30);
        utilities.takeScreenShot( driver.getWebDriver());
    }


    @Given("I click on events tab")
    public void givenIClickOnEventsTab() {
        System.out.println("Title of the page is"+ driver.getWebDriver().getCurrentUrl());
        homePage.clickOnEventsTab();
        utilities.waitForPageLoad( driver.getWebDriver(),30);
        System.out.println("Title of the page is"+ driver.getWebDriver().getCurrentUrl());


    }

    @Given("click on More Filters option")
    public void givenClickOnMoreFiltersOption() {
        utilities.waitForPageLoad( driver.getWebDriver(),60);
       if (eventsPage.verifyFilerOptionIsPresent()){
           eventsPage.clickOnFilerOption();
       }
    }

    @Given("click on past events")
    public void givenClickOnPastEvents() {
        eventsPage.clickOnPastEvents();
        utilities.waitForPageLoad( driver.getWebDriver(),60);
        utilities.scrollFullPage( driver.getWebDriver());
        utilities.takeScreenShot( driver.getWebDriver());
    }

    @Given("I click on posts tab")
    public void givenIClickOnPostsTab() {
        Instapage.closebutton();
        Instapage.clickOnPosts();
        utilities.waitForPageLoad( driver.getWebDriver(),10);
    }

    @Given("wait till all the posts loaded")
    public void givenWaitTillAllThePostsLoaded() {
        //utilities.scrollFullPage(driver);
    }

    @Then("get all posts likes and name")
    public void thenGetAllPostsLikesAndName() {

        utilities.scrollFullPage( driver.getWebDriver());

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
