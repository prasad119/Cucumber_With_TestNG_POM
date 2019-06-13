package org.cucumber.stepdefs;


import org.cucumber.util.Configuration;
import org.cucumber.util.Hooks;
import com.cucumber.pageobjects.LoginPage;
import org.openqa.selenium.By;
import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class StepDefinitions 
{
	LoginPage objLogin = new LoginPage();
	
	@Given("^user launch and enter the \"([^\"]*)\" and \"([^\"]*)\"$")
	public void login_to_application(String userName,String passWord) throws Throwable {
		objLogin.launch_app();
		objLogin.enter_username(userName);
		objLogin.enter_password(passWord);	  
	}

	@When("^user select location \"([^\"]*)\" and do login$")
	public void select_location(String location) throws Throwable {
		objLogin.select_location(location);
		objLogin.click_onlogin();
	}

	@Then("^verify Msg$")
	public void verify_Msg() throws Throwable {
		objLogin.verify_Msg();
	}

	@Then("^Close Window$")
	public void close_window() throws Throwable {
		Configuration.closeWindow();
	}
}