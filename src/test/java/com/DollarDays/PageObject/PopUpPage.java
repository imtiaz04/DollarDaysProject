package com.DollarDays.PageObject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PopUpPage {
	WebDriver driver;
	public PopUpPage(WebDriver driver) {
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
	@FindBy(xpath="//body/form[@id='aspnetForm']/div[5]/div[2]/div[1]/div[1]/div[1]/div[1]/a[1]/figure[1]/img[1]")
	WebElement premiumFaceMask;
	public void mask() {
		premiumFaceMask.click();
	}
	@FindBy(name="picquantity")
	WebElement SearchBox;
	public void sbox() {
		 SearchBox.clear();
	}

   
	@FindBy(name="picquantity")
	WebElement SearchBox1;
	public void SBox1() {
		SearchBox1.sendKeys("420");
	}
	@FindBy(xpath="//*[@id=\"ctl00_cphContent_divProductInfo\"]/div[2]/div/div/div[2]/div[1]/div[1]/div/div[2]/div/div[1]/div/div[2]/button")
	WebElement AddCartButton;
	public void ACButton() {
		AddCartButton.sendKeys(Keys.RETURN);
	}
		
		@FindBy(xpath="/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[1]")
		WebElement Message;
		public String Message1() {
			String msg= Message.getText();
			return msg;
		}
		
}
