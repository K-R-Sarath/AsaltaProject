Feature: CreateQuotation

@Regression
Scenario: Check whether user is able to create quotation
	Given User is on login page
	When User enters email as "testra.j409@gmail.com" and password as "Cbsinf0."
	And User clicks login button
	And User clicks sales from side menu
	And User clicks quotations from side menu
	And User clicks New Quotation button
	And User chooses customer
	And User selects items
	And User scrolls down to save quote button
	And User clicks save quote button
	Then System throws "Quotation successfully added"
	
@Regression @Test	
Scenario: Check whether system throws "Please select above first" if we search item without selecting customer
	Given User is on login page
	When User enters email as "testra.j409@gmail.com" and password as "Cbsinf0."
	And User clicks login button
	And User clicks sales from side menu
	And User clicks quotations from side menu
	And User clicks New Quotation button	
	And User selects items
	Then Alert is thrown "Please select above first"
	
	