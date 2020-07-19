package com.testautomation.StepDef;

import java.io.IOException;

import com.testautomation.PageObjects.RepairDetailsPage;


import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ExposureStepDef extends UIBaseStepDef{
	
	@When("^Navigate to \"(.*)\" exposure through \"(.*)\"$")
	public void navigate_to_dwelling_exposure(String exposureName,String path) throws Exception
	{
		exposurePage.exposureNavigation(exposureName,path);
	}
	
	@When("^Navigate to \"(.*)\" exposure through \"(.*)\" coverage$")
	public void navigate_to_dwelling_exposure_coverage(String exposureName,String path) throws Exception
	{
		exposurePage.exposureNavigationByName(exposureName,path);
	}
	
	@Then("^Add details for exposure \"(.*)\" in exposure page$")
	public void add_details_in_exposure_page(String exposure_Order) throws Exception
	{
		exposurePage.ExposureUpdation(exposure_Order);
	}
	@Then("^Add rental details in vehicle damage exposure$")
	public void add_rental_details_in_vehcle_damage_exposures() throws Exception
	{
		repairDetailsPage.updatingRepairDetails();
	}

	@Then("^Add salvage details in vehicle damage exposure$")
	public void add_salvage_details_in_vehcle_damage_exposures() throws Exception
	{
		salvageDetailsPage.addingSalvageDetails();
	}
	@Then("^Add Non salvage details in vehicle damage exposure$")
	public void add_non_salvage_details_in_vehcle_damage_exposures() throws Exception
	{
		salvageDetailsPage.addingNonSalvageDetails();
	}
}
