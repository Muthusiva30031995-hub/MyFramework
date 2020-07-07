package com.testautomation.PageObjects;


import com.testautomation.Config.InstanceContainer;
import com.testautomation.PageUI.RepairDetailsPageUI;


public class RepairDetailsPage extends PageBase{

	public RepairDetailsPage(InstanceContainer ic) {
		super(ic);
		
	}

	public void updatingRepairDetails() throws Exception{
	    
		String instructionsToAppraiasal = excelData.getCommonData("InstructionsToAppraiasal");
		String lossCategoryRepair = excelData.getCommonData("LossCategoryRepair");
		wh.clickElement(RepairDetailsPageUI.exposureLink, "Exposure Link");
		wh.clickElement(RepairDetailsPageUI.newExpoVehicle,"New Vehicle Link");
		wh.clickElement(RepairDetailsPageUI.repairDetailsLink,"Repair details Link");
		wh.clickElement(RepairDetailsPageUI.repairDetailsEdit,"Repair details Edit Button");
		wh.enterValue(RepairDetailsPageUI.instructionsToAppraiasal,instructionsToAppraiasal,"Instructions To Appraiasal");
		wh.selectDropDownValue(RepairDetailsPageUI.lossCategoryRepair,lossCategoryRepair,"lossCategoryRepair");
		wh.clickElement(RepairDetailsPageUI.sendAssignmentRepair," Send Assignment Button");
		wh.waitForElementPresent(RepairDetailsPageUI.linkToCCC);
		wh.clickElement(RepairDetailsPageUI.linkToCCC,"Link To CCC");
		
		
	}

	
}
