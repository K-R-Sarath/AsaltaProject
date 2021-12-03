package pageObjects;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import commonMethods.Elements;
import commonMethods.Scrolling;

public class AddPaymentPage {

	private WebDriver driver;
	
	public AddPaymentPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	@FindBy(how = How.ID, using="amount_1")
	private WebElement amountField;
	
	@FindBy(how = How.XPATH, using="//small[@class='help-block']")
	private List<WebElement> alert;
	
	@FindBy(how = How.ID, using="date")
	private WebElement date;
	
	@FindBy(how = How.XPATH, using="//span[@id='select2-chosen-11']")
	private WebElement payByOption;
	
	@FindBy(how = How.XPATH, using="//div[@id='select2-drop']//ul//li")
	private List<WebElement> selectPayByOption;
	
	@FindBy(how = How.NAME, using="add_payment")
	private WebElement savePaymentButton;
	
	@FindBy(how = How.NAME, using="edit_payment")
	private WebElement editPayment;
	
	@FindBy(how = How.XPATH, using="//div[@class='toast-message']//strong")
	private WebElement alertMsg;
	
	@FindBy(how = How.ID, using="gift_card_no")
	private WebElement enterVoucherNo;
	
	@FindBy(how = How.XPATH, using="//label[@class='control-label col-md-3 text-right']")
	private List<WebElement> clickOut;
	
	@FindBy(how = How.XPATH, using="//div[@class='modal-content']//div[@class='modal-body']//div[@class='bootbox-body']")
	private List<WebElement> alertForVoucher;
	
	@FindBy(how = How.ID, using="attachment")
	private WebElement attach;
	
	public Map<Boolean,String> amount()	{
		
		return Elements.CTRLAWITHDELETE(driver, amountField);
		
	}
	
	public String alertMsg1()	{
		String alertMsg = null;
		
		for(int i=0;i<alert.size();i++) {
			if(i==1) {
				WebElement element = alert.get(i);
				alertMsg = element.getText();
				break;
			}
		}
		return alertMsg;
	}
	
	public String alertMsg2()	{
		String alertMsg = null;
		
		for(int i=0;i<alert.size();i++) {
			if(i==0) {
				WebElement element = alert.get(i);
				alertMsg = element.getText();
				break;
			}
		}
		return alertMsg;
	}
	
	public Map<Boolean,String> dATE()	{
		
		return Elements.CTRLAWITHDELETE(driver, date);
		
	}
	
	public Map<Boolean,String>	clickDateField()	{
		
		return Elements.CLICK(driver, date);
		
	}
	
	public Map<Boolean,String> clickPayByOption()	{
		
		return Elements.CLICK(driver, payByOption);
		
	}
	
	public Map<Boolean,String> selectPayByGiftCard()	{
		
		Map<Boolean,String> selectOption = null;
		for(int i=0;i<selectPayByOption.size();i++) {
			if(i==3) {
				WebElement element = selectPayByOption.get(i);
				selectOption = Elements.CLICK(driver, element);
				break;
			}
		}
		return selectOption;
	}
	
	public Map<Boolean,String> selectPayByCash()	{
		
		Map<Boolean,String> selectOption = null;
		for(int i=0;i<selectPayByOption.size();i++) {
			if(i==0) {
				WebElement element = selectPayByOption.get(i);
				selectOption = Elements.CLICK(driver, element);
				break;
			}
		}
		return selectOption;
	}
	
	public Map<Boolean,String> selectPayByCheque()	{
		
		Map<Boolean,String> selectOption = null;
		for(int i=0;i<selectPayByOption.size();i++) {
			if(i==1) {
				WebElement element = selectPayByOption.get(i);
				selectOption = Elements.CLICK(driver, element);
				break;
			}
		}
		return selectOption;
	}
	
	public Map<Boolean,String> selectPayByCredit()	{
		
		Map<Boolean,String> selectOption = null;
		for(int i=0;i<selectPayByOption.size();i++) {
			if(i==2) {
				WebElement element = selectPayByOption.get(i);
				selectOption = Elements.CLICK(driver, element);
				break;
			}
		}
		return selectOption;
	}
	
	public Map<Boolean,String> selectPayByOthers()	{
		
		Map<Boolean,String> selectOption = null;
		for(int i=0;i<selectPayByOption.size();i++) {
			if(i==4) {
				WebElement element = selectPayByOption.get(i);
				selectOption = Elements.CLICK(driver, element);
				break;
			}
		}
		return selectOption;
	}
	
	public Map<Boolean,String> clickSavePaymentButton()	{
		
		return Elements.CLICK(driver, savePaymentButton);
		
	}
	
	public Map<Boolean,String> clickSavePaymentButton_Edit()	{
		
		return Elements.CLICK(driver, editPayment);
		
	}
	
	public String alertMsg3()	{
		String alert1 = alertMsg.getText();
		return alert1;
	}
	
	public Map<Boolean,String> enterGiftVoucher(String gift)	{
		
		return Elements.ENTERVALUE(driver, enterVoucherNo, gift);
		
	}
	
	public Map<Boolean,String> clickOutside()	{
		
		Map<Boolean,String> outClick = null;
		for(int i=0;i<clickOut.size();i++) {
			if(i==4) {
				WebElement element = clickOut.get(i);
				outClick = Elements.CLICK(driver, element);
				break;
			}
		}
		return outClick;
	}
	
	public String alertMsg4() {
		String alert = null;
		
		for(int i=0;i<alertForVoucher.size();i++) {
			if(i==0) {
				WebElement element = alertForVoucher.get(i);
				alert = element.getText();
				break;
			}
		}
		return alert;
	}
	
	public void scroll1()	{
		Scrolling.SCROLLINTOVIEW(driver, savePaymentButton);
	}
	
	public void scroll2()	{
		Scrolling.SCROLLINTOVIEW(driver, editPayment);
	}
	
	public Map<Boolean,String> attachFile()	{
		
		return Elements.UPLOADFILE(driver, attach, "E:\\\\Steps to Run the Test Script.docx");
		
	}
	
	public Map<Boolean,String> enterAmount(String amt)	{
		
		return Elements.ENTERVALUE(driver, amountField, amt);
		
	}
	
	
}
