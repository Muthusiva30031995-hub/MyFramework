package com.testautomation.StepDef;
import java.io.IOException;
import java.net.URISyntaxException;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RestAssuredAPIStepDef extends APIBaseStepDef{

	
	@Given("^Initialize the API$")
	public void initialize_the_API() throws Exception
	{
		restAssuredAPI.setup();
	}
	
	@When("^Perform GET operation for \"(.*)\"$")
	public void perform_GET_operation_for(String url) throws URISyntaxException
	{
		restAssuredAPI.GETOperation(url);
	}
	
	@When("^Perform POST operation for \"(.*)\"$")
	public void perform_POST_operation_for(String url) throws URISyntaxException
	{
		restAssuredAPI.POSTOperation(url);
	}
	
	@Then("^Verify the status code$")
	public void verify_the_status_code() throws Exception
	{
		restAssuredAPI.verifyStatusCode();
	}
	
	@Then("^Verify the status line$")
	public void verify_the_status_line() throws Exception
	{
		restAssuredAPI.verifyStatusLine();
	}
	
	@Then("^Verify the \"(.*)\" element is present in the response body$")
	public void verify_the_element_is_present_in_the_response_body(String element) throws IOException
	{
		restAssuredAPI.verifyElement(element);
	}
	
	@Then("^Verify the \"(.*)\" header value$")
	public void verify_the_header_value(String headerKey) throws Exception
	{
		restAssuredAPI.verifyHeaderValue(headerKey);
	}
	
	@Then("^Verify the \"(.*)\" response value$")
	public void verify_the_employee_name_response_value(String responseKey) throws Exception
	{
		restAssuredAPI.verifyResponseValue(responseKey);
	}
}
