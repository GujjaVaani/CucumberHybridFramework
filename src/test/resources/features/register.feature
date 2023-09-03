@register
Feature: Register account
User has to register if user wants to login

Scenario: User creates an account only with mandatory field
Given User navigates to Register Account page
When User enters the below fields
|firstName |Arun                  | 
|lastName  |Motoorti              |
|telephone |123457899             |
|password  |12345                 |
And user selects privacy policy field
And User clicks on Continue button
Then User account should get created successfully

Scenario: User creates an account with all fields
Given User navigates to Register Account page
When User enters the below fields
|firstName |Arun                  | 
|lastName  |Motoorti              |
|telephone |123457899             |
|password  |12345                 |
And user selects privacy policy field
And user select yes for newsletter
And User clicks on Continue button
Then User account should get created successfully

Scenario: User creates an duplicate account.
Given User navigates to Register Account page
When User enters the duplicate below fields
|firstName |Arun                      | 
|lastName  |Motoorti                  |
|email     |amotoori24122022@gmail.com|
|telephone |123457899                 |
|password  |12345                     |
And user selects privacy policy field
And User clicks on Continue button
Then User should get a proper warning message about duplicate email

Scenario: User creates an account with filling any details
Given User navigates to Register Account page
When User dont enters the any details into fields
And User clicks on Continue button
Then User should get a proper warning message for every mandatory field


