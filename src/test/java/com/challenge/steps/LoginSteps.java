package com.challenge.steps;

import com.challenge.utils.AutoTool;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class LoginSteps {
	
	@Given("I navigate to the login page on {string}")
	public void I_navigate_to_the_login_page_on(String browser) {
		AutoTool.setupDriver(browser);
		AutoTool.pageObject().yourLogoHome().goLoginWebPage();
		AutoTool.addScreenshotToCucumberExecutionReport("login_page_ss");
	}
	
	@When("I submit proper username and password")
	public void I_submit_proper_username_and_password() {
		AutoTool.pageObject().yourLogoAuth().doLogin();
		AutoTool.addScreenshotToCucumberExecutionReport("logged_user_ss");
	}
}