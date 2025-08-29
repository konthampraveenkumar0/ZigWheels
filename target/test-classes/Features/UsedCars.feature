
Feature: Used Cars details

	Scenario: Searching for Used Cars in Chennai
		Given User is already on the application
		When User clicks on the search bar
		And User enters "Used Cars In Chen" in the search bar
		And User clicks down arrow key
		And User clicks enter
		Then Search result is displayed
	
	Scenario: No Search Results Found
		When Search result equals "No data found"
		Then "No cars found" is displayed on the console
		
	Scenario: Filtering Popular Models
		When All cars used in Chennai are displayed
		And User filters all the popular models
		Then Filtered results are displayed
		When Filtered results equals "No data found"
		Then Nothing is displayed on the console
		When All popular car models are displayed
		Then Names of all popular car models are displayed on the console


	
	
