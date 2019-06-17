package com.cucumber.pageobjects;

import org.cucumber.util.Configuration;
import org.cucumber.util.Global;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage {

	public LoginPage(){ 
		PageFactory.initElements(Configuration.driver, this);
	}

	@FindBy(how=How.ID, using="username")
	WebElement userName_txt;

	@FindBy(how=How.ID, using="password")
	WebElement passWord_txt;

	@FindBy(how=How.ID, using="loginButton")
	WebElement login_btn;

	public void launch_app(){
		Configuration.driver.get(Global.url);
	}

	public void enter_username(String userName){
		Configuration.enterValue(userName_txt, userName);
	}

	public void enter_password(String password){
		Configuration.enterValue(passWord_txt, password);
	}

	public void select_location(String location){
		WebElement dynamicElement = Configuration.driver.findElement(By.xpath("//ul[@id='sessionLocation']/li[contains(text(),'"+location+"')]"));
		Configuration.clickOnElement(dynamicElement);
	}

	public void click_onlogin(){
		Configuration.clickOnElement(login_btn);
	}

	public void verify_Msg(){
		boolean result =  Configuration.driver.findElement(By.tagName("h4")).getText().contains("Logged");
		Assert.assertTrue(result);
		Configuration.embedScreenShotToReport();
	}

	public void close_window(){
		Configuration.driver.close();
	}

}
