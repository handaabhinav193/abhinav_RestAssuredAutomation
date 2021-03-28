package com.restAssured.qa.TestRunner;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		//location of the feature files in project
		features = "C:\\Users\\handa\\Desktop\\WorkSpaceForAutomationProjects\\RestAssured\\src\\main\\resources\\restAPI_UserStories\\Sprints\\Sprint 1\\S001\\TC002.feature", 
		//package name where path of the step definitions are defined
		glue = {"com.restAssured.qa.steps"}, 
		//to define the format of the report
		format = {"pretty","html:test-output"}, 
		//to display the output in readable format
		monochrome = true,
		
		plugin = {"html:target/LeadershipReport/cucumber-html-report"},
		//it will fail the methods if any undefined methods are given.
		strict = false,
		// will check if the mapping is done correctly or not.
		dryRun = false 
		)
public class TestRunner {
}