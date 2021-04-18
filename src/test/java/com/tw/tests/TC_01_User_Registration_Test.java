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


@Feature("Feature: ReqRes UserRegistration API")
public final class TC_01_User_Registration_Test extends TestBase {

	private TC_01_User_Registration_Test() {

	}

	@Story("Check User Registration API with valid body data provided")
	@Description("Test Case to check if user is able to register successfully using valid email and password details in request body")
	@Severity(SeverityLevel.CRITICAL)
	@Test(groups = {"UserRegistration", "All"}, priority = 1)
	public void checkRegistrationWithValidData() {

		RequestFactory
				.doPostRequest(Constants.REGISTRATION_ENDPOINT, DataObject.getPojo("REGISTER_VALID_DATA"))
				.then()
				.spec(PostResponseSpecification.validUserRegistrationSpec());

	}

	@Story("Check User registration API with blank email body details")
	@Description("Test Case to validate user is not able to perform registration, if the email field in API request body is set to blank")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 2, groups = {"UserRegistration", "All"})
	public void checkRegistrationWithBlankEmail() {
		

		RequestFactory.doPostRequest(Constants.REGISTRATION_ENDPOINT, DataObject.getPojo("BLANK_EMAIL"))
		.then()
		.spec(PostResponseSpecification.invalidPostBodySpec(Constants.MSG_BLANK_EMAIL));

	}
	
	@Story("Check User registration API with invalid email body details")
	@Description("Test Case to validate user is not able to perform registration, if the email field in API request body is set to an domain other than reqres.in")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 3, groups = {"UserRegistration","All"})
	public void checkRegistrationWithInvalidEmail() {

		RequestFactory.doPostRequest(Constants.REGISTRATION_ENDPOINT, DataObject.getPojo("INVALID_EMAIL"))
		.then()
		.spec(PostResponseSpecification.invalidPostBodySpec(Constants.MSG_INVALID_EMAIL_REGISTER));

	}

	@Story("Check user registration API with blank password body details")
	@Description("Test Case to validate user is not able to perform registration, if the password field in API request body is set to blank")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 4, groups = {"UserRegistration","All"})
	public void checkRegistrationWithBlankPassword() {

		RequestFactory.doPostRequest(Constants.REGISTRATION_ENDPOINT, DataObject.getPojo("BLANK_PASSWORD"))
		.then()
		.spec(PostResponseSpecification.invalidPostBodySpec(Constants.MSG_BLANK_PASSWORD));

	}

}
