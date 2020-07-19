package com.testautomation.StepDef;

import java.io.IOException;

import com.testautomation.Config.InstanceContainer;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class FNOLPageStepDef extends UIBaseStepDef{
	
	

	@And("^Search a contact$")
	public void search_a_contact() throws Exception {
		searchContactPage.searchContact();
	}
	
	@Then("^Enter details in FNOL page$")
	public void enterdetails_in_FNOL_page() throws Exception {
		fnolPage.enterDetailsInFNOLPage();
	}
	
	@And("^Add injury incident in FNOL page$")
	public void add_injury_incident_in_FNOL_page() throws Exception {
		injuryIncidentPage.addInjuryDetails();
	}
	
	@And("^Add property incident in FNOL page$")
	public void add_property_incident_in_FNOL_page() throws Exception {
		propertyIncidentPage.addPropertyIncidentDetails();
	}
	
	@And("^Add dwelling incident in FNOL page$")
	public void add_dwelling_incident_in_FNOL_page() throws Exception
	{
		dwellingIncidentPage.addDwellingIncidentDetails();
	}
	
	@And("^Add aviation incident in FNOL page$")
	public void add_aviation_incident_in_FNOL_page() throws Exception
	{
		aviationIncidentPage.addAviationDetails();	
		
	}
	
	@And("^Add vehicle incident for \"(.*)\" in FNOL page$")
	public void add_vehicle_incident_for_in_FNOL_page(String selectVehicle) throws Exception
	{
		vehicleIncidentPage.addVehicleDetails(selectVehicle);
	}
	
	@And("^Click on finish button in FNOL page$")
	public void click_on_finish_button_in_FNOL_page() throws Exception {
		fnolPage.clickFinish();
	}

}
