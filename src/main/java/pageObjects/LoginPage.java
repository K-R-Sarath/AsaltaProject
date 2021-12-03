package pageObjects;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import commonMethods.Elements;

public class LoginPage {
	
	private WebDriver driver;
		
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		
	}

	@FindBy(how = How.ID, using = "identity")
	private WebElement email;
	
	@FindBy(how = How.ID, using = "password")
	private WebElement password;
	
	@FindBy(how = How.XPATH, using = "//button[@class='btn loginbtn pull-right']")
	private WebElement clickLoginButton;
	
	
	public Map<Boolean,String> enter_EmailID(String user) {

		return Elements.ENTERVALUE(driver, email, user);
		
	}
	
	public Map<Boolean,String> enter_Password(String pass) {
		
		return Elements.ENTERVALUE(driver, password, pass);
		
	}
	
	public Map<Boolean,String> click_Login_Button() {
		
		return Elements.CLICK(driver, clickLoginButton);
		
	}
	
	
	

	
}
