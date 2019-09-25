package Config;

import io.appium.java_client.android.AndroidDriver;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

import java.net.MalformedURLException;
import java.net.URL;

@Configuration
@ComponentScan({"Steps", "mobileUtlity", "Config"})
@PropertySource({"Config/${env:dev}/env.properties"})
public class MyConfig {
    private static final Logger log = LoggerFactory.getLogger(MyConfig.class);
    @Value("${base.url}")
    private String baseUrl;

    @Value("${env:dev}")
    private String envType;

    @Value("${device.Name}")
    String deviceName;

    @Value("${device.platformName}")
    private String platformName;

    @Value("${appium.server}")
    private String appiumServer;

    @Value("$web.Browser:Chrome")
    private String browserType;

    @Bean(name = "getRequestSpecification")
    @Lazy
    public RequestSpecification createRequestBuilder() {
        RequestSpecification req;
        RequestSpecBuilder builder = new RequestSpecBuilder();
        builder.setBaseUri(baseUrl);
        /*builder.addFilter(new ResponseLoggingFilter().logResponseTo(Log.getLogStream())) ;
        builder.addFilter(new RequestLoggingFilter().logRequestTo(Log.getLogStream())) ;*/
        req = builder.build();
        System.setProperty("jsseableSNIExtension", "false");
        RestAssured.useRelaxedHTTPSValidation();
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        return req;
    }

    @Lazy
    @Bean(name = "MobileDriver")
    public AndroidDriver getAndroidDriver() {
        try {
            log.info("Android Driver Instantiating...");
            return new AndroidDriver(new URL(appiumServer), getDriverCapabilities());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private DesiredCapabilities getDriverCapabilities() {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("deviceName", deviceName);
        desiredCapabilities.setCapability("platformName", platformName);
        desiredCapabilities.setCapability("browserName", "Chrome");
        desiredCapabilities.setCapability("noReset", false);
        return desiredCapabilities;
    }
}