package com.inetBanking.testCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObject.loginPage;



public class TC_LoginPage_001 extends BaseClass{

	
	@Test
	public void loginTest() throws InterruptedException {
		
		
		log.info("Driver is initialise");
		loginPage lp = new loginPage(driver);
		lp.setUserName(userName);
		log.info("User name is entered");
		lp.setPasswotd(password);
		log.info("Password is enterd");
		lp.clickLogin();
		
		Assert.assertEquals(driver.getTitle(), "Guru99 Bank Manager HomePage");
		log.info("Titel is verify");
		
		
		
		
	}

}
