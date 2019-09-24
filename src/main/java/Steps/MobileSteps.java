package Steps;

import mobileUtlity.MobileDriverWrapper;
import org.jbehave.core.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.net.MalformedURLException;

@Component
@Lazy
public class MobileSteps {

    @Autowired
    private MobileDriverWrapper mobileDriver;

    @Then("I click on Text button $text")
    public void clickOnButtonWithText(@Named("text") String text) {
        mobileDriver.clickOnButtonByText(text);
    }

    @Given("I click on Text View $text")
    public void clickOnTextViewWithText(@Named("text") String text) {
        mobileDriver.clickOnTextViewByText(text);
    }

    @Given("I click if button $text available wait for $time sec")
    public void clickOnButtonWithTextIfAvailable(@Named("text") String text,
                                                 @Named("time") long time) {
        mobileDriver.clickOnButtonByTextIfAvailable(text, time);
    }

    @Given("I click if TextView $text available wait for $time sec")
    public void clickOnTextViewWithTextIfAvailable(@Named("text") String text,
                                                   @Named("time") long time) {
        mobileDriver.clickOnTextViewByTextIfAvailable(text, time);
    }

    @Given("I close app")
    public void closeApp() {
        mobileDriver.closeApp();
    }

    @Given("I relaunch app")
    public void relaunchApp() {
        mobileDriver.relaunchApp();
    }

    @Given("I Open Web $webUrl in Mobile Browser")
    public void openBrowser(@Named("webUrl") String webUrl) {
        mobileDriver.openWebPage(webUrl);
    }
}
