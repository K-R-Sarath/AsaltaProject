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
	public void user_navigates_to_invoice_creation_page_and_enters_invoice_details() {
	   Map<Boolean,String> status = invoiceCreation.clickCustomerField();
	   Assert.assertTrue(status.get(false),status.containsKey(true));
	   Map<Boolean,String> status1 = invoiceCreation.enterCustomerName();
	   Assert.assertTrue(status1.get(false),status1.containsKey(true));
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
	    Thread.sleep(3000);
	    Map<Boolean,String> status1 = invoiceCreation.selectItem();
	    Assert.assertTrue(status1.get(false),status1.containsKey(true));
	    Thread.sleep(3000);
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
	    Thread.sleep(10000);
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
		Thread.sleep(10000);
	    
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




















}
