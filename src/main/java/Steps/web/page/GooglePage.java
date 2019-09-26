package Steps.web.page;

import Utilities.UIUtilities;
import mobileUtlity.WebDriverWrapper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class GooglePage {
    @Autowired
    WebDriverWrapper driver;

    @Autowired
    UIUtilities utilities ;
   // private WebDriver driver;
    private WebElement element;
    private WebDriverWait wait ;
}
