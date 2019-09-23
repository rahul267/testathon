package Steps.ApiTestSteps;

import io.restassured.config.SSLConfig;
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

import java.util.Map;

import static io.restassured.RestAssured.*;

@Component
@Lazy
public class GetEventPageDetailsSteps {
    private static final Logger log = LoggerFactory.getLogger(GetEventPageDetailsSteps.class);
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
        Assertions.assertThat( false).isEqualTo(true);
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
        log.info("Status code of get All events is" + statusCode);
        Assertions.assertThat(response.getStatusCode()).isEqualTo(statusCode);
    }

}
