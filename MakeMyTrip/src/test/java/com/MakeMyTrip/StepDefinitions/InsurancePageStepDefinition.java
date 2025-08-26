package com.MakeMyTrip.StepDefinitions;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.MakeMyTrip.Hooks.Hooks;
import com.MakeMyTrip.pages.InsurancePage;

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
	
	@When("the Popup appears")
	public void the_popup_appears() {
		Assert.assertTrue(Insurance.popUpDisplayed(),"Popup is displayed");
	}
	
	@Then("close the popUp")
	public void close_the_pop_up() {
	    Insurance.closePopUp();
	}

	@Given("User navigates to Insurance Page")
	public void user_navigates_to_insurance_page() {
	    Insurance.insurance();
	}

	@Then("User selects the {string} and confirm the destiantion")
	public void user_selects_the_and_confirm_the_destiantion(String string) {
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

	@When("User is in the plans page")
	public void user_is_in_the_plans_page() {
		Assert.assertTrue(Insurance.Page(),"The Plans page has loaded");
	}

	@Then("retrieve the Insurance provider and plans available")
	public void retrieve_the_insurance_provider_and_plans_available() {
	    Insurance.deatils();
	    logger.info("Plan details and provider details retrieved.");
	}
}
