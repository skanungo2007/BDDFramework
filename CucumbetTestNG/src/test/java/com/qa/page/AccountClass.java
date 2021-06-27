package com.qa.page;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.base.BaseClass;

public class AccountClass extends BaseClass {

	
	
	@FindBy(css="input[name='cusid']")
	WebElement custID;
	
	@FindBy(xpath="//input[@name='inideposit']")
	WebElement deposit;
	
	@FindBy(how=How.NAME, using="button2")
	WebElement submit;
	
	@FindBy(name="selaccount")
	WebElement acntType;
	
	
	@FindBy(linkText="Home")
	WebElement home;
	
	@FindBy(linkText="Log out")
	WebElement logOut;
	
	@FindBy(xpath="//table[@id='account']/tbody")
	WebElement values;
	
	
	
	
	public AccountClass(WebDriver driver) {
		
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
		
	}

	
	
	
	
	public void fillDetails(String id, String type, String amount) throws InterruptedException {
		
		custID.sendKeys(id);
		
		
		Select dropdown = new Select(acntType);
		dropdown.selectByVisibleText(type);
		
		deposit.sendKeys(amount);
		
		submit.click();
		
		Thread.sleep(500);
		
		System.out.println(values.getText());
		
	}
	
	
	
	
	public void LogOut() throws InterruptedException {
		
		home.click();
		
		Thread.sleep(500);
		
		logOut.click();
		
		Thread.sleep(500);
		
		Alert alert = driver.switchTo().alert();
		
		System.out.println();
		
		System.out.println(alert.getText());
		
		alert.accept();
		
		Thread.sleep(2000);
	
		
	}
	
}
