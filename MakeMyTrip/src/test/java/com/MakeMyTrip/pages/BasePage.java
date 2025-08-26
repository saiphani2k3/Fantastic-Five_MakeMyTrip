package com.MakeMyTrip.pages;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;

import com.MakeMyTrip.Utilities.ConfigReader;
/**
 * BasePage serves as a parent class for all page classes in the framework.
 * It initializes the WebDriver and sets up PageFactory for locating web elements.
 */
public class BasePage {
	
	@FindBy(xpath= "//span[@class='commonModal__close']")
	WebElement closePopup;
	
    // WebDriver instance used by all page classes
	
    WebDriver driver;
    JavascriptExecutor jse;
    FluentWait<WebDriver> wait;
    //Constructor to initialize the WebDriver and PageFactory elements.
    
    public BasePage(WebDriver driver) {
        this.driver = driver;
		jse=(JavascriptExecutor)driver;
        // Initialize all WebElements in the page using PageFactory
        PageFactory.initElements(driver, this);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(ConfigReader.getProperty("implicit.wait"))));
        
        wait=new FluentWait<>(driver)
				.withTimeout(Duration.ofSeconds(Integer.parseInt(ConfigReader.getProperty("Fluent.wait"))))
				.pollingEvery(Duration.ofSeconds(Integer.parseInt(ConfigReader.getProperty("Polling.time"))))
				.ignoring(NoSuchElementException.class);
        
        
    }
    public boolean popUpDisplayed() {
		
		return closePopup.isDisplayed();
	}
    
    public void ClosePopUp() {
		
		closePopup.click();
	}
}
