package Pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;

public class GeneralEventsPage {

    private WebDriver driver;
    private WebElement element;
    private WebDriverWait wait ;

    @FindBy(xpath = "//span[contains(text,'More Filters')]")
    WebElement eventsLink;

    public boolean verifyFilerOptionIsPresent()    {

        return eventsLink.isDisplayed() ? true : false;
    }

    public GeneralEventsPage (WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnFilerOption() {
        eventsLink.click();
        File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

      try {


          FileUtils.copyFile(screenshotFile, new File("D:\\TestAthonGitHub\\testathon\\src\\main\\resources\\snapshot.jpg"));

      }
      catch(IOException e){
          e.getMessage();
      }
    }


}
