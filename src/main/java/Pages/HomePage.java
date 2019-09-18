package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    private WebDriver driver;
    private WebElement element;
    private WebDriverWait wait ;

    @FindBy(xpath = "//div[@class='evnt-platform-header']//a[contains(text(),'Events')]")
    WebElement eventsLink;

    public void clickOnEventsTab()  {
      try{  Thread.sleep(5000);
        eventsLink.click();}
      catch(Exception e){

      }
    }

    public HomePage (WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


}
