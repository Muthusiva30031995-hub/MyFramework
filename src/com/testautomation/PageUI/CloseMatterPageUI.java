package com.testautomation.PageUI;

import org.openqa.selenium.By;

public class CloseMatterPageUI {
	
	public static final By litigationLink = By.xpath("//div[@id=\"Claim-MenuLinks-Claim_ClaimMatters\"]/div");
	public static final By matterLink = By.xpath("//div[contains(@id,'ClaimMatters-ClaimMatterScreen-MattersLV-0-Name_button')]");
	public static final By closeMatterBtn = By.xpath("//div[contains(@id,'MatterDetailPage-MatterDetailScreen-MatterDetailPage_CloseMatterButton')]");
	public static final By noteText = By.xpath("//textarea[contains(@name,'CloseMatterPopup-CloseMatterScreen-CloseMatterInfoDV-Note')]");
	public static final By outcomeList = By.xpath("//select[@name='CloseMatterPopup-CloseMatterScreen-CloseMatterInfoDV-Resolution']");
	public static final By closeCloseMatterBtn = By.xpath("//div[contains(@id,'CloseMatterPopup-CloseMatterScreen-Update')]");
	public static final By reOpenMatterBtn = By.xpath("//div[@id='MatterDetailPage-MatterDetailScreen-MatterDetailPage_ReopenMatterButton']");

}
