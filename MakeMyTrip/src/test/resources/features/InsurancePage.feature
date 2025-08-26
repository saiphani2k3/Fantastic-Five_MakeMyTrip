Feature:Retrieve the Insurance details
	
	Scenario:Retriving the Insurance provider and the plans available
	
	Given Users on MakeMyTrip page
	When the Popup appears
	Then close the popUp
	
	Given User navigates to Insurance Page
	Then User selects the "<country>" and confirm the destiantion
	Then select plan "<plan>" according to requirements
	And click search
	Then Click Okay on the popUp that appears
	
	When User is in the plans page
	Then retrieve the Insurance provider and plans available 
	