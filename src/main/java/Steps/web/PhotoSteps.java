package Steps.web;

import Pages.*;
import Utilities.ContextVariable;
import mobileUtlity.WebDriverWrapper;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PhotoSteps {

    @Autowired
    WebDriverWrapper driver;
    PhotoPage photoPage;



    public PhotoSteps() {
    }



    @Given("I navigate to photo and get details of album")
    @When("I navigate to photo and get details of album")
    public void getAlbumDetails() {
        photoPage = new PhotoPage(driver.getWebDriver());
        photoPage.getAlbumDetails();
    }

}
