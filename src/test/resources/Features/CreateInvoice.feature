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
	| -1% |	Unexpected value provided! |
	| 101% | Unexpected value provided! |
	
@Regression
Scenario: Check whether system throws error while entering discount amount greater than total amount	
	And User selects customer
	And User enters item name and selects item
	And User enters discount
	And User clicks outside the discount field
	Then System throws "Unexpected value provided!"
	
@Regression 
Scenario: Check whether system throws error while entering discount amount less than 0
	And User selects customer
	And User enters item name and selects item
	And User enters discount as "-1"
	And User clicks outside the discount field 
	Then It should display "Unexpected value provided!"	
	
@Regression @Sanity
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
	
@Regression @Sanity
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

@Regression	@Sanity
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
	
@Regression	@Sanity
Scenario: Check whether system throws "Address added successfully" after creating billing address inside new invoice sale page
	And User selects customer
	And User clicks add billing address button
	And User enters address line1
	And User enters postal code
	And User clicks save address button
	Then System throws "Address added successfully"	
	
@Regression @Sanity	
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
	
@Regression 
Scenario: Check whether user can close edit billing address popup
	And User selects customer
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
	And User selects customer
	And User clicks add shipping address button
	And User clicks save address button
	Then System throws "Address is required"
	
@Regression 
Scenario: Check whether system throws "Postal code is required" when user clicks save address button after filling address in add shipping address popup
	And User selects customer
	And User clicks add shipping address button
	And User enters address line1
	And User clicks save address button
	Then System throws "Postal code is required"
	
@Regression	@Sanity
Scenario: Check whether system throws "Address added successfully" after creating shipping address inside new invoice sale page
	And User selects customer
	And User clicks add shipping address button
	And User enters address line1
	And User enters postal code
	And User clicks save address button
	Then System throws "Address added successfully"					

@Regression @Sanity
Scenario: Check whether system throws "Address updated successfully" after editing shipping address inside new invoice sale page
	And User selects customer
	And User selects shipping address
	And User clicks edit option shipping
	And User updates postal code
	And User clicks update address button
	Then System throws "Address updated successfully"	
	
@Regression 
Scenario: Check whether edit shipping address popup closes while clicking cancel button	
  And User selects customer
	And User selects shipping address
	And User clicks edit option shipping
	And User clicks cancel button
	Then Verify popup closed	
	
@Regression
Scenario: Check whether user can close edit shipping address popup
	And User selects customer
	And User selects shipping address
	And User clicks edit option shipping
	And User closes billing address popup
	Then Verify popup closed
	
@Regression 
Scenario: Check whether system throws alert when user clicks save currency button in add currency option inside new invoice sale page without filling anything
	And User clicks add currency button
	And User clicks save currency button
	Then Four alerts, First alert is "The Currency Code field is required."
	And Second alert is "The Name field is required."
	And Third alert is "The Exchange Rate field is required."
	And Fourth alert is "The Currency Symbol field is required."	
	
@Regression 
Scenario: Check whether system throws "The Exchange Rate field is required." when clicking save currency button with exchange rate "0.00"
	And User clicks add currency button
	And User selects currency code
	And User clicks save currency button
	Then Alert is "The Exchange Rate field is required."
	
@Regression	@Sanity
Scenario: Check whether system throws "Currency successfully added"	after creating currency
	And User clicks add currency button
	And User selects currency code
	And User enters exchange rate
	And User clicks save currency button
	Then System throws "Currency successfully added"	
	
@Regression 	
Scenario: Check whether user can close the currency popup
	And User clicks add currency button	
	And User closes the currency popup
	Then Verify popup closes
	
@Regression @Sanity
Scenario: Check whether the page gets resets after clicking reset button
	And User navigates to invoice creation page and enters invoice details
	And User enters coupon code as "FLAT50"
	And User clicks Apply coupon button 
	And It tells "Coupon Applied"
	And User enters discount as "50%"
	And User enters shipping cost as "10"
	And User clicks reset button
	And User clicks OK
	And Scroll up to customer field
	Then Verify whether the page gets resetted
	
@Regression
Scenario: Check whether reset popup disappears after clicking cancel
	And User navigates to invoice creation page and enters invoice details
	And User enters coupon code as "FLAT50"
	And User clicks Apply coupon button 
	And It tells "Coupon Applied"
	And User enters discount as "50%"
	And User enters shipping cost as "10"
	And User clicks reset button
	And User clicks cancel
	Then Verify whether popup closed	
	
@Regression			
Scenario: Check whether reset popup closes after clicking close
	And User navigates to invoice creation page and enters invoice details
	And User enters coupon code as "FLAT50"
	And User clicks Apply coupon button 
	And It tells "Coupon Applied"
	And User enters discount as "50%"
	And User enters shipping cost as "10"
	And User clicks reset button
	And User closes the popup
	Then Verify the same			
	
