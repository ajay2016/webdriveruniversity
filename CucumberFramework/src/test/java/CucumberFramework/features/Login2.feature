Feature: Login into Account
Existing Stackoverflow user should be able to login into
account with correct credentials

Scenario: Login into the account with correct details2
	Given User navigates to stackoverflow website2
	And User clicks on the login button on homepage2
	And User enters a valid username2
	And User enters a valid password2
	When User clicks on the login button2
	Then User should be taken to the successful login page2 
 