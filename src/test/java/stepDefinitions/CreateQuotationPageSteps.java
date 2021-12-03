package stepDefinitions;

import java.util.Map;

import org.junit.Assert;

import cucumber.TestContext;
import io.cucumber.java.en.*;
import pageObjects.CreateQuotationPage;

public class CreateQuotationPageSteps {
	
	TestContext testContext;
	CreateQuotationPage createQuotation;
	
	public CreateQuotationPageSteps(TestContext context)	{
		testContext = context;
		createQuotation = testContext.getPageObjectManager().getCreateQuotationPage();
	}
	
	@When("User chooses customer")
	public void user_chooses_customer() {
	    Map<Boolean,String> status = createQuotation.clickCustomer();
	    Assert.assertTrue(status.get(false), status.containsKey(true));
	    Map<Boolean,String> status1 = createQuotation.enterCust();
	    Assert.assertTrue(status1.get(false), status1.containsKey(true));
	    Map<Boolean,String> status2 = createQuotation.selectCustomer();
	    Assert.assertTrue(status2.get(false), status2.containsKey(true));
	}
	
	@When("User selects items")
	public void user_selects_items() {
	    Map<Boolean,String> status = createQuotation.searchItem();
	    Assert.assertTrue(status.get(false), status.containsKey(true));
	    Map<Boolean,String> status1 = createQuotation.selectItem();
	    Assert.assertTrue(status1.get(false), status1.containsKey(true));
	}
	
	@When("User scrolls down to save quote button")
	public void user_scrolls_down_to_save_quote_button() {
	    createQuotation.scroll();
	}
	
	@When("User clicks save quote button")
	public void user_clicks_save_quote_button() {
	    Map<Boolean,String> status = createQuotation.clickSaveQuote();
	    Assert.assertTrue(status.get(false), status.containsKey(true));
	}

	@Then("Alert is thrown {string}")
	public void alert_is_thrown(String result) {
	    String mess = createQuotation.message();
	    if(mess.equalsIgnoreCase(result)){
	    	Assert.assertTrue(true);
	    }else{
	    	Assert.assertTrue(false);
	    }
	}





}
