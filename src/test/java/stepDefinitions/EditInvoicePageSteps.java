package stepDefinitions;

import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import cucumber.TestContext;
import io.cucumber.java.en.*;
import pageObjects.EditInvoicePage;

public class EditInvoicePageSteps {
	
	TestContext testContext;
	EditInvoicePage editInvoice;
	
	public EditInvoicePageSteps(TestContext context)	{
		testContext = context;
		editInvoice = testContext.getPageObjectManager().getEditInvoicePage();
	}
	
	@When("User scrolls down to items")
	public void user_scrolls_down_to_items() {
	    editInvoice.scroll();
	}
	@When("User edits quantity")
	public void user_edits_quantity() {
	    Map<Boolean,String> status = editInvoice.editQuantity();
	    Assert.assertTrue(status.get(false),status.containsKey(true));
	}
	
	@When("User Click save sale button")
	public void user_click_save_sale_button()	{
		Map<Boolean,String> status = editInvoice.clickSaveSaleButton();
		Assert.assertTrue(status.get(false),status.containsKey(true));
	}
	
	@Then("Invoice updated successfully")
	public void invoice_updated_successfully() {
	    String success = editInvoice.success1();
	    if(success.equalsIgnoreCase("Invoice sale successfully updated")) {
	    	Assert.assertTrue(true);
	    }else {
	    	Assert.assertTrue(false);
	    }
	}
	
	//Check whether it throws "Unexpected value provided!" while entering zero, -1 and alphabets in quantity field

	@When("User edits quantity as {string}")
	public void user_edits_quantity_as(String qty) {
	    Map<Boolean,String> status = editInvoice.editQty(qty);
	    Assert.assertTrue(status.get(false),status.containsKey(true));
	}
	@When("User clicks outside qty field")
	public void user_clicks_outside_qty_field() {
	    Map<Boolean,String> status = editInvoice.clickOutside();
	    Assert.assertTrue(status.get(false),status.containsKey(true));
	}
	@Then("It throws {string}")
	public void it_throws(String result) {
	    String alert = editInvoice.success1();
	    if(alert.equalsIgnoreCase(result)) {
	    	Assert.assertTrue(true);
	    }else {
	    	Assert.assertTrue(false);
	    }
	}

	//Check whether system throws error while entering more than 100% in discount and more than the total amount in discounts

	@When("User scrolls down to discounts")
	public void user_scrolls_down_to_discounts() {
	    editInvoice.scroll1();
	}
	
	@When("User enters discount as {string}")
	public void user_enters_discount_as(String disc) {
	    Map<Boolean,String> status = editInvoice.enterDiscount(disc);
	    Assert.assertTrue(status.get(false),status.containsKey(true));
	}
	
	@When("User clicks outside the discount field")
	public void user_clicks_outside_the_discount_field() {
	   Map<Boolean,String> status = editInvoice.clickOutOfDisc();
	   Assert.assertTrue(status.get(false),status.containsKey(true));
	}
	
	@Then("System throws {string}")
	public void system_throws(String result) {
		String alert = editInvoice.success1();
	    if(alert.equalsIgnoreCase(result)) {
	    	Assert.assertTrue(true);
	    }else {
	    	Assert.assertTrue(false);
	    }
	}

	//Check whether system throws error while entering discount amount greater than total amount

	@When("User enters discount")
	public void user_enters_discount() {
	    Map<Boolean,String> status = editInvoice.enterDsc();
	    Assert.assertTrue(status.get(false),status.containsKey(true));
	}
	
	//Check whether user is able to delete the item
	
	@When("User deletes item")
	public void user_deletes_item() {
	    Map<Boolean,String> status = editInvoice.deleteItem();
	    Assert.assertTrue(status.get(false),status.containsKey(true));
	}
	
	//Check whether system throws "The Order Items field is required." when clicking save sale button without any item selected.

	@When("If there is no item present")
	public void if_there_is_no_item_present() {
	   String amount = editInvoice.totalAmt();
	   if(amount.equals("$ 0.00")) {
		   Assert.assertTrue(true);
	   }else {
		   Assert.assertTrue(false);
	   }
	}
	
	//Check whether user is able to upload document

	@When("User scrolls down to attachment")
	public void user_scrolls_down_to_attachment() {
	    editInvoice.scroll3();
	}

	@When("User uploads document")
	public void user_uploads_document() {
	    Map<Boolean,String> status = editInvoice.attachFile();
	    Assert.assertTrue(status.get(false),status.containsKey(true));
	}
	
	@When("User clicks save sale button")
	public void user_clicks_save_sale_button() {
	    Map<Boolean,String> status = editInvoice.clickEditSaleButton();
	    Assert.assertTrue(status.get(false),status.containsKey(true));
	}
	
	//Check whether system throws error, if we make return invoice for cancelled invoice

	@When("Change sale status to cancelled")
	public void change_sale_status_to_cancelled() {
	    Map<Boolean,String> status = editInvoice.clickSaleStatus();
	    Assert.assertTrue(status.get(false), status.containsKey(true));
	    Map<Boolean,String> status1 = editInvoice.changeSaleStatus();
	    Assert.assertTrue(status1.get(false), status1.containsKey(true));
	}
	
	//Check whether system throws "Invoice No must be unique" when we duplicate the invoice number
	
	@When("User enters duplicate invoice number")
	public void user_enters_duplicate_invoice_number() {
	    Map<Boolean,String> status = editInvoice.duplicateInvoiceNo();
	    Assert.assertTrue(status.get(false), status.containsKey(true));
	}
	
	//Check whether revisions are getting stored when we edit and save invoice
	
	@When("Scroll to revisions field")
	public void scroll_to_revisions_field() {
	    editInvoice.scroll4();
	}
	
	@When("Click revisions field")
	public void click_revisions_field() {
		Map<Boolean,String> status = editInvoice.clickRevisionsField();
	    Assert.assertTrue(status.get(false), status.containsKey(true));
	}
	
	@When("Get revisions list")
	public void get_revisions_list() {
	   editInvoice.getRevisionsList();
	}
	
	@When("Choose revision")
	public void choose_revision() {
		Map<Boolean,String> status = editInvoice.selectRevision();
	    Assert.assertTrue(status.get(false), status.containsKey(true));
	}

	@When("Now get revisions list")
	public void now_get_revisions_list() {
	    editInvoice.nowGetRevisionsList();
	}

	@Then("Revisions list should be added by one more revision")
	public void revisions_list_should_be_added_by_one_more_revision() {
	    if((editInvoice.nowGetRevisionsList()) != 0) {
	    	Assert.assertTrue(true);
	    } else {
	    	Assert.assertTrue(false);
	    }
	}




































}
