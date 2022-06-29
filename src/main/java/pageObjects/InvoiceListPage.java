package pageObjects;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
	
	@FindBy(how = How.XPATH, using="//table[@id='SLData']//thead//tr//th[contains(text(),'Status')]")
	private WebElement sortStatusInAsc;
	
	@FindBy(how = How.XPATH, using="//table[@id='SLData']//tbody//tr//td[@class=' sorting_1']//button")
	private List<WebElement> statusList;
	
	@FindBy(how = How.XPATH, using="//table[@id='SLData']//thead//tr//th[contains(text(),'Channels')]")
	private WebElement sortChannels;
	
	@FindBy(how = How.XPATH, using="//table[@id='SLData']//tbody//tr//td[2]")
	private List<WebElement> channelsList;
	
	@FindBy(how = How.XPATH, using="//table[@id='SLData']//thead//tr//th[contains(text(),'Channel Order No')]")
	private WebElement sortChannelOrderNo;
	
	@FindBy(how = How.XPATH, using="//table[@id='SLData']//tbody//tr//td[3]")
	private List<WebElement> channelOrderNoList;
	
	@FindBy(how = How.XPATH, using="//table[@id='SLData']//thead//tr//th[contains(text(),'Invoice')]")
	private WebElement sortInvoices;
	
	@FindBy(how = How.XPATH, using="//table[@id='SLData']//tbody//tr//td[4]")
	private List<WebElement> invoicesList;
	
	@FindBy(how = How.XPATH, using="//table[@id='SLData']//thead//tr//th[contains(text(),'Biller')]")
	private WebElement sortBillers;
	
	@FindBy(how = How.XPATH, using="//table[@id='SLData']//tbody//tr//td[5]")
	private List<WebElement> billersList;
	
	@FindBy(how = How.XPATH, using="//table[@id='SLData']//thead//tr//th[contains(text(),'Customer')]")
	private WebElement sortCustomers;
	
	@FindBy(how = How.XPATH, using="//table[@id='SLData']//tbody//tr//td[6]")
	private List<WebElement> customersList;
	
	@FindBy(how = How.XPATH, using="//table[@id='SLData']//thead//tr//th[contains(text(),'Total')]")
	private WebElement sortTotalAmount;
	
	@FindBy(how = How.XPATH, using="//table[@id='SLData']//tbody//tr//td[7]//div")
	private List<WebElement> totalAmountList;
	
	@FindBy(how = How.XPATH, using="//table[@id='SLData']//thead//tr//th[contains(text(),'Outstanding')]")
	private WebElement sortOutstandingAmount;
	
	@FindBy(how = How.XPATH, using="//table[@id='SLData']//tbody//tr//td[8]//div")
	private List<WebElement> outstandingAmountList;
	
	@FindBy(how = How.XPATH, using="//table[@id='SLData']//thead//tr[@class='active']//th[2]//div//div//a//span[@class='select2-chosen']")
	private WebElement clickChannelsDropDown;
	
	@FindBy(how = How.XPATH, using="//div[@id='select2-drop']//ul//li[2]")
	private WebElement selectInvoiceSales;
	
	@FindBy(how = How.XPATH, using="//table[@id='SLData']//tbody//tr//td[2]")
	private List<WebElement> displayedChannel;
	
	@FindBy(how = How.XPATH, using="//div[@id='select2-drop']//ul//li[3]")
	private WebElement selectPOS;
	
	@FindBy(how = How.XPATH, using="//div[@id='select2-drop']//ul//li[4]")
	private WebElement selectEcommerce;
	
	@FindBy(how = How.XPATH, using="//div[@id='select2-drop']//ul//li[5]")
	private WebElement selectWoocommerce;
	
	@FindBy(how = How.XPATH, using="//div[@id='select2-drop']//ul//li[6]")
	private WebElement selectOpencart;
	
	@FindBy(how = How.XPATH, using="//div[@id='select2-drop']//ul//li[7]")
	private WebElement selectShopify;
	
	@FindBy(how = How.XPATH, using="//div[@id='select2-drop']//ul//li[9]")
	private WebElement selectLazada;
	
	@FindBy(how = How.XPATH, using="//div[@id='select2-drop']//ul//li[10]")
	private WebElement selectShopee;
	
	@FindBy(how = How.XPATH, using="//table[@id='SLData']//tbody//tr//td[3]")
	private List<WebElement> getInputForChannelOrderNoSearch;
	
	@FindBy(how = How.XPATH, using="//table[@id='SLData']//thead//tr[2]//th[3]//div//input")
	private WebElement searchChannelOrderNo;
	
	@FindBy(how = How.XPATH, using="//table[@id='SLData']//tbody//tr//td[3]")
	private WebElement searchResultForChannelOrderNo;
	
	@FindBy(how = How.XPATH, using="//table[@id='SLData']//tbody//tr//td[4]")
	private List<WebElement> getInputForInvoice;
	
	@FindBy(how = How.XPATH, using="//table[@id='SLData']//thead//tr[2]//th[4]//div//input")
	private WebElement searchInvoice;
	
	@FindBy(how = How.XPATH, using="//table[@id='SLData']//tbody//tr//td[4]")
	private WebElement searchResultForInvoice;
	
	@FindBy(how = How.XPATH, using="//table[@id='SLData']//tbody//tr//td[5]")
	private List<WebElement> getInputForBiller;
	
	@FindBy(how = How.XPATH, using="//table[@id='SLData']//thead//tr[2]//th[5]//div//input")
	private WebElement searchBiller;
	
	@FindBy(how = How.XPATH, using="//table[@id='SLData']//tbody//tr//td[5]")
	private WebElement searchResultForBiller;
	
	@FindBy(how = How.XPATH, using="//table[@id='SLData']//tbody//tr//td[6]")
	private List<WebElement> getInputForCustomer;
	
	@FindBy(how = How.XPATH, using="//table[@id='SLData']//thead//tr[2]//th[6]//div//input")
	private WebElement searchCustomer;
	
	@FindBy(how = How.XPATH, using="//table[@id='SLData']//tbody//tr//td[6]")
	private WebElement searchResultForCustomer;
	
	@FindBy(how = How.XPATH, using="//table[@id='SLData']//tbody//tr//td[7]//div")
	private List<WebElement> getInputForTotalAmount;
	
	@FindBy(how = How.XPATH, using="//table[@id='SLData']//thead//tr[2]//th[7]//div//input")
	private WebElement searchTotalAmount;
	
	@FindBy(how = How.XPATH, using="//table[@id='SLData']//tbody//tr//td[7]//div")
	private List<WebElement> searchResultForTotalAmount;
	
	@FindBy(how = How.XPATH, using="//table[@id='SLData']//tbody//tr//td[8]//div")
	private List<WebElement> getInputForOutstandingAmount;
	
	@FindBy(how = How.XPATH, using="//table[@id='SLData']//thead//tr[2]//th[8]//div//input")
	private WebElement searchOutstandingAmount;
	
	@FindBy(how = How.XPATH, using="//table[@id='SLData']//tbody//tr//td[7]//div")
	private List<WebElement> searchResultForOutstandingAmount;
	
	@FindBy(how = How.XPATH, using="//div[@class='form-group hamberFilter']//ul//li//a//button")
	private WebElement moreButton;
	
	@FindBy(how = How.ID, using="bulk_add_delivery")
	private WebElement bulkAddToDelivery;
	
	@FindBy(how = How.XPATH, using="//table[@id='SLData']//thead//tr[1]//div")
	private WebElement bulkSelectInvoices;
	
	@FindBy(how = How.ID, using="add_delivery")
	private WebElement addDeliveryButton;
	
	@FindBy(how = How.XPATH, using="//ul[@class='dropdown-menu pull-right']//li//a")
	private List<WebElement> editDelivery;
	
	@FindBy(how = How.XPATH, using="//div[@id='sidebar_menu']//ul//li[@class='mm_sales mm_quotes mm_saleorders mm_pos active']//a")
	private WebElement salesFromSideMenu;

	
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
		if(!Validations.IFELEMENTPRESENT(paginate)) {
			for(int i=0;i<invoiceStatusList.size();i++) {
				String text = invoiceStatusList.get(i).getText();
				if(text.equalsIgnoreCase("Due")){ 
					result = true;
				} else {
					return false;
				}
			}
		}
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
		if(!Validations.IFELEMENTPRESENT(paginate)) {
			for(int i=0;i<invoiceStatusList.size();i++) {
				String text = invoiceStatusList.get(i).getText();
				if(text.equalsIgnoreCase("Paid")){ 
					result = true;
				} else {
					return false;
				}
			}
		}
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
		if(!Validations.IFELEMENTPRESENT(paginate)) {
			for(int i=0;i<invoiceStatusList.size();i++) {
				String text = invoiceStatusList.get(i).getText();
				if(text.equalsIgnoreCase("Partially Paid")){ 
					result = true;
				} else {
					return false;
				}
			}
		}
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
		if(!Validations.IFELEMENTPRESENT(paginate)) {
			for(int i=0;i<invoiceStatusList.size();i++) {
				String text = invoiceStatusList.get(i).getText();
				if(text.equalsIgnoreCase("Returned")){ 
					result = true;
				} else {
					return false;
				}
			}
		}
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
		if(!Validations.IFELEMENTPRESENT(paginate)) {
			for(int i=0;i<invoiceStatusList.size();i++) {
				String text = invoiceStatusList.get(i).getText();
				if(text.equalsIgnoreCase("Cancelled")){ 
					result = true;
				} else {
					return false;
				}
			}
		}
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
		if(!Validations.IFELEMENTPRESENT(paginate)) {
			for(int i=0;i<invoiceStatusList.size();i++) {
				String text = invoiceStatusList.get(i).getText();
				if(text.equalsIgnoreCase("Cancelled") || text.equalsIgnoreCase("Due") || text.equalsIgnoreCase("Paid") ||
				text.equalsIgnoreCase("Partially Paid") || text.equalsIgnoreCase("Returned") || text.equalsIgnoreCase("Pending")){ 
					result = true;
				} else {
					return false;
				}
			}
		}
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
	
	public Map<Boolean,String> clickStatus()	{
	
		return Elements.CLICK(driver, sortStatusInAsc);
	
	}
	
	public boolean verifyObtainedAndSortedList()	{
		
		ArrayList<String> obtainedList = new ArrayList<>();
		
		do{
			for(WebElement element : statusList) {
				obtainedList.add(element.getText());
			}
			if(Validations.IFELEMENTPRESENT(paginate))
				Elements.CLICK(driver, paginate);	
		}while(Validations.IFELEMENTPRESENT(paginate));
			if(!Validations.IFELEMENTPRESENT(paginate))
				for(WebElement element : statusList) {
					obtainedList.add(element.getText());
				}
				System.out.println(obtainedList.size());
		
		ArrayList<String> sortedList = new ArrayList<>();
			for(String s : obtainedList)	{
				sortedList.add(s);
			}
			Collections.sort(sortedList);
			System.out.println(sortedList.size());
			return sortedList.equals(obtainedList);
	}
	
	public boolean verifyObtainedAndSortedListinDescOrder()	{
		
		ArrayList<String> obtainedList = new ArrayList<>();
		
		do{
			for(WebElement element : statusList) {
				obtainedList.add(element.getText());
			}
			if(Validations.IFELEMENTPRESENT(paginate))
				Elements.CLICK(driver, paginate);	
		}while(Validations.IFELEMENTPRESENT(paginate));
			if(!Validations.IFELEMENTPRESENT(paginate))
				for(WebElement element : statusList) {
					obtainedList.add(element.getText());
				}
				System.out.println(obtainedList.size());
		
		ArrayList<String> sortedList = new ArrayList<>();
			for(String s : obtainedList)	{
				sortedList.add(s);
			}
			Collections.sort(sortedList);
			Collections.reverse(sortedList);
			System.out.println("Desc : " +sortedList.size());
			return sortedList.equals(obtainedList);
	}
	
	public Map<Boolean,String> clickChannels()	{
		
		return Elements.CLICK(driver, sortChannels);
	
	}
	
	public boolean verifyObtainedAndSortedChannels() throws Exception	{
		ArrayList<String> obtainedList = new ArrayList<>();
		
		do{
			for(WebElement element : channelsList) {
				obtainedList.add(element.getText());
			}
			if(Validations.IFELEMENTPRESENT(paginate))
				Elements.CLICK(driver, paginate);	
		  }while(Validations.IFELEMENTPRESENT(paginate));
		if(!Validations.IFELEMENTPRESENT(paginate))
			for(WebElement element : channelsList) {
				obtainedList.add(element.getText());
			}
		System.out.println("Obtained : "+obtainedList.size());
		
		ArrayList<String> sortedList = new ArrayList<>();
		for(String s : obtainedList)	{
			sortedList.add(s);
		}
		 Collections.sort(sortedList, String.CASE_INSENSITIVE_ORDER);
		System.out.println("Sorted : "+sortedList.size());
		if(sortedList.equals(obtainedList)) {
			return true;
		} else {
			return false;
		}		
	}
	
	public boolean verifyObtainedAndSortedChannelsInDescOrder()	{
		
		ArrayList<String> obtainedList = new ArrayList<>();
		
		do{
			for(WebElement element : channelsList) {
				obtainedList.add(element.getText());
			}
			if(Validations.IFELEMENTPRESENT(paginate))
				Elements.CLICK(driver, paginate);	
		  }while(Validations.IFELEMENTPRESENT(paginate));
		if(!Validations.IFELEMENTPRESENT(paginate))
			for(WebElement element : channelsList) {
				obtainedList.add(element.getText());
			}
		System.out.println("Obtained : "+obtainedList.size());
		
		ArrayList<String> sortedList = new ArrayList<>();
		for(String s : obtainedList)	{
			sortedList.add(s);
		}
		 Collections.sort(sortedList, String.CASE_INSENSITIVE_ORDER);
		 Collections.reverse(sortedList);
		System.out.println("Sorted : "+sortedList.size());
		return sortedList.equals(obtainedList);
		
	}
	
	public Map<Boolean,String> clickChannelOrderNo()	{
		
		return Elements.CLICK(driver, sortChannelOrderNo);
	
	}
	
	public boolean verifyObtainedAndSortedChannelOrderNo() throws Exception	{
		ArrayList<String> obtainedList = new ArrayList<>();
		
		do{
			for(WebElement element : channelOrderNoList) {
				if(element.getText().equalsIgnoreCase("N.A")) {
					obtainedList.add("#0");
				} else {
					obtainedList.add(element.getText());
				}
			}
			if(Validations.IFELEMENTPRESENT(paginate))
				Elements.CLICK(driver, paginate);	
		  }while(Validations.IFELEMENTPRESENT(paginate));
		if(!Validations.IFELEMENTPRESENT(paginate))
			for(WebElement element : channelOrderNoList) {
				if(element.getText().equalsIgnoreCase("N.A")) {
					obtainedList.add("#0");
				} else {
					obtainedList.add(element.getText());
				}
			}
		System.out.println("Obtained : "+obtainedList);
		
		ArrayList<String> sortedList = new ArrayList<>();
		for(String s : obtainedList)	{
			sortedList.add(s);
		}
		 Collections.sort(sortedList);
		System.out.println("Sorted : "+sortedList);
		return sortedList.equals(obtainedList);			
	}
	
	public boolean verifyObtainedAndSortedChannelOrderNoInDescOrder()	{
		ArrayList<String> obtainedList = new ArrayList<>();
		
		do{
			for(WebElement element : channelOrderNoList) {
				if(element.getText().equalsIgnoreCase("N.A")) {
					obtainedList.add("#0");
				} else {
					obtainedList.add(element.getText());
				}
			}
			if(Validations.IFELEMENTPRESENT(paginate))
				Elements.CLICK(driver, paginate);	
		  }while(Validations.IFELEMENTPRESENT(paginate));
		if(!Validations.IFELEMENTPRESENT(paginate))
			for(WebElement element : channelOrderNoList) {
				if(element.getText().equalsIgnoreCase("N.A")) {
					obtainedList.add("#0");
				} else {
					obtainedList.add(element.getText());
				}
			}
		System.out.println("Obtained : "+obtainedList);
		
		ArrayList<String> sortedList = new ArrayList<>();
		for(String s : obtainedList)	{
			sortedList.add(s);
		}
		 Collections.sort(sortedList);
		 Collections.reverse(sortedList);
		System.out.println("Sorted : "+sortedList);
		return sortedList.equals(obtainedList);	
	}
	
	public Map<Boolean,String> clickInvoices()	{
		
		return Elements.CLICK(driver, sortInvoices);
	
	}
	
	public boolean verifyObtainedAndSortedInvoices() throws ParseException {
		ArrayList<String> obtainedList = new ArrayList<>();
		
		do{
			for(WebElement element : invoicesList) {
				String textDate = element.getText().substring(element.getText().indexOf('\n'));
				String tDate = textDate.trim();
				SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
				Date parsedDate = sdf.parse(tDate);
				SimpleDateFormat print = new SimpleDateFormat("yyyy-MM-dd");
				String pd = print.format(parsedDate);
					obtainedList.add(pd);
			}
			if(Validations.IFELEMENTPRESENT(paginate))
				Elements.CLICK(driver, paginate);	
		  }while(Validations.IFELEMENTPRESENT(paginate));
			if(!Validations.IFELEMENTPRESENT(paginate)) {
				for(WebElement element : invoicesList) {
					String textDate = element.getText().substring(element.getText().indexOf('\n'));
					String tDate = textDate.trim();
					SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
					Date parsedDate = sdf.parse(tDate);
					SimpleDateFormat print = new SimpleDateFormat("yyyy-MM-dd");
					String pd = print.format(parsedDate);
						obtainedList.add(pd);
			}
			}
			System.out.println("Obtained : "+obtainedList);
			
			ArrayList<String> sortedList = new ArrayList<>();
			for(String s : obtainedList)	{
				sortedList.add(s);
			}
			Collections.sort(sortedList);
			System.out.println("Sorted : "+sortedList);
			return sortedList.equals(obtainedList);	
	}
	
	public boolean verifyObtainedAndSortedInvoicesInDescOrder() throws ParseException	{
		ArrayList<String> obtainedList = new ArrayList<>();
		
		do{
			for(WebElement element : invoicesList) {
				String textDate = element.getText().substring(element.getText().indexOf('\n'));
				String tDate = textDate.trim();
				SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
				Date parsedDate = sdf.parse(tDate);
				SimpleDateFormat print = new SimpleDateFormat("yyyy-MM-dd");
				String pd = print.format(parsedDate);
					obtainedList.add(pd);
			}
			if(Validations.IFELEMENTPRESENT(paginate))
				Elements.CLICK(driver, paginate);	
		  }while(Validations.IFELEMENTPRESENT(paginate));
			if(!Validations.IFELEMENTPRESENT(paginate)) {
				for(WebElement element : invoicesList) {
					String textDate = element.getText().substring(element.getText().indexOf('\n'));
					String tDate = textDate.trim();
					SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
					Date parsedDate = sdf.parse(tDate);
					SimpleDateFormat print = new SimpleDateFormat("yyyy-MM-dd");
					String pd = print.format(parsedDate);
						obtainedList.add(pd);
			}
			}
			System.out.println("Obtained : "+obtainedList);
			
			ArrayList<String> sortedList = new ArrayList<>();
			for(String s : obtainedList)	{
				sortedList.add(s);
			}
			Collections.sort(sortedList);
			Collections.reverse(sortedList);
			System.out.println("Sorted : "+sortedList);
			return sortedList.equals(obtainedList);
	}
	
	public Map<Boolean,String> clickBillers()	{
		
		return Elements.CLICK(driver, sortBillers);
	
	}	
	
	public boolean verifyObtainedAndSortedBillers()	{
		ArrayList<String> obtainedList = new ArrayList<>();
		
		do{
			for(WebElement element : billersList) {
				obtainedList.add(element.getText());
			}
			if(Validations.IFELEMENTPRESENT(paginate))
				Elements.CLICK(driver, paginate);	
		  }while(Validations.IFELEMENTPRESENT(paginate));
		if(!Validations.IFELEMENTPRESENT(paginate))
			for(WebElement element : billersList) {
				obtainedList.add(element.getText());
			}
		System.out.println("Obtained : "+obtainedList);
		
		ArrayList<String> sortedList = new ArrayList<>();
		for(String s : obtainedList)	{
			sortedList.add(s);
		}
		 Collections.sort(sortedList, String.CASE_INSENSITIVE_ORDER);
		System.out.println("Sorted : "+sortedList);
		return sortedList.equals(obtainedList);
	}
	
	public boolean verifyObtainedAndSortedBillersInDescOrder()	{
		ArrayList<String> obtainedList = new ArrayList<>();
		
		do{
			for(WebElement element : billersList) {
				obtainedList.add(element.getText());
			}
			if(Validations.IFELEMENTPRESENT(paginate))
				Elements.CLICK(driver, paginate);	
		  }while(Validations.IFELEMENTPRESENT(paginate));
		if(!Validations.IFELEMENTPRESENT(paginate))
			for(WebElement element : billersList) {
				obtainedList.add(element.getText());
			}
		System.out.println("Obtained : "+obtainedList);
		
		ArrayList<String> sortedList = new ArrayList<>();
		for(String s : obtainedList)	{
			sortedList.add(s);
		}
		 Collections.sort(sortedList, String.CASE_INSENSITIVE_ORDER);
		 Collections.reverse(sortedList);
		System.out.println("Sorted : "+sortedList);
		return sortedList.equals(obtainedList);	
	}
	
	public Map<Boolean,String> clickCustomers()	{
		
		return Elements.CLICK(driver, sortCustomers);
	
	}	
	
	public boolean verifyObtainedAndSortedCustomers()	{
		ArrayList<String> obtainedList = new ArrayList<>();
		
		do{
			for(WebElement element : customersList) {
				obtainedList.add(element.getText());
			}
			if(Validations.IFELEMENTPRESENT(paginate))
				Elements.CLICK(driver, paginate);	
		  }while(Validations.IFELEMENTPRESENT(paginate));
		if(!Validations.IFELEMENTPRESENT(paginate))
			for(WebElement element : customersList) {
				obtainedList.add(element.getText());
			}
		System.out.println("Obtained : "+obtainedList);
		
		ArrayList<String> sortedList = new ArrayList<>();
		for(String s : obtainedList)	{
			sortedList.add(s);
		}
		 Collections.sort(sortedList, String.CASE_INSENSITIVE_ORDER);
		System.out.println("Sorted : "+sortedList);
		return sortedList.equals(obtainedList);
	}
	
	public boolean verifyObtainedAndSortedCustomersInDescOrder()	{
		ArrayList<String> obtainedList = new ArrayList<>();
		
		do{
			for(WebElement element : customersList) {
				obtainedList.add(element.getText());
			}
			if(Validations.IFELEMENTPRESENT(paginate))
				Elements.CLICK(driver, paginate);	
		  }while(Validations.IFELEMENTPRESENT(paginate));
		if(!Validations.IFELEMENTPRESENT(paginate))
			for(WebElement element : customersList) {
				obtainedList.add(element.getText());
			}
		System.out.println("Obtained : "+obtainedList);
		
		ArrayList<String> sortedList = new ArrayList<>();
		for(String s : obtainedList)	{
			sortedList.add(s);
		}
		 Collections.sort(sortedList, String.CASE_INSENSITIVE_ORDER);
		 Collections.reverse(sortedList);
		System.out.println("Sorted : "+sortedList);
		return sortedList.equals(obtainedList);
	}
	
	public Map<Boolean,String> clickTotal()	{
		
		return Elements.CLICK(driver, sortTotalAmount);
	
	}
	
	public boolean verifyObtainedAndSortedTotalAmount()	{
		ArrayList<Double> obtainedList = new ArrayList<>();
		
		do{
			for(WebElement element : totalAmountList) {
				if(element.getText().contains("("))
					continue;
				String a = element.getText().substring(1).trim();
				if(a.contains(",")) {
					obtainedList.add(Double.parseDouble(a.replaceAll(",", "")));				
			} else {
				obtainedList.add(Double.parseDouble(a));
			}	
			}
			if(Validations.IFELEMENTPRESENT(paginate))
				Elements.CLICK(driver, paginate);	
		  }while(Validations.IFELEMENTPRESENT(paginate));
		if(!Validations.IFELEMENTPRESENT(paginate))
			for(WebElement element : totalAmountList) {
				if(element.getText().contains("("))
					continue;
				String a = element.getText().substring(1).trim();
				if(a.contains(",")) {
					obtainedList.add(Double.parseDouble(a.replaceAll(",", "")));				
			} else {
				obtainedList.add(Double.parseDouble(a));
			}
			}
		System.out.println("Obtained : "+obtainedList);
		
		ArrayList<Double> sortedList = new ArrayList<>();
		for(Double s : obtainedList)	{
			sortedList.add(s);
		}
		 Collections.sort(sortedList);
		System.out.println("Sorted : "+sortedList);
		return sortedList.equals(obtainedList);
	}
	
	public boolean verifyObtainedAndSortedTotalAmountInDescOrder()	{
		ArrayList<Double> obtainedList = new ArrayList<>();
		
		do{
			for(WebElement element : totalAmountList) {
				if(element.getText().contains("("))
					continue;
				String a = element.getText().substring(1).trim();
				if(a.contains(",")) {
					obtainedList.add(Double.parseDouble(a.replaceAll(",", "")));				
			} else {
				obtainedList.add(Double.parseDouble(a));
			}	
			}
			if(Validations.IFELEMENTPRESENT(paginate))
				Elements.CLICK(driver, paginate);	
		  }while(Validations.IFELEMENTPRESENT(paginate));
		if(!Validations.IFELEMENTPRESENT(paginate))
			for(WebElement element : totalAmountList) {
				if(element.getText().contains("("))
					continue;
				String a = element.getText().substring(1).trim();
				if(a.contains(",")) {
					obtainedList.add(Double.parseDouble(a.replaceAll(",", "")));				
			} else {
				obtainedList.add(Double.parseDouble(a));
			}
			}
		System.out.println("Obtained : "+obtainedList);
		
		ArrayList<Double> sortedList = new ArrayList<>();
		for(Double s : obtainedList)	{
			sortedList.add(s);
		}
		 Collections.sort(sortedList);
		 Collections.reverse(sortedList);
		System.out.println("Sorted : "+sortedList);
		return sortedList.equals(obtainedList);
	}
	
	public Map<Boolean,String> clickOutstanding()	{
		
		return Elements.CLICK(driver, sortOutstandingAmount);
	
	}
	
	public boolean verifyObtainedAndSortedOutstandingAmount()	{
		ArrayList<Double> obtainedList = new ArrayList<>();
		
		do{
			for(WebElement element : outstandingAmountList) {
				if(element.getText().contains("("))
					continue;
				String a = element.getText().substring(1).trim();
				if(a.contains(",")) {
					obtainedList.add(Double.parseDouble(a.replaceAll(",", "")));				
			} else {
				obtainedList.add(Double.parseDouble(a));
			}	
			}
			if(Validations.IFELEMENTPRESENT(paginate))
				Elements.CLICK(driver, paginate);	
		  }while(Validations.IFELEMENTPRESENT(paginate));
		if(!Validations.IFELEMENTPRESENT(paginate))
			for(WebElement element : outstandingAmountList) {
				if(element.getText().contains("("))
					continue;
				String a = element.getText().substring(1).trim();
				if(a.contains(",")) {
					obtainedList.add(Double.parseDouble(a.replaceAll(",", "")));				
			} else {
				obtainedList.add(Double.parseDouble(a));
			}
			}
		System.out.println("Obtained : "+obtainedList);
		
		ArrayList<Double> sortedList = new ArrayList<>();
		for(Double s : obtainedList)	{
			sortedList.add(s);
		}
		 Collections.sort(sortedList);
		System.out.println("Sorted : "+sortedList);
		return sortedList.equals(obtainedList);
	}
	
	public boolean verifyObtainedAndSortedOutstandingAmountInDescOrder()	{
		ArrayList<Double> obtainedList = new ArrayList<>();
		
		do{
			for(WebElement element : outstandingAmountList) {
				if(element.getText().contains("("))
					continue;
				String a = element.getText().substring(1).trim();
				if(a.contains(",")) {
					obtainedList.add(Double.parseDouble(a.replaceAll(",", "")));				
			} else {
				obtainedList.add(Double.parseDouble(a));
			}	
			}
			if(Validations.IFELEMENTPRESENT(paginate))
				Elements.CLICK(driver, paginate);	
		  }while(Validations.IFELEMENTPRESENT(paginate));
		if(!Validations.IFELEMENTPRESENT(paginate))
			for(WebElement element : outstandingAmountList) {
				if(element.getText().contains("("))
					continue;
				String a = element.getText().substring(1).trim();
				if(a.contains(",")) {
					obtainedList.add(Double.parseDouble(a.replaceAll(",", "")));				
			} else {
				obtainedList.add(Double.parseDouble(a));
			}
			}
		System.out.println("Obtained : "+obtainedList);
		
		ArrayList<Double> sortedList = new ArrayList<>();
		for(Double s : obtainedList)	{
			sortedList.add(s);
		}
		 Collections.sort(sortedList);
		 Collections.reverse(sortedList);
		System.out.println("Sorted : "+sortedList);
		return sortedList.equals(obtainedList);
	}
	
	public Map<Boolean,String> clickChannelDropdown()	{
		
		return Elements.CLICK(driver, clickChannelsDropDown);
		
	}
	
	public Map<Boolean,String> selectInvoiceSales()	{
		
		return Elements.CLICK(driver, selectInvoiceSales);
		
	}
	
	public boolean filteredChannelIsInvoiceSale()	{
		boolean result = false;
		do{
			for(WebElement element : displayedChannel){
				if(element.getText().equalsIgnoreCase("Invoice Sales"))	
					result = true;
				else 
					return false;
			}
			if(Validations.IFELEMENTPRESENT(paginate))	
				Elements.CLICK(driver, paginate);
		}while(Validations.IFELEMENTPRESENT(paginate));
		if(!Validations.IFELEMENTPRESENT(paginate))	{
			for(WebElement element : displayedChannel){
				if(element.getText().equalsIgnoreCase("Invoice Sales"))	
					result = true;
				else 
					return false;
			}
		}
		return result;
	}
	
	public Map<Boolean,String> selectPOS()	{
		
		return Elements.CLICK(driver, selectPOS);
		
	}
	
	public boolean filteredChannelIsPOS()	{
		boolean result = false;
		do{
			for(WebElement element : displayedChannel){
				if(element.getText().equalsIgnoreCase("POS"))	
					result = true;
				else 
					return false;
			}
			if(Validations.IFELEMENTPRESENT(paginate))	
				Elements.CLICK(driver, paginate);
		}while(Validations.IFELEMENTPRESENT(paginate));
		if(!Validations.IFELEMENTPRESENT(paginate))	{
			for(WebElement element : displayedChannel){
				if(element.getText().equalsIgnoreCase("POS"))	
					result = true;
				else 
					return false;
			}
		}
		return result;
	}
	
	public Map<Boolean,String> selectEcommerce()	{
		
		return Elements.CLICK(driver, selectEcommerce);
		
	}
	
	public boolean filteredChannelIsEcommerce()	{
		boolean result = false;
		do{
			for(WebElement element : displayedChannel){
				if(element.getText().equalsIgnoreCase("eCommerce"))	
					result = true;
				else 
					return false;
			}
			if(Validations.IFELEMENTPRESENT(paginate))	
				Elements.CLICK(driver, paginate);
		}while(Validations.IFELEMENTPRESENT(paginate));
		if(!Validations.IFELEMENTPRESENT(paginate))	{
			for(WebElement element : displayedChannel){
				if(element.getText().equalsIgnoreCase("eCommerce"))	
					result = true;
				else 
					return false;
			}
		}
		return result;
	}
	
	public Map<Boolean,String> selectWoocommerce()	{
		
		return Elements.CLICK(driver, selectWoocommerce);
		
	}
	
	public boolean filteredChannelIsWoocommerce()	{
		boolean result = false;
		do{
			for(WebElement element : displayedChannel){
				if(element.getText().equalsIgnoreCase("WooCommerce"))	
					result = true;
				else 
					return false;
			}
			if(Validations.IFELEMENTPRESENT(paginate))	
				Elements.CLICK(driver, paginate);
		}while(Validations.IFELEMENTPRESENT(paginate));
		if(!Validations.IFELEMENTPRESENT(paginate))	{
			for(WebElement element : displayedChannel){
				if(element.getText().equalsIgnoreCase("WooCommerce"))	
					result = true;
				else 
					return false;
			}
		}
		return result;
	}
	
	public Map<Boolean,String> selectOpencart()	{
		
		return Elements.CLICK(driver, selectOpencart);
		
	}
	
	public boolean filteredChannelIsOpencart()	{
		boolean result = false;
		do{
			for(WebElement element : displayedChannel){
				if(element.getText().equalsIgnoreCase("Opencart"))	
					result = true;
				else 
					return false;
			}
			if(Validations.IFELEMENTPRESENT(paginate))	
				Elements.CLICK(driver, paginate);
		}while(Validations.IFELEMENTPRESENT(paginate));
		if(!Validations.IFELEMENTPRESENT(paginate))	{
			for(WebElement element : displayedChannel){
				if(element.getText().equalsIgnoreCase("Opencart"))	
					result = true;
				else 
					return false;
			}
		}
		return result;
	}
	
	public Map<Boolean,String> selectShopify()	{
		
		return Elements.CLICK(driver, selectShopify);
		
	}
	
	public boolean filteredChannelIsShopify()	{
		boolean result = false;
		do{
			for(WebElement element : displayedChannel){
				if(element.getText().equalsIgnoreCase("Shopify"))	
					result = true;
				else 
					return false;
			}
			if(Validations.IFELEMENTPRESENT(paginate))	
				Elements.CLICK(driver, paginate);
		}while(Validations.IFELEMENTPRESENT(paginate));
		if(!Validations.IFELEMENTPRESENT(paginate))	{
			for(WebElement element : displayedChannel){
				if(element.getText().equalsIgnoreCase("Shopify"))	
					result = true;
				else 
					return false;
			}
		}
		return result;
	}
	
	public Map<Boolean,String> selectLazada()	{
		
		return Elements.CLICK(driver, selectLazada);
		
	}
	
	public boolean filteredChannelIsLazada()	{
		boolean result = false;
		do{
			for(WebElement element : displayedChannel){
				if(element.getText().equalsIgnoreCase("Lazada"))	
					result = true;
				else 
					return false;
			}
			if(Validations.IFELEMENTPRESENT(paginate))	
				Elements.CLICK(driver, paginate);
		}while(Validations.IFELEMENTPRESENT(paginate));
		if(!Validations.IFELEMENTPRESENT(paginate))	{
			for(WebElement element : displayedChannel){
				if(element.getText().equalsIgnoreCase("Lazada"))	
					result = true;
				else 
					return false;
			}
		}
		return result;
	}
	
	public Map<Boolean,String> selectShopee()	{
		
		return Elements.CLICK(driver, selectShopee);
		
	}
	
	public boolean filteredChannelIsShopee()	{
		boolean result = false;
		do{
			for(WebElement element : displayedChannel){
				if(element.getText().equalsIgnoreCase("Shopee"))	
					result = true;
				else 
					return false;
			}
			if(Validations.IFELEMENTPRESENT(paginate))	
				Elements.CLICK(driver, paginate);
		}while(Validations.IFELEMENTPRESENT(paginate));
		if(!Validations.IFELEMENTPRESENT(paginate))	{
			for(WebElement element : displayedChannel){
				if(element.getText().equalsIgnoreCase("Shopee"))	
					result = true;
				else 
					return false;
			}
		}
		return result;
	}
	
	public String getInputforChannelOrderNoSearch()	{
		String result = null;
		
		for(int i=0;i<getInputForChannelOrderNoSearch.size();i++)	{
			if(i==0) {
				WebElement element = getInputForChannelOrderNoSearch.get(i);
				result = element.getText();
				break;
			}
		}
		return result;
	}
	
	public Map<Boolean,String> searchChannelOrderNo()	{
		
		return Elements.ENTERVALUE(driver, searchChannelOrderNo, getInputforChannelOrderNoSearch());
		
	}
	
	public boolean searchResultForChannelOrderNo()	{
		
		if(searchResultForChannelOrderNo.getText().equalsIgnoreCase(getInputforChannelOrderNoSearch()))	
			return true;
		else
			return false;
		
	}
	
	public String getInputforInvoice()	{
		String result = null;
		
		for(int i=0;i<getInputForInvoice.size();i++)	{
			if(i==0) {
				WebElement element = getInputForInvoice.get(i);
				result = element.getText().substring(0, 14);
				break;
			}
		}
		return result;
	}
	
	public Map<Boolean,String> searchInvoice()	{
		
		return Elements.ENTERVALUE(driver, searchInvoice, getInputforInvoice());
		
	}
	
	public boolean searchResultForInvoice()	{
		if(searchResultForInvoice.getText().substring(0, 14).equalsIgnoreCase(getInputforInvoice()))	
			return true;
		else
			return false;	
	}
	
	public String getInputforBiller()	{
		String result = null;
		
		for(int i=0;i<getInputForBiller.size();i++)	{
			if(i==0) {
				WebElement element = getInputForBiller.get(i);
				result = element.getText();
				break;
			}
		}
		return result;
	}
	
	public Map<Boolean,String> searchBiller()	{
		
		return Elements.ENTERVALUE(driver, searchBiller, getInputforBiller());
		
	}
	
	public boolean searchResultForBiller()	{
		if(searchResultForBiller.getText().equalsIgnoreCase(getInputforBiller()))	
			return true;
		else
			return false;	
	}
	
	public String getInputforCustomer()	{
		String result = null;
		
		for(int i=0;i<getInputForCustomer.size();i++)	{
			if(i==0) {
				WebElement element = getInputForCustomer.get(i);
				result = element.getText();
				break;
			}
		}
		return result;
	}
	
	public Map<Boolean,String> searchCustomer()	{
		
		return Elements.ENTERVALUE(driver, searchCustomer, getInputforCustomer());
		
	}
	
	public boolean searchResultForCustomer()	{
		if(searchResultForCustomer.getText().equalsIgnoreCase(getInputforCustomer()))	
			return true;
		else
			return false;	
	}
	
	public String getInputforTotal()	{
		String result = null;
		
		for(int i=0;i<getInputForTotalAmount.size();i++)	{
			if(getInputForTotalAmount.get(i).getText().contains("("))
					continue;
			else {
				WebElement element = getInputForTotalAmount.get(i);
				result = element.getText();
				break;
			}
		}
		return result;
	}
	
	public Double totalAmount()	{

		return Double.parseDouble(getInputforTotal().substring(2));
		
	}
	
	public Map<Boolean,String> searchTotal()	{
		
		return Elements.ENTERVALUE(driver, searchTotalAmount, Double.toString(totalAmount()));
		
	}
	
	public boolean searchResultForTotalAmount()	{
		boolean result = false;
		
		for(int i=0;i<searchResultForTotalAmount.size();i++) {
			if(searchResultForTotalAmount.get(i).getText().contains("("))
				continue;
			else {
				searchResultForTotalAmount.get(i).getText().equalsIgnoreCase(Double.toString(totalAmount()));
				result = true;
			}
		}
		return result;	
	}
	
	public String getInputforOutstanding()	{
		String result = null;
		
		for(int i=0;i<getInputForOutstandingAmount.size();i++)	{
			if(getInputForOutstandingAmount.get(i).getText().contains("("))
					continue;
			else {
				WebElement element = getInputForOutstandingAmount.get(i);
				result = element.getText();
				break;
			}
		}
		return result;
	}
	
	public Double outstandingAmount()	{

		return Double.parseDouble(getInputforOutstanding().substring(2));
		
	}
	
	public Map<Boolean,String> searchOutstanding()	{
		
		return Elements.ENTERVALUE(driver, searchOutstandingAmount, Double.toString(outstandingAmount()));
		
	}
	
	public boolean searchResultForOutstandingAmount()	{
		boolean result = false;
		
		for(int i=0;i<searchResultForOutstandingAmount.size();i++) {
			if(searchResultForTotalAmount.get(i).getText().contains("("))
				continue;
			else {
				searchResultForOutstandingAmount.get(i).getText().equalsIgnoreCase(Double.toString(outstandingAmount()));
				result = true;
			}
		}
		return result;	
	}
	
	public Map<Boolean,String> clickMoreButton()	{
		
		return Elements.CLICK(driver, moreButton);
		
	}
	
	public Map<Boolean,String> clickBulkAddToDelivery()	{
		
		return Elements.CLICK(driver, bulkAddToDelivery);
		
	}
	
	public boolean chooseCheckBox()	{
	
		return Validations.ISSELECTED(bulkSelectInvoices);
		
	}
	
	public Map<Boolean,String> clickAddDeliveryButton()	{
		
		return Elements.CLICK(driver, addDeliveryButton);
		
	}
	
	public Map<Boolean,String> clickEditDelivery()	{
		Map<Boolean,String> editDel = null;
		
		for(int i=0;i<editDelivery.size();i++) {
			if(i==12) {
				WebElement element = editDelivery.get(i);
				editDel = Elements.CLICK(driver, element);
				break;
			}
		}
		return editDel;	
	}
	
	public void refreshPage()	{
		driver.navigate().refresh();
	}
	
	public Map<Boolean,String> clickSalesInSideMenu()	{
		
		return Elements.CLICK(driver, salesFromSideMenu);
		
	}
	
	
	
}
