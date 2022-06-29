package pageObjects;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import commonMethods.Elements;
import commonMethods.Validations;
import commonMethods.Windows;


public class DeliveryListPage {
	
	private WebDriver driver;
	
	public DeliveryListPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	@FindBy(how = How.XPATH, using="//table[@id='DOData']//tbody//tr//td//button")
	private List<WebElement> DOdataStatus;
	
	@FindBy(how = How.XPATH, using="//ul[@class='dropdown-menu pull-right']//li")
	private List<WebElement> selectOption;
	
	@FindBy(how = How.XPATH, using="//a[@class='btn btn-danger po-delete']")
	private WebElement deleteConfirmationYes;
	
	@FindBy(how = How.XPATH, using="//button[@class='btn btn-default dropdown-toggle']")
	private WebElement clickMore;
	
	@FindBy(how = How.XPATH, using="//div//ins[@class='iCheck-helper']")
	private List<WebElement> chooseCheckBox;
	
	@FindBy(how = How.XPATH, using="//a[@class='bpo btn btn-default deletetodata']")
	private WebElement clickDeleteButton;
	
	@FindBy(how = How.ID, using="delete")
	private WebElement clickYesInDeleteConfirmation;
	
	@FindBy(how = How.XPATH, using="//a[@class='btn btn-default edittodata']")
	private WebElement changeStatus;
	
	@FindBy(how = How.ID, using="select2-chosen-3")
	private WebElement clickStatus;
	
	@FindBy(how = How.XPATH, using="//ul[@id='select2-results-3']//li")
	private List<WebElement> chooseStatus;
	
	@FindBy(how = How.ID, using="update_delivery_status")
	private WebElement clickUpdateStatusButton;
	
	@FindBy(how = How.ID, using="assignDriver")
	private WebElement assignDriver;
	
	@FindBy(how = How.ID, using="select2-chosen-4")
	private WebElement clickAssignToDriver;
	
	@FindBy(how = How.XPATH, using="//ul[@id='select2-results-4']//li")
	private List<WebElement> chooseDriver;
	
	@FindBy(how = How.ID, using="submit_assign_driver")
	private WebElement submitNewDriver;
	
	@FindBy(how = How.XPATH, using="//ul[@class='dropdown-menu pull-right']//li//a")
	private List<WebElement> actionsList;
	
	@FindBy(how = How.NAME, using="picked_quantity[]")
	private WebElement pickedQuantity;
	
	@FindBy(how = How.XPATH, using="//table[@class='table table-bordered table-hover table-striped dataTable_Left']//tbody//tr//td[8]")
	private WebElement getQty;
	
	@FindBy(how = How.ID, using="submit")
	private WebElement submitButton;
	
	@FindBy(how = How.XPATH, using="//table[@id='DOData']//tbody//tr[1]//td[1]//button")
	private WebElement statusAfterPickedQty;
	
	@FindBy(how = How.ID, using="printcan")
	private WebElement editBtnInPickList;
	
	@FindBy(how = How.XPATH, using="//div[@class='col-md-12 col-sm-12 col-xs-12 text-center']//h1")
	private WebElement packingSlip;
	
	@FindBy(how = How.XPATH, using="//div[@class='text-right col-md-12']//button")
	private WebElement closePickListPopup;
	
	@FindBy(how = How.XPATH, using="//div[@class='col-md-12 text-left']//p//a[2]")
	private WebElement pendingStatus;
	
	@FindBy(how = How.XPATH, using="//table[@id='DOData']//tbody//tr//td[1]//button")
	private List<WebElement> deliveryStatusList;
	
	@FindBy(how = How.XPATH, using="//ul[@class='pagination pagination-sm']//li[@class='next']//a[contains(text(),'Next > ')]")
	private WebElement paginate;
	
	@FindBy(how = How.XPATH, using="//ul[@class='pagination pagination-sm']//li")
	private List<WebElement> sizeOfPagination;
	
	@FindBy(how = How.XPATH, using="//div[@class='col-md-12 text-left']//p//a[3]")
	private WebElement packedStatus;
	
	@FindBy(how = How.XPATH, using="//div[@class='col-md-12 text-left']//p//a[4]")
	private WebElement readyToShipStatus;
	
	@FindBy(how = How.XPATH, using="//div[@class='col-md-12 text-left']//p//a[5]")
	private WebElement shippedStatus;
	
	@FindBy(how = How.XPATH, using="//div[@class='col-md-12 text-left']//p//a[6]")
	private WebElement deliveredStatus;
	
	@FindBy(how = How.XPATH, using="//div[@class='col-md-12 text-left']//p//a[7]")
	private WebElement onHoldStatus;
	
	@FindBy(how = How.XPATH, using="//div[@class='col-md-12 text-left']//p//a[8]")
	private WebElement cancelledStatus;
	
	@FindBy(how = How.XPATH, using="//div[@class='col-md-12 text-left']//p//a[1]")
	private WebElement ALLStatus;
	
	@FindBy(how = How.XPATH, using="//div[@id='DOData_info']")
	private WebElement displayResult;
	
	@FindBy(how = How.XPATH, using="//table[@id='DOData']//tbody//tr")
	private List<WebElement> resultInTable;
	
	@FindBy(how = How.XPATH, using="//div[@id='DOData_length']//label//div//a//span[1]")
	private WebElement displayOption;
	
	@FindBy(how = How.XPATH, using="//table[@id='DOData']//thead//tr[1]//th[1]")
	private WebElement sortStatus;
	
	@FindBy(how = How.XPATH, using="//table[@id='DOData']//tbody//tr//td[1]")
	private List<WebElement> statusList;
	
	@FindBy(how = How.XPATH, using="//table[@id='DOData']//thead//tr[1]//th[2]")
	private WebElement sortDODate;
	
	@FindBy(how = How.XPATH, using="//table[@id='DOData']//tbody//tr//td[2]")
	private List<WebElement> DODateList;
	
	@FindBy(how = How.XPATH, using="//table[@id='DOData']//thead//tr[1]//th[3]")
	private WebElement sortDRDate;
	
	@FindBy(how = How.XPATH, using="//table[@id='DOData']//tbody//tr//td[3]")
	private List<WebElement> DRDateList;
	
