package com.tw.tests;

import java.util.Map;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tw.base.TestBase;
import com.tw.constants.Constants;
import com.tw.factory.RequestFactory;
import com.tw.model.DataObject;
import com.tw.specs.PostResponseSpecification;
import com.tw.utils.JsonFileReader;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Feature("Feature: ReqRes UserCreation API")
public final class TC_03_Create_User_Test extends TestBase {
	
	private TC_03_Create_User_Test() {}
	
	@Story("Check if user is able to create an new single user with valid data")
	@Description("Test case to validate if we are able to successfully create an user with valid name and job details")
	@Severity(SeverityLevel.CRITICAL)
	@Test(priority=1, groups= {"CreateUser","All"})
	public void checkCreateUsersApiWIthValidData() {
		
		RequestFactory.doPostRequest(Constants.USERS_ENDPOINT, DataObject.getPojo("CREATE_USER"))
		  			  .then()
                      .spec(PostResponseSpecification.successfulUserCreationSpec(DataObject.getPojo("CREATE_USER")));
	
	}
	
	
	@Story("Check if user is able to create multiple users with valid data")
	@Description("Test case to validate if we are able to successfully multiple users with valid name and job details")
	@Test(priority=2, groups= {"CreateUser","All"}, dataProvider= "getUsersData")
	public void checkCreateMultipleUsersApiWIthValidData(String name, String job) {
		
		RequestFactory.doPostRequest(Constants.USERS_ENDPOINT, DataObject.createUsersPojo(name, job))
					  .then()
					  .spec(PostResponseSpecification.successfulUserCreationSpec(DataObject.createUsersPojo(name, job)));
	
	}
	
	
	
	@DataProvider(name= "getUsersData")
	public String[][] getData() {
		
		Map<String,String> dataValues = JsonFileReader.readJsonFile();
		
		return JsonFileReader.convertToObjectArray(dataValues);
		
	}
	
	
	
	
	
	

}
