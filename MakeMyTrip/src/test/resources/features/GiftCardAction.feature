Feature: Retrieve the error message displayed

	Scenario: Retrieving the error messaged displayed when incorrect details are given

		Given User is the home page
		Then Navigate to the GiftCards Page
		Then Select "<Gift Card Name>" from the list of GiftCards
		Then Navigate to the address section
		And Give invalid "<Name>" "<Number>" "<Email>" in the input
		Then Retrieve the messages
	