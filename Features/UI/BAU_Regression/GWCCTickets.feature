Feature: GWCC Tickets

Background: 
	Given Open "GWCC" environment
	And Login to the application	

Scenario: GWCC-23546_Legacy claim search_TC001
	When Search a legacy cliam "AL071617" in adavnce serach screen
	And Should not get the error "ClassCastException: com.guidewire.pl.system.database.impl"
	Then The results should be displayed and resulted claim should be opened 

Scenario: GWCC-23546_Legacy claim search_TC002
	When Search a legacy policy "2217016001" in adavnce serach screen 
	And Should not get the error "ClassCastException: com.guidewire.pl.system.database.impl"
	Then The results should display the claims having that policy and claim should be opened 	