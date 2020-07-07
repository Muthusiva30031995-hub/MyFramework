package com.testautomation.PageUI;

import org.openqa.selenium.By;

public class VehicleIncidentPageUI {

	public static final By vehicleAddButton = By.xpath("//div[contains(@id,'QuickClaimDV-EditableVehicleIncidentsLV_tb-Add')]/div");
	public static final By vehicleEditButton = By.xpath("//div[@id='EditVehicleIncidentPopup-EditVehicleIncidentScreen-Edit']/div");
	public static final By choosingVechileIncident = By.xpath("(//div[contains(@id,'LossDetailsDV-EditableVehicleIncidentsLV-0-Make')])[1]");
	public static final By selectVehicle = By.xpath("//select[contains(@name,\"VehicleIncidentDV-Vehicle_Picker\")]");
	public static final By lossParty = By.xpath("//select[contains(@name,'VehicleIncidentDV-LossParty')]");
	public static final By vehicleType = By.xpath("//select[contains(@name,'VehicleIncidentDV-Vehicle_VehicleType')]");
	public static final By vehicleYear = By.xpath("//input[contains(@name,'VehicleIncidentDV-Vehicle_Year')]");
	public static final By vehicleMake = By.xpath("//select[contains(@name,'VehicleIncidentDV-Vehicle_Vehicle_Make')]");
	public static final By vehicleModel = By.xpath("//input[contains(@name,'VehicleIncidentDV-Vehicle_Model')]");
	public static final By unformattedMake = By.xpath("//input[contains(@name,'VehicleIncidentDV-Vehicle_Make')]");
	public static final By vin = By.xpath("//input[contains(@name,'VehicleIncidentDV-Vehicle_VIN')]");
	public static final By driverName = By.xpath("//select[contains(@name,'VehicleIncidentDV-DriverRangeInput')]");
	public static final By owner = By.xpath("//select[contains(@name,'VehicleIncidentDV-Owner_Picker')]");
	public static final By vehicleDamageDesc = By.xpath("//textarea[contains(@name,'VehicleIncidentDV-Description')]");
	public static final By wasThrPhyDamToVhcl = By.xpath("//input[@id=\"NewVehicleIncidentPopup-NewVehicleIncidentScreen-VehIncidentDetailDV-VehicleIncidentDV-WasVehicalPhysicallyDamaged_0\"]");
	public static final By wasTheVhclParked = By.xpath("//input[@id=\"NewVehicleIncidentPopup-NewVehicleIncidentScreen-VehIncidentDetailDV-VehicleIncidentDV-VehicleParked_1\"]");
	public static final By lossOccured = By.xpath("//select[@name=\"NewVehicleIncidentPopup-NewVehicleIncidentScreen-VehIncidentDetailDV-VehicleIncidentDV-LossOccured\"]");
	public static final By airBagsDeploy = By.xpath("//input[@id=\"NewVehicleIncidentPopup-NewVehicleIncidentScreen-VehIncidentDetailDV-VehicleIncidentDV-Exposure_AirbagsDeployed_1\"]");
	public static final By driveable = By.xpath("//input[contains(@id,'VehIncidentDetailDV-VehicleIncidentDV-Operable_0')]");
	public static final By totalLoss = By.xpath("//input[contains(@id,'NewVehicleIncidentPopup-NewVehicleIncidentScreen-VehIncidentDetailDV-VehicleIncidentDV-TotalLoss_0')]");
	public static final By doesQBEhavePermToVhcl = By.xpath("//input[contains(@id,'VehicleIncidentDV-QBEPermToMoveVehicle_0')]");
	public static final By hasAnEsthclDam = By.xpath("//input[contains(@id,'VehicleIncidentDV-VehicleDamageEstimateDetermined_0')]");
	public static final By lossEstimate = By.xpath("//input[contains(@name,'VehicleIncidentDV-LossEstimate')]");
	public static final By wasACpyhclDmg = By.xpath("//input[contains(@id,'VehicleIncidentDV-WasEstimateProvidedtoVehicleOwner_0')]");
	public static final By didAcdntsVanPool = By.xpath("//input[contains(@id,'VehicleIncidentDV-DidAccidentInvolve_1')]");
	public static final By pointofFirstImpact = By.xpath("//select[contains(@name,'VehicleIncidentDV-CollisionPoint')]");
	public static final By askDriver = By.xpath("//input[@id=\"NewVehicleIncidentPopup-NewVehicleIncidentScreen-VehIncidentDetailDV-VehicleIncidentDV-AskDriverSeatInUseOrDamage_1\"]");
	public static final By vehicleStyle = By.xpath("//select[contains(@name,'VehicleIncidentDV-Vehicle_Style')]");
	public static final By appraisalLink = By.xpath("//div[contains(@id,'VehIncidentDetailDV-SubView_AutoTotalLossCalculatorCard1Tab')]/div");
	public static final By primaryPoint = By.xpath("//select[contains(@name,'VehIncidentDetailDV-VehicleIncidentAppraisalAssignmentDV-primary_poi')]");
	public static final By vehicleOKButton = By.xpath("//div[@id='NewVehicleIncidentPopup-NewVehicleIncidentScreen-Update']/div");
	public static final By evaluateLink = By.xpath("//div[contains(@id,'VehicleIncidentAppraisalAssignmentDV-moiPicker')]");
	public static final By radiusList = By.xpath("//select[contains(@name,'ProximitySearchType')]");
	public static final By postalCode = By.xpath("//input[contains(@name,'ProximityPostalCode')]");
	public static final By shop1Link = By.xpath("//div[contains(@id,'VehicleIncidentPredictiveAppraiserAssignmentSearchPopup-0-Directions_button')]");
	public static final By selectShop = By.xpath("//div[contains(@id,'VehicleIncidentPredictiveAppraiserAssignmentSearchPopup-AppraiserResultLV-0-_Select')]");
	public static final By vehicleUpdateButton = By.xpath("//div[@id='EditVehicleIncidentPopup-EditVehicleIncidentScreen-Update']/div");
	
	
	
	
}
