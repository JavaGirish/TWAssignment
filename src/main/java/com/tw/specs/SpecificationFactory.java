package com.tw.specs;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

import org.hamcrest.Matchers;

import com.tw.constants.Constants;
import com.tw.utils.PropertyFileReader;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;

public final class SpecificationFactory  {

	private static ResponseSpecBuilder responseSpec;
	
	/* Common ResponseSpecification method to verify generic fields for all GET requests
	 * Checks: Status code (200) and Content-Type
	 * */
	
	public static synchronized ResponseSpecification genericGetRequestSpecification() {
		responseSpec = new ResponseSpecBuilder();
		
		responseSpec.expectStatusCode(Constants.HTTP_OK_STATUS)
					.expectHeader("Content-Type", "application/json; charset=utf-8");
		
		return responseSpec.build();

	
	}

	
	/* Common ResponseSpecification method to validate appropriate error message is being displayed in response body 
	 * if an invalid data is passed in request body during POST method.
	 * @param: error message (To be checked in POST response body)
	 * 
	 * Additional Checks: status code (400) and Content-Type
	 * 
	 * */
	public static synchronized ResponseSpecification invalidPostBodySpec(String message) {
		responseSpec = new ResponseSpecBuilder();
		
		responseSpec.expectStatusCode(Constants.HTTP_BAD_REQUEST)
		            .expectHeader("Content-Type", Constants.CONTENT_TYPE_JSON)
		            .expectBody("error", equalTo(message));
		
		return responseSpec.build();
		

	}
	
	
	
	public static synchronized ResponseSpecification validUserRegistrationSpec() {
		responseSpec = new ResponseSpecBuilder();
		
		responseSpec.expectStatusCode(Constants.HTTP_OK_STATUS)
					.expectHeader("Content-Type", Constants.CONTENT_TYPE_JSON)
					.expectBody("id", notNullValue())
					.expectBody("token", notNullValue())
					.expectBody("id", equalTo(Integer.valueOf(PropertyFileReader.get("register_expected_user_id"))))
					.expectBody("token", equalTo(PropertyFileReader.get("register_expected_user_token")));
			
		return responseSpec.build();
		
	}
	
	
	
	public static synchronized ResponseSpecification validUserLoginSpec() {
		responseSpec = new ResponseSpecBuilder();
		
		responseSpec.expectStatusCode(Constants.HTTP_OK_STATUS)
					.expectHeader("Content-Type", Constants.CONTENT_TYPE_JSON)
					.expectBody("token", notNullValue())
					.expectBody("token", equalTo(PropertyFileReader.get("login_expected_token")));
			
		return responseSpec.build();
		
	}
	
	
	public static synchronized ResponseSpecification successfulUserCreationSpec() {
		responseSpec = new ResponseSpecBuilder();
		
		responseSpec.expectStatusCode(Constants.HTTP_CREATED_STATUS)
					.expectHeader("Content-Type", Constants.CONTENT_TYPE_JSON)
					.expectBody("name", equalTo(PropertyFileReader.get("reqres_user_name")))
					.expectBody("job", equalTo(PropertyFileReader.get("reqres_user_job")))
					.expectBody("id", notNullValue())
					.expectBody("createdAt", notNullValue());
			
		return responseSpec.build();
		
	}
	
	
	public static synchronized ResponseSpecification successfulUserDeletionSpec() {
		responseSpec = new ResponseSpecBuilder();
		
		responseSpec.expectStatusCode(Constants.HTTP_NO_CONTENT_STATUS)
					.expectHeader("Content-Length", "0");
					
		return responseSpec.build();
		
	}

	

	

}
