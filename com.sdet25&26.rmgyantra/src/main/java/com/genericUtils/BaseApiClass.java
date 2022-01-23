package com.genericUtils;


import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.port;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
/**
 * Base api class used to provide all the repeated actions
 * @author Adarsh M
 *
 */
public class BaseApiClass {
	
	public DataBaseUtility dbUtil = new DataBaseUtility();
	public JavaUtility jUtil = new JavaUtility();
	public JsonUtility jsonUtil=new JsonUtility();
	
	@BeforeSuite
	public void BS() throws Throwable {
	
		System.out.println("Data base connection is started");
		dbUtil.connectDB();
		System.out.println("Connected to database");
		baseURI="http://localhost";
		port=8084;
	}
    @AfterSuite
    public void AS() {
    	dbUtil.closeDB();
    	System.out.println("database is closed");
    }
}
