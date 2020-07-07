package com.testautomation.PageUI;

import org.openqa.selenium.By;

public class AviationIncidentPageUI {
	public static final By aviationAddButton = By.xpath("//div[contains(@id,'FNOLWizard-FNOLWizard_NewQuickClaimScreen-QuickClaimDV-Ext_EditableAviationIncidentsLV_tb-Add')]/div");
	public static final By selectAircraft = By.xpath("//select[contains(@name,'Ext_AviationIncidentDetailDV-SelectAircraft')]");
	public static final By lossParty = By.xpath("//select[contains(@name,'AviationIncidentDetailDV-LossParty')]");
	public static final By vehicleTypeList = By.xpath("//select[contains(@name,'AviationIncidentDetailDV-Vehicle_VehicleType')]");
	public static final By year = By.xpath("//input[contains(@name,'AviationIncidentDetailDV-Vehicle_Year')]");
	public static final By aircraftMake = By.xpath("//input[contains(@name,'AviationIncidentDetailDV-Vehicle_Make')]");
	public static final By model = By.xpath("//input[contains(@name,'AviationIncidentDetailDV-Vehicle_Model')]");
	public static final By aircraftType = By.xpath("//select[contains(@name,'AviationIncidentDetailDV-AircraftType')]");
	public static final By registeredOwner = By.xpath("//select[contains(@name,'AviationIncidentDetailDV-RegisteredOwner')]");
	public static final By aircraftDamageDescription = By.xpath("//textarea[contains(@name,'AviationIncidentDetailDV-Description')]");
	public static final By aircraftInMotion = By.xpath("//select[contains(@name,'AviationIncidentDetailDV-AircraftInMotion')]");
	public static final By aviationOkButton = By.xpath("//div[@id='Ext_NewAviationIncidentPopup-Ext_NewAviationIncidentScreen-Update']");
}
