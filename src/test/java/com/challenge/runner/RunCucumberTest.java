package com.challenge.runner;

import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import com.challenge.utils.AutoTool;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty,html:target/cucumber-report.html,json:target/cucumber.json")
public class RunCucumberTest {
	@Before
	public void scenarioSetup(Scenario scenario) {
		AutoTool.loadSetupValues();
		AutoTool.scenarioHandler().setThreadScenario(scenario);
	}

	@After
	public void scenarioTearDown() {
		AutoTool.clearDriver();
		AutoTool.scenarioHandler().clearScenario();
	}
}