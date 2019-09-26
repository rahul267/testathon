package Steps.mobile.page;

import mobileUtlity.MobileDriverWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Lazy
public class FacebookPage {

    @Autowired
    private MobileDriverWrapper mobileDriverWrapper;
    private String xpathForPost ="(//article)[%d]//div[@class='_5rgu _7dc9 _27x0']//a";

    public boolean isPageLoaded(){
        return mobileDriverWrapper.waitForVisibilityOf(By.xpath("//*[@id='header']//u[text()='facebook']"),5).isDisplayed();
    }

    public void clickOnPostLink(){
        mobileDriverWrapper.waitForVisibilityOf(By.xpath("//*[contains(text(),'Post') and  @class='_6zf']")).click();
    }

    public void scrollToPageWhichHasMoreThanFourImage() {
        List<WebElement> elementList;
        for (int i = 1; i < 8; i++) {
            WebElement element = mobileDriverWrapper.waitForVisibilityOf(By.xpath(String.format(xpathForPost, i)));
            elementList = element.findElements(By.tagName("a"));
            if (elementList.size() > 4)
                break;
        }



    }

}
