package pageObjects;

import java.util.HashMap;
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
	
	@FindBy(how = How.XPATH, using = "//span[@id='select2-chosen-16']")
	private WebElement clickCustomerField;
	
	@FindBy(how = How.XPATH, using = "//div[@id='select2-drop']//div[@class='select2-search']//input")
	private WebElement enterCustName;
	
	@FindBy(how = How.XPATH, using = "//ul[@id='select2-results-16']//li")
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
		
		return Elements.ENTERVALUE(driver, clickItemNameFieldAndEnterItem, "202");
		
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
		couponMessage.split(" for $ 5,000.00");
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
	
	
}
