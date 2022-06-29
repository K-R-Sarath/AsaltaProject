package pageObjects;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import commonMethods.Elements;
import commonMethods.Validations;

public class SaleOrderListPage {
	
	private WebDriver driver;
	
	public SaleOrderListPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	@FindBy(how = How.XPATH, using="//div[@class='col-md-12 text-right']//a")
	private WebElement newOrderButton;
	
	@FindBy(how = How.XPATH, using="//ul[@class='dropdown-menu pull-right']//li//a")
	private List<WebElement> actionDropdown;
	
	@FindBy(how = How.XPATH, using="//div[@class='btn-group']//a//span[contains(text(),'Attachment')]")
	private WebElement verifyAttachment;
	
	@FindBy(how = How.XPATH, using="//a[@class='btn btn-danger po-delete']")
	private WebElement clickYes;
	
	@FindBy(how = How.XPATH, using="//div[@class='toast-message']")
	private WebElement toast;
	
	@FindBy(how = How.XPATH, using="//table[@id='SORData']//tbody//tr[1]//td//i")
	private List<WebElement> verifyTickMark;
	
	@FindBy(how = How.ID, using = "sales_index")
	private WebElement clickInvoice;
	
	@FindBy(how = How.XPATH, using="//div[@class='col-md-12 text-left']//a[contains(text(),'All')]")
	private WebElement clickAllInTopList;
	
	@FindBy(how = How.ID, using="mm_deliveries")
	private WebElement clickDeliveries;
	
	@FindBy(how = How.ID, using="delete")
	private WebElement bulkDeleteSO;
	
	@FindBy(how = How.XPATH, using="//button[contains(text(),' More ')]")
	private WebElement moreButton;
	
	@FindBy(how = How.ID, using="delete_data")
	private WebElement deleteSOinBulk;
	
	@FindBy(how = How.XPATH, using="//table[@id='SORData']//tbody//tr//td//center//div")
	private List<WebElement> selectSO;
	
	@FindBy(how = How.XPATH, using="//a[@class='bpo btn btn-default deletetodata']")
	private WebElement deleteButton;
	
	@FindBy(how = How.ID, using="bulk_add_delivery")
	private WebElement bulkAddDelivery;
	
	@FindBy(how = How.ID, using="add_delivery")
	private WebElement convertToDO;
	
	@FindBy(how = How.XPATH, using="//div[@class='toast-message']")
	private WebElement alertMessage;
	
	
	
	public Map<Boolean,String> clickNewOrderButton()	{
		
		return Elements.CLICK(driver, newOrderButton);
		
	}
	
	public Map<Boolean,String> clickSaleOrderDetails()	{
		Map<Boolean,String> saleOrder = null;
		
		for(int i=0;i<actionDropdown.size();i++)	{
			if(i==4) {
			WebElement element = actionDropdown.get(i);
			saleOrder = Elements.CLICK(driver, element);
			break;
			}
		}
		return saleOrder;
	}
	
	public boolean attachmentVerification()	{
		
		return Validations.IFELEMENTPRESENT(verifyAttachment);
		
	}
	
	public Map<Boolean,String> clickEditSaleOrder()	{
		Map<Boolean,String> editSale = null;
		
		for(int i=0;i<actionDropdown.size();i++) {
			if(i==5) {
				WebElement element = actionDropdown.get(i);
				editSale = Elements.CLICK(driver, element);
				break;
			}
		}
		return editSale;		
	}
	
	public Map<Boolean,String> clickDeleteSaleOrder()	{
		Map<Boolean,String> deleteSale = null;
		
		for(int i=0;i<actionDropdown.size();i++) {
			if(i==9) {
				WebElement element = actionDropdown.get(i);
				deleteSale = Elements.CLICK(driver, element);
				break;
			}
		}
		return deleteSale;		
	}
	
	public Map<Boolean,String> yesInPopup()	{
		
		return Elements.CLICK(driver, clickYes);
		
	}
	
	public Map<Boolean,String> mouseHover()	{
		
		return Elements.MOUSECLICK(driver, toast);
		
	}
	
	public Map<Boolean,String> clickEmailSaleOrder()	{
		Map<Boolean,String> emailSale = null;
		
		for(int i=0;i<actionDropdown.size();i++) {
			if(i==8) {
				WebElement element = actionDropdown.get(i);
				emailSale = Elements.CLICK(driver, element);
				break;
			}
		}
		return emailSale;		
	}
	
	public Map<Boolean,String> clickCreateInvoice()	{
		Map<Boolean,String> invoice = null;
		
		for(int i=0;i<actionDropdown.size();i++)	{
			if(i==6) {
			WebElement element = actionDropdown.get(i);
			invoice = Elements.CLICK(driver, element);
			break;
			}
		}
		return invoice;
	}
	
