Feature: CreateInvoice

Background: Login and navigate to new invoice sale page
	Given User is on login page
	When User enters email as "testra.j409@gmail.com" and password as "Cbsinf0."
	And User clicks login button
	And User is on Dashboard page and clicks sales and invoice from side menu
	And User navigates to invoice sale
	And User clicks New Invoice Sale button

@Regression @Sanity 
Scenario: Check whether user is able to create invoice
	And User navigates to invoice creation page and enters invoice details
	And Click save sale button
	Then Invoice created successfully
	
@Regression	@Sanity
Scenario: Check whether user is able to create invoice with discount percentage
	And User navigates to invoice creation page and enters invoice details
	And User enters coupon code as "FLAT50"
	And User clicks Apply coupon button 
	And It tells "Coupon Applied"
	And User enters discount as "50%"
	And User enters shipping cost as "10"
	And Click save sale button
	Then Invoice created successfully
	
@Regreession @Sanity
Scenario: Check whether user is able to create invoice with discount amount	
	And User navigates to invoice creation page and enters invoice details
	And User enters coupon code as "FLAT50"
	And User clicks Apply coupon button 
	And It tells "Coupon Applied"
	And User enters discounts
	And User enters shipping cost as "10"
	And Click save sale button
	Then Invoice created successfully 
		

@Regression	
Scenario: Check whether system throws "Please select above first" while selecting item name directly	
	And User selects item name directly
	Then It should throw "Please select above first"

@Regression	
Scenario Outline: Check whether system throws "Unexpected value provided!" while entering negative values, Zero and alphabets in Quantity field
	And User selects customer
	And User enters item name and selects item
	And User enters Quantity as "<Quantity>"
	Then System should throw "Unexpected value provided!"
	
Examples:
	| Quantity |
	| abcd	   |
	|	0	   |
	|	-1	   |
	| !@#	   |	

@Regression	
Scenario: Check whether system throws "Please provide valid Coupon code" while clicking Apply button without entering coupon
	And User selects customer
	And User enters item name and selects item
	And User clicks Apply coupon button
	Then It must throw "Please provide valid Coupon code"
	
@Regression	
Scenario: Check whether system throws "Please select atleast one item." while clicking Apply button without entering coupon and without selecting item
	And User clicks Apply coupon button
	Then System must throw "Please select atleast one item."	

@Regression 
Scenario Outline: Check whether error is thrown "Please provide valid coupon code." while entering invalid coupon codes
	And User selects customer
	And User enters item name and selects item
	And User enters coupon code as "<CouponCodes>"
	And User clicks Apply coupon button 	
	Then It must throw "Please provide valid coupon code."
	
Examples:
	| CouponCodes |
	| FLAT75	  |
	| !@#	  |
	| 123	|
	
@Regression 
Scenario Outline: Check whether system throws error while entering more than 100% and less than 0% in discount	
	And User selects customer
	And User enters item name and selects item
	And User enters discount as "<Discount>"
	And User clicks outside the discount field 
	Then It should display "<Result>"
	
Examples: 
	| Discount | Result |
	| -1% |	Discount cannot be less than 0% |
	| 101% | Discount cannot be more than 100% |
	
@Regression
Scenario: Check whether system throws error while entering discount amount greater than total amount	
	And User selects customer
	And User enters item name and selects item
	And User enters discount
	And User clicks outside the discount field
	Then System throws "Discount amount cannot be more than total amount"
	
@Regression 
Scenario: Check whether system throws error while entering discount amount less than 0
	And User selects customer
	And User enters item name and selects item
	And User enters discount as "-1"
	And User clicks outside the discount field 
	Then It should display "Discount amount cannot be less than 0"		
	
@Regression
Scenario: Check whether user is able to upload document	
	And User selects customer
	And User enters item name and selects item
	Then User attachs document
	And User verifies the attachment
	
@Regression
Scenario: Check whether system throws "Unexpected value provided!" while making Payment term field empty and clicking outside Payment term field	
	And User makes Payment term field empty
	And User click outside payment term field
	Then System should throw "Unexpected value provided!"
	
@Regression @Sanity	
Scenario: Check whether user is able to create customer inside new invoice sale page
	And User clicks add new customer button
	And User enters name of the customer as "Test Customer Sarath"
	And User clicks save customer button
	Then System should throw "Customer successfully added"	
	
@Regression 	
Scenario: Check whether system throws "The Name field is required." while clicking save customer button without entering name
	And User clicks add new customer button	
	And User clicks save customer button
	Then Alert is "The Name field is required."
	
