package com.tw.tests;

import org.testng.annotations.Test;

import com.tw.base.TestBase;
import com.tw.constants.Constants;
import com.tw.factory.RequestFactory;
import com.tw.specs.SpecificationFactory;

import testData.DataObject;



public final class TC_001_User_Registration_Test extends TestBase {

	private TC_001_User_Registration_Test() {

	}

	@Test(groups = "UserRegistration", priority = 1)
	public void checkRegistrationWithValidData() {

		RequestFactory
				.doPostRequest(Constants.REGISTRATION_ENDPOINT, DataObject.getPojo("REGISTER_VALID_DATA"))
				.then()
				.spec(SpecificationFactory.validUserRegistrationSpec());

	}

	@Test(priority = 2, groups = "UserRegistration")
	public void checkRegistrationWithBlankEmail() {
		

		RequestFactory.doPostRequest(Constants.REGISTRATION_ENDPOINT, DataObject.getPojo("BLANK_EMAIL"))
		.then()
		.spec(SpecificationFactory.invalidPostBodySpec(Constants.MSG_BLANK_EMAIL));

	}

	@Test(priority = 3, groups = "UserRegistration")
	public void checkRegistrationWithInvalidEmail() {

		RequestFactory.doPostRequest(Constants.REGISTRATION_ENDPOINT, DataObject.getPojo("INVALID_EMAIL"))
		.then()
		.spec(SpecificationFactory.invalidPostBodySpec(Constants.MSG_INVALID_EMAIL_REGISTER));

	}

	
	@Test(priority = 4, groups = "UserRegistration")
	public void checkRegistrationWithBlankPassword() {

		RequestFactory.doPostRequest(Constants.REGISTRATION_ENDPOINT, DataObject.getPojo("BLANK_PASSWORD"))
		.then()
		.spec(SpecificationFactory.invalidPostBodySpec(Constants.MSG_BLANK_PASSWORD));

	}

}
