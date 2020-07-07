package com.testautomation.PageUI;

import org.openqa.selenium.By;

public class ClaimStatusPageUI {
	
	public static final By summaryLink = By.xpath("(//div[text()='Summary'])[1]");
	public static final By summaryPageTitle = By.xpath("//div[@id='ClaimSummary-ClaimSummaryScreen-ttlBar']");
	public static final By claimStatusTitle = By.xpath("//div[@id='ClaimStatus-ttlBar']");
	public static final By claimStatusLink = By.xpath("//div[contains(@id,'Claim-MenuLinks-Claim_ClaimSummaryGroup-ClaimSummaryGroup_ClaimStatus')]");
	public static final By claimStatusEdit = By.xpath("//div[contains(@id,'ClaimStatus-Edit')]/div");
	public static final By claimDate = By.xpath("//input[@name=\"ClaimStatus-Ext_ClaimDate\"]");
	public static final By coverageInRadio = By.xpath("//input[contains(@id,'ClaimStatus-3-ClaimIndicatorInputSet-CoverageInQuestion_1')]");
	public static final By claimStatusUpdate = By.xpath("//div[contains(@id,'ClaimStatus-Update')]/div");
	
	
}
