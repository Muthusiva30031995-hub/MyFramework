Feature: GAIN

Background: 
	Given Open "GWCC" environment
	And Login to the application


Scenario: TC28_BBCEBusinessOwners_Property_Gain_TEST_OPT	
	When Search a policy and select "Property" type	
	And Click Next button in Step 2 of 3 policy properties page
	And Search a contact
	Then Enter details in FNOL page
	And Add injury incident in FNOL page
	And Add property incident in FNOL page	
	And Click on finish button in FNOL page
	When Enter details in loss details page
	Then Add metro politian details in loss details page
	When Navigate to "property" exposure through "1a_Contractors Section 1 - Liability - Property Damage" coverage
	Then Add details for exposure "1" in exposure page	
	When Navigate to "Bodily Injury" exposure through "1a_Contractors Section 1 - Liability - Bodily Injury" coverage
	Then Add details for exposure "2" in exposure page
	And Create reserve for exposure "1" with "Indemnity" and "Loss"
	And Create reserve for exposure "1" with "Expense - Legal" and "Legal"
	And Create reserve for exposure "2" with "Indemnity" and "Loss"
	Then Add MSP details for "Bodily injury" exposure
#	Then Add MSP details for "Bodily injury" with "SSN exists" and "MBI not exists"
	Then Create a matter through litigation
 	And Add "Check" payment for reserveline "1"
 	And Add "Electronic funds transfer" payment for reserveline "1"
 	And Add "Check" payment for reserveline "2"
 	Then Add manual check payment for reserveline "1"
 	And Recode the check amount
 	Then transfer the check amount
 	And Create a recovery
 	Then Close all the activities in activities page
 	And Close the "Property" exposure
 	And Close the "Bodily Injury" exposure
 	And Close the matter
 	And Close the claim
 	
@Smoke	
Scenario: TC110_GWCC_MarketScout_InlandMarine_Property_TEST_OPT
	When Search a policy and select "Property" type	
	And Search a contact
	Then Enter details in FNOL page		
	And Click on finish button in FNOL page
	When Enter details in loss details page
	Then Add metro politian details in loss details page
	Then Close all the activities in activities page
	And Close the claim
	
Scenario: TC02_BBCE_PersonalAuto_Salvage_GAIN_TEST_OPT	
# 	When Search an existing claim "208467P"
	When Search a policy and select "Auto" type		
	And Search a contact
	Then Enter details in FNOL page
	And Add injury incident in FNOL page
	And Add vehicle incident for "0001: 2002 CHEVROLET S10" in FNOL page
	And Click on finish button in FNOL page	
	When Enter details in loss details page
    Then Add metro politian details in loss details page 
    Then Edit vehicle details and add vehicle Style
    Then Add vehicle appraisal in loss details page
    And Update "Mobile" contact for "TERRY MOORE" in parties Involved page
    And Add existing contact "ASI" in parties involved page
    When Navigate to "Vehicle Damage" exposure through "1a-2a-3a-4a-5b"	
    Then Add details for exposure "1" in exposure page
    When Navigate to "Bodily Injury" exposure through "1a-2a-3a-4a-5a"
    Then Add details for exposure "2" in exposure page
    Then Add rental details in vehicle damage exposure
    Then Add salvage details in vehicle damage exposure
    And Create reserve for exposure "1" with "Indemnity" and "Loss"
	And Create reserve for exposure "1" with "Expense - Legal" and "Legal"
	And Create reserve for exposure "2" with "Indemnity" and "Loss"
	Then Add Rental Details in Vehicle incident from loss details page
	Then Add MSP details for "Bodily Injury" exposure
    Then Create a matter through litigation
 	And Add "Check" payment for reserveline "1"
 	And Add "Electronic funds transfer" payment for reserveline "1"
 	And Add "Check" payment for reserveline "2"
 	Then Add manual check payment for reserveline "1"
 	And Recode the check amount
 	Then transfer the check amount
 	And Create a recovery
 	Then Close all the activities in activities page
 	And Close the "Vehicle" exposure
 	And Close the "Bodily Injury" exposure
 	And Close the matter
 	And Close the claim
 	
Scenario: TC001_BBCE_DwellingFireProperty-GAIN_TEST_OPT	    
	When Search a policy and select "Property" type	
	And Click Next button in Step 2 of 3 policy properties page
	And Search a contact
	Then Enter details in FNOL page
	And Add injury incident in FNOL page
	And Add property incident in FNOL page	
	And Click on finish button in FNOL page
	When Enter details in loss details page
	Then Add metro politian details in loss details page
	When Navigate to "property" exposure through "1a-2a-3c-4a-5a" coverage
	Then Add details for exposure "1" in exposure page	
	When Navigate to "Med Pay" exposure through "1a-2a-3b-4a-5a" coverage
	Then Add details for exposure "2" in exposure page
	And Create reserve for exposure "1" with "Indemnity" and "Loss"
	And Create reserve for exposure "1" with "Expense - Legal" and "Legal"
	And Create reserve for exposure "2" with "Indemnity" and "Loss"	
	Then Add MSP details for "Med Pay" exposure 	
	Then Create a matter through litigation
 	And Add "Check" payment for reserveline "1"
 	And Add "Electronic funds transfer" payment for reserveline "1"
 	And Add "Check" payment for reserveline "2"
 	Then Add manual check payment for reserveline "1"
 	And Recode the check amount
 	Then transfer the check amount
 	And Create a recovery
 	Then Close all the activities in activities page
 	And Close the "Property" exposure
 	And Close the "Med Pay" exposure
 	And Close the matter
 	And Close the claim
 	