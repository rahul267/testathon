package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InstaPage {

    private WebDriver driver;
    private WebElement element;
    private WebDriverWait wait ;

    public InstaPage (WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[text()='Posts']")
    WebElement posts;

    @FindBy(xpath="//span[contains(@aria-label,'Close')]")
    WebElement close;
    public void clickOnPosts(){
        posts.click();
    }
public void closebutton(){
close.click();
}

}
