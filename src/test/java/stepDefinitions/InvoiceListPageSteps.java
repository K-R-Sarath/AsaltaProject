package stepDefinitions;

import java.util.Map;

import org.junit.Assert;

import cucumber.TestContext;
import io.cucumber.java.en.*;
import pageObjects.InvoiceListPage;

public class InvoiceListPageSteps {

	TestContext testContext;
	InvoiceListPage invoice;
	
	public InvoiceListPageSteps(TestContext context) {
		testContext = context;
		invoice = testContext.getPageObjectManager().getInvoiceListPage();
	}
	
	@When("User navigates to invoice sale")
	public void user_navigates_to_invoice_sale() {
		
	}
	
	@When("User clicks New Invoice Sale button")
	public void user_clicks_new_invoice_sale_button() {
		Map<Boolean,String> status = invoice.clickNewInvoiceButton();
		Assert.assertTrue(status.get(false),status.containsKey(true));
	}
	
	//Check whether user is able to edit quantity in invoice
	

	@When("User clicks the Action icon")
	public void user_clicks_the_action_icon() {
	    Map<Boolean,String> status = invoice.clickActionIcon();
	    Assert.assertTrue(status.get(false), status.containsKey(true));
	}
	@When("User clicks Edit Invoice Sale")
	public void user_clicks_edit_invoice_sale() {
	    Map<Boolean,String> status = invoice.selectEditOption();
	    Assert.assertTrue(status.get(false), status.containsKey(true));
	}
	
	//Check whether system displays "No data available" in view payments, if total amount and outstanding amount are equal

	@When("If total amount and outstanding amount are equal")
	public void if_total_amount_and_outstanding_amount_are_equal() {
	    if((invoice.getTotalAmount()).equals(invoice.getOutstandingAmount())) {
	    	Assert.assertTrue(true);
	    }else {
	    	Assert.assertTrue(false);
	    }
	}
	
	@When("User clicks view payments")
	public void user_clicks_view_payments() {
	    Map<Boolean,String> status = invoice.selectViewPayments();
	    Assert.assertTrue(status.get(false),status.containsKey(true));
	}
	
	//Check whether system throws error while making amount field to zero in Add Payment

	@When("User clicks Add Payment")
	public void user_clicks_add_payment() {
	    Map<Boolean,String> status = invoice.selectAddPayments();
	    Assert.assertTrue(status.get(false),status.containsKey(true));
	}
	
	//Check whether status changes to Partially paid when 50% or <50% of amount is paid

	@Then("Status should change to {string}")
	public void status_should_change_to(String status) {
	    String stat = invoice.currentStatus();
	    if(stat.equalsIgnoreCase(status)) {
	    	Assert.assertTrue(true);
	    }else {
	    	Assert.assertTrue(false);
	    }
	    
	}
	
	//Check whether status changes to Paid when oustanding amount is 0
	
	@When("If outstanding amount is zero")
	public void if_outstanding_amount_is_zero() {
		Long stats = invoice.getOutstandingAmount();
	    if(stats == 0) {
	    	Assert.assertTrue(true);
	    }else {
	    	Assert.assertTrue(false);
	    }
	}
	@Then("Status should be {string}")
	public void status_should_be(String status) {
	    String currStatus = invoice.currentStatus();
	    if(currStatus.equalsIgnoreCase(status)) {
	    	Assert.assertTrue(true);
	    }else {
	    	Assert.assertTrue(false);
	    }
	}

	//Check whether Invoice sale details can be viewed while clicking on the invoice in list page

	@Then("User captures invoice number and User clicks invoice and verifies the invoice number")
	public void user_captures_invoice_number_and_user_clicks_invoice_and_verifies_the_invoice_number() {
	    String invoiceNumberFromListPage = invoice.getInvoiceNumberFromListPage();
	    Map<Boolean,String> status = invoice.clickOnInvoice();
	    Assert.assertTrue(status.get(false), status.containsKey(true));
	    String verifyInvoiceNumber = invoice.verifyInvoiceNumber();
	    if(invoiceNumberFromListPage.equalsIgnoreCase(verifyInvoiceNumber)) {
	    	Assert.assertTrue(true);
	    }else {
	    	Assert.assertTrue(false);
	    }
	}

	//Check whether Invoice sale details can be viewed by clicking Invoice sale details from action menu

	@Then("User captures invoice number & clicks invoice sale details from action menu and verifies it")
	public void user_captures_invoice_number_clicks_invoice_sale_details_from_action_menu_and_verifies_it() {
		String invoiceNumberFromListPage = invoice.getInvoiceNumberFromListPage();
		Map<Boolean,String> status = invoice.clickActionIcon();
	    Assert.assertTrue(status.get(false), status.containsKey(true));
	    Map<Boolean,String> status1 = invoice.selectInvoiceSaleDetails();
	    Assert.assertTrue(status1.get(false), status1.containsKey(true));
	    String verifyInvoiceNumber = invoice.verifyInvoiceNumber();
	    if(invoiceNumberFromListPage.equalsIgnoreCase(verifyInvoiceNumber))	{
	    	Assert.assertTrue(true);
	    }else {
	    	Assert.assertTrue(false);
	    }
	}
	
	//Check whether clicking Invoice Link from actions menu opens new tab and displays invoice details with options to pay via paypal,stripe

	@When("User clicks Invoice link from action menu")
	public void user_clicks_invoice_link_from_action_menu() {
		Map<Boolean,String> status1 = invoice.selectInvoiceLink();
	    Assert.assertTrue(status1.get(false), status1.containsKey(true));
	}
	
	@Then("User verifies invoice link")
	public void user_verifies_invoice_link() {
	    Map<Boolean,String> status = invoice.switchToNewWindow();
	    Assert.assertTrue(status.get(false), status.containsKey(true));
	    Map<Boolean,String> status1 = invoice.verifyLink();
	    Assert.assertTrue(status1.get(false), status1.containsKey(true));
	}
	
	//Check whether invoice can be added to delivery list irrespective of invoice payments

	@When("User clicks Add to Delivery option")
	public void user_clicks_add_to_delivery_option() {
	   Map<Boolean,String> status = invoice.clickAddToDelivery();
	   Assert.assertTrue(status.get(false), status.containsKey(true));
	}
	
	//Check whether system throws error, if we make return invoice for cancelled invoice

	@When("User clicks Return invoice sale")
	public void user_clicks_return_invoice_sale() {
	    Map<Boolean,String> status = invoice.returnInvoiceSale();
	    Assert.assertTrue(status.get(false), status.containsKey(true));
	}















	
	




}
