package pageObjects;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import commonMethods.Elements;
import commonMethods.Validations;

public class EmailInvoicePage {

	private WebDriver driver;
	
	public EmailInvoicePage(WebDriver driver)	{
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	@FindBy(how = How.NAME, using="send_email")
	private WebElement sendEmailButton;
	
	@FindBy(how = How.ID, using="to")
	private WebElement toField;
	
	@FindBy(how = How.ID, using="subject")
	private WebElement subField;
	
	@FindBy(how = How.XPATH, using="//small[contains(text(),'Please enter a valid email address')]")
	private List<WebElement> alert;
	
	@FindBy(how = How.XPATH, using="//small[contains(text(),'Please enter/select a value matching the pattern')]")
	private WebElement alert1;
	
	@FindBy(how = How.XPATH, using="//button[@class='close']")
	private WebElement closeEmailPopup;
	
	public Map<Boolean,String> clickSendEmailButton()	{
		
		return Elements.CLICK(driver, sendEmailButton);
		
	}
	
	public Map<Boolean,String> emptyToField()	{
		
		return Elements.ERASEVALUE(driver, toField);
		
	}
	
	public Map<Boolean,String> emptySubjectField()	{
		
		return Elements.ERASEVALUE(driver, subField);
		
	}
	
	public Map<Boolean,String> enterInvalidEmail()	{
		
		return Elements.ENTERVALUE(driver, toField, "!@#$%^&*()@gmail.com");
		
	}
	
	public String alertMsg()	{
		
		String alert1 = null;
		
		for(int i=0;i<alert.size();i++)	{
			if(i==0) {
				WebElement element = alert.get(i);
				alert1 = element.getText();
				break;
			}
		}
		return alert1;
	}
	
	public Map<Boolean,String> enterCharacterInSubField()	{
		
		return Elements.ENTERVALUE(driver, subField, "a");
		
	}
	
	public String alertMsg1()	{
		
		return alert1.getText();
		
	}
	
	public Map<Boolean,String> clickCloseEmail()	{
		
		return Elements.CLICK(driver, closeEmailPopup);
		
	}
	
	public boolean verifyEmailPopup()	{
		
		return Validations.IFELEMENTPRESENT(closeEmailPopup);
		
	}
	
	
	
}
