package Config;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan({"Steps","mobileUtlity"})
@PropertySource({"Config/${env:dev}/env.properties"})
public class MyConfig {

    @Value("${base.url:www.google.com}")
    private String baseUrl;

    @Value("${env:dev}")
    private String envType;

    @Bean(name = "getRequestSpecification")
    @Lazy
    public RequestSpecification createRequestBuilder() {
        RequestSpecification req;
        RequestSpecBuilder builder = new RequestSpecBuilder();
        builder.setBaseUri(baseUrl);
        /*builder.addFilter(new ResponseLoggingFilter().logResponseTo(Log.getLogStream())) ;
        builder.addFilter(new RequestLoggingFilter().logRequestTo(Log.getLogStream())) ;*/
        req = builder.build();
        System.setProperty("jsse.enableSNIExtension", "false");
       // RestAssured.useRelaxedHTTPSValidation();
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        return req;
    }

}