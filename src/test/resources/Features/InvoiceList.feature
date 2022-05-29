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
	
@Regression @Test	
Scenario: Check whether filtering invoices by date displays only invoices of filtered date		
	And User clicks date field
	And User clicks from date field and enter date
	And User clicks to date field and enter date
	And User clicks Apply button
	Then Verify invoices date
		
		
	
	
	
	
	
	
	