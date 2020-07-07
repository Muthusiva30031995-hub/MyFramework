package com.testautomation.PageObjects;

import java.io.IOException;

import com.testautomation.Config.InstanceContainer;
import com.testautomation.PageUI.LossDetailsPageUI;
import com.testautomation.PageUI.VehicleIncidentPageUI;

public class LossDetailsPage extends PageBase{

	public LossDetailsPage(InstanceContainer ic) {
		super(ic);
		
	}

	public void lossDetailsUpdation() throws Exception
	{
		String reponsibleParty = excelData.getCommonData("ResponsibleParty");
		String faultRating = excelData.getCommonData("FaultRating");
		String insuredPercentage = excelData.getCommonData("InsuredPercentage");
		String certificateNumber = excelData.getCommonData("CertificateNumber");
		String locationOfLoss = excelData.getCommonData("LocationOfLoss");
		String contibutingPrimaryCategory = excelData.getData("ContributingPrimaryCategory");
		String contributingSubCategory = excelData.getData("ContributingSubCategory");
		String contributingDesc = excelData.getData("ContributingDescription");
		
		wh.clickElement(LossDetailsPageUI.lossDetailsLink, "Loss Details Link");
		if(wh.isElementPresent(LossDetailsPageUI.lossDetailEditLink)) {
			wh.clickElement(LossDetailsPageUI.lossDetailEditLink, "Loss Details Edit button");
			wh.waitForElementPresent(LossDetailsPageUI.lossDetailsUpdateBtn);
			if(wh.isElementExists(LossDetailsPageUI.responsibleParty)) {
			wh.selectDropDownValue(LossDetailsPageUI.responsibleParty, reponsibleParty,"Responsible Party");
			}
			if(wh.isElementExists(LossDetailsPageUI.faultRating)) {
			wh.selectDropDownValue(LossDetailsPageUI.faultRating, faultRating,"Fault Rating");
			}
			if(wh.isElementExists(LossDetailsPageUI.insuredPercentage)) {
			wh.enterValue(LossDetailsPageUI.insuredPercentage, insuredPercentage,"Insured Percentage");
			}
			if(wh.isElementExists(LossDetailsPageUI.Reinsurance))
			{
				wh.selectDropDownValue(LossDetailsPageUI.Reinsurance, "Yes","ReInsurance value");
			}
			
			if(wh.isElementExists(LossDetailsPageUI.certificateNumber))
			{
				wh.enterValue(LossDetailsPageUI.certificateNumber, certificateNumber,"Certificate Number");
			}
			
			if(wh.isElementExists(LossDetailsPageUI.locationOfLoss)) {
			wh.selectDropDownValue(LossDetailsPageUI.locationOfLoss, locationOfLoss,"Location of Loss");
			}
			
			wh.clickElement(LossDetailsPageUI.contributingAddBtn, "Contributing Factor Add buton");
			wh.selectDropDownValue(LossDetailsPageUI.primaryCategory, contibutingPrimaryCategory,"Primary Category");
			Thread.sleep(2000);
			wh.waitForElementPresent(LossDetailsPageUI.contributingDescription);
			wh.enterValue(LossDetailsPageUI.contributingDescription, contributingDesc,"Contributing Description");			
			wh.selectDropdownByVisibleText(LossDetailsPageUI.subCategory, contributingSubCategory,"SubCategory");			
			wh.clickElement(LossDetailsPageUI.lossDetailsTitile, "Loss Details Title");
			wh.clickElement(LossDetailsPageUI.lossDetailsUpdateBtn, "Loss Details update button");
			wh.waitForElementPresent(LossDetailsPageUI.lossDetailEditLink);
		}
	}
	
	
	public void metroDetailsUpdation() throws Exception 
	{
		String metroType = excelData.getData("MetroType");
		String metroCity = excelData.getData("MetroCity");
		String metroState = excelData.getData("MetroState");
		wh.waitForElementPresent(LossDetailsPageUI.lossDetailsLink);
		wh.clickElement(LossDetailsPageUI.lossDetailsLink, "Loss Details Link");
		if(wh.isElementPresent(LossDetailsPageUI.lossDetailEditLink)) {
		wh.clickElement(LossDetailsPageUI.lossDetailEditLink, "Loss Details Edit button");
			if(wh.isElementPresent(LossDetailsPageUI.metroAddBtn)) {
				wh.clickElement(LossDetailsPageUI.metroAddBtn, "Metro Politian Add button");
				wh.waitForElementPresent(LossDetailsPageUI.metroReportType);
				wh.selectDropDownValue(LossDetailsPageUI.metroReportType, metroType,"Metro type");
				wh.enterValue(LossDetailsPageUI.metroCityOfInvestAgency, metroCity,"MetroPolitian City");
				wh.selectDropDownValue(LossDetailsPageUI.metroStateOfInvestAgency, metroState,"Metro state");
				wh.clickElement(LossDetailsPageUI.metroPolitianUpdate, "Metro politian update button");
				wh.clickElement(LossDetailsPageUI.lossDetailsUpdateBtn, "Loss Details update button");
				wh.waitForElementPresent(LossDetailsPageUI.lossDetailEditLink);
			}
	}
}
	
