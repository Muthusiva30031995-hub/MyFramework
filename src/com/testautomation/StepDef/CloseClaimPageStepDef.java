package com.testautomation.StepDef;

import com.testautomation.PageObjects.CloseClaimPage;

import cucumber.api.java.en.And;

public class CloseClaimPageStepDef extends UIBaseStepDef{
	
	@And("^Close the claim$")
	public void close_the_claim() throws Exception
	{
		closeClaimPage.closeClaim();
	}

}
