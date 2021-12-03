package stepDefinitions;

import java.util.Map;

import org.junit.Assert;

import cucumber.TestContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.AddDeliveryPage;

public class AddDeliveryPageSteps {
	
	TestContext testContext;
	AddDeliveryPage addDelivery;
	
	public AddDeliveryPageSteps(TestContext context)	{
		testContext = context;
		addDelivery = testContext.getPageObjectManager().getAddDeliveryPage();
	}
	
	@When("User switches to new window")
	public void user_switches_to_new_window() {
	    Map<Boolean,String> status = addDelivery.switchToNewWindow();
	    Assert.assertTrue(status.get(false),status.containsKey(true));
	}
	@When("User scrolls down to delivery status option")
	public void user_scrolls_down_to_delivery_status_option() {
	    addDelivery.scrollToDeliveryStatus();
	}
	
	@When("User saves the delivery")
	public void user_saves_the_delivery() {
	    Map<Boolean,String> status = addDelivery.clickSaveDelivery();
	    Assert.assertTrue(status.get(false), status.containsKey(true));
	}

}
