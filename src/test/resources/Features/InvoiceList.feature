Feature: InvoiceList

Background: Login and navigate to new invoice sale page
	Given User is on login page
	When User enters email as "testra.j409@gmail.com" and password as "Cbsinf0."
	And User clicks login button
	And User is on Dashboard page and clicks sales and invoice from side menu
	And User navigates to invoice sale
	
@Regression 
Scenario: Check whether clicking DUE in invoice list page, displays invoices which are DUE
	And User clicks Due in top of the page
	Then Paginate and get values
	
@Regression 
Scenario: Check whether clicking PAID in invoice list page, displays invoices which are PAID
	And User clicks Paid in top of the page
	Then Paginate and get values for PAID status		
	
@Regression 
Scenario: Check whether clicking PARTIALLY PAID in invoice list page, displays invoices which are PARTIALLY PAID
	And User clicks Partially Paid in top of the page
	Then Paginate and get values for PARTIALLY PAID status	

@Regression 
Scenario: Check whether clicking RETURNED in invoice list page, displays invoices which are RETURNED
	And User clicks Returned in top of the page
	Then Paginate and get values for RETURNED status
	
@Regression
Scenario: Check whether clicking CANCELLED in invoice list page, displays invoices which are CANCELLED
	And User clicks Cancelled in top of the page
	Then Paginate and get values for CANCELLED status
	
@Regression
Scenario: Check whether clicking ALL in invoice list page, displays ALL invoices 
	And User clicks All in top of the page
	Then Paginate and get values for ALL status	
	
@Regression
Scenario: Check whether pagination works in both forward and backward directions	 
	Then User paginates in forward direction and Verify whether NEXT button is disabled while on last page
	Then User paginates in backward direction and Verify whether PREVIOUS button is disabled while on first page	
	
@Regression 
Scenario: Check whether choosing Display 10 in display dropdown lists only 10 invoices per page
	And User clicks display option
	And User chooses Display10
	Then Verify only ten invoices displayed per page
	And Only ten invoices present in table
	
@Regression
Scenario: Check whether choosing Display 25 in display dropdown lists only 25 invoices per page
	And User clicks display option
	And User chooses Display25
	Then Verify only twenty five invoices displayed per page
	And Only twenty five invoices present in table	

@Regression
Scenario: Check whether choosing Display 50 in display dropdown lists only 50 invoices per page
	And User clicks display option
	And User chooses Display50
	Then Verify only fifty invoices displayed per page
	And Only fifty invoices present in table	
	
@Regression 
Scenario: Check whether choosing Display 100 in display dropdown lists only 100 invoices per page
	And User clicks display option
	And User chooses Display100
	Then Verify only hundred invoices displayed per page
	And Only hundred invoices present in table
	
@Regression	
Scenario: Check whether filtering invoices by date displays only invoices of filtered date		
	And User clicks date field
	And User clicks from date field and enter date
	And User clicks to date field and enter date
	And User clicks Apply button
	Then Verify invoices date
	
@Regression
Scenario: Check whether status can be sorted in Ascending order
	And User clicks Status
	Then User gets obtained list and sorts it in Ascending order and verify the sorted list with obtained list
	
@Regression
Scenario: Check whether status can be sorted in Descending order	
	And User clicks Status
	And User clicks Status
	Then User gets obtained list and sorts it in Descending order and verify the sorted list with obtained list
	
@Regression 	
Scenario: Check whether channels can be sorted in Ascending order
	And User clicks Channels
	Then User gets obtained list of channels and sorts it in Ascending order and verify the sorted list with obtained list	
	
@Regression 
Scenario: Check whether channels can be sorted in descending order
	And User clicks Channels
	And User clicks Channels
	Then User gets obtained list of channels and sorts it in descending order and verify the sorted list with obtained list
	
@Regression
Scenario: Check whether channel order number can be sorted in ascending order
	And User clicks channel order no
	Then User gets obtained list of channel order number and sorts in in ascending order and verify the sorted list with obtained list	
	
@Regression	
Scenario: Check whether channel order number can be sorted in descending order
	And User clicks channel order no
	And User clicks channel order no
	Then User gets obtained list of channel order number and sorts it in descending order and verify the sorted list with obtained list
	
@Regression
Scenario: Check whether invoice numbers can be sorted in ascending order
	And User clicks invoice
	Then User gets obtained list of invoices and sorts it in ascending order and verify the sorted list with the obtained list		
		
@Regression 
Scenario: Check whether invoice numbers can be sorted in descending order
	And User clicks invoice
	And User clicks invoice
	Then User gets obtained list of invoices and sorts it in descending order and verify the sorted list with the obtained list	
	
