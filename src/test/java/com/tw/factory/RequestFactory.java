package com.tw.factory;

import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;

public class RequestFactory {
	
	
	public static Response doPostRequest(String apiEndpoint, Object pojoObject) {
		return given()
			.body(pojoObject)
			.contentType(ContentType.JSON)
			.when()
			.post(apiEndpoint);
		 
	}
	
	
	public static Response getAllResources(String apiEndpoint) {
		return given()
				.when()
				.get(apiEndpoint);
		
	}
	
	
	public static Response getResourceById(String apiEndpoint, int userId) {
		return given()
				.when()
				.pathParam("id", userId)
				.get(apiEndpoint+ "/{id}");
		
	}
	
	
	public static Response deleteResourceById(String apiEndpoint, String userId) {
		return given()
				.pathParam("id", userId)
				.when()
				.delete(apiEndpoint+ "/{id}");
			
	}

}
