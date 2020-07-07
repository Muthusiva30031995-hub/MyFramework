package com.testautomation.StepDef;

import cucumber.api.java.en.And;

public class CloseMatterPageStepDef extends UIBaseStepDef{
	
	@And("^Close the matter$")
	public void close_the_matter() throws Exception
	{
		closeMatterPage.closeMatter();
	}

}
