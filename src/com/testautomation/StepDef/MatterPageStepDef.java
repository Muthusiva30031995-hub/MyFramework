package com.testautomation.StepDef;

import java.io.IOException;

import cucumber.api.java.en.Then;

public class MatterPageStepDef extends UIBaseStepDef{
	
	@Then("^Create a matter through litigation$")
	public void create_a_matter_through_litigation() throws Exception
	{
		matterPage.createMatter();
	}

}
