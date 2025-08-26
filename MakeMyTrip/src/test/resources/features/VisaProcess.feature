Feature:Retrieve Visa Process Step's
	
	Scenario:Retriving the steps for Visa Application 
	
	Given Users on MakeMyTrip main page
	When the Popup is visible
	Then close the popUp to proceed
	
	When User navigates to Visa Page
	Then Select the country "<Country>" to which u want to apply for visa 
	And Select the date "<Date>" and search
	Then retrieve the Visa process steps
	
	
	