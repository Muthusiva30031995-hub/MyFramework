package com.testautomation.PageUI;

import org.openqa.selenium.By;

public class RecoveryPageUI {

	public static final By actionLink = By.xpath("(//div[contains(@id,'Claim-ClaimMenuActions')])[1]");
	public static final By otherLink = By.xpath("//div[text()='Other']/..");
	public static final By recoveryLink = By.xpath("//div[contains(@id,'ClaimMenuActions_NewTransaction_RecoverySet')]/div/div[2]");
	public static final By payerList = By.xpath("//select[@name=\"NewRecoverySet-NewRecoveryScreen-RecoveryDetailDV-Payer\"]");
	public static final By reserveLine = By.xpath("//select[contains(@name,'ReserveLineInputSet-ReserveLine')]");
	public static final By payerCheckNumberTxt = By.xpath("//input[contains(@name,'RecoveryDetailDV-Ext_CheckNumber')]");
	public static final By RecoveryCategory = By.xpath("//select[contains(@name,'RecoveryDetailDV-recCategory')]");
	public static final By recoveryComments = By.xpath("//textarea[contains(@name,'RecoveryDetailDV-Comments')]");
	public static final By lineItemsCategoryList = By.xpath("//select[contains(@name,'RecoveryLineItemsLV-0-LineCategory')]");
	public static final By lineItemAmount = By.xpath("//input[contains(@name,'EditableRecoveryLineItemsLV-0-Amount')]");
	public static final By recoveryUpdateBtn = By.xpath("//div[@id=\"NewRecoverySet-NewRecoveryScreen-Update\"]");
			
	
}
