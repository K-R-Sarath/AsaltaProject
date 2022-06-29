package pageObjects;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import commonMethods.Elements;
import commonMethods.Windows;

public class ReturnInvoiceSaleListPage {
	
private WebDriver driver;
	
	public ReturnInvoiceSaleListPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	
	@FindBy(how = How.XPATH, using="//ul[@class='breadcrumb']//li[2]")
	private WebElement breadCrumb;
	
	@FindBy(how = How.XPATH, using="//div[@id='toast-container']//div[@class='toast toast-error']//div")
	private WebElement alertMsg1;
	
	@FindBy(how = How.XPATH, using="//ul[@class='dropdown-menu pull-right']//li//a")
	private List<WebElement> actionDropDown;
	
	@FindBy(how = How.XPATH, using="//div[@class='col-sm-12 text-center']//h4")
	private WebElement verifyCreditNote;
	
	@FindBy(how = How.XPATH, using="//table[@id='RESLData']//tbody//tr//td[2]")
	private List<WebElement> getReturnInvoiceNo;
	
	@FindBy(how = How.XPATH, using="//ul[@class='breadcrumb']//li[3]")
	private WebElement returnsNumberInViewPage;
	
	
	public String getBreadCrumb()	{
		
		return breadCrumb.getText().substring(0, 12);
		
	}
	
	public String alertMessage1()	{
		
		return alertMsg1.getText().substring(0, 61);
		
	}
	
	public Map<Boolean,String> clickViewCreditNote()	{
		Map<Boolean,String> creditNote = null;
		
		for(int i=0;i<actionDropDown.size();i++) {
			if(i==1) {
				WebElement element = actionDropDown.get(i);
				creditNote = Elements.CLICK(driver, element);
				break;
			}
		}
		return creditNote;
	}
	
	public void closePrintPopup() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ESCAPE);
		r.keyRelease(KeyEvent.VK_ESCAPE);	
	}
	
	public String creditNoteVerification()	{
		
		return verifyCreditNote.getText().trim();
		
	}
	
	public String getReturnInvoiceNo()	{
		String returnsNo = null;
		
		for(int i=0;i<getReturnInvoiceNo.size();i++) {
			if(i==0) {
				WebElement element = getReturnInvoiceNo.get(i);
				returnsNo = element.getText();
				break;
			}
		}
		return returnsNo;
	}
		
	public boolean clickViewDetailsAndVerify()	{
		String returnsNumber = getReturnInvoiceNo();
		
		for(int i=0;i<actionDropDown.size();i++) {
			if(i==2) {
				WebElement element = actionDropDown.get(i);
				Map<Boolean,String> details = Elements.CLICK(driver, element);
				break;
			}
		}
		if(returnsNumberInViewPage.getText().equalsIgnoreCase(returnsNumber)) {
			return true;
		} else {
			return false;
		}
	}
	
	
	
	
	
	

}
