package Framework.BrowserDriver;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.MalformedURLException;
import java.net.URL;

public class ChromeMobileBrowser implements BrowserDriver {
    private static final Logger LOGGER = LoggerFactory.getLogger(FireFoxBrowserDriver.class.getName());
    public static final String FIREFOX_DRIVER_FILEPATH = System.getProperty("user.dir") + "/src/main/resources/driver-executables/geckodriver.exe";

    @Override
    public WebDriver createDriver(String os) {

        String nodeURL = "http://localhost:4444/wd/hub";
        RemoteWebDriver driver = null;
        try {
            driver = new RemoteWebDriver(new URL(nodeURL), getDriverCapabilities());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return driver;
    }

    @Override
    public WebDriver createRemoteDriver() throws MalformedURLException {

        String nodeURL = "http://localhost:4444/wd/hub";
        DesiredCapabilities capability = DesiredCapabilities.android();
        capability.setBrowserName("chrome");
        capability.setPlatform(Platform.WIN10);
        WebDriver driver = new RemoteWebDriver(new URL(nodeURL), capability);
        return driver;
    }

    private DesiredCapabilities getDriverCapabilities() {
            DesiredCapabilities desiredCapabilities = DesiredCapabilities.android();
            desiredCapabilities.setCapability("deviceName", "samsung_galaxy_s6_8.1");
            desiredCapabilities.setCapability("platformName", "Android");
            desiredCapabilities.setCapability("browserName", "chrome");
            desiredCapabilities.setCapability("noReset", false);
            return desiredCapabilities;
    }
}