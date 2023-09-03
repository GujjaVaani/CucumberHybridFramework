@search
Feature: Searh functionality

Scenario: User searches for valid product
Given User opens the application
When User enters valid product "HP" into search field
And User clicks on Search button
Then User should get valid product displayed in search results

 
Scenario: User searches for invalid product
Given User opens the application
When User enters invalid product "Honda" into search field
And User clicks on Search button
Then User should get message about no product matching

Scenario: User searches without any product
Given User opens the application
When User dont enter any product name into search field
And User clicks on Search button
Then User should get message about no product matching

 