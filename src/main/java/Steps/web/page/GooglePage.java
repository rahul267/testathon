package Steps.web.page;

import Utilities.UIUtilities;
import com.google.errorprone.annotations.FormatMethod;
import mobileUtlity.WebDriverWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.util.List;

@Component
@Lazy
public class GooglePage {
    @Autowired
    WebDriverWrapper webDriverWrapper;

    @Autowired
    UIUtilities utilities ;
    @FindBy(xpath = "//input[contains(@class,'gLFyf gsfi')]")
    WebElement searchField;

    @FindBy(xpath="//div[@class='FPdoLc VlcLAe']//input[contains(@value,'Google Search')]")
    WebElement googleSearchButton;

    @FindBy(xpath="//div[contains(@id,'rso')]//cite[contains(text(),'https://www.facebook.com › ... › Community › STeP-IN Forum')]")
    WebElement stepinLink;
    String stepin_Link="//div[contains(@id,'rso')]//cite[contains(text(),'https://www.facebook.com › ... › Community › STeP-IN Forum')]";
    Actions action= new Actions(webDriverWrapper.getWebDriver());
@FindBy(xpath = "//a[contains(@id,'expanding_cta_close_button')]")
WebElement notNow;

@FindBy(xpath = "//span[contains(text(),'Posts')]")
WebElement posts;

@FindBy(xpath = "//span[text()='Next']")
WebElement next;

String postsLink="//span[contains(text(),'Posts')]";
    public GooglePage(@Autowired WebDriverWrapper webDriverWrapper){
        PageFactory.initElements(webDriverWrapper.getWebDriver(),this);
    }

    public void Search(String testData){
        utilities.waitForPageLoad(webDriverWrapper.getWebDriver(),30);
        searchField.sendKeys(testData);
        googleSearchButton.click();
        utilities.waitForPageLoad(webDriverWrapper.getWebDriver(),30);
    }
    public void verifyUserOnGooglePage(){

    }

    public void clickOnLink(){
        List<WebElement> li= webDriverWrapper.getWebDriver().findElements(By.xpath("//div[@class='g']//div[@class='r']//cite"));

        boolean flag=true;
        viewPage();
        utilities.waitForPageLoad(webDriverWrapper.getWebDriver(), 40);
        popUp();
    }
public void popUp(){
    ((JavascriptExecutor) webDriverWrapper.getWebDriver()).executeScript("window.scrollTo(0, document.body.scrollHeight);");
    //  Thread.sleep(2000);
    webDriverWrapper.waitForVisibilityOf(By.xpath("//div[@class='uiScaledImageContainer _62ui']"));
    webDriverWrapper.waitForVisibilityOf(By.xpath("//a[contains(@id,'expanding_cta_close_button')]"));
    notNow.click();
}
    public void clickOnPostsTab(){
        ((JavascriptExecutor) webDriverWrapper.getWebDriver()).executeScript("arguments[0].scrollIntoView(true);",posts);
        webDriverWrapper.waitForVisibilityOf(By.xpath(postsLink));
        posts.click();
    }
    public void viewPage(){
        String source=webDriverWrapper.getWebDriver().getPageSource();
        if(source.contains("25000")){
            webDriverWrapper.waitForVisibilityOf(By.xpath(stepin_Link));
            stepinLink.click();
        }
        else
            action.moveToElement(next).click().build().perform();

    }

}
