package com.testautomation.PageObjects;

import java.io.IOException;

import com.testautomation.Config.InstanceContainer;
import com.testautomation.PageUI.RepairDetailsPageUI;
import com.testautomation.PageUI.SalvageDetailsPageUI;

public class SalvageDetailsPage extends PageBase{

	public SalvageDetailsPage(InstanceContainer ic) {
		super(ic);
		
	}

	public void addingSalvageDetails() throws Exception {
		String acvText = excelData.getData("ACVText");
		String estimatedRepairCost = excelData.getData("EstimatedRepairCost");
		String contactList = excelData.getData("ContactList");
		String dispositionList = excelData.getData("DispositionList");
		String lossCategorySolvage = excelData.getData("LossCategorySolvage");
		wh.clickElement(SalvageDetailsPageUI.salvageLink,"Salvage Link");
		wh.clickElement(RepairDetailsPageUI.repairDetailsEdit,"Repair details Edit Button");
		if(wh.isElementPresent(SalvageDetailsPageUI.ACVText)) {		
			if((acvText!=null) && !(acvText.equals("")))
				{
				wh.enterValue(SalvageDetailsPageUI.ACVText, acvText, "ACV Text");
			    }
		}
		if(wh.isElementPresent(SalvageDetailsPageUI.estimatedRepairCost)) {		
			if((estimatedRepairCost!=null) && !(estimatedRepairCost.equals("")))
				{
				wh.enterValue(SalvageDetailsPageUI.estimatedRepairCost, estimatedRepairCost, "Estimated Repair Cost");
				wh.clickElement(SalvageDetailsPageUI.proQuoteLink,"Pro Quote Link");
				wh.clickElement(RepairDetailsPageUI.repairDetailsEdit,"Repair details Edit Button");
			    }
		}		

		wh.clickElement(SalvageDetailsPageUI.isOwnerRetain,"Is Owner Retaining the vehicle");
		
		if(wh.isElementPresent(SalvageDetailsPageUI.contactList)) {		
			if((contactList!=null) && !(contactList.equals("")))
				{
				wh.clickElement(RepairDetailsPageUI.repairDetailsEdit,"Repair details Edit Button");
				wh.enterValue(SalvageDetailsPageUI.contactList, contactList, "Contact List");
			    }
		}
		if(wh.isElementPresent(SalvageDetailsPageUI.dispositionList)) {		
			if((dispositionList!=null) && !(dispositionList.equals("")))
				{
				wh.enterValue(SalvageDetailsPageUI.dispositionList, dispositionList, "disposition List");
			    }
		}
		if(wh.isElementPresent(SalvageDetailsPageUI.lossCategorySolvage)) {		
			if((lossCategorySolvage!=null) && !(lossCategorySolvage.equals("")))
				{
				wh.enterValue(SalvageDetailsPageUI.lossCategorySolvage, lossCategorySolvage, "loss Category Solvage");
				wh.clickElement(SalvageDetailsPageUI.sendAssignmentSolvage,"send Assignment Solvage Link");
				wh.clickElement(SalvageDetailsPageUI.linktoCoPart,"link to CoPart");
			    }
		}
		
		

	}

	public void addingNonSalvageDetails() throws Exception {
		
		wh.clickElement(SalvageDetailsPageUI.salvageLink,"Salvage Link");
		wh.clickElement(RepairDetailsPageUI.repairDetailsEdit,"Repair details Edit Button");
		wh.clickElement(SalvageDetailsPageUI.isOwnerRetain,"Is Owner Retaining the vehicle");
		wh.clickElement(SalvageDetailsPageUI.salvageUpdate,"Salvage Update Link");
	}



}