	public void editVehicleDetails() throws Exception 
	{
		String vehicleStyle = excelData.getData("VehicleStyle");
		wh.clickElement(VehicleIncidentPageUI.choosingVechileIncident, "Choosing Vechile Incident");
		wh.clickElement(VehicleIncidentPageUI.vehicleEditButton, "Vehicle EDIT Button");
		wh.selectDropDownValue(VehicleIncidentPageUI.vehicleStyle, vehicleStyle,"Vehicle Style");
		wh.clickElement(VehicleIncidentPageUI.vehicleUpdateButton, "Vehicle Update Button");
		wh.clickElement(LossDetailsPageUI.lossDetailsUpdateBtn, "Loss Details update button");
		wh.waitForElementPresent(LossDetailsPageUI.lossDetailsTitile);
	}
	public void addVehicleAprraisal() throws Exception 
	{
		String vehicleRadius = excelData.getCommonData("VehicleRadius");
		String vehiclePostalCode = excelData.getCommonData("VehiclePostalCode");
		wh.clickElement(VehicleIncidentPageUI.choosingVechileIncident, "Choosing Vechile Incident");
		wh.clickElement(VehicleIncidentPageUI.appraisalLink, "Appraisal Link");
		wh.clickElement(VehicleIncidentPageUI.evaluateLink, "Evaluate Link");
		wh.selectDropDownValue(VehicleIncidentPageUI.radiusList, vehicleRadius,"Radius List");
		wh.enterValue(VehicleIncidentPageUI.postalCode, vehiclePostalCode,"Vehicle Damage Desc");
		wh.clickElement(VehicleIncidentPageUI.shop1Link, "Shop1 Link");
		wh.clickElement(VehicleIncidentPageUI.selectShop, "Select Shop Link");
	}
	
	public void validateSendToSymbility() throws Exception
	{
		wh.clickElement(LossDetailsPageUI.lossDetailsLink, "Loss Details Link");
		wh.waitForElementPresent(LossDetailsPageUI.lossDetailsTitile);
		wh.clickElement(LossDetailsPageUI.estimatesLink, "Estimates link");
		wh.validateText(LossDetailsPageUI.symbilitySendStatus, "Not Sent", "Symbility send status");
		wh.clickElement(LossDetailsPageUI.sendToSymbility, "Send To Symbility");
		if(wh.isElementPresent(LossDetailsPageUI.notifyVendorOfAssignment)) {
		wh.validateText(LossDetailsPageUI.symbilitySendStatus, "Sent", "Symbility send status");
		}
		wh.clickElement(LossDetailsPageUI.estimatesLink, "Estimates link");
	}
	
	
}
