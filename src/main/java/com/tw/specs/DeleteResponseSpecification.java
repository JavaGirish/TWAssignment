package com.tw.specs;

import com.tw.constants.Constants;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;

public final class DeleteResponseSpecification extends BaseSpecification  {
	
	/* ResponseSpecification method to verify successful delete request via DeleteUsers API.
	 * 
	 * @return: ResponseSpecification
	 * Validations done: Content Length should be zero.
	 * */
	public static synchronized ResponseSpecification successfulUserDeletionSpec() {
		return new ResponseSpecBuilder()
					.expectHeader("Content-Length", Constants.BLANK_CONTENT_LENGTH)		
					.build();
		
	}

}
