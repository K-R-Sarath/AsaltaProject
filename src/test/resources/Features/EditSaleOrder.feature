Feature: EditSaleOrder

Background: Login and navigate to edit sale order page
	Given User is on login page
	When User enters email as "testra.j409@gmail.com" and password as "Cbsinf0."
	And User clicks login button
	And User clicks sales from side menu
	And User clicks sale orders
	And User clicks the Action icon
	And User clicks Edit Sale Order
	
@Regression 
Scenario: Check whether user is able to add another item 
	And User selects items
	And User clicks edit sale order button
	Then System throws "Sale Order successfully updated"
	
@Regression 
Scenario: Check whether user is able to delete the item
	And User deletes item
	And User clicks edit sale order button
	Then System throws "Sale Order successfully updated"
	
@Regression 
Scenario: Check whether system throws "Sale Order No must be unique" when we duplicate the sale order number	
	And User enters duplicate sale order number
	And User clicks edit sale order button
	Then Alert is "Sale Order No must be unique"
	
@Regression
Scenario: Check whether revisions are getting stored when we edit and save sale order
	And Scroll to revisions field
	And Click revisions field
	And Get revisions list
	And Choose revision
	And User selects items
	And User clicks edit sale order button
	Then System throws "Sale Order successfully added"
	And User clicks the Action icon
	And User clicks Edit Sale Order
	And Scroll to revisions field
	And Click revisions field
	And Now get revisions list
	Then Revisions list should be added by one more revision
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
			