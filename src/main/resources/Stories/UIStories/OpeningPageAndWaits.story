Feature: Login feature

Scenario: Login and Navigate to Admin
Given i login to the site
And I click on events tab
And click on More Filters option
And click on past events
Examples:
|site|
|https://events.epam.com/|