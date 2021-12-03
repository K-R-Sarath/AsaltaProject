package stepDefinitions;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import cucumber.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;

public class Hooks {
	
	TestContext testContext;
	
	public Hooks(TestContext context) {
		testContext = context;
	}
	
	@After(order = 1)
	public void embedScreenshot(Scenario scenario) {
		if(scenario.isFailed()) {
			try {
				byte[] screenshot = ((TakesScreenshot) testContext.getWebDriverManager().getDriver()).getScreenshotAs(OutputType.BYTES);
				scenario.attach(screenshot,"image/png","image"); 
			} catch (Exception e) {
				e.printStackTrace();
			}	
		}
	}
	
	@After(order = 0)
	public void quitDriver() {
		testContext.getWebDriverManager().quitDriver();
	}
	
}
