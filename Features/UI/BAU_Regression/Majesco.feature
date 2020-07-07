Feature: XM

Background: 
	Given Open "GWCC" environment
	And Login to the application
	

Scenario: TC108_BBCE_Aviation_Majesco_CGL_Aviation_TEST_OPT
	When Search a policy and select "Aviation" type
	And Click Next button in Step 2 of 3 policy properties page
	And Search a contact
	Then Enter details in FNOL page
	And Add injury incident in FNOL page
	And Add aviation incident in FNOL page
	And Click on finish button in FNOL page
	When Enter details in loss details page
	Then Add metro politian details in loss details page
	When Navigate to "Aviation" exposure through "1a-2a-3a-4d-5c"	
	Then Add details for exposure "1" in exposure page
	When Navigate to "Bodily Injury" exposure through "1a-2a-3a-4d-5a"
	Then Add details for exposure "2" in exposure page
	And Create reserve for exposure "1" with "Indemnity" and "Loss"
	And Create reserve for exposure "1" with "Expense - Legal" and "Legal"
	And Create reserve for exposure "2" with "Indemnity" and "Excess"
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
 	And Close the "Aviation" exposure
 	And Close the "Bodily Injury" exposure
 	And Close the matter
 	And Close the claim