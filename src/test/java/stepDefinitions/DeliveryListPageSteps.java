package stepDefinitions;

import java.awt.AWTException;
import java.text.ParseException;
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

	//Check whether system throws "Picked quantity updated successfully" when we update picked quantity
	
	@When("User clicks Item Pick List")
	public void user_clicks_item_pick_list() {
		Map<Boolean,String> status = delivery.clickItemPickList();
	    Assert.assertTrue(status.get(false), status.containsKey(true));
	}
	
	@When("User updates quantity")
	public void user_updates_quantity() {
		Map<Boolean,String> status = delivery.enterPickedQty();
	    Assert.assertTrue(status.get(false), status.containsKey(true));
	}
	
	@When("User clicks the submit button")
	public void user_clicks_the_submit_button() {
		Map<Boolean,String> status = delivery.clickSubmitButton();
	    Assert.assertTrue(status.get(false), status.containsKey(true));
	}

	@When("User clicks outside")
	public void user_clicks_outside() throws AWTException, InterruptedException {
	    delivery.clickOut();
	}
	
	@Then("Status should be changed to {string}")
	public void status_should_be_changed_to(String msg) {
	    String status = delivery.statusAfterPickQty();
	    if(status.equalsIgnoreCase(msg)) {
	    	Assert.assertTrue(true);
	    } else {
	    	Assert.assertTrue(false);
	    }
	}

	//Check whether clicking edit in picklist popup navigates to edit deliveries page
	
	@When("User clicks Edit in picklist popup")
	public void user_clicks_edit_in_picklist_popup() {
		Map<Boolean,String> status = delivery.clickEditBtn();
	    Assert.assertTrue(status.get(false), status.containsKey(true));
	}
	
	//Check whether packing slip can be viewed	
	
	@When("User clicks packing slip option")
	public void user_clicks_packing_slip_option() {
		Map<Boolean,String> status = delivery.clickPackingSlip();
	    Assert.assertTrue(status.get(false), status.containsKey(true));
	}
	
	@Then("Packing slip should be displayed")
	public void packing_slip_should_be_displayed() {
	    String status = delivery.packSlip();
	    if(status.equalsIgnoreCase("Packing Slip")) {
	    	Assert.assertTrue(true);
	    } else {
	    	Assert.assertTrue(false);
	    }
	}

	//Check whether clicking edit in packingslip popup navigates to edit deliveries page
	
	@When("User clicks edit in packing slip")
	public void user_clicks_edit_in_packing_slip() {
		Map<Boolean,String> status = delivery.clickEditBtn();
	    Assert.assertTrue(status.get(false), status.containsKey(true));
	}

	//Check whether picklist popup closes when we click close
	
	@When("User closes the picklist popup")
	public void user_closes_the_picklist_popup() throws InterruptedException {
		Map<Boolean,String> status = delivery.clickClosePickListPopup();
	    Assert.assertTrue(status.get(false), status.containsKey(true));
	    Thread.sleep(1000);
	}
	
	@Then("Verify picklist popup closed")
	public void verify_picklist_popup_closed() {
	    boolean status = delivery.verifyPickListPopup();
	    if(status) {
	    	Assert.assertTrue(false);
	    } else {
	    	Assert.assertTrue(true);
	    }
	}

	//Check whether packing slip popup closes when we click close
	
	@When("User closes the packing slip option")
	public void user_closes_the_packing_slip_option() throws InterruptedException {
		Map<Boolean,String> status = delivery.clickClosePackingSlipPopup();
	    Assert.assertTrue(status.get(false), status.containsKey(true));
	    Thread.sleep(1000);
	}
	
	@Then("Verify packing slip popup closed")
	public void verify_packing_slip_popup_closed() {
		boolean status = delivery.verifyPackingSlipPopup();
	    if(status) {
	    	Assert.assertTrue(false);
	    } else {
	    	Assert.assertTrue(true);
	    }
	}

	//Check whether clicking PENDING in deliveries list page, displays deliveries which are PENDING
	
	@When("User clicks Pending in top of the page")
	public void user_clicks_pending_in_top_of_the_page() {
		Map<Boolean,String> status = delivery.clickPendingStatus();
	    Assert.assertTrue(status.get(false), status.containsKey(true));
	}
	
	@Then("Paginate and get values for PENDING status")
	public void paginate_and_get_values_for_pending_status() throws Exception {
		boolean status = delivery.paginateAndGetValuesForPending();
		if(status) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}

	//Check whether clicking PACKED in deliveries list page, displays deliveries which are PACKED
	
	@When("User clicks Packed in top of the page")
	public void user_clicks_packed_in_top_of_the_page() {
		Map<Boolean,String> status = delivery.clickPackedStatus();
	    Assert.assertTrue(status.get(false), status.containsKey(true));
	}
	
	@Then("Paginate and get values for PACKED status")
	public void paginate_and_get_values_for_packed_status() {
		boolean status = delivery.paginateAndGetValuesForPacked();
		if(status) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}

	//Check whether clicking READY TO SHIP in deliveries list page, displays deliveries which are READY TO SHIP
	
	@When("User clicks Ready To Ship in top of the page")
	public void user_clicks_ready_to_ship_in_top_of_the_page() {
		Map<Boolean,String> status = delivery.clickReadyToShipStatus();
	    Assert.assertTrue(status.get(false), status.containsKey(true));
	}
	
	@Then("Paginate and get values for READY TO SHIP status")
	public void paginate_and_get_values_for_ready_to_ship_status() {
		boolean status = delivery.paginateAndGetValuesForReadyToShip();
		if(status) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}

	//Check whether clicking SHIPPED in deliveries list page, displays deliveries which are SHIPPED
	
	@When("User clicks Shipped in top of the page")
	public void user_clicks_shipped_in_top_of_the_page() {
		Map<Boolean,String> status = delivery.clickShippedStatus();
	    Assert.assertTrue(status.get(false), status.containsKey(true));
	}
	
	@Then("Paginate and get values for SHIPPED status")
	public void paginate_and_get_values_for_shipped_status() {
		boolean status = delivery.paginateAndGetValuesForShipped();
		if(status) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}

	//Check whether clicking DELIVERED in deliveries list page, displays deliveries which are DELIVERED
	
	@When("User clicks Delivered in top of the page")
	public void user_clicks_delivered_in_top_of_the_page() {
		Map<Boolean,String> status = delivery.clickDeliveredStatus();
	    Assert.assertTrue(status.get(false), status.containsKey(true));
	}
	
	@Then("Paginate and get values for DELIVERED status")
	public void paginate_and_get_values_for_delivered_status() {
		boolean status = delivery.paginateAndGetValuesForDelivered();
		if(status) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}

	//Check whether clicking ONHOLD in deliveries list page, displays deliveries which are ONHOLD
	
	@When("User clicks Onhold in top of the page")
	public void user_clicks_onhold_in_top_of_the_page() {
		Map<Boolean,String> status = delivery.clickOnHoldStatus();
	    Assert.assertTrue(status.get(false), status.containsKey(true));
	}
	
	@Then("Paginate and get values for ONHOLD status")
	public void paginate_and_get_values_for_onhold_status() {
		boolean status = delivery.paginateAndGetValuesForOnHold();
		if(status) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}

	//Check whether clicking CANCELLED in deliveries list page, displays deliveries which are CANCELLED

	@When("User clicks Cancelled in top of the page in deliveries")
	public void user_clicks_cancelled_in_top_of_the_page_in_deliveries() {
		Map<Boolean,String> status = delivery.clickCancelledStatus();
	    Assert.assertTrue(status.get(false), status.containsKey(true));
	}

	@Then("Paginate and get values for CANCELLED status	in deliveries")
	public void paginate_and_get_values_for_cancelled_status_in_deliveries() {
		boolean status = delivery.paginateAndGetValuesForCancelled();
		if(status) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}
	
	//Check whether clicking ALL in deliveries list page, displays ALL deliveries
	
	@When("User clicks ALL in top of the page in deliveries")
	public void user_clicks_all_in_top_of_the_page_in_deliveries() {
		Map<Boolean,String> status = delivery.clickALLStatus();
	    Assert.assertTrue(status.get(false), status.containsKey(true));
	}
	
	@Then("Paginate and get values for ALL status	in deliveries")
	public void paginate_and_get_values_for_all_status_in_deliveries() {
		boolean status = delivery.paginateAndGetValuesForAll();
		if(status) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}

	//Check whether choosing Display 10 in display dropdown lists only 10 deliveries per page
	
	@When("User clicks display option in deliveries")
	public void user_clicks_display_option_in_deliveries() {
		Map<Boolean,String> status1 = delivery.clickDisplayOption();
	    Assert.assertTrue(status1.get(false), status1.containsKey(true));
	}

	@Then("Verify only ten deliveries displayed per page")
	public void verify_only_ten_deliveries_displayed_per_page() {
		String status = delivery.displayResult10();
	    if(status.equalsIgnoreCase("1 to 10")) {
	    	Assert.assertTrue(true);
	    } else {
	    	Assert.assertTrue(false);
	    }
	}
	
	@Then("Only ten deliveries present in table")
	public void only_ten_deliveries_present_in_table() {
		Integer status = delivery.resultInTable();
		if(status.equals(10)) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}

	//Check whether choosing Display 25 in display dropdown lists only 25 deliveries per page
	
	@Then("Verify only twenty five deliveries displayed per page")
	public void verify_only_twenty_five_deliveries_displayed_per_page() {
		String status = delivery.displayResult25();
	    if(status.equalsIgnoreCase("1 to 25")) {
	    	Assert.assertTrue(true);
	    } else {
	    	Assert.assertTrue(false);
	    }
	}
	
	@Then("Only twenty five deliveries present in table")
	public void only_twenty_five_deliveries_present_in_table() {
		Integer status = delivery.resultInTable();
		if(status.equals(25)) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}
	
	//Check whether choosing Display 50 in display dropdown lists only 50 deliveries per page
	
	@Then("Verify only fifty deliveries displayed per page")
	public void verify_only_fifty_deliveries_displayed_per_page() {
		String status = delivery.displayResult50();
	    if(status.equalsIgnoreCase("1 to 50")) {
	    	Assert.assertTrue(true);
	    } else {
	    	Assert.assertTrue(false);
	    }
	}
	
	@Then("Only fifty deliveries present in table")
	public void only_fifty_deliveries_present_in_table() {
		Integer status = delivery.resultInTable();
		if(status.equals(50)) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}

	//Check whether choosing Display 100 in display dropdown lists only 100 deliveries per page
	
	@Then("Verify only hundred deliveries displayed per page")
	public void verify_only_hundred_deliveries_displayed_per_page() {
		String status = delivery.displayResult100();
	    if(status.equalsIgnoreCase("1 to 100")) {
	    	Assert.assertTrue(true);
	    } else {
	    	Assert.assertTrue(false);
	    }
	}
	
	@Then("Only hundred deliveries present in table")
	public void only_hundred_deliveries_present_in_table() {
		Integer status = delivery.resultInTable();
		if(status.equals(100)) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}

	//Check whether status can be sorted in Ascending order in deliveries table

	@When("User clicks Status in deliveries")
	public void user_clicks_status_in_deliveries() {
		Map<Boolean,String> status = delivery.clickStatusForSorting();
	    Assert.assertTrue(status.get(false), status.containsKey(true));
	}
	
	@Then("User gets obtained list and sorts it in Ascending order and verify the sorted list with obtained list in deliveries")
	public void user_gets_obtained_list_and_sorts_it_in_ascending_order_and_verify_the_sorted_list_with_obtained_list_in_deliveries() {
		boolean status = delivery.verifyObtainedAndSortedStatusInAscOrder();
		   if(status) {
			   Assert.assertTrue(true);
		   } else {
			   Assert.assertTrue(false);
		   }
	}

	//Check whether status can be sorted in Descending order in deliveries table
	
	@Then("User gets obtained list and sorts it in Descending order and verify the sorted list with obtained list in deliveries")
	public void user_gets_obtained_list_and_sorts_it_in_descending_order_and_verify_the_sorted_list_with_obtained_list_in_deliveries() {
		boolean status = delivery.verifyObtainedAndSortedStatusInDescOrder();
		   if(status) {
			   Assert.assertTrue(true);
		   } else {
			   Assert.assertTrue(false);
		   }
	}

	//Check whether DODate can be sorted in Ascending order in deliveries table
	
	@When("User clicks DOdate")
	public void user_clicks_d_odate() {
		Map<Boolean,String> status = delivery.clickDODateForSorting();
	    Assert.assertTrue(status.get(false), status.containsKey(true));
	}
	
	@Then("User gets obtained list of DOdate and sorts it in Ascending order and verify the sorted list with obtained list")
	public void user_gets_obtained_list_of_d_odate_and_sorts_it_in_ascending_order_and_verify_the_sorted_list_with_obtained_list() throws ParseException {
		boolean status = delivery.verifyObtainedAndSortedDODateInAscOrder();
		   if(status) {
			   Assert.assertTrue(true);
		   } else {
			   Assert.assertTrue(false);
		   }
	}

	//Check whether DODate can be sorted in Descending order in deliveries table
	
	@Then("User gets obtained list of DOdate and sorts it in Descending order and verify the sorted list with obtained list")
	public void user_gets_obtained_list_of_d_odate_and_sorts_it_in_descending_order_and_verify_the_sorted_list_with_obtained_list() throws ParseException {
		boolean status = delivery.verifyObtainedAndSortedDODateInDescOrder();
		   if(status) {
			   Assert.assertTrue(true);
		   } else {
			   Assert.assertTrue(false);
		   }
	}
	
	//Check whether DRDate can be sorted in Ascending order in deliveries table
	
	@When("User clicks DRDate")
	public void user_clicks_dr_date() {
		Map<Boolean,String> status = delivery.clickDRDateForSorting();
	    Assert.assertTrue(status.get(false), status.containsKey(true));
	}
	
	@Then("User gets obtained list of DRDate and sorts it in Ascending order and verify the sorted list with obtained list")
	public void user_gets_obtained_list_of_dr_date_and_sorts_it_in_ascending_order_and_verify_the_sorted_list_with_obtained_list() throws Exception {
		boolean status = delivery.verifyObtainedAndSortedDRDateInAscOrder();
		   if(status) {
			   Assert.assertTrue(true);
		   } else {
			   Assert.assertTrue(false);
		   }
	}

	//Check whether DRDate can be sorted in Descending order in deliveries table
	
	@Then("User gets obtained list of DRDate and sorts it in Descending order and verify the sorted list with obtained list")
	public void user_gets_obtained_list_of_dr_date_and_sorts_it_in_descending_order_and_verify_the_sorted_list_with_obtained_list() throws Exception {
		boolean status = delivery.verifyObtainedAndSortedDRDateInDescOrder();
		   if(status) {
			   Assert.assertTrue(true);
		   } else {
			   Assert.assertTrue(false);
		   }
	}
	
	//Check whether Delivered Date can be sorted in Ascending order in deliveries table
	
	@When("User clicks Delivered Date")
	public void user_clicks_delivered_date() {
		Map<Boolean,String> status = delivery.clickDeliveredDateForSorting();
	    Assert.assertTrue(status.get(false), status.containsKey(true));
	}
	
	@Then("User gets obtained list of Delivered Date and sorts it in Ascending order and verify the sorted list with obtained list")
	public void user_gets_obtained_list_of_delivered_date_and_sorts_it_in_ascending_order_and_verify_the_sorted_list_with_obtained_list() throws ParseException {
		boolean status = delivery.verifyObtainedAndSortedDeliveredDateInAscOrder();
		   if(status) {
			   Assert.assertTrue(true);
		   } else {
			   Assert.assertTrue(false);
		   }
	}

	//Check whether Delivered Date can be sorted in Descending order in deliveries table
	
	@Then("User gets obtained list of Delivered Date and sorts it in Descending order and verify the sorted list with obtained list")
	public void user_gets_obtained_list_of_delivered_date_and_sorts_it_in_descending_order_and_verify_the_sorted_list_with_obtained_list() throws ParseException {
		boolean status = delivery.verifyObtainedAndSortedDeliveredDateInDescOrder();
		   if(status) {
			   Assert.assertTrue(true);
		   } else {
			   Assert.assertTrue(false);
		   }
	}

	//Check whether channels can be sorted in Ascending order in deliveries table
	
	@When("User clicks Channels in deliveries table")
	public void user_clicks_channels_in_deliveries_table() {
		Map<Boolean,String> status = delivery.clickChannelsForSorting();
	    Assert.assertTrue(status.get(false), status.containsKey(true));
	}
	
	@Then("User gets obtained list of channels in deliveries table and sorts it in Ascending order and verify the sorted list with obtained list")
	public void user_gets_obtained_list_of_channels_in_deliveries_table_and_sorts_it_in_ascending_order_and_verify_the_sorted_list_with_obtained_list() {
		boolean status = delivery.verifyObtainedAndSortedChannelsInAscOrder();
		   if(status) {
			   Assert.assertTrue(true);
		   } else {
			   Assert.assertTrue(false);
		   }
	}

	//Check whether channels can be sorted in Descending order in deliveries table
	
	@Then("User gets obtained list of channels in deliveries table and sorts it in Descending order and verify the sorted list with obtained list")
	public void user_gets_obtained_list_of_channels_in_deliveries_table_and_sorts_it_in_descending_order_and_verify_the_sorted_list_with_obtained_list() {
		boolean status = delivery.verifyObtainedAndSortedChannelsInDescOrder();
		   if(status) {
			   Assert.assertTrue(true);
		   } else {
			   Assert.assertTrue(false);
		   }
	}
	
	//Check whether channel order number can be sorted in Ascending order in deliveries table
	
	@When("User clicks channel order no in deliveries table")
	public void user_clicks_channel_order_no_in_deliveries_table() {
		Map<Boolean,String> status = delivery.clickChannelOrderNoForSorting();
	    Assert.assertTrue(status.get(false), status.containsKey(true));
	}
	
	@Then("User gets obtained list of channel order number in deliveries table and sorts in in ascending order and verify the sorted list with obtained list")
	public void user_gets_obtained_list_of_channel_order_number_in_deliveries_table_and_sorts_in_in_ascending_order_and_verify_the_sorted_list_with_obtained_list() {
		boolean status = delivery.verifyObtainedAndSortedChannelOrderNoInAscOrder();
		   if(status) {
			   Assert.assertTrue(true);
		   } else {
			   Assert.assertTrue(false);
		   }
	}

	//Check whether channel order number can be sorted in Descending order in deliveries table
	
	@Then("User gets obtained list of channel order number in deliveries table and sorts in in Descending order and verify the sorted list with obtained list")
	public void user_gets_obtained_list_of_channel_order_number_in_deliveries_table_and_sorts_in_in_descending_order_and_verify_the_sorted_list_with_obtained_list() {
		boolean status = delivery.verifyObtainedAndSortedChannelOrderNoInDescOrder();
		   if(status) {
			   Assert.assertTrue(true);
		   } else {
			   Assert.assertTrue(false);
		   }
	}

	//Check whether Delivery number can be sorted in Ascending order in deliveries table
	
	@When("User clicks Delivery number")
	public void user_clicks_delivery_number() {
		Map<Boolean,String> status = delivery.clickDeliveryNoForSorting();
	    Assert.assertTrue(status.get(false), status.containsKey(true));
	}
	
	@Then("User gets obtained list of delivery number and sorts it in Ascending order and verify the sorted list with obtained list")
	public void user_gets_obtained_list_of_delivery_number_and_sorts_it_in_ascending_order_and_verify_the_sorted_list_with_obtained_list() {
		boolean status = delivery.verifyObtainedAndSortedDeliveryNoInAscOrder();
		   if(status) {
			   Assert.assertTrue(true);
		   } else {
			   Assert.assertTrue(false);
		   }
	}

	//Check whether customer can be sorted in Ascending order in deliveries table
	
	@When("User clicks customers in deliveries")
	public void user_clicks_customers_in_deliveries() {
		Map<Boolean,String> status = delivery.clickCustomersForSorting();
	    Assert.assertTrue(status.get(false), status.containsKey(true));
	}
	
	@Then("User gets obtained list of customers and sorts it in Ascending order and verify the sorted list with obtained list")
	public void user_gets_obtained_list_of_customers_and_sorts_it_in_ascending_order_and_verify_the_sorted_list_with_obtained_list() {
		boolean status = delivery.verifyObtainedAndSortedCustomersInAscOrder();
		   if(status) {
			   Assert.assertTrue(true);
		   } else {
			   Assert.assertTrue(false);
		   }
	}

	//Check whether customer can be sorted in Descending order in deliveries table
	
	@Then("User gets obtained list of customers and sorts it in Descending order and verify the sorted list with obtained list")
	public void user_gets_obtained_list_of_customers_and_sorts_it_in_descending_order_and_verify_the_sorted_list_with_obtained_list() {
		boolean status = delivery.verifyObtainedAndSortedCustomersInDescOrder();
		   if(status) {
			   Assert.assertTrue(true);
		   } else {
			   Assert.assertTrue(false);
		   }
	}

	//Check whether postal code can be sorted in Ascending order in deliveries table
	
	@When("User clicks postal code")
	public void user_clicks_postal_code() {
		Map<Boolean,String> status = delivery.clickPostalCodeForSorting();
	    Assert.assertTrue(status.get(false), status.containsKey(true));
	}
	
	@Then("User gets obtained list of postal codes and sorts it in Ascending order and verify the sorted list with obtained list")
	public void user_gets_obtained_list_of_postal_codes_and_sorts_it_in_ascending_order_and_verify_the_sorted_list_with_obtained_list() {
		boolean status = delivery.verifyObtainedAndSortedPostalCodeInAscOrder();
		   if(status) {
			   Assert.assertTrue(true);
		   } else {
			   Assert.assertTrue(false);
		   }
	}

	//Check whether postal code can be sorted in Descending order in deliveries table
	
	@Then("User gets obtained list of postal codes and sorts it in Descending order and verify the sorted list with obtained list")
	public void user_gets_obtained_list_of_postal_codes_and_sorts_it_in_descending_order_and_verify_the_sorted_list_with_obtained_list() {
		boolean status = delivery.verifyObtainedAndSortedPostalCodeInDescOrder();
		   if(status) {
			   Assert.assertTrue(true);
		   } else {
			   Assert.assertTrue(false);
		   }
	}

	//Check whether filtering deliveries by date displays only deliveries of filtered date
	
	@When("User clicks DOdate field")
	public void user_clicks_d_odate_field() {
		Map<Boolean,String> status = delivery.clickDODateField();
	    Assert.assertTrue(status.get(false), status.containsKey(true));
	}
	
	@When("User clicks from DOdate field and enter date")
	public void user_clicks_from_d_odate_field_and_enter_date() {
		Map<Boolean,String> status1 = delivery.enterFromDate();
	    Assert.assertTrue(status1.get(false), status1.containsKey(true));
	}
	
	@When("User clicks to DOdate field and enter date")
	public void user_clicks_to_d_odate_field_and_enter_date() {
		Map<Boolean,String> status1 = delivery.enterToDate();
	    Assert.assertTrue(status1.get(false), status1.containsKey(true));
	}
	
	@Then("Verify deliveries date")
	public void verify_deliveries_date() {
		boolean status = delivery.dateSearchResult();
	    if(status) {
	    	Assert.assertTrue(true);
	    } else {
	    	Assert.assertTrue(false);
	    }
	}
	
	//Check whether filtering deliveries by Delivery Request Date displays only deliveries of filtered date
	
	@When("User enters DRDate")
	public void user_enters_dr_date() {
		Map<Boolean,String> status1 = delivery.enterDRDate();
	    Assert.assertTrue(status1.get(false), status1.containsKey(true));
	}
	
	@Then("Verify DRDate of deliveries")
	public void verify_dr_date_of_deliveries() {
		boolean status = delivery.dateSearchResultForDRDate();
	    if(status) {
	    	Assert.assertTrue(true);
	    } else {
	    	Assert.assertTrue(false);
	    }
	}
	
	//Check whether filtering deliveries by Delivered date displays only deliveries of filtered date
	
	@When("User clicks Delivered Date in deliveries table")
	public void user_clicks_delivered_date_in_deliveries_table() {
		Map<Boolean,String> status1 = delivery.clickDeliveredDate();
	    Assert.assertTrue(status1.get(false), status1.containsKey(true));
	}
	
	@When("User enters from DelDate")
	public void user_enters_from_del_date() {
		Map<Boolean,String> status1 = delivery.enterFromDelDate();
	    Assert.assertTrue(status1.get(false), status1.containsKey(true));
	}
	
	@When("User enters to DelDate")
	public void user_enters_to_del_date() {
		Map<Boolean,String> status1 = delivery.enterToDelDate();
	    Assert.assertTrue(status1.get(false), status1.containsKey(true));
	}
	
	@When("User clicks Apply button in delivered date")
	public void user_clicks_apply_button_in_delivered_date() {
		Map<Boolean,String> status1 = delivery.clickApplyButton();
	    Assert.assertTrue(status1.get(false), status1.containsKey(true));
	}

	@Then("Verify Delivered Date")
	public void verify_delivered_date() {
		boolean status = delivery.dateSearchResultForDeliveredDate();
	    if(status) {
	    	Assert.assertTrue(true);
	    } else {
	    	Assert.assertTrue(false);
	    }
	}

	//Check whether filtering deliveries by channels displays only deliveries of that channel
	
	@When("User enters channel")
	public void user_enters_channel() {
		Map<Boolean,String> status1 = delivery.enterChannelName();
	    Assert.assertTrue(status1.get(false), status1.containsKey(true));
	}
	
	@Then("Verify deliveries of the channel")
	public void verify_deliveries_of_the_channel() {
		boolean status = delivery.resultOfChannel();
	    if(status) {
	    	Assert.assertTrue(true);
	    } else {
	    	Assert.assertTrue(false);
	    }
	}

	//Check whether filtering deliveries by channel order no displays only deliveries of that channel order no
	
	@When("User enters channel order no")
	public void user_enters_channel_order_no() {
		Map<Boolean,String> status1 = delivery.enterChannelOrderNo();
	    Assert.assertTrue(status1.get(false), status1.containsKey(true));
	}
	
	@Then("Verify deliveries of that channel order no")
	public void verify_deliveries_of_that_channel_order_no() {
		boolean status = delivery.resultOfChannelOrderNo();
	    if(status) {
	    	Assert.assertTrue(true);
	    } else {
	    	Assert.assertTrue(false);
	    }
	}

	//Check whether filtering deliveries by delivery no displays only delivery of that delivery no
	
	@When("User enters delivery no")
	public void user_enters_delivery_no() {
		Map<Boolean,String> status1 = delivery.enterDeliveryNo();
	    Assert.assertTrue(status1.get(false), status1.containsKey(true));
	}
	
	@Then("Verify delivery of that delivery no")
	public void verify_delivery_of_that_delivery_no() {
		boolean status = delivery.resultOfDeliveryNo();
	    if(status) {
	    	Assert.assertTrue(true);
	    } else {
	    	Assert.assertTrue(false);
	    }
	}

	//Check whether filtering deliveries by invoice no displays only delivery of that invoice no
	
	@When("User enters invoice no")
	public void user_enters_invoice_no() {
		Map<Boolean,String> status1 = delivery.enterInvoiceNo();
	    Assert.assertTrue(status1.get(false), status1.containsKey(true));
	}
	
	@Then("Verify delivery of that invoice no")
	public void verify_delivery_of_that_invoice_no() {
		boolean status = delivery.resultOfInvoiceNo();
	    if(status) {
	    	Assert.assertTrue(true);
	    } else {
	    	Assert.assertTrue(false);
	    }
	}

	//Check whether filtering deliveries by customer displays only delivery of that customer
	
	@When("User enters customer name")
	public void user_enters_customer_name() {
		Map<Boolean,String> status1 = delivery.enterCustName();
	    Assert.assertTrue(status1.get(false), status1.containsKey(true));
	}
	
	@Then("Verify delivery of that customer")
	public void verify_delivery_of_that_customer() {
		boolean status = delivery.resultOfCustomer();
	    if(status) {
	    	Assert.assertTrue(true);
	    } else {
	    	Assert.assertTrue(false);
	    }
	}

	//Check whether filtering deliveries by postal code displays only delivery of that postal code
	
	@When("User enters postalcode")
	public void user_enters_postalcode() {
		Map<Boolean,String> status1 = delivery.enterPostalCode();
	    Assert.assertTrue(status1.get(false), status1.containsKey(true));
	}
	
	@Then("Verify delivery of that postal code")
	public void verify_delivery_of_that_postal_code() {
		boolean status = delivery.resultOfPostalCode();
	    if(status) {
	    	Assert.assertTrue(true);
	    } else {
	    	Assert.assertTrue(false);
	    }
	}

	//Check whether user is able to create invoice for the sale order	and track till delivery
	
	@When("Click the status")
	public void click_the_status() {
		Map<Boolean,String> status1 = delivery.clickDeliveryStatus();
	    Assert.assertTrue(status1.get(false), status1.containsKey(true));
	}

	@When("User updates delivery status to ReadyToShip")
	public void user_updates_delivery_status_to_ready_to_ship() {
		Map<Boolean,String> status = delivery.clickDelStatus();
	    Assert.assertTrue(status.get(false), status.containsKey(true));
	    Map<Boolean,String> status1 = delivery.clickReadyToShip();
	    Assert.assertTrue(status1.get(false), status1.containsKey(true));
	    
	}
	
	@When("User clicks update delivery status button")
	public void user_clicks_update_delivery_status_button() throws InterruptedException {
		Map<Boolean,String> status = delivery.clickUpdateStatusButton();
	    Assert.assertTrue(status.get(false), status.containsKey(true));
	}
	
	@When("User updates delivery status to Shipped")
	public void user_updates_delivery_status_to_shipped() {
		Map<Boolean,String> status = delivery.clickDelStatus();
	    Assert.assertTrue(status.get(false), status.containsKey(true));
	    Map<Boolean,String> status1 = delivery.clickShipped();
	    Assert.assertTrue(status1.get(false), status1.containsKey(true));
	}

	@When("Refresh the page")
	public void refresh_the_page() {
	    delivery.refresh();
	}

	@When("User updates delivery status to Delivered")
	public void user_updates_delivery_status_to_delivered() {
		Map<Boolean,String> status = delivery.clickDelStatus();
	    Assert.assertTrue(status.get(false), status.containsKey(true));
	    Map<Boolean,String> status1 = delivery.clickDelivered();
	    Assert.assertTrue(status1.get(false), status1.containsKey(true));
	}































































}
