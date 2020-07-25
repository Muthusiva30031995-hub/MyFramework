package com.testautomation.StepDef;

import java.io.IOException;

import cucumber.api.java.en.And;
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
	
	@When("Send a message through messages app")
	public void send_a_message_through_messages_app() throws Exception
	{
		mobileAutomationPage.sendMessage();
	}
	
	@When("^Navigate to views and click on \"(.*)\"$")
	public void navigate_to_views_and_click_on(String text) throws Exception
	{
		mobileAutomationPage.APIDemoOperation1(text);
	}
	
	@And("Navigate to dark theme and perform basic operations")
	public void navigate_to_dark_theme_and_perform_basic_operations() throws Exception
	{
		mobileAutomationPage.APIDemoOperation2();
	}
}
