Feature: CreateSaleOrder

Background: Login and navigate to new sale order page
	Given User is on login page
	When User enters email as "testra.j409@gmail.com" and password as "Cbsinf0."
	And User clicks login button
	And User clicks sales from side menu
	And User clicks sale orders
	And User clicks new order button

@Regression
Scenario: Check whether user is able to add new sale order
	And User chooses customer in new sale order page
	And User selects shipping address
	And User selects items
	And User clicks save sale order button
	Then System throws "Sale Order successfully added" 
	
@Regression
Scenario: Check whether system throws alert for customer field and shipping address field when we leave it empty and save sale order
	And User clicks save sale order button
	Then First Alert is "The Customer field is required."
	And Second alert is "The Shipping Address field is required."
	
@Regression	
Scenario: Check whether system throws alert for shipping address field when we leave it empty and save sale order	
	And User chooses customer in new sale order page
	And User clicks save sale order button
	Then Alert is "The Shipping Address field is required." 
	
@Regression 
Scenario: Check whether system throws alert for order items field when we leave it empty and save sale order		
	And User chooses customer in new sale order page
	And User selects shipping address
	And User clicks save sale order button
	Then Alert is "The Order Items field is required."
	
@Regression	
Scenario: Check whether system throws error while entering discount amount greater than total amount in new sale order page
	And User chooses customer in new sale order page
	And User selects shipping address
	And User selects items
	And User enters discount amount greater than total amount
	And User clicks out of the discount field
	Then System throws "Unexpected value provided!"
	
@Regression 
Scenario: Check whether user is able to create customer inside new sale order page
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
Scenario Outline: Check whether user is able to create a new custom field for new customer inside new sale order page	with mandatory YES
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
Scenario Outline: Check whether user is able to create a new custom field for new customer inside new sale order page	with mandatory NO
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
Scenario: Check whether system throws "All fields are required"	when clicking save button without filling anything in custom field inside sale order page  
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
	And User closes add new custom field popup and add new customer popup in new sale order page
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
	And User chooses customer in new sale order page
	And User clicks add billing address button
	And User clicks save address button
	Then System throws "Address is required"
	
@Regression	
Scenario: Check whether system throws "Postal code is required" when user clicks save address button after filling address in add billing address popup
	And User chooses customer in new sale order page
	And User clicks add billing address button
	And User enters address line1
	And User clicks save address button
	Then System throws "Postal code is required"	

@Regression
Scenario: Check whether system throws "Address added successfully" after creating billing address inside new invoice sale page
	And User chooses customer in new sale order page
	And User clicks add billing address button
	And User enters address line1
	And User enters postal code
	And User clicks save address button
	Then System throws "Address added successfully"	
	
@Regression 
Scenario: Check whether system throws "Address updated successfully" after editing billing address inside new invoice sale page
	And User chooses customer in new sale order page
	And User selects billing address
	And User clicks edit option
	And User updates postal code
	And User clicks update address button
	Then System throws "Address updated successfully"
	
@Regression 
Scenario: Check whether edit billing address popup closes while clicking cancel button	
  And User chooses customer in new sale order page
	And User selects billing address
	And User clicks edit option
	And User clicks cancel button
	Then Verify popup closed
	
@Regression 
Scenario: Check whether user can close edit billing address popup
	And User chooses customer in new sale order page
	And User selects billing address
	And User clicks edit option
	And User closes billing address popup
	Then Verify popup closed
	
@Regression 
Scenario: Check whether system throws "Customer is missing from invoice" when user clicks save address button in add shipping address option without selecting customer	
	And User clicks add shipping address button
	And User clicks save address button
	Then System throws "Customer is missing from invoice"
	
@Regression 
Scenario: Check whether shipping address popup closes while clicking cancel button
	And User clicks add shipping address button
	And User clicks cancel button
	Then Verify popup closed	
	
@Regression 	
Scenario: Check whether user can close shipping address popup
	And User clicks add shipping address button
	And User closes billing address popup
	Then Verify popup closed
	
@Regression	
Scenario: Check whether system throws "Address is required" when user clicks save address button without filling address in add shipping address popup
	And User chooses customer in new sale order page
	And User clicks add shipping address button
	And User clicks save address button
	Then System throws "Address is required"
	
@Regression 
Scenario: Check whether system throws "Postal code is required" when user clicks save address button after filling address in add shipping address popup
	And User chooses customer in new sale order page
	And User clicks add shipping address button
	And User enters address line1
	And User clicks save address button
	Then System throws "Postal code is required"
	
@Regression	
Scenario: Check whether system throws "Address added successfully" after creating shipping address inside new invoice sale page
	And User chooses customer in new sale order page
	And User clicks add shipping address button
	And User enters address line1
	And User enters postal code
	And User clicks save address button
	Then System throws "Address added successfully"
	
@Regression 
Scenario: Check whether system throws "Address updated successfully" after editing shipping address inside new invoice sale page
	And User chooses customer in new sale order page
	And User selects shipping address
	And User clicks edit option shipping
	And User updates postal code
	And User clicks update address button
	Then System throws "Address updated successfully"	
	
@Regression
Scenario: Check whether edit shipping address popup closes while clicking cancel button	
  And User chooses customer in new sale order page
	And User selects shipping address
	And User clicks edit option shipping
	And User clicks cancel button
	Then Verify popup closed	
	
@Regression
Scenario: Check whether user can close edit shipping address popup
	And User chooses customer in new sale order page
	And User selects shipping address
	And User clicks edit option shipping
	And User closes billing address popup
	Then Verify popup closed
	
@Regression 
Scenario: Check whether the page gets resets after clicking reset button
	And User chooses customer in new sale order page
	And User selects shipping address
	And User selects items
	And User clicks reset button
	And User clicks OK
	And Scroll back to customer field
	Then Verify whether page resetted

@Regression 	
Scenario: Check whether reset popup disappears after clicking cancel															
	And User chooses customer in new sale order page
	And User selects shipping address
	And User selects items
	And User clicks reset button
	And User clicks cancel
	Then Verify whether popup closed
	
@Regression		
Scenario: Check whether reset popup closes after clicking close	
	And User chooses customer in new sale order page
	And User selects shipping address
	And User selects items
	And User clicks reset button
	And User closes the popup
	Then Verify the same
	
@Regression
Scenario: Check whether user is able to upload document	
	And User chooses customer in new sale order page
	And User selects shipping address
	And User selects items
	And User attachs document to sale order
	And User clicks save sale order button
	And User clicks the Action icon
	And User clicks sale order details 
	Then User verifies the attachment in view page
	
	
	
	
	
	
	
	