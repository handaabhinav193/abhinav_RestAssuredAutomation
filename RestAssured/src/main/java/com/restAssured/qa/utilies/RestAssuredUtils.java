package com.restAssured.qa.utilies;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.restAssured.qa.base.*;

public class RestAssuredUtils {
	
		//Returns a random String which is used as First Name
		public static String userFName() {
			return "FirstName" + RandomStringUtils.random(5);
		}
		//Returns a random String which is used as Last Name
		public static String userLName() {
			return "LastName"+ RandomStringUtils.random(5);
		}
		//Returns a random String which is used as username for a profile
		public static String userName() {
			return "handaabhinav" + RandomStringUtils.random(5);
		}
		
		//Returns a random String which is used as password for a profile
		public static String userPassword() {
			return "xxxxxxx" + RandomStringUtils.random(5);
		}
		
		//Returns a random String which is used as random email
		public static String userEmail() {
			return RandomStringUtils.random(5) + "@gmail.com";
		}
		
		//Returns username for an API which needs authentication
		public String authenticationAPIUserName() {
			return "ToolsQA";
		}
		
		//Returns password for an API which needs authentication
		public String authenticationAPIPassword() {
			return "TestPassword";
		}
	 
}