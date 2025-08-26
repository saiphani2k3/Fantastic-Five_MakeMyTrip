package com.MakeMyTrip.pages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.MakeMyTrip.Utilities.ConfigReader;
import com.MakeMyTrip.Utilities.ExcelUtil;
import com.MakeMyTrip.Utilities.JsonWriter;

public class GiftCardAction extends BasePage{
	
	List<HashMap<String,String>> data= new ArrayList<>();
	
	JsonWriter writer=new JsonWriter();
	
	String giftCard;
	String name;
	String number;
	String email;
	
	public GiftCardAction(WebDriver driver) throws IOException {
		super(driver);
		ExcelUtil excel=new ExcelUtil();
		data=excel.data(ConfigReader.getProperty("test.data.file"),"GiftCard");
		
		giftCard=data.get(0).get("Gift Card Name");
		name=data.get(0).get("Name");
		number=data.get(0).get("Number");
		email=data.get(0).get("Email");
		
	}

	
	@FindBy(xpath= "//span[@class='commonModal__close']")
	WebElement closePopup;
	
	@FindBy(xpath= "//img[@alt='Gift Cards_image']")
	WebElement clickGiftCard;
	
	@FindBy(xpath= "//h3[@class='lato-black black-text']")
	List<WebElement> giftCards;
	
	@FindBy(name= "senderName")
	WebElement sendername;
	
	@FindBy(name= "senderMobileNo")
	WebElement senderMobileNo;
	
	@FindBy(name= "senderEmailId")
	WebElement senderEmail;
	
	@FindBy(xpath= "//*[text()='BUY NOW']")
	WebElement clickBuyNow;
	
	@FindBy(xpath= "//p[@class='note-text red-text lato-black append-bottom20']")
	WebElement errorRes1;
	
	@FindBy(xpath= "//p[@class='red-text font11 append-top5']")
	WebElement errorRes2;
	
	public void giftCardWindow() {
		
		closePopup.click();
		
        jse.executeScript("arguments[0].scrollIntoView(true);", clickGiftCard);
        jse.executeScript("arguments[0].click()", clickGiftCard);
        
        
        Set<String> windowsId= driver.getWindowHandles();
        String title=driver.getTitle();
        
        for(String tab :windowsId) {
        	if(driver.getTitle().equals(title)){
        		driver.switchTo().window(tab);
        	}
        }
	}
	
	public void cardSelection() {
		for(WebElement Card:giftCards) {
			if(giftCard.equalsIgnoreCase(Card.getText())) {
				jse.executeScript("arguments[0].click()", Card);
				break;
			}
		}
	}
	
	public void ScrollTo() {
		
		jse.executeScript("arguments[0].scrollIntoView(false)",senderMobileNo);
	}
	
	public void PaymentValidation() {
		        
        sendername.sendKeys(name);
        senderMobileNo.sendKeys(number);
        senderEmail.sendKeys(email);
        
        jse.executeScript("arguments[0].click()", clickBuyNow);
	}
	
	public void errorMessage() {
		
		String error1=errorRes1.getText();
		String error2=errorRes2.getText();
		
		System.out.println(error1);        
	    System.out.println(error2);
	     
	    writer.writeToFile("GiftCard.json","Error messages retrieved: ",error1);
	    writer.writeToFile("GiftCard.json","Error messages retrieved: ",error2);
	     
	     
	}
}


