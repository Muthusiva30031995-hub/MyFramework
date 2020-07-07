package com.testautomation.PageUI;

import org.openqa.selenium.By;

public class PartiesInvolvedPageUI {
	
	public static final By partiesInvoluedLink = By.xpath("//div[@id='Claim-MenuLinks-Claim_ClaimPartiesGroup']");
	public static final By contactEdit = By.xpath("//div[contains(@id,'ContactBasicsDV_tb-ContactDetailToolbarButtonSet-Edit')]");
	public static final By mobileNumber = By.xpath("//input[contains(@name,'ContactBasicsDV-PersonContactInfoInputSet-phoneInputSet-QBEPhoneInputSet-Mobile')]");
	public static final By primaryPhone = By.xpath("//select[contains(@name,'ContactBasicsDV-PersonContactInfoInputSet-PrimaryPhone')]");
	public static final By addExistingBtn = By.xpath("//div[contains(@id,'PeopleInvolvedDetailedLV_tb-ClaimContacts_AddExistingButton')]/div");
	public static final By lastName = By.xpath("//input[contains(@name,'AddressBookSearchDV-NameInputSet-GlobalContactNameInputSet-Name')]");
	public static final By contactSearch = By.xpath("//div[contains(@id,'AddressBookSearchDV-SearchAndResetInputSet-SearchLinksInputSet-Search')]");
	public static final By contactSelect = By.xpath("//div[contains(@id,'AddressBookSearchLV-0-_Select')]");
    public static final By addBtn = By.xpath("//div[contains(@id,'ContactBasicsDV-ContactBasicsHeaderInputSet-EditableClaimContactRolesLV_tb-Add')]/div");
    public static final By roleList = By.xpath("//select[contains(@name,'EditableClaimContactRolesLV-0-Role')]");
    public static final By contactUpdate = By.xpath("//div[contains(@id,'ContactBasicsDV_tb-ContactDetailToolbarButtonSet-Update')]/div");
    
}


