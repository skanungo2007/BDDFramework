package com.qa.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.BaseClass;

public class LoginClass extends BaseClass {
	
	@FindBy(xpath="//*[contains(text(),'Manger Id')]")
	WebElement mID;
	
	
	@FindBy(linkText="New Account")
	WebElement account;
	
	
	public LoginClass(WebDriver driver) {
		
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
		
	}
	
	
	public void getID() {
		
		System.out.println(mID.getText());
		
	}
	
	public void createAccount() throws InterruptedException {
		
		account.click();
		
		Thread.sleep(1000);
	}


}