	@FindBy(how = How.XPATH, using="//table[@id='DOData']//thead//tr[1]//th[4]")
	private WebElement sortDeliveredDate;
	
	@FindBy(how = How.XPATH, using="//table[@id='DOData']//tbody//tr//td[4]")
	private List<WebElement> DeliveredDateList;
	
	@FindBy(how = How.XPATH, using="//table[@id='DOData']//thead//tr[1]//th[5]")
	private WebElement sortChannels;
	
	@FindBy(how = How.XPATH, using="//table[@id='DOData']//tbody//tr//td[5]")
	private List<WebElement> channelsList;
	
	@FindBy(how = How.XPATH, using="//table[@id='DOData']//thead//tr[1]//th[6]")
	private WebElement sortChannelOrderNo;
	
	@FindBy(how = How.XPATH, using="//table[@id='DOData']//tbody//tr//td[6]")
	private List<WebElement> channelOrderNoList;
	
	@FindBy(how = How.XPATH, using="//table[@id='DOData']//thead//tr[1]//th[7]")
	private WebElement sortDeliveryNo;
	
	@FindBy(how = How.XPATH, using="//table[@id='DOData']//tbody//tr//td[7]")
	private List<WebElement> deliveryNoList;
	
	@FindBy(how = How.XPATH, using="//table[@id='DOData']//thead//tr[1]//th[9]")
	private WebElement sortCustomers;
	
	@FindBy(how = How.XPATH, using="//table[@id='DOData']//tbody//tr//td[9]")
	private List<WebElement> customersList;
	
	@FindBy(how = How.XPATH, using="//table[@id='DOData']//thead//tr[1]//th[10]")
	private WebElement sortPostalCode;
	
	@FindBy(how = How.XPATH, using="//table[@id='DOData']//tbody//tr//td[10]")
	private List<WebElement> postalCodeList;
	
	@FindBy(how = How.XPATH, using="//table[@id='DOData']//thead//tr[2]//th[2]//div//input")
	private WebElement doDateField;
	
	@FindBy(how = How.NAME, using="daterangepicker_start")
	private WebElement dateRangepickerStart;
	
	@FindBy(how = How.NAME, using="daterangepicker_end")
	private WebElement dateRangepickerEnd;
	
	@FindBy(how = How.XPATH, using="//table[@id='DOData']//tbody//tr//td[2]")
	private List<WebElement> dateSearchResult;
	
	@FindBy(how = How.XPATH, using="//table[@id='DOData']//tbody//tr//td[3]")
	private List<WebElement> DRDate;
	
	@FindBy(how = How.XPATH, using="//table[@id='DOData']//thead//tr[2]//th[3]//div//input")
	private WebElement enterDRDate;
	
	@FindBy(how = How.XPATH, using="//table[@id='DOData']//tbody//tr//td[3]")
	private List<WebElement> dateSearchResultForDRDate;
	
	@FindBy(how = How.XPATH, using="//table[@id='DOData']//tbody//tr//td[4]")
	private List<WebElement> DeliveredDate;
	
	@FindBy(how = How.XPATH, using="//table[@id='DOData']//thead//tr[2]//th[4]//div//input")
	private WebElement enterDeliveredDate;
	
	@FindBy(how = How.XPATH, using="//input[@name='daterangepicker_start']")
	private List<WebElement> startDate;
	
	@FindBy(how = How.XPATH, using="//input[@name='daterangepicker_end']")
	private List<WebElement> endDate;
	
	@FindBy(how = How.XPATH, using="//button[contains(text(),'Apply')]")
	private List<WebElement> applyButton;
	
	@FindBy(how = How.XPATH, using="//table[@id='DOData']//tbody//tr//td[5]")
	private List<WebElement> getChannelName;
	
	@FindBy(how = How.XPATH, using="//table[@id='DOData']//thead//tr[2]//th[5]//div//input")
	private WebElement enterChannel;
	
	@FindBy(how = How.XPATH, using="//table[@id='DOData']//tbody//tr//td[6]")
	private List<WebElement> getChannelOrderNo;
	
	@FindBy(how = How.XPATH, using="//table[@id='DOData']//thead//tr[2]//th[6]//div//input")
	private WebElement enterChannelOrderNo;
	
	@FindBy(how = How.XPATH, using="//table[@id='DOData']//tbody//tr//td[7]")
	private List<WebElement> getDeliveryNo;
	
	@FindBy(how = How.XPATH, using="//table[@id='DOData']//thead//tr[2]//th[7]//div//input")
	private WebElement enterDeliveryNo;
	
	@FindBy(how = How.XPATH, using="//table[@id='DOData']//tbody//tr//td[8]")
	private List<WebElement> getInvoiceNo;
	
	@FindBy(how = How.XPATH, using="//table[@id='DOData']//thead//tr[2]//th[8]//div//input")
	private WebElement enterInvoiceNo;
	
	@FindBy(how = How.XPATH, using="//table[@id='DOData']//tbody//tr//td[9]")
	private List<WebElement> getCustomer;
	
	@FindBy(how = How.XPATH, using="//table[@id='DOData']//thead//tr[2]//th[9]//div//input")
	private WebElement enterCustomerName;
	
	@FindBy(how = How.XPATH, using="//table[@id='DOData']//tbody//tr//td[10]")
	private List<WebElement> getPostalCode;
	
	@FindBy(how = How.XPATH, using="//table[@id='DOData']//thead//tr[2]//th[10]//div//input")
	private WebElement enterPostalCode;
	
	@FindBy(how = How.XPATH, using="//table[@id='DOData']//tbody//tr[1]//td[1]//button")
	private WebElement deliveryStatus;
	
	@FindBy(how = How.XPATH, using="//div[@id='s2id_delivery_status']//a//span[@class='select2-chosen']")
	private WebElement clickdelStatus;
	
	@FindBy(how = How.XPATH, using="//div[@id='select2-drop']//ul//li[3]")
	private WebElement chooseReadyToShip;
	
	@FindBy(how = How.XPATH, using="//div[@id='select2-drop']//ul//li[4]")
	private WebElement chooseShipped;
	
