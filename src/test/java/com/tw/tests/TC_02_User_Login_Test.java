package com.tw.tests;

import org.testng.annotations.Test;

import com.tw.base.TestBase;
import com.tw.constants.Constants;
import com.tw.factory.RequestFactory;
import com.tw.model.DataObject;
import com.tw.specs.PostResponseSpecification;
import com.tw.specs.SpecificationFactory;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Feature("Feature: ReqRes UserLogin API")
public final class TC_02_User_Login_Test extends TestBase{
	
	private TC_02_User_Login_Test() {}
	
	
	@Story("Check UserLogin API with valid data provided")
	@Description("Test Case to check if user is able to login successfully using valid email and password details in request body")
	@Severity(SeverityLevel.CRITICAL)
	@Test(groups= {"UserLogin", "All"}, priority=1)
	public void checkLoginWithValidData() {
		RequestFactory.doPostRequest(Constants.LOGIN_ENDPOINT, DataObject.getPojo("LOGIN_VALID_DATA"))
		 			  .then()
		              .spec(PostResponseSpecification.validUserLoginSpec());
		
	}
	
	
	@Story("Check UserLogin API with email field set to blank")
	@Description("Test Case to validate user is not able to perform login, if the email field in API request body is set to blank")
	@Severity(SeverityLevel.NORMAL)
	@Test(groups= {"UserLogin","All"}, priority=2) 
	public void checkLoginApiWithBlankEmail() {
		RequestFactory.doPostRequest(Constants.LOGIN_ENDPOINT, DataObject.getPojo("BLANK_EMAIL"))
					 .then()
					  .spec(PostResponseSpecification.invalidPostBodySpec(Constants.MSG_BLANK_EMAIL));
		
	}
		
	
	@Story("Check UserLogin API with email field set to an invalid value")
	@Description("Test Case to validate user is not able to perform login, if the email field in API request body is set to an domain other than reqres.in")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority=3, groups= {"UserLogin","All"})
	public void checkLoginApiWithInvalidEmail() {
		RequestFactory.doPostRequest(Constants.LOGIN_ENDPOINT, DataObject.getPojo("INVALID_EMAIL"))
					  .then()
		              .spec(PostResponseSpecification.invalidPostBodySpec(Constants.MSG_INVALID_EMAIL_LOGIN));
		
	}
	
	@Story("Check UserLogin API with password field set to blank")
	@Description("Test Case to validate user is not able to perform login, if the password field in API request body is set to blank")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority=4, groups= {"UserLogin","All"})
	public void checkLoginApiWithBlankPassword() {
		
		RequestFactory.doPostRequest(Constants.LOGIN_ENDPOINT, DataObject.getPojo("BLANK_PASSWORD"))
					  .then()
					  .spec(PostResponseSpecification.invalidPostBodySpec(Constants.MSG_BLANK_PASSWORD));
		
	}
		
	

}
