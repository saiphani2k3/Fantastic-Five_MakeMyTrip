package com.MakeMyTrip.StepDefinitions;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.MakeMyTrip.Hooks.Hooks;
import com.MakeMyTrip.pages.GiftCardAction;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class GiftCardActionStepDefinition {
	
	private WebDriver driver;
	private GiftCardAction card;
	private static final Logger logger=LogManager.getLogger(GiftCardActionStepDefinition.class);
	
	@Given("User is the home page")
	public void user_is_the_home_page() throws IOException {
		
		driver=Hooks.driver;
        if (driver == null) {
            throw new RuntimeException("Driver is not initialized. Check Hooks setup.");
        }
        card=new GiftCardAction(driver);
	}
	
	@Then("Navigate to the GiftCards Page")
	public void navigate_to_the_gift_cards_page() {
	    card.giftCardWindow();
	}

	@Then("Select {string} from the list of GiftCards")
	public void select_gift_card_from_the_list_of_gift_cards(String string) {
	    card.cardSelection();
	}

	@Then("Navigate to the address section")
	public void navigate_to_the_address_section() {
	   card.ScrollTo();
	}

	@Then("Give invalid {string} {string} {string} in the input")
	public void give_invalid_details_in_the_input(String name,String number,String email) {
	    card.PaymentValidation();
	}

	@Then("Retrieve the messages")
	public void retrieve_the_messages() {
	    card.errorMessage();
	    logger.info("Error occured.");
	}
}
