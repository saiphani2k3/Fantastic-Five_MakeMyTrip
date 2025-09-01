package com.MakeMyTrip.StepDefinitions;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.MakeMyTrip.Hooks.Hooks;
import com.MakeMyTrip.pages.InsurancePage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class InsurancePageStepDefinition {
	
	private WebDriver driver;
	private InsurancePage Insurance;
	private static final Logger logger=LogManager.getLogger(InsurancePageStepDefinition.class);
	
	@Given("Users on MakeMyTrip page")
	public void user_on_MakeMyTrip_page() throws IOException {
		
		driver = Hooks.driver;
        if (driver == null) {
            throw new RuntimeException("Driver is not initialized. Check Hooks setup.");
        }
        Insurance=new InsurancePage(driver);
	}
	
	@When("the Popup appears,Close it")
	public void the_popup_appears_close_it() {
		
		Insurance.ClosePopUp();
	}

	@When("User navigates to Insurance Page")
	public void user_navigates_to_insurance_page() {
		
	    Insurance.insurance();
	}

	@Then("User selects the country {string} and confirm the destiantion")
	public void user_selects_the_country_and_confirm_the_destiantion(String string) {
		
	    Insurance.country();
	    Insurance.submit();
	}

	@Then("select plan {string} according to requirements")
	public void select_plan_according_to_requirements(String string) {
		
	    Insurance.plans();
	}

	@Then("click search")
	public void click_search() {
		
	    Insurance.search();
	}

	@Then("Click Okay on the popUp that appears")
	public void click_okay_on_the_pop_up_that_appears() {
		
	    Insurance.confirm();
	}

	@And("retrieve the Insurance provider and plans available")
	public void retrieve_the_insurance_provider_and_plans_available() {
		
	    Insurance.deatils();
	    logger.info("Plan details and provider details retrieved.");
	}
}
