#Author: Abhinav Handa (handaabhinav1991@gmail.com)

Feature: API requiring authentication 

	Scenario: Validate API which requires credentials to be passed as paramters for accessing the API
	
		Given Test Specialist sends a GET request with authentication credentials
		Then  Validate authentication success message with reference status code