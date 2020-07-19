package com.testautomation.StepDef;

import cucumber.api.java.en.Given;

public class MobileAutomationStepDef extends MobileBaseStepDef{

	@Given("^Open \"(.*)\" app$")
	public void Open_app(String appName)
	{
		mobileAutomationPage.openApp(appName);
	}
	
}
