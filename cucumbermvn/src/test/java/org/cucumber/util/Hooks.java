package org.cucumber.util;

import org.openqa.selenium.WebDriverException;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {
	public static Scenario scenario;
	@Before
	public void f(Scenario scenario){
		Configuration.initDriver();
		Hooks.scenario = scenario;
	}

	@After
	public void afterTest(Scenario scenario) throws InterruptedException {
		if (scenario.isFailed()) {
			try {
				Configuration.embedScreenShotToReport();
				Configuration.driver.close();
			} catch (WebDriverException e) {
			}
		}
	}
}
