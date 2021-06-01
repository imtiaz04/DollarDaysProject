package com.DollarDays.TestCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.DollarDays.PageObject.LoginPage;
import com.DollarDays.utilities.ExcelDataDriven;

public class TC_LoginDDT_002 extends BaseClass {

		@Test(priority=0,dataProvider="LoginData")
	public void loginDDT(String user,String pwd) throws InterruptedException, IOException {

		LoginPage lp=new  LoginPage(driver);//create object for lp
		String hometitle="DollarDays | Bulk Goods for Nonprofits, Businesses & Schools | Wholesale Products";
		//driver.get( baseURL);
		//logger.info("open url");
		

		lp.setsignin();
		logger.info("Clicking signin button");
		Thread.sleep(1000);		 
		lp.setDDsignin();
		logger.info("Clicking DDsignin button");
		Thread.sleep(1000);
		lp.setemail(user);
		logger.info("entering  username ");
		Thread.sleep(2000);
		lp.setpassword(pwd);
		logger.info("entering password ");
		Thread.sleep(1000);
		lp.ClickSignin();
		logger.info("clicking signin button");	 
		Thread.sleep(1000);
		
		logger.info("Before Calling screenshot");
		captureScreen(driver,"LoginDDT");
		logger.info("screenshot taken");

		String Actual=	driver.getTitle();	

		Assert.assertEquals(Actual,hometitle,"You are at register page");
		logger.info("test fail");

	    Assert.assertTrue(true);
		logger.info("you successfully logged-in");

		lp.ClickIcon();
		logger.info("clicking the image after signin");
		lp.ClickSinout();
		logger.info("successfully log out");

		Assert.assertEquals(Actual,hometitle);
		logger.info("your test is passed");


	}
	@DataProvider(name="LoginData")
	Object[][]getData() throws IOException{
		String path=System.getProperty("user.dir")+"/src/test/java/com/DollarDays/TestData/Data1.xlsx";
		int rownum= ExcelDataDriven.getRowCount(path, "sheet1");
		int columcount=ExcelDataDriven.getCellCount(path, "sheet1", 1);

		Object loginData[][]=new String[rownum][columcount];

		for(int i=1;i<=rownum;i++) {
			for(int j=0;j<columcount;j++) {
				loginData[i-1][j]=ExcelDataDriven.getCellData(path, "sheet1",i,j );
			}
		}
		return loginData;
	}
	@Test(priority=1)
	public void txtForgot() throws InterruptedException {
		LoginPage lp=new  LoginPage(driver);//create object for lp

		

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
/*	if(lp.alert.isDisplayed()==true) {
			//driver.switchTo().alert().accept();//close alert	
			logger.info("test fail");
			 logger.info("Before Calling screenshot");
				captureScreen(driver,"LoginDDT");
			Assert.assertTrue(true);	// using this one for to break if loop,after this line if u give also nothing will print				

		}
		else{
			System.out.println("@else");

			System.out.println("Before Checking srikanth");
			driver.getPageSource().contains("srikanth s.");
			System.out.println("test pass");
			//driver.getPageSource().contains("DollarDays | Bulk Goods for Nonprofits, Businesses & Schools | Wholesale Products");
			//driver.getTitle();
			logger.info("test pass");
			//driver.switchTo().defaultContent();	
			Assert.assertTrue(false);
		}		*/

/*if(lp.alert.isDisplayed()==true) {
			driver.switchTo().defaultContent();	//Madh code
			captureScreen(driver,"LogininDDT");
			logger.warn("Login failed");
			Assert.assertTrue(false);
		}
		else {
			Assert.assertTrue(true);
			logger.info("Login passed");

	}*/
//lp.ClickForgotlink();
//	logger.info("clicking on forgotLink");
//if(lp.alert.isDisplayed()==true) {
//logger.info("failed case");
//Assert.assertTrue(false);

//}else {
//	logger.info("pass");
//}

//user define method to check alert present or not 
/*	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();//if alert present
			return true;
		}catch (NoAlertPresentException e) {
			return false;			
		}	*	
	}*/