@Regression
Scenario Outline: Check whether user is able to create a new custom field for new customer inside new invoice sale page	with mandatory YES
	And User clicks add new customer button
	And User scrolls down to Add New Custom Field button
	And User clicks add new custom field button
	And User enters label as "<Label>"
	And User clicks and selects type as "<Type>"
	And User chooses mandatory option as yes
	And User clicks save button
	Then System should throw "Custom field successfully added for customer"
	
Examples:
	|	Label		|	Type		|
	|	Chk	|	Checklist	|	
	|	Dte	|	Date	|
	|	Dpd	|	Dropdown	|
	|	MuCh	|	Mutiple Choice	|
	|	Pra	|	Paragraph	|
	|	Sht	|	Short Text	|

@Regression	
Scenario Outline: Check whether user is able to create a new custom field for new customer inside new invoice sale page	with mandatory NO
	And User clicks add new customer button
	And User scrolls down to Add New Custom Field button
	And User clicks add new custom field button
	And User enters label as "<Label>"
	And User clicks and selects type as "<Type>"
	And User chooses mandatory option as no
	And User clicks save button
	Then System should throw "Custom field successfully added for customer"
	
Examples:
	|	Label		|	Type		|
	|	Chk	|	Checklist	|	
	|	Dte	|	Date	|
	|	Dpd	|	Dropdown	|
	|	MuCh	|	Mutiple Choice	|
	|	Pra	|	Paragraph	|
	|	Sht	|	Short Text	|
	
@Regression 	
Scenario: Check whether system throws "All fields are required"	when clicking save button without filling anything in custom field inside new invoice sale 
	And User clicks add new customer button
	And User scrolls down to Add New Custom Field button
	And User clicks add new custom field button
	And User clicks save button
	Then Alert "All fields are required"
	
@Regression 	
Scenario: Check whether another custom field adding option is displaying while clicking Add another custom field button
	And User clicks add new customer button
	And User scrolls down to Add New Custom Field button
	And User clicks add new custom field button
	And User clicks	add another custom field button
	Then Verify the custom field option
	
@Regression 
Scenario: Check whether user can delete the newly added custom field option
	And User clicks add new customer button
	And User scrolls down to Add New Custom Field button
	And User clicks add new custom field button
	And User clicks	add another custom field button
	And User deletes the newly added custom field option
	Then Verify the deleted option
	
@Regression 
Scenario: Check whether user can close add new custom field popup and add new customer popup
	And User clicks add new customer button
	And User scrolls down to Add New Custom Field button
	And User clicks add new custom field button
	And User closes add new custom field popup and add new customer popup
	Then Verify popup closed for both
	
@Regression 	
Scenario: Check whether system throws "Customer is missing from invoice" when user clicks save address button in add billing address option without selecting customer
	And User clicks add billing address button
	And User clicks save address button
	Then System throws "Customer is missing from invoice"
	
@Regression 
Scenario: Check whether billing address popup closes while clicking cancel button
	And User clicks add billing address button
	And User clicks cancel button
	Then Verify popup closed	
	
@Regression 	
Scenario: Check whether user can close billing address popup
	And User clicks add billing address button
	And User closes billing address popup
	Then Verify popup closed
	
@Regression	
Scenario: Check whether system throws "Address is required" when user clicks save address button without filling address in add billing address popup
	And User selects customer
	And User clicks add billing address button
	And User clicks save address button
	Then System throws "Address is required"
	
@Regression 	
Scenario: Check whether system throws "Postal code is required" when user clicks save address button after filling address in add billing address popup
	And User selects customer
	And User clicks add billing address button
	And User enters address line1
	And User clicks save address button
	Then System throws "Postal code is required"
	
@Regression	
Scenario: Check whether system throws "Address added successfully" after creating billing address inside new invoice sale page
	And User selects customer
	And User clicks add billing address button
	And User enters address line1
	And User enters postal code
	And User clicks save address button
	Then System throws "Address added successfully"	
	
@Regression 	
Scenario: Check whether system throws "Address updated successfully" after editing billing address inside new invoice sale page
	And User selects customer
	And User selects billing address
	And User clicks edit option
	And User updates postal code
	And User clicks update address button
	Then System throws "Address updated successfully"
	
@Regression 
Scenario: Check whether edit billing address popup closes while clicking cancel button	
    And User selects customer
	And User selects billing address
	And User clicks edit option
	And User clicks cancel button
	Then Verify popup closed
	
@Regression @Test
Scenario: Check whether user can close edit billing address popup
	And User selects customer
	And User selects billing address
	And User clicks edit option
	And User closes billing address popup
	Then Verify popup closed
	
	

	
	
	
	

	
				
		
	
	
	
	
	
		
	
	