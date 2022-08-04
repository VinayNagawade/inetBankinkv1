package com.inetBanking.testCase;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetBanking.utility.ReadConfig;



public class BaseClass {

	ReadConfig readConfig = new ReadConfig();
	
	public String baseURL = readConfig.getBaseUrl();
	public String userName = readConfig.getUserName();
	public String password = readConfig.getPassword();
	public static WebDriver driver;
	public static Logger log;
	
	
	@Parameters("browser")
	@BeforeClass
	public void setUp(String br) {
		
		log = LogManager.getLogger(BaseClass.class.getName());
		
		if (br.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", readConfig.getChromeDriver());
			driver = new ChromeDriver();
		}
		else if (br.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver",readConfig.getFirefoxDriver());
	        driver = new FirefoxDriver();
		}
		else if (br.equals("ie")) {
			
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(baseURL);
		
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
   public String takeScreenShotPath(String testCaseName,WebDriver driver) throws IOException {
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"\\ScreenShot\\"+testCaseName+".png";
		FileUtils.copyFile(source, new File(destinationFile));
		return destinationFile;
	}
   
   public String randomString() {
	   
	   String generatedString = RandomStringUtils.randomAlphabetic(8);
	   return generatedString;
   }
   
 public String randomNum() {
	   
	   String generatedString = RandomStringUtils.randomAlphanumeric(5);
	   return generatedString;
   }
}
