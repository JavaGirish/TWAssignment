package com.tw.specs;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public final class LoggingSpecification {
	
	
	/* RequestSpecification method to log payload info in Allure Reports
	 * 
	 * @return: RequestSpecification
	 * */
	public static synchronized RequestSpecification getPayloadInfo() {
		
		return new RequestSpecBuilder().addFilter(new AllureRestAssured()).build();
		
	}
	
	


}
