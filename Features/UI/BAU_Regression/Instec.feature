Feature: Instec

Background: 
	Given Open "GWCC" environment
	And Login to the application

Scenario: TC119_GWCC_SecurityFirst_Property1_TEST_OPT
	When Search a policy and select "Property" type
	And Search a contact
	Then Enter details in FNOL page
	And Add dwelling incident in FNOL page
	And Click on finish button in FNOL page
	When Enter details in loss details page
	Then Add metro politian details in loss details page
	When Navigate to "dwelling" exposure through "1a-2a-3f-4a-5a"	
	Then Add details for exposure "1" in exposure page
	And Create reserve for exposure "#1" with "Indemnity" and "Loss"
	And Create reserve for exposure "#1" with "Expense - Legal" and "Legal"
 	Then Create a matter through litigation
 	And Add "Check" payment for reserveline "#1"
 	And Add "Electronic funds transfer" payment for reserveline "#1" 
 	And Add "Check" payment for reserveline "#2"	
 	Then Add manual check payment for reserveline "#1" 	 	
 	And Recode the check amount
 	Then transfer the check amount
 	And Create a recovery
 	Then Close all the activities in activities page
 	And Close the "Dwelling" exposure
 	And Close the matter
 	And Close the claim 	
 	

 Scenario: TC118_McDonalds_Property1_TEST_OPT_TD1
	When Search a policy and select "Property" type
	And Search a contact
	Then Enter details in FNOL page
	And Add property incident in FNOL page
	And Click on finish button in FNOL page	

 	

	 	
    
 

