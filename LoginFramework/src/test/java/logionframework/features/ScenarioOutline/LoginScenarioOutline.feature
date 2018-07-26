Feature: Login to account

Scenario Outline: Login to account with credentials
	Given  User navigates to "<url>"
	When  User clicks on login-portal link 
	And  User enters the "<username>" username 
	And  User enters the "<password>" password
	When Click on the login button          
	      
	Then  User should be presented with the following alert "<message>"
	
	#Five scenarios to be tested 
	
	Examples:
		|url									|username			|password			|message		  	|
		|http://www.webdriveruniversity.com		|user1				|pass1				|validation failed	|
		|http://www.webdriveruniversity.com		|webdriver			|webdriver123		|validation succeed	|  
		|http://www.webdriveruniversity.com		|webrive			|webdriver123	    |validation failed	|
		|http://www.webdriveruniversity.com		|webdriver			|webdriver1 		|validation failed	|  
		|http://www.webdriveruniversity.com		|				    |				    |validation failed	|
		