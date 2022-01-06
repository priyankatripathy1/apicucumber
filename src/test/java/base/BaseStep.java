package base;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseStep {

    protected Response response;
    protected String jsonString;
    protected RequestSpecification request;

    protected void setupRestAssured() {
        RestAssured.port = 8080;
        request = RestAssured.given();
        request.auth().preemptive().basic("APIPROCESSING","2xx@Success");
    }
}
