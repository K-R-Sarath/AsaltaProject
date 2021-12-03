package stepDefinitions;

import java.util.Map;

import org.junit.Assert;

import cucumber.TestContext;
import io.cucumber.java.en.When;
import pageObjects.QuotationListPage;

public class QuotationListPageSteps {
	
	TestContext testContext;
	QuotationListPage quotation;
	
	public QuotationListPageSteps(TestContext context)	{
		testContext = context;
		quotation = testContext.getPageObjectManager().getQuotationListPage();
	}
	
	@When("User clicks New Quotation button")
	public void user_clicks_new_quotation_button() {
	    Map<Boolean,String> status = quotation.clickNewQuotationButton();
	    Assert.assertTrue(status.get(false),status.containsKey(true));
	}

}
