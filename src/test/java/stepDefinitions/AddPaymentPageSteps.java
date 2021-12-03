package stepDefinitions;

import java.util.Map;

import org.junit.Assert;

import cucumber.TestContext;
import io.cucumber.java.en.*;
import pageObjects.AddPaymentPage;

public class AddPaymentPageSteps {
	
	TestContext testContext;
	AddPaymentPage addPayments;
	
	public AddPaymentPageSteps(TestContext context) {
		testContext = context;
		addPayments = testContext.getPageObjectManager().getAddPaymentPage();
	}
	
	@When("User makes amount field to zero")
	public void user_makes_amount_field_to_zero() {
	    Map<Boolean,String> status = addPayments.amount();
	    Assert.assertTrue(status.get(false),status.containsKey(true));
	}

	@Then("Throwss {string}")
	public void throwss(String result) {
	    String alert = addPayments.alertMsg1();
	    if(alert.equalsIgnoreCase(result)) {
	    	Assert.assertTrue(true);
	    }else {
	    	Assert.assertTrue(false);
	    }
	}
	
	//Check whether system throws error "Please enter/select a value" while making date field empty in AddPayments

	@When("User deletes the date")
	public void user_deletes_the_date() {
	   Map<Boolean,String> status = addPayments.dATE();
	   Assert.assertTrue(status.get(false),status.containsKey(true));
	}
	
	@Then("Throws field validation {string}")
	public void throws_field_validation(String result) {
	    String alert = addPayments.alertMsg2();
	    if(alert.equalsIgnoreCase(result)) {
	    	Assert.assertTrue(true);
	    }else {
	    	Assert.assertTrue(false);
	    }
	}
	
	//Check whether payment fails when choosing gift card in payby option and not entering gift voucher number
	
	@When("User chooses gift card in payby option")
	public void user_chooses_gift_card_in_payby_option() {
	   Map<Boolean,String> status = addPayments.clickPayByOption();
	   Assert.assertTrue(status.get(false),status.containsKey(true));
	   Map<Boolean,String> status1 = addPayments.selectPayByGiftCard();
	   Assert.assertTrue(status1.get(false),status1.containsKey(true));
	}
	
	@When("User clicks save payment option")
	public void user_clicks_save_payment_option() {
	    Map<Boolean,String> status = addPayments.clickSavePaymentButton();
	    Assert.assertTrue(status.get(false),status.containsKey(true));
	}

	@Then("Throws validation {string}")
	public void throws_validation(String result) {
		String alert = addPayments.alertMsg3();
		if(alert.equalsIgnoreCase(result)) {
			Assert.assertTrue(true);
		}else {
			Assert.assertTrue(false);
		}
	    
	}
	
	//Check whether user is able to do payment by Cash

	@When("User chooses Cash in payby option")
	public void user_chooses_cash_in_payby_option() {
		Map<Boolean,String> status2 = addPayments.clickDateField();
		Assert.assertTrue(status2.get(false),status2.containsKey(true));		
	    Map<Boolean,String> status = addPayments.clickPayByOption();
	    Assert.assertTrue(status.get(false),status.containsKey(true));
	    Map<Boolean,String> status1 = addPayments.selectPayByCash();
	    Assert.assertTrue(status1.get(false),status1.containsKey(true));
	}

	//Check whether user is able to do payment by Cheque
	
	@When("User chooses Cheque in payby option")
	public void user_chooses_cheque_in_payby_option() {
		Map<Boolean,String> status2 = addPayments.clickDateField();
		Assert.assertTrue(status2.get(false),status2.containsKey(true));		
	    Map<Boolean,String> status = addPayments.clickPayByOption();
	    Assert.assertTrue(status.get(false),status.containsKey(true));
	    Map<Boolean,String> status1 = addPayments.selectPayByCheque();
	    Assert.assertTrue(status1.get(false),status1.containsKey(true));
	}
	
	//Check whether user is able to do payment by Credit Card

