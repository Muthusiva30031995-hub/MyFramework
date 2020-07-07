package com.testautomation.PageUI;

import org.openqa.selenium.By;

public class LossDetailsPageUI {
	
	public static final By lossDetailsTitile = By.xpath("//div[contains(@id,'ClaimLossDetails-ClaimLossDetailsScreen-ttlBar')]//div[text()='Loss Details']");
	public static final By lossDetailsLink = By.xpath("//div[@id='Claim-MenuLinks-Claim_ClaimLossDetailsGroup']/div[1]");
	public static final By lossDetailEditLink = By.xpath("//div[@id='ClaimLossDetails-ClaimLossDetailsScreen-Edit']/div[1]");
	public static final By lossDescription = By.xpath("//textarea[contains(@name,'LossDetailsDV-Description')]");
	public static final By responsibleParty = By.xpath("//select[contains(@name,'LossDetailsDV-ResponsibleParty')]");
	public static final By faultRating = By.xpath("//select[contains(@name,'LossDetailsDV-Notification_Fault')]");
	public static final By insuredPercentage = By.xpath("//input[contains(@name,'LossDetailsDV-Notification_AtFaultPercentage')]");
	public static final By Reinsurance = By.xpath("//select[contains(@name,'LossDetailsDV-Ext_Reinsurance_MLPLInputSet-Ext_Reinsurance_MLPLInputSet-Ext_Reinsurance_MLPL')]");
	public static final By locationOfLoss = By.xpath("//select[contains(@name,'LossDetailsDV-LocationofLoss')]");
	public static final By contributingAddBtn = By.xpath("//div[contains(@id,'EditableContributingFactorsLV_tb-Add')]/div/div[2]");
	public static final By primaryCategory = By.xpath("//select[contains(@name,'ContributingFactors_contribprimary')]");
	public static final By subCategory = By.xpath("//select[contains(@name,'ContributingFactors_contribsecond')]");
	public static final By contributingDescription = By.xpath("//input[contains(@name,'EditableContributingFactorsLV-0-EditableContributingFactors_Text')]");
	public static final By metroAddBtn = By.xpath("//div[contains(@id,'MetroReportsLV_tb-Add')]/div");
	public static final By metroReportType = By.xpath("//select[contains(@name,'MetroReportDetailsDV-MetroReportType')]");	
	public static final By metroCityOfInvestAgency = By.xpath("//input[contains(@name,'MetroReportDetailsDV-MetroInvestAgencyCity')]");
	public static final By metroStateOfInvestAgency = By.xpath("//select[contains(@name,'MetroReportDetailsDV-MetroInvestAgencyState')]");
	public static final By metroInsuredVehicle = By.xpath("//select[@name=\"NewMetroReportDetailsPopup-MetroReportDetailsScreen-MetroReportDetailsDV-InsuredVehicle\"]");
	public static final By metroPolitianUpdate = By.xpath("//div[contains(@id,'NewMetroReportDetailsPopup-MetroReportDetailsScreen-Update')]");
	public static final By lossDetailsUpdateBtn = By.xpath("//div[contains(@id,'ClaimLossDetails-ClaimLossDetailsScreen-Update')]");
	public static final By certificateNumber = By.xpath("//input[contains(@name,'LossDetailsDV-CertificateNumber')]");
	public static final By estimatesLink = By.xpath("//div[contains(@id,'ClaimLossDetailsGroup_Ext_ClaimEstimates')]/div");
	public static final By symbilitySendStatus = By.xpath("//div[text()='Symbility Send Status']/../div[2]/div[contains(@id,'EstimateDV-sendStatus')]/div/div");
	public static final By sendToSymbility = By.xpath("//div[contains(@id,'EstimateDV_tb-SendtoSymbility')]/div");
	public static final By notifyVendorOfAssignment = By.xpath("//div[text()='Notify Vendor of Assignment']");
}
