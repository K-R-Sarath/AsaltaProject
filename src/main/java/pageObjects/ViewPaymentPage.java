package pageObjects;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import commonMethods.Elements;

public class ViewPaymentPage {
	
	private WebDriver driver;
	
	public ViewPaymentPage(WebDriver driver)	{
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	@FindBy(how = How.XPATH, using="//table[@id='CompTable']//tbody//tr//td")
	private WebElement tableMsg;
	
	@FindBy(how = How.XPATH, using="//table[@id='CompTable']//tbody//tr//td[5]")
	private WebElement paidBy;
	
	@FindBy(how = How.XPATH, using="//i[@class='fa fa-trash-o actionicon red']")
	private WebElement deletePayment;
	
	@FindBy(how = How.XPATH, using="//div[@class='popover-content']//a")
	private WebElement yesDelete;
	
	@FindBy(how = How.XPATH, using="//button[@class='close']//i")
	private WebElement close;
	
	@FindBy(how = How.XPATH, using="//table[@id='CompTable']//tbody//tr//td[@class='dataTable_Right']//a")
	private WebElement attachment;
	
	@FindBy(how = How.XPATH, using="//i[@class='fa fa-edit actionicon']")
	private WebElement editPayment;
	
	@FindBy(how = How.XPATH, using="//i[@class='fa fa-file-text-o actionicon']")
	private WebElement viewPayment;
	
	@FindBy(how = How.XPATH, using="//div[@class='col-sm-4 pull-left']//p[5]")
	private WebElement paymentSlip;
	
	public String dataMessage()	{
		
		return tableMsg.getText();
		
	}
	
	public String verifyPayment() {
		String payment = paidBy.getText();
		return payment;
	}
	
	public Map<Boolean,String> deletePayment()	{
		
		return Elements.CLICK(driver, deletePayment);
		
	}
	
	public Map<Boolean,String> deleteYes()	{
		
		return Elements.CLICK(driver, yesDelete);
		
	}
	
	public Map<Boolean,String> close()	{
		
		return Elements.CLICK(driver, close);
		
	}
	
	public boolean attachment()	{
		boolean attach = false;
		if(attachment.getTagName().equals("a")) {
			attach = true;
		}else {
			attach = false;
		}
		return attach;
	}
	
	public Map<Boolean,String> editPayment()	{
		
		return Elements.CLICK(driver, editPayment);
		
	}
	
	public Map<Boolean,String> viewPayment()	{
		
		return Elements.CLICK(driver, viewPayment);
		
	}
	
	public String paymentSlip()	{
		
		String slip = paymentSlip.getText();
		return slip;
		
	}
	
	
	

}
