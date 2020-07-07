package com.testautomation.StepDef;

import cucumber.api.java.en.And;


public class PartiesInvolvedPageStepDef extends UIBaseStepDef{
	
	@And("^Update \"(.*)\" contact for \"(.*)\" in parties Involved page$")
	public void updating_contacts_in_parties_involved_page(String contactType,String contactName) throws Exception
	{
		partiesInvolvedPage.updatingContacts(contactType,contactName); 
		
	}

	@And("^Add existing contact \"(.*)\" in parties involved page$")
	public void add_existing_contact_ASI_in_parties_involved_page(String contactName)throws Exception
	{
		partiesInvolvedPage.addingExistingContact(contactName); 
		
	}
}
