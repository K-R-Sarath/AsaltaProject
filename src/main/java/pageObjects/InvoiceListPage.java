package pageObjects;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import commonMethods.Elements;
import commonMethods.Validations;
import commonMethods.Windows;
import io.cucumber.plugin.event.Result;

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
	
	@FindBy(how = How.XPATH, using="//div//a//i")
	private WebElement verifyLinkPage;
	
	@FindBy(how = How.XPATH, using="//ul[@class='dropdown-menu pull-right']//li")
	private List<WebElement> addToDelivery;
	
	@FindBy(how = How.XPATH, using="//table[@id='SLData']//tbody//tr//td//button")
	private List<WebElement> invoiceStatus;
	
	@FindBy(how = How.XPATH, using="//ul[@class='breadcrumb']//li[@class='active breadcrumb_title ']")
	private WebElement invoiceListPageBreadcrumb;
	
	@FindBy(how = How.XPATH, using="//div[@class='col-md-12 text-left']//p[1]//a[2]")
	private WebElement clickDueInInvoice;
	
	@FindBy(how = How.XPATH, using="//table[@id='SLData']//tbody//tr//td//button[@style='cursor: default;']")
	private List<WebElement> invoiceStatusList;
	
	@FindBy(how = How.XPATH, using="//ul[@class='pagination pagination-sm']//li[@class='next']//a[contains(text(),'Next > ')]")
	private WebElement paginate;
	
	@FindBy(how = How.XPATH, using="//ul[@class='pagination pagination-sm']//li[@class='prev']//a[contains(text(),' < Previous')]")
	private WebElement paginateBack;
	
	@FindBy(how = How.XPATH, using = "//div[@class='col-md-12 text-left']//p[1]//a[3]")
	private WebElement clickPaidInInvoice;
	
	@FindBy(how = How.XPATH, using="//div[@class='col-md-12 text-left']//p[1]//a[1]")
	private WebElement clickAllInInvoice;
	
	@FindBy(how = How.XPATH, using="//div[@class='col-md-12 text-left']//p[1]//a[4]")
	private WebElement clickPartiallyPaidInInvoice;
	
	@FindBy(how = How.XPATH, using="//div[@class='col-md-12 text-left']//p[1]//a[5]")
	private WebElement clickReturnedInInvoice;
	
	@FindBy(how = How.XPATH, using="//div[@class='col-md-12 text-left']//p[1]//a[6]")
	private WebElement clickCancelledInInvoice;
	
	@FindBy(how = How.XPATH, using="//div[@id='s2id_autogen2']//a//span[@class='select2-chosen']")
	private WebElement displayOption;
	
	@FindBy(how = How.XPATH, using="//div[@id='select2-drop']//ul//li")
	private List<WebElement> selectDisplay;
	
	@FindBy(how = How.XPATH, using="//div[@id='SLData_info']")
	private WebElement displayResult;
	
	@FindBy(how = How.XPATH, using="//table[@id='SLData']//tbody//tr")
	private List<WebElement> resultInTable;
	
	@FindBy(how = How.ID, using="daterangewithoutlimit")
	private WebElement dateField;
	
	@FindBy(how = How.NAME, using="daterangepicker_start")
	private WebElement dateRangepickerStart;
	
	@FindBy(how = How.NAME, using="daterangepicker_end")
	private WebElement dateRangepickerEnd;
	
	@FindBy(how = How.XPATH, using="//div[@class='range_inputs']//button[1]")
	private WebElement applyButton;
	
	@FindBy(how = How.XPATH, using="//table[@id='SLData']//tbody//tr//td[@class=' sorting_1']")
	private List<WebElement> dateSearchResult;

	
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
	
	public Map<Boolean,String> selectEmailInvoiceSale()	{
		Map<Boolean,String> emailInvoice = null;
		
		for(int i=0;i<selectAddPayment.size();i++) {
			if(i==15) {
				WebElement element = selectAddPayment.get(i);
				emailInvoice = Elements.CLICK(driver, element);
				break;
			}
		}
		return emailInvoice;
		
		
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
	
	public String invoiceStatus()	{
		String invStatus = null;
		
		for(int i=0;i<invoiceStatus.size();i++)	{
			if(i==0){
				WebElement element = invoiceStatus.get(i);
				invStatus = element.getText();
				break;
			}
		}
		return invStatus;
	}
	
	public String getInvoiceListPageBreadcrumb()	{
		String breadcrumb = invoiceListPageBreadcrumb.getText();
		return breadcrumb;
	}
	
	public Map<Boolean,String> clickDueInInvoice()	{
	
		return Elements.CLICK(driver, clickDueInInvoice);
	
	}
	
	public boolean paginateAndGetValues() throws Exception	{
		boolean result = false;
				
		do{
			for(int i=0;i<invoiceStatusList.size();i++) {
				String text = invoiceStatusList.get(i).getText();
				if(text.equalsIgnoreCase("Due")){ 
					result = true;
				} else {
					return false;
				}
			}
			if(Validations.IFELEMENTPRESENT(paginate))
			Elements.CLICK(driver, paginate);
		}
		while(Validations.IFELEMENTPRESENT(paginate));	
		return result;
	}
	
	public Map<Boolean,String> clickPaidInInvoice()	{
		
		return Elements.CLICK(driver, clickPaidInInvoice);
		
	}
	
	public boolean paginateAndGetValuesForPaid() throws Exception	{
		boolean result = false;
				
		do{
			for(int i=0;i<invoiceStatusList.size();i++) {
				String text = invoiceStatusList.get(i).getText();
				if(text.equalsIgnoreCase("Paid")){ 
					result = true;
				} else {
					return false;
				}
			}
			if(Validations.IFELEMENTPRESENT(paginate))
			Elements.CLICK(driver, paginate);
		}
		while(Validations.IFELEMENTPRESENT(paginate));	
		return result;
	}
	
	public Map<Boolean,String> clickAllInInvoice()	{
		
		return Elements.CLICK(driver, clickAllInInvoice);
		
	}
	
	public Map<Boolean,String> clickPartiallyPaidInInvoice()	{
		
		return Elements.CLICK(driver, clickPartiallyPaidInInvoice);
		
	}
	
	public boolean paginateAndGetValuesForPartiallyPaid() throws Exception	{
		boolean result = false;
				
		do{
			for(int i=0;i<invoiceStatusList.size();i++) {
				String text = invoiceStatusList.get(i).getText();
				if(text.equalsIgnoreCase("Partially Paid")){ 
					result = true;
				} else {
					return false;
				}
			}
			if(Validations.IFELEMENTPRESENT(paginate)) 
			Elements.CLICK(driver, paginate);
		}
		while(Validations.IFELEMENTPRESENT(paginate));	
		return result;
	}
	
	public Map<Boolean,String> clickReturnedInInvoice()	{
		
		return Elements.CLICK(driver, clickReturnedInInvoice);
		
	}
	
	public boolean paginateAndGetValuesForReturned() throws Exception	{
		boolean result = false;
				
		do{
			for(int i=0;i<invoiceStatusList.size();i++) {
				String text = invoiceStatusList.get(i).getText();
				if(text.equalsIgnoreCase("Returned")){ 
					result = true;
				} else {
					return false;
				}
			}
			if(Validations.IFELEMENTPRESENT(paginate)) 
			Elements.CLICK(driver, paginate);
		}
		while(Validations.IFELEMENTPRESENT(paginate));	
		return result;
	}
	
	public Map<Boolean,String> clickCancelledInInvoice()	{
		
		return Elements.CLICK(driver, clickCancelledInInvoice);
		
	}
	
	public boolean paginateAndGetValuesForCancelled() throws Exception	{
		boolean result = false;
				
		do{
			for(int i=0;i<invoiceStatusList.size();i++) {
				String text = invoiceStatusList.get(i).getText();
				if(text.equalsIgnoreCase("Cancelled")){ 
					result = true;
				} else {
					return false;
				}
			}
			if(Validations.IFELEMENTPRESENT(paginate)) 
			Elements.CLICK(driver, paginate);
		}
		while(Validations.IFELEMENTPRESENT(paginate));	
		return result;
	}
	
	public boolean paginateAndGetValuesForAll() throws Exception	{
		boolean result = false;
				
		do{
			for(int i=0;i<invoiceStatusList.size();i++) {
				String text = invoiceStatusList.get(i).getText();
				if(text.equalsIgnoreCase("Cancelled") || text.equalsIgnoreCase("Due") || text.equalsIgnoreCase("Paid") ||
				text.equalsIgnoreCase("Partially Paid") || text.equalsIgnoreCase("Returned") || text.equalsIgnoreCase("Pending")){ 
					result = true;
				} else {
					return false;
				}
			}
			if(Validations.IFELEMENTPRESENT(paginate)) 
			Elements.CLICK(driver, paginate);
		}
		while(Validations.IFELEMENTPRESENT(paginate));	
		return result;
	}
	
	public boolean paginateForwardAndVerify()	{
		do{
			if(Validations.IFELEMENTPRESENT(paginate))
			Elements.CLICK(driver, paginate);
		} while(Validations.IFELEMENTPRESENT(paginate));
		if(!Validations.IFELEMENTPRESENT(paginate))
		return true;
		else
		return false;
	}
	
	public boolean paginateBackAndVerify()	{
		do{
			if(Validations.IFELEMENTPRESENT(paginateBack))
				Elements.CLICK(driver, paginateBack);
		} while(Validations.IFELEMENTPRESENT(paginateBack));
		if(!Validations.IFELEMENTPRESENT(paginateBack))
			return true;
		else
			return false;
		
	}
	
	public Map<Boolean,String> clickDisplayOption()	{
		
		return Elements.CLICK(driver, displayOption);
		
	}
	
	public Map<Boolean,String> selectDisplay10()	{
		Map<Boolean,String> ten = null;
		
		for(int i=0;i<selectDisplay.size();i++)	{
			if(i==0) {
				WebElement element = selectDisplay.get(i);
				ten = Elements.CLICK(driver, element);
				break;
			}
		}
		return ten;
	}
	
	public Map<Boolean,String> selectDisplay25()	{
		Map<Boolean,String> twentyFive = null;
		
		for(int i=0;i<selectDisplay.size();i++)	{
			if(i==1) {
				WebElement element = selectDisplay.get(i);
				twentyFive = Elements.CLICK(driver, element);
				break;
			}
		}
		return twentyFive;
	}
	
	public Map<Boolean,String> selectDisplay50()	{
		Map<Boolean,String> fifty = null;
		
		for(int i=0;i<selectDisplay.size();i++)	{
			if(i==2) {
				WebElement element = selectDisplay.get(i);
				fifty = Elements.CLICK(driver, element);
				break;
			}
		}
		return fifty;
	}
	
	public Map<Boolean,String> selectDisplay100()	{
		Map<Boolean,String> hundred = null;
		
		for(int i=0;i<selectDisplay.size();i++)	{
			if(i==3) {
				WebElement element = selectDisplay.get(i);
				hundred = Elements.CLICK(driver, element);
				break;
			}
		}
		return hundred;
	}
	
	public String displayResult10()	{
		String result10 = displayResult.getText().substring(11, 18);
		System.out.println(result10);
		return result10;	
	}
	
	public String displayResult25()	{
		String result25 = displayResult.getText().substring(11, 18);
		System.out.println(result25);
		return result25;	
	}
	
	public String displayResult50()	{
		String result50 = displayResult.getText().substring(11, 18);
		System.out.println(result50);
		return result50;	
	}
	
	public String displayResult100()	{
		String result100 = displayResult.getText().substring(11, 19);
		System.out.println(result100);
		return result100;	
	}
	
	public Integer resultInTable()	{
		return resultInTable.size();
	}
	
	public Map<Boolean,String> clickDateField()	{
		
		return Elements.CLICK(driver, dateField);
		
	}
	
	public Map<Boolean,String> enterFromDate()	{
		
		return Elements.ENTERVALUE(driver, dateRangepickerStart, "26/05/2022");
		
	}
	
	public Map<Boolean,String> enterToDate()	{
		
		return Elements.ENTERVALUE(driver, dateRangepickerEnd, "26/05/2022");
		
	}
	
	public Map<Boolean,String> clickApplyButton()	{
		
		return Elements.CLICK(driver, applyButton);
		
	}
	
	public boolean dateSearchResult()	{
		boolean result = false;
		
		for(int i=0;i<dateSearchResult.size();i++)	{
			String text = dateSearchResult.get(i).getText().substring(14, 25);
			if(text.equalsIgnoreCase("" + "\n" + "26-05-2022")) {
				result = true;
			} else {
				return false;
			}
		}
		return result;
	}
	
	
}
