package Config;

import mobileUtlity.WebDriverWrapper;
import org.jbehave.core.annotations.AfterStory;
import org.jbehave.core.model.*;
import org.jbehave.core.reporters.ConsoleOutput;
import org.jbehave.core.reporters.StoryReporter;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class LifeCircle {

    @Autowired
    WebDriverWrapper webDriverWrapper;

    @AfterStory
    public void afterStory(boolean b) {
        WebDriver driver = webDriverWrapper.driverDeleget.get();
        if(driver!=null)
            driver.close();
    }

}
