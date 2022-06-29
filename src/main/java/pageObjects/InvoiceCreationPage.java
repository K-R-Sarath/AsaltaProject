package pageObjects;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Date;

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
	
	@FindBy(how = How.XPATH, using = "//div[@id='s2id_slcustomer']//a//span[@class='select2-chosen']")
	private WebElement clickCustomerField;
	
	@FindBy(how = How.XPATH, using = "//div[@id='select2-drop']//div[@class='select2-search']//input")
	private WebElement enterCustName;
	
	@FindBy(how = How.XPATH, using = "//ul[@class='select2-results']//li")
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
	
	@FindBy(how = How.ID, using="slpayment_term")
	private WebElement erasePaymentTermField;
	
	@FindBy(how = How.XPATH, using="//label[@for='slpayment_term']")
	private WebElement clickOutPaymentTermField;
	
	@FindBy(how = How.ID, using="couponAmount")
	private WebElement couponAppliedMsg;
	
	@FindBy(how = How.ID, using="slshipping")
	private WebElement shippingAmount;
	
	@FindBy(how = How.XPATH, using="//tr[@id='tfoot']//th[@class='text-right']")
	private List<WebElement> discAmount;
	
	@FindBy(how = How.ID, using="add-customer")
	private WebElement addcustomer;
	
	@FindBy(how = How.ID, using="name")
	private WebElement enterCustomerName;
	
	@FindBy(how = How.NAME, using="add_customer")
	private WebElement clickSaveCustomerButton;
	
	@FindBy(how = How.XPATH, using="//div[@class='toast-message']/p")
	private WebElement alertMsg6;
	
	@FindBy(how = How.XPATH, using="//button[@class='btn btn-default pull-right']")
	private WebElement addCustomFieldButton;
	
	@FindBy(how = How.NAME, using="customfields[label][]")
	private WebElement enterLabel;
	
	@FindBy(how = How.XPATH, using="//div[@class='select2-container customfields_type select1']//a")
	private List<WebElement> clickTypeField;
	
	@FindBy(how = How.XPATH, using="//div[@id='select2-drop']//div[@class='select2-search']//input")
	private WebElement enterTypE;
	
	@FindBy(how = How.XPATH, using="//div[@id='select2-drop']//ul//li")
	private WebElement selectType;
	
	@FindBy(how = How.XPATH, using="//div[@class='col-md-6']//div[@class='col-md-8']//label//div")
	private List<WebElement> isMandatoryForCustomFieldYES;
	
	@FindBy(how = How.XPATH, using="//*[@id='custom_table']/div/div[2]/div/div/div/input")
	private WebElement checkListValues;
	
	@FindBy(how = How.ID, using="formSaveCustom")
	private WebElement clickSaveForCustomField;
	
	@FindBy(how = How.XPATH, using="//div[@class='bootbox-body']")
	private WebElement alertMsg7;
	
	@FindBy(how = How.ID, using="addCustomField")
	private WebElement clickAddAnotherCustomFieldButton;
	
	@FindBy(how = How.ID, using="row_2")
	private WebElement verifyAnotherCustomField;
	
	@FindBy(how = How.XPATH, using="//button[@class='btn btn-xs qudel']")
	private WebElement deleteNewlyAddedCustomFieldOption;
	
	@FindBy(how = How.XPATH, using="//button[@class='close']")
	private List<WebElement> closeCustomFieldPopup;
	
	@FindBy(how = How.ID, using="chck")
	private WebElement closeAddNewCustomerPopup;
	
	@FindBy(how = How.XPATH, using="//a[@class='btn btn-sm btn-primary1 tip']")
	private List<WebElement> clickAddBillingAddressButton;
	
	@FindBy(how = How.ID, using="formSaveAddress")
	private WebElement clickSaveAddressButtonBilling;
	
	@FindBy(how = How.ID, using="formCancelAddress")
	private WebElement clickCancelButtonBilling;
	
	@FindBy(how = How.NAME, using="address")
	private WebElement enterAddressLine1inBillingAddressPopup;
	
	@FindBy(how = How.NAME, using="postal_code")
	private WebElement enterPostalCodeinBillingAddressPopup;
	
	@FindBy(how = How.XPATH, using="//div[@id='s2id_customer_billing_address']//a")
	private WebElement clickBillingAddressField;
	
	@FindBy(how = How.XPATH, using="//div[@id='select2-drop']//div//input")
	private WebElement enterBillingAddress;
	
	@FindBy(how = How.XPATH, using="//div[@id='select2-drop']//ul")
	private WebElement selectBillingAddress;
	
	@FindBy(how = How.ID, using="billAddress")
	private WebElement editBillingAddress;
	
	@FindBy(how = How.ID, using="formUpdateAddress")
	private WebElement clickUpdateBillingAddressButton;
	
	@FindBy(how = How.XPATH, using="//div[@id='s2id_customer_shipping_address']//a")
	private WebElement clickShippingAddressField;
	
	@FindBy(how = How.ID, using="shipAddress")
	private WebElement editShippingAddress;
	
	@FindBy(how = How.NAME, using="add_currency")
	private WebElement clickSaveCurrencyButton;
	
	@FindBy(how = How.XPATH, using="//div[@class='toast-message']//p[1]")
	private WebElement alertMsg8;
	
	@FindBy(how = How.XPATH, using="//div[@class='toast-message']//p[2]")
	private WebElement alertMsg9;
	
	@FindBy(how = How.XPATH, using="//div[@class='toast-message']//p[3]")
	private WebElement alertMsg10;
	
	@FindBy(how = How.XPATH, using="//div[@class='toast-message']//p[4]")
	private WebElement alertMsg11;
	
	@FindBy(how = How.XPATH, using="//div[@id='s2id_code']//a")
	private WebElement clickCurrencyCodeField;
	
	@FindBy(how = How.XPATH, using="//div[@id='select2-drop']//div[@class='select2-search']//input")
	private WebElement enterCurrencyCode;
	
	@FindBy(how = How.XPATH, using="//div[@id='select2-drop']//ul")
	private WebElement selectCurrencyCode;
	
	@FindBy(how = How.ID, using="rate")
	private WebElement exchangeRate;
	
	@FindBy(how = How.XPATH, using="//a//i[@class='fa fa-cog']")
	private WebElement clickSettings;
	
	@FindBy(how = How.XPATH, using="//div[@class='box-content']//div//div[5]//a")
	private WebElement clickCurrencies;
	
	@FindBy(how = How.XPATH, using="//button//i[@class='fa fa-2x']")
	private List<WebElement> closeCurrencyPopup;
	
	@FindBy(how = How.XPATH, using="//div[@id='myModal']//div//div//div//button[@class='close']//i[@class='fa fa-2x']")
	private WebElement verifyCurrencyPopupClosed;
	
	@FindBy(how = How.ID, using="reset")
	private WebElement clickResetButton;
	
	@FindBy(how = How.XPATH, using="//div[@class='modal-footer']//button[@data-bb-handler='confirm']")
	private WebElement clickOKinResetPopup;
	
	@FindBy(how = How.XPATH, using="//div[@class='modal-footer']//button[@data-bb-handler='cancel']")
	private WebElement clickCancelinResetPopup;
	
	@FindBy(how = How.XPATH, using="//div[@id='s2id_slcustomer']//a//span[@class='select2-chosen']")
	private WebElement verifyAfterReset;
	
	@FindBy(how = How.XPATH, using = "//div[@id='s2id_slcustomer']//a//span[@class='select2-chosen']")
	private WebElement scrollToCustField;
	
	@FindBy(how = How.XPATH, using="//div[@class='modal-body']//button//i")
	private WebElement resetPopupCloses;
	
	@FindBy(how = How.XPATH, using="//div[@id='s2id_slsale_status']//a//span[@class='select2-chosen']")
	private WebElement clickSaleStatusField;
	
	@FindBy(how = How.XPATH, using="//div[@id='select2-drop']//ul//li")
	private List<WebElement> saleStatus;
	
	@FindBy(how = How.XPATH, using="//ul[@class='breadcrumb']//li[2]//a")
	private WebElement invoiceSalesBreadcrumb;
	
	@FindBy(how = How.XPATH, using="//ul[@class='breadcrumb']//li[1]")
	private WebElement dashboardBreadcrumb;
	
	@FindBy(how = How.XPATH, using="//div[@id='s2id_sltax2']//a//span[@class='select2-chosen']")
	private WebElement clickGSTField;
	
	@FindBy(how = How.XPATH, using="//div[@id='select2-drop']//ul//li[1]")
	private WebElement selectGSTAt7PercentOption;
	
	@FindBy(how = How.XPATH, using="//span[@class='gtotal form-control']")
	private WebElement totalAmountForInvoice;
	
	@FindBy(how = How.XPATH, using="//div[@class='col-md-12']//span[@class='recurring_invoice']//label[2]//div")
	private WebElement recurringEnableDisableKey;
	
	@FindBy(how = How.XPATH, using="//label[@class='control-label']")
	private WebElement upcomingInvoiceDate;
	
	@FindBy(how = How.XPATH, using="//div[@id='s2id_repeat_every']//a//span[@class='select2-chosen']")
	private WebElement clickRepeatOptionField;
	
	@FindBy(how = How.XPATH, using="//div[@id='select2-drop']//ul//li[2]")
	private WebElement chooseYearForRepeatOption;
	
	@FindBy(how = How.XPATH, using="//div[@class='col-md-2']//div[2]")
	private WebElement chooseAfterInEndsOption;
	
	@FindBy(how = How.ID, using="repeat_times")
	private WebElement repeatTimes;
	
	@FindBy(how = How.ID, using="recurring_ends")
	private WebElement endOccurence;
	
	@FindBy(how = How.XPATH, using="//small[contains(text(),'Please enter a valid number')]")
	private List<WebElement> alertForRepeatTimesAndOccurence;
	
	@FindBy(how = How.XPATH, using="//i[@title='Edit']")
	private WebElement clickEditItemAfterAddingItem;
	
	@FindBy(how = How.ID, using="pquantity")
	private WebElement enterQuantityInEditOption;
	
	@FindBy(how = How.XPATH, using="//label[contains(text(),'Item GST')]")
	private List<WebElement> clickOutOfQuantityField;
	
	@FindBy(how = How.ID, using="pdiscount")
	private WebElement discountInItemEdit;
	
	@FindBy(how = How.ID, using="editItem")
	private WebElement clickSubmitButton;
	
	@FindBy(how = How.ID, using="net_price")
	private WebElement netUnitPrice;
	
	@FindBy(how = How.XPATH, using="//button[@class='close']//span//i")
	private List<WebElement> closeItemEditPopup;
	
	@FindBy(how = How.XPATH, using="//div[@id='s2id_slwarehouse']//a//span[@class='select2-chosen']")
	private WebElement clickLocation;
	
	@FindBy(how = How.XPATH, using="//div[@id='select2-drop']//ul//li[2]")
	private WebElement chooseLocation;
	
	@FindBy(how = How.ID, using="select_consolidated_orders")
	private WebElement clickConsolidatedOrdersButton;
	
	@FindBy(how = How.ID, using="select_orders")
	private WebElement clickSelectOrdersButton;
	
	@FindBy(how = How.XPATH, using="//table[@id='CompTable']//tbody//tr[2]//td//div")
	private WebElement chooseOrder;
	
	@FindBy(how = How.XPATH, using="//table[@id='slTable']//tbody[1]//tr")
	private List<WebElement> orderTableItems;
	
	@FindBy(how = How.XPATH, using="//div[@class='row']//div[@class='col-sm-12 text-center']//button[1]")
	private WebElement cancelButtonInConsolidatedOrderPopup;
	
	@FindBy(how = How.XPATH, using="//div[@id='myModal']//button[@class='close']")
	private WebElement closeConsolidatedOrderPopup;
	
	@FindBy(how = How.ID, using="addManually")
	private WebElement newItemButton;
	
	@FindBy(how = How.ID, using="addItemManually")
	private WebElement clickSubmitForNewItem;
	
	@FindBy(how = How.ID, using="mcode")
	private WebElement enterSKU;
	
	@FindBy(how = How.ID, using="mname")
	private WebElement enterItemName;
	
	@FindBy(how = How.XPATH, using="//div[@id='mModal']//button[@class='close']")
	private WebElement closeItemAddPopup;
	
	@FindBy(how = How.ID, using="mquantity")
	private WebElement quantityInNewItemPopup;
	
	@FindBy(how = How.XPATH, using="//label[@for='mcode']")
	private WebElement clickOutQtyField;
	
	@FindBy(how = How.ID, using="mdiscount")
	private WebElement discInNewItemPopup;
	
	@FindBy(how = How.ID, using="mprice")
	private WebElement unitPriceInNewItemPopup;
	
	@FindBy(how = How.XPATH, using="//table[@id='slTable']//tbody//tr//td[7]//span")
	private WebElement getDiscAmount;
	
	public Map<Boolean,String> clickCustomerField() {
		
		return Elements.CLICK(driver, clickCustomerField);
		
	}
	
	public Map<Boolean,String> enterCustomerName() {
		
		return Elements.ENTERVALUE(driver, enterCustName, "Sar");
		
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
		
		return Elements.ENTERVALUE(driver, clickItemNameFieldAndEnterItem, "men silver");
		
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
		
		return Elements.UPLOADFILE(driver, attachDocument, "F:\\document_attach.docx");
		
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
	
	public Map<Boolean,String> erasePaymentTermField()	{
		return Elements.ERASEVALUE(driver, erasePaymentTermField);
	}
	
	public Map<Boolean,String> clickOutPaymentTermField()	{
		return Elements.CLICK(driver, clickOutPaymentTermField);
	}
	
	public String couponMsg()	{
		String couponMessage = couponAppliedMsg.getText();
		couponMessage.split(" for $ 70.00");
		return couponMessage;
	}
	
	public Map<Boolean,String> enterShippingAmount(String ship)	{
		return Elements.ENTERVALUE(driver, shippingAmount, ship);
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
	
	public double amount()	{
		double amount;
		long add = 0; 
		String amt = getAmount().get(true);
		StringBuilder builder = new StringBuilder();
		if(amt.contains(","))
		{
		String[] retval = amt.split(",");
	    for(String a:retval) {
	    	builder.append(a);
	    }
	    	add = Long.parseLong(builder.toString());
		}else{
			builder.append(amt);
			add = Long.parseLong(builder.toString());
		}
	    System.out.println(add);
	    amount = (double)add / 100;
	    System.out.println(amount);
		return amount;
	}
	
	public Map<Boolean,String> enterDiscountAmount()	{
		
		return Elements.ENTERVALUE(driver, discount, Double.toString(amount()));
		
	}
	
	public Map<Boolean,String> clickAddCustomerButton()	{
		
		return Elements.CLICK(driver, addcustomer);
		
	}
	
	public Map<Boolean,String> enterCustName(String customer)	{
		
		return Elements.ENTERVALUE(driver, enterCustomerName, customer);
		
	}
	
	public Map<Boolean,String> clickSaveCustomerButton()	{
		
		return Elements.CLICK(driver, clickSaveCustomerButton);
		
	}
	
	public String alert6()	{
		String alert = alertMsg6.getText();
		return alert;
	}
	
	public void scroll3() {
		
		Scrolling.SCROLLINTOVIEW(driver, addCustomFieldButton);
	
	}
	
	public Map<Boolean, String> clickAddNewCustomFieldButton()	{
		
		return Elements.CLICK(driver, addCustomFieldButton);
		
	}
	
	public Map<Boolean,String> enterLabel(String label)	{
		
		return Elements.ENTERVALUE(driver, enterLabel, label);
		
	}
	
	public Map<Boolean,String> clickType()	{
		Map<Boolean,String> clickTypefield = null;
		
		for(int i=0;i<clickTypeField.size();i++){
			if(i==0){
				WebElement element = clickTypeField.get(i);
				clickTypefield = Elements.CLICK(driver, element);
				break;
			}
		}
		return clickTypefield;
	}
	
	public Map<Boolean,String> enterType(String type)	{
		
		return Elements.ENTERVALUE(driver, enterTypE, type);
		
	}
	
	public Map<Boolean,String> typeSelect()	{
		
		return Elements.CLICK(driver, selectType);
		
	}
	
	public Map<Boolean,String> clickYes()	{
		Map<Boolean,String> YES = null;
		
		for(int i=0;i<isMandatoryForCustomFieldYES.size();i++){
			if(i==0)	{
				WebElement element = isMandatoryForCustomFieldYES.get(i);
				YES = Elements.CLICK(driver, element);
				break;
			}
		}
		return YES;	
	}
	
	
	public Map<Boolean,String> clickSaveCustom()	{
		
		return Elements.CLICK(driver, clickSaveForCustomField);
		
	}
	
	public Map<Boolean,String> enterChecklistValues()	{
		
		return Elements.ENTERVALUE(driver, checkListValues, "One"); 
		
	}
	
	public Map<Boolean,String> clickNo()	{
		Map<Boolean,String> NO = null;
		
		for(int i=0;i<isMandatoryForCustomFieldYES.size();i++){
			if(i==1)	{
				WebElement element = isMandatoryForCustomFieldYES.get(i);
				NO = Elements.CLICK(driver, element);
				break;
			}
		}
		return NO;	
	}
	
	public String alert7()	{
		String alert7 = alertMsg7.getText();
		return alert7;
	}
	
	public Map<Boolean,String> clickAnotherCustomField()	{
		
		return Elements.CLICK(driver, clickAddAnotherCustomFieldButton);
		
	}
	
	public boolean verifyAnotherCustomField()	{
		
		return Validations.IFELEMENTENABLED(verifyAnotherCustomField);
		
	}
	
	public Map<Boolean,String> deleteNewlyAddedCustomField()	{
		
		return Elements.CLICK(driver, deleteNewlyAddedCustomFieldOption);
		
	}
	
	public Map<Boolean,String> closeCustomfieldPopup() throws Exception	{
		Map<Boolean,String> closeCustom = null;
		
		for(int i=closeCustomFieldPopup.size()-1;i>=0;i--)	{
			if(i==6){
				WebElement element = closeCustomFieldPopup.get(i);
				closeCustom = Elements.CLICK(driver, element);
				break;
			}
		}
		return closeCustom;
	}
	
	public Map<Boolean,String> closeCustomerPopup()	{
		
		return Elements.CLICK(driver, closeAddNewCustomerPopup);
		
	}
	
	public Map<Boolean,String> clickAddBillingAddress()	{
		Map<Boolean,String> addAddress = null;
		
		for(int i=0;i<clickAddBillingAddressButton.size();i++)	{
			if(i==0){
				WebElement element = clickAddBillingAddressButton.get(i);
				addAddress = Elements.CLICK(driver, element);
				break;
			}
		}
		return addAddress;
	}
	
	public Map<Boolean,String> clickSaveBillingAddress()	{
		
		return Elements.CLICK(driver, clickSaveAddressButtonBilling);
		
	}
	
	public Map<Boolean,String> CancelBilling()	{
		
		return Elements.CLICK(driver, clickCancelButtonBilling);
		
	}
	
	public boolean verifyBillingAddressPopupClosed()	{
		
		return Validations.IFELEMENTPRESENT(clickCancelButtonBilling);
		
	}
	
	public boolean verifyCustomerAndCustomFieldPopupClosed()	{
		
		return Validations.IFELEMENTPRESENT(clickSaveCustomerButton);
		
	}
	
	public Map<Boolean,String> closeBillingAddressPopup()	{
		
		return Elements.CLICK(driver, closeAddNewCustomerPopup);
		
	}
	
	public Map<Boolean,String> enterAddress1inBillingAddress()	{
		
		return Elements.ENTERVALUE(driver, enterAddressLine1inBillingAddressPopup, "Plot 33, Meadows Street");
		
	}
	
	public Map<Boolean,String> enterPostalCodeinBillingAddress()	{
		
		return Elements.ENTERVALUE(driver, enterPostalCodeinBillingAddressPopup, "654321");
		
	}
	
	public Map<Boolean,String> clickBillingAddress()	{
		
		return Elements.CLICK(driver, clickBillingAddressField);
		
	}
	
	public Map<Boolean,String> enterBillAddress()	{
		
		return Elements.ENTERVALUE(driver, enterBillingAddress, "Plo");
		
	}
	
	public Map<Boolean,String> selectBillAddress()	{
		
		return Elements.CLICK(driver, selectBillingAddress);
		
	}
	
	public Map<Boolean,String> clickEditBillAddress()	{
		
		return Elements.CLICK(driver, editBillingAddress);
		
	}
	
	public Map<Boolean,String> erasePostalCode()	{
		
		return Elements.ERASEVALUE(driver, enterPostalCodeinBillingAddressPopup);
		
	}
	
	public Map<Boolean,String> updatePostalCode()	{
		
		return Elements.ENTERVALUE(driver, enterPostalCodeinBillingAddressPopup, "658972");
		
	}
	
	public Map<Boolean,String> clickUpdateBillAddressButton()	{
		
		return Elements.CLICK(driver, clickUpdateBillingAddressButton);
		
	}
	
	public Map<Boolean,String> clickAddShippingAddress()	{
		Map<Boolean,String> addAddress = null;
		
		for(int i=0;i<clickAddBillingAddressButton.size();i++)	{
			if(i==1){
				WebElement element = clickAddBillingAddressButton.get(i);
				addAddress = Elements.CLICK(driver, element);
				break;
			}
		}
		return addAddress;
	}
	
	public Map<Boolean,String> clickShippingAddress()	{
		
		return Elements.CLICK(driver, clickShippingAddressField);
		
	}
	
	public Map<Boolean,String> enterShipAddress()	{
		
		return Elements.ENTERVALUE(driver, enterBillingAddress, "Plo");
		
	}
	
	public Map<Boolean,String> selectShipAddress()	{
		
		return Elements.CLICK(driver, selectBillingAddress);
		
	}
	
	public Map<Boolean,String> clickEditShipAddress()	{
		
		return Elements.CLICK(driver, editShippingAddress);
		
	}
	
	public Map<Boolean,String> clickAddCurrencyButton()	{
		Map<Boolean,String> addCurrency = null;
		
		for(int i=0;i<clickAddBillingAddressButton.size();i++)	{
			if(i==2){
				WebElement element = clickAddBillingAddressButton.get(i);
				addCurrency = Elements.CLICK(driver, element);
				break;
			}
		}
		return addCurrency;
	}
	
	public Map<Boolean,String> clickSaveCurrency()	{
		
		return Elements.CLICK(driver, clickSaveCurrencyButton);
		
	}
	
	public String alertMessage1()	{
		String alertMess1 = alertMsg8.getText();
		return alertMess1;
	}
	
	public String alertMessage2()	{
		String alertMess2 = alertMsg9.getText();
		return alertMess2;
	}
	
	public String alertMessage3()	{
		String alertMess3 = alertMsg10.getText();
		return alertMess3;
	}
	
	public String alertMessage4()	{
		String alertMess4 = alertMsg11.getText();
		return alertMess4;
	}
	
	public Map<Boolean,String> clickCurrencyCode()	{
		
		return Elements.CLICK(driver, clickCurrencyCodeField);
		
	}
	
	public Map<Boolean,String> enterCurrencyCode()	{
		
		return Elements.ENTERVALUE(driver, enterCurrencyCode, "Aus");
		
	}
	
	public Map<Boolean,String> selectCurrencyCode()	{
		
		return Elements.CLICK(driver, selectCurrencyCode);
		
	}
	
	public Map<Boolean,String> eraseRate()	{
		
		return Elements.ERASEVALUE(driver, exchangeRate);
		
	}
	
	public Map<Boolean,String> enterExchangeRate()	{
		
		return Elements.ENTERVALUE(driver, exchangeRate, "5.00");
		
	}
	
	
	public Map<Boolean,String> clickSettingsFromSideMenu()	{
		
		return Elements.CLICK(driver, clickSettings);
		
	}
	
	public Map<Boolean,String> clickCurrencies()	{
		
		return Elements.CLICK(driver, clickCurrencies);
		
	}
	
	public Map<Boolean,String> clickCurrencyPopupClose()	{
		Map<Boolean,String> closePopup = null;
		
		for(int i=0;i<closeCurrencyPopup.size();i++)	{
			if(i==4){
				WebElement element = closeCurrencyPopup.get(i);
				closePopup = Elements.CLICK(driver, element);
				break;
			}
		}
		return closePopup;
	}
	
	public boolean verifyCurrencyPopupClosed()	{
		
		return Validations.IFELEMENTPRESENT(verifyCurrencyPopupClosed);
		
	}
	
	public Map<Boolean,String> clicksResetButton()	{
		
		return Elements.CLICK(driver, clickResetButton);
		
	}
	
	public Map<Boolean,String> clickOKinReset()	{
		
		return Elements.CLICK(driver, clickOKinResetPopup);
		
	}
	
	public String afterReset()	{
		String value = verifyAfterReset.getText();
		return value;
	}
	
	public void scroll4()	{
		Scrolling.SCROLLINTOVIEW(driver, scrollToCustField);
	}
	
	public Map<Boolean,String> clickCancelinReset()	{
		
		return Elements.CLICK(driver, clickCancelinResetPopup);
		
	}
	
	public boolean verifyResetPopupDisappears()	{
		
		return Validations.IFELEMENTPRESENT(clickCancelinResetPopup);
		
	}
	
	public Map<Boolean,String> resetPopupClose()	{
		
		return Elements.CLICK(driver, resetPopupCloses);
		
	}
	
	public boolean verifyResetPopupCloses()	{
		
		return Validations.IFELEMENTPRESENT(resetPopupCloses);
		
	}
	
	public Map<Boolean,String> clickSaleStatus()	{
		
		return Elements.CLICK(driver, clickSaleStatusField);
		
	}
	
	public Map<Boolean,String> selectSaleStatusCompleted()	{
		Map<Boolean,String> status = null;
		
		for(int i=0;i<saleStatus.size();i++)	{
			if(i==0){
				WebElement element = saleStatus.get(i);
				status = Elements.CLICK(driver, element);
				break;
			}
		}
		return status;
	}
	
	public Map<Boolean,String> selectSaleStatusProcessing()	{
		Map<Boolean,String> status = null;
		
		for(int i=0;i<saleStatus.size();i++)	{
			if(i==1){
				WebElement element = saleStatus.get(i);
				status = Elements.CLICK(driver, element);
				break;
			}
		}
		return status;
	}
	
	public Map<Boolean,String> selectSaleStatusPending()	{
		Map<Boolean,String> status = null;
		
		for(int i=0;i<saleStatus.size();i++)	{
			if(i==2){
				WebElement element = saleStatus.get(i);
				status = Elements.CLICK(driver, element);
				break;
			}
		}
		return status;
	}
	
	public Map<Boolean,String> selectSaleStatusCancelled()	{
		Map<Boolean,String> status = null;
		
		for(int i=0;i<saleStatus.size();i++)	{
			if(i==3){
				WebElement element = saleStatus.get(i);
				status = Elements.CLICK(driver, element);
				break;
			}
		}
		return status;
	}
	
	public Map<Boolean,String> clickInvoiceSalesBreadcrumb()	{
		
		return Elements.CLICK(driver, invoiceSalesBreadcrumb);
		
	}
	
	public Map<Boolean,String> clickDashboardBreadcrumb()	{
		
		return Elements.CLICK(driver, dashboardBreadcrumb);
		
	}
	
	public Map<Boolean,String> clickGSTField()	{
		
		return Elements.CLICK(driver, clickGSTField);
		
	}
		
	public Map<Boolean,String> selectGSToption()	{
		
		return Elements.CLICK(driver, selectGSTAt7PercentOption);
		
	}
	
	public double amountFor7PercentGST()	{
		String amount = null;
		String afterTrim = null;
		double d;
		StringBuilder builder = new StringBuilder();
		
		for(int i=0;i<discAmount.size();i++) {
			if(i==2) {
				WebElement element = discAmount.get(i);
				amount = element.getText();
				break;
			}
		}
		afterTrim = amount.substring(2);
		if(afterTrim.contains(","))
		{
		String[] retval = afterTrim.split(",");
	    for(String a:retval) {
	    	builder.append(a);
	    }
	    	d = Double.parseDouble(builder.toString());
		}else{
			builder.append(afterTrim);
			d = Double.parseDouble(builder.toString());
		}
		double e = (d/100)*7;
		return d+e;
	}
	 
	public double totalAmt()	{
		
		String s = totalAmountForInvoice.getText();
		String trim = s.substring(2);
		double d;
		StringBuilder builder = new StringBuilder();
		if(trim.contains(",")) 
			{
				String[] retval = trim.split(",");
				for(String a:retval) {
					builder.append(a);
				}
				d = Double.parseDouble(builder.toString());
			} else {
				builder.append(trim);
				d = Double.parseDouble(builder.toString());
			}
		return d;	
	}
	
	public void scroll7()	{
		
		Scrolling.SCROLLINTOVIEW(driver, recurringEnableDisableKey);
		
	}
	
	public Map<Boolean,String> clickRecurringEnableDisableButton()	{
		
		return Elements.CLICK(driver, recurringEnableDisableKey);
		
	}
	
	public String upcomingInvDate()	{
		String upcomingDate = upcomingInvoiceDate.getText();
		String trim = upcomingDate.substring(25);
		return trim;	
	}
	
	public String getNewDate()	{
		LocalDate futureDate = LocalDate.now().plusMonths(1);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/YYYY");
		String newDate = formatter.format(futureDate);
		System.out.println(newDate);
		return newDate;	
	}
	
	public Map<Boolean,String> clickRepeatField()	{
		
		return Elements.CLICK(driver, clickRepeatOptionField);
		
	}
	
	public Map<Boolean,String> chooseYearInRepeatOption()	{
		
		return Elements.CLICK(driver, chooseYearForRepeatOption);
		
	}
	
	public String getNewDateForYearOption()	{
		LocalDate futureDate = LocalDate.now().plusYears(1);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/YYYY");
		String newDate = formatter.format(futureDate);
		return newDate;
		
		
	}
	
	public String upcomingEndDate()	{
		String upcomingDate = upcomingInvoiceDate.getText();
		String trim = upcomingDate.substring(48);
		System.out.println(trim);
		return trim;	
	}
	
	public Map<Boolean,String> chooseAfterInEndsOption()	{
		
		return Elements.CLICK(driver, chooseAfterInEndsOption);
		
	}
	
	public Map<Boolean,String> enterRepeatTimes()	{
		
		return Elements.ENTERVALUE1(driver, repeatTimes, ".5");
		
	}
	
	public Map<Boolean,String> enterOccurence()	{
		
		return Elements.ENTERVALUE1(driver, endOccurence, ".5");
		
	}
	
	public String alertForRepeatTimes()	{
		String repeat = null;
		
		for(int i=0;i<alertForRepeatTimesAndOccurence.size();i++)	{
			if(i==1){
				WebElement element = alertForRepeatTimesAndOccurence.get(i);
				repeat = element.getText();
				break;
			}
		}
		return repeat;	
	}
	
	public String alertForOccurence()	{
		String repeat = null;
		
		for(int i=0;i<alertForRepeatTimesAndOccurence.size();i++)	{
			if(i==2){
				WebElement element = alertForRepeatTimesAndOccurence.get(i);
				repeat = element.getText();
				break;
			}
		}
		return repeat;	
	}
	
	public Map<Boolean,String> clickEditAfterAddingItem()	{
		
		return Elements.CLICK(driver, clickEditItemAfterAddingItem);
		
	}
	
	public Map<Boolean,String> editQuantityInEditItem(String quantity)	{
		
		return Elements.ENTERVALUE(driver, enterQuantityInEditOption, quantity);
		
	}
	
	public Map<Boolean,String> clickOutOfQuantityField()	{
		Map<Boolean,String> qty = null;
		
		for(int i=0;i<clickOutOfQuantityField.size();i++)	{
			if(i==3) {
				WebElement element = clickOutOfQuantityField.get(i);
				qty = Elements.CLICK(driver, element);
				break;
			}
		}
		return qty;
	}
	
	public Map<Boolean,String> enterDiscountInItemEdit(String disc)	{
		
		return Elements.ENTERVALUE(driver, discountInItemEdit, disc);	
		
	}
	
	public Map<Boolean,String> clickSubmit() {
		
		return Elements.CLICK(driver, clickSubmitButton);
		
	}
	
	public Map<Boolean,String> getAmountinItemEdit()	{
		
		String globalAmt = null;
		String dscAmt = null;
		Map<Boolean,String> discounts = new HashMap<>();
		
		dscAmt = netUnitPrice.getText();
		
		globalAmt = dscAmt.substring(2, dscAmt.indexOf('.'));
		discounts.put(true, globalAmt);
		return discounts;
		
	}
	
	public Long amountinItemEdit()	{
		long amount;
		long add = 0; 
		String amt = getAmountinItemEdit().get(true);
		StringBuilder builder = new StringBuilder();
		if(amt.contains(","))
		{
		String[] retval = amt.split(",");
	    for(String a:retval) {
	    	builder.append(a);
	    }
	    	add = Long.parseLong(builder.toString());
		}else{
			builder.append(amt);
			add = Long.parseLong(builder.toString());
		}
	    
	    amount = add + 1;
		return amount;
	}
	
	public Map<Boolean,String> enterDiscountinEdit()	{
		
		return Elements.ENTERVALUE(driver, discountInItemEdit, Long.toString(amountinItemEdit()));
		
	}
	
	public Map<Boolean,String> closeItemEditPopup()	{
		Map<Boolean,String> closePopup = null;
		
		for(int i=0;i<closeItemEditPopup.size();i++) {
			if(i==1) {
				WebElement element = closeItemEditPopup.get(i);
				closePopup = Elements.CLICK(driver, element);
				break;
			}
		}
		return closePopup;
	}
	
	public boolean VerifyThePopupClose()	{
		boolean verify = true;
		
		for(int i=0;i<closeItemEditPopup.size();i++) {
			if(i==1) {
				WebElement element = closeItemEditPopup.get(i);
				verify = Validations.IFELEMENTPRESENT(element);
				break;
			}
		}
		return verify;
	}
	
	public Map<Boolean,String> clickLocation()	{
		
		return Elements.CLICK(driver, clickLocation);
		
	}
	
	public Map<Boolean,String> chooseLocation()	{
		
		return Elements.CLICK(driver, chooseLocation);
		
	}
	
	public Map<Boolean,String> clickConsolidatedOrdersButton()	{
		
		return Elements.CLICK(driver, clickConsolidatedOrdersButton);
		
	}
	
	public Map<Boolean,String> clickSelectOrdersButton()	{
		
		return Elements.CLICK(driver, clickSelectOrdersButton);
		
	}
	
	public Map<Boolean,String> chooseConsolidatedOrder()	{
		
		return Elements.CLICK(driver, chooseOrder);
		
	}
	
	public boolean verifyOrderTable()	{
		boolean orderItemTable;
		
		if(orderTableItems.size() != 0) {
			orderItemTable = true;
		} else {
			orderItemTable = false;
		}
		return orderItemTable;
	}
	
	public Map<Boolean,String> clickCancelButton()	{
		
		return Elements.CLICK(driver, cancelButtonInConsolidatedOrderPopup);
		
	}
	
	public boolean verifyConsolidatedOrderPopupClosed()	{
		
		return Validations.IFELEMENTPRESENT(cancelButtonInConsolidatedOrderPopup);
		
	}
	
	public Map<Boolean,String> closeConsolidatedOrderPopup()	{
		
		return Elements.CLICK(driver, closeConsolidatedOrderPopup);
		
	}
	
	public void scroll8()	{
		
		Scrolling.SCROLLINTOVIEW(driver, newItemButton);
		
	}
	
	public Map<Boolean,String> clickNewItemButton()	{
		
		return Elements.CLICK(driver, newItemButton);
		
	}
	
	public Map<Boolean,String> clickSubmitButtonForNewItem()	{
		
		return Elements.CLICK(driver, clickSubmitForNewItem);
		
	}
	
	public String GenerateRandomSKU(int n)	{
		
		String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                					+ "0123456789"
                					+ "abcdefghijklmnopqrstuvxyz";

		StringBuilder sb = new StringBuilder(n);

		for (int i = 0; i < n; i++) {
			int index = (int)(AlphaNumericString.length()* Math.random());
			sb.append(AlphaNumericString.charAt(index));
			}

		return sb.toString();
		
	}
	
	public Map<Boolean,String> enterSKU()	{
		
		return Elements.ENTERVALUE(driver, enterSKU, GenerateRandomSKU(10));
		
	}
	
	public Map<Boolean,String> enterItemName()	{
		
		return Elements.ENTERVALUE(driver, enterItemName, "TestItem 001");
		
	}
	
	public Map<Boolean,String> closeAddItemPopup()	{
		
		return Elements.CLICK(driver, closeItemAddPopup);
		
	}
	
	public Map<Boolean,String> enterQty(String qty)  {
		
		return Elements.ENTERVALUE(driver, quantityInNewItemPopup, qty);
		
	}
	
	public Map<Boolean,String> clickOutQtyField()	{
		
		return Elements.CLICK(driver, clickOutQtyField);
		
	}
	
	public Map<Boolean,String> enterDiscInNewItemPopup(String discount)	{
		
		return Elements.ENTERVALUE(driver, discInNewItemPopup, discount);
		
	}
	
	public Map<Boolean,String> enterUnitPriceInNewItemPopup()	{
		
		return Elements.ENTERVALUE(driver, unitPriceInNewItemPopup, "50");
		
	}
	
	public String verifyDiscAmountForNewItem()	{
		
		return getDiscAmount.getText().substring(2);
	}
	
	
}
