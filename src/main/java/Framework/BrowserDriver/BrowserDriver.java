package Framework.BrowserDriver;


import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;

public interface BrowserDriver {
        WebDriver createDriver();
        WebDriver createRemoteDriver() throws MalformedURLException;
    }


