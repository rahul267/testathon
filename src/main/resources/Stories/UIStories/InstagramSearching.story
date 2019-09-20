Feature: Login feature

Scenario: Login
Given i login to the site
And I click on posts tab
And wait till all the posts loaded
Then get all posts likes and name
Examples:
|site|
|https://www.instagram.com/step_in_forum/|