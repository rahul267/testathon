package Steps.mobile.page;

import mobileUtlity.MobileDriverWrapper;
import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class FacebookPage {

    @Autowired
    private MobileDriverWrapper mobileDriverWrapper;
    public boolean isPageLoaded(){
        return mobileDriverWrapper.waitForVisibilityOf(By.xpath("//*[@id='header']//u[text()='facebook']"),5).isDisplayed();
    }
}
