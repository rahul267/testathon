Meta:

Narrative:
Open Google Search Step-ni

Scenario: To validate the response of GET API Request
Given I Open Web http://www.google.com in Mobile Browser
Then Google Page is Loaded
When I Search for keyword step-in forum facebook
Then I expect search results has result which contains text 25000 test professionals
Given I click on Result which contains text 25000 test professionals

