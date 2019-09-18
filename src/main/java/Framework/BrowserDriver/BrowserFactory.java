package Framework.BrowserDriver;

import Enums.Browser;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BrowserFactory {

    static WebDriver driver;

    private static final Logger LOGGER = LoggerFactory.getLogger(BrowserFactory.class.getName());

    public static WebDriver getDriver(Browser browserType) {

        switch (browserType) {
            case FIREFOX :
                LOGGER.info("Creating FirefoxDriver");
                driver = new FireFoxBrowserDriver().createDriver();
                break;
            case CHROME:
                LOGGER.info("Creating ChromeDriver");
                driver = new ChromeBrowserDriver().createDriver();
                break;


            default:
                throw new IllegalArgumentException("Cannot create driver for browser" + browserType);
        }

        return driver;
    }

}
