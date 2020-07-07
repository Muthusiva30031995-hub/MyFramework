package com.testautomation.PageUI;

import org.openqa.selenium.By;

public class ExposurePageUI {
	
	public static final By ExposureLink = By.xpath("(//div[contains(@id,'Claim-MenuLinks-Claim_ClaimExposures')])[1]");
	public static final By ExposureTitle = By.xpath("//div[@id='ClaimExposures-ClaimExposuresScreen-ttlBar']");
	public static final By newExposureTitle = By.xpath("//div[@id='NewExposure-NewExposureScreen-ttlBar']");
	public static final By actionsLink = By.xpath("(//div[contains(@id,'Claim-ClaimMenuActions')])[1]");	
	public static final By newExposureText = By.xpath("//div[@id=\"Claim-ClaimMenuActions-ClaimMenuActions_NewExposure\"]");
	public static final By dwellingExposureTitle = By.xpath("(//div[text()='New Exposure - Dwelling'])[2]");
	public static final By lossParty = By.xpath("(//select[contains(@name,\"NewExposure-NewExposureScreen-NewExposureDV\")])[1]");
	public static final By statisticalLine = By.xpath("//select[contains(@name,'StatLine')]");
	public static final By claimant = By.xpath("//select[contains(@name,'Claimant_Picker')]");
	public static final By type = By.xpath("//select[contains(@name,'Claimant_Type')]");
	public static final By damageDescriptionTxt = By.xpath("//textarea[contains(@name,'NewExposureDV-Description')]");
	public static final By propertyInfoList = By.xpath("//select[contains(@name,'Property_Incident')]");
	public static final By StateOfJurisdiction = By.xpath("//select[contains(@name,'Ext_Jurisdiction')]");
	public static final By JurisdictionList = By.xpath("//select[contains(@name,'JurisdictionState')]");
	public static final By KOL = By.xpath("//select[contains(@name,'KOL')]");
	public static final By exposureUpdate = By.xpath("//div[contains(@id,'NewExposure-NewExposureScreen-Update')]");
	public static final By bodilyInjuryLink = By.xpath("//div[contains(@id,'ClaimExposures-ClaimExposuresScreen-ExposuresLV') and contains(text(),'Bodily Injury')]");
	public static final By medPayLink = By.xpath("//div[contains(@id,'ClaimExposures-ClaimExposuresScreen-ExposuresLV') and text()='Med Pay']");
	
}
