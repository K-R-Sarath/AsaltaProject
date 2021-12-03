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
import commonMethods.Validations;
import commonMethods.Windows;

public class InvoiceListPage {
	
	private WebDriver driver;
	
	public InvoiceListPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	@FindBy(how = How.XPATH, using = "//div[@class='col-md-12 text-right']//a")
	private WebElement clickNewInvoiceButton;
	
	@FindBy(how = How.XPATH, using = "//button[@class='btn btn-default dropdown-toggle btn-xs']")
	private List<WebElement> clickActionIcon;
	
	@FindBy(how = How.XPATH, using = "//ul[@class='dropdown-menu pull-right']//li")
	private List<WebElement> selectEditInvoice;
	
	@FindBy(how = How.XPATH, using = "//table[@id='SLData']/tbody/tr[1]/td/div")
	private List<WebElement> totalAmount; 
	
	@FindBy(how = How.XPATH, using = "//table[@id='SLData']/tbody/tr[1]/td/div")
	private List<WebElement> outstandingAmount;
	
	@FindBy(how = How.XPATH, using = "//ul[@class='dropdown-menu pull-right']//li")
	private List<WebElement> selectViewPayments;
	
	@FindBy(how = How.XPATH, using = "//ul[@class='dropdown-menu pull-right']//li")
	private List<WebElement> selectAddPayment;
	
	@FindBy(how = How.XPATH, using = "//table[@id='SLData']//tbody//tr//td//button")
	private List<WebElement> status;
	
	@FindBy(how = How.XPATH, using="//table[@id='SLData']//tbody//tr//td[@class=' sorting_1']//b")
	private List<WebElement> invoiceNumberInListPage;
	
	@FindBy(how = How.XPATH, using="//div[@class='col-sm-12 col-md-12']//ul//li[@class='active breadcrumb_title ']")
	private WebElement verifyInvoiceNumberInSaleDetailsPage;
	
	@FindBy(how = How.XPATH, using = "//ul[@class='dropdown-menu pull-right']//li")
	private List<WebElement> selectInvoiceDetails;
	
	@FindBy(how = How.XPATH, using = "//ul[@class='dropdown-menu pull-right']//li")
	private List<WebElement> selectInvoiceLink;
	
	@FindBy(how = How.NAME, using="paypalPay")
	private WebElement verifyLinkPage;
	
	@FindBy(how = How.XPATH, using="//ul[@class='dropdown-menu pull-right']//li")
	private List<WebElement> addToDelivery;

	
	public Map<Boolean,String> clickNewInvoiceButton() {

		return Elements.CLICK(driver, clickNewInvoiceButton);
		
	}
	
	public Map<Boolean,String> clickActionIcon()	{
		Map<Boolean,String> clickActionButton = null;
		
		for(int i=0;i<clickActionIcon.size();i++) {
			if(i==0) {
				WebElement element = clickActionIcon.get(i);
				clickActionButton = Elements.CLICK(driver, element);
				break;
			}
		}
		return clickActionButton;
	}
	
	public Map<Boolean,String> selectEditOption()	{
		Map<Boolean,String> selectEdit = null;
		
		for(int i=0;i<selectEditInvoice.size();i++) {
			if(i==6) {
				WebElement element = selectEditInvoice.get(i);
				selectEdit = Elements.CLICK(driver, element);
				break;
			}
		}
		return selectEdit;
	}
	
	public Long getTotalAmount()	{
		
		Map<Boolean,String> totalAmt = new HashMap<>();
		String amt = null;
		String amtAfterTrimming = null;
		for(int i=0;i<totalAmount.size();i++) {
			if(i==0) {
				WebElement element = totalAmount.get(i);
				amt = element.getText();
				break;
			}
		}
		amtAfterTrimming = amt.substring(2, amt.indexOf('.'));
		String[] retval = amtAfterTrimming.split(",");
		StringBuilder builder = new StringBuilder();
	    for(String a:retval) {
	    	builder.append(a);
	    }
	    long value = Long.parseLong(builder.toString());
		totalAmt.put(true, Long.toString(value));
		return Long.valueOf(totalAmt.get(true));
	}
	
