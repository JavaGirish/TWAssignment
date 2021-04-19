package com.tw.specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;

public class BaseSpecification {
	
	
	/* Common ResponseSpecification method to check HTTP status code matches as per expected values
	 * @param: statusCode
	 * @return: ResponseSpecification 
	 * */
	public static synchronized ResponseSpecification checkHttpStatusCodeSpec(int statusCode) {
		
		return new ResponseSpecBuilder().expectStatusCode(statusCode).build();
		
	}
	
	
	/* Common ResponseSpecification method to check content Type in response header matches as per expected values
	 * @param: contentType
	 * @return: ResponseSpecification
	 * */
	public static synchronized ResponseSpecification checkContentTypeSpec(String contentType) {
		
		return new ResponseSpecBuilder().expectContentType(contentType).build();
	}
	
	
	

}
