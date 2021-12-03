package stepDefinitions;

import java.util.Map;

import org.junit.Assert;

import cucumber.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pageObjects.LoginPage;

public class Steps {
	
	TestContext testContext;
	LoginPage login;
	
	public Steps(TestContext context) {
		testContext = context;
		login = testContext.getPageObjectManager().getLoginPage();
	}
	
	@Given("User is on login page")
	public void user_is_on_login_page() {
		testContext.getWebDriverManager().getDriver();
		testContext.getWebDriverManager().getURL();	
	}
	
	@When("User enters email as {string} and password as {string}")
	public void user_enters_email_as_and_password_as(String uName, String pwd) {
	   Map<Boolean,String> status = login.enter_EmailID(uName);
	   Assert.assertTrue(status.get(false),status.containsKey(true));
	    Map<Boolean,String> status1 = login.enter_Password(pwd);
	    Assert.assertTrue(status1.get(false),status1.containsKey(true));
	}
	
	@When("User clicks login button")
	public void user_clicks_login_button() {
	    Map<Boolean,String> status = login.click_Login_Button();
	    Assert.assertTrue(status.get(false),status.containsKey(true));
	}
	
}

