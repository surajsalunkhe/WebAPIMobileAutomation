@sanity
Feature: Login
In order to perform sucessful login
As a user
I want to enter correct username and password

Scenario Outline: In order to verify login to facebook
		Given user navigates to facebook website
		When user validates the homepage title
		Then user entered "<username>" username
		And user entered "<password>" password
		And user selected the Age Group
		| Age 		 | Location|
		| above 18 | India	 |
		| below 18 | USA		 |
		Then user "<Logintype>" sucessfully logged in
		
Examples:
|username | password | Logintype|
|valid		|valid		 |	should	|
|invalid	|invalid	 |shouldnot	|
