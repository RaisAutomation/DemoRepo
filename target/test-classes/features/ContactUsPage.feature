Feature: Contact Us page

Scenario: Contact us page Test
Given user is already in contact us page
When user fill fields like Name Email Address contact Name
And user fill field like Comments
Then click on send your message
