Feature: EditInvoice

Background: Login and navigate to invoice sale page
	Given User is on login page
	When User enters email as "testra.j409@gmail.com" and password as "Cbsinf0."
	And User clicks login button
	And User is on Dashboard page and clicks sales and invoice from side menu
	And User navigates to invoice sale
	And User clicks the Action icon
	And User clicks Edit Invoice Sale
	
@Regression @Sanity
Scenario: Check whether user is able to add another item 
	And User scrolls down to items
	And User enters item name and selects item
	And User Click save sale button
	Then Invoice updated successfully
	
@Regression @Sanity
Scenario: Check whether user is able to delete the item	
	And User scrolls down to items
	And User deletes item
	And User Click save sale button
	Then Invoice updated successfully
	
@Regression
Scenario: Check whether system throws "Invoice No must be unique" when we duplicate the invoice number
	And User enters duplicate invoice number
	And User Click save sale button
	Then Alert is "Invoice No must be unique"
	
@Regression @Sanity
Scenario: Check whether revisions are getting stored when we edit and save invoice
	And Scroll to revisions field
	And Click revisions field
	And Get revisions list
	And Choose revision
	And User enters item name and selects item
	And User Click save sale button
	Then Invoice updated successfully	
	When User clicks the Action icon
	And User clicks Edit Invoice Sale
	And Scroll to revisions field
	And Click revisions field
	And Now get revisions list
	Then Revisions list should be added by one more revision
	

	
	
	
	
	
	
	
	
	
	
	
	
	