package com.tw.specs;

import com.tw.constants.Constants;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;

public final class DeleteResponseSpecification {
	
	/* ResponseSpecification method to verify successful delete request via DeleteUsers API.
	 * 
	 * @return: ResponseSpecification
	 * Validations done: HTTP No content status code, Content Length should be zero.
	 * */
	public static synchronized ResponseSpecification successfulUserDeletionSpec() {
		return new ResponseSpecBuilder()
					.expectStatusCode(Constants.HTTP_NO_CONTENT_STATUS)
					.expectHeader("Content-Length", "0")		
					.build();
		
	}

}
