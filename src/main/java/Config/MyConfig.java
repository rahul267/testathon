package Config;

import io.appium.java_client.android.AndroidDriver;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

import java.net.MalformedURLException;
import java.net.URL;

@Configuration
@ComponentScan({"Steps", "mobileUtlity"})
@PropertySource({"Config/${env:dev}/env.properties"})
public class MyConfig {

    @Value("${base.url:www.google.com}")
    private String baseUrl;

    @Value("${env:dev}")
    private String envType;

    @Value("${device.Name}")
    String deviceName;

    @Value("${device.platformName}")
    String platformName;

    @Value("${appium.server}")
    String appiumServer;


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
            return new AndroidDriver(new URL(appiumServer), getDriverCapabilities());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private DesiredCapabilities getDriverCapabilities() {
        DesiredCapabilities desiredCapabilities = DesiredCapabilities.android();
        desiredCapabilities.setCapability("deviceName", deviceName);
        desiredCapabilities.setCapability("platformName", platformName);
        desiredCapabilities.setCapability("browserName", "Chrome");
        desiredCapabilities.setCapability("noReset", false);
        return desiredCapabilities;
    }
}