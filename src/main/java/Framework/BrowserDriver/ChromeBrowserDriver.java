package Framework.BrowserDriver;


import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.MalformedURLException;
import java.net.URL;


public class ChromeBrowserDriver implements BrowserDriver {
    private static final Logger log = LoggerFactory.getLogger(ChromeBrowserDriver.class.getName());
    public static final String CHROME_DRIVER_FILEPATH = System.getProperty("user.dir") + "/src/main/resources/driver-executables/chromedriver.exe";

    @Override
    public WebDriver createDriver(String os) {
        WebDriver driver = null;
        System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_FILEPATH);
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setAcceptInsecureCerts(true);
        driver = new ChromeDriver(chromeOptions);
        return driver;
    }

    @Override
    public WebDriver createRemoteDriver() {
        String nodeURL = "http://localhost:4444/wd/hub";
        WebDriver driver = null;
        DesiredCapabilities capability = DesiredCapabilities.chrome();
        capability.setBrowserName("chrome");
        capability.setPlatform(Platform.LINUX);
        try {
            driver = new RemoteWebDriver(new URL(nodeURL), capability);
            //more code goes here
        } catch (MalformedURLException ex) {
//do exception handling here
        }

        return driver;
    }


}
