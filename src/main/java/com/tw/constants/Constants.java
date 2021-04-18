package com.tw.constants;

import java.io.File;

public final class Constants {

	private Constants() {

	}



	// API Endpoints
	public static final String REGISTRATION_ENDPOINT = "/register";
	public static final String LOGIN_ENDPOINT = "/login";
	public static final String USERS_ENDPOINT = "/users";
	
	// HTTP Status Codes
	public static final int HTTP_OK_STATUS = 200;
	public static final int HTTP_CREATED_STATUS= 201;
	public static final int HTTP_NO_CONTENT_STATUS= 204;
	
	public static final int HTTP_BAD_REQUEST= 400;
	public static final int HTTP_UNAUTHORIZED= 401;
	public static final int HTTP_FORBIDDEN= 403;
	public static final int HTTP_PAGE_NOT_FOUND= 404;
	
	public static final String CONTENT_TYPE_JSON= "application/json; charset=utf-8";
	
	public static final String USER_EMAIL= "eve.holt@reqres.in";
	public static final String USER_PASSWORD = "pistol";
	
	// API Response messages for blank body fields
	public static final String MSG_BLANK_EMAIL = "Missing email or username";
	public static final String MSG_BLANK_PASSWORD= "Missing password";
	
	public static final String MSG_INVALID_EMAIL_REGISTER = "Note: Only defined users succeed registration";
	public static final String MSG_INVALID_EMAIL_LOGIN = "user not found";
	
	public static final String BLANK_STRING_VALUE= "";
	
	
	public static final String CONFIG_FILE_PATH= System.getProperty("user.dir") + File.separator + "src/test/resources/config/config.properties";
	public static final String TEST_DATA_JSON_PATH= System.getProperty("user.dir") + File.separator+ "src/test/resources/testData/usersData.json";
	
	public static final String AVAILABLE_RESPONSE_SCHEMA= System.getProperty("user.dir") + File.separator + "src/test/resources/responsePayloads/availableListUsers.json";
	public static final String UNAVAILABLE_REPONSE_SCHEMA= System.getProperty("user.dir") + File.separator + "src/test/resources/responsePayloads/unAvailableListUsers.json";
	
	

}
