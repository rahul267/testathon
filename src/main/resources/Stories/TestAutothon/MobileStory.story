Meta:

Narrative:
Open Google Search Step-ni

Scenario: To validate the response of GET API Request
Given I Open Web http://www.google.com in Mobile Browser
Then Google Page is Loaded
When I Search for keyword step-in forum facebook
Then I expect search results has result which contains text 25000 test professionals
Given I click on Result which contains text 25000 test professionals
Given I Navigate and download to post which has more than 4 images
Given I navigate to photo
Given I click on See All Link
Then I extract Album and Photos name and count and create a json file