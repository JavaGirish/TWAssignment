package com.tw.tests;

import org.testng.annotations.Test;

import com.tw.base.TestBase;
import com.tw.constants.Constants;
import com.tw.factory.RequestFactory;
import com.tw.specs.SpecificationFactory;

import testData.DataObject;

public final class TC_003_Create_User_Test extends TestBase {
	
	private TC_003_Create_User_Test() {}
	
	
	@Test(priority=1, groups="CreateUser")
	public void checkCreateUsersApiWIthValidData() {
		
		RequestFactory.doPostRequest(Constants.USERS_ENDPOINT, DataObject.getPojo("CREATE_USER"))
		  			  .then()
                      .spec(SpecificationFactory.successfulUserCreationSpec());
	
	}

}
