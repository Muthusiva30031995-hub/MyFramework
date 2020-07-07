Feature: TestIDLogin

Background: 
	Given Open "GWCC" environment

Scenario: Login for TestID
Given Login to the application with TestUserID
And Logout to the application 
