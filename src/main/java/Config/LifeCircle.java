package Config;

import mobileUtlity.MobileDriverWrapper;
import mobileUtlity.WebDriverWrapper;
import org.jbehave.core.annotations.AfterStory;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LifeCircle {

    @Autowired
    WebDriverWrapper webDriverWrapper;

    @Autowired
    MobileDriverWrapper mobileDriverWrapper;

    @AfterStory
    public void afterStory() {
        WebDriver driver = webDriverWrapper.driverDeleget.get();
        if(driver!=null)
            driver.close();
        mobileDriverWrapper.close();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
