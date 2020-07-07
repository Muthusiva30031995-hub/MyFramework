package com.testautomation.StepDef;

import cucumber.api.java.en.Then;

public class ClaimStatusPageStepDef extends UIBaseStepDef{
	
	@Then("^Update claim date in claim status page$")
	public void update_claim_date_in_claim_status_page() throws Exception
	{
		claimStatusPage.claimDateUpdation();
	}

}
