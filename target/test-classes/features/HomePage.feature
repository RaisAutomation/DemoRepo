Feature: Homepage Test

Scenario: Home Page Main Menu Test

Given User already on Home Page
When user clicks Or Hover on Menu slider
Then Main Menu will get Opened

Scenario: Home Page Search Bar Test
Given User already on Home Page
When User clicks on Search box
And Enter Product Name
And Hit Search Icon
Then Search result will appear


