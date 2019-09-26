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
    String searchButton="//div[@class='FPdoLc VlcLAe']//input[contains(@value,'Google Search')]";
    @FindBy(xpath="//div[contains(@id,'rso')]//cite[contains(text(),'https://www.facebook.com › ... › Community › STeP-IN Forum')]")
    WebElement stepinLink;
    String stepin_Link="//div[contains(@id,'rso')]//cite[contains(text(),'https://www.facebook.com › ... › Community › STeP-IN Forum')]";
   // Actions action= new Actions(webDriverWrapper.getWebDriver());
@FindBy(xpath = "//a[contains(@id,'expanding_cta_close_button')]")
WebElement notNow;

@FindBy(xpath = "//span[contains(text(),'Posts')]")
WebElement posts;

@FindBy(xpath = "//span[text()='Next']")
WebElement next;

@FindBy(xpath="//a[contains(text(),'Log In')]")
WebElement login;

@FindBy(xpath = "//input[@id='email']")
        WebElement userName;
@FindBy(xpath="//input[@id='pass']")
        WebElement password;
@FindBy(xpath = "//button[@id='loginbutton']")
        WebElement loginButton;
String postsLink="//span[contains(text(),'Posts')]";
    public GooglePage(@Autowired WebDriverWrapper webDriverWrapper){
        PageFactory.initElements(webDriverWrapper.getWebDriver(),this);
    }

    public void Search(String testData){
        utilities.waitForPageLoad(webDriverWrapper.getWebDriver(),30);
        searchField.sendKeys(testData);
        try{
        webDriverWrapper.getWebDriver().wait(20);}
        catch(Exception e){

        }
        webDriverWrapper.waitForVisibilityOf(By.xpath(searchButton));
        googleSearchButton.click();
        utilities.waitForPageLoad(webDriverWrapper.getWebDriver(),30);
    }

    public void navigateToCommunity(){
        webDriverWrapper.getWebDriver().navigate().to("https://www.facebook.com/pg/STeP-IN-Forum-2063693617253588/community/");
    }
    public void clickOnLink(){
        navigateToCommunity();
        utilities.waitForPageLoad(webDriverWrapper.getWebDriver(), 40);
        login();
      }

      public void login(){
        login.click();
        utilities.waitForPageLoad(webDriverWrapper.getWebDriver(),30);
        userName.sendKeys("selenium.onlinetutorials@gmail.com");
        password.sendKeys("fbpwd#123");
        loginButton.click();
        utilities.waitForPageLoad(webDriverWrapper.getWebDriver(),30);

      }
public void popUp(){

        try{
            ((JavascriptExecutor) webDriverWrapper.getWebDriver()).executeScript("window.scrollTo(0, document.body.scrollHeight);");
            //  Thread.sleep(2000);
            webDriverWrapper.waitForVisibilityOf(By.xpath("//div[@class='uiScaledImageContainer _62ui']"));
            webDriverWrapper.waitForVisibilityOf(By.xpath("//a[contains(@id,'expanding_cta_close_button')]"));
            notNow.click();
        }catch(Exception e){

        }

}
    public void clickOnPostsTab(){
        ((JavascriptExecutor) webDriverWrapper.getWebDriver()).executeScript("arguments[0].scrollIntoView(true);",posts);
       // popUp();
        webDriverWrapper.waitForVisibilityOf(By.xpath(postsLink));
        posts.click();
    }
    @FindBy(xpath = "(//div[contains(@id,'u_fetchstream_1_2t')]//div[@class='mtm'])]")
    WebElement topPost;
    String top_Post="(//div[contains(@id,'u_fetchstream_1_2t')]//div[@class='mtm'])[1]/div/a/following::div/div/div[contains(text(),'+')]";
    public void selectPost(){
        List<WebElement> we= webDriverWrapper.getWebDriver().findElements(By.xpath(top_Post));
        for(int i=1;i<=we.size();i++){
            int count=webDriverWrapper.getWebDriver().findElements(By.xpath("(//div[contains(@id,'u_fetchstream_1_2t')]//div[@class='mtm'])["+i+"]/div/a/following::div/div/div[contains(text(),'+')]")).size();
            if(count>0){
                WebElement element=webDriverWrapper.getWebDriver().findElement(By.xpath("(//div[contains(@id,'u_fetchstream_1_2t')]//div[@class='mtm'])["+i+"]/div/a/following::div/div/div[contains(text(),'+')]"));
            }


        }
    }
}
