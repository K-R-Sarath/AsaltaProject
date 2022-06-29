package stepDefinitions;

import java.util.Map;

import org.junit.Assert;

import cucumber.TestContext;
import io.cucumber.java.en.*;
import pageObjects.SaleOrderListPage;

public class SaleOrderListPageSteps {
	
	TestContext testContext;
	SaleOrderListPage saleOrderList;
	
	public SaleOrderListPageSteps(TestContext context) {
		testContext = context;
		saleOrderList = testContext.getPageObjectManager().getSaleOrderListPage();
	}
	
	
	//Check whether system throws alert for customer field and shipping address field when we leave it empty and save sale order
	
	@When("User clicks new order button")
	public void user_clicks_new_order_button() {
		Map<Boolean,String> status = saleOrderList.clickNewOrderButton();
		Assert.assertTrue(status.get(false),status.containsKey(true));
	}
	
	//Check whether user is able to upload document	

	
	@When("User clicks sale order details")
	public void user_clicks_sale_order_details() {
		Map<Boolean,String> status = saleOrderList.clickSaleOrderDetails();
		Assert.assertTrue(status.get(false),status.containsKey(true));
	}
	
	@Then("User verifies the attachment in view page")
	public void user_verifies_the_attachment_in_view_page() {
		boolean status = saleOrderList.attachmentVerification();
		if(status)
			Assert.assertTrue(true);
		else
			Assert.assertTrue(false);
	}
	
	//Check whether user is able to add another item 
	
	@When("User clicks Edit Sale Order")
	public void user_clicks_edit_sale_order() {
		Map<Boolean,String> status = saleOrderList.clickEditSaleOrder();
		Assert.assertTrue(status.get(false),status.containsKey(true));
	}

	//Check whether user is able to delete the sale order	
	
	@When("mouse hover on toast")
	public void mouse_hover_on_toast() {
		Map<Boolean,String> status = saleOrderList.mouseHover();
		Assert.assertTrue(status.get(false),status.containsKey(true));
	}

	@When("User clicks Delete sale order")
	public void user_clicks_delete_sale_order() throws InterruptedException {
		Thread.sleep(2000);
		Map<Boolean,String> status = saleOrderList.clickDeleteSaleOrder();
		Assert.assertTrue(status.get(false),status.containsKey(true));
	}
	
	@When("User selects yes in delete popup")
	public void user_selects_yes_in_delete_popup() {
		Map<Boolean,String> status = saleOrderList.yesInPopup();
		Assert.assertTrue(status.get(false),status.containsKey(true));
	}

	//Check whether sale order can be emailed
	
	@When("User clicks email sale order")
	public void user_clicks_email_sale_order() {
		Map<Boolean,String> status = saleOrderList.clickEmailSaleOrder();
		Assert.assertTrue(status.get(false),status.containsKey(true));
	}

	//Check whether user is able to create invoice for the sale order	
	
	@When("User clicks create invoice")
	public void user_clicks_create_invoice() {
		Map<Boolean,String> status = saleOrderList.clickCreateInvoice();
		Assert.assertTrue(status.get(false),status.containsKey(true));
	}
	 
	@Then("Verify tick mark for invoice")
	public void verify_tick_mark_for_invoice() {
	    String status = saleOrderList.invoiceTick();
	    if(status.equalsIgnoreCase("fa fa-lg fa-check green-text ")) 
	    	Assert.assertTrue(true);
	    else
	    	Assert.assertTrue(false);
	}

	//Check whether user is able to create invoice for the sale order	and track till delivery
	
	@When("Clicks Invoice")
	public void clicks_invoice() {
		Map<Boolean,String> status1 = saleOrderList.clickInvoice();
		Assert.assertTrue(status1.get(false),status1.containsKey(true));
	}
	
	@When("User clicks ALL")
	public void user_clicks_all() {
		Map<Boolean,String> status1 = saleOrderList.clickAll();
		Assert.assertTrue(status1.get(false),status1.containsKey(true));
	}
	
	@Then("Verify tick mark for payment")
	public void verify_tick_mark_for_payment() {
		String status = saleOrderList.paymentTick();
	    if(status.equalsIgnoreCase("fa fa-check fa-lg green-text")) 
	    	Assert.assertTrue(true);
	    else
	    	Assert.assertTrue(false);
	}
	
	@Then("Verify packed status")
	public void verify_packed_status() {
		/*String status = saleOrderList.packedTickBeforePicking();
	    if(status.equalsIgnoreCase("fa fa-check fa-lg text-info")) 
	    	Assert.assertTrue(true);
	    else
	    	Assert.assertTrue(false);*/
	}
	
