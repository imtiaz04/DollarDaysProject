package com.DollarDays.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting extends TestListenerAdapter {
	//public WebDriver driver;
	public ExtentSparkReporter  reporter;//create 
	public ExtentReports    extent;
	public ExtentTest  test;

	public void onStart(ITestContext testContext) {

		String timeStamp=new SimpleDateFormat("yyyy.MM.HH.mm.ss").format(new Date());
		String repName="Test-Report-"+timeStamp+".html";

		reporter=new  ExtentSparkReporter(System.getProperty("user.dir")+"/testoutput/"+repName);		

		try {
			reporter.loadXMLConfig(System.getProperty("user.dir")+"/extent-Config.xml");
		} catch (IOException e) {

			e.printStackTrace();
		}


		extent=new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("HostName","LocalHost");
		extent.setSystemInfo("Environment","QA");
		extent.setSystemInfo("TesterName","Imtiaz");


		reporter.config().setDocumentTitle("DD Project");//title of the report
		reporter.config().setReportName("Functional report");//Name of the report	
		reporter.config().setTheme(Theme.DARK);		
	}

	public void onTestSuccess(ITestResult tr) {
		test=extent.createTest(tr.getName());
		test.log(Status.PASS,MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));	
	}

	public void onTestFailure(ITestResult result) {

		test=extent.createTest(result.getName());
		test.log(Status.FAIL,MarkupHelper.createLabel(result.getName(), ExtentColor.RED));

		String screenshotpath=System.getProperty("user.dir")+"//Screenshots//"+result.getName()+".png";//path for screenshots 
		test.addScreenCaptureFromPath(screenshotpath) ;//adding screenshot

	
		}
	
	public void onTestSkipped(ITestResult tr) {
		test=extent.createTest(tr.getName());
		test.log(Status.SKIP,MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));
	}
	public void onFinish(ITestContext testcontext) {

		extent.flush();
	}
}

/*if(f.exists())
			{
				test.fail("screenshot is below:"+ test.addScreenCaptureFromPath(screenshotpath));//
				System.out.println("entering loop");
			}
			}


			//File f=new File(screenshotpath);
		//	System.out.println("Before if loop");			
			//if(f.exists()) {
				//System.out.println("Inside loope");
				//test.fail("screenshot is below: "+test.addScreenCaptureFromPath(screenshotpath));
			//	System.out.println("adding meessage");
			//}

	
			

}		/*public static String getscreenshot(WebDriver driver,String screenshotName) throws IOException  {
			String dateName=new SimpleDateFormat("yyyyMMDDmmss").format(new Date());
			TakesScreenshot ts=(TakesScreenshot) driver;
			File source=ts.getScreenshotAs(OutputType.FILE);
				String destination=System.getProperty("user.dir"+"/Screenshots/"+screenshotName+dateName+".png");
				File  finaldestination=new File(destination);
				FileUtils.copyFile(source, finaldestination);
				return destination;

		}*/
/*public  void captureScreen(WebDriver driver,String tname) throws IOException {
			 TakesScreenshot ts= (TakesScreenshot) driver;

			 File source = ts.getScreenshotAs(OutputType.FILE);
			 File target = new File(System.getProperty("user.dir")+ "/Screenshots/" + tname + ".png");

			 FileUtils.copyFile(source, target.getAbsoluteFile());
			 System.out.println("Screenshot taken");

			 }*/





