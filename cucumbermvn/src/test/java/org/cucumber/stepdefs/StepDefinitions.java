package org.cucumber.stepdefs;


import org.cucumber.util.Configuration;
import org.cucumber.util.Hooks;

import com.cucumber.pageobjects.LoginPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class StepDefinitions 
{
	LoginPage objLogin = new LoginPage();
	
	
	@Given("^user login to application with \"([^\"]*)\" and \"([^\"]*)\"$")
	public void login_to_application(String username,String password) throws Throwable {
		objLogin.launch_app();
		objLogin.enter_username(Hooks.data.get(username));
		objLogin.enter_password(Hooks.data.get(password));	  
	}

	@When("^user select \"([^\"]*)\" and do login$")
	public void select_location(String location) throws Throwable {
		objLogin.select_location(Hooks.data.get(location));
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