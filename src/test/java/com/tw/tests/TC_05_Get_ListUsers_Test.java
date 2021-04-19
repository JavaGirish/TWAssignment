package com.tw.tests;

import org.testng.annotations.Test;

import com.tw.base.TestBase;
import com.tw.constants.Constants;
import com.tw.factory.RequestFactory;
import com.tw.specs.GetResponseSpecification;
import com.tw.utils.PropertyFileReader;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Feature("Feature 05: ReqRes ListUsers API")
public class TC_05_Get_ListUsers_Test extends TestBase {

	private TC_05_Get_ListUsers_Test() {}
	
	@Story("Check user is able to fetch details of all available users in the application")
	@Description("Test case to validate if all available users details in the application are fetched properly if an appropriate page number is used")
	@Severity(SeverityLevel.CRITICAL)
	@Test(priority=1, groups= {"ListUsers", "All"})
	public void checkListUsersApiWithAvailableData() {
		
		RequestFactory.getAllUsers(Constants.USERS_ENDPOINT, PropertyFileReader.get("list_users_page"))
		.then()
		.spec(GetResponseSpecification.checkHttpStatusCodeSpec(Constants.HTTP_OK_STATUS))
		.spec(GetResponseSpecification.checkContentTypeSpec(Constants.CONTENT_TYPE_JSON))
		.spec(GetResponseSpecification.listUsersSpec(PropertyFileReader.get("list_users_page")))
		.spec(GetResponseSpecification.checkDataSizeSpec(PropertyFileReader.get("list_users_page")));
		
	}
	
	@Story("Check user is not able to fetch details of available users in the application if page no specified is more than 2")
	@Description("Test case to validate no users data is available in Response if an page number value more than the no of availables pages is used")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority=2, groups= {"ListUsers","All"})
	public void checkListApiUsersBeyondPageLimit() {
		RequestFactory.getAllUsers(Constants.USERS_ENDPOINT, PropertyFileReader.get("list_users_page_no"))
		.then()
		.spec(GetResponseSpecification.checkHttpStatusCodeSpec(Constants.HTTP_OK_STATUS))
		.spec(GetResponseSpecification.checkContentTypeSpec(Constants.CONTENT_TYPE_JSON))
		.spec(GetResponseSpecification.listUsersSpec(PropertyFileReader.get("list_users_page_no")))
		.spec(GetResponseSpecification.checkDataSizeSpec(PropertyFileReader.get("list_users_page_no")));
		
	}
	
	
}