	public Long getOutstandingAmount()	{
		
		Map<Boolean,String> outstandingAmt = new HashMap<>();
		String amt = null;
		String amtAfterTrimming = null;
		for(int i=0;i<totalAmount.size();i++) {
			if(i==1) {
				WebElement element = totalAmount.get(i);
				amt = element.getText();
				break;
			}
		}
		amtAfterTrimming = amt.substring(2, amt.indexOf('.'));
		String[] retval = amtAfterTrimming.split(",");
		StringBuilder builder = new StringBuilder();
	    for(String a:retval) {
	    	builder.append(a);
	    }
	    long value = Long.parseLong(builder.toString());
		outstandingAmt.put(true, Long.toString(value));
		return Long.valueOf(outstandingAmt.get(true));
	}
	
	public Map<Boolean,String> selectViewPayments()	{
		
		Map<Boolean,String> selectViewPayment = null;
		
		for(int i=0;i<selectViewPayments.size();i++) {
			if(i==7) {
				WebElement element = selectViewPayments.get(i);
				selectViewPayment = Elements.CLICK(driver, element);
				break;
			}
		}
		return selectViewPayment;
		
	}
	
	public Map<Boolean,String> selectAddPayments()	{
		
		Map<Boolean,String> selectAddPayments = null;
		
		for(int i=0;i<selectAddPayment.size();i++) {
			if(i==8) {
				WebElement element = selectAddPayment.get(i);
				selectAddPayments = Elements.CLICK(driver, element);
				break;
			}
		}
		return selectAddPayments;
	}
	
	public String currentStatus()	{
		
		String sts = null;
		for(int i=0;i<status.size();i++)	{
			if(i==0) {
				WebElement element = status.get(i);
				sts = element.getText();
				break;
			}
		}
		return sts;
	}
	
	public String getInvoiceNumberFromListPage()	{
		String invoiceNo = null;
		
		for(int i=0;i<invoiceNumberInListPage.size();i++)	{
			if(i==0) {
				WebElement element = invoiceNumberInListPage.get(i);
				invoiceNo = element.getText();
				break;
			}
		}
		return invoiceNo;
	}
	
	public Map<Boolean,String> clickOnInvoice()	{
		
		Map<Boolean,String> clickInvoice = null;
		
		for(int i=0;i<invoiceNumberInListPage.size();i++)	{
			if(i==0) {
				WebElement element = invoiceNumberInListPage.get(i);
				clickInvoice = Elements.CLICK(driver, element);
				break;
			}
		}
		return clickInvoice;
	}
	
	public String verifyInvoiceNumber()	{
		
		return verifyInvoiceNumberInSaleDetailsPage.getText();
		
	}
	
	public Map<Boolean,String> selectInvoiceSaleDetails()	{
		
		Map<Boolean,String> invoiceSaleDetails = null;
		for(int i=0;i<selectInvoiceDetails.size();i++)	{
			if(i==3) {
				WebElement element = selectInvoiceDetails.get(i);
				invoiceSaleDetails = Elements.CLICK(driver, element);
				break;
			}
		}
		return invoiceSaleDetails;
	}
	
	public Map<Boolean,String> selectInvoiceLink()	{
		
		Map<Boolean,String> invoiceLink = null;
		for(int i=0;i<selectInvoiceLink.size();i++)	{
			if(i==5) {
				WebElement element = selectInvoiceLink.get(i);
				invoiceLink = Elements.CLICK(driver, element);
				break;
			}
		}
		return invoiceLink;
	}
	
	public Map<Boolean,String> switchToNewWindow()	{
		
		return Windows.FOCUSWINDOW(driver);
		
	}
	
	public Map<Boolean,String> verifyLink() {
		
		return Validations.VERIFYOBJECT(driver, verifyLinkPage);
		
	}
	
	public Map<Boolean,String> clickAddToDelivery()	{
		
		Map<Boolean,String> clickDelivery = null;
		for(int i=0;i<addToDelivery.size();i++) {
			if(i==10) {
				WebElement element = addToDelivery.get(i);
				clickDelivery = Elements.CLICK(driver, element);
				break;
			}
		}
		return clickDelivery;		
	}
	
	public Map<Boolean,String> returnInvoiceSale()	{
		
		Map<Boolean,String> returnSale = null;
		for(int i=0;i<selectEditInvoice.size();i++) {
			if(i==16) {
				WebElement element = selectEditInvoice.get(i);
				returnSale = Elements.CLICK(driver, element);
				break;
			}
		}
		return returnSale;
	}
	
	
}
