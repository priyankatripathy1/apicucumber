package StepDefinition;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class GetApi {
	
	private Response response;
	private String jsonString;
	
	@Given("User is on the Get Request")
	public void user_is_on_the_get_request() {
		//RestAssured.baseURI = "localhost";
		RestAssured.port = 8080;
	}

	@When("User sends Request")
	public void user_sends_request() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("User Recevies Response")
	public void user_recevies_response() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("User sends exsiting (.*)$")
	public void user_sends_exsiting(Integer int1) {
		RequestSpecification request = RestAssured.given();
		response= request.get("/skills/"+int1);
	}

	@Then("User retrives the skill Details")
	public void user_retrives_the_skill_details() {
	    Assert.assertEquals(response.statusCode(), 200);
	}

	@When("User sends Non exsiting (.*)$")
	public void user_sends_non_exsiting(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("User receives an {int} status code")
	public void user_receives_an_status_code(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

}
