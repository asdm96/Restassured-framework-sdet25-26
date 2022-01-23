package com.genericUtils;

import io.restassured.response.Response;
/**
 * This method will return the data from response based on json path
 * @author Adarsh M
 *
 */
public class JsonUtility {
	public String getJsonValueData(Response response,String jsonPath) {
		String jsonData = response.jsonPath().get(jsonPath);
		return jsonData;
	}

}
