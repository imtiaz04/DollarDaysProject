
package com.DollarDays.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	 public WebDriver driver;
	 public LoginPage (WebDriver driver) {
		
		PageFactory.initElements(driver,this);
		this.driver=driver;
	}
	@FindBy(xpath="//*[@id=\"aspnetForm\"]/header/div/div/div/div[3]/div/ul/li[1]/a/img")
	WebElement signin;
	public void setsignin() {
		signin.click();
	}
	
	@FindBy(xpath="//*[@id=\"aspnetForm\"]/header/div/div/div/div[3]/div/ul/li[1]/ul/li[2]/a")
	WebElement DDsignin;//dropdown
	public void setDDsignin() {
		DDsignin.click();
	}
	
	@FindBy(id="inputLoginUsername")
	WebElement email;
	public void setemail(String uname) {
		email.sendKeys(uname);
		
	}
	@FindBy(name="password")
	WebElement password;
	public void setpassword(String pwd) {
		password.sendKeys(pwd);		
	}
	@FindBy(xpath="//*[@id=\"aspnetForm\"]/div[5]/div/div/div/div[2]/div/div[1]/div/div/div[4]/button")
	WebElement Tosignin;
	public void ClickSignin() {
		Tosignin.click();
	}
	@FindBy(xpath="//a[contains(text(),'Forgot your email address or password?')]")
	WebElement ForgotLink;
	public void ClickForgotlink() {
		ForgotLink.click();
	}
	@FindBy(xpath="//*[@id=\"ctl00_cphContent_txtEmailAddress\"]")
	WebElement emailAddress;
	public void LinkAddress() {
		 emailAddress.sendKeys("1234");
	}
	@FindBy(xpath="//input[@id='ctl00_cphContent_btnSearch']")
	WebElement Lookup;
	public void look() {
		Lookup.click();
	}
	@FindBy(xpath="//*[@id=\"div_msgsent\"]/div/div[1]")
	 public WebElement AlertText;
	
	@FindBy(xpath="//*[@id=\"aspnetForm\"]/header/div[2]/div/div/div[3]/div/ul/li[1]/ul/li[12]/a")
	WebElement signout;
	public void ClickSinout() {
		signout.click();
	}
	@FindBy(xpath="//*[@id=\"aspnetForm\"]/div[5]/div/div/div/div[1]/div/div/div/strong")
	public WebElement alert;
	
	
	@FindBy(xpath="//*[@id='aspnetForm']/header/div[2]/div/div/div[3]/div/ul/li[1]/a/span")
	public WebElement SigninIcon;
	
	public void ClickIcon() {
		SigninIcon.click();
	
}	
	
	

}
