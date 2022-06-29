Feature: ReturnInvoiceList

@Regression
Scenario: Check whether user can able to view credit note
	Given User is on login page
	When User enters email as "testra.j409@gmail.com" and password as "Cbsinf0."
	And User clicks login button
	And User is on Dashboard page and clicks sales and return sales from side menu
	And User clicks the Action icon
	And User clicks View Credit Note
	And User closes print popup
	Then User verifies the credit note
	
@Regression 
Scenario: Check whether user can able to view details	
	Given User is on login page
	When User enters email as "testra.j409@gmail.com" and password as "Cbsinf0."
	And User clicks login button
	And User is on Dashboard page and clicks sales and return sales from side menu
	And User clicks the Action icon
	Then User clicks View details and verify the details
	