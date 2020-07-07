package com.testautomation.StepDef;

import java.io.IOException;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LossDetailsPageStepDef extends UIBaseStepDef{

	
	@When("^Enter details in loss details page$")
	public void enter_details_in_loss_details_page() throws Exception
	{
		lossDetailsPage.lossDetailsUpdation();
	}
	
	@Then("^Add metro politian details in loss details page$")
	public void add_metro_politian_details_in_loss_details_page() throws Exception
	{
		lossDetailsPage.metroDetailsUpdation();
	}
	
	@Then("^Edit vehicle details and add vehicle Style$")
	public void Edit_vehicle_details_and_add_vehicle_Style() throws Exception
	{
		lossDetailsPage.editVehicleDetails();
	}
	@Then("^Add vehicle appraisal in loss details page$")
	public void Add_vehicle_appraisal() throws Exception
	{
		lossDetailsPage.addVehicleAprraisal();
	}
	@Then("^Add Rental Details in Vehicle incident from loss details page$")
	public void Add_Rental_Details_in_Vehicle_incident_from_loss_details_page() throws Exception
	{
		rentalDetailsPage.addingRentalDetails();
	}
	
	@Then("^Navigate to estimates screen and validate symbility status$")
	public void navigate_to_estimates_screen_and_validate_symbility_status() throws Exception
	{
		lossDetailsPage.validateSendToSymbility();
	}
}
