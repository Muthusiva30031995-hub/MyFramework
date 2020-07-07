package com.testautomation.StepDef;



import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class LoginPageStepDef extends UIBaseStepDef{	
	

	@Given("Open \"(.*)\" environment")
	public void i_am_on_gwcc_environment(String application) throws Exception {
		loginPage.openApplication(application);
	}	
	
	@And("^Login to the application$")
	public void login_to_the_application() throws Throwable {		
		loginPage.Login();		
	}

	@Given("^Login to the application with TestUserID$")
	public void login_to_the_application_with_testuserID_and_password() throws Throwable {		
		loginPage.Logindynamic();		
	}
	@And("^Logout to the application$")
	public void logout_to_the_application() throws Throwable {		
		loginPage.Logout();		
	}
}
