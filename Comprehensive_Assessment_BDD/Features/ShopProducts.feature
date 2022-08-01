Feature: Shop Products

Scenario: Check functionality of Shop Products link

Given User is on website home page
When User mouse hovers on Shop Products and click on Stain Remover
And User clicks on Deep Clean
And User prints the number of products available on that page
Then Validate the page