package stepDefinitions;

import java.util.Map;

import org.junit.Assert;

import cucumber.TestContext;
import io.cucumber.java.en.*;
import pageObjects.DeliveryListPage;

public class DeliveryListPageSteps {
	
	TestContext testContext;
	DeliveryListPage delivery;
	
	public DeliveryListPageSteps(TestContext context)	{
		testContext = context;
		delivery = testContext.getPageObjectManager().getDeliveryListPage();
	}
	
	@Then("Invoice should be added to delivery list with {string} status")
	public void invoice_should_be_added_to_delivery_list_with_status(String DOstatus) {
	    String status = delivery.deliveryStatus();
	    if(status.equalsIgnoreCase(DOstatus)) {
	    	Assert.assertTrue(true);
	    }else {
	    	Assert.assertTrue(false);
	    }
	}
	
	//Check whether "Packed" delivery status introduces two new fields called "Packed By" and "Packed Date & Time"
	
	@When("User cicks edit deliveries option")
	public void user_cicks_edit_deliveries_option() {
	    Map<Boolean,String> status = delivery.editDelivery();
	    Assert.assertTrue(status.get(false), status.containsKey(true));
	}
	
	@Then("Status should be changed to Packed in deliveries list page")
	public void status_should_be_changed_to_packed_in_deliveries_list_page() {
	    String status = delivery.deliveryStatus();
	    if(status.equalsIgnoreCase("Packed")) {
	    	Assert.assertTrue(true);
	    }else {
	    	Assert.assertTrue(false);
	    }
	}
	
	@Then("Status should be changed to {string} in deliveries list page")
	public void status_should_be_changed_to_in_deliveries_list_page(String DOStatus) {
		String status = delivery.deliveryStatus();
	    if(status.equalsIgnoreCase(DOStatus)) {
	    	Assert.assertTrue(true);
	    }else {
	    	Assert.assertTrue(false);
	    }
	}
	
	//Check whether user can able to delete delivery from delivery list individually

	@When("User clicks Delete delivery option")
	public void user_clicks_delete_delivery_option() {
		Map<Boolean,String> status = delivery.deleteDelivery();
	    Assert.assertTrue(status.get(false), status.containsKey(true));
	}
	
	@When("User choose Yes in confirmation")
	public void user_choose_yes_in_confirmation() {
		Map<Boolean,String> status = delivery.deleteConfirmation();
	    Assert.assertTrue(status.get(false), status.containsKey(true));
	}

	//Check whether user is able to delete deliveries in bulk

	@When("User clicks More option")
	public void user_clicks_more_option() {
	   Map<Boolean,String> status = delivery.clickMoreOption();
	   Assert.assertTrue(status.get(false), status.containsKey(true));
	}
	
	@When("User clicks delete deliveries")
	public void user_clicks_delete_deliveries() throws Exception {
		Map<Boolean,String> status = delivery.clickDeleteDeleveries();
		Assert.assertTrue(status.get(false), status.containsKey(true));
		Thread.sleep(3000);
	}
	
	@When("User chooses deliveries")
	public void user_chooses_deliveries() {
	    boolean status = delivery.chooseCheckBox();
	    if(status) {
	    	Assert.assertTrue(true);
	    }else {
	    	Assert.assertTrue(false);
	    }
	}
	
	@When("User clicks delete button")
	public void user_clicks_delete_button() {
	    Map<Boolean,String> status = delivery.clickDelete();
	    Assert.assertTrue(status.get(false), status.containsKey(true));
	}
	
	@When("User chooses Yes in confirmation")
	public void user_chooses_yes_in_confirmation() {
	    Map<Boolean,String> status = delivery.clickYesConfirm();
	    Assert.assertTrue(status.get(false),status.containsKey(true));
	}

	//Check whether user is able to change status in bulk

	@When("User clicks Change Status")
	public void user_clicks_change_status() {
	    Map<Boolean,String> status = delivery.changeStatus();
	    Assert.assertTrue(status.get(false), status.containsKey(true));
	}
	
	@When("User clicks Change status button")
	public void user_clicks_change_status_button() {
	    Map<Boolean,String> status = delivery.clickChangeStatusButton();
	    Assert.assertTrue(status.get(false), status.containsKey(true));
	}
	
	@When("User selects status")
	public void user_selects_status() {
	    Map<Boolean,String> status = delivery.clickStatus();
	    Assert.assertTrue(status.get(false), status.containsKey(true));
	    Map<Boolean,String> status1 = delivery.chooseStatus();
	    Assert.assertTrue(status1.get(false), status1.containsKey(true));
	}
	
	@When("User clicks update status button")
	public void user_clicks_update_status_button() {
	    Map<Boolean,String> status = delivery.updateStatus();
	    Assert.assertTrue(status.get(false), status.containsKey(true));
	}

	//Check whether user is able to assign driver in bulk

	@When("User clicks Assign to Driver")
	public void user_clicks_assign_to_driver() {
	   Map<Boolean,String> status = delivery.assignToDriver();
	   Assert.assertTrue(status.get(false), status.containsKey(true));
	}
	
	@When("User clicks Assign Driver button")
	public void user_clicks_assign_driver_button() {
	   Map<Boolean,String> status = delivery.clickAssignDriverButton();
	   Assert.assertTrue(status.get(false), status.containsKey(true));
	}
	
	@When("User selects Driver")
	public void user_selects_driver() {
	    Map<Boolean,String> status = delivery.clickDriver();
	    Assert.assertTrue(status.get(false), status.containsKey(true));
	    Map<Boolean,String> status1 = delivery.chooseDriver();
	    Assert.assertTrue(status1.get(false), status1.containsKey(true));
	}
	
	@When("User clicks Assign Driver")
	public void user_clicks_assign_driver() {
	    Map<Boolean,String> status = delivery.submitDriver();
	    Assert.assertTrue(status.get(false), status.containsKey(true));
	}








}
