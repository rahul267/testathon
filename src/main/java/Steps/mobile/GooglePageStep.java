package Steps.mobile;

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
public class GooglePageStep {

    @Autowired
    private GooglePage googlePage;

    @Then("Google Page is Loaded")
    public void googlePageLoaded(){
        Assertions.assertThat(googlePage.isPageLoaded()).isTrue();
    }

    @When("I Search for keyword $keyword")
    public void iSearchForKeyword(@Named("keyword") String keyword){
        googlePage.searchKeyword(keyword);

    }

    @Then("I expect search results has result which contains text $text")
    public void searchResultContains(@Named("text") String text){
        Assertions.assertThat(googlePage.elementAppeardWhichContainText(text)).isTrue();
    }

    @Given("I click on Result which contains text $text")
    public void clickOnSearchResult(@Named("text") String text){
        googlePage.clickOnResultContainText(text);
    }

}
