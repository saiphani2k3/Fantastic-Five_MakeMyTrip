package com.MakeMyTrip.StepDefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.MakeMyTrip.Hooks.Hooks;
import com.MakeMyTrip.pages.GetAdultCount;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HotelAdultCountStepDefinition {
	
	private WebDriver driver;
	private GetAdultCount count;
	private static final Logger logger=LogManager.getLogger(HotelAdultCountStepDefinition.class);
	
	@Given("User is in Homepage")
	public void when_user_is_in_homepage() {
		
		driver = Hooks.driver;
        if (driver == null) {
            throw new RuntimeException("Driver is not initialized. Check Hooks setup.");
        }
        count=new GetAdultCount(driver);
	}
	
	@When("Popup appears")
	public void pop_up_appears() {
		
		count.ClosePopUp();
	}

	@Then("Navigate to the Hotels section")
	public void navigate_to_the_hotels_section() {
	    
		count.hotels();
	}

	@Then("Click the Rooms&Guests button")
	public void click_the_rooms_guests_button() {
	    
		count.rooms();
	}

	@Then("Click the Adults dropdown button")
	public void click_the_adults_dropdown_button() {
	    
		count.dropdown();
	}

	@Then("Retrieve the max number of adults to be accommodated")
	public void retrieve_the_max_number_of_adults_to_be_accommodated() {
		
		count.adultCount();
		logger.info("Count of max adults retrieved.");
	}

}
