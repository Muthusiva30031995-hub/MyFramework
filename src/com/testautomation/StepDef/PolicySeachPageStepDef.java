package com.testautomation.StepDef;

import java.io.IOException;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;

public class PolicySeachPageStepDef extends UIBaseStepDef{
	
	@When("^Search a policy and select \"(.*)\" type$")
	public void search_a_policy_and_select(String typeOfClaim) throws Exception
	{
		policySearchPage.searchPolicy(typeOfClaim);
	}
	
	@And("^Click Next button in Step 2 of 3 policy properties page$")
	public void click_next_button_in_step_2_of_3_policy_properties_page() throws Exception
	{
		policySearchPage.step2NextBtn();
	}
	
	@When("^Search an existing claim \"(.*)\"$")
	public void search_an_existing_claim(String claimNo) throws Exception
	{
		policySearchPage.searchExistingClaim(claimNo);
	}

}
