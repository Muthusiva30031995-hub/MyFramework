Feature: Mobile Automation

Scenario: TC_001_Calculator_Automation	
	When Add two numbers in calculator
	Then Validate the result of additon of two numbers 
	
Scenario: TC_002_Dial_Mobile_Number	
	When Dial a mobile number

Scenario: TC_003_Send_SMS_In_Android_Mobile
	When Send a message through messages app
	
Scenario: TC_004_Operation_On_API_Demos_App
	When Navigate to API demos and click on "Views"