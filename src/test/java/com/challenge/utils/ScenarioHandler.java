package com.challenge.utils;

import io.cucumber.java.Scenario;

public final class ScenarioHandler {
	private static ScenarioHandler instance = new ScenarioHandler();
	private ThreadLocal<Scenario> threadScenarioContainer = new ThreadLocal <Scenario>();
	
	private ScenarioHandler(){
	}
	
    public static ScenarioHandler getInstance() {
        return instance;
    }

	public void setThreadScenario(Scenario incScenario) {
		threadScenarioContainer.set(incScenario);
	}


	public Scenario getScenario() {
		return threadScenarioContainer.get();
	}
	

	public void clearScenario() {
		threadScenarioContainer.remove();
	}

}
