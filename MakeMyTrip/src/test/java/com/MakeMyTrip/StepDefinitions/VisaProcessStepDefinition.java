package com.MakeMyTrip.StepDefinitions;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.MakeMyTrip.Hooks.Hooks;
import com.MakeMyTrip.pages.VisaProcess;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class VisaProcessStepDefinition{
	
	private WebDriver driver;
	private VisaProcess visa;
	private static final Logger logger=LogManager.getLogger(VisaProcessStepDefinition.class);
	
	@Given("Users on MakeMyTrip main page")
	public void users_on_make_my_trip_main_page() throws IOException {
		
		driver = Hooks.driver;
        if (driver == null) {
            throw new RuntimeException("Driver is not initialized. Check Hooks setup.");
        }
        visa=new VisaProcess(driver);
	}

	@When("the Popup is visible,Close the popup")
	public void the_popup_is_visible_close_the_popup() {
		visa.ClosePopUp();
	}

	@Then("User navigates to Visa Page")
	public void user_navigates_to_visa_page() {
	    
		visa.Visa();
	}

	@Then("Select the country {string} to which u want to apply for visa")
	public void select_the_country_to_which_u_want_to_apply_for_visa(String string) {
	    
		visa.visaCountry();
	}

	@Then("Select the date {string} and search")
	public void select_the_date_and_search(String string) {
	    
		visa.VisaDate();
	}

	@Then("retrieve the Visa process steps")
	public void retrieve_the_visa_process_steps() {
	    
		visa.VisaSteps();
		logger.info("Visa steps retrieved.");
	}
}