	public Map<Boolean,String> clickItemPickList()	{
		Map<Boolean,String> pick = null;
		
		for(int i=0;i<actionDropdown.size();i++)	{
			if(i==10) {
			WebElement element = actionDropdown.get(i);
			pick = Elements.CLICK(driver, element);
			break;
			}
		}
		return pick;
	}
	
	public String invoiceTick()	{
		String tick = null;
		
		for(int i=0;i<verifyTickMark.size();i++) {
			if(i==0) {
				WebElement element = verifyTickMark.get(i);
				tick = element.getAttribute("class");
				break;
			}
		}
		return tick;
	}
	
	public String paymentTick()	{
		String tick = null;
		
		for(int i=0;i<verifyTickMark.size();i++) {
			if(i==1) {
				WebElement element = verifyTickMark.get(i);
				tick = element.getAttribute("class");
				break;
			}
		}
		return tick;
	}
	
	public String packedTickBeforePicking()	{
		String tick = null;
		
		for(int i=0;i<verifyTickMark.size();i++) {
			if(i==2) {
				WebElement element = verifyTickMark.get(i);
				tick = element.getAttribute("class");
				break;
			}
		}
		return tick;
	}
	
	public String packedTickAfterPicking()	{
		String tick = null;
		
		for(int i=0;i<verifyTickMark.size();i++) {
			if(i==2) {
				WebElement element = verifyTickMark.get(i);
				tick = element.getAttribute("class");
				break;
			}
		}
		return tick;
	}
	
	public String readyToShip()	{
		String tick = null;
		
		for(int i=0;i<verifyTickMark.size();i++) {
			if(i==3) {
				WebElement element = verifyTickMark.get(i);
				tick = element.getAttribute("class");
				break;
			}
		}
		return tick;
	}
	
	public String shipped()	{
		String tick = null;
		
		for(int i=0;i<verifyTickMark.size();i++) {
			if(i==4) {
				WebElement element = verifyTickMark.get(i);
				tick = element.getAttribute("class");
				break;
			}
		}
		return tick;
	}
	
	public String delivered()	{
		String tick = null;
		
		for(int i=0;i<verifyTickMark.size();i++) {
			if(i==5) {
				WebElement element = verifyTickMark.get(i);
				tick = element.getAttribute("class");
				break;
			}
		}
		return tick;
	}
	
	public Map<Boolean,String> clickInvoice() {

		return Elements.CLICK(driver, clickInvoice);
		
	}
	
	public Map<Boolean,String> clickAll() {

		return Elements.CLICK(driver, clickAllInTopList);
		
	}
	
	public Map<Boolean,String> clickDeliveries() {

		return Elements.CLICK(driver, clickDeliveries);
		
	}
	
	public Map<Boolean,String> clickBulkDelete() {

		return Elements.CLICK(driver, bulkDeleteSO);
		
	}
	
	public Map<Boolean,String> clickMoreButton() {
		
		return Elements.CLICK(driver, moreButton);
		
	}
	
	public Map<Boolean,String> clickDeleteSOinBulk() {
		
		return Elements.CLICK(driver, deleteSOinBulk);
		
	}
	
	public boolean checkSO()	{
		boolean SO = false;
		
		for(int i=0;i<selectSO.size();i++)	{
			if(i==1 || i==2 || i==3) {
				WebElement element = selectSO.get(i);
				SO = Validations.ISSELECTED(element);
			}if(i>3) break;
		}
		return SO;		
	}
	
	public Map<Boolean,String> clickDeleteButton() {
		
		return Elements.CLICK(driver, deleteButton);
		
	}
	
	public Map<Boolean,String> clickBulkDeleteSO() {
		
		return Elements.CLICK(driver, bulkDeleteSO);
		
	}
	
	public Map<Boolean,String> clickBulkAddDelivery() {
		
		return Elements.CLICK(driver, bulkAddDelivery);
		
	}
	
	public boolean checkSOforDelivery()	{
		boolean SO = false;
		
		for(int i=0;i<selectSO.size();i++)	{
			if(i==0) {
				WebElement element = selectSO.get(i);
				SO = Validations.ISSELECTED(element);
				break;
			} 
		}
		return SO;		
	}
	
	public Map<Boolean,String> clickConvertToDOButton() {
		
		return Elements.CLICK(driver, convertToDO);
		
	}
	
	public String alert() {
		
		return alertMessage.getText().substring(0, 29);
		
	}
	
	public String alert1()	{
		
		return alertMessage.getText().substring(15);
		
	}
	

}
