package stepDefinitions;

import java.util.Map;

import org.junit.Assert;

import cucumber.TestContext;
import io.cucumber.java.en.*;
import pageObjects.ViewPaymentPage;

public class ViewPaymentPageSteps {
	
	TestContext testContext;
	ViewPaymentPage viewPayments;
	
	public ViewPaymentPageSteps(TestContext context) {
		testContext = context;
		viewPayments = testContext.getPageObjectManager().getViewPaymentPage();
	}
	
	@Then("System should display {string}")
	public void system_should_display(String result) {
	    String message = viewPayments.dataMessage();
	    if(message.equalsIgnoreCase(result)) {
	    	Assert.assertTrue(true);
	    }else {
	    	Assert.assertTrue(false);
	    }
	}
	
	//Check whether user is able to do payment by Cash
	
	@Then("User verifies the payment")
	public void user_verifies_the_payment() throws Exception {
	    String paymentVerification = viewPayments.verifyPayment();
	    if(paymentVerification.equalsIgnoreCase("Cash")) {
	    	Assert.assertTrue(true);
	    }else if(paymentVerification.equalsIgnoreCase("Cheque")){
	    	Assert.assertTrue(true);
	    }else if(paymentVerification.equalsIgnoreCase("Credit Card")) {
	    	Assert.assertTrue(true);
	    }else if(paymentVerification.equalsIgnoreCase("Others")) {
	    	Assert.assertTrue(true);
	    }else if(paymentVerification.equalsIgnoreCase("Gift Card")) {
	    	Assert.assertTrue(true);
	    }else {
	    	Assert.assertTrue(false);
	    }
	}

	@Then("User deletes the payment")
	public void user_deletes_the_payment() {
	    Map<Boolean,String> status = viewPayments.deletePayment();
	    Assert.assertTrue(status.get(false),status.containsKey(true));
	    Map<Boolean,String> status1 = viewPayments.deleteYes();
	    Assert.assertTrue(status1.get(false),status1.containsKey(true));
	}
	
	//Check whether user is able to attach document while doing payment
	
	@Then("User verifies attachment")
	public void user_verifies_attachment() {
	    boolean file = viewPayments.attachment();
	    if(file) {
	    	Assert.assertTrue(true);
	    }else {
	    	Assert.assertTrue(false);
	    }
	}
	
	//Check whether paid amount can be edited in view payments page

	@Then("User clicks edit icon")
	public void user_clicks_edit_icon() {
	    Map<Boolean,String> status = viewPayments.editPayment();
	    Assert.assertTrue(status.get(false),status.containsKey(true));
	}

	//Check whether the payment can be viewed by the user

	@Then("User clicks the view icon")
	public void user_clicks_the_view_icon() {
	    Map<Boolean,String> status = viewPayments.viewPayment();
	    Assert.assertTrue(status.get(false), status.containsKey(true));
	}

	@Then("Payment slip can be viewed with {string} option")
	public void payment_slip_can_be_viewed_with_option(String stampAndSignature) {
	    String slip = viewPayments.paymentSlip();
	    if(slip.equalsIgnoreCase(stampAndSignature)) {
	    	Assert.assertTrue(true);
	    }else {
	    	Assert.assertTrue(false);
	    }
	}















}
