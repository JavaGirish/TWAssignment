package com.tw.utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


import com.tw.constants.Constants;


public final class JsonFileReader {
	
	private static JSONParser jsonParser; 
	private static FileReader reader;
	private static JSONObject jso;
	private static Map<String,String> dataMap = new HashMap<String,String>(); 
	
	/* Method to read values from an JSON file
	 * */
	public static Map<String,String> readJsonFile()   {
		jsonParser = new JSONParser();
		try {
			reader = new FileReader(Constants.TEST_DATA_JSON_PATH);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		try {
			jso = (JSONObject) (jsonParser.parse(reader));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		
		
		@SuppressWarnings("unchecked")
		List<Map<String,String>> arr = (List<Map<String, String>>) jso.get("users");
		for(Map<String,String> mapObject: arr) {
			
			dataMap.put(mapObject.get("name"), mapObject.get("job"));
		}
		
		return dataMap;
			
	}
	
	
	/* Method to convert Map Object to an 2D array
	 * 
	 * @param: Map<String,String> mapObject
	 * @return: String[][]
	 * */
	public static String[][] convertToObjectArray(Map<String,String> mapObject) {
		String[][] strArray = new String[mapObject.size()][2];
		int count = 0;
		for(Map.Entry<String,String> entry : mapObject.entrySet()){
			strArray[count][0] = entry.getKey();
			strArray[count][1] = entry.getValue();
		    count++;
		}
		
		return strArray;
		
		
	}
	
	
	

}
