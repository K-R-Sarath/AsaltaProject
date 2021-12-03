package pageObjects;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import commonMethods.Elements;
import commonMethods.Scrolling;
import commonMethods.Validations;
import commonMethods.WaitConditions;
import commonMethods.Windows;

public class InvoiceCreationPage {
	
	private WebDriver driver;
	JavascriptExecutor jse = (JavascriptExecutor) driver;
	
	public InvoiceCreationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	@FindBy(how = How.XPATH, using = "//span[@id='select2-chosen-15']")
	private WebElement clickCustomerField;
	
	@FindBy(how = How.ID, using = "s2id_autogen15_search")
	private WebElement enterCustName;
	
	@FindBy(how = How.XPATH, using = "//ul[@id='select2-results-15']//li")
	private List<WebElement> selectCust;
	
	@FindBy(how = How.ID, using = "search_items-selectized")
	private WebElement clickItemNameFieldAndEnterItem;
	
	@FindBy(how = How.XPATH, using = "//div[@class='selectize-dropdown single search_items skip plugin-no_results']//div//div[@class='option']")
	private List<WebElement> selectItem;
	
	@FindBy(how = How.ID, using="add_sale")
	private WebElement saveSaleButton;
	
	@FindBy(how = How.XPATH, using="//div[@class='toast-message']")
	private WebElement successMsg;
	
	@FindBy(how = How.XPATH, using="//div[@class='toast-message']")
	private WebElement alertMsg1;
	
	@FindBy(how = How.NAME, using="quantity[]")
	private WebElement quantity;
	
	@FindBy(how = How.XPATH, using="//div[@class='toast-message']")
	private WebElement alertMsg2;
	
	@FindBy(how = How.XPATH, using="//button[@class='btn applyBtn']")
	private WebElement applyCouponButton;
	
	@FindBy(how = How.XPATH, using="//div[@class='toast-message']")
	private WebElement successMsg2;
	
	@FindBy(how = How.XPATH, using="//div[@class='toast-message']")
	private WebElement alertMsg3;
	
	@FindBy(how = How.XPATH, using="//div[@class='row']//div[@class='col-sm-6']//div//ins[@class='iCheck-helper']")
	private WebElement priceBookListPriceCheckbox;
	
	@FindBy(how = How.XPATH, using="//div[@class='toast-message']")
	private WebElement alertMsg4;
	
	@FindBy(how = How.XPATH, using="//div[@class='col-sm-6 form-group']//label[@class='control-label col-sm-4 text-right']")
	private List<WebElement> clickOutAfterSelectingCustomer;
	
	@FindBy(how = How.XPATH, using="//table[@id='slTable']//thead/tr/th")
	private List<WebElement> clickOut;
	
	@FindBy(how = How.ID, using="coupon_code")
	private WebElement coupons;
	
	@FindBy(how = How.ID, using="sldiscount")
	private WebElement discount;
	
	@FindBy(how = How.XPATH, using="//label[@class='control-label col-sm-5 text-right']")
	private List<WebElement> clickOutAfterDiscount;
	
	@FindBy(how = How.XPATH, using="//div[@class='toast-message']")
	private WebElement alertMsg5;
	
	@FindBy(how = How.ID, using="document")
	private WebElement attachDocument;
	
	@FindBy(how = How.XPATH, using="//table//tbody//tr[1]//td[@class=' sorting_1']")
	private WebElement attachmentVerification;
	
	@FindBy(how = How.XPATH, using="//div[@class='btn-group btn-group-justified']//div[1]")
	private WebElement scrollToAttachment;
	
	@FindBy(how = How.XPATH,using="//div[@class='btn-group btn-group-justified']//div//a//span")
	private List<WebElement> attachment;
	
	
	
	public Map<Boolean,String> clickCustomerField() {
		
		return Elements.CLICK(driver, clickCustomerField);
		
	}
	
	public Map<Boolean,String> enterCustomerName() {
		
		return Elements.ENTERVALUE(driver, enterCustName, "a");
		
	}
	
	public Map<Boolean,String> selectCustomer() {
		
		Map<Boolean,String> selectCustomer = null;
		
		for(int i=0;i<selectCust.size();i++) {
			if(i==0) {
				WebElement element = selectCust.get(i);
				System.out.println("0th element " + element.getText());
				selectCustomer = Elements.CLICK(driver, element);
				break;
			}
		}
		return selectCustomer;
	}
	
