package com.MakeMyTrip.StepDefinitions;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.MakeMyTrip.Hooks.Hooks;
import com.MakeMyTrip.pages.CabsPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CabSearchStepDefinition {
	
	private WebDriver driver;
	private CabsPage cabs;
	private static final Logger logger=LogManager.getLogger(CabSearchStepDefinition.class);
	
	@Given("User is in the home page")
	public void user_is_in_the_home_page() throws IOException {
		
		driver = Hooks.driver;
        if (driver == null) {
            throw new RuntimeException("Driver is not initialized. Check Hooks setup.");
        }
        cabs=new CabsPage(driver);
	}
	
	@When("PopUp appears")
	public void pop_up_appears() {
		
		Assert.assertTrue(cabs.popUpDisplayed(),"The popup is displayed");
	}
	@Then("Close the popup")
	public void close_the_popup() {
		
		cabs.ClosePopUp();
	}
	@Then("Navigate to the cabs section")
	public void navigate_to_the_cabs_section() {
		
		cabs.Cab();
	}
	@When("User in cabs section")
	public void user_in_cabs_section() {
		
		Assert.assertTrue(cabs.inCabs(),"The user is at the cabs section");
	}
	@Then("Select {string} as Travel from location")
	public void select_as_travel_from_location(String from) throws InterruptedException {
		
		cabs.currlocation();
	}
	@Then("Select {string} as Travel to location")
	public void select_as_travel_to_location(String destination) throws InterruptedException {
		
		cabs.destination();
	}
	@Then("Select {string} and {string} as Travel Date")
	public void select_and_as_travel_date(String month, String date) throws InterruptedException {
		
		cabs.DateSelection();
	}
	@Given("User want to select TimeOfTravel")
	public void user_want_to_select_time_of_travel() {
		
		cabs.time();
	}
	@Then("Select {string} {string} {string} you want to travel at")
	public void select_you_want_to_travel_at(String hrs, String minutes, String meridian) {
		
		cabs.timeSelection();
	}
	@Then("Click search")
	public void click_search() {
		
		cabs.search();
	}
	@When("User is in Cabs page and Package appears")
	public void user_is_in_cabs_page_and_package_appears() {
		Assert.assertTrue(cabs.Page(),"The cabs page has loaded");
	}
	@Then("Close the Package popup")
	public void close_the_package_popup() {
		
		cabs.PackagePopUp();
	}
	@Then("Click the {string}")
	public void click_the(String carType) {
		
		cabs.CabType();
	}
	@Then("Retrieve the lowest costing Cab for the type")
	public void retrieve_the_lowest_costing_cab_for_the_type() {
		
		cabs.LowestCostCab();
		logger.info("The lowest costing cab value retrieved.");
	}

}