	@FindBy(how = How.XPATH, using="//div[@id='select2-drop']//ul//li[7]")
	private WebElement chooseDelivered;
	
	@FindBy(how = How.ID, using="update_delivery_status")
	private WebElement updateDeliveryStatusButton;
	
	
	
	public String deliveryStatus()	{
		
		String DOstatus = null;
		for(int i=0;i<DOdataStatus.size();i++)	{
			if(i==0) {
				WebElement element = DOdataStatus.get(i);
				DOstatus = element.getText();
				break;
			}
		}
		return DOstatus;
	}
	
	public Map<Boolean,String> editDelivery()	{
		
		Map<Boolean,String> selectEditOption = null;
		for(int i=0;i<selectOption.size();i++) {
			if(i==10) {
				WebElement element = selectOption.get(i);
				selectEditOption = Elements.CLICK(driver, element);
				break;
			}
		}
		return selectEditOption;
	}
	
	public Map<Boolean,String> deleteDelivery()	{
		Map<Boolean,String> selectDelete = null;
		for(int i=0;i<selectOption.size();i++)	{
			if(i==12)	{
				WebElement element = selectOption.get(i);
				selectDelete = Elements.CLICK(driver, element);
				break;
			}
		}
		return selectDelete;
	}
	
	public Map<Boolean,String> deleteConfirmation()	{
		
		return Elements.CLICK(driver, deleteConfirmationYes);
		
	}
	
	public Map<Boolean,String> clickMoreOption()	{
		
		return Elements.CLICK(driver, clickMore);
		
	}
	
	public Map<Boolean,String> clickDeleteDeleveries()	{
		
		Map<Boolean,String> bulkDelete = null;
		for(int i=0;i<selectOption.size();i++) {
			if(i==4) {
				WebElement element = selectOption.get(i);
				bulkDelete = Elements.CLICK(driver, element);
				break;
			}
		}
		return bulkDelete;
	}
	
	public boolean chooseCheckBox()	{
		
		boolean chooseBox = false;
		for(int i=0;i<chooseCheckBox.size();i++)	{
			if(i==1 || i==2 || i==3)	{
				WebElement element = chooseCheckBox.get(i);
				chooseBox = Validations.ISSELECTED(element);
			}if(i>3) {
				break;
			}
		}
		return chooseBox;
	}
	
	public Map<Boolean,String> clickDelete()	{
		
		return Elements.CLICK(driver, clickDeleteButton);
		
	}
	
	public Map<Boolean,String> clickYesConfirm()	{
		
		return Elements.CLICK(driver, clickYesInDeleteConfirmation);
		
	}
	
	public Map<Boolean,String> changeStatus()	{
		
		Map<Boolean,String> Status = null;
		for(int i=0;i<selectOption.size();i++) {
			if(i==2) {
				WebElement element = selectOption.get(i);
				Status = Elements.CLICK(driver, element);
				break;
			}
		}
		return Status;
	}
	
	public Map<Boolean,String> clickChangeStatusButton()	{
		
		return Elements.CLICK(driver, changeStatus);
		
	}
	
	public Map<Boolean,String> clickStatus()	{
		
		return Elements.CLICK(driver, clickStatus);
		
	}
	
	public Map<Boolean,String> chooseStatus()	{
		
		Map<Boolean,String> Status = null;
		for(int i=0;i<chooseStatus.size();i++)	{
			if(i==2) {
				WebElement element = chooseStatus.get(i);
				Status = Elements.CLICK(driver, element);
				break;
			}
		}
		return Status;		
	}
	
	public Map<Boolean,String> updateStatus()	{
	
		return Elements.CLICK(driver, clickUpdateStatusButton);
		
	}
	
	public Map<Boolean,String> assignToDriver()	{
		
		Map<Boolean,String> selectAssignDriver = null;
		for(int i=0;i<selectOption.size();i++)	{
			if(i==3) {
				WebElement element = selectOption.get(i);
				selectAssignDriver = Elements.CLICK(driver, element);
				break;
			}
		}
		return selectAssignDriver;
	}
	
	public Map<Boolean,String> clickAssignDriverButton()	{
		
		return Elements.CLICK(driver, assignDriver);
		
	}

	public Map<Boolean,String> clickDriver()	{
		
		return Elements.CLICK(driver, clickAssignToDriver);
		
	}
	
	public Map<Boolean,String> chooseDriver()	{
		
		Map<Boolean,String> newdriver = null;
		for(int i=0;i<chooseDriver.size();i++)	{
			if(i==0) {
				WebElement element = chooseDriver.get(i);
				newdriver = Elements.CLICK(driver, element);
				break;
			}
		}
		return newdriver;
	}
	
	public Map<Boolean,String> submitDriver()	{
		
		return Elements.CLICK(driver, submitNewDriver);
		
	}
	
	public Map<Boolean,String> closeNewTab()	{
		
		 return Windows.SWITCHTOPARENTWINDOW(driver);
			
	}
	
	public Map<Boolean,String> clickItemPickList()	{
		Map<Boolean,String> pickList = null;
		
		for(int i=0;i<actionsList.size();i++) {
			if(i==4) {
				WebElement element = actionsList.get(i);
				pickList = Elements.CLICK(driver, element);
				break;
			}
		}
		return pickList;
	}
	
	public String getQuantity()	{
		
		return getQty.getText().trim();
		
	}
	
	public Map<Boolean,String> enterPickedQty()	{
		
		return Elements.ENTERVALUE(driver, pickedQuantity, "1");
		
	}
	
	public Map<Boolean,String> clickSubmitButton() {
		
		return Elements.CLICK(driver, submitButton);
		
	}
	
	public void clickOut() throws AWTException, InterruptedException {
		
		Robot robot = new Robot();
		robot.mouseMove(100,400);
		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(1000);
		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		
	}
	
	public String statusAfterPickQty()	{
		
		return statusAfterPickedQty.getText();
		
	}
	
	public Map<Boolean,String> clickEditBtn()	{
		
		return Elements.CLICK(driver, editBtnInPickList);
		
	}
	
