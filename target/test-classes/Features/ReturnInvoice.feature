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
	
@Regression 
Scenario: Check whether invoice can be returned
	Given User is on login page
	When User enters email as "testra.j409@gmail.com" and password as "Cbsinf0."
	And User clicks login button
	And User is on Dashboard page and clicks sales and invoice from side menu
	And User navigates to invoice sale
	And User clicks New Invoice Sale button
	And User navigates to invoice creation page and enters invoice details
	And Click save sale button
	And User clicks the Action icon
	And User clicks Return invoice sale
	And User selects item to return
	And User clicks Return Checked items button
	Then System throws "Return invoice sale successfully added"
		
@Regression
Scenario: Check whether system throws "The Order Items field is required." if we click Return checked items button without selecting items
	Given User is on login page
	When User enters email as "testra.j409@gmail.com" and password as "Cbsinf0."
	And User clicks login button
	And User is on Dashboard page and clicks sales and invoice from side menu
	And User navigates to invoice sale
	And User clicks New Invoice Sale button
	And User navigates to invoice creation page and enters invoice details
	And Click save sale button
	And User clicks the Action icon
	And User clicks Return invoice sale
	And User clicks Return Checked items button
	Then Alert is "The Order Items field is required."	
	
@Regression 	
Scenario: Check whether clicking cancel in return invoice page redirects to return sales list page
	Given User is on login page
	When User enters email as "testra.j409@gmail.com" and password as "Cbsinf0."
	And User clicks login button
	And User is on Dashboard page and clicks sales and invoice from side menu
	And User navigates to invoice sale
	And User clicks New Invoice Sale button
	And User navigates to invoice creation page and enters invoice details
	And Click save sale button
	And User clicks the Action icon
	And User clicks Return invoice sale
	And User clicks Cancel button
	Then It should navigate to return sales list page	
	
@Regression
Scenario: Check whether adding exchange item quantity higher than the available quantity throws "Exchange Sale is failed due to - The quantity is out of stock"	
	Given User is on login page
	When User enters email as "testra.j409@gmail.com" and password as "Cbsinf0."
	And User clicks login button
	And User is on Dashboard page and clicks sales and invoice from side menu
	And User navigates to invoice sale
	And User clicks New Invoice Sale button
	And User navigates to invoice creation page and enters invoice details
	And Click save sale button
	And User clicks the Action icon
	And User clicks Return invoice sale	
	And User selects item to return
	And User clicks Add items for exchange button
	And User adds item
	And User enters quantity
	And User makes amount field to zero in exchange
	And User clicks Return Checked items button
	Then Throws first alert "Exchange Sale is failed due to - The quantity is out of stock"
	
	
	
	
	
 
	