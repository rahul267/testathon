package Steps.api;

import io.restassured.RestAssured;
import io.restassured.config.RestAssuredConfig;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.assertj.core.api.Assertions;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static io.restassured.config.EncoderConfig.encoderConfig;

@Component
@Lazy
public class ApiCommonStep {
    private static final Logger log = LoggerFactory.getLogger(ApiCommonStep.class);
    private static Response response;

    @Autowired
    private RequestSpecification req;

    @Given("I make a get request to $service with param $param")
    public void invokeGetRequest(@Named("service") String service,
                                 @Named("param") String  parameter) {
        log.info("calling get events proposed Talks details");
        response = given().
                spec(req).
                //contentType("application/json").
                // pathParams(parameter).
                        get(service);
        System.out.println(response.getBody().print());
    }

    @Given("I make a post request to $service with param $param")
    @When("I make a post request to $service with param $param")
    public Response invokePostRequest(@Named("service") String service,
                                      @Named("param") Map<String, Object> parameter) {
        log.info("calling get events proposed Talks details");
        response = given().
                spec(req).
                contentType("application/json").
                pathParams(parameter).
                post("service");
        return response;
    }


    @Then("validate the status code is $statusCode")
    public void validateStatusCode(@Named("statusCode") int statusCode) {
        log.info("Status code of upload file Api is" + statusCode);
        Assertions.assertThat(response.getStatusCode()).isEqualTo(statusCode);
    }


    @When("I make post request to  <service> with fields like <upfile>,<note> values")
    public Response whenIMakePostRequestToServiceWithFieldsLikeUpfilenoteValues(@Named("service") String service, @Named("upfile") String upfile, @Named("note") String note) {
        log.info("invoking file upload api");
        System.setProperty("jsse.enableSNIExtension", "false");
        RestAssured.useRelaxedHTTPSValidation();
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        File uploadFile = new File("upfile");
        response = given().log().all().
                //config(RestAssuredConfig.config().encoderConfig(encoderConfig().encodeContentTypeAs("multipart/form-data", ContentType.HTML))).
                spec(req).
                        multiPart(uploadFile).
                contentType("multipart/form-data").
                accept("text/html").
                formParam("note",note).
                post("service");
        return response;
    }
}
