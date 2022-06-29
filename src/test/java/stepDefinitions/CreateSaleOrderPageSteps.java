package stepDefinitions;

import java.util.Map;

import org.junit.Assert;

import cucumber.TestContext;
import io.cucumber.java.en.*;
import pageObjects.CreateSaleOrderPage;

public class CreateSaleOrderPageSteps {
	
	TestContext testContext;
	CreateSaleOrderPage saleOrderCreation;
	
	public CreateSaleOrderPageSteps(TestContext context) {
		testContext = context;
		saleOrderCreation = testContext.getPageObjectManager().getSaleOrderCreationPage();
	}
	
	//Check whether system throws alert for customer field and shipping address field when we leave it empty and save sale order
		
	@When("User chooses customer in new sale order page")
	public void user_chooses_customer_in_new_sale_order_page() {
		Map<Boolean,String> status = saleOrderCreation.clickCustomerField();
		Assert.assertTrue(status.get(false),status.containsKey(true));
		Map<Boolean,String> status1 = saleOrderCreation.enterCustomerName();
		Assert.assertTrue(status1.get(false),status1.containsKey(true));
		Map<Boolean,String> status2 = saleOrderCreation.selectCustomer();
		Assert.assertTrue(status2.get(false),status2.containsKey(true));
		
	}
	
	@When("User clicks save sale order button")
	public void user_clicks_save_sale_order_button() {
		Map<Boolean,String> status = saleOrderCreation.clickSaveSaleOrderButton();
		Assert.assertTrue(status.get(false),status.containsKey(true));
	}

	//Check whether system throws error while entering discount amount greater than total amount in new sale order page
	
	@When("User enters discount amount greater than total amount")
	public void user_enters_discount_amount_greater_than_total_amount() {
		Map<Boolean,String> status = saleOrderCreation.enterDiscount();
		Assert.assertTrue(status.get(false),status.containsKey(true));
	}
	
	@When("User clicks out of the discount field")
	public void user_clicks_out_of_the_discount_field() {
		Map<Boolean,String> status = saleOrderCreation.clickOutOfDiscount();
		Assert.assertTrue(status.get(false),status.containsKey(true));
	}
	
	//Check whether user is able to create customer inside new sale order page
	
	@When("Click OK in bootbox alert")
	public void click_ok_in_bootbox_alert() {
		Map<Boolean,String> status = saleOrderCreation.clickOKinBootbox();
		Assert.assertTrue(status.get(false),status.containsKey(true));
	}

	//Check whether user can close add new custom field popup and add new customer popup
	
	@When("User closes add new custom field popup and add new customer popup in new sale order page")
	public void user_closes_add_new_custom_field_popup_and_add_new_customer_popup_in_new_sale_order_page() throws Exception {
		Map<Boolean,String> status = saleOrderCreation.closeCustomfieldPopup();
	    Assert.assertTrue(status.get(false), status.containsKey(true));
	    Map<Boolean,String> status1 = saleOrderCreation.closeCustomerPopup();
	    Assert.assertTrue(status1.get(false), status.containsKey(true));
	}
	
	//Check whether the page gets resets after clicking reset button
	
	@When("Scroll back to customer field")
	public void scroll_back_to_customer_field() {
	    saleOrderCreation.scroll1();
	}
	
	@Then("Verify whether page resetted")
	public void verify_whether_page_resetted() {
		String status = saleOrderCreation.afterReset();
		   if(status.equals("Select Customer")){
			   Assert.assertTrue(true);
		   } else {
			   Assert.assertTrue(false);
		   }
	}

	//Check whether user is able to upload document	
	
	@When("User attachs document to sale order")
	public void user_attachs_document_to_sale_order() {
		Map<Boolean,String> status = saleOrderCreation.attachFile();
		Assert.assertTrue(status.get(false),status.containsKey(true));
	}









	
	
	
	
	
	
	
	
	

}
