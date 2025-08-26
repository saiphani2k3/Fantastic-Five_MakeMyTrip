package com.MakeMyTrip.pages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.MakeMyTrip.Utilities.ConfigReader;
import com.MakeMyTrip.Utilities.ExcelUtil;
import com.MakeMyTrip.Utilities.JsonWriter;


public class InsurancePage extends BasePage {
	
	JsonWriter writer=new JsonWriter();
	
	String country;
	String plan;

	List<HashMap<String,String>> data=new ArrayList<>();
	
	public InsurancePage(WebDriver driver) throws IOException {
		super(driver); 
		ExcelUtil excel=new ExcelUtil();
		data=excel.data(ConfigReader.getProperty("test.data.file"),"Insurance");
		
		country=data.get(0).get("Country");
		plan=data.get(0).get("Plan");
		
    }
	
	@FindBy(xpath= "//span[@class='commonModal__close']")
	WebElement closePopup;
	
	@FindBy(xpath="//a[text()='Travel Insurance']")
	WebElement Insurance;

	@FindBy(xpath="//div[@data-test-id='PopularCountryComp-OtherCountyBtn']")
	WebElement countries;

	@FindBy(xpath="//div[@data-test-id='FlexComp-FlexCompStyle']/p[@data-test-id='ParaTag-ParaTagStyle']")
	List<WebElement> CountrySelection;
	
	@FindBy(xpath="//div[@data-test-id='TravelDateWiget-TravelDateWigetStyle']")
	WebElement dateSelection;
	
	@FindBy(xpath="//div[@class='rdp-caption']")
	List<WebElement> month;
	
	@FindBy(xpath="//button[@name='day']")
	List<WebElement> dates;
	
	@FindBy(xpath="//button[@name='next-month']")
	WebElement next;
	
	@FindBy(xpath="//span[text()='Add Destination']")
	WebElement submit;
	
	@FindBy(xpath="//div[@data-test-id='Tags-TagItem']")
	List<WebElement> plans;
	
	@FindBy(xpath="//span[text()='VIEW PLANS']")
	WebElement search;
	
	@FindBy(xpath="//span[text()='OKAY,GOT IT']")
	WebElement confirm;
	
	@FindBy(xpath = "//div[@data-test-id='InsurancePlansComp-InsuranceTypeSection']")
	public List<WebElement> planDetails;
 
	@FindBy(xpath = "//div[@data-test-id='InsurancePlansComp-InsurancePlanTypeHd']//span[@data-test-id='FormattedText']")
	public WebElement planName;
	
	@FindBy(css = "div[data-test-id='InsurancePlansComp-InsurancePlanSection']")
	public List<WebElement> cards;
	
	public void closePopUp() {

		closePopup.click();
	}
	
	public void insurance() {
		
		jse.executeScript("arguments[0].click()",Insurance);
	}
	
	public void country() {
		
		jse.executeScript("arguments[0].click()",countries);
		
		for(WebElement coun:CountrySelection) {
			String Country=coun.getText();
			if(Country.equalsIgnoreCase(country)) {
				coun.click();
				break;
			}
		}
	}
	
	public void submit() {
		
		jse.executeScript("arguments[0].click()",submit);
	}
	
	public void plans() {
		
		for(WebElement Insurplan :plans) {
			if(Insurplan.getText().equalsIgnoreCase(plan)) {
				jse.executeScript("arguments[0].click()",Insurplan);
				break;
			}
		}
	}
	
	public void search() {
		
		jse.executeScript("arguments[0].click()",search);
	}
	
	public void confirm() {
		
		jse.executeScript("arguments[0].click()",confirm);
	}
	
	public boolean Page() {
		
		return driver.getTitle().contains("Insurance Policy");
	}
	
	public void deatils() {
		
		String name = planName.getText().trim();
		System.out.println("Insurance Provider:" + " " + name);
		
		writer.writeToFile(name, name, name);
		
 
		for (WebElement info : planDetails) {
			String details = info.getText().trim();
			System.out.println("Price Details:" + " " + details);
			writer.writeToFile("InsurancePage.json","Plan details with provider: ",name+" "+details);
		}
	}
}
