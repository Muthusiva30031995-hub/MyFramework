package com.testautomation.StepDef;

import java.io.IOException;

import cucumber.api.java.en.Then;

public class MSPDetailsPageStepDef extends UIBaseStepDef{

	@Then("^Add MSP details for \"(.*)\" exposure$")
	public void  add_MSP_details_for_exposure(String exposureName) throws Exception
	{
		mspDetailsPage.addMSPDetails(exposureName);
	}
	
	@Then("^Add MSP details for \"(.*)\" with \"(.*)\" and \"(.*)\"$")
	public void add_msp_details_for_bodily_injury_with_SSN_exists_and_MBI_not_exists(String exposureName,String ssnStatus,String mbiStatus) throws Exception	
	{
		mspDetailsPage.addMSPDetails1(exposureName,ssnStatus,mbiStatus);
	}
}
