#Author: Abhinav Handa (handaabhinav1991@gmail.com)

Feature: POST Request Example

  Scenario: Validating POST Request sends back successful status code with new record being created
    Given Test Specialist sends a POST Request
    Then Test Specialist validates the status code for the POST Response
    Then Test Specialist validates record is created with the name Abhinav