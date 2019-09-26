package Steps.mobile.page;

import mobileUtlity.MobileDriverWrapper;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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
        mobileDriverWrapper.scrollDown();
        mobileDriverWrapper.waitForVisibilityOf(By.xpath("//*[contains(text(),'Post') and  @class='_6zf']")).click();
    }

    public void scrollToPageWhichHasMoreThanFourImageAndDowloadFile() throws IOException, InterruptedException {
        List<WebElement> elementList= null;
        for (int i = 1; i < 8; i++) {
            WebElement element = mobileDriverWrapper.waitForVisibilityOf(By.xpath(String.format(xpathForPost, i)));
            elementList = element.findElements(By.tagName("a"));
            if (elementList.size() > 4)
                break;
            mobileDriverWrapper.scrollDown();
        }
        downloadPhoto(elementList);
    }

    private String processUrl(String text){
        return (text.split(".https\3a //")[1]).split(".jpg")[0]+".jpg";
    }
    public void downloadPhoto(List<WebElement> webElementList) throws IOException {
        int counter = 1;
        for(WebElement element :webElementList) {
            String logoSRC = element.getAttribute("style");
            java.net.URL imageURL = new URL(processUrl(logoSRC));
            BufferedImage saveImage = ImageIO.read(imageURL);
            File imageFile = new File(counter+".jpg");
            ImageIO.write(saveImage, "jpg", imageFile);
            ++counter;
            long size = imageFile.length();
            Assert.assertTrue("File is empty with 0 size ",size > 0);
        }
    }

    public void clickOnPostLinkPhoto() {
        mobileDriverWrapper.scrollDown();
        mobileDriverWrapper.waitForVisibilityOf(By.xpath("//*[contains(text(),'Photo') and  @class='_6zf']")).click();
    }

    public void clickSeeAllLink() {
        mobileDriverWrapper.waitForVisibilityOf(By.xpath("//*[contains(text(),'See All')]")).click();
    }

    public void saveAllPhotoAlbumCount() {
        List<String> albumName = new ArrayList<>();
        List<WebElement> albumNameList = mobileDriverWrapper.getAndroidDriver().findElements( By.xpath("//div[@class='_52je _52jb _52jh']"));
        albumNameList.forEach(element ->{
            albumName.add(element.getText());
        });
    }
}
