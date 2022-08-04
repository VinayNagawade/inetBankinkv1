package com.inetBanking.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCustomer {

	public WebDriver driver;
	
	public AddCustomer(WebDriver rdriver) {
		
		driver = rdriver;
	    PageFactory.initElements(rdriver, this);
	}
	


	@FindBy(xpath="//a[contains(text(),'New Customer')]")
	@CacheLookup
	WebElement newCust;
	
	public WebElement newCuctomer() {
		return newCust;   
		
	   }
	
	@FindBy(name="name")
	@CacheLookup
	WebElement custName;
	
	@FindBy(name="rad1")
	@CacheLookup
	WebElement gender;
	
	@FindBy(name="dob")
	@CacheLookup
	WebElement BirthDate;
	
	@FindBy(name="addr")
	@CacheLookup
	WebElement address;
	
	@FindBy(name="city")
	@CacheLookup
	WebElement city;
	
	@FindBy(name="state")
	@CacheLookup
	WebElement state;
	
	@FindBy(name="pinno")
	@CacheLookup
	WebElement pinNO;
	
	@FindBy(name="telephoneno")
	@CacheLookup
	WebElement teleNO;
	
	@FindBy(name="emailid")
	@CacheLookup
	WebElement emailId;
	
	@FindBy(name="password")
	@CacheLookup
	WebElement password;
	
	@FindBy(name="sub")
	@CacheLookup
	WebElement submit;
	
	@FindBy(css=".heading3")
	@CacheLookup
	WebElement custHeading;
	
	public void clickNewCust() {  
		newCust.click();
	   }
	
	public void setCustName(String cName) {  
		custName.sendKeys(cName);
	   }
	
	public void selectGender() {  
		gender.click();
	   }
	
	public void setDOB(String mm,String dd, String yy) {  
		BirthDate.sendKeys(mm);
		BirthDate.sendKeys(dd);
		BirthDate.sendKeys(yy);
	   }
	
	public void setAddress(String add) {  
		address.sendKeys(add);
	   }
	
	public void setCity(String cName) {  
		city.sendKeys(cName);
	   }
	
	public void setState(String sName) {  
		state.sendKeys(sName);
	   }
	
	public void setPin(int string) {  
		pinNO.sendKeys(String.valueOf(string));
	   }
	
	public void setTele(int tele) {  
		teleNO.sendKeys(String.valueOf(tele));
	   }
	
	public void setEmail(String email) {  
		emailId.sendKeys(email);
	   }
	
	public void setPassword(String pass) {  
		password.sendKeys(pass);
	   }
	
	public void submit() {  
		submit.click();
	   }
	
	public String getHeading() {  
		return custHeading.getText();
	   }
}
