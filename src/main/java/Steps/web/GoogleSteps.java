package Steps.web;


import Steps.web.page.GooglePage;
import Utilities.UIUtilities;
import mobileUtlity.WebDriverWrapper;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class GoogleSteps {

    @Autowired
    WebDriverWrapper driver;

    @Autowired
    UIUtilities utilities ;

    @Autowired
    GooglePage googlePage;





    @Given("navigate to <google>")
    public void givenNavigateToGoogle(@Named("google") String google) {
        driver.getWebDriver().get(google);
        driver.getWebDriver().manage().window().maximize();
        utilities.waitForPageLoad( driver.getWebDriver(),30);
       // utilities.takeScreenShot( driver.getWebDriver());
    }



    @Given("click on the link with $integer1 test professionals")
    public void givenClickOnTheLinkWithTestProfessionals(int integer1) {
        googlePage.clickOnLink();
        googlePage.clickOnPostsTab();
        try{
            Thread.sleep(5000);
        }catch(Exception e){

        }
    }

    @Given("download the posts with more than $integer1 photos")
    public void givenDownloadThePostsWithMoreThanPhotos(int integer1) {

    }



    @Given("Search for <stepin> forum facebook")
    public void givenSearchForStepinForumFacebook(@Named("stepin") String stepin) {
        System.out.println("Data::"+stepin);
        googlePage.Search(stepin);
        try{
            Thread.sleep(5000);
        }catch(Exception e){

        }
    }
}