	public Map<Boolean,String> clickPackingSlip()	{
		Map<Boolean,String> pack = null;
		
		for(int i=0;i<actionsList.size();i++) {
			if(i==5) {
				WebElement element = actionsList.get(i);
				pack = Elements.CLICK(driver, element);
				break;
			}
		}
		return pack;
	}
	
	public String packSlip()	{
		
		return packingSlip.getText().trim();
		
	}
	
	public Map<Boolean,String> clickClosePickListPopup() {
		
		return Elements.CLICK(driver, closePickListPopup);
		
	}
	
	public boolean verifyPickListPopup()	{
	
		return Validations.IFELEMENTPRESENT(closePickListPopup);
		
	}
	
	public Map<Boolean,String> clickClosePackingSlipPopup() {
		
		return Elements.CLICK(driver, closePickListPopup);
		
	}
	
	public boolean verifyPackingSlipPopup()	{
		
		return Validations.IFELEMENTPRESENT(closePickListPopup);
		
	}
	
	public Map<Boolean,String> clickPendingStatus()	{
		
		return Elements.CLICK(driver, pendingStatus);
		
	}
	
	public boolean paginateAndGetValuesForPending() throws Exception	{
		boolean result = false;
				
		do{
			for(int i=0;i<deliveryStatusList.size();i++) {
				String text = deliveryStatusList.get(i).getText();
				if(text.equalsIgnoreCase("Pending")){ 
					result = true;
				} else {
					return false;
				}
			}
			if(Validations.IFELEMENTPRESENT(paginate))
			Elements.CLICK(driver, paginate);
		}
		while(Validations.IFELEMENTPRESENT(paginate));
		if(sizeOfPagination.size() == 3) {
			result = true;
		}else if(!Validations.IFELEMENTPRESENT(paginate)) {
			for(int i=0;i<deliveryStatusList.size();i++) {
				String text = deliveryStatusList.get(i).getText();
				if(text.equalsIgnoreCase("Pending")){ 
					result = true;
				} else {
					return false;
				}
			}
		}
		return result;
	}
	
	public Map<Boolean,String> clickPackedStatus()	{
		
		return Elements.CLICK(driver, packedStatus);
		
	}
	
	public boolean paginateAndGetValuesForPacked()	{
		boolean result = false;
				
		do{
			for(int i=0;i<deliveryStatusList.size();i++) {
				String text = deliveryStatusList.get(i).getText();
				if(text.equalsIgnoreCase("Packed")){ 
					result = true;
				} else {
					return false;
				}
			}
			if(Validations.IFELEMENTPRESENT(paginate))
			Elements.CLICK(driver, paginate);
		}
		while(Validations.IFELEMENTPRESENT(paginate));	
		if(sizeOfPagination.size() == 3) {
			result = true;
		}else if(!Validations.IFELEMENTPRESENT(paginate)) {
			for(int i=0;i<deliveryStatusList.size();i++) {
				String text = deliveryStatusList.get(i).getText();
				if(text.equalsIgnoreCase("Packed")){ 
					result = true;
				} else {
					return false;
				}
			}
		}
		return result;
	}
	
	public Map<Boolean,String> clickReadyToShipStatus()	{
		
		return Elements.CLICK(driver, readyToShipStatus);
		
	}
	
	public boolean paginateAndGetValuesForReadyToShip()	{
		boolean result = false;
				
		do{
			for(int i=0;i<deliveryStatusList.size();i++) {
				String text = deliveryStatusList.get(i).getText();
				if(text.equalsIgnoreCase("Ready To Ship")){ 
					result = true;
				} else {
					return false;
				}
			}
			if(Validations.IFELEMENTPRESENT(paginate))
			Elements.CLICK(driver, paginate);
		}
		while(Validations.IFELEMENTPRESENT(paginate));
		if(sizeOfPagination.size() == 3) {
			result = true;
		}else if(!Validations.IFELEMENTPRESENT(paginate)) {
			for(int i=0;i<deliveryStatusList.size();i++) {
				String text = deliveryStatusList.get(i).getText();
				if(text.equalsIgnoreCase("Ready To Ship")){ 
					result = true;
				} else {
					return false;
				}
			}
		}
		return result;
	}
	
	public Map<Boolean,String> clickShippedStatus()	{
		
		return Elements.CLICK(driver, shippedStatus);
		
	}
	
	public boolean paginateAndGetValuesForShipped()	{
		boolean result = false;
				
		do{
			for(int i=0;i<deliveryStatusList.size();i++) {
				String text = deliveryStatusList.get(i).getText();
				if(text.equalsIgnoreCase("Shipped")){ 
					result = true;
				} else {
					return false;
				}
			}
			if(Validations.IFELEMENTPRESENT(paginate))
			Elements.CLICK(driver, paginate);
		}
		while(Validations.IFELEMENTPRESENT(paginate));
		if(sizeOfPagination.size() == 3) {
			result = true;
		}else if(!Validations.IFELEMENTPRESENT(paginate)) {
			for(int i=0;i<deliveryStatusList.size();i++) {
				String text = deliveryStatusList.get(i).getText();
				if(text.equalsIgnoreCase("Shipped")){ 
					result = true;
				} else {
					return false;
				}
			}
		}
		return result;
	}
	
	public Map<Boolean,String> clickDeliveredStatus()	{
		
		return Elements.CLICK(driver, deliveredStatus);
		
	}
	
	public boolean paginateAndGetValuesForDelivered()	{
		boolean result = false;
				
		do{
			for(int i=0;i<deliveryStatusList.size();i++) {
				String text = deliveryStatusList.get(i).getText();
				if(text.equalsIgnoreCase("Delivered")){ 
					result = true;
				} else {
					return false;
				}
			}
			if(Validations.IFELEMENTPRESENT(paginate))
			Elements.CLICK(driver, paginate);
		}
		while(Validations.IFELEMENTPRESENT(paginate));
		if(sizeOfPagination.size() == 3) {
			result = true;
		}else if(!Validations.IFELEMENTPRESENT(paginate)) {
			for(int i=0;i<deliveryStatusList.size();i++) {
				String text = deliveryStatusList.get(i).getText();
				if(text.equalsIgnoreCase("Delivered")){ 
					result = true;
				} else {
					return false;
				}
			}
		}
		return result;
	}
	