@Regression @Sanity
Scenario: Check whether invoice status is due in invoice list page when sale status is saved as completed
	And User navigates to invoice creation page and enters invoice details
	And User selects sale status as completed
	And Click save sale button
	Then Invoice created successfully	
	And Invoice status is "Due"
	
@Regression @Sanity	
Scenario: Check whether invoice status is due in invoice list page when sale status is saved as processing
	And User navigates to invoice creation page and enters invoice details
	And User selects sale status as processing
	And Click save sale button
	Then Invoice created successfully	
	And Invoice status is "Due"
	
@Regression @Sanity	
Scenario: Check whether invoice status is pending in invoice list page when sale status is saved as pending
	And User navigates to invoice creation page and enters invoice details
	And User selects sale status as pending
	And Click save sale button
	Then Invoice created successfully	
	And Invoice status is "Pending"	
	
@Regression @Sanity
Scenario: Check whether invoice status is cancelled in invoice list page when sale status is saved as cancelled
	And User navigates to invoice creation page and enters invoice details
	And User selects sale status as cancelled
	And Click save sale button
	Then Invoice created successfully	
	And Invoice status is "Cancelled"	
	
@Regression	
Scenario: Check whether clicking invoice sales in breadcrumbs navigates to invoice list page
	And User clicks invoice sales breadcrumb
	Then It should navigate to invoice list page	
	
@Regression 	
Scenario: Check whether clicking dashboard in breadcrumbs in invoice sale page navigates to dashboard page
	And User clicks dashboard breadcrumb
	Then It should navigate to dashboard page	
	
@Regression @Sanity
Scenario: Check whether adding GST@7% affects the total amount 
	And User navigates to invoice creation page and enters invoice details
	And User chooses GST option
	Then Total amount should be affected
		
@Regression 	
Scenario: Check whether Upcoming invoice date is displaying correctly for repeat every month option with ends never
	And Scroll down to recurring button
	And Enable recurring button
	Then Upcoming invoice date should be correctly displayed	
	
@Regression 	
Scenario: Check whether Upcoming invoice date is displaying correctly for repeat every year option with ends never
	And Scroll down to recurring button
	And Enable recurring button
	And Choose Repeats Every option as Year
	Then Upcoming invoice date for year option should be correctly displayed 		
	
@Regression 
Scenario: Check whether Upcoming invoice date and end date is displaying correctly for repeat every month option with ends after
	And Scroll down to recurring button
	And Enable recurring button
	And Choose After in Ends option
	Then Upcoming invoice date and end date should be correctly displayed	
	 
@Regression	
Scenario: Check whether upcoming invoice date and end date is displaying correctly for repeat every year option with ends after
	And Scroll down to recurring button
	And Enable recurring button
	And Choose Repeats Every option as Year
	And Choose After in Ends option
	Then Upcoming invoice date and end date for year option should be correctly displayed	
		
@Regression 
Scenario: Check whether entering decimal value in repeat times field and occurence field throws error message
	And Scroll down to recurring button
	And Enable recurring button
	And Enter decimal value in repeat times field
	Then Error throws "Please enter a valid number"
	When Choose After in Ends option
	And Enter decimal value in occurence field
	Then Error throwss "Please enter a valid number"
	
@Regression
Scenario Outline: Check whether system throws "Unexpected value provided!" while entering negative values, Zero and alphabets in Quantity field while editing item after adding it
	And User selects customer
	And User enters item name and selects item
	And User clicks item edit button
	And User enters Quantity in edit option "<Quantity>"
	And User clicks out of Quantity field
	Then System should throw "Unexpected value provided!"
	
Examples:
	| Quantity |
	| abcd	   |
	|	0	   |
	|	-1	   |
	| !@#	   |		
	
@Regression 
Scenario Outline: Check whether system throws error while entering more than 100% and less than 0% in discount in item edit	
	And User selects customer
	And User enters item name and selects item
	And User clicks item edit button
	And Discount is "<Discount>"
	And User clicks submit button 
	Then It should display "<Result>"
	
Examples: 
	| Discount | Result |
	| -1% |	Unexpected value provided! |
	| 101% | Unexpected value provided! |
	
@Regression 
Scenario: Check whether system throws error while entering discount amount greater than total amount in item edit	
	And User selects customer
	And User enters item name and selects item
	And User clicks item edit button
	And Discount greater than net unit price
	And User clicks submit button
	Then System throws "Unexpected value provided!"
	
@Regression 
Scenario: Check whether system throws error while entering discount amount less than 0 in item edit
	And User selects customer
	And User enters item name and selects item
	And User clicks item edit button
	And Discount is "-1"
	And User clicks submit button  
	Then It should display "Unexpected value provided!"	
	
@Regression	
Scenario: Check whether user can close edit item popup
	And User selects customer
	And User enters item name and selects item
	And User clicks item edit button
	And User closes popup
	Then Verify the popup close				
		
@Regression	
Scenario: Check whether system throws "Select Orders" if we click Select order button in consolidated orders popup by choosing Consignment location without selecting orders
	And Choose location as consignment
	And User clicks Select consolidated orders button
	And User clicks select order button
	Then System throws "Select Orders"
	
