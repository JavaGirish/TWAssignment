package com.tw.utils;

import java.util.Map;

import org.testng.annotations.DataProvider;

public class DataUtils {
	
	
	/* DataProvider Method to provide data to be used in tests
	 * */
	@DataProvider(name= "getUsersData")
	public String[][] getData() {
		
		Map<String,String> dataValues = JsonFileReader.readJsonFile();
		
		return JsonFileReader.convertToObjectArray(dataValues);
		
	}
	
	

}
