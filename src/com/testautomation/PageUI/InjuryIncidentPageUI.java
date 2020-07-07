package com.testautomation.PageUI;

import org.openqa.selenium.By;

public class InjuryIncidentPageUI {

	public static final By injuryAddBtn = By.xpath("//div[contains(@id,\"QuickClaimDV-EditableInjuryIncidentsLV_tb-Add\")]/div");
	public static final By injuredPerson = By.xpath("//select[contains(@name,'InjuryIncidentDV-Injured_Picker')]");
	public static final By lossParty = By.xpath("//select[contains(@name,'InjuryIncidentDV-InjuryIncidentInputSet-LossParty')]");
	public static final By severity = By.xpath("//select[contains(@name,'InjuryIncidentDV-InjuryIncidentInputSet-Severity')]");
	public static final By description = By.xpath("//textarea[contains(@name,'InjuryIncidentDV-InjuryIncidentInputSet-InjuryDescription')]");
	public static final By injuryType = By.xpath("//select[contains(@name,'InjuryIncidentDV-InjuryIncidentInputSet-PrimaryInjuryType')]");
	public static final By bodyPartsAddBtn = By.xpath("//div[contains(@id,'InjuryIncidentDV-InjuryIncidentInputSet-EditableBodyPartDetailsLV_tb-Add')]/div");
	public static final By areaOfBody = By.xpath("//select[contains(@name,'InjuryIncidentDV-InjuryIncidentInputSet-EditableBodyPartDetailsLV-0-PrimaryBodyPart')]");
	public static final By detailedBody = By.xpath("//select[contains(@name,'InjuryIncidentDV-InjuryIncidentInputSet-EditableBodyPartDetailsLV-0-DetailedBodyPart')]");
	public static final By detailedInjuryType = By.xpath("//select[contains(@name,'InjuryIncidentDV-InjuryIncidentInputSet-EditableBodyPartDetailsLV-0-DetailedInjuryPart')]");
	public static final By injuryIncidentOkBtn = By.xpath("//div[@id=\"NewInjuryIncidentPopup-NewInjuryIncidentScreen-Update\"]//div");
	
}
