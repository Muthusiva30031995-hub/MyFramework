package com.testautomation.PageObjects;

import com.testautomation.Config.InstanceContainer;
import com.testautomation.PageUI.AviationIncidentPageUI;
import com.testautomation.PageUI.FNOLPageUI;

public class AviationIncidentPage extends PageBase{

	public AviationIncidentPage(InstanceContainer ic) {
		super(ic);		
	}

	
	public void addAviationDetails() throws Exception
	{
		String aircraftDamageDescription = excelData.getCommonData("AircraftDamageDescription");
		String selectAircraft = excelData.getData("AircraftList");
		String lossParty = excelData.getData("LossParty");
		String vehicleTypeList = excelData.getData("VehicleTypeList");
		String year = excelData.getData("Year");
		String make = excelData.getData("Make");
		String model = excelData.getData("Model");
		String aircraftType = excelData.getData("AircraftType");
		String registeredOwner = excelData.getData("RegisteredOwner");
		wh.clickElement(AviationIncidentPageUI.aviationAddButton, "Aviation Add Button");
		wh.selectDropDownValue (AviationIncidentPageUI.selectAircraft, selectAircraft, "Aircraft List");
		wh.selectDropDownValue (AviationIncidentPageUI.lossParty,lossParty, "Loss Party");
		wh.selectDropDownValue (AviationIncidentPageUI.vehicleTypeList,vehicleTypeList, "Vehicle Type");
		wh.enterValue(AviationIncidentPageUI.year, year, "Year Entred");
		wh.enterValue(AviationIncidentPageUI.aircraftMake, make, "Make Entred");
		wh.enterValue(AviationIncidentPageUI.model, model, "Model Entred");
		wh.selectDropDownValue (AviationIncidentPageUI.aircraftType, aircraftType, "Aircraft type");
		wh.selectDropDownValue (AviationIncidentPageUI.registeredOwner,registeredOwner, "Registered Owner");
		wh.enterValue(AviationIncidentPageUI.aircraftDamageDescription, aircraftDamageDescription, "Damage Description");
		wh.selectDropDownValue (AviationIncidentPageUI.aircraftInMotion,"No", "Vehicle Type selected");
		wh.clickElement(AviationIncidentPageUI.aviationOkButton, "Aviation OK Butoon");
		wh.waitForElementPresent(FNOLPageUI.finishButton);
	}
}
