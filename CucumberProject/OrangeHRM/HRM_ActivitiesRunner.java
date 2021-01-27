package com.cucumber_runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
	
    features = "Features\\OrangeHRM.feature",
    glue = {"com.cucumber_stepDefinitions"},
    tags = "@CreatingJobVacancy or @AddingCandidate or @AddingMultipleEmployees or @CreatingMultipleVacancies",
    plugin= {"html:reports/json_report.html"},
    monochrome=true
   
  )

public class HRM_ActivitiesRunner {

}
