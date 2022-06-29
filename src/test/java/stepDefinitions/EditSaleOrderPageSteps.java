package stepDefinitions;

import java.util.Map;

import org.junit.Assert;

import cucumber.TestContext;
import io.cucumber.java.en.*;
import pageObjects.EditSaleOrderPage;

public class EditSaleOrderPageSteps {
	
	TestContext testContext;
	EditSaleOrderPage editSale;
	
	public EditSaleOrderPageSteps(TestContext context) {
		testContext = context;
		editSale = testContext.getPageObjectManager().getEditSaleOrderPage();
	}

	//Check whether user is able to add another item 
	
	@When("User clicks edit sale order button")
	public void user_clicks_edit_sale_order_button() {
	    Map<Boolean,String> status = editSale.clickEditSaleButton();
	    Assert.assertTrue(status.get(false),status.containsKey(true));
	}

	//Check whether system throws "Sale Order No must be unique" when we duplicate the sale order number
	
	@When("User enters duplicate sale order number")
	public void user_enters_duplicate_sale_order_number() {
		Map<Boolean,String> status = editSale.duplicateSaleOrderNo();
	    Assert.assertTrue(status.get(false),status.containsKey(true));
	}




	
	
	
	
	
	
}
