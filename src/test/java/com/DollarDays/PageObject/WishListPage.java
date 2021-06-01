package com.DollarDays.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WishListPage {
	WebDriver driver;
	public WishListPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
		this.driver=driver;		
	}
	@FindBy(xpath="//span[contains(text(),'Wishlist')]")
	 public WebElement wishlistIcon;
	
	
	
	@FindBy(xpath="//*[@id=\"aspnetForm\"]/header/div[2]/div/div/div[3]/div/ul/li[2]/a/i")
	WebElement DropDownButton;
	public void DDButton() {
		DropDownButton.click();
	}
	@FindBy(xpath="//*[@id=\"aspnetForm\"]/header/div[2]/div/div/div[3]/div/ul/li[2]/ul/li[2]/a" )
	 public WebElement LearnMore;
	public void ClickLM() {
		LearnMore.click();
	}
	
	

}
