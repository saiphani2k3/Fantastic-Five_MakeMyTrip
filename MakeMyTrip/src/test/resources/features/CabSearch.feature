Feature:Searching Cabs 
Scenario: Searching for Cabs for travel
	Given User is in the home page
	
		When PopUp appears,close it
		Then Navigate to the cabs section
	
		When User in cabs section,validate if outstation and is selected
		Then Select "<From>" as Travel from location
		And Select "<Destination>" as Travel to location
		And Select "<TravelMonth>" and "<TravelDate>" as Travel Date
		
		Given User want to select TimeOfTravel
		Then Select time "<Hour>" "<Minute>" "<Meridian>" you want to travel at
		Then Click search
		
		When User is in Cabs page,Close the Package appears
		Then Click the carType "<CarType>"
		Then Retrieve the lowest costing Cab for the type
		