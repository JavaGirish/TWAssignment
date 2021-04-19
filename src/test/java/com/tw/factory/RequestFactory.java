package com.tw.factory;

import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

import com.tw.specs.LoggingSpecification;

import io.qameta.allure.Step;
import io.restassured.http.ContentType;

public class RequestFactory {
	
	/* Factory method to perform POST Request
	 * @param: apiEndpoint, pojoObject
	 * @return: Response
	 * */
	@Step("Performing an POST request to API endpoint: {0} with body payload")
	public static Response doPostRequest(String apiEndpoint, Object pojoObject) {
		return given()
			.spec(LoggingSpecification.getPayloadInfo())
			.body(pojoObject)
			.contentType(ContentType.JSON)
			.when()
			.post(apiEndpoint);
		 
	}
	
	
	
	/* Factory method to perform GET request fpr users using api endpoint and pageNumber
	 * @param: apiEndpoint, pageNumber
	 * @return: Response
	 * */
	@Step("Performing an GET request to API endpoint: {0} with page number as: {1}")
	public static Response getAllUsers(String apiEndpoint, String pageNumber) {
		return given()
				.spec(LoggingSpecification.getPayloadInfo())
				.when()
				.queryParam("page", pageNumber)
				.get(apiEndpoint);
		
	}
	
	
	/* Factory method to perform DELETE request using an specific ID
	 * @param: apiEndpoint, userId
	 * @return: Response
	 * 
	 * */
	@Step("Performing an DELETE request to API endpoint: {0} for userid: {1}")
	public static Response deleteResourceById(String apiEndpoint, String userId) {
		return given()
				.spec(LoggingSpecification.getPayloadInfo())
				.pathParam("id", userId)
				.when()
				.delete(apiEndpoint+ "/{id}");
			
	}

}
