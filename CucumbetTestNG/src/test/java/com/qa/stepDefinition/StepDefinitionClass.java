package com.qa.stepDefinition;

import java.io.IOException;
import java.util.List;
import com.qa.base.BaseClass;
import com.qa.page.AccountClass;
import com.qa.page.HomeClass;
import com.qa.page.LoginClass;
import com.qa.util.HelperClass;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;



public class StepDefinitionClass extends BaseClass {

	HomeClass home = new HomeClass(driver);
	LoginClass login = new LoginClass(driver);
	AccountClass account = new AccountClass(driver);
	
	@Given("^User is on HomePage Bank$")
	public void user_is_on_HomePage_Bank() throws Throwable {
	   
		
		BaseClass.initialize();
		
	}

	@When("^User verifies title of the bank page$")
	public void user_verifies_title_of_the_bank_page() {
		
		home = new HomeClass(driver);
		home.verifyPage();
		
	}

	@Then("^User login with credentials$")
	public void user_login_with_credentials() throws InterruptedException, IOException {
	   
		home = new HomeClass(driver);
		String uname = HelperClass.readProperty("username");
		String pwd = HelperClass.readProperty("password");
		
		
		home.profileLogin(uname, pwd);
			
		
	}

	
	@And("^User verifies Profile ID displayed$")
	public void user_verifies_Profile_ID_displayed() throws Throwable {
	    
		login = new LoginClass(driver);
		login.getID();
	}

	
	
	
	@Then("^User then Navigates to Account Creation page$")
	public void user_navigates_account_page() throws InterruptedException {
	
		login = new LoginClass(driver);
		login.createAccount();
	
	}
	
	
	

	@Then("^User fills up all the details required$")
	public void user_fills_up_all_the_details_required(DataTable actdata) throws Throwable {
	    
		account = new AccountClass(driver);
		
		List<List<String>> actVal = actdata.raw();
		
		account.fillDetails(actVal.get(0).get(0), actVal.get(0).get(1), actVal.get(0).get(2));
	
	}

	
	
	
	@Then("^User clicks Logout option$")
	public void user_clicks_Logout_option() throws InterruptedException {
	   
		account = new AccountClass(driver);
		account.LogOut();
		
	}

	

	@Then("^Close the browser and exit$")
	public void close_the_browser_and_exit() {
	   
		BaseClass.closeBrowser();
	}

}
