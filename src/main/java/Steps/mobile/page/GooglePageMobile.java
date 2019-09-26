package Steps.mobile.page;

import mobileUtlity.MobileDriverWrapper;
import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class GooglePageMobile {
    private String searchElementXpath="//*[@id=\"tsf\"]//input[@type ='search']";
    private String searchButtonXpath="//*[@id=\"tsf\"]/div[2]/div[1]/div[1]/button[2]";
    private String searchResultTextContainsPath = "//*[contains(text(),'STeP-IN Forum')]";
    @Autowired
    private MobileDriverWrapper mobileDriverWrapper;
    public boolean isPageLoaded(){
        return mobileDriverWrapper.waitForVisibilityOf(By.xpath(searchElementXpath)).isDisplayed();
    }

    public void searchKeyword(String keyword){
        mobileDriverWrapper.waitForVisibilityOf(By.xpath(searchElementXpath)).sendKeys(keyword);
        mobileDriverWrapper.waitForVisibilityOf(By.xpath(searchButtonXpath)).click();
    }

    public void clickOnResultContainText(String text) {
        mobileDriverWrapper.waitForVisibilityOf(By.xpath(String.format(searchResultTextContainsPath,text))).click();
    }

    public boolean elementAppeardWhichContainText(String text){
        mobileDriverWrapper.scrollDown();
       return mobileDriverWrapper.waitForVisibilityOf(By.xpath(String.format("//*[contains(text(),'%s')]",text))).isDisplayed();
    }
}
