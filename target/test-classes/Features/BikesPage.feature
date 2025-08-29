Feature: Honda Bikes Details

	Scenario: User launches ZigWheels homepage
			Given User launch the browser
			When User opens the url "https://www.zigwheels.com/"
			
	Scenario: User searches for upcoming Honda bikes
			And User clicks on the search bar
			And User enters "Upcoming Honda" in the search bar
			And User clicks down arrow key
			And User clicks enter
	
	Scenario: Display all bikes from search results
			Then All bikes are displayed
			
	Scenario: Display Honda bikes under 4 lacs
			And Honda bikes with price less than "4" lacs are displayed on the console
