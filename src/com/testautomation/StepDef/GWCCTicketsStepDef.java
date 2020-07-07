package com.testautomation.StepDef;



import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GWCCTicketsStepDef extends UIBaseStepDef{
	

	@When("^Search a legacy cliam \"(.*)\" in adavnce serach screen$")
	public void search_a_legacy_claim_ticket_in_advance_serach_screen(String ClaimNo) throws Exception
	{
		gwccTicketsPage.claimSearch(ClaimNo);
	}
	
	@And("^Should not get the error \"(.*)\"$")
	public void search_should_be_successful(String error) throws Exception
	{
		 gwccTicketsPage.validateErrorMessage(error); 
	}
	
	@Then("^The results should be displayed and resulted claim should be opened$")
	public void the_claim_should_be_opened() throws Exception
	{
		gwccTicketsPage.openResultedClaim();
	}

	@When("^Search a legacy policy \"(.*)\" in adavnce serach screen$")
	public void search_legacy_policy_in_advance_search_screen(String policyNo) throws Exception
	{
		gwccTicketsPage.policySearch(policyNo);
	}
	@Then("^The results should display the claims having that policy and claim should be opened$")
	public void the_results_should_display_the_claims() throws Exception
	{
		gwccTicketsPage.openResultedClaim();
	}
}
