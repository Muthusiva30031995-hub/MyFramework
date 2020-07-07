Feature: Desktop Automation

Scenario: TC001_Notepad operations
	When Enter "Desktop automation" in notepad
	And Clear the entered text
	Then Close the notepad
	
Scenario: TC002_Internet explorer operations
	Given Navigate to Security settings

	
	
	