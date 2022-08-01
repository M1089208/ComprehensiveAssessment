Feature: Login 

Scenario: Check Login functionality with valid data

Given User is landing on website home page
When User clicks on Login link on the signup page
And User enters "<Email>" and "<password>"
Then Validate user is on correct page

Examples:
|Email										|password|
|ramyakaranam593@gmail.com|Ramya@123|