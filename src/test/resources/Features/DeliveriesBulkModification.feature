Feature: DeliveriesBulkModification

Background: Login and navigate to Deliveries
	Given User is on login page
	When User enters email as "testra.j409@gmail.com" and password as "Cbsinf0."
	And User clicks login button
	And User is Dashboard page and clicks Deliveries from side menu

@Regression 
Scenario: Check whether user can able to delete delivery from delivery list individually
	And User clicks the Action icon
	And User clicks Delete delivery option
	And User choose Yes in confirmation
	Then System throws "Delivery successfully deleted"
	
@Regression
Scenario: Check whether user is able to delete deliveries in bulk
	And User clicks More option
	And User clicks delete deliveries
	And User chooses deliveries
	And User clicks delete button
	And User chooses Yes in confirmation
	Then System throws "Deliveries successfully deleted"
	
@Regression 
Scenario: Check whether user is able to change status in bulk	
	And User clicks More option
	And User clicks Change Status
	And User chooses deliveries
	And User clicks Change status button
	And User selects status
	And User clicks update status button
	Then System throws "Delivery status successfully updated"
	
@Regression
Scenario: Check whether not selecting status and clicking update status button throws "Select Delivery Status"
	And User clicks More option
	And User clicks Change Status
	And User chooses deliveries
	And User clicks Change status button
	And User clicks update status button
	Then System throws "Select Delivery Status"	
	
@Regression 
Scenario: Check whether user is able to assign driver in bulk
	And User clicks More option
	And User clicks Assign to Driver
	And User chooses deliveries
	And User clicks Assign Driver button
	And User selects Driver
	And User clicks Assign Driver
	Then System throws "Driver successfully assigned"
	
@Regression
Scenario: Check whether not selecting driver and clicking assign driver button throws "Select Driver"
	And User clicks More option
	And User clicks Assign to Driver
	And User chooses deliveries
	And User clicks Assign Driver button
	And User clicks Assign Driver
	Then System throws "Select Driver"
	
		

















	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	