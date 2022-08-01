package com.StepDefinitions;

import java.io.IOException;

import com.runner.Base;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends Base{
	
	@Before
	public void beforeScenario()
	{
		launchBrowser();
	
	}

	@After
	public void afterScenario(Scenario scenario) throws IOException
	{
		if(scenario.isFailed())
		{
			ts.takeSS(driver, scenario.getName());
		}
		closeBrowser();
	}
}
