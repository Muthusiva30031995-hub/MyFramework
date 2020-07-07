package com.testautomation.PageUI;

import org.openqa.selenium.By;

public class PolicySearchPageUI {
	
	public static final By claimBtn = By.xpath("//*[@id='TabBar-ClaimTab']/div[3]/div");
	public static final By newClaim = By.xpath("//div[@id='TabBar-ClaimTab-ClaimTab_FNOLWizard']");
	public static final By existingClaimText = By.xpath("//input[contains(@name,'TabBar-ClaimTab-ClaimTab_FindClaim')]");
	public static final By claimSearchImage = By.xpath("//div[contains(@id,'TabBar-ClaimTab-ClaimTab_FindClaim_Button')]");
	public static final By policyText = By.xpath("//input[contains(@name,\"FNOLWizard-FNOLWizard_FindPolicyScreen-FNOLWizardFindPolicyPanelSet-policyNumber\")]");
	public static final By lossDateTrue = By.xpath("//input[contains(@id,'FNOLWizard-FNOLWizard_FindPolicyScreen-FNOLWizardFindPolicyPanelSet-IsLossDateRequired_0')]");
	public static final By lossDateText = By.xpath("//input[contains(@name,'FNOLWizardFindPolicyPanelSet-Ext_ReportedDate')]");
	public static final By searchButton = By.xpath("//div[contains(@id,'FNOLWizard-FNOLWizard_FindPolicyScreen-FNOLWizardFindPolicyPanelSet-Search')]");
	public static final By nextBtn = By.xpath("//div[contains(@id, \"Next\")]/div");
	public static final By liability = By.xpath("//input[contains(@id,\"FindPolicyScreen-FNOLWizardFindPolicyPanelSet-ClaimMode\") and @value='Liability - Quick Claim']");
	public static final By property = By.xpath("//input[contains(@id,\"FindPolicyScreen-FNOLWizardFindPolicyPanelSet-ClaimMode\") and @value='Property - Quick Claim']");
	public static final By auto = By.xpath("//input[contains(@id,\"FindPolicyScreen-FNOLWizardFindPolicyPanelSet-ClaimMode\") and @value='Auto - Quick Claim']");
	public static final By aviation = By.xpath("//input[contains(@id,'FindPolicyScreen-FNOLWizardFindPolicyPanelSet-ClaimMode') and @value='Auto - Quick Claim']");
	public static final By step2NextBtn = By.xpath("//div[contains(@id,'FNOLWizard-FNOLWizard_PickPolicyRiskUnitsScreen-0')]//div[contains(text(),\"Next >\")]");
	public static final By finishBtn = By.xpath("//div[contains(@id, 'Finish')]/div");		
	public static final By summaryTitle = By.xpath("#ClaimSummary-ClaimSummaryScreen-ttlBar");
	
}
