package com.restAssured.qa.steps;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.restAssured.qa.page.*;
import com.restAssured.qa.utilies.RestAssuredAPI_Base;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class RestAssuredAPISteps {

	public static RestAssuredAPIRequests requestAPI = new RestAssuredAPIRequests(null) ;
	
			@Given ("Test Specialist sends GET Request")
			public void sendingRequest() {
				requestAPI.getRequest();
			}
			
			@Then ("Test Specialist validates the status code in GET Response")
			public void getRequestCode() {
				Assert.assertEquals(requestAPI.getResponseStatusCode(), 200);
			}
			
			@Then ("Test Specialist validates status line in GET Response")
			public void getRequestLine() {
				Assert.assertTrue(requestAPI.getResponseStatusLine().contains("HTTP/1.1 200 OK"));
			}
			
			@Then ("Test Specialist validates city Name is Chandigarh from Response received from the GET Request")
			public void getCityName() {
				Assert.assertEquals(requestAPI.validateCityName(), "Chandigarh");
			}
			
			@Then ("Test Specialist fetches all the headers from the GET Response")
			public void getResponseHeaders() {
				requestAPI.getResponseHeaders();
			}
			
			@Given ("Test Specialist sends a POST Request")
			public void postRequestAPI() {
				requestAPI.postRequest();
			}
			
			@Then ("Test Specialist validates the status code for the POST Response")
			public void postResponseAPI() {
				Assert.assertEquals(requestAPI.postResponse(), 201);
			}
			
			@ Then ("Test Specialist validates record is created with the name Abhinav")
			public void validationForRecordCreation() {
				Assert.assertTrue(requestAPI.validateRecordCreation());
			}
			
			@Then ("Test Specialist validates value of header Content Type")
			public void validateContentTypeHeaderValue() {
				Assert.assertEquals(requestAPI.validateContentTypeResponseHeader(), "application/json");
			}
			
			@Given ("Test Specialist registers a new Customer using POST Request")
			public void postRequestCreateCustomer() {
				requestAPI.postRequestCustomerCreation();
			}
			
			@Then ("Test Specialist validates success message for Customer registration")
			public void validateSuccessMsgCustCreation() {
				Assert.assertEquals(requestAPI.validateCustCreationSuccessMsg(), "OPERATION_SUCCESS");
			}
			
			@Given ("Test Specialist sends a PUT request with details")
			public void sendPUTRequest() {
				requestAPI.putRequest();
			}
			
			@Then ("Test Specialist validates record is updated in the database")
			public void validatePutResponseRecordUpdate() {
				Assert.assertTrue(requestAPI.validateRecordUpdatedWithPutRequest());
			}
			
			@Given ("Test Specialist sends a DELETE Request")
			public void sendDELETERequest() {
				requestAPI.deleteRequest();
			}
			
			@Then ("Validate successful Deletion Message in DELETE Response")
			public void validateSuccessfulDELETEResponseMsg() {
				Assert.assertEquals(requestAPI.validateDELResponseMsg(), "successfully! deleted Records");
			}
			
			@Given ("Test Specialist sends a GET request with authentication credentials")
			public void authenticationGETRequest() {
				requestAPI.authenticationRequest();
			}
			
			@Then  ("Validate authentication success message with reference status code")
			public void authenticationGETResponse() {
				Assert.assertEquals(requestAPI.authenticationResponse(), "OPERATION_SUCCESS");
			}
			
			@Given ("Test Specialist sends request to a Synchronouse API Server")
			public void synchronousAPIRequest() {
				requestAPI.sendRequestforSynchronousAPI();
			}
			
			@Then  ("Test Specialist validates value of node total_pages")
			public void synchronousAPIResponse() throws InterruptedException {
				Assert.assertEquals(requestAPI.responseForSynchronousAPI(), 2);
			}
			
			@Given ("Test Specialist sends request for an Array Response")
			public void getRequestForArrayResponse() {
				requestAPI.getRequestForArrayResponse();
			}
			
			@Then  ("Test Specialist validates value a particular node from the Array Response")
			public void getArrayResponse() {
				Assert.assertEquals(requestAPI.readingArrayResponse(), "-31.8129");
			}
			
}
