Feature: AddDeliveries

Background: Login and navigate to invoice sale, create invoice and add to delivery
	Given User is on login page
	When User enters email as "testra.j409@gmail.com" and password as "Cbsinf0."
	And User clicks login button
	And User is on Dashboard page and clicks sales and invoice from side menu
	And User navigates to invoice sale
	And User clicks New Invoice Sale button
	And User navigates to invoice creation page and enters invoice details
	And Click save sale button
	And User clicks the Action icon
	And User clicks Add to Delivery option

@Regression
Scenario: Check whether invoice can be added to delivery list irrespective of invoice payments
	And User switches to new window
	And User scrolls down to delivery status option 
	And User saves the delivery
	Then Invoice should be added to delivery list with "Pending" status