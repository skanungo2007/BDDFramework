package com.qa.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.BaseClass;

import junit.framework.Assert;

public class HomeClass extends BaseClass {
	
	@FindBy(name="uid")
	@CacheLookup
	WebElement userID;
	
	@FindBy(name="password")
	@CacheLookup
	WebElement pass;
	
	
	@FindBy(xpath="//h2")
	WebElement banner;
	
	@FindBy(css="input[type='submit']")
	WebElement loginBtn;
	
	
	
	public HomeClass(WebDriver driver) {
		
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
		
	}

	
	
	public void verifyPage() {
		
		String title = "Guru99 Bank Home Page";
		
		System.out.println("Page URL: " + driver.getCurrentUrl());
		
		Assert.assertEquals(title, driver.getTitle());
		
		System.out.println("Banner Text: " + banner.getText());
		
		System.out.println();
		
	}
	
	
	public void profileLogin(String uname, String pwd) throws InterruptedException {
		
		userID.sendKeys(uname);
		pass.sendKeys(pwd);
		
		userID.click();
		loginBtn.click();
		
		Thread.sleep(1000);
		
	}
}