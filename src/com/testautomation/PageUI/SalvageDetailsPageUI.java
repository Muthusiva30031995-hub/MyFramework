package com.testautomation.PageUI;

import org.openqa.selenium.By;

public class SalvageDetailsPageUI {

	public static final By salvageLink = By.xpath("//div[contains(@id,'ExposureDetailDV-Exposure_SalvageCardTab')]/div");
	public static final By ACVText = By.xpath("//input[contains(@name,'ExposureDetailDV-VehicleSalvageDetailsDV-PQSalvageACV')]");
	public static final By estimatedRepairCost = By.xpath("//input[contains(@name,'VehicleSalvageDetailsDV-PQSalvageEstRepairCost')]");
	public static final By proQuoteLink = By.xpath("//div[@id='ExposureDetail-ExposureDetailScreen-ExposureDetailDV-VehicleSalvageDetailsDV-ProQuoteButton']/div");
	public static final By isOwnerRetain = By.xpath("//input[contains(@id,'ExposureDetailDV-VehicleSalvageDetailsDV-OwnerRetSalvage_0')]");
	public static final By contactList = By.xpath("//select[contains(@name,'ExposureDetailDV-VehicleSalvageDetailsDV-Claimant_Picker')]");
	public static final By dispositionList = By.xpath("//select[contains(@name,'VehicleSalvageDetailsDV-disposition_type')]");
	public static final By lossCategorySolvage = By.xpath("//select[contains(@name,'VehicleSalvageDetailsDV-LosscategoryId')]");
	public static final By salvageUpdate = By.xpath("//div[contains(@id,'ExposureDetail-ExposureDetailScreen-Update')]/div");
	public static final By sendAssignmentSolvage = By.xpath("//div[@id='ExposureDetail-ExposureDetailScreen-ExposureDetailDV-VehicleSalvageDetailsDV-sendAsgnBtn']/div");
	public static final By linktoCoPart = By.xpath("//div[contains(@id,'ExposureDetailDV-VehicleRepairDV_tb-LinktoCCC')]/div");
	
}
