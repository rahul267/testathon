package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    private WebDriver driver;
    private WebElement element;
    private WebDriverWait wait ;

    @FindBy(xpath = "//*[@id=\"app\"]/header/div/div/ul[1]/li[2]/a")


    WebElement eventsLink;

    public void clickOnEventsTab()  {
      try{
          JavascriptExecutor js = (JavascriptExecutor)driver;

          Thread.sleep(5000);
          driver.findElement(By.cssSelector("ul[class*='evnt-navigation navbar-nav'] li:nth-child(2)>a")).click();
        //  js.executeScript("arguments[0].click()",eventsLink);
      }

      catch(Exception e){

      }
    }

    public HomePage (WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


}
