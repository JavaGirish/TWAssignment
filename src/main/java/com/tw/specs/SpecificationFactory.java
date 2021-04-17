package com.tw.specs;

import static org.hamcrest.Matchers.equalTo;

import com.tw.constants.Constants;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;

public final class SpecificationFactory  {

	private static ResponseSpecBuilder responseSpec;
	
	public static synchronized ResponseSpecification genericGetRequestSpecification() {
		responseSpec = new ResponseSpecBuilder();
		responseSpec.expectStatusCode(Constants.HTTP_OK_STATUS);
		responseSpec.expectHeader("Content-Type", "application/json; charset=utf-8");
		return responseSpec.build();

	
	}

	public static synchronized ResponseSpecification missingEmailSpecification() {
		responseSpec = new ResponseSpecBuilder();
		responseSpec.expectStatusCode(Constants.HTTP_BAD_REQUEST);
		responseSpec.expectHeader("Content-Type", "application/json; charset=utf-8");
		responseSpec.expectBody("error", equalTo(Constants.MSG_BLANK_EMAIL));
		return responseSpec.build();
		

	}

	public static synchronized ResponseSpecification invalidEmailRegistrationSpecification() {
		responseSpec = new ResponseSpecBuilder();
		responseSpec.expectStatusCode(Constants.HTTP_BAD_REQUEST);
		responseSpec.expectHeader("Content-Type", "application/json; charset=utf-8");
		responseSpec.expectBody("error", equalTo(Constants.MSG_INVALID_EMAIL_REGISTER));
		return responseSpec.build();
	

	}

	public static synchronized ResponseSpecification missingPasswordSpecification() {
		responseSpec = new ResponseSpecBuilder();
		responseSpec.expectStatusCode(Constants.HTTP_BAD_REQUEST);
		responseSpec.expectHeader("Content-Type", "application/json; charset=utf-8");
		responseSpec.expectBody("error", equalTo(Constants.MSG_BLANK_PASSWORD));
		return responseSpec.build();

	}

}
