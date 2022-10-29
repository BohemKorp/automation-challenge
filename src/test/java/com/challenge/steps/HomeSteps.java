package com.challenge.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import com.challenge.utils.AutoTool;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;


public class HomeSteps {

    @Given("I navigate to {string} section")
    public void I_navigate_to_section(String section) {
		AutoTool.pageObject().yourLogoHome().navToSection(section);
		AutoTool.addScreenshotToCucumberExecutionReport("section_ss");
    }

	@And("I select {string} sub category")
	public void I_select_sub_category(String subCategory) {
		AutoTool.pageObject().yourLogoHome().goToSubCategory(subCategory);
		AutoTool.addScreenshotToCucumberExecutionReport("subcategory_ss");
	}

	@When("I search {string}")
	public void I_search_product(String product) {
		AutoTool.pageObject().yourLogoHome().searchProduct(product);
		AutoTool.addScreenshotToCucumberExecutionReport("search_result_ss");

	}

	@Then("I should visualize the message {string}")
	public void I_should_visualize_the_message(String message) {
		Assertions.assertEquals(message, AutoTool.pageObject().yourLogoHome().getSearchMessage(), "The message is not equal");
		AutoTool.addScreenshotToCucumberExecutionReport("search_result_message_ss");

	}
}