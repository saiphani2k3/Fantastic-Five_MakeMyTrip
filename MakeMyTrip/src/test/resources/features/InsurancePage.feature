Feature:Retrieve the Insurance details
	
	Scenario:Retriving the Insurance provider and the plans available
	
	Given Users on MakeMyTrip page
	When the Popup appears,Close it
	
	When User navigates to Insurance Page
	Then User selects the country "<country>" and confirm the destiantion
	Then select plan "<plan>" according to requirements
	And click search
	Then Click Okay on the popUp that appears
	And retrieve the Insurance provider and plans available 
	