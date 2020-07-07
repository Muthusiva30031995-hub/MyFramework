package com.testautomation.PageUI;

import org.openqa.selenium.By;

public class RentalDetailsPageUI {

	public static final By rentalLink = By.xpath("//div[contains(@id,'VehIncidentDetailDV-VehicleRental_CardTab')]");
	public static final By rentaAddBtn = By.xpath("//div[contains(@id,'RentalCarLV_tb-Add')]/div");
	public static final By rentalExposure = By.xpath("//select[contains(@name,'RentalListDetail-Exposure')]");
	public static final By renterList = By.xpath("//select[contains(@name,'RentalListDetail-Renter')]");
	public static final By authorizedRentalCarClass = By.xpath("//select[@name=\"EditVehicleIncidentPopup-EditVehicleIncidentScreen-VehIncidentDetailDV-RentalListDetail-RentalClassID\"]");
	public static final By renterInstructions = By.xpath("//textarea[contains(@name,'RentalListDetail-ReservationID')]");
	public static final By approvedRate = By.xpath("//input[contains(@name,'RentalListDetail-ApprovedRate')]");
	public static final By approvedDays = By.xpath("//input[contains(@name,'RentalListDetail-ApprovedDays')]");
	public static final By proximitySearch = By.xpath("//div[@id='EditVehicleIncidentPopup-EditVehicleIncidentScreen-VehIncidentDetailDV-RentalListDetail-ProximitySearchButtonInput']/div");
	public static final By proximitySearchSelect = By.xpath("//div[@id=\"EditVehicleIncidentPopup-EditVehicleIncidentScreen-VehIncidentDetailDV-RentalListDetail-Ext_ENTLV-0-SelectButtonCellENT\"]");
	public static final By rentalUpdateBtn = By.xpath("//div[contains(@id,'EditVehicleIncidentPopup-EditVehicleIncidentScreen-Update')]");
	public static final By rentalSendToBtn = By.xpath("//div[contains(@id,'VehIncidentDetailDV-RentalListDetail-ToolbarButton2')]/div");
}
