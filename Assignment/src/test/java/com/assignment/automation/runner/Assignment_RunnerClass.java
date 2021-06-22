package com.assignment.automation.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;




@RunWith(Cucumber.class)				
@CucumberOptions(
			features="C:\\Users\\User1\\.jenkins\\Assignment\\src\\test\\java\\com\\assignment\\automation\\feature\\Assignment.feature",
			glue={"com.assignment.automation.stepdefination"},
			
					
			//plugin = {"pretty", "html:target/Cucumberreports"}  ,
			monochrome = true
			)
		
public class Assignment_RunnerClass  {

}
