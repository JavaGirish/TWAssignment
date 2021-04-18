package com.tw.tests;

import org.testng.annotations.Test;

import com.tw.base.TestBase;
import com.tw.constants.Constants;
import com.tw.factory.RequestFactory;
import com.tw.specs.DeleteResponseSpecification;
import com.tw.specs.SpecificationFactory;
import com.tw.utils.PropertyFileReader;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Feature("Feature: ReqRes Delete Users API")
public final class TC_04_Delete_Users_Test extends TestBase {
	
	private TC_04_Delete_Users_Test() {}
	
	@Story("Check if user is able to successfully delete an user")
	@Description("Test case to validate if we are able to successfully delete an user from the application")
	@Severity(SeverityLevel.CRITICAL)
	@Test(priority=1, groups= {"DeleteUser","All"})
	public void checkDeleteApiWithSpecificId() {
		
		RequestFactory.deleteResourceById(Constants.USERS_ENDPOINT, PropertyFileReader.get("delete_user_id"))
					  .then()
					  .spec(DeleteResponseSpecification.successfulUserDeletionSpec());
		
	}

}
