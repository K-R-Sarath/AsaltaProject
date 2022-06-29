package stepDefinitions;

import java.util.Map;

import org.junit.Assert;

import cucumber.TestContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.InvoiceCreationPage;

public class InvoiceCreationPageSteps {
	
	TestContext testContext;
	InvoiceCreationPage invoiceCreation;
	
	public InvoiceCreationPageSteps(TestContext context) {
		testContext = context;
		invoiceCreation = testContext.getPageObjectManager().getInvoiceCreationPage();
	}
	
	@When("User navigates to invoice creation page and enters invoice details")
	public void user_navigates_to_invoice_creation_page_and_enters_invoice_details() throws Exception {
	   Map<Boolean,String> status = invoiceCreation.clickCustomerField();
	   Assert.assertTrue(status.get(false),status.containsKey(true));
	   Map<Boolean,String> status1 = invoiceCreation.enterCustomerName();
	   Assert.assertTrue(status1.get(false),status1.containsKey(true));
	   Map<Boolean,String> status2 = invoiceCreation.selectCustomer();
	   Assert.assertTrue(status2.get(false),status2.containsKey(true));
	   invoiceCreation.scroll();
	   Map<Boolean,String> status3 = invoiceCreation.enterItem();
	   Assert.assertTrue(status3.get(false), status3.containsKey(true));
	  // Map<Boolean,String> status4 = invoiceCreation.selectItem();
	   //Assert.assertTrue(status4.get(false), status4.containsKey(true));
	   
	}
	@When("Click save sale button")
	public void click_save_sale_button() throws InterruptedException {
	    Map<Boolean,String> status = invoiceCreation.clickAddSaleButton();
	    Assert.assertTrue(status.get(false),status.containsKey(true));
		
	}
	@Then("Invoice created successfully")
	public void invoice_created_successfully()  {
	    String succ = invoiceCreation.success();
	    if(succ.equalsIgnoreCase("Invoice sale successfully added")) {
	    	Assert.assertTrue(true);
	    }else {
	    	Assert.assertTrue(false);
	    }
	}
	
	//Check whether system throws "Please select above first" while selecting item name directly
	

	@When("User selects item name directly")
	public void user_selects_item_name_directly() {
		invoiceCreation.scroll();
	    Map<Boolean,String> status = invoiceCreation.enterItem();
	    Assert.assertTrue(status.get(false),status.containsKey(true));
	}
	@Then("It should throw {string}")
	public void it_should_throw(String result) {
		Map<Boolean,String> status = invoiceCreation.selectItem();
		Assert.assertTrue(status.get(false),status.containsKey(true));
		String alertText = invoiceCreation.alert();
		if(alertText.equalsIgnoreCase(result)) {
			Assert.assertTrue(true);
		}else {
			Assert.assertTrue(false);
		}
	}
	
	//Check whether system throws "Unexpected value provided!" while entering negative values, Zero and alphabets in Quantity field
	
	
	@When("User selects customer")
	public void user_selects_customer() {
	   Map<Boolean,String> status = invoiceCreation.clickCustomerField();
	   Assert.assertTrue(status.get(false),status.containsKey(true));
	   Map<Boolean,String> status1 = invoiceCreation.enterCustomerName();
	   Assert.assertTrue(status1.get(false),status1.containsKey(true));
	   Map<Boolean,String> status2 = invoiceCreation.selectCustomer();
	   Assert.assertTrue(status2.get(false),status2.containsKey(true));
	   System.out.println("Scroll");
	  // Map<Boolean,String> status3 = invoiceCreation.refreshCurrentPage();
	  // Assert.assertTrue(status3.get(false),status3.containsKey(true));
	}
	
	@When("User enters item name and selects item")
	public void user_enters_item_name_and_selects_item() throws Exception {
		invoiceCreation.scroll();
		Map<Boolean,String> status = invoiceCreation.enterItem();
	    Assert.assertTrue(status.get(false),status.containsKey(true));
	    Map<Boolean,String> status1 = invoiceCreation.selectItem();
	    Assert.assertTrue(status1.get(false),status1.containsKey(true));
	}
	
	@When("User enters Quantity as {string}")
	public void user_enters_quantity_as(String Qty) {
	    Map<Boolean,String> status = invoiceCreation.enterQuantity(Qty);
	    Assert.assertTrue(status.get(false),status.containsKey(true));
	    Map<Boolean,String> status1 = invoiceCreation.clickOutside();
	    Assert.assertTrue(status1.get(false), status1.containsKey(true));
	}
	
	@Then("System should throw {string}")
	public void System_should_throw(String result) {
		String alert2 = invoiceCreation.alert2();
		if(alert2.equalsIgnoreCase(result)) {
			Assert.assertTrue(true);
		}else {
			Assert.assertTrue(false);
		}
	}

	//Check whether system throws "Please provide valid Coupon code" while clicking Apply button without entering coupon

	@When("User clicks Apply coupon button")
	public void user_clicks_apply_coupon_button() throws Exception {
	    Map<Boolean,String> status = invoiceCreation.clickApplyCouponButton();
	    Assert.assertTrue(status.get(false),status.containsKey(true));
	}
	
	@Then("It must throw {string}")
	public void it_must_throw(String result) {
		
		String success2 = invoiceCreation.successMsg2();
		System.out.println(success2);
		if(success2.equalsIgnoreCase(result)) {
			Assert.assertTrue(true);
		}else {
			Assert.assertTrue(false);
		}
	    
	}
	
