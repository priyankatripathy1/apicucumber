package StepDefinition;

import base.BaseStep;
import data.Skill;
import data.SkillPostResponse;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import utils.ExcelUtils;

public class SkillsPost extends BaseStep {

    private final static String FILE_PATH = "src\\test\\resources\\postskill_data.xlsx";
    private final static String VALID = "valid";
    private final static String INVALID = "invalid";
    private final static String NUMERIC = "numeric";

    @Given("user sets POST request with endpoint \\skills")
    public void user_sets_post_request_with_endpoint_skills() {
        super.setupRestAssured();
    }

    @When("User sends request with valid input from valid excel {int}")
    public void user_sends_request_with_valid_input_from_valid_excel(Integer int1) {
        sendRequestWithSkillName(getValidSkillName(int1));
    }

    @Then("User should receive {int}")
    public void user_should_receive(Integer int1) {
        Assert.assertEquals(int1.intValue(), response.statusCode());
    }

    @Then("user receive valid JSON schema")
    public void user_receive_valid_json_schema() {
        SkillPostResponse skill = response.as(SkillPostResponse.class);
        Assert.assertNotNull(skill);
        Assert.assertTrue(skill.skill_id > 0);
        Assert.assertEquals("Successfully Created !!", skill.message_response);
    }

    @When("User sends request with valid input from invalid excel {int}")
    public void user_sends_request_with_valid_input_from_invalid_excel(Integer int1) {
        sendRequestWithSkillName(getInvalidSkillName(int1));
    }

    @When("User sends request with valid input from numeric excel {int}")
    public void user_sends_request_with_valid_input_from_numeric_excel(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        sendRequestWithSkillName(getInvalidSkillNameNumeric(int1).toString());
    }

    private String getValidSkillName(int row) {
        ExcelUtils utils = new ExcelUtils(FILE_PATH, VALID);
        return utils.getCellDataString(row, 0);
    }

    private String getInvalidSkillName(int row) {
        ExcelUtils utils = new ExcelUtils(FILE_PATH, INVALID);
        return utils.getCellDataString(row, 0);
    }

    private Double getInvalidSkillNameNumeric(int row) {
        ExcelUtils utils = new ExcelUtils(FILE_PATH, NUMERIC);
        return utils.getCellDataNumeric(row, 0);
    }

    private void sendRequestWithSkillName(String skillName) {
        Skill skill = new Skill();
        skill.skill_name = skillName;
        this.request.body(skill);
        this.request.header("Content-Type", "application/json");
        this.response = this.request.post("/Skills");
    }
}
