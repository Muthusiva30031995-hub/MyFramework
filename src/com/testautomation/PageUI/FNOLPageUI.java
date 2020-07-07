package com.testautomation.PageUI;

import org.openqa.selenium.By;

public class FNOLPageUI {

	public static final By relationToInsured = By.xpath("//select[contains(@name,'QuickClaimDV-Claim_ReportedByType')]");
	public static final By claimant = By.xpath("//select[contains(@name,'Claimant_Picker')]");
	public static final By description = By.xpath("//div[contains(@id,\"Description\")]//textarea");
	public static final By lossCause = By.xpath("//select[contains(@name,'QuickClaimDV-Claim_LossCause')]");
	public static final By masTortClaim = By.xpath("//input[contains(@id,'QuickClaimDV-ext_mspmasstortind_1')]");
	public static final By fourOrMoreVehicle = By.xpath("//input[contains(@id,'QuickClaimDV-Claim_MoreThan3Vehicles_1')]");
	public static final By lossLocation = By.xpath("//select[contains(@name,'QuickClaimDV-CCAddressInputSet-globalAddressContainer-Address_Picker')]");
	public static final By notes = By.xpath("//textarea[contains(@name,'QuickClaimDV-Note')]");
	public static final By claimAssignmnet = By.xpath("//select[contains(@name,'QuickClaimDV-CommonAssign')]");
	public static final By finishButton = By.xpath("//div[contains(@id, 'Finish')]/div");
	public static final By newClaimSaved = By.xpath("//div[@id=\"NewClaimSaved-NewClaimSavedScreen-NewClaimSavedDV-GoToClaim\"]");
	public static final By claimNumber = By.xpath("(//div[@id='TabBar-ClaimTab']/div/div[2])[1]");
	public static final By summaryPage = By.xpath("(//div[text()='Summary'])[1]");
	
}