	//Check whether system throws "Please select atleast one item." while clicking Apply button without entering coupon and without selecting item

	@Then("System must throw {string}")
	public void system_must_throw(String result) {
		
		String alert3 = invoiceCreation.alert3();
		if(alert3.equalsIgnoreCase(result)) {
			Assert.assertTrue(true);
		}else {
			Assert.assertTrue(false);
		}
	    
	}
	
	//Check whether system throws error "Please Select Customer" when checking Display all price book list price without selecting customer

	@When("User selects Display all price book list price checkbox")
	public void user_selects_display_all_price_book_list_price_checkbox() {
		invoiceCreation.scroll1();
	    invoiceCreation.clickCheckbox();
	    //Assert.assertTrue(status.get(false),status.containsKey(true));
	    invoiceCreation.selectCheckbox();
	}
	
	@Then("It throws error {string}")
	public void it_throws_error(String result) {
	    String alert4 = invoiceCreation.alert4();
	    if(alert4.equalsIgnoreCase(result)) {
	    	Assert.assertTrue(true);
	    }else {
	    	Assert.assertTrue(false);
	    }
	}

	//Check whether error is thrown "Please provide valid Coupon code" while entering invalid coupon codes

	@When("User enters coupon code as {string}")
	public void user_enters_coupon_code_as(String coupons) throws Exception {
		Map<Boolean,String> status = invoiceCreation.enterCoupons(coupons);
		Assert.assertTrue(status.get(false),status.containsKey(true));	    
	}

	//Check whether system throws "Discount amount cannot be more than item amount" when we enter discount amount more than the item amount and "Discount amount cannot be more than 100%" if we enter percentage above hundred

	/*@When("User enters discount {string}")
	public void user_enters_discount(String discount) {
		Map<Boolean,String> status = invoiceCreation.enterDiscount(discount);
		Assert.assertTrue(status.get(false),status.containsKey(true));
		Map<Boolean,String> status1 = invoiceCreation.clickOutAfterDiscount();
		Assert.assertTrue(status1.get(false),status1.containsKey(true));
	    
	}
	@Then("It should display {string}")
	public void it_should_display(String result) {
		String alert5 = invoiceCreation.alert5();
		if(alert5.equalsIgnoreCase(result)) {
			Assert.assertTrue(true);
		}else {
			Assert.assertTrue(false);
		}
	   
	}*/
	
	//Check whether user is able to upload document	
	
	@Then("User attachs document")
	public void user_attachs_document() throws Exception	{
		Map<Boolean,String> status = invoiceCreation.attachFile();
		Assert.assertTrue(status.get(false),status.containsKey(true));
		Map<Boolean,String> status1 = invoiceCreation.clickAddSaleButton();
		Assert.assertTrue(status1.get(false),status1.containsKey(true));
	}

	@Then("User verifies the attachment")
	public void user_verifies_the_attachment() throws Exception {
	    Map<Boolean,String> status = invoiceCreation.verifyAttachment();
	    Assert.assertTrue(status.get(false), status.containsKey(true));
	    invoiceCreation.scroll2();
	    String status1 = invoiceCreation.attachment();
	    if(status1.equalsIgnoreCase("Attachment")) {
	    	Assert.assertTrue(true);
	    }else {
	    	Assert.assertTrue(false);
	    }
	}
	
	//Check whether system throws "Unexpected value provided!" while making Payment term field empty and clicking outside Payment term field

	@When("User makes Payment term field empty")
	public void user_makes_payment_term_field_empty() {
	    Map<Boolean,String> status = invoiceCreation.erasePaymentTermField();
	    Assert.assertTrue(status.get(false), status.containsKey(true));
	}
	
	@When("User click outside payment term field")
	public void user_click_outside_payment_term_field() {
	    Map<Boolean,String> status = invoiceCreation.clickOutPaymentTermField();
	    Assert.assertTrue(status.get(false), status.containsKey(true));
	}
	
	//Check whether user is able to create invoice with all informations
	
	@When("It tells {string}")
	public void it_tells(String couponMsg) {
	    String coupon = invoiceCreation.couponMsg();
	    if(coupon.contains(couponMsg)){
	    	Assert.assertTrue(true);
	    } else {
	    	Assert.assertTrue(false);
	    }
	}
	
	@When("User enters shipping cost as {string}")
	public void user_enters_shipping_cost_as(String shippingAmount) {
	   Map<Boolean,String> status = invoiceCreation.enterShippingAmount(shippingAmount);
	   Assert.assertTrue(status.get(false), status.containsKey(true));
	}
	
	//Check whether user is able to create invoice with discount amount	
	
	@When("User enters discounts")
	public void user_enters_discounts() throws Exception {
	    Map<Boolean,String> status = invoiceCreation.enterDiscountAmount();
	    Assert.assertTrue(status.get(false), status.containsKey(true));
	}
	
	//Check whether user is able to create customer inside new invoice sale page

	@When("User clicks add new customer button")
	public void user_clicks_add_new_customer_button() {
	   Map<Boolean,String> status = invoiceCreation.clickAddCustomerButton();
	   Assert.assertTrue(status.get(false), status.containsKey(true));
	}
	
	@When("User enters name of the customer as {string}")
	public void user_enters_name_of_the_customer_as(String customerName)  {
	   Map<Boolean,String> status = invoiceCreation.enterCustName(customerName);
	   Assert.assertTrue(status.get(false), status.containsKey(true));
	}
	
