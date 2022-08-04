package com.inetBanking.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage {

	
	public WebDriver driver;
	
	public loginPage(WebDriver rdriver) {
		
		driver = rdriver;
	    PageFactory.initElements(rdriver, this);
	}
	
	
	
	@FindBy(name="uid")
	@CacheLookup
	WebElement txtUserName;
	
	@FindBy(name="password")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy(name="btnLogin")
	@CacheLookup
	WebElement btnLogin;

	@FindBy(xpath="//a[contains(text(),'Log out')]")
	@CacheLookup
	WebElement logOut;
  
	
	public void setUserName(String name) {
		
		txtUserName.sendKeys(name);
	}
	
   public void setPasswotd(String password) {
		
		txtPassword.sendKeys(password);
	}
   
   public void clickLogin() {
	   
	   btnLogin.click();
   }
   
 public void clickLogOut() {
	   
	 logOut.click();
   }
 
 public WebElement logOut() {
	return logOut;   
	
   }
	
}
