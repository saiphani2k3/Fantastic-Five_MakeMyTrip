package com.MakeMyTrip.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.MakeMyTrip.Utilities.JsonWriter;

public class GetAdultCount extends BasePage {
	
	JsonWriter writer=new JsonWriter();

	public GetAdultCount(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath ="//span[@class='commonModal__close']")
	WebElement closePopup;

	@FindBy(className ="menu_Hotels")
	WebElement hotels;

	@FindBy(css ="#guest")
	WebElement guests;

	@FindBy(className ="gstSlctCont")
	List<WebElement> adults;

	@FindBy(css =".gstSlct__list li") 
	List<WebElement> countOptions;
	
	public void closePopup() {
		
		jse.executeScript("arguments[0].click()",closePopup);
	}
	
	public void hotels() {
		
		jse.executeScript("arguments[0].click()",hotels);
	}
	
	public void rooms() {

		jse.executeScript("arguments[0].click()",guests);
	}
	
	public void dropdown() {
		
		adults.get(1).click();
	}
	public void adultCount() {

		WebElement lastOption = countOptions.get(countOptions.size()-1);
		writer.writeToFile("AdultCount.json","Number of adults that can be accomodated at once: ",lastOption.getText());
		System.out.println("Last dropdown option: " + lastOption.getText());
	}
}

