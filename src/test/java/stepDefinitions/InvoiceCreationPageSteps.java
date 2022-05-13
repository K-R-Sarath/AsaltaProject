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
	   Thread.sleep(50000);
	   Map<Boolean,String> status2 = invoiceCreation.selectCustomer();
	   Assert.assertTrue(status2.get(false),status2.containsKey(true));
	   invoiceCreation.scroll();
	   Map<Boolean,String> status3 = invoiceCreation.enterItem();
	   Assert.assertTrue(status3.get(false), status3.containsKey(true));
	   Map<Boolean,String> status4 = invoiceCreation.selectItem();
	   Assert.assertTrue(status4.get(false), status4.containsKey(true));
	   
	}
	@When("Click save sale button")
	public void click_save_sale_button() {
	    Map<Boolean,String> status = invoiceCreation.clickAddSaleButton();
	    Assert.assertTrue(status.get(false),status.containsKey(true));
		
	}
	@Then("Invoice created successfully")
	public void invoice_created_successfully() {
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

	@When("User enters discount {string}")
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
	   
	}
	
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
	public void user_enters_name_of_the_customer_as(String customerName) {
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















	




















	



























}
