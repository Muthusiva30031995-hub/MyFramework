package com.testautomation.PageUI;

import org.openqa.selenium.By;

public class SearchContactPageUI {
	
	public static final By reportedByNameIcon = By.xpath("//div[contains(@id,'NameMenuIcon')]/div[2]");
	public static final By search = By.xpath("//div[contains(@id,'ReportedBy_Name-MenuItem_Search')]");
	public static final By lastNameTxt = By.xpath("//input[contains(@name,'AddressBookSearchDV-NameInputSet-GlobalContactNameInputSet-Name')]");
	public static final By taxIDTxt = By.xpath("//input[contains(@name,'AddressBookSearchDV-TaxID')]");
	public static final By searchBtn = By.xpath("//div[contains(@id,'AddressBookSearchDV-SearchAndResetInputSet-SearchLinksInputSet-Search')]");
	public static final By selectBtn = By.xpath("//div[contains(@id,'AddressBookSearchLV-0-_Select')]");
}
