package com.testautomation.PageUI;

import org.openqa.selenium.By;

public class MatterPageUI {
	
	public static final By litigationLink = By.xpath("//div[@id=\"Claim-MenuLinks-Claim_ClaimMatters\"]/div");
	public static final By newMatterBtn = By.xpath("//div[contains(@id,'ClaimMatters-ClaimMatterScreen-ClaimMatters_NewMatterButton')]");
	public static final By matterTitle = By.xpath("//div[@id='NewMatter-NewMatterScreen-ttlBar']");
	public static final By matterTypeList = By.xpath("//select[contains(@name,'NewMatter-NewMatterScreen-NewMatterDV-MatterType')]");
	public static final By matterNameTxt = By.xpath("//input[contains(@name,'NewMatter-NewMatterScreen-NewMatterDV-Matter_Name')]");
	public static final By plantiffAddBtn = By.xpath("//div[contains(@id,'Ext_MatterPlaintiffLV_tb-Add')]");
	public static final By plantiffContactList = By.xpath("//select[contains(@name,'Ext_MatterPlaintiffLV-0-plaintiffid')]");
	public static final By defendantAddBtn = By.xpath("//div[contains(@id,'Ext_MatterDefendantLV_tb-Add')]");
	public static final By defendantContactList = By.xpath("//select[contains(@name,'Ext_MatterDefendantLV-0-defendantid')]");
	public static final By exposureAddBtn = By.xpath("//div[contains(@id,'Ext_MatterExposureLV_tb-Add')]");
	public static final By relatedToExposureList = By.xpath("//select[contains(@name,'Ext_MatterExposureLV-0-exps')]");
	public static final By courtTypeList = By.xpath("//select[contains(@name,'NewMatter-NewMatterScreen-NewMatterDV-CourtType')]");
	public static final By courtDistrictDamageList = By.xpath("//select[contains(@name,'NewMatter-NewMatterScreen-NewMatterDV-CourtDistrict')]");
	public static final By legalSpecialityList = By.xpath("//select[contains(@name,'NewMatter-NewMatterScreen-NewMatterDV-LegalSpecialty')]");
	public static final By primaryCauseList = By.xpath("//select[contains(@name,'NewMatter-NewMatterScreen-NewMatterDV-TrialDetails_PrimaryCause')]");
	public static final By matterUpdateBtn = By.xpath("//div[contains(@id,'NewMatter-NewMatterScreen-Update')]");
	public static final By closeMatterBtn = By.xpath("//div[contains(@id,'MatterDetailPage_CloseMatterButton')]");

}
