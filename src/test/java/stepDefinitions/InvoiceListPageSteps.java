package stepDefinitions;

import java.text.ParseException;
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

	//
	
	@Then("Invoice status is {string}")
	public void invoice_status_is(String invoiceStatus) {
	    String status = invoice.invoiceStatus();
	    if(status.equalsIgnoreCase(invoiceStatus)){
	    	Assert.assertTrue(true);
	    } else {
	    	Assert.assertTrue(false);
	    }
	}

	//Check whether clicking invoice sales in breadcrumbs in new invoice sale page navigates to invoice list page
	
	@Then("It should navigate to invoice list page")
	public void it_should_navigate_to_invoice_list_page() {
	    String status = invoice.getInvoiceListPageBreadcrumb();
	    if(status.equalsIgnoreCase("Sales / Invoices (All Locations)"))	{
	    	Assert.assertTrue(true);
	    } else {
	    	Assert.assertTrue(false);
	    }
	}

	//Check whether invoice sale can be emailed
	
	@When("User clicks Email invoice sale")
	public void user_clicks_email_invoice_sale() {
		Map<Boolean,String> status1 = invoice.selectEmailInvoiceSale();
	    Assert.assertTrue(status1.get(false), status1.containsKey(true));
	}
	
	//Check whether clicking DUE in invoice list page, displays invoices which are DUE
	
	@When("User clicks Due in top of the page")
	public void user_clicks_due_in_top_of_the_page() {
		Map<Boolean,String> status1 = invoice.clickDueInInvoice();
	    Assert.assertTrue(status1.get(false), status1.containsKey(true));
	}
	
	@Then("Paginate and get values")
	public void paginate_and_get_values() throws Exception {
		boolean status = invoice.paginateAndGetValues();
		if(status) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}

	//Check whether clicking PAID in invoice list page, displays invoices which are PAID
	
	@When("User clicks Paid in top of the page")
	public void user_clicks_paid_in_top_of_the_page() {
		Map<Boolean,String> status1 = invoice.clickPaidInInvoice();
	    Assert.assertTrue(status1.get(false), status1.containsKey(true));
	}
	
	@Then("Paginate and get values for PAID status")
	public void paginate_and_get_values_for_paid_status() throws Exception {
	   boolean status = invoice.paginateAndGetValuesForPaid();
	   if(status) {
		   Assert.assertTrue(true);
	   } else {
		   Assert.assertTrue(false);
	   }
	}

	//Check whether clicking PARTIALLY PAID in invoice list page, displays invoices which are PARTIALLY PAID
	
	@When("User clicks Partially Paid in top of the page")
	public void user_clicks_partially_paid_in_top_of_the_page() {
		Map<Boolean,String> status1 = invoice.clickPartiallyPaidInInvoice();
	    Assert.assertTrue(status1.get(false), status1.containsKey(true));
	}
	
	@Then("Paginate and get values for PARTIALLY PAID status")
	public void paginate_and_get_values_for_partially_paid_status() throws Exception {
		boolean status = invoice.paginateAndGetValuesForPartiallyPaid();
		   if(status) {
			   Assert.assertTrue(true);
		   } else {
			   Assert.assertTrue(false);
		   }
	}

	//Check whether clicking RETURNED in invoice list page, displays invoices which are RETURNED
	
	@When("User clicks Returned in top of the page")
	public void user_clicks_returned_in_top_of_the_page() {
		Map<Boolean,String> status1 = invoice.clickReturnedInInvoice();
	    Assert.assertTrue(status1.get(false), status1.containsKey(true));
	}
	
	@Then("Paginate and get values for RETURNED status")
	public void paginate_and_get_values_for_returned_status() throws Exception {
		boolean status = invoice.paginateAndGetValuesForReturned();
		   if(status) {
			   Assert.assertTrue(true);
		   } else {
			   Assert.assertTrue(false);
		   }
	}

	//Check whether clicking CANCELLED in invoice list page, displays invoices which are CANCELLED
	
	@When("User clicks Cancelled in top of the page")
	public void user_clicks_cancelled_in_top_of_the_page() {
		Map<Boolean,String> status1 = invoice.clickCancelledInInvoice();
	    Assert.assertTrue(status1.get(false), status1.containsKey(true));
	}
	
	@Then("Paginate and get values for CANCELLED status")
	public void paginate_and_get_values_for_cancelled_status() throws Exception {
		boolean status = invoice.paginateAndGetValuesForCancelled();
		   if(status) {
			   Assert.assertTrue(true);
		   } else {
			   Assert.assertTrue(false);
		   }
	}

	//Check whether clicking ALL in invoice list page, displays ALL invoices
	
	@When("User clicks All in top of the page")
	public void user_clicks_all_in_top_of_the_page() {
		Map<Boolean,String> status1 = invoice.clickAllInInvoice();
	    Assert.assertTrue(status1.get(false), status1.containsKey(true));
	}
	
	@Then("Paginate and get values for ALL status")
	public void paginate_and_get_values_for_all_status() throws Exception {
		boolean status = invoice.paginateAndGetValuesForAll();
		   if(status) {
			   Assert.assertTrue(true);
		   } else {
			   Assert.assertTrue(false);
		   }
	}

	//Check whether pagination works in both forward and backward directions

	@Then("User paginates in forward direction and Verify whether NEXT button is disabled while on last page")
	public void verify_whether_next_button_is_disabled_while_on_last_page() {
	    boolean status = invoice.paginateForwardAndVerify();
	    if(status) {
	    	Assert.assertTrue(true);
	    } else {
	    	Assert.assertTrue(false);
	    }
	}
	
	@Then("User paginates in backward direction and Verify whether PREVIOUS button is disabled while on first page")
	public void verify_whether_previous_button_is_disabled_while_on_first_page() {
	    boolean status = invoice.paginateBackAndVerify();
	    if(status) {
	    	Assert.assertTrue(true);
	    } else {
	    	Assert.assertTrue(false);
	    }
	}

	//Check whether choosing Display 10 in display dropdown lists only 10 invoices per page
	
	@When("User clicks display option")
	public void user_clicks_display_option() {
		Map<Boolean,String> status1 = invoice.clickDisplayOption();
	    Assert.assertTrue(status1.get(false), status1.containsKey(true));
	}
	
	@When("User chooses Display10")
	public void user_chooses_display10() {
		Map<Boolean,String> status1 = invoice.selectDisplay10();
	    Assert.assertTrue(status1.get(false), status1.containsKey(true));
	}
	
	@Then("Verify only ten invoices displayed per page")
	public void verify_only_ten_invoices_displayed_per_page() {
	    String status = invoice.displayResult10();
	    if(status.equalsIgnoreCase("1 to 10")) {
	    	Assert.assertTrue(true);
	    } else {
	    	Assert.assertTrue(false);
	    }

	}
	
	@Then("Only ten invoices present in table")
	public void only_ten_invoices_present_in_table() {
		Integer status = invoice.resultInTable();
		if(status.equals(10)) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}

	//Check whether choosing Display 25 in display dropdown lists only 25 invoices per page
	
	@When("User chooses Display25")
	public void user_chooses_display25() {
		Map<Boolean,String> status1 = invoice.selectDisplay25();
	    Assert.assertTrue(status1.get(false), status1.containsKey(true));
	}
	
	@Then("Verify only twenty five invoices displayed per page")
	public void verify_only_twenty_five_invoices_displayed_per_page() {
		String status = invoice.displayResult25();
	    if(status.equalsIgnoreCase("1 to 25")) {
	    	Assert.assertTrue(true);
	    } else {
	    	Assert.assertTrue(false);
	    }
	}
	
	@Then("Only twenty five invoices present in table")
	public void only_twenty_five_invoices_present_in_table() {
		Integer status = invoice.resultInTable();
		if(status.equals(25)) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}

	//Check whether choosing Display 50 in display dropdown lists only 50 invoices per page
	
	@When("User chooses Display50")
	public void user_chooses_display50() {
		Map<Boolean,String> status1 = invoice.selectDisplay50();
	    Assert.assertTrue(status1.get(false), status1.containsKey(true));
	}
	
	@Then("Verify only fifty invoices displayed per page")
	public void verify_only_fifty_invoices_displayed_per_page() {
		String status = invoice.displayResult25();
	    if(status.equalsIgnoreCase("1 to 50")) {
	    	Assert.assertTrue(true);
	    } else {
	    	Assert.assertTrue(false);
	    }
	}
	
	@Then("Only fifty invoices present in table")
	public void only_fifty_invoices_present_in_table() {
		Integer status = invoice.resultInTable();
		if(status.equals(50)) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}

	//Check whether choosing Display 100 in display dropdown lists only 100 invoices per page
	
	@When("User chooses Display100")
	public void user_chooses_display100() {
		Map<Boolean,String> status1 = invoice.selectDisplay100();
	    Assert.assertTrue(status1.get(false), status1.containsKey(true));
	}
	
	@Then("Verify only hundred invoices displayed per page")
	public void verify_only_hundred_invoices_displayed_per_page() {
		String status = invoice.displayResult100();
	    if(status.equalsIgnoreCase("1 to 100")) {
	    	Assert.assertTrue(true);
	    } else {
	    	Assert.assertTrue(false);
	    }
	}
	
	@Then("Only hundred invoices present in table")
	public void only_hundred_invoices_present_in_table() {
		Integer status = invoice.resultInTable();
		if(status.equals(100)) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}

	//Check whether filtering invoices by date displays only invoices of filtered date
	
	@When("User clicks date field")
	public void user_clicks_date_field() {
		Map<Boolean,String> status1 = invoice.clickDateField();
	    Assert.assertTrue(status1.get(false), status1.containsKey(true));
	}
	
	@When("User clicks from date field and enter date")
	public void user_clicks_from_date_field_and_enter_date() {
		Map<Boolean,String> status1 = invoice.enterFromDate();
	    Assert.assertTrue(status1.get(false), status1.containsKey(true));
	}
	
	@When("User clicks to date field and enter date")
	public void user_clicks_to_date_field_and_enter_date() {
		Map<Boolean,String> status1 = invoice.enterToDate();
	    Assert.assertTrue(status1.get(false), status1.containsKey(true));
	}
	
	@When("User clicks Apply button")
	public void user_clicks_apply_button() {
		Map<Boolean,String> status1 = invoice.clickApplyButton();
	    Assert.assertTrue(status1.get(false), status1.containsKey(true));
	}
	
	@Then("Verify invoices date")
	public void verify_invoices_date() {
	    boolean status = invoice.dateSearchResult();
	    if(status) {
	    	Assert.assertTrue(true);
	    } else {
	    	Assert.assertTrue(false);
	    }
	}

	//Check whether status can be sorted in Ascending order
	
	@When("User clicks Status")
	public void user_clicks_status() {
		Map<Boolean,String> status1 = invoice.clickStatus();
	    Assert.assertTrue(status1.get(false), status1.containsKey(true));
	}
	
	@Then("User gets obtained list and sorts it in Ascending order and verify the sorted list with obtained list")
	public void user_gets_obtained_list_and_sorts_it_in_ascending_order_and_verify_the_sorted_list_with_obtained_list() {
	   boolean status = invoice.verifyObtainedAndSortedList();
	   if(status) {
		   Assert.assertTrue(true);
	   } else {
		   Assert.assertTrue(false);
	   }
	}
	
	//Check whether status can be sorted in Descending order
	
	@Then("User gets obtained list and sorts it in Descending order and verify the sorted list with obtained list")
	public void user_gets_obtained_list_and_sorts_it_in_descending_order_and_verify_the_sorted_list_with_obtained_list() {
	    boolean status = invoice.verifyObtainedAndSortedListinDescOrder();
	    if(status) {
	    	Assert.assertTrue(true);
	    } else {
	    	Assert.assertTrue(false);
	    }
	}
	
	//Check whether channels can be sorted in Ascending order
	
	@When("User clicks Channels")
	public void user_clicks_channels() {
		Map<Boolean,String> status1 = invoice.clickChannels();
	    Assert.assertTrue(status1.get(false), status1.containsKey(true));
	}
	
	@Then("User gets obtained list of channels and sorts it in Ascending order and verify the sorted list with obtained list")
	public void user_gets_obtained_list_of_channels_and_sorts_it_in_ascending_order_and_verify_the_sorted_list_with_obtained_list() throws Exception {
		boolean status = invoice.verifyObtainedAndSortedChannels();
		if(status)	{
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}

	//Check whether channels can be sorted in descending order
	
	@Then("User gets obtained list of channels and sorts it in descending order and verify the sorted list with obtained list")
	public void user_gets_obtained_list_of_channels_and_sorts_it_in_descending_order_and_verify_the_sorted_list_with_obtained_list() {
		boolean status = invoice.verifyObtainedAndSortedChannelsInDescOrder();
		if(status)	{
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}

	//Check whether channel order number can be sorted in ascending order
	
	@When("User clicks channel order no")
	public void user_clicks_channel_order_no() throws Exception {
		Map<Boolean,String> status1 = invoice.clickChannelOrderNo();
	    Assert.assertTrue(status1.get(false), status1.containsKey(true));
	    Thread.sleep(1000);
	}
	
	@Then("User gets obtained list of channel order number and sorts in in ascending order and verify the sorted list with obtained list")
	public void user_gets_obtained_list_of_channel_order_number_and_sorts_in_in_ascending_order_and_verify_the_sorted_list_with_obtained_list() throws Exception {
		boolean status = invoice.verifyObtainedAndSortedChannelOrderNo();
		if(status)	{
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}

	//Check whether channel order number can be sorted in descending order
	
	@Then("User gets obtained list of channel order number and sorts it in descending order and verify the sorted list with obtained list")
	public void user_gets_obtained_list_of_channel_order_number_and_sorts_it_in_descending_order_and_verify_the_sorted_list_with_obtained_list() {
	    boolean status = invoice.verifyObtainedAndSortedChannelOrderNoInDescOrder();
	    if(status)	{
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}

	//Check whether invoice numbers can be sorted in ascending order
	
	@When("User clicks invoice")
	public void user_clicks_invoice() throws InterruptedException {
		Map<Boolean,String> status1 = invoice.clickInvoices();
	    Assert.assertTrue(status1.get(false), status1.containsKey(true));
	    Thread.sleep(1000);
	}
	
	@Then("User gets obtained list of invoices and sorts it in ascending order and verify the sorted list with the obtained list")
	public void user_gets_obtained_list_of_invoices_and_sorts_it_in_ascending_order_and_verify_the_sorted_list_with_the_obtained_list() throws ParseException {
		boolean status = invoice.verifyObtainedAndSortedInvoices();
	    if(status)	{
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}

	//Check whether invoice numbers can be sorted in descending order
	
	@Then("User gets obtained list of invoices and sorts it in descending order and verify the sorted list with the obtained list")
	public void user_gets_obtained_list_of_invoices_and_sorts_it_in_descending_order_and_verify_the_sorted_list_with_the_obtained_list() throws ParseException {
		boolean status = invoice.verifyObtainedAndSortedInvoicesInDescOrder();
	    if(status)	{
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}

	//Check whether billers can be sorted in ascending order
	
	@When("User clicks billers")
	public void user_clicks_billers() throws InterruptedException {
		Map<Boolean,String> status1 = invoice.clickBillers();
	    Assert.assertTrue(status1.get(false), status1.containsKey(true));
	    Thread.sleep(1000);
	}
	
	@Then("User gets obtained list of billers and sorts it in ascending order and verify the sorted list with the obtained list")
	public void user_gets_obtained_list_of_billers_and_sorts_it_in_ascending_order_and_verify_the_sorted_list_with_the_obtained_list() {
		boolean status = invoice.verifyObtainedAndSortedBillers();
	    if(status)	{
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}

	//Check whether billers can be sorted in descending order			
	
	@Then("User gets obtained list of billers and sorts it in descending order and verify the sorted list with the obtained list")
	public void user_gets_obtained_list_of_billers_and_sorts_it_in_descending_order_and_verify_the_sorted_list_with_the_obtained_list() {
		boolean status = invoice.verifyObtainedAndSortedBillersInDescOrder();
	    if(status)	{
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}

	//Check whether customers can be sorted in ascending order
	
	@When("User clicks customers")
	public void user_clicks_customers() throws InterruptedException {
		Map<Boolean,String> status1 = invoice.clickCustomers();
	    Assert.assertTrue(status1.get(false), status1.containsKey(true));
	    Thread.sleep(1000);
	}
	
	@Then("User gets obtained list of customers and sorts it in ascending order and verify the sorted list with the obtained list")
	public void user_gets_obtained_list_of_customers_and_sorts_it_in_ascending_order_and_verify_the_sorted_list_with_the_obtained_list() {
		boolean status = invoice.verifyObtainedAndSortedCustomers();
	    if(status)	{
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}

	//Check whether customers can be sorted in descending order
	
	@Then("User gets obtained list of customers and sorts it in descending order and verify the sorted list with the obtained list")
	public void user_gets_obtained_list_of_customers_and_sorts_it_in_descending_order_and_verify_the_sorted_list_with_the_obtained_list() {
		boolean status = invoice.verifyObtainedAndSortedCustomersInDescOrder();
	    if(status)	{
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}

	//Check whether total amount can be sorted in ascending order	
	
	@When("User clicks total")
	public void user_clicks_total() throws InterruptedException {
		Map<Boolean,String> status1 = invoice.clickTotal();
	    Assert.assertTrue(status1.get(false), status1.containsKey(true));
	    Thread.sleep(1000);
	}
	
	@Then("User gets obtained list of total amounts and sorts it in ascending order and verify the sorted list with the obtained list")
	public void user_gets_obtained_list_of_total_amounts_and_sorts_it_in_ascending_order_and_verify_the_sorted_list_with_the_obtained_list() {
		boolean status = invoice.verifyObtainedAndSortedTotalAmount();
	    if(status)	{
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}

	//Check whether total amount can be sorted in descending order 
	
	@Then("User gets obtained list of total amounts and sorts it in descending order and verify the sorted list with the obtained list")
	public void user_gets_obtained_list_of_total_amounts_and_sorts_it_in_descending_order_and_verify_the_sorted_list_with_the_obtained_list() {
		boolean status = invoice.verifyObtainedAndSortedTotalAmountInDescOrder();
	    if(status)	{
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}

	//Check whether outstanding amount can be sorted in ascending order
	
	@When("User clicks outstanding")
	public void user_clicks_outstanding() throws InterruptedException {
		Map<Boolean,String> status1 = invoice.clickOutstanding();
	    Assert.assertTrue(status1.get(false), status1.containsKey(true));
	    Thread.sleep(1000);
	}
	
	@Then("User gets obtained list of outstanding amounts and sorts it in ascending order and verify the sorted list with the obtained list")
	public void user_gets_obtained_list_of_outstanding_amounts_and_sorts_it_in_ascending_order_and_verify_the_sorted_list_with_the_obtained_list() {
		boolean status = invoice.verifyObtainedAndSortedOutstandingAmount();
	    if(status)	{
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}

	//Check whether outstanding amount can be sorted in descending order
	
	@Then("User gets obtained list of outstanding amounts and sorts it in descending order and verify the sorted list with the obtained list")
	public void user_gets_obtained_list_of_outstanding_amounts_and_sorts_it_in_descending_order_and_verify_the_sorted_list_with_the_obtained_list() {
		boolean status = invoice.verifyObtainedAndSortedOutstandingAmountInDescOrder();
	    if(status)	{
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}

	//Check whether filtering invoices by invoice sales channel displays invoices only of the filtered channel

	@When("User clicks channels dropdown")
	public void user_clicks_channels_dropdown() {
		Map<Boolean,String> status1 = invoice.clickChannelDropdown();
	    Assert.assertTrue(status1.get(false), status1.containsKey(true));
	}
	
	@When("User selects Invoice sales in channels")
	public void user_selects_invoice_sales_in_channels() {
		Map<Boolean,String> status1 = invoice.selectInvoiceSales();
	    Assert.assertTrue(status1.get(false), status1.containsKey(true));
	}
	
	@Then("Only invoice sales channel invoices are displayed")
	public void only_invoice_sales_channel_invoices_are_displayed() {
		boolean status = invoice.filteredChannelIsInvoiceSale();
	    if(status)	{
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}

	//Check whether filtering invoices by pos channel displays invoices only of the filtered channel
	
	@When("User selects pos in channels")
	public void user_selects_pos_in_channels() {
		Map<Boolean,String> status1 = invoice.selectPOS();
	    Assert.assertTrue(status1.get(false), status1.containsKey(true));
	}
	
	@Then("Only pos channel invoices are displayed")
	public void only_pos_channel_invoices_are_displayed() {
		boolean status = invoice.filteredChannelIsPOS();
	    if(status)	{
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}

	//Check whether filtering invoices by ecommerce channel displays invoices only of the filtered channel
	
	@When("User selects ecommerce in channels")
	public void user_selects_ecommerce_in_channels() {
		Map<Boolean,String> status1 = invoice.selectEcommerce();
	    Assert.assertTrue(status1.get(false), status1.containsKey(true));
	}
	
	@Then("Only ecommerce channel invoices are displayed")
	public void only_ecommerce_channel_invoices_are_displayed() {
		boolean status = invoice.filteredChannelIsEcommerce();
	    if(status)	{
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}
	
	//Check whether filtering invoices by woocommerce channel displays invoices only of the filtered channel
	
	@When("User selects woocommerce in channels")
	public void user_selects_woocommerce_in_channels() {
		Map<Boolean,String> status1 = invoice.selectWoocommerce();
	    Assert.assertTrue(status1.get(false), status1.containsKey(true));
	}
	
	@Then("Only woocommerce channel invoices are displayed")
	public void only_woocommerce_channel_invoices_are_displayed() {
		boolean status = invoice.filteredChannelIsWoocommerce();
	    if(status)	{
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}

	//Check whether filtering invoices by opencart channel displays invoices only of the filtered channel	
	
	@When("User selects opencart in channels")
	public void user_selects_opencart_in_channels() {
		Map<Boolean,String> status1 = invoice.selectOpencart();
	    Assert.assertTrue(status1.get(false), status1.containsKey(true));
	}
	
	@Then("Only opencart channel invoices are displayed")
	public void only_opencart_channel_invoices_are_displayed() {
		boolean status = invoice.filteredChannelIsOpencart();
	    if(status)	{
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}

	//Check whether filtering invoices by shopify channel displays invoices only of the filtered channel	
	
	@When("User selects shopify in channels")
	public void user_selects_shopify_in_channels() {
		Map<Boolean,String> status1 = invoice.selectShopify();
	    Assert.assertTrue(status1.get(false), status1.containsKey(true));
	}
	
	@Then("Only shopify channel invoices are displayed")
	public void only_shopify_channel_invoices_are_displayed() {
		boolean status = invoice.filteredChannelIsShopify();
	    if(status)	{
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}

	//Check whether filtering invoices by lazada channel displays invoices only of the filtered channel
	
	@When("User selects lazada in channels")
	public void user_selects_lazada_in_channels() {
		Map<Boolean,String> status1 = invoice.selectLazada();
	    Assert.assertTrue(status1.get(false), status1.containsKey(true));
	}
	
	@Then("Only lazada channel invoices are displayed")
	public void only_lazada_channel_invoices_are_displayed() {
		boolean status = invoice.filteredChannelIsLazada();
	    if(status)	{
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}

	//Check whether filtering invoices by shopee channel displays invoices only of the filtered channel
	
	@When("User selects shopee in channels")
	public void user_selects_shopee_in_channels() {
		Map<Boolean,String> status1 = invoice.selectShopee();
	    Assert.assertTrue(status1.get(false), status1.containsKey(true));
	}
	
	@Then("Only shopee channel invoices are displayed")
	public void only_shopee_channel_invoices_are_displayed() {
		boolean status = invoice.filteredChannelIsShopee();
	    if(status)	{
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}
	
	//Check whether search is working for channel order number
	
	@When("User searches for channel order no")
	public void user_searches_for_channel_order_no() {
		Map<Boolean,String> status1 = invoice.searchChannelOrderNo();
	    Assert.assertTrue(status1.get(false), status1.containsKey(true));
	}
	
	@Then("Searched channel order no is displayed")
	public void searched_channel_order_no_is_displayed() {
		boolean status = invoice.searchResultForChannelOrderNo();
	    if(status)	{
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}

	//Check whether search is working for invoices
	
	@When("User searches for invoice")
	public void user_searches_for_invoice() {
		Map<Boolean,String> status1 = invoice.searchInvoice();
	    Assert.assertTrue(status1.get(false), status1.containsKey(true));
	}
	
	@Then("Searched invoice is displayed")
	public void searched_invoice_is_displayed() {
		boolean status = invoice.searchResultForInvoice();
	    if(status)	{
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}

	//Check whether search is working for billers	
	
	@When("User searches for biller")
	public void user_searches_for_biller() {
		Map<Boolean,String> status1 = invoice.searchBiller();
	    Assert.assertTrue(status1.get(false), status1.containsKey(true));
	}
	
	@Then("Searched biller is displayed")
	public void searched_biller_is_displayed() {
		boolean status = invoice.searchResultForBiller();
	    if(status)	{
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}

	//Check whether search is working for customers
	
	@When("User searches for customer")
	public void user_searches_for_customer() {
		Map<Boolean,String> status1 = invoice.searchCustomer();
	    Assert.assertTrue(status1.get(false), status1.containsKey(true));
	}
	
	@Then("Searched customer is displayed")
	public void searched_customer_is_displayed() {
		boolean status = invoice.searchResultForCustomer();
	    if(status)	{
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}

	//Check whether search is working for total amount
	
	@When("User searches for total amount")
	public void user_searches_for_total_amount() {
		Map<Boolean,String> status1 = invoice.searchTotal();
	    Assert.assertTrue(status1.get(false), status1.containsKey(true));
	}
	
	@Then("Searched total amount is displayed")
	public void searched_total_amount_is_displayed() {
		boolean status = invoice.searchResultForTotalAmount();
	    if(status)	{
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}

	//Check whether search is working for outstanding amount
	
	@When("User searches for outstanding amount")
	public void user_searches_for_outstanding_amount() {
		Map<Boolean,String> status1 = invoice.searchOutstanding();
	    Assert.assertTrue(status1.get(false), status1.containsKey(true));
	}
	
	@Then("Searched outstanding amount is displayed")
	public void searched_outstanding_amount_is_displayed() {
		boolean status = invoice.searchResultForOutstandingAmount();
	    if(status)	{
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}

	//Check whether multiple invoices can be added to delivery using more option
	
	@When("User clicks More button")
	public void user_clicks_more_button() {
		Map<Boolean,String> status = invoice.clickMoreButton();
	    Assert.assertTrue(status.get(false), status.containsKey(true));
	}
	
	@When("User chooses add to delivery option")
	public void user_chooses_add_to_delivery_option() {
		Map<Boolean,String> status = invoice.clickBulkAddToDelivery();
	    Assert.assertTrue(status.get(false), status.containsKey(true));
	}
	
	@When("User selects invoices")
	public void user_selects_invoices() {
		boolean status = invoice.chooseCheckBox();
	    if(status) {
	    	Assert.assertTrue(true);
	    } else {
	    	Assert.assertTrue(false);
	    }
	}
	
	@When("User clicks convert to DO button")
	public void user_clicks_convert_to_do_button() {
		Map<Boolean,String> status = invoice.clickAddDeliveryButton();
	    Assert.assertTrue(status.get(false), status.containsKey(true));
	}

	//Check whether user is able to create invoice for the sale order
	
	@When("User clicks sales from side menu from invoice list page")
	public void user_clicks_sales_from_side_menu_from_invoice_list_page() {
		Map<Boolean,String> status = invoice.clickSalesInSideMenu();
	    Assert.assertTrue(status.get(false), status.containsKey(true));
	}



	
























































}
