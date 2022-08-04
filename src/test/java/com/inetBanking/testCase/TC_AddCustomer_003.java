package com.inetBanking.testCase;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import com.inetBanking.pageObject.AddCustomer;
import com.inetBanking.pageObject.loginPage;

import junit.framework.Assert;

public class TC_AddCustomer_003 extends BaseClass{
	
	@Test
	public void addNewCust() throws InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		log.info("Driver is initialise");
		loginPage lp = new loginPage(driver);
		lp.setUserName(userName);
		log.info("User name is entered");
		lp.setPasswotd(password);
		log.info("Password is enterd");
		lp.clickLogin();
		
		AddCustomer addCust = new AddCustomer(driver);
		Thread.sleep(1000);
		addCust.clickNewCust();
	
		 wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("google_ads_iframe_/24132379/INTERSTITIAL_DemoGuru99_0"));
		 driver.switchTo().frame("ad_iframe");
		 driver.findElement(By.id("dismiss-button")).click();
		 driver.switchTo().defaultContent();
		 
		 Thread.sleep(2000);
		addCust.setCustName("Vinay");
		addCust.selectGender();
		addCust.setDOB("05", "15", "1990");
		Thread.sleep(2000);
		addCust.setAddress("shrigonda");
		addCust.setCity("Pune");
		addCust.setState("Maharastra");
		addCust.setPin(122345);
		addCust.setTele(1234567891);
		addCust.setEmail(randomString()+"@gmail.com");
		addCust.setPassword("abcdef");
		addCust.submit();
		 
		// wait.until(ExpectedConditions.alertIsPresent()).accept();
		
		Thread.sleep(3000);
		Assert.assertEquals(addCust.getHeading(), "Customer Registered Successfully!!!");
	
	}
}
