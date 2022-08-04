package com.inetBanking.testCase;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.inetBanking.pageObject.loginPage;
import com.inetBanking.utility.XelUtil;

public class TC_LoginPageDDT_002 extends BaseClass {

	@Test(dataProvider = "LoginData")
	public void  loginDDT(String userName , String password ) throws InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		loginPage lp = new loginPage(driver);
		lp.setUserName(userName);
		log.info("User name is entered");
		lp.setPasswotd(password);
		log.info("Password is entered");
		lp.clickLogin();
		
		if(isAlertPresent()==true) {
			 Thread.sleep(2000);
			 wait.until(ExpectedConditions.alertIsPresent());
			 driver.switchTo().alert().accept();
			Assert.assertTrue(false);
	
		}else {
			Assert.assertTrue(true);
			log.info("Login pass");
			Thread.sleep(1000);
			wait.until(ExpectedConditions.elementToBeClickable(lp.logOut()));
			lp.clickLogOut();
			Thread.sleep(1000);
		    wait.until(ExpectedConditions.alertIsPresent()).accept();
			
		}
	}
	
	public boolean isAlertPresent() {
	
		try {
			driver.switchTo().alert();
			return true;
		}
		catch(Exception e){
			
			return false;
		}
	}

	@DataProvider(name = "LoginData")
	public Object[][] getData() throws IOException {
		
		String path = System.getProperty("user.dir")+"/src/test/java/com/inetBanking/testData/inetProjData.xlsx";
		XelUtil d = new XelUtil();
		int rowCount =  d.getRowCount(path);
		int colCount = d.getColoum(path);
		Object a[][]= new Object[rowCount][colCount];
		a =d.getData(path);
		return a;
		
	}
	
}
