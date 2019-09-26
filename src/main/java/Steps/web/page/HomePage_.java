package Steps.web.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class HomePage_ {

    @FindBy(xpath = "text")
    WebElement homePage;

    public HomePage_(@Autowired WebDriver webDriver){
        PageFactory.initElements(webDriver,this);
    }

    public void performActionOnHomePage(){
        System.out.println(homePage.getText());
    }

}
