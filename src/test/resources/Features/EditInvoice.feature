Feature: EditInvoice

@Regression 
Scenario: Check whether user is able to edit quantity in invoice
	Given User is on login page
	When User enters email as "testra.j409@gmail.com" and password as "Cbsinf0."
	And User clicks login button
	And User is on Dashboard page and clicks sales and invoice from side menu
	And User navigates to invoice sale
	And User clicks the Action icon
	And User clicks Edit Invoice Sale
	And User scrolls down to items
	And User edits quantity
	And User Click save sale button
	Then Invoice updated successfully

@Regression 
Scenario Outline: Check whether it throws "Unexpected value provided!" while entering zero, -1 and alphabets in quantity field
	Given User is on login page
	When User enters email as "testra.j409@gmail.com" and password as "Cbsinf0."
	And User clicks login button
	And User is on Dashboard page and clicks sales and invoice from side menu
	And User navigates to invoice sale
	And User clicks the Action icon
	And User clicks Edit Invoice Sale
	And User scrolls down to items
	And User edits quantity as "<Quantity>"
	And User clicks outside qty field	
	Then It throws "Unexpected value provided!"
	
Examples: 
	|	Quantity	|
	|	-1	|
	|	0	|
	|	abcd	|
	
@Regression 
Scenario Outline: Check whether system throws error while entering more than 100% in discount
	Given User is on login page
	When User enters email as "testra.j409@gmail.com" and password as "Cbsinf0."
	And User clicks login button
	And User is on Dashboard page and clicks sales and invoice from side menu
	And User navigates to invoice sale
	And User clicks the Action icon
	And User clicks Edit Invoice Sale
	And User scrolls down to discounts
	And User enters discount as "<Discounts>"
	And User clicks outside the discount field
	Then System throws "<Result>"
	
Examples:
	|	Discounts	|	Result	|
	|	101%		|	Discount cannot be more than 100%	|
	
@Regression
Scenario: Check whether system throws error while entering discount amount greater than total amount	
	Given User is on login page
	When User enters email as "testra.j409@gmail.com" and password as "Cbsinf0."
	And User clicks login button
	And User is on Dashboard page and clicks sales and invoice from side menu
	And User navigates to invoice sale
	And User clicks the Action icon
	And User clicks Edit Invoice Sale
	And User scrolls down to discounts
	And User enters discount
	And User clicks outside the discount field
	Then System throws "Discount amount cannot be more than total amount"
	
@Regression	
Scenario: Check whether system throws "Please provide valid Coupon code" while clicking Apply button without entering coupon
	Given User is on login page
	When User enters email as "testra.j409@gmail.com" and password as "Cbsinf0."
	And User clicks login button
	And User is on Dashboard page and clicks sales and invoice from side menu
	And User navigates to invoice sale
	And User clicks the Action icon
	And User clicks Edit Invoice Sale
	And User scrolls down to coupons
	And User clicks Apply coupon button
	Then It must throw "Please provide valid Coupon code"

@Regression 
Scenario Outline: Check whether error is thrown "Please provide valid coupon code." while entering invalid coupon codes
	Given User is on login page
	When User enters email as "testra.j409@gmail.com" and password as "Cbsinf0."
	And User clicks login button
	And User is on Dashboard page and clicks sales and invoice from side menu
	And User navigates to invoice sale
	And User clicks the Action icon
	And User clicks Edit Invoice Sale
	And User scrolls down to items
	And User enters coupon code as "<CouponCodes>"
	And User clicks Apply coupon button 	
	Then It must throw "Please provide valid coupon code."
	
Examples:
	| CouponCodes |
	| FLAT50	  |
	| !@#$%^&*()_+	  |
	| 1234567890	|
	
@Regression 
Scenario: Check whether user is able to add another item 
	Given User is on login page
	When User enters email as "testra.j409@gmail.com" and password as "Cbsinf0."
	And User clicks login button
	And User is on Dashboard page and clicks sales and invoice from side menu
	And User navigates to invoice sale
	And User clicks the Action icon
	And User clicks Edit Invoice Sale
	And User scrolls down to items
	And User enters item name and selects item
	And User Click save sale button
	Then Invoice updated successfully
	
@Regression 
Scenario: Check whether user is able to delete the item	
	Given User is on login page
	When User enters email as "testra.j409@gmail.com" and password as "Cbsinf0."
	And User clicks login button
	And User is on Dashboard page and clicks sales and invoice from side menu
	And User navigates to invoice sale
	And User clicks the Action icon
	And User clicks Edit Invoice Sale
	And User scrolls down to items
	And User deletes item
	And User Click save sale button
	Then Invoice updated successfully
	
Scenario: Check whether system throws "The Order Items field is required." when clicking save sale button without any item selected.
	Given User is on login page
	When User enters email as "testra.j409@gmail.com" and password as "Cbsinf0."
	And User clicks login button
	And User is on Dashboard page and clicks sales and invoice from side menu
	And User navigates to invoice sale
	And User clicks the Action icon
	And User clicks Edit Invoice Sale
	And User scrolls down to items
	And User deletes item
	And If there is no item present
	And User Click save sale button
	Then System throws "The Order Items field is required."	
	
@Regression	
Scenario: Check whether user is able to upload document
	Given User is on login page
	When User enters email as "testra.j409@gmail.com" and password as "Cbsinf0."
	And User clicks login button
	And User is on Dashboard page and clicks sales and invoice from side menu
	And User navigates to invoice sale	
	And User clicks the Action icon
	And User clicks Edit Invoice Sale
	And User scrolls down to attachment
	And User uploads document
	And User clicks save sale button
	Then User verifies the attachment

	
	
	
	
	
	
	
	
	
	
	
	
	