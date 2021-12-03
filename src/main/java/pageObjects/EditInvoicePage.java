package pageObjects;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import commonMethods.Elements;
import commonMethods.Scrolling;

public class EditInvoicePage {
	
	private WebDriver driver;
	
	public EditInvoicePage(WebDriver driver)	{
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	@FindBy(how = How.XPATH, using="//input[@name='quantity[]']")
	private WebElement quantity;
	
	@FindBy(how = How.ID, using="edit_sale")
	private WebElement saveSaleButton;
	
	@FindBy(how = How.XPATH, using="//div[@class='toast-message']")
	private WebElement successMsg;
	
	@FindBy(how = How.XPATH, using="//table[@id='slTable']//thead//tr//th[6]")
	private WebElement clickOut;
	
	@FindBy(how = How.ID, using="sldiscount")
	private WebElement discount;
	
	@FindBy(how = How.XPATH, using="//label[@for='sldiscount']")
	private WebElement clickOutOfDisc;
	
	@FindBy(how = How.XPATH, using="//tr[@id='tfoot']//th[@class='text-right']")
	private List<WebElement> discAmount;
	
	@FindBy(how = How.ID, using="coupon_code")
	private WebElement couponCode;
	
	@FindBy(how = How.XPATH, using="//i[@title='Remove']")
	private List<WebElement> removeItem;
	
	@FindBy(how = How.XPATH, using="//div[@class='toast-message']/p")
	private WebElement alertMsg;
	
	@FindBy(how = How.ID, using="document")
	private WebElement attachment;
	
	@FindBy(how = How.ID, using="select2-chosen-4")
	private WebElement saleStatusClick;
	
	@FindBy(how = How.XPATH, using="//div[@id='select2-drop']//ul//li[4]")
	private WebElement changeSaleStatusToCancelled;
	
	public void scroll()	{
		Scrolling.SCROLLINTOVIEW(driver, quantity);
	}
	
	public Map<Boolean,String> editQuantity()	{
		
		return Elements.ENTERVALUE1(driver, quantity, "7");
		
	}
	
	public Map<Boolean,String> editQty(String qty)	{
		
		return Elements.ENTERVALUE1(driver, quantity, qty);
		
	}
	
	public String success1()	{
		String success = successMsg.getText();
		return success;
	}
	
	public Map<Boolean,String> clickSaveSaleButton()	{
		
		return Elements.CLICK(driver, saveSaleButton);
		
	}
	
	public Map<Boolean,String> clickOutside()	{
		
		return Elements.CLICK(driver, clickOut);
		
	}
	
	public void scroll1()	{
		Scrolling.SCROLLINTOVIEW(driver, discount);
	}
	
	public Map<Boolean,String> enterDiscount(String disc)	{
		
		return Elements.ENTERVALUE(driver, discount, disc);
		
	}
	
	public Map<Boolean,String> clickOutOfDisc()	{
		
		return Elements.CLICK(driver, clickOutOfDisc);
		
	}
	
	public Map<Boolean,String> getAmount()	{
		
		String globalAmt = null;
		String dscAmt = null;
		Map<Boolean,String> discounts = new HashMap<>();
		
		for(int i=0;i<discAmount.size();i++) {
			if(i==2) {
				WebElement element = discAmount.get(i);
				dscAmt = element.getText();
				break;
			}
		}
		globalAmt = dscAmt.substring(2, dscAmt.indexOf('.'));
		discounts.put(true, globalAmt);
		return discounts;
		
	}
	
	public Long amount()	{
		long amount;
		String amt = getAmount().get(true);
		String[] retval = amt.split(",");
	    StringBuilder builder = new StringBuilder();
	    for(String a:retval) {
	    	builder.append(a);
	    }
	    long add = Long.parseLong(builder.toString());
	    amount = add + 1;
		return amount;
	}
	
	public Map<Boolean,String> enterDsc()	{
		
		return Elements.ENTERVALUE(driver, discount, Long.toString(amount()));
		
	}
	
	public void scroll2()	{
		Scrolling.SCROLLINTOVIEW(driver, couponCode);
	}
	
	public Map<Boolean,String> deleteItem()	{
		
		Map<Boolean,String> dlteItem = null;
		
		for(int i=0;i<removeItem.size();i++)	{
			if(i==0) {
				WebElement element = removeItem.get(i);
				dlteItem = Elements.CLICK(driver, element);
				break;
			}
		}
		return dlteItem;
	}
	
	public String success2()	{
		String alert = alertMsg.getText();
		return alert;
	}
	
	public String totalAmt() {
		String dscAmt = null;
		for(int i=0;i<discAmount.size();i++) {
			if(i==2) {
				WebElement element = discAmount.get(i);
				dscAmt = element.getText();
				break;
			}
		}
		return dscAmt;
	}
	
	public void scroll3()	{
		Scrolling.SCROLLINTOVIEW(driver, attachment);
	}
	
	public Map<Boolean,String> attachFile()	{
		
		return Elements.UPLOADFILE(driver, attachment, "E:\\Steps to Run the Test Script.docx");
		
	}
	
	public Map<Boolean,String> clickEditSaleButton()	{
		
		return Elements.CLICK(driver, saveSaleButton);
		
	}
	
	public Map<Boolean,String> clickSaleStatus()	{
		
		return Elements.CLICK(driver, saleStatusClick);
		
	}
	
	public Map<Boolean,String> changeSaleStatus()	{
		
		return Elements.CLICK(driver, changeSaleStatusToCancelled);
		
	}

}