	@When("User clicks save customer button")
	public void user_clicks_save_customer_button() {
	   Map<Boolean,String> status = invoiceCreation.clickSaveCustomerButton();
	   Assert.assertTrue(status.get(false), status.containsKey(true));
	}

	//Check whether system throws "The Name field is required." while clicking save customer button without entering name.

	@Then("Alert is {string}")
	public void alert_is(String message) {
	   String alert = invoiceCreation.alert6();
	   if(alert.equalsIgnoreCase(message))	{
		   Assert.assertTrue(true);
	   } else {
		   Assert.assertTrue(false);
	   }
	}
	
	//Check whether user is able to create a new custom field for new customer inside new invoice sale page	

	@When("User scrolls down to Add New Custom Field button")
	public void user_scrolls_down_to_add_new_custom_field_button() {
	    invoiceCreation.scroll3();
	}
	
	@When("User clicks add new custom field button")
	public void user_clicks_add_new_custom_field_button() {
	    Map<Boolean,String> status = invoiceCreation.clickAddNewCustomFieldButton();
	    Assert.assertTrue(status.get(false), status.containsKey(true));
	}
	
	@When("User enters label as {string}")
	public void user_enters_label_as(String label) {
	    Map<Boolean,String> status = invoiceCreation.enterLabel(label);
	    Assert.assertTrue(status.get(false), status.containsKey(true));
	}
	
	@When("User clicks and selects type as {string}")
	public void user_clicks_and_selects_type_as(String type) {
	    Map<Boolean,String> status = invoiceCreation.clickType();
	    Assert.assertTrue(status.get(false), status.containsKey(true));
	    Map<Boolean,String> status1 = invoiceCreation.enterType(type);
	    Assert.assertTrue(status1.get(false), status1.containsKey(true));
	    Map<Boolean,String> status2 = invoiceCreation.typeSelect();
	    Assert.assertTrue(status2.get(false), status2.containsKey(true));
	    if(type.equals("Checklist") || type.equals("Dropdown") || type.equals("Mutiple Choice"))	{
	    	Map<Boolean,String> status3 = invoiceCreation.enterChecklistValues();
	    	Assert.assertTrue(status3.get(false), status3.containsKey(true));
	    }
	}
	
	@When("User chooses mandatory option as yes")
	public void user_chooses_mandatory_option_as_yes() {
	   Map<Boolean,String> status = invoiceCreation.clickYes();
	   Assert.assertTrue(status.get(false), status.containsKey(true));
	}
	
	@When("User clicks save button")
	public void user_clicks_save_button() {
	    Map<Boolean,String> status = invoiceCreation.clickSaveCustom();
	    Assert.assertTrue(status.get(false), status.containsKey(true));
	}
	
	//Check whether user is able to create a new custom field for new customer inside new invoice sale page	with mandatory NO
	
	@When("User chooses mandatory option as no")
	public void user_chooses_mandatory_option_as_no() {
	   Map<Boolean,String> status = invoiceCreation.clickNo();
	   Assert.assertTrue(status.get(false), status.containsKey(true));
	}
	
	//Check whether system throws "All fields are required"	when clicking save button in custom field inside new invoice sale 

	@Then("Alert {string}")
	public void alert(String message) {
	    String alert = invoiceCreation.alert7();
	    if(alert.equals(message))	{
	    	Assert.assertTrue(true);
	    }	else	{
	    	Assert.assertTrue(false);
	    }
	}

	//Check whether another custom field adding option is displaying while clicking Add another custom field button

	@When("User clicks	add another custom field button")
	public void user_clicks_add_another_custom_field_button() throws Exception {
		Thread.sleep(1000);
	    Map<Boolean,String> status = invoiceCreation.clickAnotherCustomField();
	    Assert.assertTrue(status.get(false), status.containsKey(true));
	}
	
	@Then("Verify the custom field option")
	public void verify_the_custom_field_option() {
	    boolean status = invoiceCreation.verifyAnotherCustomField();
	    if(status){
	    	Assert.assertTrue(true);
	    } else {
	    	Assert.assertTrue(false);
	    }
	}
	
	//Check whether user can delete the newly added custom field option
	
	@When("User deletes the newly added custom field option")
	public void user_deletes_the_newly_added_custom_field_option() {
	    Map<Boolean,String> status = invoiceCreation.deleteNewlyAddedCustomField();
	    Assert.assertTrue(status.get(false), status.containsKey(true));
	}
	
	@Then("Verify the deleted option")
	public void verify_the_deleted_option() {
	    boolean status = invoiceCreation.verifyAnotherCustomField();
	    if(status == false){
	    	Assert.assertTrue(true);
	    } else {
	    	Assert.assertTrue(false);
	    }
	}
	
	//Check whether user can close add new custom field popup and add new customer popup
	
	@When("User closes add new custom field popup and add new customer popup")
	public void user_closes_add_new_custom_field_popup_and_add_new_customer_popup() throws Exception {
	    Map<Boolean,String> status = invoiceCreation.closeCustomfieldPopup();
	    Assert.assertTrue(status.get(false), status.containsKey(true));
	    Map<Boolean,String> status1 = invoiceCreation.closeCustomerPopup();
	    Assert.assertTrue(status1.get(false), status.containsKey(true));
	}
	
