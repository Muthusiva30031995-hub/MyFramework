package com.testautomation.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.testautomation.Config.InstanceContainer;
import com.testautomation.PageUI.PropertyIncidentPageUI;

public class PropertyIncidentPage extends PageBase{

	public PropertyIncidentPage(InstanceContainer ic) {
		super(ic);
		
	}
	
	public void addPropertyIncidentDetails() throws Exception
	{
		String propertyDescription = excelData.getCommonData("PropertyDescription");
		String propertyOwner = excelData.getData("PropertyOwner");
		String lossParty = excelData.getData("LossParty");
		String damageDescription = excelData.getCommonData("PropertyDamageDescription");
		String propertyName = excelData.getData("PropertyName");
		String address1 = excelData.getData("Address1");
		String zipcode = excelData.getData("Zipcode");
		String estimate = excelData.getData("PropertyEstimate");
		
		wh.clickElement(PropertyIncidentPageUI.propertyAddBtn, "Property Add Button");
		wh.enterValue(PropertyIncidentPageUI.propertyDescription, propertyDescription, "Property Description");		
		if((propertyOwner!= null) && !(propertyOwner.equals("")))
		{
			wh.selectDropDownValue(PropertyIncidentPageUI.propertyOwner, propertyOwner, "Property Owner");
		}
		
		if((lossParty!= null) && !(lossParty.equals("")))
		{
			wh.selectDropDownValue(PropertyIncidentPageUI.lossParty, lossParty, "Loss Party");
		}
		
		wh.enterValue(PropertyIncidentPageUI.damageDescription, damageDescription, "Damage Description");
		
		if((propertyName!= null) && !(propertyName.equals("")))
		{
			wh.selectDropDownValue(PropertyIncidentPageUI.propertyName, propertyName, "Property Name");
		}
		
		if((address1!= null) && !(address1.equals("")))
		{
			wh.enterValue(PropertyIncidentPageUI.address1, address1, "Address Line 1");
		}
		
		if((address1!= null) && !(address1.equals("")))
		{
			wh.enterValue(PropertyIncidentPageUI.zipcode, zipcode, "Zipcode");
			WebElement element = driver.findElement(By.xpath("//input[contains(@name,'FixedPropertyIncidentDV-CCAddressInputSet-globalAddressContainer-Address_Description')]"));
			element.click();
					
		}
		
		if((estimate!= null) && !(estimate.equals("")))
		{
			wh.selectDropDownValue(PropertyIncidentPageUI.estimate, estimate, "Estimate");
		}
		
		wh.clickElement(PropertyIncidentPageUI.structureDamageRadio, "Structure Damage Radio Button");
		wh.clickElement(PropertyIncidentPageUI.propertyHabitableRadio, "Property Habitable Radio Button");
		wh.clickElement(PropertyIncidentPageUI.businessClose, "Business Close Radio Button");
		wh.clickElement(PropertyIncidentPageUI.propertyOkBtn, "Property OK Button");
		
	}
	

}
