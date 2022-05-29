package stepDefinitions;

import java.util.Map;

import org.junit.Assert;

import cucumber.TestContext;
import io.cucumber.java.en.*;
import pageObjects.EmailInvoicePage;

public class EmailInvoicePageSteps {
	
	TestContext testContext;
	EmailInvoicePage emailInvoiceSale;
	
	public EmailInvoicePageSteps(TestContext context)	{
		testContext = context;
		emailInvoiceSale = testContext.getPageObjectManager().getEmailInvoicePage();
	}
	
	//Check whether invoice sale can be emailed
	
	@When("User clicks Send Email button")
	public void user_clicks_send_email_button() {
	    Map<Boolean,String> status = emailInvoiceSale.clickSendEmailButton();
	    Assert.assertTrue(status.get(false), status.containsKey(true));
	}
	
	//Check whether emptying to field and subject field throws "Please enter/select a value"
	
	@When("Empty To field")
	public void empty_to_field() {
		Map<Boolean,String> status = emailInvoiceSale.emptyToField();
	    Assert.assertTrue(status.get(false), status.containsKey(true));
	}
	
	@When("Empty Subject field")
	public void empty_subject_field() {
		Map<Boolean,String> status = emailInvoiceSale.emptySubjectField();
	    Assert.assertTrue(status.get(false), status.containsKey(true));
	}
	
	//Check whether system throws "Please enter a valid email address" on entering invalid email ID
	
	@When("Enter invalid emailID")
	public void enter_invalid_email_id() {
		Map<Boolean,String> status = emailInvoiceSale.enterInvalidEmail();
	    Assert.assertTrue(status.get(false), status.containsKey(true));
	}
	
	//Check whether system throws "Please enter a valid email address" on entering invalid email ID
	
	@Then("Throwss alert {string}")
	public void throwss_alert(String msg) {
	    String status = emailInvoiceSale.alertMsg();
	    if(status.equalsIgnoreCase(msg)) {
	    	Assert.assertTrue(true);
	    } else {
	    	Assert.assertTrue(false);
	    }
	}
	
	@When("Enter a character in subject field")
	public void enter_a_character_in_subject_field() {
		Map<Boolean,String> status = emailInvoiceSale.enterCharacterInSubField();
	    Assert.assertTrue(status.get(false), status.containsKey(true));
	}
	
	@Then("The Alert is {string}")
	public void the_alert_is(String msg) {
	    String status = emailInvoiceSale.alertMsg1();
	    if(status.equalsIgnoreCase(msg)) {
	    	Assert.assertTrue(true);
	    } else {
	    	Assert.assertTrue(false);
	    }
	}
	
	//Check whether user can close email popup
	
	@When("User closes email popup")
	public void user_closes_email_popup() {
		Map<Boolean,String> status = emailInvoiceSale.clickCloseEmail();
	    Assert.assertTrue(status.get(false), status.containsKey(true));
	}
	
	@Then("Verifies it")
	public void verifies_it() {
	   boolean status = emailInvoiceSale.verifyEmailPopup();
	   if(status) {
		   Assert.assertTrue(false);
	   } else {
		   Assert.assertTrue(true);
	   }
	}















}
