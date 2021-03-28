$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("C:/Users/handa/Desktop/WorkSpaceForAutomationProjects/RestAssured/src/main/resources/restAPI_UserStories/Sprints/Sprint 1/S001/TC002.feature");
formatter.feature({
  "line": 1,
  "name": "Validating POST Request",
  "description": "",
  "id": "validating-post-request",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 3,
  "name": "POST Request Example",
  "description": "",
  "id": "validating-post-request;post-request-example",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 4,
  "name": "Test Specialist sends a POST Request",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "Test Specialist validates the status code for the POST Response",
  "keyword": "Then "
});
formatter.match({
  "location": "RestAssuredAPISteps.postRequestAPI()"
});
formatter.result({
  "duration": 4637728400,
  "status": "passed"
});
formatter.match({
  "location": "RestAssuredAPISteps.postResponseAPI()"
});
formatter.result({
  "duration": 403379399,
  "status": "passed"
});
});