	@When("User chooses Credit Card in payby option")
	public void user_chooses_credit_card_in_payby_option() {
		Map<Boolean,String> status2 = addPayments.clickDateField();
		Assert.assertTrue(status2.get(false),status2.containsKey(true));		
	    Map<Boolean,String> status = addPayments.clickPayByOption();
	    Assert.assertTrue(status.get(false),status.containsKey(true));
	    Map<Boolean,String> status1 = addPayments.selectPayByCredit();
	    Assert.assertTrue(status1.get(false),status1.containsKey(true));
	}

	//Check whether user is able to do payment by Others

	@When("User chooses Others in payby option")
	public void user_chooses_others_in_payby_option() {
		Map<Boolean,String> status2 = addPayments.clickDateField();
		Assert.assertTrue(status2.get(false),status2.containsKey(true));		
	    Map<Boolean,String> status = addPayments.clickPayByOption();
	    Assert.assertTrue(status.get(false),status.containsKey(true));
	    Map<Boolean,String> status1 = addPayments.selectPayByOthers();
	    Assert.assertTrue(status1.get(false),status1.containsKey(true));
	}

	//

	@When("User chooses Gift Card in payby option1")
	public void user_chooses_gift_card_in_payby_option1() {
		Map<Boolean,String> status2 = addPayments.clickDateField();
		Assert.assertTrue(status2.get(false),status2.containsKey(true));		
	    Map<Boolean,String> status = addPayments.clickPayByOption();
	    Assert.assertTrue(status.get(false),status.containsKey(true));
	    Map<Boolean,String> status1 = addPayments.selectPayByGiftCard();
	    Assert.assertTrue(status1.get(false),status1.containsKey(true));
	}
	@When("User enters Voucher number as {string}")
	public void user_enters_voucher_number_as(String voucher) {
	    Map<Boolean,String> status = addPayments.enterGiftVoucher(voucher);
	    Assert.assertTrue(status.get(false),status.containsKey(true));
	    Map<Boolean,String> status1 = addPayments.clickOutside();
	    Assert.assertTrue(status1.get(false),status.containsKey(true));
	    addPayments.scroll1();
	}
	
	//Check whether system throws alert "Gift Voucher number is incorrect or expired." on entering invalid voucher number
	
	@When("User enter Voucher number as {string}")
	public void user_enter_voucher_number_as(String voucher) {
		Map<Boolean,String> status = addPayments.enterGiftVoucher(voucher);
	    Assert.assertTrue(status.get(false),status.containsKey(true));
	    Map<Boolean,String> status1 = addPayments.clickOutside();
	    Assert.assertTrue(status1.get(false),status.containsKey(true));
	}

	@Then("It throws alert {string}")
	public void it_throws_alert(String result) {
	    String alert = addPayments.alertMsg4();
	    if(alert.equalsIgnoreCase(result)) {
	    	Assert.assertTrue(true);
	    }else {
	    	Assert.assertTrue(false);
	    }
	}

	//Check whether user is able to attach document while doing payment

	@When("User uploads the document")
	public void user_uploads_the_document() {
	    Map<Boolean,String> status = addPayments.attachFile();
	    Assert.assertTrue(status.get(false), status.containsKey(true));
	}

	//Check whether status changes to Partially paid when 50% or <50% of amount is paid

	@When("User enters amount as {string}")
	public void user_enters_amount_as(String amount) {
	    Map<Boolean,String> status = addPayments.enterAmount(amount);
	    Assert.assertTrue(status.get(false),status.containsKey(true));
	}

	//

	@Then("User scrolls to save payment button")
	public void user_scrolls_to_save_payment_button() {
	    addPayments.scroll2();
	}
	
	@Then("User clicks save payment edit option")
	public void user_clicks_save_payment_edit_option() {
	    Map<Boolean,String> status = addPayments.clickSavePaymentButton_Edit();
	    Assert.assertTrue(status.get(false),status.containsKey(true));
	}















	
	



	
	













	





}
