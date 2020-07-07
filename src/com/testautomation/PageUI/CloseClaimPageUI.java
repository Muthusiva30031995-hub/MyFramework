package com.testautomation.PageUI;

import org.openqa.selenium.By;

public class CloseClaimPageUI {
	
	public static final By actionLink = By.xpath("(//div[contains(@id,'Claim-ClaimMenuActions')])[1]");
	public static final By closeClaimLink = By.xpath("//div[contains(@id,'ClaimMenuActions_CloseClaim')]");
	public static final By noteText = By.xpath("//textarea[contains(@name,'CloseClaimPopup-CloseClaimScreen-CloseClaimInfoDV-Note')]");
	public static final By outcomeList = By.xpath("//select[contains(@name,'CloseClaimPopup-CloseClaimScreen-CloseClaimInfoDV-Outcome')]");
	public static final By closeCloseClaim = By.xpath("//div[contains(@id,'CloseClaimPopup-CloseClaimScreen-Update')]");
}
