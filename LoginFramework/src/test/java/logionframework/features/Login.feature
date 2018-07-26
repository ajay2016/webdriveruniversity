Feature: Login into user account using login portal

Background:
	Given User access webdriverunivesity website
	When User clicks on Login Portal link
	And User enters a username

Scenario: Login to account with a valid password
	And User enters a "valid" password
	When User clicks on the Login button
	Then User should be presented with a successful validation alert

Scenario: Login to account with a invalid password
	And User enters a "invalid" password
	When User clicks on the Login button
	Then User should be presented with a unsuccessful validation alert 