package com.tw.specs;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

import com.tw.constants.Constants;
import com.tw.model.UserPojoModel;
import com.tw.utils.PropertyFileReader;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;

public final class PostResponseSpecification {
	
	
	/* Common ResponseSpecification method to validate appropriate error message is being displayed in response body 
	 * if an invalid data is passed in request body during POST method.
	 * @param: error message (To be checked in POST response body)
	 * @return: ResponseSpecification
	 * 
	 * Validations done: HTTP status code (400) and Content-Type
	 * */
	public static synchronized ResponseSpecification invalidPostBodySpec(String message) {
		
		return new ResponseSpecBuilder()
					.expectStatusCode(Constants.HTTP_BAD_REQUEST)
		            .expectHeader("Content-Type", Constants.CONTENT_TYPE_JSON)
		            .expectBody("error", equalTo(message))
		            .build();
		
	}
	
	
	/* ResponseSpecification method to validate successful user registration via POST method for UserRegistration API
	 * 
	 * @return: ResponseSpecification
	 * Validations Done: HTTP OK status, Content Type, 
	 * 					Response body fields(id and token) are not null and are as per expected values available in config
	 * */	
	public static synchronized ResponseSpecification validUserRegistrationSpec() {
		
		return new ResponseSpecBuilder()
							.expectStatusCode(Constants.HTTP_OK_STATUS)
							.expectHeader("Content-Type", Constants.CONTENT_TYPE_JSON)
							.expectBody("id", notNullValue())
							.expectBody("token", notNullValue())
							.expectBody("id", equalTo(Integer.valueOf(PropertyFileReader.get("register_expected_user_id"))))
							.expectBody("token", equalTo(PropertyFileReader.get("register_expected_user_token")))
							.build();
		
	}
	
	
	
	/* ResponseSpecification method to validate successful user login for UserLogin API.
	 * 
	 * @return: ResponseSpecification
	 * Validations done: HTTP OK status code, Content type, 
	 * 					 Response body(token) is not null and is as per expected values available in config
	 * */
	public static synchronized ResponseSpecification validUserLoginSpec() {
		
		return new ResponseSpecBuilder()
					.expectStatusCode(Constants.HTTP_OK_STATUS)
					.expectHeader("Content-Type", Constants.CONTENT_TYPE_JSON)
					.expectBody("token", notNullValue())
					.expectBody("token", equalTo(PropertyFileReader.get("login_expected_token")))	
					.build();
		
	}
	
	
	
	/* ResponseSpecification method to validate successful user creation via CreateUser API.
	 * 
	 * @return: ResponseSpecification
	 * Validations done: HTTP Created Status code, Content-Type, 
	 * 					 Response body fields: name and job are as per expected values available in config
	 * 					 Response body fields: id and createdAt are not null values
	 * */
	public static synchronized ResponseSpecification successfulUserCreationSpec(UserPojoModel object) {
		
		return new ResponseSpecBuilder()
					.expectStatusCode(Constants.HTTP_CREATED_STATUS)
					.expectHeader("Content-Type", Constants.CONTENT_TYPE_JSON)
					.expectBody("name", equalTo(object.getName()))
					.expectBody("job", equalTo(object.getJob()))
					.expectBody("id", notNullValue())
					.expectBody("createdAt", notNullValue())
					.build();
		
	}
	
	
	
	
	

}
