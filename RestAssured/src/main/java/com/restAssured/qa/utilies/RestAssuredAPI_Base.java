package com.restAssured.qa.utilies;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.apache.log4j.Level;
import org.testng.annotations.BeforeClass;


import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestAssuredAPI_Base{
	
	public static WebDriver driver;
	
	public RestAssuredAPI_Base(WebDriver driver){
		this.driver = driver;
	}
	
	public RequestSpecification httpRequest;
	public Response httpResponse;
	
	public Logger logger = Logger.getLogger(RestAssuredAPI_Base.class);				//Adding logger object for Logging fxn
	
	@BeforeClass
	public void setUp() {
		logger = Logger.getLogger("Rest Assured API Automation Testing");
		PropertyConfigurator.configure("C:\\Users\\handa\\Desktop\\WorkSpaceForAutomationProjects\\RestAssured\\src\\main\\resources\\Log4j.properties");
		logger.setLevel(Level.DEBUG);
	}
	

}
