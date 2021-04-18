package com.tw.tests;

import org.testng.annotations.Test;

import com.tw.base.TestBase;
import com.tw.constants.Constants;
import com.tw.factory.RequestFactory;
import com.tw.specs.SpecificationFactory;
import com.tw.utils.PropertyFileReader;

public final class TC_004_Delete_Users_Test extends TestBase {
	
	private TC_004_Delete_Users_Test() {}
	
	@Test(priority=1, groups= "DeleteUser")
	public void checkDeleteApiWithSpecificId() {
		
		RequestFactory.deleteResourceById(Constants.USERS_ENDPOINT, PropertyFileReader.get("delete_user_id"))
					  .then()
					  .spec(SpecificationFactory.successfulUserDeletionSpec());
		
	}

}
