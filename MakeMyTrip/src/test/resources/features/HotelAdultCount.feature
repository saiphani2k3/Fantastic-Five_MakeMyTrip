Feature: Number of adults that can be accommodated at once
	Scenario:Adults max count to be accommodated at once
		
		Given User is in Homepage 
		When Popup appears
		Then Navigate to the Hotels section
		And Click the Rooms&Guests button
		And Click the Adults dropdown button
		And Retrieve the max number of adults to be accommodated