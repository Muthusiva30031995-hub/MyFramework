package com.testautomation.PageUI;

import org.openqa.selenium.By;

public class DwellingIncidentPageUI {

	
	public static final By dwellingAddButton = By.xpath("//div[contains(@id,'AddIncidentButton')]//div[text()='Add']");
	public static final By dwellingLink = By.xpath("(//div[contains(@id,'QuickClaimDV-AddIncidentButton')]/div[@class='gw-action--inner gw-hasDivider'])[1]");
	public static final By propertyDesc = By.xpath("//input[contains(@name,\"PropertyDescription\")]");
	public static final By propertyOwner = By.xpath("//div[contains(@id,'PropertyOwner')]//select");
	public static final By damageDesc = By.xpath("//div[contains(@id,\"Description\")]//textarea");
	public static final By estimate = By.xpath("//div[contains(@id,\"EstDamageAmt\")]//select");
	public static final By contractorRepairRadio = By.xpath("//input[contains(@id,\"ContractorRepairProgramoffered_0\")]");
	public static final By propertyInfo = By.xpath("//div[contains(@id,\"Address_Picker\")]//select");
	public static final By structureDamageRadio = By.xpath("(//input[contains(@id,\"DwellingAttributeInputSet-StructureOrMultipleRoomDamage\")])[1]");
	public static final By propertyHeritable = By.xpath("//input[contains(@id,\"IsPropertyHabitable_1\")]");
	public static final By businessClose = By.xpath("//input[contains(@id,\"BusinessCloseDueToLoss_1\")]");
	public static final By dwellingUpdate = By.xpath("(//div[contains(@id,\"Update\")]//div[1])[1]");
	
}
