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
	
	
	
}
