package com.testautomation.StepDef;

import java.io.IOException;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SymbilityStepDef extends DesktopBaseStepDef{
	
	@When("^Login to the symbility application$")
	public void login_to_the_symbility_application() throws Exception
	{
		symbilityPage.LoginSymbility();
	}
	
	
	@And("^Search a claim$")
	public void search_a_claim() throws Exception
	{
		symbilityPage.seachClaim();
	}
	
}
