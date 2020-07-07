package com.testautomation.PageObjects;

import java.io.IOException;

import com.testautomation.Config.InstanceContainer;
import com.testautomation.PageUI.DwellingIncidentPageUI;

public class DwellingIncidentPage extends PageBase {

	public DwellingIncidentPage(InstanceContainer ic) {
		super(ic);
		
	}

	public void addDwellingIncidentDetails() throws Exception
	{
		String propertDesc = excelData.getCommonData("DwellingPropertyDesc");
		String propertyOwner = excelData.getData("DwellingOwner");
		String damageDesc = excelData.getCommonData("DwellingDamageDesc ");
		String estimate = excelData.getData("DwellingEstimate");
		String propertyInfo = excelData.getData("PropertyInfo");
		wh.clickElement(DwellingIncidentPageUI.dwellingAddButton, "Dwelling Add Button");
		if(wh.isElementPresent(DwellingIncidentPageUI.dwellingLink)) {
			wh.clickElement(DwellingIncidentPageUI.dwellingLink, "Dwelling link");
			wh.enterValue(DwellingIncidentPageUI.propertyDesc, propertDesc, "Dwelling Description");
			wh.selectDropDownValue(DwellingIncidentPageUI.propertyOwner, propertyOwner,"Property owner");
			wh.enterValue(DwellingIncidentPageUI.damageDesc, damageDesc, "Dwelling Damage Description");
			wh.selectDropDownValue(DwellingIncidentPageUI.estimate, estimate,"Estimate");
			wh.clickWebButton(DwellingIncidentPageUI.contractorRepairRadio,"Contarctor Repair Radio button");
			wh.selectDropDownValue(DwellingIncidentPageUI.propertyInfo, propertyInfo,"Property info");
			wh.waitForElementPresent(DwellingIncidentPageUI.structureDamageRadio);
			wh.clickWebButton(DwellingIncidentPageUI.structureDamageRadio,"Structure Damage Radio Button");
			wh.clickWebButton(DwellingIncidentPageUI.propertyHeritable,"Property Heritable Radio Button");
			wh.clickWebButton(DwellingIncidentPageUI.businessClose,"Business Close Radio Button");
			wh.clickElement(DwellingIncidentPageUI.dwellingUpdate, "Dwelling Update button");
		}
	}
	
}
