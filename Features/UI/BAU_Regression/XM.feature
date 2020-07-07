Feature: XM

Background: 
	Given Open "GWCC" environment
	And Login to the application
	
Scenario: TC007_BBCEHomeowners-XM-Property_TEST_OPT
	When Search a policy and select "Property" type	
#	When Search an existing claim "207782P"
	And Search a contact
	Then Enter details in FNOL page
	And Add injury incident in FNOL page	
	And Add dwelling incident in FNOL page
	And Click on finish button in FNOL page
	When Enter details in loss details page
	Then Add metro politian details in loss details page
	When Navigate to "Dwelling" exposure through "1b-2a-3a-4a-5a"	
	Then Add details for exposure "1" in exposure page
	When Navigate to "Med Pay" exposure through "1b-2a-3c-4a-5a"
	Then Add details for exposure "2" in exposure page	
	And Create reserve for exposure "1" with "Expense - Legal" and "Legal"
	And Create reserve for exposure "2" with "Indemnity" and "Excess"
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
 	And Close the "Dwelling" exposure
 	And Close the "Med Pay" exposure
 	And Close the matter
 	And Close the claim
 	
 Scenario: TC042_BBCECommercialPackage-Liability-Salvage - XM - New Incident_TEST_OPT
 	When Search a policy and select "Auto" type	
 	And Click Next button in Step 2 of 3 policy properties page
 	And Search a contact
	Then Enter details in FNOL page
	And Add injury incident in FNOL page
	And Add vehicle incident for "New..." in FNOL page
	And Click on finish button in FNOL page	
	When Enter details in loss details page
    Then Add metro politian details in loss details page 
    Then Edit vehicle details and add vehicle Style
    Then Add vehicle appraisal in loss details page
    And Add existing contact "ASI" in parties involved page
    When Navigate to "Vehicle Damage" exposure through "1a-2a-3a-4a-5c"	
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
 	
 Scenario: CommercialProperty_AutomatedAssignment-EXCL-DwellingFire-History
	When Search a policy and select "Property" type
	And Search a contact
	Then Enter details in FNOL page
	And Add dwelling incident in FNOL page
	And Click on finish button in FNOL page
	Then Navigate to estimates screen and validate symbility status