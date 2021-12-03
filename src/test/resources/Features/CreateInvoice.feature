Feature: CreateInvoice

@Regression 
Scenario: Check whether user is able to create invoice
	Given User is on login page
	When User enters email as "testra.j409@gmail.com" and password as "Cbsinf0."
	And User clicks login button
	And User is on Dashboard page and clicks sales and invoice from side menu
	And User navigates to invoice sale
	And User clicks New Invoice Sale button
	And User navigates to invoice creation page and enters invoice details
	And Click save sale button
	Then Invoice created successfully

@Regression	
Scenario: Check whether system throws "Please select above first" while selecting item name directly	
	Given User is on login page
	When User enters email as "testra.j409@gmail.com" and password as "Cbsinf0."
	And User clicks login button
	And User is on Dashboard page and clicks sales and invoice from side menu
	And User navigates to invoice sale
	And User clicks New Invoice Sale button
	And User selects item name directly
	Then It should throw "Please select above first"

@Regression	
Scenario Outline: Check whether system throws "Unexpected value provided!" while entering negative values, Zero and alphabets in Quantity field
	Given User is on login page
	When User enters email as "testra.j409@gmail.com" and password as "Cbsinf0."
	And User clicks login button
	And User is on Dashboard page and clicks sales and invoice from side menu
	And User navigates to invoice sale
	And User clicks New Invoice Sale button
	And User selects customer
	And User enters item name and selects item
	And User enters Quantity as "<Quantity>"
	Then System should throw "Unexpected value provided!"
	
Examples:
	| Quantity |
	| abcd	   |
	|	0	   |
	|	-1	   |	
	|!@#$%^&*()|

@Regression	
Scenario: Check whether system throws "Please provide valid Coupon code" while clicking Apply button without entering coupon
	Given User is on login page
	When User enters email as "testra.j409@gmail.com" and password as "Cbsinf0."
	And User clicks login button
	And User is on Dashboard page and clicks sales and invoice from side menu
	And User navigates to invoice sale
	And User clicks New Invoice Sale button
	And User selects customer
	And User enters item name and selects item
	And User clicks Apply coupon button
	Then It must throw "Please provide valid Coupon code"
	
@Regression	
Scenario: Check whether system throws "Please select atleast one item." while clicking Apply button without entering coupon and without selecting item
	Given User is on login page
	When User enters email as "testra.j409@gmail.com" and password as "Cbsinf0."
	And User clicks login button
	And User is on Dashboard page and clicks sales and invoice from side menu
	And User navigates to invoice sale
	And User clicks New Invoice Sale button
	And User clicks Apply coupon button
	Then System must throw "Please select atleast one item."	

@Regression 
Scenario: Check whether system throws error "Please Select Customer" when checking Display all price book list price without selecting customer	
	Given User is on login page
	When User enters email as "testra.j409@gmail.com" and password as "Cbsinf0."
	And User clicks login button
	And User is on Dashboard page and clicks sales and invoice from side menu
	And User navigates to invoice sale
	And User clicks New Invoice Sale button
	And User selects Display all price book list price checkbox
	Then It throws error "Please Select Customer"

@Regression 
Scenario Outline: Check whether error is thrown "Please provide valid coupon code." while entering invalid coupon codes
	Given User is on login page
	When User enters email as "testra.j409@gmail.com" and password as "Cbsinf0."
	And User clicks login button
	And User is on Dashboard page and clicks sales and invoice from side menu
	And User navigates to invoice sale
	And User clicks New Invoice Sale button
	And User selects customer
	And User enters item name and selects item
	And User enters coupon code as "<CouponCodes>"
	And User clicks Apply coupon button 	
	Then It must throw "Please provide valid coupon code."
	
Examples:
	| CouponCodes |
	| FLAT50	  |
	| !@#$%^&*()_+	  |
	| 1234567890	|
	
@Regression 
Scenario Outline: Check whether system throws "Discount amount cannot be more than item amount" when we enter discount amount more than the item amount and "Discount amount cannot be more than 100%" if we enter percentage above hundred	
	Given User is on login page
	When User enters email as "testra.j409@gmail.com" and password as "Cbsinf0."
	And User clicks login button
	And User is on Dashboard page and clicks sales and invoice from side menu
	And User navigates to invoice sale
	And User clicks New Invoice Sale button
	And User selects customer
	And User enters item name and selects item
	And User enters discount "<Discount>" 
	Then It should display "<Result>"
	
Examples: 
	| Discount | Result |
	| 150 |	Discount amount cannot be more than item amount |
	| 101% | Discount cannot be more than 100% |	
	
@Regression 
Scenario: Check whether user is able to upload document	
	Given User is on login page
	When User enters email as "testra.j409@gmail.com" and password as "Cbsinf0."
	And User clicks login button
	And User is on Dashboard page and clicks sales and invoice from side menu
	And User navigates to invoice sale
	And User clicks New Invoice Sale button
	And User selects customer
	And User enters item name and selects item
	Then User attachs document
	And User verifies the attachment
	
	
	
	
	
	
	
	
	
	
		
	
	