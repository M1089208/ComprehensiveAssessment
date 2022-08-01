Feature: LiveChat

Scenario: check LiveChat functionality
Given User is landing on website home page
When User clicks on LiveChat link
Then Validate ChatNow button is available or not
When User clicks on ChatNow button
And User enters "<FirstName>" "<LastName>" and "<Emailid>"
Then Validate EndChat is displayed or not


Examples:
|FirstName|LastName|Emailid|
|ramya|reddipalli|ramyakaranam593@gmail.com| 