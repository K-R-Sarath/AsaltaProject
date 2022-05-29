Feature: InvoicePayments

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

@Regression 
Scenario: Check whether system displays "No data available" in view payments, if total amount and outstanding amount are equal
	And If total amount and outstanding amount are equal
	And User clicks view payments
	Then System should display "No data available"
	
@Regression 
Scenario: Check whether system throws error "Please enter/select a value" while making amount field to zero in Add Payment
	And User clicks Add Payment
	And User clicks date field twice to make calendar disappear
	And User clicks date field twice to make calendar disappear
	And User makes amount field to zero
	And User clicks out of amount field
	Then Throwss "Please enter/select a value"	
	
@Regression 
Scenario: Check whether system throws error "Please enter/select a value" while making date field empty in AddPayments
	And User clicks Add Payment
	And User deletes the date
	And User clicks out of amount field
	Then Throws field validation "Please enter/select a value"	
	
@Regression	
Scenario: Check whether payment fails when choosing gift card in payby option and not entering gift voucher number
	And User clicks Add Payment
	And User clicks date field twice to make calendar disappear
	And User clicks date field twice to make calendar disappear
	And User chooses gift card in payby option
	And User clicks save payment option
	Then Throws validation "Payment failed!"	
	
@Regression @Sanity
Scenario: Check whether user is able to do payment by Cash
	And User clicks Add Payment
	And User clicks date field twice to make calendar disappear
	And User clicks date field twice to make calendar disappear
	And User chooses Cash in payby option
	And User clicks save payment option
	Then System should throw "Payment has been successfully added."
	And User clicks the Action icon
	And User clicks view payments
	And User verifies the payment 
	And User deletes the payment
	And System should throw "Payment successfully deleted"
	
@Regression @Sanity
Scenario: Check whether user is able to do payment by Cheque
	And User clicks Add Payment
	And User clicks date field twice to make calendar disappear
	And User clicks date field twice to make calendar disappear
	And User chooses Cheque in payby option
	And User clicks save payment option
	Then System should throw "Payment has been successfully added."
	And User clicks the Action icon
	And User clicks view payments
	And User verifies the payment 
	And User deletes the payment
	And System should throw "Payment successfully deleted"	
			
@Regression @Sanity
Scenario: Check whether user is able to do payment by Credit Card
	And User clicks Add Payment
	And User clicks date field twice to make calendar disappear
	And User clicks date field twice to make calendar disappear
	And User chooses Credit Card in payby option
	And User clicks save payment option
	Then System should throw "Payment has been successfully added."
	And User clicks the Action icon
	And User clicks view payments
	And User verifies the payment 
	And User deletes the payment
	And System should throw "Payment successfully deleted"	
			
@Regression @Sanity
Scenario: Check whether user is able to do payment by Others
	And User clicks Add Payment
	And User clicks date field twice to make calendar disappear
	And User clicks date field twice to make calendar disappear
	And User chooses Others in payby option
	And User clicks save payment option
	Then System should throw "Payment has been successfully added."
	And User clicks the Action icon
	And User clicks view payments
	And User verifies the payment 
	And User deletes the payment
	And System should throw "Payment successfully deleted"	
	
@Regression @Sanity
Scenario: Check whether user is able to do payment by Gift Card
	And User clicks Add Payment	
	And User clicks date field twice to make calendar disappear
	And User clicks date field twice to make calendar disappear
	And User chooses Gift Card in payby option1
	And User enters Voucher number as "8558745271928565"
	And User clicks save payment option
	Then System should throw "Payment has been successfully added."
	And User clicks the Action icon
	And User clicks view payments
	And User verifies the payment 

@Regression 
Scenario Outline: Check whether system throws alert "Gift Voucher number is incorrect or expired." on entering invalid voucher number	
	And User clicks Add Payment	
	And User clicks date field twice to make calendar disappear
	And User clicks date field twice to make calendar disappear
	And User chooses Gift Card in payby option1
	And User enter Voucher number as "<Voucher>"
	Then It throws alert "Gift Voucher number is incorrect or expired."	
	
