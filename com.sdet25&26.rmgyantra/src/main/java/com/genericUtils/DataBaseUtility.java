package com.genericUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;
/**
 * database utility class
 * @author Adarsh M
 *
 */
public class DataBaseUtility {
	Connection connection=null;
	/**
	 * This method will do the connection to database
	 * @throws Throwable
	 */
	public void connectDB() throws Throwable {
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		connection= DriverManager.getConnection(EndPoints.DATABASE_URL,"root","root");

	}
	/**
	 * This method will close the data base connection
	 * @throws Throwable
	 */
	public void closeDB()  {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * This method will return all the data from database
	 * @param querry
	 * @return
	 */
	public ResultSet getAllData(String querry) {
		ResultSet result = null;
		try {
			result = connection.createStatement().executeQuery(querry);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	/**
	 * This method will match the column data based on the expectedData 
	 * @param querry
	 * @param columnNumber
	 * @param expectedData
	 * @return
	 * @throws Throwable
	 */
	public String getAndVerifyTheData(String querry,int columnNumber,String expectedData) throws Throwable {
		ResultSet result = connection.createStatement().executeQuery(querry);
		String actualData = null;
		boolean flag=false;
		try {
			while(result.next()) {
				String dbData = result.getString(columnNumber);
				if(dbData.equals(expectedData)) {
					actualData=dbData;
					flag=true;
					break;  
				}
			}
		} catch (Exception e) {

		}

		if(flag) {
			System.out.println("Data is present and verified ");
			return actualData;
		}else {
			System.out.println("Data is not present in database");
			return actualData;
		}
	}

}
