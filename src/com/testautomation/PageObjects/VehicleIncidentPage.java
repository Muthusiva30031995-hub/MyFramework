package com.testautomation.PageObjects;

import com.testautomation.Config.InstanceContainer;
import com.testautomation.PageUI.VehicleIncidentPageUI;

public class VehicleIncidentPage extends PageBase{

	public VehicleIncidentPage(InstanceContainer ic) {
		super(ic);
	}

	public void addVehicleDetails(String selectVehicle) throws Exception	{
		
		String vehicleLossParty = excelData.getData("VehicleLossParty");
		String vehicleType = excelData.getData("VehicleType");
		String vehicleYear = excelData.getData("VehicleYear");
		String unformattedMake = excelData.getData("UnformattedMake");
		String vehicleMake = excelData.getData("VehicleMake");
		String vehicleModel = excelData.getData("VehicleModel");
		String vehicleStyle = excelData.getData("VehicleStyle");
		String vin = excelData.getData("VIN");
		String driverName = excelData.getData("DriverName");
		String owner = excelData.getData("Owner");
		String vehicleDamageDesc = excelData.getCommonData("VehicleDamageDesc");
		String lossOccured = excelData.getData("LossOccured");
		String lossEstimate = excelData.getData("LossEstimate");
		String pointofFirstImpact = excelData.getData("PointofFirstImpact");
		String primaryPoint = excelData.getData("PrimaryPoint");
		wh.waitForElementPresent(VehicleIncidentPageUI.vehicleAddButton);
		wh.clickElement(VehicleIncidentPageUI.vehicleAddButton, "Vehicle Add Button");
		if(wh.isElementPresent(VehicleIncidentPageUI.selectVehicle)) {		
			if((selectVehicle!=null) && !(selectVehicle.equals("")))
				{
				wh.selectDropDownValue(VehicleIncidentPageUI.selectVehicle, selectVehicle,"Select Vehicle");
				}
		    }
		if(selectVehicle.contains("New")) {
		
			if(wh.isElementExists(VehicleIncidentPageUI.vehicleStyle)) {		
				if((vehicleStyle!=null) && !(vehicleStyle.equals("")))
					{
					wh.selectDropDownValue(VehicleIncidentPageUI.vehicleStyle, vehicleStyle,"Vehicle Style");
					}
			}
		
		}
			if(wh.isElementPresent(VehicleIncidentPageUI.lossParty)) {		
				if((vehicleLossParty!=null) && !(vehicleLossParty.equals("")))
					{
					wh.selectDropDownValue(VehicleIncidentPageUI.lossParty, vehicleLossParty,"Loss Party");
					}
			}
		
			if(wh.isElementPresent(VehicleIncidentPageUI.vehicleType)) {		
				if((vehicleType!=null) && !(vehicleType.equals("")))
					{
					wh.selectDropDownValue(VehicleIncidentPageUI.vehicleType, vehicleType,"Vehicle Type");
				    }
			}
			if(wh.isElementExists(VehicleIncidentPageUI.vehicleYear)) {		
				if((vehicleYear!=null) && !(vehicleYear.equals("")))
					{
					wh.enterValue(VehicleIncidentPageUI.vehicleYear, vehicleYear,"Year");
					}
			}
			if(wh.isElementExists(VehicleIncidentPageUI.unformattedMake)) {		
				if((unformattedMake!=null) && !(unformattedMake.equals("")))
					{
					wh.enterValue(VehicleIncidentPageUI.unformattedMake, unformattedMake,"unformattedMake");
					}
			}
			if(wh.isElementPresent(VehicleIncidentPageUI.vehicleMake)) {		
				if((vehicleMake!=null) && !(vehicleMake.equals("")))
					{
					wh.selectDropDownValue(VehicleIncidentPageUI.vehicleMake, vehicleMake,"Make");
					}
			}
				if(wh.isElementExists(VehicleIncidentPageUI.vehicleModel)) {		
					if((vehicleModel!=null) && !(vehicleModel.equals("")))
						{
						wh.enterValue(VehicleIncidentPageUI.vehicleModel, vehicleModel,"Model");
						}
			}
			
			if(wh.isElementPresent(VehicleIncidentPageUI.vin)) {		
				if((vin!=null) && !(vin.equals("")))
					{
					wh.enterValue(VehicleIncidentPageUI.vin, vin,"VIN");
					}
			}
			if(wh.isElementPresent(VehicleIncidentPageUI.driverName)) {		
				if((driverName!=null) && !(driverName.equals("")))
					{
					wh.selectDropDownValue(VehicleIncidentPageUI.driverName, driverName,"Driver Name");
					}
			}
			if(wh.isElementPresent(VehicleIncidentPageUI.owner)) {		
				if((owner!=null) && !(owner.equals("")))
					{
					wh.selectDropDownValue(VehicleIncidentPageUI.owner, owner,"Owner Name");
					}
			}
			if(wh.isElementPresent(VehicleIncidentPageUI.vehicleDamageDesc)) {		
				if((vehicleDamageDesc!=null) && !(vehicleDamageDesc.equals("")))
					{
					wh.enterValue(VehicleIncidentPageUI.vehicleDamageDesc, vehicleDamageDesc,"Vehicle Damage Desc");
					}
			}
			wh.clickElement(VehicleIncidentPageUI.wasThrPhyDamToVhcl, "Was There Physical Damage to the Vehicle Butoon");
			wh.clickElement(VehicleIncidentPageUI.wasTheVhclParked, "Was the vehicle parked Butoon");
			wh.selectDropDownValue(VehicleIncidentPageUI.lossOccured, lossOccured,"Loss Occured");
			wh.clickElement(VehicleIncidentPageUI.airBagsDeploy, "Air Bags Deploy Butoon");
			if(wh.isElementExists(VehicleIncidentPageUI.askDriver)) {		
				
				wh.clickElement(VehicleIncidentPageUI.askDriver,"Ask Driver");
					
			}
			wh.clickElement(VehicleIncidentPageUI.driveable, "Driveable Butoon");
			wh.clickElement(VehicleIncidentPageUI.totalLoss, "Total Loss Butoon");
			wh.clickElement(VehicleIncidentPageUI.doesQBEhavePermToVhcl, "Does QBE Have Permission to Move or Transport Vehicle Butoon");
			wh.clickElement(VehicleIncidentPageUI.hasAnEsthclDam, "Has an Estimate Been Determined for the Vehicle Damage Butoon");
			wh.waitForElementPresent(VehicleIncidentPageUI.lossEstimate);
			wh.enterValue(VehicleIncidentPageUI.lossEstimate, lossEstimate,"Loss Estimate");
			wh.clickElement(VehicleIncidentPageUI.wasACpyhclDmg, "Was a copy of the vehicle damage estimate provided to the vehicle owner Butoon");
			wh.clickElement(VehicleIncidentPageUI.didAcdntsVanPool, "Did Accident Involve Pedestrian, Motorcycle, Bus or Van Pool Butoon");
			wh.selectDropDownValue(VehicleIncidentPageUI.pointofFirstImpact, pointofFirstImpact,"Point of First Impact");
			wh.clickElement(VehicleIncidentPageUI.appraisalLink, "Appraisal Link");
			wh.selectDropDownValue(VehicleIncidentPageUI.primaryPoint, primaryPoint,"Primary Point");
			wh.clickElement(VehicleIncidentPageUI.vehicleOKButton, "Vehicle OK Button");
			
			
			

}
}
