Feature:Searching Cabs 
Scenario: Searching for Cabs for travel
	Given User is in the home page
	
		When PopUp appears
		Then Close the popup
		Then Navigate to the cabs section
		
	
		When User in cabs section
		Then Select "<From>" as Travel from location
		And Select "<Destination>" as Travel to location
		And Select "<TravelMonth>" and "<TravelDate>" as Travel Date
		
		Given User want to select TimeOfTravel
		Then Select "<Hour>" "<Minute>" "<Meridian>" you want to travel at
		Then Click search
		
		When User is in Cabs page and Package appears
		Then Close the Package popup
		Then Click the "<CarType>"
		Then Retrieve the lowest costing Cab for the type
		