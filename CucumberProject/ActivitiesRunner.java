package com.cucumber_runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "Features",
    glue = {"com.cucumber_stepDefinitions"},
   tags = "@CreateUser or @SearchJob or @PostingJob or @PostingJob_Examples",
    plugin= {"html:reports/json_report.html"},
    monochrome=true
   
  )

public class ActivitiesRunner {

}
