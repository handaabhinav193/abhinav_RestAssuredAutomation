package com.restAssured.qa.utilies;

public class RestAssuredResources {
	
	// Example of a GET Request
	public static String getRequestBaseURI() {
		return "http://restapi.demoqa.com/utilities/weather/city";
	}
	
	//Basepath of above GET Request
	public static String getRequestBasePath() {
		return "/Chandigarh";
	}
	
	//Example of a GET Request with Response in Array
	public static String getRequestForArrayResponse() {
		return "https://jsonplaceholder.typicode.com/users";
	}
	
	//Example of a POST Request
	public static String postRequestBaseURI() {
		return "https://jsonplaceholder.typicode.com/users";
	}
	
	//Another Example of a POST Request
	public static String postRequestBaseURICustomerCreation() {
		return "http://restapi.demoqa.com/customer/register";
	}
	
	//Example of a PUT Request
	public static String putRequestBaseURIEmployeeUpdate() {
		return "http://dummy.restapiexample.com/api/v1";
	}
	
	//Basepath of above PUT Request
	public static String putRequestBasePathEmployeeUpdate() {
		return "/update/15410";
	}
	//Example of a DELETE Request
	public static String deleteRequestBaseURI() {
		return "http://dummy.restapiexample.com/api/v1";
	}
	
	//Basepath of above DELETE Request
	public static String deleteRequestBasePath() {
		return "/delete/2";
	}
	
	//Example of an Authentication API Resource
	public static String authenticationAPI() {
		return "http://restapi.demoqa.com/authentication/CheckForAuthentication";
	}
	
	public static String synchronousAPIURI() {
		return "https://reqres.in/api/users?delay=7";
	}

}
