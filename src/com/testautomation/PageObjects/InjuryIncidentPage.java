package com.testautomation.PageObjects;

import com.testautomation.Config.InstanceContainer;
import com.testautomation.PageUI.InjuryIncidentPageUI;

public class InjuryIncidentPage extends PageBase{

	public InjuryIncidentPage(InstanceContainer ic) {
		super(ic);		
	}
	
	public void addInjuryDetails() throws Exception
	{
		String injuredPerson = excelData.getData("InjuredPerson");
		String lossParty = excelData.getData("LossParty");
		String injuryDescription = excelData.getCommonData("InjuryDescription");
		String areaOfBody = excelData.getData("AreaOfBody");
		String detailedBodyPart = excelData.getData("DetailedBody");
		String detailedInjuryType = excelData.getData("DetailedInjuryType");
		wh.clickElement(InjuryIncidentPageUI.injuryAddBtn,"Injury Add");
		wh.waitForElementPresent(InjuryIncidentPageUI.injuryIncidentOkBtn);
		wh.selectDropDownValue(InjuryIncidentPageUI.injuredPerson, injuredPerson,"Injured Person");
		wh.selectDropDownValue(InjuryIncidentPageUI.lossParty, lossParty,"Loss party");
		wh.waitForElementPresent(InjuryIncidentPageUI.severity);
		wh.selectDropDownValue(InjuryIncidentPageUI.severity, "#2","Severity");
		wh.enterValue(InjuryIncidentPageUI.description, injuryDescription,"Injury Description");
		wh.selectDropDownValue(InjuryIncidentPageUI.injuryType, "#1","Injury type");
		wh.clickElement(InjuryIncidentPageUI.bodyPartsAddBtn,"Body Parts Add");
		wh.waitForElementPresent(InjuryIncidentPageUI.areaOfBody);
		wh.selectDropDownValue(InjuryIncidentPageUI.areaOfBody, areaOfBody,"Area of Body");
		wh.waitForElementPresent(InjuryIncidentPageUI.detailedBody);
		wh.selectDropDownValue(InjuryIncidentPageUI.detailedBody, detailedBodyPart,"Detailed Body part");
		wh.waitForElementPresent(InjuryIncidentPageUI.detailedInjuryType);
		wh.selectDropDownValue(InjuryIncidentPageUI.detailedInjuryType, detailedInjuryType,"Detailed Injury type");
		wh.clickElement(InjuryIncidentPageUI.injuryIncidentOkBtn,"Injury OK");
	}
	

}
