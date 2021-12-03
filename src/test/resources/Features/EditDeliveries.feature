Feature: EditDeliveries

@Regression 
Scenario: Check whether "Packed" delivery status introduces two new fields called "Packed By" and "Packed Date & Time"
	Given User is on login page
	When User enters email as "testra.j409@gmail.com" and password as "Cbsinf0."
	And User clicks login button
	And User is Dashboard page and clicks Deliveries from side menu
	And User clicks the Action icon
	And User cicks edit deliveries option
	And User scrolls down to delivery status
	And User changes delivery status to Packed
	Then two fields are newly introduced
	And User clicks save delivery button
	And Status should be changed to Packed in deliveries list page
	
@Regression
Scenario: Check when we change delivery status to "Ready To Ship", then in list page, status should change to Ready To Ship
	Given User is on login page
	When User enters email as "testra.j409@gmail.com" and password as "Cbsinf0."
	And User clicks login button
	And User is Dashboard page and clicks Deliveries from side menu
	And User clicks the Action icon
	And User cicks edit deliveries option
	And User scrolls down to delivery status
	And User changes delivery status to Ready To Ship
	Then User clicks save delivery button
	And Status should be changed to "Ready To Ship" in deliveries list page	
	
@Regression 
Scenario: Check when we change delivery status to "Shipped", then in list page, status should change to Shipped
	Given User is on login page
	When User enters email as "testra.j409@gmail.com" and password as "Cbsinf0."
	And User clicks login button
	And User is Dashboard page and clicks Deliveries from side menu
	And User clicks the Action icon
	And User cicks edit deliveries option
	And User scrolls down to delivery status
	And User changes delivery status to Shipped
	Then User clicks save delivery button
	And Status should be changed to "Shipped" in deliveries list page	
	
@Regression 
Scenario: Check when we change delivery status to "On Hold", then in list page, status should change to OnHold 	
	Given User is on login page
	When User enters email as "testra.j409@gmail.com" and password as "Cbsinf0."
	And User clicks login button
	And User is Dashboard page and clicks Deliveries from side menu
	And User clicks the Action icon
	And User cicks edit deliveries option
	And User scrolls down to delivery status
	And User changes delivery status to OnHold
	Then User clicks save delivery button
	And Status should be changed to "On Hold" in deliveries list page

@Regression	
Scenario: Check when we change delivery status to "Cancelled", then in list page, status should change to Cancelled 	
	Given User is on login page
	When User enters email as "testra.j409@gmail.com" and password as "Cbsinf0."
	And User clicks login button
	And User is Dashboard page and clicks Deliveries from side menu
	And User clicks the Action icon
	And User cicks edit deliveries option
	And User scrolls down to delivery status
	And User changes delivery status to Cancelled
	Then User clicks save delivery button
	And Status should be changed to "Cancelled" in deliveries list page

@Regression	
Scenario: Check when we change delivery status to "Delivered", then in list page, status should change to Delivered 	
	Given User is on login page
	When User enters email as "testra.j409@gmail.com" and password as "Cbsinf0."
	And User clicks login button
	And User is Dashboard page and clicks Deliveries from side menu
	And User clicks the Action icon
	And User cicks edit deliveries option
	And User scrolls down to delivery status
	And User changes delivery status to Delivered
	Then User clicks save delivery button
	And Status should be changed to "Delivered" in deliveries list page
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	