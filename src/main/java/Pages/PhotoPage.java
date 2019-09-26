package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class PhotoPage {

    private WebDriver driver;
    private WebElement element;

    @FindBy(xpath = "//span[contains(text(),'Photos')]")
    WebElement photoLink;

    @FindBy(xpath = "//div[contains(text(),'See All')]")
    WebElement seeAll;

    @FindBy(xpath = "//div[@class='_3rte']")
    WebElement listOfAlbum;

    @FindBy(xpath = "//div[@class='_3rte']/a[2]/div/div")
    WebElement albumName;

    @FindBy(xpath = "//div[@class='_3rte']/div[2]")
    WebElement photoCount;




    public PhotoPage() { }

    public PhotoPage(WebDriver driver) {
       // wait =  new WebDriverWait(driver, 20);
        this.driver = driver;
        PageFactory.initElements(driver, this);


    }

    public List<String> getAlbumDetails()
    {
        clickPhotoLink();
        clickOnSeeAll();
        return getAlbumNameAndPhotoCount();
    }
    public void clickPhotoLink()
    {
        photoLink.click();
    }

    public void clickOnSeeAll()
    {
        seeAll.click();
    }

    public List<String> getAlbumNameAndPhotoCount()
    {
        List<String> albumDetails = new ArrayList<>();

        List<WebElement> albumNameList = driver.findElements(By.xpath("//div[@class='_3rte']"));
        List<WebElement> photoCOuntList = driver.findElements(By.xpath("//div[@class='_3rte']/div[2]"));

        for (WebElement ele: albumNameList)
        {
            albumDetails.add(ele.getText());
            System.out.println(ele.getText());

        }

        return albumDetails;

    }



}
