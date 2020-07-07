Feature: Majesco

Background: 
	Given Open "GWCC" environment
	And Login to the application	

Scenario: TC54_General Liability_QIC_TEST_OPT
	When Search a policy and select "Liability" type	
#	When Search an existing claim "207782P"
	And Click Next button in Step 2 of 3 policy properties page
	And Search a contact
	Then Enter details in FNOL page
	And Add injury incident in FNOL page	
	And Click on finish button in FNOL page
	When Enter details in loss details page
	Then Add metro politian details in loss details page
	Then Close all the activities in activities page
	And Close the claim