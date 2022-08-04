package com.inetBanking.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {

	
	Properties prop;
	
	public ReadConfig()  {
		
		FileInputStream fil;
		try {
			fil = new FileInputStream("./Configuration\\config.properties");
			prop = new Properties();
				prop.load(fil);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
	}
	
	public String getBaseUrl() {
	   String url = prop.getProperty("baseURL");
	   return url;
	}
	
	public String getUserName() {
		   String userName = prop.getProperty("userName");
		   return userName;
		}
	
	public String getPassword() {
		   String password = prop.getProperty("password");
		   return password;
		}
		
	public String getChromeDriver() {
		   String driver = prop.getProperty("chrome");
		   return driver;
		}
	
	public String getFirefoxDriver() {
		   String driver = prop.getProperty("firefox");
		   return driver;
		}
}
