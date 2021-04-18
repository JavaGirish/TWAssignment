package com.tw.base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.tw.utils.PropertyFileReader;

import io.restassured.RestAssured;

public class TestBase {
	
	
	@BeforeMethod
	protected void setUp() {
		RestAssured.baseURI = PropertyFileReader.get("baseuri");
		RestAssured.basePath = PropertyFileReader.get("basepath");
			
	}
	
	
	
	@AfterMethod
	protected void tearDown() {
		RestAssured.reset();
	}

}
