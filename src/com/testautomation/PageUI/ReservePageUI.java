package com.testautomation.PageUI;

import org.openqa.selenium.By;

public class ReservePageUI {
	
	public static final By actionLink = By.xpath("(//div[contains(@id,'Claim-ClaimMenuActions')])[1]");
	public static final By reserveLink = By.xpath("//div[contains(@id,'NewTransaction_ReserveSet')]");
	public static final By exposureDropDown1 = By.xpath("//select[contains(@name,'NewReserveSet-NewReserveSetScreen-ReservesSummaryDV-EditableReservesLV-0-Exposure')]");
	public static final By costType1 = By.xpath("//select[contains(@name,'NewReserveSet-NewReserveSetScreen-ReservesSummaryDV-EditableReservesLV-0-CostType')]");
	public static final By costCategory1 = By.xpath("//select[contains(@name,'NewReserveSet-NewReserveSetScreen-ReservesSummaryDV-EditableReservesLV-0-CostCategory')]");
	public static final By availableReserve1= By.xpath("//input[contains(@name,'NewReserveSet-NewReserveSetScreen-ReservesSummaryDV-EditableReservesLV-0-NewAmount')]");
	public static final By exposureDropDown2 = By.xpath("//select[contains(@name,\"NewReserveSet-NewReserveSetScreen-ReservesSummaryDV-EditableReservesLV-1-Exposure\")]");
	public static final By costType2 = By.xpath("//select[contains(@name,'NewReserveSet-NewReserveSetScreen-ReservesSummaryDV-EditableReservesLV-1-CostType')]");
	public static final By costCategory2 = By.xpath("//select[contains(@name,'NewReserveSet-NewReserveSetScreen-ReservesSummaryDV-EditableReservesLV-1-CostCategory')]");
	public static final By availableReserve2 = By.xpath("//input[contains(@name,'NewReserveSet-NewReserveSetScreen-ReservesSummaryDV-EditableReservesLV-1-NewAmount')]");
	public static final By exposureDropDown3 = By.xpath("//select[contains(@name,'NewReserveSet-NewReserveSetScreen-ReservesSummaryDV-EditableReservesLV-2-Exposure')]");
	public static final By costType3 = By.xpath("//select[contains(@name,'NewReserveSet-NewReserveSetScreen-ReservesSummaryDV-EditableReservesLV-2-CostType')]");
	public static final By costCategory3 = By.xpath("//select[contains(@name,'NewReserveSet-NewReserveSetScreen-ReservesSummaryDV-EditableReservesLV-2-CostCategory')]");
	public static final By availableReserve3 = By.xpath("//input[contains(@name,'NewReserveSet-NewReserveSetScreen-ReservesSummaryDV-EditableReservesLV-2-NewAmount')]");
	public static final By reserveTitle = By.cssSelector("#NewReserveSet-NewReserveSetScreen-ttlBar");
	public static final By saveButton = By.xpath("//div[contains(@id,'NewReserveSet-NewReserveSetScreen-Update')]/div[1]");
	public static final By financialTitle = By.cssSelector("#ClaimFinancialsTransactions-ClaimFinancialsTransactionsScreen-ttlBar");
	public static final By comments1 = By.xpath("//input[contains(@name,'ReservesSummaryDV-EditableReservesLV-0-Comments')]");
	public static final By comments2 = By.xpath("//input[contains(@name,'ReservesSummaryDV-EditableReservesLV-1-Comments')]");
	public static final By comments3 = By.xpath("//input[contains(@name,'ReservesSummaryDV-EditableReservesLV-2-Comments')]");
}
