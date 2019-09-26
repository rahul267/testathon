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

@Component
@Lazy
public class FaceBookPageStep {

    @Autowired
    private FacebookPage facebookPage;

    @Then("Facebook Page is Loaded")
    public void faceBookPageLoaded(){
        Assertions.assertThat(facebookPage.isPageLoaded()).isTrue();
    }

}