	@When("User clicks item pick list from actions menu")
	public void user_clicks_item_pick_list_from_actions_menu() {
		Map<Boolean,String> status1 = saleOrderList.clickItemPickList();
		Assert.assertTrue(status1.get(false),status1.containsKey(true));
	}
	
	@Then("Verify packed status after pick")
	public void verify_packed_status_after_pick() {
		String status = saleOrderList.packedTickAfterPicking();
	    if(status.equalsIgnoreCase("fa fa-check fa-lg green-text")) 
	    	Assert.assertTrue(true);
	    else
	    	Assert.assertTrue(false);
	}
	
	@When("User clicks deliveries from side menu")
	public void user_clicks_deliveries_from_side_menu() throws InterruptedException {
		Thread.sleep(1000);
		Map<Boolean,String> status1 = saleOrderList.clickDeliveries();
		Assert.assertTrue(status1.get(false),status1.containsKey(true));
	}
	
	@Then("Verify ReadyToShip status")
	public void verify_ready_to_ship_status() {
		String status = saleOrderList.readyToShip();
	    if(status.equalsIgnoreCase("fa fa-check fa-lg green-text")) 
	    	Assert.assertTrue(true);
	    else
	    	Assert.assertTrue(false);
	}
	
	@Then("Verify Shipped status")
	public void verify_shipped_status() {
		String status = saleOrderList.shipped();
	    if(status.equalsIgnoreCase("fa fa-check fa-lg green-text")) 
	    	Assert.assertTrue(true);
	    else
	    	Assert.assertTrue(false);
	}
	
	@Then("Verify Delivered status")
	public void verify_delivered_status() {
		String status = saleOrderList.delivered();
	    if(status.equalsIgnoreCase("fa fa-check fa-lg green-text")) 
	    	Assert.assertTrue(true);
	    else
	    	Assert.assertTrue(false);
	}

	//Check whether user can delete sale orders in bulk
	
	@When("User clicks more in sale order")
	public void user_clicks_more_in_sale_order() {
		Map<Boolean,String> status = saleOrderList.clickMoreButton();
		Assert.assertTrue(status.get(false),status.containsKey(true));
	}
	
	@When("User chooses delete sale order")
	public void user_chooses_delete_sale_order() {
		Map<Boolean,String> status = saleOrderList.clickDeleteSOinBulk();
		Assert.assertTrue(status.get(false),status.containsKey(true));
	}
	
	@When("User selects SO by checkboxes")
	public void user_selects_so_by_checkboxes() {
		boolean status = saleOrderList.checkSO();
	    if(status) {
	    	Assert.assertTrue(true);
	    }else {
	    	Assert.assertTrue(false);
	    }
	}
	
	@When("User clicks delete button for SO")
	public void user_clicks_delete_button_for_so() {
		Map<Boolean,String> status = saleOrderList.clickDeleteButton();
		Assert.assertTrue(status.get(false),status.containsKey(true));
	}
	
	@When("User selects yes in bulk delete popup")
	public void user_selects_yes_in_bulk_delete_popup() {
		Map<Boolean,String> status = saleOrderList.clickBulkDeleteSO();
		Assert.assertTrue(status.get(false),status.containsKey(true));
	}

	//Check whether adding sale order to delivery without invoicing  throws "Kindly Invoice the Sale order"
	
	@When("User chooses add to delivery")
	public void user_chooses_add_to_delivery() {
		Map<Boolean,String> status = saleOrderList.clickBulkAddDelivery();
		Assert.assertTrue(status.get(false),status.containsKey(true));
	}
	
	@When("User selects SO by checkboxes for delivery")
	public void user_selects_so_by_checkboxes_for_delivery() {
		boolean status = saleOrderList.checkSOforDelivery();
	    if(status) {
	    	Assert.assertTrue(true);
	    }else {
	    	Assert.assertTrue(false);
	    }
	}
	
	@When("User clicks Convert to DO button")
	public void user_convert_change_to_do_button() {
		Map<Boolean,String> status = saleOrderList.clickConvertToDOButton();
		Assert.assertTrue(status.get(false),status.containsKey(true));
	}

	@Then("System throws alert {string}")
	public void system_throws_alert(String message) {
	    String status = saleOrderList.alert();
	    if(status.equalsIgnoreCase(message))
	    	Assert.assertTrue(true);
	    else
	    	Assert.assertTrue(false);
	}
	
	//Check whether adding the already added invoice to delivery throws "Invoice already added to deliveries"
	
	@Then("System throws alert as {string}")
	public void system_throws_alert_as(String message) {
		String status = saleOrderList.alert1();
	    if(status.equalsIgnoreCase(message))
	    	Assert.assertTrue(true);
	    else
	    	Assert.assertTrue(false);
	}



















	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
