Feature: SaleOrderList

@Regression 
Scenario: Check whether user is able to delete the sale order	
	Given User is on login page
	When User enters email as "testra.j409@gmail.com" and password as "Cbsinf0."
	And User clicks login button
	And User clicks sales from side menu
	And User clicks sale orders
	And User clicks new order button
	And User chooses customer in new sale order page
	And User selects shipping address
	And User selects items
	And User clicks save sale order button
	Then System throws "Sale Order successfully added"
	When mouse hover on toast
	And User clicks the Action icon
	And User clicks Delete sale order
	And User selects yes in delete popup
	Then System throws "Sale Order successfully deleted"
	
@Regression 
Scenario: Check whether sale order can be emailed
	Given User is on login page
	When User enters email as "testra.j409@gmail.com" and password as "Cbsinf0."
	And User clicks login button
	And User clicks sales from side menu
	And User clicks sale orders
	And User clicks the Action icon
	And User clicks email sale order
	And User clicks Send Email button
	Then System throws "Email successfully sent!"		
	
@Regression 	
Scenario: Check whether user is able to create invoice for the sale order and track till delivery
	Given User is on login page
	When User enters email as "testra.j409@gmail.com" and password as "Cbsinf0."
	And User clicks login button
	And User clicks sales from side menu
	And User clicks sale orders
	And User clicks new order button
	And User chooses customer in new sale order page
	And User selects shipping address
	And User selects items
	And User clicks save sale order button
	Then System throws "Sale Order successfully added"
	When mouse hover on toast
	And User clicks the Action icon
	And User clicks create invoice
	And User switches to new window
	And Click save sale button
	Then Invoice created successfully
	When User clicks sales from side menu from invoice list page
	And User clicks sale orders
	Then Verify tick mark for invoice
	When User clicks sales from side menu from invoice list page
	And Clicks Invoice
	And User clicks the Action icon
	And User clicks Add Payment
	And User clicks date field twice to make calendar disappear
	And User clicks date field twice to make calendar disappear
	And User chooses Cash in payby option
	And User clicks save payment option
	Then System should throw "Payment has been successfully added."
	When User clicks sales from side menu from invoice list page
	And User clicks sale orders
	And User clicks ALL
	Then Verify tick mark for payment
	When User clicks sales from side menu from invoice list page
	And Clicks Invoice
	And User clicks the Action icon
	And User clicks Add to Delivery option
	And User switches to new window
	And User scrolls down to delivery status option 
	And User saves the delivery  
	And User clicks sales from side menu
	And User clicks sale orders
	Then Verify packed status
	When User clicks ALL
	When User clicks the Action icon
	And User clicks item pick list from actions menu
	And User updates quantity
	And User clicks the submit button
	Then System throws "Picked quantity updated successfully"
	When User clicks outside
	Then Verify packed status after pick
	When User clicks deliveries from side menu
	And Click the status
	And User updates delivery status to ReadyToShip
	And User clicks update delivery status button
	And User clicks sales from side menu
	And User clicks sale orders
	And User clicks ALL
	Then Verify ReadyToShip status
	When User clicks deliveries from side menu
	And Click the status
	And User updates delivery status to Shipped
	And User clicks update delivery status button
	And User clicks sales from side menu
	And User clicks sale orders
	And User clicks ALL
	Then Verify Shipped status
	When User clicks deliveries from side menu
	And Click the status
	And User updates delivery status to Delivered
	And User clicks update delivery status button
	And Refresh the page
	And User clicks sales from side menu
	And User clicks sale orders
	And User clicks ALL
	Then Verify Delivered status
	
@Regression 	
Scenario: Check whether user can delete sale orders in bulk
	Given User is on login page
	When User enters email as "testra.j409@gmail.com" and password as "Cbsinf0."
	And User clicks login button
	And User clicks sales from side menu
	And User clicks sale orders
	And User clicks more in sale order
	And User chooses delete sale order
	And User selects SO by checkboxes
	And User clicks delete button for SO
	And User selects yes in bulk delete popup
	Then System throws "Sale Orders successfully deleted"
	
@Regression
Scenario: Check whether adding sale order to delivery without invoicing  throws "Kindly Invoice the Sale order"
	Given User is on login page
	When User enters email as "testra.j409@gmail.com" and password as "Cbsinf0."
	And User clicks login button
	And User clicks sales from side menu
	And User clicks sale orders
	And User clicks new order button
	And User chooses customer in new sale order page
	And User selects shipping address
	And User selects items
	And User clicks save sale order button
	Then System throws "Sale Order successfully added"
	When User clicks more in sale order
	And User chooses add to delivery
	And User selects SO by checkboxes for delivery
	And User clicks Convert to DO button
	Then System throws alert "Kindly Invoice the Sale order"
	 	
@Regression 	
Scenario: Check whether adding the already added invoice to delivery throws "Invoice already added to deliveries"
	Given User is on login page
	When User enters email as "testra.j409@gmail.com" and password as "Cbsinf0."
	And User clicks login button
	And User clicks sales from side menu
	And User clicks sale orders
	And User clicks new order button
	And User chooses customer in new sale order page
	And User selects shipping address
	And User selects items
	And User clicks save sale order button
	Then System throws "Sale Order successfully added"
	When mouse hover on toast
	And User clicks the Action icon
	And User clicks create invoice
	And User switches to new window
	And Click save sale button
	Then Invoice created successfully
	When User clicks sales from side menu from invoice list page
	And User clicks sale orders
	Then Verify tick mark for invoice
	When User clicks sales from side menu from invoice list page
	And Clicks Invoice
	And User clicks the Action icon
	And User clicks Add Payment
	And User clicks date field twice to make calendar disappear
	And User clicks date field twice to make calendar disappear
	And User chooses Cash in payby option
	And User clicks save payment option
	Then System should throw "Payment has been successfully added."
	When User clicks sales from side menu from invoice list page
	And User clicks sale orders
	And User clicks ALL
	Then Verify tick mark for payment
	When User clicks sales from side menu from invoice list page
	And Clicks Invoice
	And User clicks the Action icon
	And User clicks Add to Delivery option
	And User switches to new window
	And User scrolls down to delivery status option 
	And User saves the delivery  
	And User clicks sales from side menu
	And User clicks sale orders
	And User clicks ALL
	And User clicks more in sale order
	And User chooses add to delivery
	And User selects SO by checkboxes for delivery
	And User clicks Convert to DO button	
	Then System throws alert as "Invoice already added to deliveries"
	
@Regression @Test	
Scenario: Check whether system throws "Delivery successfully added" after adding Sale orders to deliveries in bulk after invoicing
	Given User is on login page
	When User enters email as "testra.j409@gmail.com" and password as "Cbsinf0."
	And User clicks login button
	And User clicks sales from side menu
	And User clicks sale orders
	And User clicks new order button
	And User chooses customer in new sale order page
	And User selects shipping address
	And User selects items
	And User clicks save sale order button
	Then System throws "Sale Order successfully added"
	When mouse hover on toast
	And User clicks the Action icon
	And User clicks create invoice
	And User switches to new window
	And Click save sale button
	Then Invoice created successfully
	When User clicks sales from side menu from invoice list page
	And User clicks sale orders
	And User clicks more in sale order
	And User chooses add to delivery
	And User selects SO by checkboxes for delivery
	And User clicks Convert to DO button	
	Then System throws "Delivery successfully added" 	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	