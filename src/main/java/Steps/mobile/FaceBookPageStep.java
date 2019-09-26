package Steps.mobile;

import Steps.mobile.page.FacebookPage;
import Steps.mobile.page.GooglePage;
import org.assertj.core.api.Assertions;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Lazy
public class FaceBookPageStep {

    @Autowired
    private FacebookPage facebookPage;

    @Then("Facebook Page is Loaded")
    public void faceBookPageLoaded(){
        Assertions.assertThat(facebookPage.isPageLoaded()).isTrue();
    }

    @Given ("I Navigate to Post")
    public void navigateToFaceBook(){
        facebookPage.clickOnPostLink();
    }

    @Given("I Navigate and download to post which has more than 4 images")
    public void navigateToSpecificPost() throws IOException, InterruptedException {
        facebookPage.scrollToPageWhichHasMoreThanFourImageAndDowloadFile();
    }

    @Given("I navigate to photo")
    public void navigateToFaceBookPhoto(){
        facebookPage.clickOnPostLinkPhoto();
    }

    @Given("I click on See All Link")
    public void clickAllLink(){
        facebookPage.clickSeeAllLink();
    }

    @Given("I extract Album and Photos name and count and create a json file")
    public void savePhotoLink(){
        facebookPage.saveAllPhotoAlbumCount();
    }
}