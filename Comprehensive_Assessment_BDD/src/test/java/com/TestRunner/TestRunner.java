package com.TestRunner;



import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features= {"Features"},
		glue= {"com.StepDefinitions"},
		dryRun=false,
		monochrome=true,
		plugin= {"pretty","html:target/HtmlReports/report.html","json:target/JSonReport/Toothbrush.json",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
		 
		)

public class TestRunner {
	


}
