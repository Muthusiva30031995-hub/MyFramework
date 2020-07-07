package com.testautomation.PageUI;

import org.openqa.selenium.By;

public class CloseExposurePageUI {
	
	public static final By exposureLink = By.xpath("(//div[contains(@id,'Claim-MenuLinks-Claim_ClaimExposures')])[1]");
	public static final By closeExposureLink = By.xpath("//div[contains(@id,'ExposureDetail-ExposureDetailScreen-ExposureDetailScreen_CloseButton')]");
	public static final By outcomeList = By.xpath("//select[contains(@name,'CloseExposurePopup-CloseExposureScreen-CloseExposureInfoDV-Outcome')]");
	public static final By noteText = By.xpath("//textarea[contains(@name,'CloseExposureInfoDV-Note')]");
	public static final By closeCloseExposure = By.xpath("//div[@id=\"CloseExposurePopup-CloseExposureScreen-Update\"]");	
	public static final By exposureCheckBox1 = By.xpath("//input[@name=\"ClaimExposures-ClaimExposuresScreen-ExposuresLV-0-_Checkbox\"]");
	public static final By exposureCheckBox2 = By.xpath("//input[@name=\"ClaimExposures-ClaimExposuresScreen-ExposuresLV-1-_Checkbox\"]");
	public static final By exposureCloseExposure = By.xpath("//div[contains(@id,'ClaimExposures_CloseExposure')]//div/div[2]");
	public static final By DwellingExposureLink = By.xpath("//div[contains(@id,'ClaimExposures-ClaimExposuresScreen-ExposuresLV') and contains(text(),'Dwelling')]");
	public static final By BodilyInjuryExposureLink = By.xpath("//div[contains(@id,'ClaimExposures-ClaimExposuresScreen-ExposuresLV') and contains(text(),'Bodily Injury')]");
	public static final By MedPayExposureLink = By.xpath("//div[contains(@id,'ClaimExposures-ClaimExposuresScreen-ExposuresLV') and contains(text(),'Med Pay')]");
	public static final By PropertyExposureLink = By.xpath("//div[contains(@id,'ClaimExposures-ClaimExposuresScreen-ExposuresLV') and contains(text(),'Property')]");
	public static final By VehicleExposureLink = By.xpath("//div[contains(@id,'ClaimExposures-ClaimExposuresScreen-ExposuresLV') and contains(text(),'Vehicle')]");
	public static final By GeneralDamageExposureLink = By.xpath("//div[contains(@id,'ClaimExposures-ClaimExposuresScreen-ExposuresLV') and contains(text(),'General')]");
	public static final By reOpenExposure = By.xpath("//div[@id='ExposureDetail-ExposureDetailScreen-ExposureDetailScreen_ReopenButton']");
	public static final By exposureAssign = By.xpath("//div[contains(@id,'ExposureDetail-ExposureDetailScreen-ExposureDetailScreen_AssignButton')]");
	public static final By assignmentList = By.xpath("//select[@name='AssignExposuresPopup-AssignmentPopupScreen-AssignmentPopupDV-SelectFromList']");
	public static final By assignBtn = By.xpath("(//div[contains(@id,'AssignmentPopupDV-AssignmentPopupScreen_ButtonButton')])[2]");
			
			
	
	
}
