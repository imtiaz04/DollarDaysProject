package com.DollarDays.TestCases;

import java.util.concurrent.TimeUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.DollarDays.PageObject.WishListPage;

public class WishListIconTC_002 extends BaseClass {
	WishListPage wlp=new  WishListPage (driver);
	@Test(priority=1)
	public void WishListTC_002() {
		
		WishListPage wlp=new  WishListPage (driver);
		
		//driver.get(baseURL);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.MILLISECONDS);
		logger.info("entering the url");
		wlp.DDButton();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.MILLISECONDS);
		logger.info("Clicking Drop Down");
		wlp.ClickLM();
	String WishListTitle=driver.getTitle();	
	System.out.println(WishListTitle);

		if(WishListTitle.equals("Wishlist")) {
			
		logger.info("Test Pass");

	}else { 
			logger.info("Test Failed");
	}		
		
	}
	@Test(priority=0)
	public void  WishListTC_001() {
		
       WishListPage wlp=new  WishListPage (driver);
		
		driver.get(baseURL);
		
		if(wlp.wishlistIcon.isDisplayed()==true) {
			Assert.assertTrue(true);
			logger.info("Testcase pass");
		}else{
			logger.info("Testcase fail");
			Assert.assertTrue(false);
		}
		
	}
	public boolean CheckingIcon() {
		try {
		wlp.wishlistIcon.isDisplayed();
		return true;
		}catch (Exception e) {
		return false;
		}
	}
	
}
