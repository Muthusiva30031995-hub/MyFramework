package com.testautomation.StepDef;

import java.io.IOException;

import cucumber.api.java.en.And;

public class CloseExposurePageStepDef extends UIBaseStepDef{
	
	@And("^Close the \"(.*)\" exposure$")
	public void close_the_exposure(String exposureName) throws Exception
	{
		closeExposurePage.closeExposure(exposureName);
	}

}
