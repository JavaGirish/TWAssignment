package com.tw.tests;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

import org.testng.annotations.Test;

import com.tw.base.TestBase;
import com.tw.constants.Constants;
import com.tw.model.UserPojoModel;
import com.tw.requests.RequestFactory;
import com.tw.specs.SpecificationFactory;
import com.tw.utils.GenerateFakeData;

import io.restassured.response.ValidatableResponse;

public final class TC_001_User_Registration_Test extends TestBase {
	
	private TC_001_User_Registration_Test() {
		
	}
	
	
	@Test(groups= "UserRegistration", priority=1)
	public void checkRegistrationWithValidData() {
		UserPojoModel pojo = new UserPojoModel();
		pojo.setEmail(Constants.USER_EMAIL);
		pojo.setPassword(Constants.USER_PASSWORD);
		
		ValidatableResponse response = RequestFactory.doPostRequest(Constants.REGISTRATION_ENDPOINT, pojo).then();
		
		response.statusCode(Constants.HTTP_OK_STATUS);
		
		response.body("id", notNullValue(),"token", notNullValue());
		response.body("id", equalTo(4), "token", equalTo("QpwL5tke4Pnpja7X4"));
		
	}
	
	
	@Test(priority=2, groups= "UserRegistration") 
	public void checkRegistrationWithBlankEmail() {
		UserPojoModel pojo = new UserPojoModel();
		pojo.setEmail("");
		pojo.setPassword(Constants.USER_PASSWORD);
		
		ValidatableResponse response = RequestFactory.doPostRequest(Constants.REGISTRATION_ENDPOINT, pojo).then();
		
		response.spec(SpecificationFactory.missingEmailSpecification());
		
	}
	
	
	@Test(priority=3, groups= "UserRegistration") 
	public void checkRegistrationWithInvalidEmail() {
		
		UserPojoModel pojo = new UserPojoModel();
		pojo.setEmail(GenerateFakeData.getEmailAddress());
		pojo.setPassword(Constants.USER_PASSWORD);
		
		ValidatableResponse response = RequestFactory.doPostRequest(Constants.REGISTRATION_ENDPOINT, pojo).then();
		
		response.spec(SpecificationFactory.invalidEmailRegistrationSpecification());
		
		
		
	}
	
	@Test(priority=4, groups= "UserRegistration") 
	public void checkRegistrationWithBlankPassword() {
		
		UserPojoModel pojo = new UserPojoModel();
		pojo.setEmail(Constants.USER_EMAIL);
		pojo.setPassword("");
		
		ValidatableResponse response = RequestFactory.doPostRequest(Constants.REGISTRATION_ENDPOINT, pojo).then();
		
		response.spec(SpecificationFactory.missingPasswordSpecification());
		
		
		
	}
	
	
	
	

}
