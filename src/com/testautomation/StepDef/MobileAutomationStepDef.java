package com.testautomation.StepDef;

import java.io.IOException;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MobileAutomationStepDef extends MobileBaseStepDef{

		
	@When("^Add two numbers in calculator$")
	public void add_two_numbers_in_calculator() throws Exception
	{
		mobileAutomationPage.calculatorAdd();
	}
	
	@Then("^Validate the result of additon of two numbers$")
	public void validate_the_result_of_additon_of_two_numbers() throws Exception
	{
		mobileAutomationPage.validateAdditionResult();
	}
	
	@When("^Dial a mobile number$")
	public void dial_a_mobile_number() throws Exception
	{
		mobileAutomationPage.DialNumber();
	}
}
