package stepDefinitions;

import java.util.Map;

import org.junit.Assert;

import cucumber.TestContext;
import io.cucumber.java.en.*;
import pageObjects.EditDeliveryPage;

public class EditDeliveryPageSteps {
	
	TestContext testContext;
	EditDeliveryPage editDelivery;
	
	public EditDeliveryPageSteps(TestContext context) {
		testContext = context;
		editDelivery = testContext.getPageObjectManager().getEditDeliveryPage();
	}
	
	@When("User scrolls down to delivery status")
	public void user_scrolls_down_to_delivery_status() {
	   editDelivery.scrollToDeliveryStatus();
	}
	@When("User changes delivery status to Packed")
	public void user_changes_delivery_status_to_packed() {
	   Map<Boolean,String> status = editDelivery.clickDeliveryStatus();
	   Assert.assertTrue(status.get(false), status.containsKey(true));
	   Map<Boolean,String> status1 = editDelivery.clickPackedStatus();
	   Assert.assertTrue(status1.get(false), status1.containsKey(true));
	}
	
	@Then("two fields are newly introduced")
	public void two_fields_are_newly_introduced() {
		boolean Packed = editDelivery.pack();
		if(Packed) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}
	
	@Then("User clicks save delivery button")
	public void user_clicks_save_delivery_button() {
		Map<Boolean,String> status = editDelivery.clickSaveDeliveryButton();
		Assert.assertTrue(status.get(false), status.containsKey(true));	    
	}

	
	//Check when we change delivery status to "Ready To Ship", then in list page, status should change to Ready To Ship

	@When("User changes delivery status to Ready To Ship")
	public void user_changes_delivery_status_to_ready_to_ship() {
		Map<Boolean,String> status = editDelivery.clickDeliveryStatus();
		Assert.assertTrue(status.get(false), status.containsKey(true));
		Map<Boolean,String> status1 = editDelivery.clickReadyToShipStatus();
		Assert.assertTrue(status1.get(false), status1.containsKey(true));
	}

	//Shipped
	
	@When("User changes delivery status to Shipped")
	public void user_changes_delivery_status_to_shipped() {
		Map<Boolean,String> status = editDelivery.clickDeliveryStatus();
		Assert.assertTrue(status.get(false), status.containsKey(true));
		Map<Boolean,String> status1 = editDelivery.clickShippedStatus();
		Assert.assertTrue(status1.get(false), status1.containsKey(true));		
	}
	
	//OnHold

	@When("User changes delivery status to OnHold")
	public void user_changes_delivery_status_to_on_hold() {
		Map<Boolean,String> status = editDelivery.clickDeliveryStatus();
		Assert.assertTrue(status.get(false), status.containsKey(true));
		Map<Boolean,String> status1 = editDelivery.clickOnHoldStatus();
		Assert.assertTrue(status1.get(false), status1.containsKey(true));
	}

	//Cancelled

	@When("User changes delivery status to Cancelled")
	public void user_changes_delivery_status_to_cancelled() {
		Map<Boolean,String> status = editDelivery.clickDeliveryStatus();
		Assert.assertTrue(status.get(false), status.containsKey(true));
		Map<Boolean,String> status1 = editDelivery.clickCancelledStatus();
		Assert.assertTrue(status1.get(false), status1.containsKey(true));
	}

	//Delivered

	@When("User changes delivery status to Delivered")
	public void user_changes_delivery_status_to_delivered() {
		Map<Boolean,String> status = editDelivery.clickDeliveryStatus();
		Assert.assertTrue(status.get(false), status.containsKey(true));
		Map<Boolean,String> status1 = editDelivery.clickDeliveredStatus();
		Assert.assertTrue(status1.get(false), status1.containsKey(true));
	}









}
