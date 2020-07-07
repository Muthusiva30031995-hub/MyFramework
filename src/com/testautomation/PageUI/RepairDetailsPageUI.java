package com.testautomation.PageUI;

import org.openqa.selenium.By;

public class RepairDetailsPageUI {
	
	public static final By exposureLink = By.xpath("(//div[contains(@id,'Claim-MenuLinks-Claim_ClaimExposures')])[1]");
	public static final By newExpoVehicle = By.xpath("//div[contains(@id,'ClaimExposures-ClaimExposuresScreen-ExposuresLV') and contains(text(),'Vehicle')]");
	public static final By repairDetailsLink = By.xpath("//div[contains(@id,'ExposureDetailDV-Exposure_RepairCardTab')]");
	public static final By repairDetailsEdit = By.xpath("//div[contains(@id,'ExposureDetail-ExposureDetailScreen-Edit')]/div");
    public static final By instructionsToAppraiasal = By.xpath("//textarea[contains(@name,'ExposureDetailDV-VehicleRepairDV-appraiserMemo')]");
    public static final By lossCategoryRepair = By.xpath("//select[contains(@name,'ExposureDetailDV-VehicleRepairDV-LosscategoryId')]");
    public static final By sendAssignmentRepair = By.xpath("//div[@id='ExposureDetail-ExposureDetailScreen-ExposureDetailDV-VehicleRepairDV-sendAsgnBtn']/div");
    public static final By linkToCCC = By.xpath("//div[contains(@id,'ExposureDetailDV-VehicleRepairDV_tb-LinktoCCC')]/div");
    
    
}
