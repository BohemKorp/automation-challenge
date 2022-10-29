package com.challenge.utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;
import java.util.Map;

public class TestContext {
		
	public Response response;
	public Map<String, Object> session = new HashMap<String, Object>();
	private static final String CONTENT_TYPE = AutoTool.getSetupValue("content.type");
	
	public RequestSpecification requestSetup() {	
		RestAssured.reset();
		RestAssured.baseURI = AutoTool.getSetupValue("baseURL");
		return RestAssured.given()
				.contentType(CONTENT_TYPE)
				.accept(CONTENT_TYPE);
	} 
}
