package com.testautomation.PageObjects;

import java.io.IOException;

import com.testautomation.Config.InstanceContainer;
import com.testautomation.PageUI.LossDetailsPageUI;
import com.testautomation.PageUI.RentalDetailsPageUI;
import com.testautomation.PageUI.VehicleIncidentPageUI;

public class RentalDetailsPage extends PageBase{

	public RentalDetailsPage(InstanceContainer ic) {
		super(ic);
	}
public void addingRentalDetails() throws Exception {

	String renterExposure = excelData.getData("RenterExposure");
	String renterList = excelData.getData("RenterList");
	String renterInstructions = excelData.getData("RenterInstructions");
	String approvedRate = excelData.getData("ApprovedRate");
	String approvedDays = excelData.getData("ApprovedDays");
	String authorizedRentalCarClass = excelData.getData("authorizedRentalCarClass");
	wh.clickElement(LossDetailsPageUI.lossDetailsLink, "Loss Details Link");
	wh.clickElement(VehicleIncidentPageUI.choosingVechileIncident, "Choosing Vechile Incident");
	wh.clickElement(RentalDetailsPageUI.rentalLink," Rental Link");
	wh.clickElement(VehicleIncidentPageUI.vehicleEditButton, "Vehicle EDIT Button");
	wh.clickElement(RentalDetailsPageUI.rentaAddBtn,"Rental Add Button");
	wh.selectDropDownValue(RentalDetailsPageUI.rentalExposure, renterExposure, "Renter Exposure");
	wh.selectDropDownValue(RentalDetailsPageUI.renterList, renterList, "Renter List");
	if(wh.isElementExists(RentalDetailsPageUI.authorizedRentalCarClass)) {
		wh.selectDropDownValue(RentalDetailsPageUI.authorizedRentalCarClass, authorizedRentalCarClass,"Authorized Rental Car Class");
	}
	wh.enterValue(RentalDetailsPageUI.renterInstructions, renterInstructions, "Renter Instructions");
	wh.enterValue(RentalDetailsPageUI.approvedRate, approvedRate, "Approved Rate");
	wh.enterValue(RentalDetailsPageUI.approvedDays, approvedDays, "Approved Days");
	wh.clickElement(RentalDetailsPageUI.proximitySearch,"Proximity search Link");
	wh.clickElement(RentalDetailsPageUI.proximitySearchSelect,"Proximity search Selecting shop Link");
	wh.clickElement(RentalDetailsPageUI.rentalUpdateBtn,"Update Button");
	wh.clickElement(VehicleIncidentPageUI.choosingVechileIncident, "Choosing Vechile Incident");
	wh.clickElement(RentalDetailsPageUI.rentalLink," Rental Link");
	wh.clickElement(RentalDetailsPageUI.rentalSendToBtn,"Rental Send To Button");
	
}

}