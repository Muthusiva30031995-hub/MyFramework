package com.testautomation.StepDef;

import java.io.IOException;

import cucumber.api.java.en.Then;

public class ActivitiesPageStepDef extends UIBaseStepDef{
	
	@Then("^Close all the activities in activities page$")
	public void close_all_the_activities_in_activities_page() throws Exception
	{
		activitiesPage.closeActivities();
	}

}
