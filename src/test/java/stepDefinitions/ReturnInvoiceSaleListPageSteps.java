package stepDefinitions;

import java.awt.AWTException;
import java.util.Map;

import org.junit.Assert;

import cucumber.TestContext;
import io.cucumber.java.en.*;
import pageObjects.ReturnInvoiceSaleListPage;

public class ReturnInvoiceSaleListPageSteps {
	
	TestContext testContext;
	ReturnInvoiceSaleListPage invoiceReturnsList;
	
	public ReturnInvoiceSaleListPageSteps(TestContext context)	{
		testContext = context;
		invoiceReturnsList = testContext.getPageObjectManager().getReturnInvoiceSaleListPage();
	}
	
	//Check whether clicking cancel in return invoice page redirects to return sales list page
	
	@Then("It should navigate to return sales list page")
	public void it_should_navigate_to_return_sales_list_page() {
	    String status = invoiceReturnsList.getBreadCrumb();
	    if(status.equalsIgnoreCase("Return Sales")) {
	    	Assert.assertTrue(true);
	    } else {
	    	Assert.assertTrue(false);
	    }
	}
	
	//Check whether adding exchange item quantity higher than the available quantity throws "Exchange Sale is failed due to - The quantity is out of stock"
	
	@Then("Throws first alert {string}")
	public void throws_first_alert(String alert) {
	    String status = invoiceReturnsList.alertMessage1();
	    if(status.equalsIgnoreCase(alert))	{
	    	Assert.assertTrue(true);
	    } else {
	    	Assert.assertTrue(false);
	    }
	}
	
	//Check whether user can able to view credit note
	
	@When("User clicks View Credit Note")
	public void user_clicks_view_credit_note() {
	    Map<Boolean,String> status = invoiceReturnsList.clickViewCreditNote();
	    Assert.assertTrue(status.get(false), status.containsKey(true));
	}
	
	@When("User closes print popup")
	public void user_closes_print_popup() throws AWTException {
	    invoiceReturnsList.closePrintPopup();
	}
	
	@Then("User verifies the credit note")
	public void user_verifies_the_credit_note() {
	    String status = invoiceReturnsList.creditNoteVerification();
	    if(status.equalsIgnoreCase("Credit Note"))	{
	    	Assert.assertTrue(true);
	    } else {
	    	Assert.assertTrue(false);
	    }
	}

	//Check whether user can able to view details
	
	@Then("User clicks View details and verify the details")
	public void user_clicks_view_details_and_verify_the_details() {
		boolean status = invoiceReturnsList.clickViewDetailsAndVerify();
		if(status) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}










	
	
	
	
	
	
	
	
	

}
