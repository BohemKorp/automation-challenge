package com.challenge.steps;

import com.challenge.utils.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;

public class RestSteps {
	private TestContext context;

	public RestSteps(TestContext context) {
		this.context = context;
	}

	@Given("I have access to endpoint {string}")
	public void iHaveAccessToEndpoint(String endpoint) {
		context.session.put("endpoint", endpoint);
	}

	@When("I create an user")
	public void iCreateAnUser() {
		JSONObject body = new JSONObject();
		body.put("id","");
		body.put("title","");
		body.put("body","");
		body.put("userId","");

		context.response = context.requestSetup().body(body.toString())
				.when().post(context.session.get("endpoint").toString());
	}

	@Then("I should get the response code {int}")
	public void userShpuldGetTheResponseCode(Integer statusCode) {
		Assertions.assertEquals(Long.valueOf(statusCode), Long.valueOf(context.response.getStatusCode()));
	}

	@And("the response with JSON schema {string}")
	public void theResponseWithJSONSchema(String schemaFileName) {
		context.response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemas/"+schemaFileName));
	}

	@When("I make the query")
	public void iMakeTheQuery() {
		context.response = context.requestSetup().when().get(context.session.get("endpoint").toString());
	}

	@And("the {string} should be {string}")
	public void theShouldBeDelectusAuntAutem(String field, String value) {
		JSONObject response = new JSONObject(context.response.getBody().prettyPrint());
		Assertions.assertEquals(value, response.get(field));
	}
}