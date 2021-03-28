package com.restAssured.qa.page;

import com.restAssured.qa.utilies.RestAssuredAPI_Base;
import com.restAssured.qa.utilies.RestAssuredResources;
import com.restAssured.qa.utilies.RestAssuredUtils;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;

import java.util.concurrent.TimeUnit;

import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;

import io.restassured.path.json.JsonPath;

public class RestAssuredAPIRequests extends RestAssuredAPI_Base{
	
	RestAssuredUtils restAssuredUtility;
	
	public RestAssuredAPIRequests(RestAssuredUtils restAssuredUtility){
		super(driver);
		this.restAssuredUtility = restAssuredUtility;
	}
	

			public void getRequest() {
				/*Specifying the base URI to use REST Web Service
				 *It creates HTTP Requests against a base URI
				 *It supports creating Request of different HTTP method types (GET, POST, PUT, PATH, DELETE, UPDATE, HEAD and OPTIONS)
				 *It makes HTTP communication with the server and passes on the Request that we created in our tests to the server.
				 *Retrieves the Response from the server.
				 *Helps validate the Response received from the server.
				 */
				RestAssured.baseURI = RestAssuredResources.getRequestBaseURI();
				
				/*Gets the Request Specification of the Request that you want to sent to the Server.
				 * Server is specified by the Base URI which is sent*/
				httpRequest = RestAssured.given();
				
				/*Make a request to the server by specifying the method Type and the method URL.
				 *This will return the Response from the server. Store the response in a variable.*/
				httpResponse = httpRequest.request(Method.GET, RestAssuredResources.getRequestBasePath());
				
				
				logger.info("***********Sending GET Request**************************");
				
				//Prints Response of an API as String
				System.out.println(httpResponse.getBody().asString());
			}
			
			public int getResponseStatusCode() {
				logger.info("************Validating Status Code*************************");
				return httpResponse.getStatusCode();		//Returns Status code
			}
			
			public String getResponseStatusLine() {
				logger.info("*************Validating Status Line************************");
				System.out.println(httpResponse.getStatusLine());		//Returns Status Line
				return httpResponse.getStatusLine();
			}
			
			public String validateCityName() {
				logger.info("**********Validating value of a Node***************************");
				JsonPath jsonpathevaluator = httpResponse.jsonPath();	/*Declaring the Json path for verifying & extracting the object*/
				return jsonpathevaluator.get("City");					/*gets the value of the Key "City" from the response*/
			}
			
			public void getResponseHeaders() {
				logger.info("************Extracting Headers & there Value*************************");
				Headers allHeaders = httpResponse.headers();			/*Stores all the headers in allHeaders Object*/
				for(Header header : allHeaders) {
					System.out.println("Key: " +header.getName()+ "  ||  " + "Value: " +header.getValue());			/*Prints the Header Key & Key Value*/
				}
			}
			
			public String validateContentTypeResponseHeader() {
				logger.info("*************Validating specific header value************************");
				return httpResponse.header("Content-Type");					/*Returns the Content-Type of Header "Content-Type"*/
			}
			
			public void postRequest() {
				logger.info("************Sending Post Request*************************");
				
				httpRequest = RestAssured.given();
				httpRequest.header("Content-Type","application/json");
				JSONObject json = new JSONObject();							/*JSONObject class is used to send body as Request for an Request Fxn*/
				json.put("id", "11");
				json.put("name", "Abhinav Handa");
				json.put("username", "handaabhinav");
				json.put("email", "handaabhinavxyz@gmail.com");
				httpRequest.body(json.toJSONString());
				httpResponse = httpRequest.post(RestAssuredResources.postRequestBaseURI());
				System.out.println(httpResponse.getBody().asString());
			}
			
			public int postResponse() {
				logger.info("**************Validating status code of a Post Response***********************");
				return httpResponse.getStatusCode();
			}
			
			public boolean validateRecordCreation() {
				logger.info("***************Validating record has been created due to Post request**********************");
				boolean recordCreated = false;
				JsonPath jPath = httpResponse.jsonPath();			/*JsonPath is used to extract value of a particular Key of the Response*/
								
				System.out.println(jPath.get("name"));
				if(jPath.get("name").equals("Abhinav Handa")) {
					recordCreated = true;
				}else {
					recordCreated = false;
				}
				return recordCreated;
			}
			
			public void postRequestCustomerCreation() {
				logger.info("***************Sending Post Request for Customer Creation**********************");
				httpRequest = RestAssured.given();
				httpRequest.headers("Content-Type", "application/json");
				
				JSONObject jPostParams = new JSONObject();
				jPostParams.put("FirstName", RestAssuredUtils.userFName());
				jPostParams.put("LastName", RestAssuredUtils.userLName());
				jPostParams.put("UserName", RestAssuredUtils.userName());
				jPostParams.put("Password",RestAssuredUtils.userPassword());
				jPostParams.put("Email",RestAssuredUtils.userEmail());
				
				httpRequest.body(jPostParams.toJSONString());
				httpResponse = httpRequest.post(RestAssuredResources.postRequestBaseURICustomerCreation());
				System.out.println(httpResponse.getBody().asString());
			}
			
