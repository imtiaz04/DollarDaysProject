package com.DollarDays.TestCases;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.DollarDays.PageObject.PopUpPage;

public class TC_PopUp_002 extends BaseClass {
	
	@Test
	public void PopUptest() throws InterruptedException {
		PopUpPage pp=new PopUpPage(driver);
		
		//driver.get(baseURL);
		pp.setsignin();
		logger.info("clicking sign in button");
		pp.setDDsignin();
		logger.info("Clicking the dropdown");
		pp.setemail(" srikanthtesting100@gmail.com");
		driver.manage().timeouts().implicitlyWait(3,TimeUnit.MICROSECONDS);
		logger.info("sending email values" );
		pp.setpassword("password123");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.MICROSECONDS);
		logger.info("sending password values");
		pp.ClickSignin();
		logger.info("clicking the signin button");
		pp.mask();
		logger.info("selecting the mask box");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.MICROSECONDS);
		pp.sbox();
		logger.info("clearing previous contents");
		pp.SBox1();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.MICROSECONDS);
		logger.info("entering values in search box");
		//driver.manage().timeouts().implicitlyWait(15,TimeUnit.MICROSECONDS);
		pp.ACButton();
		Thread.sleep(2000);
		logger.info("Clicking addCart button");
		
		
		String expected=pp.Message1();
		System.out.println(expected);
		Assert.assertEquals( expected,"you've exceeded the number of available units. Please revise your quantity or call 877-837-9569.");
		logger.info("Test Pass");		
		
	}	

	
	
	}
	


