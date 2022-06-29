package stepDefinitions;

import java.util.Map;

import org.junit.Assert;

import cucumber.TestContext;
import io.cucumber.java.en.*;
import pageObjects.ReturnInvoiceSalePage;

public class ReturnInvoiceSalePageSteps {

	TestContext testContext;
	ReturnInvoiceSalePage returnInvoice;
	
	public ReturnInvoiceSalePageSteps(TestContext context)	{
		testContext = context;
		returnInvoice = testContext.getPageObjectManager().getReturnInvoiceSalePage();
	}
	
	//Check whether invoice can be returned
	
	@When("User selects item to return")
	public void user_selects_item_to_return() {
	    boolean status = returnInvoice.selectItems();
	    if(status) {
	    	Assert.assertTrue(true);
	    } else {
	    	Assert.assertTrue(false);
	    }
	}
	
	@When("User clicks Return Checked items button")
	public void user_clicks_return_checked_items_button() {
	    Map<Boolean,String> status = returnInvoice.clickReturnCheckedItemsButton();
	    Assert.assertTrue(status.get(false), status.containsKey(true));
	}

	//Check whether clicking cancel in return invoice page redirects to return sales list page
	
	@When("User clicks Cancel button")
	public void user_clicks_cancel_button() {
		Map<Boolean,String> status = returnInvoice.clickCancelButton();
	    Assert.assertTrue(status.get(false), status.containsKey(true));
	}
	
	//Check whether adding exchange item quantity higher than the available quantity throws "Exchange Sale is failed due to - The quantity is out of stock"
	
	@When("User clicks Add items for exchange button")
	public void user_clicks_add_items_for_exchange_button() {
		Map<Boolean,String> status = returnInvoice.clickAddExchangeButton();
	    Assert.assertTrue(status.get(false), status.containsKey(true));
	}
	
	@When("User adds item")
	public void user_adds_item() {
		Map<Boolean,String> status = returnInvoice.enterItemForExchange();
	    Assert.assertTrue(status.get(false), status.containsKey(true));
	    Map<Boolean,String> status1 = returnInvoice.selectItemForExchange();
	    Assert.assertTrue(status1.get(false), status1.containsKey(true));
	}
	
	@When("User enters quantity")
	public void user_enters_quantity() {
		Map<Boolean,String> status = returnInvoice.enterQtyForExchange();
	    Assert.assertTrue(status.get(false), status.containsKey(true));
	}

	@When("User makes amount field to zero in exchange")
	public void user_makes_amount_field_to_zero_in_exchange() {
		Map<Boolean,String> status = returnInvoice.eraseAmount();
	    Assert.assertTrue(status.get(false), status.containsKey(true));
	}





	




	
	
	
	
	
	
}
