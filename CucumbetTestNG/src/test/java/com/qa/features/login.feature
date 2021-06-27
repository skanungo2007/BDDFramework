Feature: BDD Framework Demonstration

	@Smoke
	Scenario: Valid Login
	
	Given User is on HomePage Bank
	When User verifies title of the bank page
	Then User login with credentials
	And User verifies Profile ID displayed
	Then User then Navigates to Account Creation page
	And User fills up all the details required
	|	29840	|	Savings		|	2226	|
	Then User clicks Logout option
	And Close the browser and exit