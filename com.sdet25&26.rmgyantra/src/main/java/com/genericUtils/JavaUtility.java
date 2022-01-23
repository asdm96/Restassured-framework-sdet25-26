package com.genericUtils;

import java.util.Date;
import java.util.Random;
/**
 * java Utility class
 * @author Adarsh M
 *
 */
public class JavaUtility {
	/**
	 * This method will generate a random number within 5000 range
	 * @return
	 */
	public int getRandomNumber() {
		Random random = new Random();
		int randomNumber = random.nextInt(5000);
		return randomNumber;
	}
	/**
	 * This method will return system date and time
	 * @return
	 */
	public String getSystemDateAndTime() {
		Date date = new Date();
		String systemDateNAndTime = date.toString();
		return systemDateNAndTime;
	}

}
