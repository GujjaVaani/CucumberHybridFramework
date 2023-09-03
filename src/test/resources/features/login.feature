@login
Feature: User Login
Registered usershould be able to login to access account details

Scenario Outline:
Login with valid Credentials
Given User has navigated to login page
When User enter valid email address <userName> into email field
And User has entered valid password <password> into password field.
And Click on Continue button
Then User should get successfully logged in
Examples:
|userName              |password|
|amotooricap1@gmail.com|12345   |
|amotooricap2@gmail.com|12345   |
|amotooricap3@gmail.com|12345   |


Scenario: Login with invalid Credentials
Given User has navigated to login page
When User enter invalid email address into email field
And User has entered invalid password "1239045" into password field.
And Click on Continue button
Then User should get getproper warning message about credentials mismatch.

Scenario: Login with valid email and invalid password
Given User has navigated to login page
When User enter valid email address amotooricap9@gmail.com into email field
And User has entered invalid password "1902345" into password field.
And Click on Continue button
Then User should get getproper warning message about credentials mismatch.


Scenario: Login with invalid email and valid password
Given User has navigated to login page
When User enter invalid email address into email field
And User has entered valid password "12345" into password field.
And Click on Continue button
Then User should get getproper warning message about credentials mismatch.



Scenario: Login without providing credentials
Given User has navigated to login page
When User dont enter email address into email field
And User dont enter valid password into password field.
And Click on Continue button
Then User should get getproper warning message about credentials mismatch.