	@Then("Verify popup closed for both")
	public void verify_popup_closed_for_both() throws Exception	{
		Thread.sleep(2000);
		boolean status = invoiceCreation.verifyCustomerAndCustomFieldPopupClosed();
		System.out.println(status);
		if(status == false)	{
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}
	
	//Check whether system throws "Customer is missing from invoice" when user clicks save address button in add billing address option

	@When("User clicks add billing address button")
	public void user_clicks_add_billing_address_button() {
	    Map<Boolean,String> status = invoiceCreation.clickAddBillingAddress();
	    Assert.assertTrue(status.get(false), status.containsKey(true));
	}
	
	@When("User clicks save address button")
	public void user_clicks_save_address_button() {
	    Map<Boolean,String> status = invoiceCreation.clickSaveBillingAddress();
	    Assert.assertTrue(status.get(false), status.containsKey(true));
	}
	
	//Check whether billing address popup closes while clicking cancel button
	
	@When("User clicks cancel button")
	public void user_clicks_cancel_button() {
	    Map<Boolean,String> status = invoiceCreation.CancelBilling();
	    Assert.assertTrue(status.get(false), status.containsKey(true));
	}
	
	@Then("Verify popup closed")
	public void verify_popup_closed() throws Exception	{
		Thread.sleep(1000);
		boolean status = invoiceCreation.verifyBillingAddressPopupClosed();
		System.out.println(status);
		if(status == false) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}
	
	//Check whether user can close billing address popup

	@When("User closes billing address popup")
	public void user_closes_billing_address_popup() {
	    Map<Boolean,String> status = invoiceCreation.closeBillingAddressPopup();
	    Assert.assertTrue(status.get(false), status.containsKey(true));
	}
	
	//Check whether system throws "Postal code is required" when user clicks save address button after filling address in add billing address popup
	
	@When("User enters address line1")
	public void user_enters_address_line1() {
	   Map<Boolean,String> status = invoiceCreation.enterAddress1inBillingAddress();
	   Assert.assertTrue(status.get(false), status.containsKey(true));
	}

	//Check whether system throws "Address added successfully" after creating billing address inside new invoice sale page
	
	@When("User enters postal code")
	public void user_enters_postal_code() {
	    Map<Boolean,String> status = invoiceCreation.enterPostalCodeinBillingAddress();
	    Assert.assertTrue(status.get(false), status.containsKey(true));
	}

	//Check whether system throws "Address updated successfully" after editing billing address inside new invoice sale page

	@When("User selects billing address")
	public void user_selects_billing_address() throws Exception {
	    Map<Boolean,String> status = invoiceCreation.clickBillingAddress();
	    Assert.assertTrue(status.get(false), status.containsKey(true));
	    Map<Boolean,String> status1 = invoiceCreation.enterBillAddress();
	    Assert.assertTrue(status1.get(false), status1.containsKey(true));
	    Map<Boolean,String> status2 = invoiceCreation.selectBillAddress();
	    Assert.assertTrue(status2.get(false), status2.containsKey(true));
	}
	
	@When("User clicks edit option")
	public void user_clicks_edit_option() {
	    Map<Boolean,String> status = invoiceCreation.clickEditBillAddress();
	    Assert.assertTrue(status.get(false), status.containsKey(true));
	}
	
	@When("User updates postal code")
	public void user_updates_postal_code() throws Exception {
	    Map<Boolean,String> status = invoiceCreation.erasePostalCode();
	    Assert.assertTrue(status.get(false), status.containsKey(true));
	    Map<Boolean,String> status1 = invoiceCreation.updatePostalCode();
	    Assert.assertTrue(status1.get(false), status1.containsKey(true));
	}
	
	@When("User clicks update address button")
	public void user_clicks_update_address_button() {
	    Map<Boolean,String> status = invoiceCreation.clickUpdateBillAddressButton();
	    Assert.assertTrue(status.get(false), status.containsKey(true));
	}

	//Check whether system throws "Customer is missing from invoice" when user clicks save address button in add shipping address option without selecting customer	
	
	@When("User clicks add shipping address button")
	public void user_clicks_add_shipping_address_button() {
	    Map<Boolean,String> status = invoiceCreation.clickAddShippingAddress();
	    Assert.assertTrue(status.get(false), status.containsKey(true));
	}

	//Check whether system throws "Address updated successfully" after editing shipping address inside new invoice sale page
	
	@When("User selects shipping address")
	public void user_selects_shipping_address() {
		 Map<Boolean,String> status = invoiceCreation.clickShippingAddress();
		 Assert.assertTrue(status.get(false), status.containsKey(true));
		 Map<Boolean,String> status1 = invoiceCreation.enterShipAddress();
		 Assert.assertTrue(status1.get(false), status1.containsKey(true));
		 Map<Boolean,String> status2 = invoiceCreation.selectShipAddress();
		 Assert.assertTrue(status2.get(false), status2.containsKey(true));
	}
	
	@When("User clicks edit option shipping")
	public void user_clicks_edit_option_shipping() throws Exception {
		Map<Boolean,String> status = invoiceCreation.clickEditShipAddress();
		Assert.assertTrue(status.get(false), status.containsKey(true));
	}
	
	//Check whether system throws alert when user clicks save currency button in add currency option inside new invoice sale page without filling anything

	@When("User clicks add currency button")
	public void user_clicks_add_currency_button() {
	    Map<Boolean,String> status = invoiceCreation.clickAddCurrencyButton();
	    Assert.assertTrue(status.get(false), status.containsKey(true));
	}
	
	@When("User clicks save currency button")
	public void user_clicks_save_currency_button() {
	    Map<Boolean,String> status = invoiceCreation.clickSaveCurrency();
	    Assert.assertTrue(status.get(false), status.containsKey(true));
	}
	
	@Then("Four alerts, First alert is {string}")
	public void four_alerts_first_alert_is(String msg1) {
	   String alert = invoiceCreation.alertMessage1();
	   if(alert.equals(msg1)){
		   Assert.assertTrue(true);
	   } else {
		   Assert.assertTrue(false);
	   }
	}
	
	@Then("Second alert is {string}")
	public void second_alert_is(String msg2) {
	   String alert = invoiceCreation.alertMessage2();
	   if(alert.equals(msg2)){
		   Assert.assertTrue(true);
	   } else {
		   Assert.assertTrue(false);
	   }
	}
	
	@Then("Third alert is {string}")
	public void third_alert_is(String msg3) {
	   String alert = invoiceCreation.alertMessage3();
	   if(alert.equals(msg3)){
		   Assert.assertTrue(true);
	   } else {
		   Assert.assertTrue(false);
	   }
	}
	
	@Then("Fourth alert is {string}")
	public void fourth_alert_is(String msg4) {
	    String alert = invoiceCreation.alertMessage4();
	    if(alert.equals(msg4)){
	    	Assert.assertTrue(true);
	    } else {
	    	Assert.assertTrue(false);
	    }
	}

	//Check whether system throws "The Exchange Rate field is required." when clicking save currency button with exchange rate "0.00"
	
	@When("User selects currency code")
	public void user_selects_currency_code() {
	    Map<Boolean,String> status = invoiceCreation.clickCurrencyCode();
	    Assert.assertTrue(status.get(false), status.containsKey(true));
	    Map<Boolean,String> status1 = invoiceCreation.enterCurrencyCode();
	    Assert.assertTrue(status1.get(false), status1.containsKey(true));
	    Map<Boolean,String> status2 = invoiceCreation.selectCurrencyCode();
	    Assert.assertTrue(status2.get(false), status2.containsKey(true));
	}

	//Check whether system throws "Currency successfully added"	after creating currency

	@When("User enters exchange rate")
	public void user_enters_exchange_rate() {
		Map<Boolean,String> status = invoiceCreation.eraseRate();
	    Assert.assertTrue(status.get(false), status.containsKey(true));
	    Map<Boolean,String> status1 = invoiceCreation.enterExchangeRate();
	    Assert.assertTrue(status1.get(false), status1.containsKey(true));
	}
	
	//
	
	@When("User closes the currency popup")
	public void user_closes_the_currency_popup() {
		Map<Boolean,String> status = invoiceCreation.clickCurrencyPopupClose();
	    Assert.assertTrue(status.get(false), status.containsKey(true));
	}
	
	@Then("Verify popup closes")
	public void verify_popup_closes() throws Exception {
		Thread.sleep(1000);
		boolean status = invoiceCreation.verifyCurrencyPopupClosed();
		System.out.println(status);
		if(status == false) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}

	//Check whether the page gets resets after clicking reset button
	
	@When("User clicks reset button")
	public void user_clicks_reset_button() {
		Map<Boolean,String> status = invoiceCreation.clicksResetButton();
	    Assert.assertTrue(status.get(false), status.containsKey(true));
	}
	
	@When("User clicks OK")
	public void user_clicks_ok() {
		Map<Boolean,String> status = invoiceCreation.clickOKinReset();
	    Assert.assertTrue(status.get(false), status.containsKey(true));
	}
	
	@Then("Verify whether the page gets resetted")
	public void verify_whether_the_page_gets_resetted() {
	   String status = invoiceCreation.afterReset();
	   if(status.equals("Select Customer")){
		   Assert.assertTrue(true);
	   } else {
		   Assert.assertTrue(false);
	   }
	}
	
	@When("Scroll up to customer field")
	public void scroll_up_to_customer_field() {
	    invoiceCreation.scroll4();
	}

	//Check whether reset popup disappears after clicking cancel
	
	@When("User clicks cancel")
	public void user_clicks_cancel() {
		Map<Boolean,String> status = invoiceCreation.clickCancelinReset();
	    Assert.assertTrue(status.get(false), status.containsKey(true));
	}
	
	@Then("Verify whether popup closed")
	public void verify_whether_popup_closed() throws Exception {
		Thread.sleep(1000);
		boolean status = invoiceCreation.verifyResetPopupDisappears();
		System.out.println(status);
		if(status == false) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}

	//Check whether reset popup closes after clicking close
	
	@When("User closes the popup")
	public void user_closes_the_popup() {
		Map<Boolean,String> status = invoiceCreation.resetPopupClose();
	    Assert.assertTrue(status.get(false), status.containsKey(true));
	}
	
	@Then("Verify the same")
	public void verify_the_same() throws Exception {
		Thread.sleep(1000);
		boolean status = invoiceCreation.verifyResetPopupCloses();
		System.out.println(status);
		if(status == false) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}

	//Check whether invoice status is due in invoice list page when sale status is saved as completed
	
	@When("User selects sale status as completed")
	public void user_selects_sale_status_as_completed() {
		Map<Boolean,String> status = invoiceCreation.clickSaleStatus();
	    Assert.assertTrue(status.get(false), status.containsKey(true));
		Map<Boolean,String> status1 = invoiceCreation.selectSaleStatusCompleted();
	    Assert.assertTrue(status1.get(false), status1.containsKey(true));
	}

	//Check whether invoice status is due in invoice list page when sale status is saved as processing
	
	@When("User selects sale status as processing")
	public void user_selects_sale_status_as_processing() {
		Map<Boolean,String> status = invoiceCreation.clickSaleStatus();
	    Assert.assertTrue(status.get(false), status.containsKey(true));
		Map<Boolean,String> status1 = invoiceCreation.selectSaleStatusProcessing();
	    Assert.assertTrue(status1.get(false), status1.containsKey(true));
	}

	//Check whether invoice status is pending in invoice list page when sale status is saved as pending
	
	@When("User selects sale status as pending")
	public void user_selects_sale_status_as_pending() {
		Map<Boolean,String> status = invoiceCreation.clickSaleStatus();
	    Assert.assertTrue(status.get(false), status.containsKey(true));
		Map<Boolean,String> status1 = invoiceCreation.selectSaleStatusPending();
	    Assert.assertTrue(status1.get(false), status1.containsKey(true));
	}

	//Check whether invoice status is cancelled in invoice list page when sale status is saved as cancelled
	
	@When("User selects sale status as cancelled")
	public void user_selects_sale_status_as_cancelled() {
		Map<Boolean,String> status = invoiceCreation.clickSaleStatus();
	    Assert.assertTrue(status.get(false), status.containsKey(true));
		Map<Boolean,String> status1 = invoiceCreation.selectSaleStatusCancelled();
	    Assert.assertTrue(status1.get(false), status1.containsKey(true));
	}
	
	//Check whether clicking invoice sales in breadcrumbs navigates to invoice list page
	
	@When("User clicks invoice sales breadcrumb")
	public void user_clicks_invoice_sales_breadcrumb() {
		Map<Boolean,String> status = invoiceCreation.clickInvoiceSalesBreadcrumb();
	    Assert.assertTrue(status.get(false), status.containsKey(true));
	}
	
	//Check whether clicking dashboard in breadcrumbs navigates to dashboard page
	
	@When("User clicks dashboard breadcrumb")
	public void user_clicks_dashboard_breadcrumb() {
		Map<Boolean,String> status = invoiceCreation.clickDashboardBreadcrumb();
	    Assert.assertTrue(status.get(false), status.containsKey(true));
	}
	
	//Check whether adding GST@7% affects the total amount 

	@When("User chooses GST option")
	public void user_chooses_gst_option() {
		Map<Boolean,String> status = invoiceCreation.clickGSTField();
	    Assert.assertTrue(status.get(false), status.containsKey(true));
	    Map<Boolean,String> status1 = invoiceCreation.selectGSToption();
	    Assert.assertTrue(status1.get(false), status1.containsKey(true));
	}
	
	@Then("Total amount should be affected")
	public void total_amount_should_be_affected() {
		if((String.valueOf(invoiceCreation.amountFor7PercentGST())).equalsIgnoreCase(String.valueOf(invoiceCreation.totalAmt()))) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}

	//Check whether Upcoming invoice date is displaying correctly for repeat every month option with ends never
	
	@When("Scroll down to recurring button")
	public void scroll_down_to_recurring_button() {
	    invoiceCreation.scroll7();
	}
	
	@When("Enable recurring button")
	public void enable_recurring_button() {
		Map<Boolean,String> status = invoiceCreation.clickRecurringEnableDisableButton();
	    Assert.assertTrue(status.get(false), status.containsKey(true));
	}
	
	@Then("Upcoming invoice date should be correctly displayed")
	public void upcoming_invoice_date_should_be_correctly_displayed() {
	    if((invoiceCreation.upcomingInvDate()).equalsIgnoreCase((invoiceCreation.getNewDate()))) {
	    	Assert.assertTrue(true);
	    } else {
	    	Assert.assertTrue(false);
	    }
	}

	//Check whether Upcoming invoice date is displaying correctly for repeat every year option with ends never
	
	@When("Choose Repeats Every option as Year")
	public void choose_repeats_every_option_as_year() {
		Map<Boolean,String> status = invoiceCreation.clickRepeatField();
	    Assert.assertTrue(status.get(false), status.containsKey(true));
	    Map<Boolean,String> status1 = invoiceCreation.chooseYearInRepeatOption();
	    Assert.assertTrue(status1.get(false), status1.containsKey(true));
	}
	
	@Then("Upcoming invoice date for year option should be correctly displayed")
	public void upcoming_invoice_date_for_year_option_should_be_correctly_displayed() {
		if((invoiceCreation.upcomingInvDate()).equalsIgnoreCase((invoiceCreation.getNewDateForYearOption()))) {
	    	Assert.assertTrue(true);
	    } else {
	    	Assert.assertTrue(false);
	    }
	}

	//Check whether Upcoming invoice date is displaying correctly for repeat every month option with ends after
	
	@When("Choose After in Ends option")
	public void choose_after_in_ends_option() {
		Map<Boolean,String> status = invoiceCreation.chooseAfterInEndsOption();
	    Assert.assertTrue(status.get(false), status.containsKey(true));
	}
	
	@Then("Upcoming invoice date and end date should be correctly displayed")
	public void upcoming_invoice_date_and_end_date_should_be_correctly_displayed() {
	   if((invoiceCreation.getNewDate()).equalsIgnoreCase((invoiceCreation.upcomingEndDate())))	{
		   Assert.assertTrue(true);
	   } else {
		   Assert.assertTrue(false);
	   }
	}

	//Check whether upcoming invoice date and end date is displaying correctly for repeat every year option with ends after
	
	@Then("Upcoming invoice date and end date for year option should be correctly displayed")
	public void upcoming_invoice_date_and_end_date_for_year_option_should_be_correctly_displayed() {
	    if((invoiceCreation.upcomingEndDate()).equalsIgnoreCase((invoiceCreation.getNewDateForYearOption())))	{
	    	Assert.assertTrue(true);
	    } else {
	    	Assert.assertTrue(false);
	    }
	}
	
	//Check whether entering decimal value in repeat times field and occurence field throws error message
	
	@When("Enter decimal value in repeat times field")
	public void enter_decimal_value_in_repeat_times_field() {
		Map<Boolean,String> status = invoiceCreation.enterRepeatTimes();
	    Assert.assertTrue(status.get(false), status.containsKey(true));
	}
	
	@Then("Error throws {string}")
	public void error_throws(String msg) {
	    String alert = invoiceCreation.alertForRepeatTimes();
	    if(alert.equalsIgnoreCase(msg))	{
	    	Assert.assertTrue(true);
	    } else {
	    	Assert.assertTrue(false);
	    }
	}
	
	@When("Enter decimal value in occurence field")
	public void enter_decimal_value_in_occurence_field() {
		Map<Boolean,String> status = invoiceCreation.enterOccurence();
	    Assert.assertTrue(status.get(false), status.containsKey(true));
	}
	
	@Then("Error throwss {string}")
	public void error_throwss(String msg) {
	    String alert = invoiceCreation.alertForOccurence();
	    if(alert.equalsIgnoreCase(msg))	{
	    	Assert.assertTrue(true);
	    } else {
	    	Assert.assertTrue(false);
	    }
	}

	//Check whether system throws "Unexpected value provided!" while entering negative values, Zero and alphabets in Quantity field while editing item after adding it
	
	@When("User clicks item edit button")
	public void user_clicks_item_edit_button() {
		Map<Boolean,String> status = invoiceCreation.clickEditAfterAddingItem();
	    Assert.assertTrue(status.get(false), status.containsKey(true));
	}
	
	@When("User enters Quantity in edit option {string}")
	public void user_enters_quantity_in_edit_option(String Qty) {
		Map<Boolean,String> status = invoiceCreation.editQuantityInEditItem(Qty);
	    Assert.assertTrue(status.get(false), status.containsKey(true));
	}
	
	@When("User clicks out of Quantity field")
	public void user_clicks_out_of_quantity_field() {
		Map<Boolean,String> status = invoiceCreation.clickOutOfQuantityField();
	    Assert.assertTrue(status.get(false), status.containsKey(true));
	}

	//Check whether system throws error while entering more than 100% and less than 0% in discount in item edit
	
	@When("Discount is {string}")
	public void discount_is(String discount) {
		Map<Boolean,String> status = invoiceCreation.enterDiscountInItemEdit(discount);
	    Assert.assertTrue(status.get(false), status.containsKey(true));
	}
	
	@When("User clicks submit button")
	public void user_clicks_submit_button() {
		Map<Boolean,String> status = invoiceCreation.clickSubmit();
	    Assert.assertTrue(status.get(false), status.containsKey(true));
	}

	//Check whether system throws error while entering discount amount greater than total amount in item edit
	
	@When("Discount greater than net unit price")
	public void discount_greater_than_net_unit_price() {
		Map<Boolean,String> status = invoiceCreation.enterDiscountinEdit();
	    Assert.assertTrue(status.get(false), status.containsKey(true));
	}

	//Check whether user can close edit item popup
	
	@When("User closes popup")
	public void user_closes_popup() {
		Map<Boolean,String> status = invoiceCreation.closeItemEditPopup();
	    Assert.assertTrue(status.get(false), status.containsKey(true));
	}
	
	@Then("Verify the popup close")
	public void verify_the_popup_close() {
	    boolean status = invoiceCreation.VerifyThePopupClose();
	    if(status)	{
	    	Assert.assertTrue(true);
	    } else {
	    	Assert.assertTrue(false);
	    }
	}

	//Check whether system throws "Select Orders" if we click Select order button in consolidated orders popup by choosing Consignment location without selecting orders
	
	@When("Choose location as consignment")
	public void choose_location_as_consignment() {
		Map<Boolean,String> status = invoiceCreation.clickLocation();
	    Assert.assertTrue(status.get(false), status.containsKey(true));
	    Map<Boolean,String> status1 = invoiceCreation.chooseLocation();
	    Assert.assertTrue(status1.get(false), status1.containsKey(true));
	}
	
	@When("User clicks Select consolidated orders button")
	public void user_clicks_select_consolidated_orders_button() {
		Map<Boolean,String> status = invoiceCreation.clickConsolidatedOrdersButton();
	    Assert.assertTrue(status.get(false), status.containsKey(true));
	}
	
	@When("User clicks select order button")
	public void user_clicks_select_order_button() {
		Map<Boolean,String> status = invoiceCreation.clickSelectOrdersButton();
	    Assert.assertTrue(status.get(false), status.containsKey(true));
	}

	//Check whether system throws "Please select above first" if we select order and click select order button without choosing customer in consolidated orders popup by choosing consignment location
	
	@When("Choose order")
	public void choose_order() {
		Map<Boolean,String> status = invoiceCreation.chooseConsolidatedOrder();
	    Assert.assertTrue(status.get(false), status.containsKey(true));
	}
	
	//Check whether order is added to order items table after selecting order in consolidated order popup and clicking select order button
	
	@Then("Order is added to order items table")
	public void order_is_added_to_order_items_table() {
	    boolean status = invoiceCreation.verifyOrderTable();
	    if(status) {
	    	Assert.assertTrue(true);
	    } else {
	    	Assert.assertTrue(false);
	    }
	}

	//Check whether clicking cancel button in consolidated orders popup closes the popup
	
	@When("User clicks cancel button in consolidated order popup")
	public void user_clicks_cancel_button_in_consolidated_order_popup() {
		Map<Boolean,String> status = invoiceCreation.clickCancelButton();
	    Assert.assertTrue(status.get(false), status.containsKey(true));
	}
	
	@Then("Verify it")
	public void verify_it() throws Exception {
		Thread.sleep(1000);
	    boolean status = invoiceCreation.verifyConsolidatedOrderPopupClosed();
	    if(status == false) {
	    	Assert.assertTrue(true);
	    } else {
	    	Assert.assertTrue(false);
	    }
	}

	//Check whether user is able to close consolidated orders popup
	
	@When("User closes consolidated orders popup")
	public void user_closes_consolidated_orders_popup() {
		Map<Boolean,String> status = invoiceCreation.closeConsolidatedOrderPopup();
	    Assert.assertTrue(status.get(false), status.containsKey(true));
	}
	
	//Check whether system throws "Item SKU  and Item Name  is required." when clicking submit button in new item creation (Consignment location)
	
	@When("User scrolls down to new item button")
	public void user_scrolls_down_to_new_item_button() {
	    invoiceCreation.scroll8();
	}
	
	@When("User clicks new item button")
	public void user_clicks_new_item_button() {
		Map<Boolean,String> status = invoiceCreation.clickNewItemButton();
	    Assert.assertTrue(status.get(false), status.containsKey(true));
	}
	
	@When("User clicks submit button in new item creation")
	public void user_clicks_submit_button_in_new_item_creation() {
		Map<Boolean,String> status = invoiceCreation.clickSubmitButtonForNewItem();
	    Assert.assertTrue(status.get(false), status.containsKey(true));
	}

	//Check whether user is able to quickly add new item
	
	@When("User enters SKU")
	public void user_enters_sku() {
		Map<Boolean,String> status = invoiceCreation.enterSKU();
	    Assert.assertTrue(status.get(false), status.containsKey(true));
	}
	
	@When("User enters Item name")
	public void user_enters_item_name() {
		Map<Boolean,String> status = invoiceCreation.enterItemName();
	    Assert.assertTrue(status.get(false), status.containsKey(true));
	}
	
	@Then("Item should be added to order items table")
	public void item_should_be_added_to_order_items_table() throws Exception {
		Thread.sleep(1000);
	    boolean status = invoiceCreation.verifyOrderTable();
	    if(status) {
	    	Assert.assertTrue(true);
	    } else {
	    	Assert.assertTrue(false);
	    }
	}

	//Check whether user is able to close item add popup
	
	@When("User closed item add popup")
	public void user_closed_item_add_popup() throws Exception {
		Map<Boolean,String> status = invoiceCreation.closeAddItemPopup();
	    Assert.assertTrue(status.get(false), status.containsKey(true));
	    Thread.sleep(1000);
	}
	
	//Check whether system throws "Unexpected value provided!" while entering negative values, Zero and alphabets in Quantity field in new item popup
	
	@When("User enters quantity {string}")
	public void user_enters_quantity(String quantity) {
		Map<Boolean,String> status = invoiceCreation.enterQty(quantity);
	    Assert.assertTrue(status.get(false), status.containsKey(true));
	}
	
	@When("User clicks outside the quantity field")
	public void user_clicks_outside_the_quantity_field() {
		Map<Boolean,String> status = invoiceCreation.clickOutQtyField();
	    Assert.assertTrue(status.get(false), status.containsKey(true));
	}

	//Check whether system throws error while entering more than 100% and less than 0% in discount in new item popup
	
	@When("User enters discount {string}")
	public void user_enters_discount(String disc) {
		Map<Boolean,String> status = invoiceCreation.enterDiscInNewItemPopup(disc);
	    Assert.assertTrue(status.get(false), status.containsKey(true));
	}
	
	@When("User enters unit price")
	public void user_enters_unit_price() {
		Map<Boolean,String> status = invoiceCreation.enterUnitPriceInNewItemPopup();
	    Assert.assertTrue(status.get(false), status.containsKey(true));
	}

	//Check whether user is able to create new item with discount percentage in new item popup
	
	@Then("Item should be added to order items table with discount")
	public void item_should_be_added_to_order_items_table_with_discount() throws Exception {
		Thread.sleep(1000);
	    String status = invoiceCreation.verifyDiscAmountForNewItem();
	    System.out.println(status);
	    if(status.equalsIgnoreCase("0.00")) {
	    	Assert.assertTrue(false);
	    } else {
	    	Assert.assertTrue(true);
	    }
	}


















	
	



















}