			public String validateCustCreationSuccessMsg() {
				logger.info("*************Extracting specific value of a particular node from the Response************************");
				JsonPath jp = httpResponse.jsonPath();
				return jp.get("SuccessCode");
			}
			
			public void putRequest() {
				logger.info("************Sending Put Request for an Update in DB*************************");
				httpRequest = RestAssured.given();
				httpRequest.header("Content-Type", "application/json");
				JSONObject jParams = new JSONObject();
				jParams.put("id", "1");
				jParams.put("name", "Abhinav Handa");
				jParams.put("salary", "400000");
				jParams.put("age", "29");
				httpRequest.body(jParams.toJSONString());
				
				httpResponse = httpRequest.put(RestAssuredResources.putRequestBaseURIEmployeeUpdate()+RestAssuredResources.putRequestBasePathEmployeeUpdate());
				System.out.println(httpResponse.getBody().asString());
			}
			
			public boolean validateRecordUpdatedWithPutRequest() {
				logger.info("************Validating if record is updated after the PUT Request was sent*************************");
				boolean recordUpdated = false;
				JsonPath jPath = httpResponse.jsonPath();
				if(httpResponse.getStatusCode() == 200) {
					if(jPath.get("name").equals("Abhinav Handa")){
						recordUpdated =true;
					}else {
						recordUpdated =false;
					}
				}
				return recordUpdated;
			}
			
			public void deleteRequest() {
				logger.info("**********Sending Delete Request***************************");
				httpRequest = RestAssured.given();
				httpResponse = httpRequest.delete(RestAssuredResources.deleteRequestBaseURI() + RestAssuredResources.deleteRequestBasePath());
				System.out.println(httpResponse.getBody().asString());
			}
			
			public String validateDELResponseMsg() {
				logger.info("**********Validating Success message for Delete Response***************************");
				JsonPath jPam = httpResponse.jsonPath();
				return jPam.get("success.text");
			}
			
			public void authenticationRequest() {
				logger.info("**************Sending Request for an API which requires authentication***********************");
				
				RestAssured.baseURI = RestAssuredResources.authenticationAPI();
				
				/*PreemptiveBasicAuthScheme java class is used to create authentication
					object which will be used to send username & password for authentication 
					of API on which we are working*/
					
																						
				PreemptiveBasicAuthScheme basicAuth = new PreemptiveBasicAuthScheme();		
				basicAuth.setUserName(restAssuredUtility.authenticationAPIUserName());
				basicAuth.setPassword(restAssuredUtility.authenticationAPIPassword());
				RestAssured.authentication = basicAuth;
				
				httpRequest = RestAssured.given();
				httpResponse = httpRequest.get();
				System.out.println(httpResponse.getBody().asString());
			}
			
			public String authenticationResponse() {
				logger.info("*********Validating specific node value from Response of an API which requires Authentication****************************");
				JsonPath jAuth = httpResponse.jsonPath();
				return jAuth.get("FaultId");
			}
			
			public void sendRequestforSynchronousAPI() {
				logger.info("************Sending Request for Synchronous API*************************");
				RestAssured.baseURI = RestAssuredResources.synchronousAPIURI();
				httpRequest = RestAssured.given();
				httpResponse = httpRequest.request(Method.GET, RestAssuredResources.synchronousAPIURI());
				
			}
			
			public int responseForSynchronousAPI() throws InterruptedException {
				logger.info("**********Validating Response of Synchronous API***************************");
				int total_pages;
				JsonPath jP = httpResponse.jsonPath();
				if(jP.get("total_pages").equals("2")) {
					System.out.println(httpResponse.getBody().asString());
					total_pages = jP.get("total_pages");
				}else {
					Thread.sleep(11000); 					//Need to find a way to implement general Explicit wait to develope more optimized automation script
					total_pages = jP.get("total_pages");
				}
				return total_pages;		
			}
				
			public void getRequestForArrayResponse() {
				logger.info("**************Sending GET Request which returns Array info in Response***********************");
				RestAssured.baseURI = RestAssuredResources.getRequestForArrayResponse();
				httpRequest = RestAssured.given();
				httpResponse = httpRequest.request(Method.GET);
			}
			
			public String readingArrayResponse() {
				logger.info("**************Reading specific array value from Array Response***********************");
				JsonPath jPath = httpResponse.jsonPath();
				return jPath.get("[4].address.geo.lat");
			}
}