Examples:
	|	Voucher		|
	|	1234567890	|
	|	asdubivyuhb	|	
	
@Regression @Sanity
Scenario: Check whether user is able to attach document while doing payment	
	And User clicks Add Payment	
	And User clicks date field twice to make calendar disappear
	And User clicks date field twice to make calendar disappear
	And User chooses Gift Card in payby option1
	And User enters Voucher number as "8558745271928565"
	And User uploads the document
	And User clicks save payment option
	Then System should throw "Payment has been successfully added."
	And User clicks the Action icon
	And User clicks view payments
	And User verifies attachment
	
@Regression @Sanity
Scenario: Check whether status is Due when total amount and outstanding amount are equal		
	And If total amount and outstanding amount are equal
	Then Status should be "Due"	
	
@Regression @Sanity
Scenario: Check whether status changes to Partially paid when 50% or <50% of amount is paid
	And User clicks Add Payment
	And User clicks date field twice to make calendar disappear
	And User clicks date field twice to make calendar disappear
	And User chooses Cash in payby option
	And User makes amount field to zero
	And User enters amount as "25" 
	And User clicks save payment option
	Then System should throw "Payment has been successfully added."
	And Status should change to "Partially Paid"
	
@Regression @Sanity
Scenario: Check whether status is Paid when oustanding amount is zero
	And User clicks Add Payment
	And User clicks date field twice to make calendar disappear
	And User clicks date field twice to make calendar disappear
	And User chooses Cash in payby option
	And User clicks save payment option
	And If outstanding amount is zero
	Then Status should be "Paid"
	
@Regression	
Scenario: Check whether paid amount can be deleted in view payments page 
	And User clicks Add Payment
	And User clicks date field twice to make calendar disappear
	And User clicks date field twice to make calendar disappear
	And User chooses Cash in payby option
	And User makes amount field to zero
	And User enters amount as "25" 
	And User clicks save payment option
	Then System should throw "Payment has been successfully added."	
	And User clicks the Action icon
	And User clicks view payments
	And User deletes the payment
	And System should throw "Payment successfully deleted"
	
@Regression @Sanity
Scenario: Check whether paid amount can be edited in view payments page
	And User clicks Add Payment
	And User clicks date field twice to make calendar disappear
	And User clicks date field twice to make calendar disappear
	And User chooses Cash in payby option
	And User makes amount field to zero
	And User enters amount as "25" 
	And User clicks save payment option
	Then System should throw "Payment has been successfully added."	
	And User clicks the Action icon
	And User clicks view payments
	And User clicks edit icon
	And User makes amount field to zero
	And User enters amount as "50"
	And User scrolls to save payment button	
	And User clicks save payment edit option
	And System should throw "Payment successfully updated"
	
@Regression @Sanity
Scenario: Check whether the payment can be viewed by the user
	And User clicks Add Payment
	And User clicks date field twice to make calendar disappear
	And User clicks date field twice to make calendar disappear
	And User chooses Cash in payby option
	And User makes amount field to zero
	And User enters amount as "25" 
	And User clicks save payment option
	Then System should throw "Payment has been successfully added."	
	And User clicks the Action icon
	And User clicks view payments
	And User clicks the view icon
	Then Payment slip can be viewed with "Stamp & Signature" option
		
@Regression @Sanity
Scenario: Check whether Invoice sale details can be viewed while clicking on the invoice in list page
	Then User captures invoice number and User clicks invoice and verifies the invoice number
	
@Regression @Sanity
Scenario: Check whether Invoice sale details can be viewed by clicking Invoice sale details from action menu	
	Then User captures invoice number & clicks invoice sale details from action menu and verifies it
	
@Regression @Sanity
Scenario: Check whether clicking Invoice Link from actions menu opens new tab and displays invoice details	
	And User clicks Invoice link from action menu
	Then User verifies invoice link
	
	
	
	
	
	