	public Map<Boolean,String> clickOnHoldStatus()	{
		
		return Elements.CLICK(driver, onHoldStatus);
		
	}
	
	public boolean paginateAndGetValuesForOnHold()	{
		boolean result = false;
				
		do{
			for(int i=0;i<deliveryStatusList.size();i++) {
				String text = deliveryStatusList.get(i).getText();
				if(text.equalsIgnoreCase("On Hold")){ 
					result = true;
				} else {
					return false;
				}
			}
			if(Validations.IFELEMENTPRESENT(paginate))
			Elements.CLICK(driver, paginate);
		}
		while(Validations.IFELEMENTPRESENT(paginate));
		if(sizeOfPagination.size() == 3) {
			result = true;
		}else if(!Validations.IFELEMENTPRESENT(paginate)) {
			for(int i=0;i<deliveryStatusList.size();i++) {
				String text = deliveryStatusList.get(i).getText();
				if(text.equalsIgnoreCase("On Hold")){ 
					result = true;
				} else {
					return false;
				}
			}
		}
		return result;
	}
	
	public Map<Boolean,String> clickCancelledStatus()	{
		
		return Elements.CLICK(driver, cancelledStatus);
		
	}
	
	public boolean paginateAndGetValuesForCancelled()	{
		boolean result = false;
				
		do{
			for(int i=0;i<deliveryStatusList.size();i++) {
				String text = deliveryStatusList.get(i).getText();
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
		if(sizeOfPagination.size() == 3) {
			result = true;
		}else if(!Validations.IFELEMENTPRESENT(paginate)) {
			for(int i=0;i<deliveryStatusList.size();i++) {
				String text = deliveryStatusList.get(i).getText();
				if(text.equalsIgnoreCase("Cancelled")){ 
					result = true;
				} else {
					return false;
				}
			}
		}
		return result;
	}
	
	public Map<Boolean,String> clickALLStatus()	{
		
		return Elements.CLICK(driver, ALLStatus);
		
	}
	
	public boolean paginateAndGetValuesForAll()	{
		boolean result = false;
				
		do{
			for(int i=0;i<deliveryStatusList.size();i++) {
				String text = deliveryStatusList.get(i).getText();
				if(text.equalsIgnoreCase("Cancelled") || text.equalsIgnoreCase("On Hold") || text.equalsIgnoreCase("Delivered") || 
				text.equalsIgnoreCase("Shipped") || text.equalsIgnoreCase("Ready To Ship") || text.equalsIgnoreCase("Packed") ||
				text.equalsIgnoreCase("Pending")){ 
					result = true;
				} else {
					return false;
				}
			}
			if(Validations.IFELEMENTPRESENT(paginate))
			Elements.CLICK(driver, paginate);
		}
		while(Validations.IFELEMENTPRESENT(paginate));
		if(sizeOfPagination.size() == 3) {
			result = true;
		}else if(!Validations.IFELEMENTPRESENT(paginate)) {
			for(int i=0;i<deliveryStatusList.size();i++) {
				String text = deliveryStatusList.get(i).getText();
				if(text.equalsIgnoreCase("Cancelled") || text.equalsIgnoreCase("OnHold") || text.equalsIgnoreCase("Delivered") || 
						text.equalsIgnoreCase("Shipped") || text.equalsIgnoreCase("Ready To Ship") || text.equalsIgnoreCase("Packed") ||
						text.equalsIgnoreCase("Pending")){ 
					result = true;
				} else {
					return false;
				}
			}
		}
		return result;
	}
	
	public Map<Boolean,String> clickDisplayOption()	{
		
		return Elements.CLICK(driver, displayOption);
		
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
	
	public Map<Boolean,String> clickStatusForSorting()	{
		
		return Elements.CLICK(driver, sortStatus);
	
	}

	public boolean verifyObtainedAndSortedStatusInAscOrder()	{
		
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
				System.out.println("Obtained : "+obtainedList);
		
		ArrayList<String> sortedList = new ArrayList<>();
			for(String s : obtainedList)	{
				sortedList.add(s);
			}
			Collections.sort(sortedList);
			System.out.println("Sorted : "+sortedList);
			return sortedList.equals(obtainedList);
	}
	
	public boolean verifyObtainedAndSortedStatusInDescOrder()	{
		
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
	
	public Map<Boolean,String> clickDODateForSorting()	{
		
		return Elements.CLICK(driver, sortDODate);
	
	}
	
	public boolean verifyObtainedAndSortedDODateInAscOrder() throws ParseException	{
		
		ArrayList<String> obtainedList = new ArrayList<>();
		
		do{
			for(WebElement element : DODateList) {
				String textDate = element.getText().substring(0, 10);
				String tDate = textDate.trim();
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				Date parsedDate = sdf.parse(tDate);
				SimpleDateFormat print = new SimpleDateFormat("yyyy/MM/dd");
				String pd = print.format(parsedDate);
					obtainedList.add(pd);
			}
			if(Validations.IFELEMENTPRESENT(paginate))
				Elements.CLICK(driver, paginate);	
		}while(Validations.IFELEMENTPRESENT(paginate));
		if(!Validations.IFELEMENTPRESENT(paginate))
				for(WebElement element : DODateList) {
					String textDate = element.getText().substring(0, 10);
					String tDate = textDate.trim();
					SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
					Date parsedDate = sdf.parse(tDate);
					SimpleDateFormat print = new SimpleDateFormat("yyyy/MM/dd");
					String pd = print.format(parsedDate);
						obtainedList.add(pd);
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
	
	public boolean verifyObtainedAndSortedDODateInDescOrder() throws ParseException	{
		
		ArrayList<String> obtainedList = new ArrayList<>();
		
		do{
			for(WebElement element : DODateList) {
				String textDate = element.getText().substring(0, 10);
				String tDate = textDate.trim();
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				Date parsedDate = sdf.parse(tDate);
				SimpleDateFormat print = new SimpleDateFormat("yyyy/MM/dd");
				String pd = print.format(parsedDate);
					obtainedList.add(pd);
			}
			if(Validations.IFELEMENTPRESENT(paginate))
				Elements.CLICK(driver, paginate);	
		}while(Validations.IFELEMENTPRESENT(paginate));
		if(!Validations.IFELEMENTPRESENT(paginate))
				for(WebElement element : DODateList) {
					String textDate = element.getText().substring(0, 10);
					String tDate = textDate.trim();
					SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
					Date parsedDate = sdf.parse(tDate);
					SimpleDateFormat print = new SimpleDateFormat("yyyy/MM/dd");
					String pd = print.format(parsedDate);
						obtainedList.add(pd);
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
	
	public Map<Boolean,String> clickDRDateForSorting()	{
		
		return Elements.CLICK(driver, sortDRDate);
	
	}
	
	public boolean verifyObtainedAndSortedDRDateInAscOrder() throws Exception	{
		ArrayList<String> obtainedList = new ArrayList<>();
		
		do{
			for(WebElement element : DRDateList) {
				if(element.getText().equalsIgnoreCase("N.A")) {
					obtainedList.add("0000/00/00");
				} else {
					String textDate = element.getText();
					String tDate = textDate.trim();
					SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
					Date parsedDate = sdf.parse(tDate);
					SimpleDateFormat print = new SimpleDateFormat("yyyy/MM/dd");
					String pd = print.format(parsedDate);
						obtainedList.add(pd);
				}
			}
			if(Validations.IFELEMENTPRESENT(paginate))
				Elements.CLICK(driver, paginate);	
		  }while(Validations.IFELEMENTPRESENT(paginate));
		if(!Validations.IFELEMENTPRESENT(paginate))
			for(WebElement element : DRDateList) {
				if(element.getText().equalsIgnoreCase("N.A")) {
					obtainedList.add("0000/00/00");
				} else {
					String textDate = element.getText();
					String tDate = textDate.trim();
					SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
					Date parsedDate = sdf.parse(tDate);
					SimpleDateFormat print = new SimpleDateFormat("yyyy/MM/dd");
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
	
	public boolean verifyObtainedAndSortedDRDateInDescOrder() throws Exception	{
		ArrayList<String> obtainedList = new ArrayList<>();
		
		do{
			for(WebElement element : DRDateList) {
				if(element.getText().equalsIgnoreCase("N.A")) {
					obtainedList.add("0000/00/00");
				} else {
					String textDate = element.getText();
					String tDate = textDate.trim();
					SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
					Date parsedDate = sdf.parse(tDate);
					SimpleDateFormat print = new SimpleDateFormat("yyyy/MM/dd");
					String pd = print.format(parsedDate);
						obtainedList.add(pd);
				}
			}
			if(Validations.IFELEMENTPRESENT(paginate))
				Elements.CLICK(driver, paginate);	
		  }while(Validations.IFELEMENTPRESENT(paginate));
		if(!Validations.IFELEMENTPRESENT(paginate))
			for(WebElement element : DRDateList) {
				if(element.getText().equalsIgnoreCase("N.A")) {
					obtainedList.add("0000/00/00");
				} else {
					String textDate = element.getText();
					String tDate = textDate.trim();
					SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
					Date parsedDate = sdf.parse(tDate);
					SimpleDateFormat print = new SimpleDateFormat("yyyy/MM/dd");
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
	
	public Map<Boolean,String> clickDeliveredDateForSorting()	{
		
		return Elements.CLICK(driver, sortDeliveredDate);
	
	}
	
	public boolean verifyObtainedAndSortedDeliveredDateInAscOrder() throws ParseException	{
		
		ArrayList<String> obtainedList = new ArrayList<>();
		
		do{
			for(WebElement element : DeliveredDateList) {
				if(element.getText().equalsIgnoreCase("N.A")) {
					obtainedList.add("0000/00/00");
				} else {
				String textDate = element.getText().substring(0, 10);
				String tDate = textDate.trim();
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				Date parsedDate = sdf.parse(tDate);
				SimpleDateFormat print = new SimpleDateFormat("yyyy/MM/dd");
				String pd = print.format(parsedDate);
					obtainedList.add(pd);
			}
			}
			if(Validations.IFELEMENTPRESENT(paginate))
				Elements.CLICK(driver, paginate);	
		}while(Validations.IFELEMENTPRESENT(paginate));
		if(!Validations.IFELEMENTPRESENT(paginate))
				for(WebElement element : DeliveredDateList) {
					if(element.getText().equalsIgnoreCase("N.A")) {
						obtainedList.add("0000/00/00");
					} else {
					String textDate = element.getText().substring(0, 10);
					String tDate = textDate.trim();
					SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
					Date parsedDate = sdf.parse(tDate);
					SimpleDateFormat print = new SimpleDateFormat("yyyy/MM/dd");
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
	
	public boolean verifyObtainedAndSortedDeliveredDateInDescOrder() throws ParseException	{
		
		ArrayList<String> obtainedList = new ArrayList<>();
		
		do{
			for(WebElement element : DeliveredDateList) {
				if(element.getText().equalsIgnoreCase("N.A")) {
					obtainedList.add("0000/00/00");
				} else {
				String textDate = element.getText().substring(0, 10);
				String tDate = textDate.trim();
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				Date parsedDate = sdf.parse(tDate);
				SimpleDateFormat print = new SimpleDateFormat("yyyy/MM/dd");
				String pd = print.format(parsedDate);
					obtainedList.add(pd);
			}
			}
			if(Validations.IFELEMENTPRESENT(paginate))
				Elements.CLICK(driver, paginate);	
		}while(Validations.IFELEMENTPRESENT(paginate));
		if(!Validations.IFELEMENTPRESENT(paginate))
				for(WebElement element : DeliveredDateList) {
					if(element.getText().equalsIgnoreCase("N.A")) {
						obtainedList.add("0000/00/00");
					} else {
					String textDate = element.getText().substring(0, 10);
					String tDate = textDate.trim();
					SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
					Date parsedDate = sdf.parse(tDate);
					SimpleDateFormat print = new SimpleDateFormat("yyyy/MM/dd");
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
	
	public Map<Boolean,String> clickChannelsForSorting()	{
		
		return Elements.CLICK(driver, sortChannels);
	
	}
	
	public boolean verifyObtainedAndSortedChannelsInAscOrder()	{
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
		System.out.println("Obtained : "+obtainedList);
		
		ArrayList<String> sortedList = new ArrayList<>();
		for(String s : obtainedList)	{
			sortedList.add(s);
		}
		 Collections.sort(sortedList, String.CASE_INSENSITIVE_ORDER);
		System.out.println("Sorted : "+sortedList);
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
		System.out.println("Obtained : "+obtainedList);
		
		ArrayList<String> sortedList = new ArrayList<>();
		for(String s : obtainedList)	{
			sortedList.add(s);
		}
		 Collections.sort(sortedList, String.CASE_INSENSITIVE_ORDER);
		 Collections.reverse(sortedList);
		System.out.println("Sorted : "+sortedList);
		if(sortedList.equals(obtainedList)) {
			return true;
		} else {
			return false;
		}		
	}
	
	public Map<Boolean,String> clickChannelOrderNoForSorting()	{
		
		return Elements.CLICK(driver, sortChannelOrderNo);
	
	}
	
	public boolean verifyObtainedAndSortedChannelOrderNoInAscOrder()	{
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
	
	public Map<Boolean,String> clickDeliveryNoForSorting()	{
		
		return Elements.CLICK(driver, sortDeliveryNo);
	
	}
	
	public boolean verifyObtainedAndSortedDeliveryNoInAscOrder()	{
		
		ArrayList<String> obtainedList = new ArrayList<>();
		
		do{
			for(WebElement element : deliveryNoList) {
				obtainedList.add(element.getText());
			}
			if(Validations.IFELEMENTPRESENT(paginate))
				Elements.CLICK(driver, paginate);	
		}while(Validations.IFELEMENTPRESENT(paginate));
		if(!Validations.IFELEMENTPRESENT(paginate))
				for(WebElement element : deliveryNoList) {
					obtainedList.add(element.getText());
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
	
	public Map<Boolean,String> clickCustomersForSorting()	{
		
		return Elements.CLICK(driver, sortCustomers);
	
	}
	
	public boolean verifyObtainedAndSortedCustomersInAscOrder()	{
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
	
	public Map<Boolean,String> clickPostalCodeForSorting()	{
		
		return Elements.CLICK(driver, sortPostalCode);
	
	}
	
	public boolean verifyObtainedAndSortedPostalCodeInAscOrder()	{
		
		ArrayList<String> obtainedList = new ArrayList<>();
		
		do{
			for(WebElement element : postalCodeList) {
				obtainedList.add(element.getText());
			}
			if(Validations.IFELEMENTPRESENT(paginate))
				Elements.CLICK(driver, paginate);	
		}while(Validations.IFELEMENTPRESENT(paginate));
		if(!Validations.IFELEMENTPRESENT(paginate))
				for(WebElement element : postalCodeList) {
					obtainedList.add(element.getText());
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
	
	public boolean verifyObtainedAndSortedPostalCodeInDescOrder()	{
		
		ArrayList<String> obtainedList = new ArrayList<>();
		
		do{
			for(WebElement element : postalCodeList) {
				obtainedList.add(element.getText());
			}
			if(Validations.IFELEMENTPRESENT(paginate))
				Elements.CLICK(driver, paginate);	
		}while(Validations.IFELEMENTPRESENT(paginate));
		if(!Validations.IFELEMENTPRESENT(paginate))
				for(WebElement element : postalCodeList) {
					obtainedList.add(element.getText());
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
	
	public Map<Boolean,String> clickDODateField()	{
		
		return Elements.CLICK(driver, doDateField);
		
	}
	
	public Map<Boolean,String> enterFromDate()	{
		
		return Elements.ENTERVALUE(driver, dateRangepickerStart, "14/06/2022");
		
	}
	
	public Map<Boolean,String> enterToDate()	{
		
		return Elements.ENTERVALUE(driver, dateRangepickerEnd, "14/06/2022");
		
	}
	
	public boolean dateSearchResult()	{
		boolean result = false;
		
		for(int i=0;i<dateSearchResult.size();i++)	{
			String text = dateSearchResult.get(i).getText().substring(0, 10);
			if(text.equalsIgnoreCase("14/06/2022")) {
				result = true;
			} else {
				return false;
			}
		}
		return result;
	}
	
	public String getDRDate()	{
		String date = null;
		
		for(int i=0;i<DRDate.size();i++) {
			if(i==0) {
				WebElement element = DRDate.get(i);
				date = element.getText();
				break;
			}
		}
		return date;
	}
	
	public Map<Boolean,String> enterDRDate()	{
		
		return Elements.ENTERVALUE(driver, enterDRDate, getDRDate());
		
	}
	
	public boolean dateSearchResultForDRDate()	{
		boolean result = false;
		
		for(int i=0;i<dateSearchResultForDRDate.size();i++)	{
			String text = dateSearchResultForDRDate.get(i).getText();
			if(text.equalsIgnoreCase(getDRDate())) {
				result = true;
			} else {
				return false;
			}
		}
		return result;
	}
	
	public Map<Boolean,String> clickDeliveredDate()	{
		
		return Elements.CLICK(driver, enterDeliveredDate);
		
	}
	
	public Map<Boolean,String> enterFromDelDate()	{
		Map<Boolean,String> Date = null;
		
		for(int i=0;i<startDate.size();i++) {
			if(i==2) {
				WebElement element = startDate.get(i);
				Date = Elements.ENTERVALUE(driver, element, "01/05/2022");
				break;
			}
		}
		return Date;
	}
	
	public Map<Boolean,String> enterToDelDate()	{
		Map<Boolean,String> Date = null;
		
		for(int i=0;i<endDate.size();i++) {
			if(i==2) {
				WebElement element = endDate.get(i);
				Date = Elements.ENTERVALUE(driver, element, "01/05/2022");
				break;
			}
		}
		return Date;
	}
	
	public Map<Boolean,String> clickApplyButton() {
		Map<Boolean,String> apply = null;
		
		for(int i=0;i<applyButton.size();i++) {
			if(i==2) {
				WebElement element = applyButton.get(i);
				apply = Elements.CLICK(driver, element);
				break;
			}
		}
		return apply;
	}
	
	public boolean dateSearchResultForDeliveredDate()	{
		boolean result = false;
		
		for(int i=0;i<DeliveredDate.size();i++)	{
			String text = DeliveredDate.get(i).getText().substring(0, 10);
			if(text.equalsIgnoreCase("01/05/2022")) {
				result = true;
			} else {
				return false;
			}
		}
		return result;
	}
	
	public String getChannel()	{
		String channel = null;
		
		for(int i=0;i<getChannelName.size();i++) {
			if(i==0) {
				WebElement element = getChannelName.get(i);
				channel = element.getText();
				break;
			}
		}
		return channel;
	}
	
	public Map<Boolean,String> enterChannelName()	{
		
		return Elements.ENTERVALUE(driver, enterChannel, getChannel());
		
	}
	
	public boolean resultOfChannel()	{
		boolean result = false;
		
		for(int i=0;i<getChannelName.size();i++) {
			String text = getChannelName.get(i).getText();
			if(text.equalsIgnoreCase(getChannel())) {
				result = true;
			} else {
				return false;
			}
		}
		return result;	
	}
	
	public String getChannelOrderNo()	{
		String channelOrderNo = null;
		
		for(int i=0;i<getChannelOrderNo.size();i++) {
			if(i==0) {
				WebElement element = getChannelOrderNo.get(i);
				channelOrderNo = element.getText();
				break;
			}
		}
		return channelOrderNo;
	}
	
	public Map<Boolean,String> enterChannelOrderNo()	{
		
		return Elements.ENTERVALUE(driver, enterChannelOrderNo, getChannelOrderNo());
		
	}
	
	public boolean resultOfChannelOrderNo()	{
		boolean result = false;
		
		for(int i=0;i<getChannelOrderNo.size();i++) {
			String text = getChannelOrderNo.get(i).getText();
			if(text.equalsIgnoreCase(getChannelOrderNo())) {
				result = true;
			} else {
				return false;
			}
		}
		return result;	
	}
	
	public String getDeliveryNo()	{
		String deliveryNo = null;
		
		for(int i=0;i<getDeliveryNo.size();i++) {
			if(i==0) {
				WebElement element = getDeliveryNo.get(i);
				deliveryNo = element.getText();
				break;
			}
		}
		return deliveryNo;
	}
	
	public Map<Boolean,String> enterDeliveryNo()	{
		
		return Elements.ENTERVALUE(driver, enterDeliveryNo, getDeliveryNo());
		
	}
	
	public boolean resultOfDeliveryNo()	{
		boolean result = false;
		
		for(int i=0;i<getDeliveryNo.size();i++) {
			String text = getDeliveryNo.get(i).getText();
			if(text.equalsIgnoreCase(getDeliveryNo())) {
				result = true;
			} else {
				return false;
			}
		}
		return result;	
	}
	
	public String getInvoiceNo()	{
		String invoiceNo = null;
		
		for(int i=0;i<getInvoiceNo.size();i++) {
			if(i==0) {
				WebElement element = getInvoiceNo.get(i);
				invoiceNo = element.getText();
				break;
			}
		}
		return invoiceNo;
	}
	
	public Map<Boolean,String> enterInvoiceNo()	{
		
		return Elements.ENTERVALUE(driver, enterInvoiceNo, getInvoiceNo());
		
	}
	
	public boolean resultOfInvoiceNo()	{
		boolean result = false;
		
		for(int i=0;i<getInvoiceNo.size();i++) {
			String text = getInvoiceNo.get(i).getText();
			if(text.equalsIgnoreCase(getInvoiceNo())) {
				result = true;
			} else {
				return false;
			}
		}
		return result;	
	}
	
	public String getCustomer()	{
		String customer = null;
		
		for(int i=0;i<getCustomer.size();i++) {
			if(i==0) {
				WebElement element = getCustomer.get(i);
				customer = element.getText();
				break;
			}
		}
		return customer;
	}
	
	public Map<Boolean,String> enterCustName()	{
		
		return Elements.ENTERVALUE(driver, enterCustomerName, getCustomer());
		
	}
	
	public boolean resultOfCustomer()	{
		boolean result = false;
		
		for(int i=0;i<getCustomer.size();i++) {
			String text = getCustomer.get(i).getText();
			if(text.equalsIgnoreCase(getCustomer())) {
				result = true;
			} else {
				return false;
			}
		}
		return result;	
	}
	
	public String getPostalCode()	{
		String customer = null;
		
		for(int i=0;i<getPostalCode.size();i++) {
			if(i==0) {
				WebElement element = getPostalCode.get(i);
				customer = element.getText();
				break;
			}
		}
		return customer;
	}
	
	public Map<Boolean,String> enterPostalCode()	{
		
		return Elements.ENTERVALUE(driver, enterPostalCode, getPostalCode());
		
	}
	
	public boolean resultOfPostalCode()	{
		boolean result = false;
		
		for(int i=0;i<getPostalCode.size();i++) {
			String text = getPostalCode.get(i).getText();
			if(text.equalsIgnoreCase(getPostalCode())) {
				result = true;
			} else {
				return false;
			}
		}
		return result;	
	}
	
	public Map<Boolean,String> clickDeliveryStatus() {
		
		return Elements.CLICK(driver, deliveryStatus);
		
	}
	
	public Map<Boolean,String> clickDelStatus() {
		
		return Elements.CLICK(driver, clickdelStatus);
		
	}
	
	public Map<Boolean,String> clickReadyToShip() {
		
		return Elements.CLICK(driver, chooseReadyToShip);
		
	}
	
	public Map<Boolean,String> clickUpdateStatusButton()	{
		
		return Elements.CLICK(driver, updateDeliveryStatusButton);
		
	}
	
	public Map<Boolean,String> clickShipped() {
		
		return Elements.CLICK(driver, chooseShipped);
		
	}
	
	public Map<Boolean,String> clickDelivered() {
		
		return Elements.CLICK(driver, chooseDelivered);
		
	}
	
	public void refresh()	{
		
		driver.navigate().refresh();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
