package com.testautomation.PageUI;

import org.openqa.selenium.By;

public class GWCCTicketsPageUI {

	
	public static final By SearchButton = By.xpath("//div[text()=\"Searc\"]");
	public static final By AdvanceSearchButton = By.xpath("//div[@id=\"Search-MenuLinks-Search_ClaimSearchesGroup-ClaimSearchesGroup_ClaimSearch\"]");
	public static final By LegacyClaim = By.xpath("//input[@name=\"ClaimSearch-ClaimSearchScreen-ClaimSearchDV-ClaimSearchOptionalInputSet-LegacyClaim\"]");
	public static final By searchBtn = By.xpath("//div[contains(@id,'ClaimSearchDV-ClaimSearchAndResetInputSet-Search')]");
	public static final By summary = By.xpath("//div[@id=\"ClaimSummary-ClaimSummaryScreen-ttlBar\"]//div[text()=\"Summary\"]");
	public static final By policySearch = By.xpath("//input[@name=\"ClaimSearch-ClaimSearchScreen-ClaimSearchDV-ClaimSearchRequiredInputSet-PolicyNumber\"]");
	
}

