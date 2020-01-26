Feature: Heroku User LogIn 

Scenario: HeroKu LogIn Page Test

Given user is already on login page
When user enters valid "tomsmith" and "SuperSecretPassword!"
Then user click on login 
Then user will get account access
And close the browser