	public Map<Boolean,String> refreshCurrentPage()	{
		
		return Windows.REFRESHPAGE(driver);
		
	}
	
	public void scroll() {
		
		Scrolling.SCROLLINTOVIEW(driver, clickItemNameFieldAndEnterItem);
	
	}
	
	public Map<Boolean,String> enterItem() {
		
		return Elements.ENTERVALUE(driver, clickItemNameFieldAndEnterItem, "b");
		
	}
	
	public Map<Boolean,String> selectItem() {
		
		Map<Boolean,String> selectItems = null;
		
		for(int i=0;i<selectItem.size();i++) {
			if(i==1) {
				WebElement element = selectItem.get(i);
				selectItems = Elements.CLICK(driver, element);
			}
		}
		
		return selectItems;
		
	}
	
	public Map<Boolean,String> clickAddSaleButton()	{
		
		return Elements.CLICK(driver, saveSaleButton);
		
	}
	
	public String success()	{
		String successful = successMsg.getText();
		return successful;
	}
	
	public String alert() {
		String alert = alertMsg1.getText();
		return alert;
	}
	
	public Map<Boolean,String> enterQuantity(String Quantity)	{
		
		return Elements.ENTERVALUE1(driver, quantity, Quantity);
	
	}
	
	public Map<Boolean,String> clickOutside()	{
		
		Map<Boolean,String> clickOutside = null;
		
		for(int i=0;i<clickOut.size();i++)	{
			if(i==5) {
				WebElement element = clickOut.get(i);
				clickOutside = Elements.CLICK(driver, element);
				break;
			}
		}
		return clickOutside;
	}
	
	public String alert2()	{
		String alert = alertMsg2.getText();
		return alert;
	}
	
	public Map<Boolean,String> clickApplyCouponButton()	{
		
		return Elements.CLICK(driver, applyCouponButton);
		
	}
	
	public String successMsg2()	{
		String success2 = successMsg2.getText();
		return success2;
	}
	
	public String alert3()	{
		String alert = alertMsg3.getText();
		return alert;
	}
	
	public Map<Boolean,String> clickCheckbox()	{
		
		return Elements.CLICK(driver, priceBookListPriceCheckbox);
		
	}
	
	public void scroll1()	{
		Scrolling.SCROLLINTOVIEW(driver, priceBookListPriceCheckbox);
	}
	

	public boolean selectCheckbox()	{
		
		return Validations.ISSELECTED(priceBookListPriceCheckbox);
		
	}
	
	public String alert4()	{
		String alert = alertMsg4.getText();
		return alert;
	}
	
	public Map<Boolean,String> enterCoupons(String couponCodes)	{
		
		return Elements.ENTERVALUE(driver, coupons, couponCodes);
		
	}
	
	public Map<Boolean,String> enterDiscount(String disc)	{
		
		return Elements.ENTERVALUE(driver, discount, disc);
		
	}
	
	public Map<Boolean,String> clickOutAfterDiscount()	{
		
		Map<Boolean,String> clickOut = null;
		
		for(int i=0;i<clickOutAfterDiscount.size();i++) {
			if(i==2) {
				WebElement element = clickOutAfterDiscount.get(i);
				clickOut = Elements.CLICK(driver, element);
				break;
			}
		}
		return clickOut;		
		
	}
	
	public String alert5() {
		String alert = alertMsg5.getText();
		return alert;
	}
	
	public Map<Boolean,String> attachFile()	{
		
		return Elements.UPLOADFILE(driver, attachDocument, "E:\\Steps to Run the Test Script.docx");
		
	}
	
	public Map<Boolean,String> verifyAttachment()	{
		
		return Elements.CLICK(driver, attachmentVerification);
	
	}
	
	public String attachment()	{
		String text = null;
		
		for(int i=0;i<attachment.size();i++)	{
			if(i==0) {
				WebElement element = attachment.get(i);
				text = element.getText();
				break;
			}
		}
		return text;
	}
	
	public void scroll2()	{
		Scrolling.SCROLLINTOVIEW(driver, scrollToAttachment);
	}
	
}
