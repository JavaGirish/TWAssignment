package com.tw.tests;

import org.testng.annotations.Test;

import com.tw.base.TestBase;
import com.tw.constants.Constants;
import com.tw.factory.RequestFactory;
import com.tw.specs.SpecificationFactory;

import testData.DataObject;



public final class TC_002_User_Login_Test extends TestBase{
	
	private TC_002_User_Login_Test() {}
	
	
	@Test(groups="UserLogin", priority=1)
	public void checkLoginWithValidData() {
		RequestFactory.doPostRequest(Constants.LOGIN_ENDPOINT, DataObject.getPojo("LOGIN_VALID_DATA"))
		 			  .then()
		              .spec(SpecificationFactory.validUserLoginSpec());
		
	}
	
	
	
	@Test(groups="UserLogin", priority=2) 
	public void checkLoginApiWithBlankEmail() {
		RequestFactory.doPostRequest(Constants.LOGIN_ENDPOINT, DataObject.getPojo("BLANK_EMAIL"))
					 .then()
					  .spec(SpecificationFactory.invalidPostBodySpec(Constants.MSG_BLANK_EMAIL));
		
	}
		
	
	
	@Test(priority=3, groups= "UserLogin")
	public void checkLoginApiWithInvalidEmail() {
		RequestFactory.doPostRequest(Constants.LOGIN_ENDPOINT, DataObject.getPojo("INVALID_EMAIL"))
					  .then()
		              .spec(SpecificationFactory.invalidPostBodySpec(Constants.MSG_INVALID_EMAIL_LOGIN));
		
	}
	
	
	@Test(priority=4, groups= "UserLogin")
	public void checkLoginApiWithBlankPassword() {
		
		RequestFactory.doPostRequest(Constants.LOGIN_ENDPOINT, DataObject.getPojo("BLANK_PASSWORD"))
					  .then()
					  .spec(SpecificationFactory.invalidPostBodySpec(Constants.MSG_BLANK_PASSWORD));
		
		
	}
		
	

}