@Regression 
Scenario: Check whether system throws "Please select above first" if we select order and click select order button without choosing customer in consolidated orders popup by choosing consignment location
	And Choose location as consignment
	And User clicks Select consolidated orders button
	And Choose order
	And User clicks select order button
	Then System throws "Please select above first"
	
@Regression	
Scenario: Check whether order is added to order items table after selecting order in consolidated order popup and clicking select order button	
	And User selects customer
	And Choose location as consignment
	And User clicks Select consolidated orders button
	And Choose order
	And User clicks select order button
	Then Order is added to order items table
	
@Regression 
Scenario: Check whether clicking cancel button in consolidated orders popup closes the popup
	And Choose location as consignment
	And User clicks Select consolidated orders button
	And User clicks cancel button in consolidated order popup
	Then Verify it
	
@Regression 
Scenario: Check whether user is able to close consolidated orders popup
	And Choose location as consignment
	And User clicks Select consolidated orders button
	And User closes consolidated orders popup
	Then Verify it	
	
@Regression	
Scenario: Check whether system throws "Item SKU and Item Name is required." when clicking submit button in new item creation (Consignment location)
	And User selects customer
	And Choose location as consignment
	And User scrolls down to new item button
	And User clicks new item button
	And User clicks submit button in new item creation
	Then System throws "Item SKU and Item Name is required." 	
	
@Regression	
Scenario: Check whether system throws "Please select above first" while clicking new item button after selecting consignment location without selecting customer
	And Choose location as consignment
	And User scrolls down to new item button
	And User clicks new item button
	Then System throws "Please select above first" 
	
@Regression @Sanity
Scenario: Check whether user is able to quickly add new item
	And User selects customer
	And Choose location as consignment
	And User scrolls down to new item button
	And User clicks new item button
	And User enters SKU
	And User enters Item name
	And User clicks submit button in new item creation
	Then Item should be added to order items table	
	
@Regression	
Scenario: Check whether user is able to close item add popup
	And User selects customer
	And Choose location as consignment
	And User scrolls down to new item button
	And User clicks new item button
	And User closed item add popup
	
@Regression	
Scenario Outline: Check whether system throws "Unexpected value provided!" while entering negative values, Zero and alphabets in Quantity field in new item popup
	And User selects customer
	And Choose location as consignment
	And User scrolls down to new item button
	And User clicks new item button 	
	And User enters SKU
	And User enters Item name
	And User enters quantity "<Quantity>"
	And User clicks outside the quantity field
	Then System should throw "Unexpected value provided!"
	
Examples: 
	| Quantity |
	| abcd	   |
	|	0	   |
	|	-1	   |
	| !@#	   |				

@Regression
Scenario Outline: Check whether system throws error while entering more than 100% and less than 0% in discount in new item popup
	And User selects customer
	And Choose location as consignment
	And User scrolls down to new item button
	And User clicks new item button 	
	And User enters SKU
	And User enters Item name
	And User enters quantity "1"
	And User enters discount "<Discount>"
	And User enters unit price 
	And User clicks submit button in new item creation
	Then System should throw "<Result>"
	
Examples: 
	| Discount | Result |
	| -1% |	Unexpected value provided! |
	| 101% | Unexpected value provided! |
	
@Regression
Scenario: Check whether system throws error while entering discount amount less than 0 in new item popup
	And User selects customer
	And Choose location as consignment
	And User scrolls down to new item button
	And User clicks new item button 	
	And User enters SKU
	And User enters Item name
	And User enters quantity "1"
	And User enters discount "-1"
	And User enters unit price 
	And User clicks submit button in new item creation
	Then System should throw "Unexpected value provided!"
	 	
@Regression
Scenario: Check whether system throws error while entering discount amount greater than total amount in new item popup	
	And User selects customer
	And Choose location as consignment
	And User scrolls down to new item button
	And User clicks new item button 	
	And User enters SKU
	And User enters Item name
	And User enters quantity "1"
	And User enters discount "51"
	And User enters unit price 
	And User clicks submit button in new item creation
	Then System should throw "Unexpected value provided!"
	
@Regression	@Sanity
Scenario: Check whether user is able to create new item with discount percentage in new item popup
	And User selects customer
	And Choose location as consignment
	And User scrolls down to new item button
	And User clicks new item button 	
	And User enters SKU
	And User enters Item name
	And User enters quantity "1"
	And User enters discount "50%"
	And User enters unit price 
	And User clicks submit button in new item creation
	Then Item should be added to order items table with discount
	
@Regression @Sanity
Scenario: Check whether user is able to create new item with discount amount in new item popup
	And User selects customer
	And Choose location as consignment
	And User scrolls down to new item button
	And User clicks new item button 	
	And User enters SKU
	And User enters Item name
	And User enters quantity "1"
	And User enters discount "25"
	And User enters unit price 
	And User clicks submit button in new item creation
	Then Item should be added to order items table with discount 	
	
		
	
	