package com.DollarDays.TestCases;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.DollarDays.utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	 ReadConfig readconfig=new  ReadConfig();
	public String baseURL=readconfig.getApplicationURL();
	
	public String username=readconfig. getusername();
	public String password=readconfig.getpassword();
	public Logger logger;
	
	WebDriver driver;
	@Parameters({"browser"})
	@BeforeMethod
	public void setup(@Optional("chrome") String br) {
		logger=LogManager.getLogger(BaseClass.class);		
		//logger=LogManager.getLogger("Imtiaz");
		
		if (br.equals("chrome")) {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		
		}
		else if(br.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			
			driver=new FirefoxDriver();			
		}
		else if(br.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}		
		driver.get( baseURL);
		logger.info("open url");
		driver.findElement(By.xpath("//*[@id=\"aspnetForm\"]/footer/div[3]/div/p/input")).click();
		driver.manage().deleteAllCookies();
				
	}
	
	
	public  void captureScreen(WebDriver driver,String tname) throws IOException {
		 TakesScreenshot ts= (TakesScreenshot) driver;
		 
		 File source = ts.getScreenshotAs(OutputType.FILE);
		 File target = new File(System.getProperty("user.dir")+ "/Screenshots/" + tname + ".png");
		
		 FileUtils.copyFile(source, target);
		 System.out.println("Screenshot taken");
		
		 }
	@AfterMethod
	public void tearDown() {
		driver.close();
		logger.info("driver closing");
		driver.quit();
		logger.info("driver quitting");
	}
}
