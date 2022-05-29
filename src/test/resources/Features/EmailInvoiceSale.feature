Feature: EmailInvoiceSale

Background: Login and navigate to invoice sale page
	Given User is on login page
	When User enters email as "testra.j409@gmail.com" and password as "Cbsinf0."
	And User clicks login button
	And User is on Dashboard page and clicks sales and invoice from side menu
	And User navigates to invoice sale
	And User clicks New Invoice Sale button
	And User navigates to invoice creation page and enters invoice details
	And Click save sale button
	Then Invoice created successfully
	When User clicks the Action icon
	And User clicks Email invoice sale
	
@Regression @Sanity
Scenario: Check whether invoice sale can be emailed
	And User clicks Send Email button
	Then System throws "Email successfully sent!"	
	
@Regression 
Scenario: Check whether emptying to field and subject field throws "Please enter/select a value"
	And Empty To field
	Then Throwss "Please enter/select a value"	
	When Empty Subject field
	Then Throwss "Please enter/select a value"	
	
@Regression
Scenario: Check whether system throws alert on entering invalid email ID and entering one character in subject field
	And Enter invalid emailID
	Then Throwss alert "Please enter a valid email address"
	When Enter a character in subject field
	Then The Alert is "Please enter/select a value matching the pattern"
	
@Regression 	
Scenario: Check whether user can close email popup
	And User closes email popup
	Then Verifies it	
	











	
	
