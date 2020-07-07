package com.testautomation.PageUI;

import org.openqa.selenium.By;

public class MSPDetailsPageUI {
	
	public static final By editLink = By.xpath("//div[@id=\"ExposureDetail-ExposureDetailScreen-Edit\"]");
	public static final By MSPDetailsTab = By.xpath("//div[@id=\"ExposureDetail-ExposureDetailScreen-ExposureDetailDV-MSP_CardTab\"]");
	public static final By insuranceType = By.xpath("//select[contains(@name,\"MSPDetailsDV-insurancetype\")]");
	public static final By noFaultInsuranceLimit = By.xpath("//input[@name=\"ExposureDetail-ExposureDetailScreen-ExposureDetailDV-MSPDetailsDV-nfiLV-nfilimit\"]");
	public static final By claimStatus = By.xpath("//select[@name=\"ExposureDetail-ExposureDetailScreen-ExposureDetailDV-MSPDetailsDV-nfiLV-claimstatus\"]");
	public static final By cmsActionList = By.xpath("//select[@name=\"ExposureDetail-ExposureDetailScreen-ExposureDetailDV-MSPDetailsDV-nfiLV-cmsaction\"]");
	public static final By stopProcessingDesc = By.xpath("//textarea[contains(@name,\"ExposureDetailDV-MSPDetailsDV-stopprocessdesc\")]");
	public static final By mspUpdate = By.xpath("//div[contains(@id,'ExposureDetail-ExposureDetailScreen-Update')]");
	public static final By ssnID = By.xpath("//div[@id='ExposureDetail-ExposureDetailScreen-ExposureDetailDV-MSPDetailsDV-TaxID']/div/div");
	public static final By tpocAddBtn = By.xpath("//div[contains(@id,'MSPDetailsDV-tpocLV_tb-Add')]/div");
	public static final By tpocDate = By.xpath("//input[contains(@name,'MSPDetailsDV-tpocLV-0-tpocdate')]");
	public static final By tpocAmount = By.xpath("//input[contains(@name,'MSPDetailsDV-tpocLV-0-tpocamount')]");
	public static final By closeFuture = By.xpath("//select[contains(@name,'MSPDetailsDV-cfmidLV-closefuturemedicals')]");
	public static final By icd = By.xpath("//div[contains(@id,'MSPDetailsDV-icdLV_tb-Add')]");
	public static final By icdText = By.xpath("//input[contains(@name,'MSPDetailsDV-icdLV-0-ICD10Code')]");
	public static final By injuredPerson = By.xpath("//div[@id='ExposureDetail-ExposureDetailScreen-ExposureDetailDV-MSPDetailsDV-Incident_Injured']/div/div");
	public static final By contactEditBtn = By.xpath("//div[contains(@id,'ContactBasicsDV_tb-ContactDetailToolbarButtonSet-Edit')]/div");
	public static final By taxIDDropdown = By.xpath("(//div[@id='ClaimContactDetailPopup-ContactDetailScreen-ContactBasicsDV-AdditionalInfoInputSet-TaxID-dropMenu']/div)[2]");
	public static final By dobTxt = By.xpath("//input[@name='ClaimContactDetailPopup-ContactDetailScreen-ContactBasicsDV-AdditionalInfoInputSet-DateOfBirth1']");
	public static final By gender = By.xpath("//select[@name='ClaimContactDetailPopup-ContactDetailScreen-ContactBasicsDV-AdditionalInfoInputSet-Gender']");
	public static final By taxIDDelete = By.xpath("//div[@id='ClaimContactDetailPopup-ContactDetailScreen-ContactBasicsDV-AdditionalInfoInputSet-TaxID-dropMenu-delete']/div");
	public static final By contactOkBtn = By.xpath("//div[@id='ClaimContactDetailPopup-ContactDetailScreen-ContactBasicsDV_tb-ContactDetailToolbarButtonSet-Update']/div");
	public static final By mbi = By.xpath("//div[@id='ExposureDetail-ExposureDetailScreen-ExposureDetailDV-MSPDetailsDV-hicn']/div/div");
	public static final By mbiValue = By.xpath("//input[@name='ClaimContactDetailPopup-ContactDetailScreen-ContactBasicsDV-AdditionalInfoInputSet-hicnNew']");
}
