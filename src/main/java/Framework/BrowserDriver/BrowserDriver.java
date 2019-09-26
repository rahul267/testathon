package Framework.BrowserDriver;


import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;

public interface BrowserDriver {
        WebDriver createDriver(String os);
        WebDriver createRemoteDriver() throws MalformedURLException;
    }


