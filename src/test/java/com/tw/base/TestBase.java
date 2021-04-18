package com.tw.base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.tw.utils.PropertyFileReader;

import io.qameta.allure.Step;
import io.restassured.RestAssured;

public class TestBase {
	
	@Step("Setting up BaseURI and BasePath for the API request")
	@BeforeMethod
	protected void setUp() {
		RestAssured.baseURI = PropertyFileReader.get("baseuri");
		RestAssured.basePath = PropertyFileReader.get("basepath");
			
	}
	
	
	@Step("Clean up resources post request has been completed")
	@AfterMethod
	protected void tearDown() {
		RestAssured.reset();
	}

}
