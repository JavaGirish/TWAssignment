package com.tw.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

import com.tw.constants.Constants;

public final class PropertyFileReader {
	
	private static Properties property = new Properties();
	private static final Map<String, String> configMap = new HashMap<String, String>();

	
	private PropertyFileReader() {}

	static {
		try{
			
			FileInputStream file = new FileInputStream(Constants.CONFIG_FILE_PATH);
			property.load(file);
			for (Map.Entry<Object, Object> entry : property.entrySet()) {
				configMap.put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()).trim()); 
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(0);
		} 
	}

	public static String get(String key)  {
		if (Objects.isNull(key) || Objects.isNull(configMap.get(key.toLowerCase()))) {
			try {
				throw new Exception("Property name " + key + " is not found. Please check config.properties");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return configMap.get(key.toLowerCase());
	}

}