@Regression
Scenario: Check whether billers can be sorted in ascending order			
	And User clicks billers
	Then User gets obtained list of billers and sorts it in ascending order and verify the sorted list with the obtained list
	
@Regression 
Scenario: Check whether billers can be sorted in descending order			
	And User clicks billers
	And User clicks billers
	Then User gets obtained list of billers and sorts it in descending order and verify the sorted list with the obtained list	
	
@Regression 
Scenario: Check whether customers can be sorted in ascending order
	And User clicks customers
	Then User gets obtained list of customers and sorts it in ascending order and verify the sorted list with the obtained list	
	
@Regression 
Scenario: Check whether customers can be sorted in descending order
	And User clicks customers
	And User clicks customers
	Then User gets obtained list of customers and sorts it in descending order and verify the sorted list with the obtained list	
	
@Regression
Scenario: Check whether total amount can be sorted in ascending order	
	And User clicks total
	Then User gets obtained list of total amounts and sorts it in ascending order and verify the sorted list with the obtained list
	
@Regression
Scenario: Check whether total amount can be sorted in descending order 
	And User clicks total
	And User clicks total
	Then User gets obtained list of total amounts and sorts it in descending order and verify the sorted list with the obtained list	
	
@Regression
Scenario: Check whether outstanding amount can be sorted in ascending order
	And User clicks outstanding
	Then User gets obtained list of outstanding amounts and sorts it in ascending order and verify the sorted list with the obtained list
	
@Regression 
Scenario: Check whether outstanding amount can be sorted in descending order
	And User clicks outstanding
	And User clicks outstanding
	Then User gets obtained list of outstanding amounts and sorts it in descending order and verify the sorted list with the obtained list
	
@Regression 
Scenario: Check whether filtering invoices by invoice sales channel displays invoices only of the filtered channel	
	And User clicks channels dropdown
	And User selects Invoice sales in channels
	Then Only invoice sales channel invoices are displayed
	
@Regression 	
Scenario: Check whether filtering invoices by pos channel displays invoices only of the filtered channel	
	And User clicks channels dropdown
	And User selects pos in channels
	Then Only pos channel invoices are displayed	
	
@Regression	
Scenario: Check whether filtering invoices by ecommerce channel displays invoices only of the filtered channel	
	And User clicks channels dropdown
	And User selects ecommerce in channels
	Then Only ecommerce channel invoices are displayed		
	
@Regression 	
Scenario: Check whether filtering invoices by woocommerce channel displays invoices only of the filtered channel	
	And User clicks channels dropdown
	And User selects woocommerce in channels
	Then Only woocommerce channel invoices are displayed
	
@Regression 	
Scenario: Check whether filtering invoices by opencart channel displays invoices only of the filtered channel	
	And User clicks channels dropdown
	And User selects opencart in channels
	Then Only opencart channel invoices are displayed	
	
@Regression	
Scenario: Check whether filtering invoices by shopify channel displays invoices only of the filtered channel	
	And User clicks channels dropdown
	And User selects shopify in channels
	Then Only shopify channel invoices are displayed	
	
@Regression 	
Scenario: Check whether filtering invoices by lazada channel displays invoices only of the filtered channel	
	And User clicks channels dropdown
	And User selects lazada in channels
	Then Only lazada channel invoices are displayed
	
@Regression
Scenario: Check whether filtering invoices by shopee channel displays invoices only of the filtered channel	
	And User clicks channels dropdown
	And User selects shopee in channels
	Then Only shopee channel invoices are displayed	

@Regression 	
Scenario: Check whether search is working for channel order number
	And User clicks channel order no
	And User clicks channel order no
	And User searches for channel order no
	Then Searched channel order no is displayed
	
@Regression
Scenario: Check whether search is working for invoices
	And User searches for invoice
	Then Searched invoice is displayed	
	
@Regression 
Scenario: Check whether search is working for billers	
	And User searches for biller
	Then Searched biller is displayed 
	
@Regression 
Scenario: Check whether search is working for customers
	And User searches for customer
	Then Searched customer is displayed 	
	
@Regression 
Scenario: Check whether search is working for total amount
	And User searches for total amount
	Then Searched total amount is displayed		
	
@Regression 
Scenario: Check whether search is working for outstanding amount
	And User searches for outstanding amount
	Then Searched outstanding amount is displayed					
	
@Regression
Scenario: Check whether multiple invoices can be added to delivery using more option
	And User clicks More button
	And User chooses add to delivery option
	And User selects invoices
	And User clicks convert to DO button
	Then System throws "Delivery successfully added"	
	
	
	
		
	
	
	
	
	