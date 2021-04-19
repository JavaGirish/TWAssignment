package com.tw.specs;

import static org.hamcrest.Matchers.equalTo;

import java.io.File;

import com.tw.constants.Constants;
import com.tw.utils.PropertyFileReader;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.specification.ResponseSpecification;

public final class GetResponseSpecification extends BaseSpecification {
	
	
	
	/* ResponseSpecification method to verify successful GET request for ListUsers API
	 * @param: actualPageNo (passed as query parameter in request)
	 * @return: ResponseSpecification
	 * 
	 * Validations done: Response body fields: (page and total) are as per values available in config file.
	 *   				
	 * */
	
	public static synchronized ResponseSpecification listUsersSpec(String actualPageNo) {
		
		return new ResponseSpecBuilder()
					.expectBody("page", equalTo(Integer.parseInt(actualPageNo)))
					.expectBody("total", equalTo(Integer.parseInt(PropertyFileReader.get("list_users_total"))))
					.build();
		
	}
	
	
	
	/* ResponseSpecification method to verify response body schema and data array size while performinhGET request 
	 * using actualPageNo values passed as query parameter, if actualPageNo is 1 or 2, user is able to get data array 
	 * in response, if an value more than 2 is passed, data array size should be zero.
	 * 
	 * @return: ResponseSpecification
	 * Validations done: data array size in response body and Response Schema.
	 * 
	 * */

	public static synchronized ResponseSpecification checkDataSizeSpec(String actualPageNo) {

		if((Integer.parseInt(actualPageNo)) <= 2)
		{
			return new ResponseSpecBuilder()
						.expectBody("data.size", equalTo(Integer.parseInt(PropertyFileReader.get("list_users_per_page"))))
						.expectBody(JsonSchemaValidator.matchesJsonSchema(new File(Constants.AVAILABLE_RESPONSE_SCHEMA)))
						.build();
		}
		
		else {
			
			return new ResponseSpecBuilder()
						.expectBody("data.size", equalTo(0))
						.expectBody(JsonSchemaValidator.matchesJsonSchema(new File(Constants.UNAVAILABLE_REPONSE_SCHEMA)))
						.build();
		}
	}
	
	
	
	
	
	
	
	

}
