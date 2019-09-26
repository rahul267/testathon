package Utilities;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
@Lazy
public class UIUtilities {

    private static final Logger log = LoggerFactory.getLogger(UIUtilities.class);

    public void waitForPageLoad(WebDriver driver, int waitTime) {
        WebDriverWait wait = new WebDriverWait(driver, waitTime);
        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            }
        });
    }

    public void waitForElement(WebDriver driver, String element, int waitTime) {
        WebDriverWait wait = new WebDriverWait(driver, waitTime);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(element)));
    }

    public void takeScreenShot(WebDriver driver) {

        log.info("Taking screen shot of the page");

        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {

            FileUtils.copyFile(screenshotFile, new File("D:\\TestAthonGitHub\\testathon\\src\\main\\resources\\snapshot.jpg"));
        } catch (IOException e) {
            e.getMessage();
        }
    }

    public void scrollToElement(WebDriver driver, WebElement element) {
        /*((JavascriptExecutor) driver)
                .executeScript("window.scrollTo(0, document.body.scrollHeight)");*/
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

    }

    public void scollPage(WebDriver driver) {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");
    }


    public void scrollUp(WebDriver driver) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("scroll(0, -250);");
    }
    public void scrollFullPage(WebDriver driver){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Set<String> s=new HashSet<String>();
        HashMap<String,String> hmap=new HashMap<String, String>();
        String likes="",comments="", src="";
        Actions act=new Actions(driver);
        try {
            long lastHeight=((Number)js.executeScript("return document.body.scrollHeight")).longValue();
            while (true) {
                List<WebElement> li= driver.findElements(By.xpath("//div[contains(@style,'flex-direction')]/div"));

                //********************************
                li= driver.findElements(By.xpath("//div[contains(@style,'flex-direction')]/div"));
                System.out.println("List Size::::"+ li.size());
                for(int i=1;i<=li.size();i++){
                    for(int j=1;j<=3;j++){
                      js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//div[contains(@style,'flex-direction')]/div["+i+"]/div["+j+"]//img")));
                        src=driver.findElement(By.xpath("//div[contains(@style,'flex-direction')]/div["+i+"]/div["+j+"]//img")).getAttribute("src");
                        waitForElement(driver,"//div[contains(@style,'flex-direction')]/div["+i+"]/div["+j+"]//img",30);
                        act.moveToElement(driver.findElement(By.xpath("//div[contains(@style,'flex-direction')]/div["+i+"]/div["+j+"]//img"))).perform();
                        Thread.sleep(5000);

                       // System.out.println(driver.findElement(By.xpath("//div[contains(@style,'flex-direction')]/div["+i+"]/div["+j+"]//img")).getAttribute("src"));
                        s.add(driver.findElement(By.xpath("//div[contains(@style,'flex-direction')]/div["+i+"]/div["+j+"]//img")).getAttribute("src"));
                        waitForElement(driver,"//div[contains(@style,'flex-direction')]/div["+i+"]/div["+j+"]//div[@class='qn-0x']/ul/li[1]/span[1]",30);
                        if(driver.findElement(By.xpath("//div[contains(@style,'flex-direction')]/div["+i+"]/div["+j+"]//div[@class='qn-0x']/ul/li[1]/span[1]")).isDisplayed() && driver.findElement(By.xpath("//div[contains(@style,'flex-direction')]/div["+i+"]/div["+j+"]//div[@class='qn-0x']/ul/li[1]/span[1]")).isEnabled()){
                            Thread.sleep(5000);
                        }
                        likes=driver.findElement(By.xpath("//div[contains(@style,'flex-direction')]/div["+i+"]/div["+j+"]//div[@class='qn-0x']/ul/li[1]/span[1]")).getText();
                        System.out.println("***Likes**::"+ likes);
                        waitForElement(driver,"//div[contains(@style,'flex-direction')]/div["+i+"]/div["+j+"]//div[@class='qn-0x']/ul/li[1]/span[2]",30);
                        comments=driver.findElement(By.xpath("//div[contains(@style,'flex-direction')]/div["+i+"]/div["+j+"]//div[@class='qn-0x']/ul/li[2]/span[1]")).getText();
                        System.out.println("***comments**::"+ comments);
                        hmap.put(src, likes+" "+comments );

                    }

                }
                /*((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
                Thread.sleep(2000);*/

                //********************************
                long newHeight = ((Number)js.executeScript("return document.body.scrollHeight")).longValue();
                if (newHeight == lastHeight) {
                    break;
                }
                lastHeight = newHeight;
            }
            System.out.println("Size:: "+s.size());
            System.out.println("Size:: "+hmap.size());
            System.out.println(hmap);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

  /*  pubic void waitForPageLoad(WebDriver driver, int timeout)
    {
        new WebDriverWait(driver, timeout).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }*/

    public void downloadPhoto(WebDriver driver, String URL, int waitTime) throws IOException, InterruptedException {
        waitForPageLoad(driver,100);
        List<WebElement> allElements=driver.findElements(By.xpath("//*[@class='_5dec _xcx']"));;
        int counter = 1;
        for(WebElement photo :allElements) {
/*            scrollToElement(driver,photo);*/
            String logoSRC = photo.getAttribute("data-ploi");

            URL imageURL = new URL(logoSRC);
            BufferedImage saveImage = ImageIO.read(imageURL);
            File imageFile = new File(counter+".jpg");
            ImageIO.write(saveImage, "jpg", imageFile);
            ++counter;

            long size = imageFile.length();
            System.out.println(size);
            Assert.assertTrue("File is empty with 0 size ",size > 0);
        }
    }
}
