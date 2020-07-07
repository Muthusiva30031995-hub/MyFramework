package com.testautomation.PageUI;

import org.openqa.selenium.By;

public class PropertyIncidentPageUI {
	
	public static final By propertyAddBtn = By.xpath("//div[contains(@id,\"EditableFixedPropertyIncidentsLV_tb-Add\")]");	
	public static final By propertyDescription = By.xpath("//input[@name=\"NewFixedPropertyIncidentPopup-NewFixedPropertyIncidentScreen-FixPropIncidentDetailDV-FixedPropertyIncidentDV-PropertyDescription\"]");
	public static final By propertyOwner = By.xpath("//select[@name=\"NewFixedPropertyIncidentPopup-NewFixedPropertyIncidentScreen-FixPropIncidentDetailDV-FixedPropertyIncidentDV-PropertyOwner\"]");
	public static final By lossParty = By.xpath("//select[contains(@name,'FixPropIncidentDetailDV-FixedPropertyIncidentDV-ClaimType')]");
	public static final By damageDescription = By.xpath("//textarea[@name=\"NewFixedPropertyIncidentPopup-NewFixedPropertyIncidentScreen-FixPropIncidentDetailDV-FixedPropertyIncidentDV-Description\"]");
	public static final By address1 = By.xpath("//input[contains(@name,\"globalAddress-GlobalAddressInputSet-AddressLine1\")]");
	public static final By zipcode = By.xpath("//input[contains(@name,\"globalAddress-GlobalAddressInputSet-PostalCode\")]"); 	
	public static final By propertyName = By.xpath("//select[contains(@name,'CCAddressInputSet-globalAddressContainer-Address_Picker')]");
	public static final By estimate = By.xpath("//select[contains(@name,\"FixedPropertyIncidentDV-EstDamageAmt\")]");
	public static final By structureDamageRadio = By.xpath("//input[contains(@id,\"StructureOrMultipleRoomDamage_1\")]");
	public static final By propertyHabitableRadio = By.xpath("//input[contains(@id,\"IsPropertyHabitable_1\")]");
	public static final By businessClose = By.xpath("//input[contains(@id,\"BusinessCloseDueToLoss_0\")]");	
	public static final By propertyOkBtn = By.xpath("//div[@id=\"NewFixedPropertyIncidentPopup-NewFixedPropertyIncidentScreen-Update\"]");
	

}
