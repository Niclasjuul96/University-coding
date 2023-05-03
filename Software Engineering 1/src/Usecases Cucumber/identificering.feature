Feature: Login Feature, This feature deals with functionality of the application. 

Scenario: Existing user logging in
	Given That the User is not logged in
	Then The User login succeeds
	And The User is logged in

Scenario: New user logging in
	Given The user do not exist
    And Username has 4 or less characters
	Then Creating the new user
	And The User is logged in

