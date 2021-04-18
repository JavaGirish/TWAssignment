package com.tw.model;

import com.tw.constants.Constants;
import com.tw.model.UserPojoModel;
import com.tw.utils.GenerateFakeData;
import com.tw.utils.PropertyFileReader;

public final class DataObject {

	private static UserPojoModel pojo;

	public static synchronized UserPojoModel getPojo(String testCondition) {

	pojo = new UserPojoModel();

	switch (testCondition.toUpperCase()) {

		case "REGISTER_VALID_DATA": 
		case "LOGIN_VALID_DATA":
			pojo.setEmail(PropertyFileReader.get("reqres_user_email"));
			pojo.setPassword(PropertyFileReader.get("reqres_user_password"));
			break;

		case "BLANK_EMAIL":
			pojo.setEmail(Constants.BLANK_STRING_VALUE);
			pojo.setPassword(PropertyFileReader.get("reqres_user_password"));
			break;

		case "INVALID_EMAIL":
			pojo.setEmail(GenerateFakeData.getEmailAddress());
			pojo.setPassword(PropertyFileReader.get("reqres_user_password"));
			break;

		case "BLANK_PASSWORD":
			pojo.setEmail(PropertyFileReader.get("reqres_user_email"));
			pojo.setPassword(Constants.BLANK_STRING_VALUE);
			break;
			
		case "CREATE_USER":
			pojo.setName(PropertyFileReader.get("reqres_user_name"));
			pojo.setJob(PropertyFileReader.get("reqres_user_job"));
			break;
			
		default:
			try {
				throw new Exception("Invalid test condition provided!!");
			} 
			
			catch (Exception e) {
			   e.printStackTrace();
			}

		}

		return pojo;

	}
	
	
	
	public static synchronized UserPojoModel createUsersPojo(String userName, String job) {
		pojo = new UserPojoModel();
		
		pojo.setName(userName);
		pojo.setJob(job);
		
		return pojo;
		
		
	}




}
