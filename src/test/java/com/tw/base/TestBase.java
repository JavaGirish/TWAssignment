package com.tw.base;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.tw.constants.Constants;
import com.tw.utils.PropertyFileReader;

import io.restassured.RestAssured;

public class TestBase {
	
	
	@BeforeClass
	protected void setUp() {
		RestAssured.baseURI = PropertyFileReader.get("baseuri");
		RestAssured.basePath = Constants.BASE_PATH;
			
	}
	
	
	
	@AfterClass
	protected void tearDown() {
		RestAssured.reset();
	}

}
