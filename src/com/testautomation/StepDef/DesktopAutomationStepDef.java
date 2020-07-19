package com.testautomation.StepDef;

import java.io.IOException;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DesktopAutomationStepDef extends DesktopBaseStepDef{
	
	@When("^Enter \"(.*)\" in notepad$")
	public void enter_value_in_notepad(String text) throws Exception
	{
		desktopAutomationPage.enterTextInNotepad(text);
	}
	
	@And("^Clear the entered text$")
	public void clear_the_entered_text() throws Exception
	{
		desktopAutomationPage.clearTextInNotepad();
	}
	
	@Then("^Close the notepad$")
	public void close_the_notepad() throws Exception
	{
		desktopAutomationPage.closeTheNotepad();
		
	}

	@Given("^Navigate to Security settings$")
	public void navigate_to_security_settings() throws Exception
	{
		desktopAutomationPage.IE();
	}
}
