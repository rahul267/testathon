package Steps.web;

import mobileUtlity.MobileDriverWrapper;
import mobileUtlity.WebDriverWrapper;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class WebCommonSteps {

    @Autowired
    private WebDriverWrapper webDriverWrapper;

    @Given("I Open $WebUrl in Browser")
    public void openUrl(@Named("WebUrl") String webUrl) throws InterruptedException {
        webDriverWrapper.getWebDriver().get(webUrl);
        Thread.sleep(10000);
    }

}
