package Framework.BrowserDriver;


import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.MalformedURLException;
import java.net.URL;

public class FireFoxBrowserDriver implements BrowserDriver {
    private static final Logger LOGGER = LoggerFactory.getLogger(FireFoxBrowserDriver.class.getName());
    public static final String FIREFOX_DRIVER_FILEPATH = System.getProperty("user.dir") + "/src/main/resources/driver-executables/geckodriver.exe";

    @Override
    public WebDriver createDriver() {
        System.setProperty("webdriver.gecko.driver", FIREFOX_DRIVER_FILEPATH);
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setAcceptInsecureCerts(true);
        WebDriver driver = new FirefoxDriver(firefoxOptions);
        return driver;
    }

    @Override
    public WebDriver createRemoteDriver() throws MalformedURLException {

        String nodeURL = "http://localhost:4444/wd/hub";
        DesiredCapabilities capability = DesiredCapabilities.chrome();
        capability.setBrowserName("chrome");
        capability.setPlatform(Platform.WIN10);
       WebDriver driver = new RemoteWebDriver(new URL(nodeURL), capability);
       return driver ;
    }

}
