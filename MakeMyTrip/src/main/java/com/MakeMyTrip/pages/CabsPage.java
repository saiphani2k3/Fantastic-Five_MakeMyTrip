package com.MakeMyTrip.pages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.MakeMyTrip.Utilities.ConfigReader;
import com.MakeMyTrip.Utilities.ExcelUtil;
import com.MakeMyTrip.Utilities.JsonWriter;
import com.MakeMyTrip.base.BasePage;


public class CabsPage extends BasePage {
	
	JsonWriter writer=new JsonWriter();
	
	String from;
	String to;
	String destination;
	String travelMonth;
	String travelDate;
	String hours;
	String minutes;
	String meridian;
	String carType;
	
	List<HashMap<String,String>> data=new ArrayList<>();

	public CabsPage(WebDriver driver) throws IOException {
		super(driver);
		
		ExcelUtil excel= new ExcelUtil();
		data=excel.data(ConfigReader.getProperty("test.data.file="),"Cabs");
			
		from=data.get(0).get("From");
		to=data.get(0).get("To");
		destination=data.get(0).get("Destination");
		travelMonth=data.get(0).get("TravelMonth");
		travelDate=data.get(0).get("TravelDate");
		hours=data.get(0).get("Hour");
		minutes=data.get(0).get("Minute");
		meridian=data.get(0).get("Meridian");
		carType=data.get(0).get("CarType");	
        
    }
	
	@FindBy(linkText= "Cabs")
	WebElement cabs;
	
	@FindBy(xpath= "//ul[@class='latoBlack greyText b2c_cswTabs']/li")
	List<WebElement> Type;

	@FindBy(id="fromCity")
	WebElement currlocation;
	
	@FindBy(xpath="//span[@class='sr_city blackText']")
	List<WebElement> dropdown;
	
	@FindBy(xpath="//input[@placeholder='From']")
	WebElement cityName;
	
	@FindBy(id="toCity")
	WebElement dest;
	
	@FindBy(xpath= "//input[@placeholder='To']")
	WebElement destloc;
	
	@FindBy(xpath="//label[@for='departure']")
	WebElement date;
	
	@FindBy(xpath="//div[@class='DayPicker-Caption']")
	List<WebElement> month;
	
	@FindBy(xpath="//span[@aria-label='Next Month']")
	WebElement next;
	
	@FindBy(xpath="//div[@role='gridcell']")
	List<WebElement> dates;
	
	@FindBy(css = ".selectedTime")
	WebElement clickOnPickupTime;
 
	@FindBy(xpath = "//li[@class='hrSlotItemParent']")
	List<WebElement> hrs;
 
	@FindBy(xpath = "//li[@class='minSlotItemParent']")
	List<WebElement> mins;
	
	@FindBy(xpath="//li[@data-cy='MeridianSlots_82']")
	List<WebElement> meri;
 
	@FindBy(css = ".applyBtnText")
	WebElement apply;
	
	@FindBy(xpath= "//div[@class='makeFlex row']")
	List<WebElement> time;
	
	@FindBy(xpath= "//a[text()='Search']")
	WebElement search;
	
	@FindBy(xpath= "//div[@class='desktopOverlay_packagesModal___gngH']")
	WebElement popUp;
	
	@FindBy(xpath= "//img[@alt='Close']")
	WebElement closed;
	
	@FindBy(xpath= "//span[@class='filterSection_title__vHRpx']")
	List<WebElement> Cabtype;
	
	@FindBy(css= "span.cabDetailsCard_price__SHN6W")
	List<WebElement> price;
	
	public void Cab() {
		
			cabs.click();
	}

	public void currlocation(){
		
		currlocation.click();

		Boolean selected=false;
		for(WebElement city:dropdown) {
			String cityText=city.getText();
			if(cityText.equalsIgnoreCase(from)) {
				jse.executeScript("arguments[0].click()",city);
				selected=true;
				break;
			}
		}
		if(!selected) {
			cityName.clear();
			cityName.sendKeys(from);
			wait.until(driver -> {
				return dropdown.get(0).getText().toLowerCase().contains(from.toLowerCase());
				});
			System.out.println(dropdown.get(0).getText());
			jse.executeScript("arguments[0].click()",dropdown.get(0));
		}
	}
	
	public void destination(){
		
		jse.executeScript("arguments[0].click()",dest);
		

		destloc.sendKeys(to);

		wait.until(driver -> {
			return dropdown.get(0).getText().toLowerCase().contains(to.toLowerCase());
		});
		
		for(WebElement elem:dropdown) {
			String val=elem.getText();
			if(val.equalsIgnoreCase(destination)){
				jse.executeScript("arguments[0].click()",elem);
				break;
			}
		}
	}
	
	public void DateSelection(){
	    
		date.click();
	    
	    boolean dayVal = false;
	    while(!dayVal){
	    	
	        List<WebElement> months=month;
	        List<WebElement> Dates=dates;

	        for(WebElement mon:months){
	        	
	            String displayedMonthYear=mon.getText().toLowerCase();
	            if(displayedMonthYear.equalsIgnoreCase(travelMonth.toLowerCase())){
	                for(WebElement res:Dates){
	                    if(res.getDomAttribute("aria-label").equalsIgnoreCase(travelDate)){
	                        jse.executeScript("arguments[0].click()",res);
	                        dayVal=true;
	                        break;
	                    }
	                }
	            }
	        }
	        if(!dayVal){
	            jse.executeScript("arguments[0].click()",next);
	        }
	    }
	}

	
	public void time() {
				
		wait.until(ExpectedConditions.elementToBeClickable(clickOnPickupTime));
		jse.executeScript("arguments[0].click()",clickOnPickupTime);
	}
	
	public void timeSelection() {
		
		for(WebElement hr:hrs) {
			String text=hr.getText();
			if (text.equals(hours)) {
				hr.click();
				break;
			}
		}
 
		for(WebElement min:mins) {
			String text=min.getText();
			if (text.equals(minutes)) {
				min.click();
				break;
			}
		}
		
		for(WebElement mer:meri) {
			String text = mer.getText();
			if (text.equals(meridian)) {
				mer.click();
				break;
			}
		}
		
	}
	
	public void search() {
		apply.click();
		
		search.click();
	}
	
	public void PackagePopUp() {
		
		try{
			if(popUp.isDisplayed()) {
				closed.click();
			}
		}
		catch(Exception e) {}
	}
	
	public void CabType() {
		
		for(WebElement type:Cabtype) {
			if(type.getText().trim().equalsIgnoreCase(carType)) {
				jse.executeScript("arguments[0].click()",type);
				break;
			}
		}		
	}
	public void LowestCostCab() {
		
		List<WebElement> prices=price;
		wait.until(ExpectedConditions.visibilityOfAllElements(prices));
		
		int[] arr=new int[prices.size()];
		int i=0;
		
		for(WebElement price:prices) {
			String cost=price.getText();
			arr[i]=Integer.parseInt(cost.replaceAll("[^0-9]",""));
			i++;
		}
		Arrays.sort(arr);
		writer.writeToFile("LowestCost.json","Lowest Price for '"+carType+"': ",String.valueOf(arr[0]));
		System.out.println(arr[0]);
		
	}
}


