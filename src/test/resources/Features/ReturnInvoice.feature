Feature: ReturnInvoice

@Regression 
Scenario: Check whether system throws error, if we make return invoice for cancelled invoice
	Given User is on login page
	When User enters email as "testra.j409@gmail.com" and password as "Cbsinf0."
	And User clicks login button
	And User is on Dashboard page and clicks sales and invoice from side menu
	And User navigates to invoice sale
	And User clicks New Invoice Sale button
	And User navigates to invoice creation page and enters invoice details
	And Click save sale button
	And User clicks the Action icon
	And User clicks Edit Invoice Sale
	And Change sale status to cancelled
	And User Click save sale button
	And User clicks the Action icon
	And User clicks Return invoice sale
	Then System throws "Invoice Sale status is cancelled, you can add return invoice sale for only completed invoice sales."
	
	
	
	
	
	
	
 
	