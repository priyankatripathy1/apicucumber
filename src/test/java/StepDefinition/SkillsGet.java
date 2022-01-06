package StepDefinition;

import java.util.List;

import base.BaseStep;
import org.testng.Assert;

import data.Skill;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SkillsGet extends BaseStep {
	
	@Given("user set GET method with endpoint\\/url\\/Skills")
	public void user_set_get_method_with_endpoint_url_skills() {
		setupRestAssured();
	}

	@When("User sends request")
	public void user_sends_request() {
		response= request.get("/Skills");
	}

	@Then("JSON schema is valid")
	public void json_schema_is_valid() {
	    List<Skill> skills = response.as(new TypeRef<List<Skill>>(){});
	    Assert.assertNotNull(skills);
	}

	@Then("User receives status code {int}")
	public void user_receives_status_code(Integer int1) {
		Assert.assertEquals(response.statusCode(), int1.intValue());
	}

	@Then("User should receive a list of skills")
	public void user_should_receive_a_list_of_skills() {
		List<Skill> skills = response.as(new TypeRef<List<Skill>>(){});
		Assert.assertNotNull(skills);
		Assert.assertTrue(skills.size() > 0);
	}

	@Given("user set GET method with endpoint\\/url\\/Skills\\/ID")
	public void user_set_get_method_with_endpoint_url_skills_id() {
		setupRestAssured();
	}

	@When("User sends the request with specific {int}")
	public void user_sends_the_request_with_specific(Integer int1) {
		response= request.get("/Skills/" + int1);
	}

	@Then("JSON schema is valid for Skill")
	public void json_schema_is_valid_for_skill() {
		Skill skill = response.as(Skill.class);
		Assert.assertNotNull(skill);
		Assert.assertNotNull(skill.skill_id);
	}

	@Then("User should receive a list of skills for specific skill ID {int}.")
	public void user_should_receive_a_list_of_skills_for_specific_skill_id(Integer int1) {
	    Skill skill = response.as(Skill.class);
	    Assert.assertEquals(skill.skill_id, int1.intValue());
	}

	@When("User sends the request with invalid {double}")
	public void user_sends_the_request_with_invalid(Double double1) {
		response= request.get("/Skills/" + double1);
	}

	@When("User sends the request with invalid A123b")
	public void user_sends_the_request_with_invalid_a123b() {
		response= request.get("/Skills/" + "A123b");
	}

	@When("User sends the request with invalid null")
	public void user_sends_the_request_with_invalid_null() {
		response= request.get("/Skills/" + null);
	}

	@When("User sends the request with non existing {int}")
	public void user_sends_the_request_with_non_existing(Integer int1) {
		response= request.get("/Skills/" + int1);
	}
	

}
