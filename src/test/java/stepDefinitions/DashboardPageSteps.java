package stepDefinitions;

import java.util.Map;

import org.junit.Assert;

import cucumber.TestContext;
import io.cucumber.java.en.*;
import pageObjects.DashboardPage;

public class DashboardPageSteps {

	TestContext testContext;
	DashboardPage dashboard;
	
	public DashboardPageSteps(TestContext context) {
		testContext = context;
		dashboard = testContext.getPageObjectManager().getDashboardPage();
	}
	
	@When("User is on Dashboard page and clicks sales and invoice from side menu")
	public void user_is_on_dashboard_page() {
	   Map<Boolean,String> status = dashboard.clickSalesInSideMenu();
	   Assert.assertTrue(status.get(false),status.containsKey(true));
	   Map<Boolean,String> status1 = dashboard.clickInvoice();
	   Assert.assertTrue(status1.get(false),status1.containsKey(true));
	}
	
	//Check whether "Packed" delivery status introduces two new fields called "Packed By" and "Packed Date & Time"

	@When("User is Dashboard page and clicks Deliveries from side menu")
	public void user_is_dashboard_page_and_clicks_deliveries_from_side_menu() {
	   Map<Boolean,String> status = dashboard.clickDeliveriesInSideMenu();
	   Assert.assertTrue(status.get(false),status.containsKey(true));
	}
	
	//Check whether user is able to create quotation

	@When("User clicks sales from side menu")
	public void user_clicks_sales_from_side_menu() {
		Map<Boolean,String> status = dashboard.clickSalesInSideMenu();
		Assert.assertTrue(status.get(false),status.containsKey(true));
	}
	
	@When("User clicks quotations from side menu")
	public void user_clicks_quotations_from_side_menu() {
	   Map<Boolean,String> status1 = dashboard.clickQuotations();
	   Assert.assertTrue(status1.get(false), status1.containsKey(true));
	}
	
	//Check whether clicking dashboard in breadcrumbs in invoice sale page navigates to dashboard page
	
	@Then("It should navigate to dashboard page")
	public void it_should_navigate_to_dashboard_page() {
	    boolean status = dashboard.verifyDashboard();
	    if(status)	{
	    	Assert.assertTrue(true);
	    } else {
	    	Assert.assertTrue(false);
	    }
	}
	
	
	
	




	
	
	
}
