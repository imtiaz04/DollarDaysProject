package com.DollarDays.TestCases;

import java.io.IOException;
import org.testng.annotations.Test;
import com.DollarDays.PageObject.LoginPage;

public class LoginTC_DD07 extends BaseClass {
	

@Test	
public void LoginTest() throws IOException, InterruptedException {
	
	 LoginPage lp=new  LoginPage(driver); //create object for lp

		driver.get( baseURL);
		logger.info("open url");

		lp.setsignin();
		logger.info("Clicking signin button");
		Thread.sleep(1000);		 
		lp.setDDsignin();
		logger.info("Clicking DDsignin button");
		Thread.sleep(1000);				
		lp.ClickForgotlink();
		logger.info("clicking forgot Link");
		lp.LinkAddress();
		logger.info("entered  values in to email address");
		lp.look();
		if(driver.getTitle().equals("Forgotten Password Recovery - DollarDays")) {
			logger.info("Test Pass");

		}else { 
			logger.info("Test Failed");
		}
	}
	 
	
}




