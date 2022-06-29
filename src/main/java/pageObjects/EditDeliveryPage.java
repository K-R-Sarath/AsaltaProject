package pageObjects;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import commonMethods.Elements;
import commonMethods.Scrolling;
import commonMethods.Validations;

public class EditDeliveryPage {
	
	private WebDriver driver;
	
	public EditDeliveryPage(WebDriver driver)	{
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	@FindBy(how = How.NAME, using="edit_delivery")
	private WebElement saveDeliveryButton;
	
	@FindBy(how = How.ID, using="select2-chosen-6")
	private WebElement clickDeliveryStatus;
	
	@FindBy(how = How.XPATH, using="//div[@id='select2-drop']//ul//li[2]")
	private WebElement choosePackedStatus;
	
	@FindBy(how = How.XPATH, using="//div[@class='col-md-6 form-group']")
	private List<WebElement> Packed;
	
	@FindBy(how = How.XPATH, using="//div[@id='select2-drop']//ul//li")
	private List<WebElement> chooseStatus;
	
	@FindBy(how = How.NAME, using="edit_delivery")
	private WebElement editDeliveryButton;
	
	@FindBy(how = How.XPATH, using="//div[@class='toast-message']//p[1]")
	private WebElement alertMsg1;
	
	@FindBy(how = How.XPATH, using="//ul[@class='breadcrumb']//li[3]")
	private WebElement breadCrumb;
	
	
	public void scrollToDeliveryStatus()	{
		Scrolling.SCROLLINTOVIEW(driver, saveDeliveryButton);
	}
	
	public Map<Boolean,String> clickDeliveryStatus()	{
		
		return Elements.CLICK(driver, clickDeliveryStatus);
		
	}
	
	public Map<Boolean,String> clickPackedStatus()	{
		
		return Elements.CLICK(driver, choosePackedStatus);
		
	}
	
		
	public boolean pack()	{
		
		boolean packIsPresent = false;
		
		for(int i=0;i<Packed.size();i++)	{
			if(i==9 || i==10) {
				WebElement element = Packed.get(i);
				packIsPresent = Validations.IFELEMENTPRESENT(element);
				System.out.println(packIsPresent);
				if(packIsPresent == false) {
					break;
				}
				break;
			}
		}
		return packIsPresent;
	}
	
	public Map<Boolean,String> clickSaveDeliveryButton()	{
		
		return Elements.CLICK(driver, saveDeliveryButton);
		
	}

	public Map<Boolean, String> clickReadyToShipStatus() {
		Map<Boolean,String> ReadyToShip = null;
		for(int i=0;i<chooseStatus.size();i++)	{
			if(i==2) {
				WebElement element = chooseStatus.get(i);
				ReadyToShip = Elements.CLICK(driver, element);
				break;
			}
		}
		return ReadyToShip;
	}
	
	public Map<Boolean,String> clickShippedStatus()	{
		Map<Boolean,String> Shipped = null;
		for(int i=0;i<chooseStatus.size();i++)	{
			if(i==3) {
				WebElement element = chooseStatus.get(i);
				Shipped = Elements.CLICK(driver, element);
				break;
			}
		}
		return Shipped;
	}
	
	public Map<Boolean,String> clickOnHoldStatus()	{
		Map<Boolean,String> OnHold = null;
		for(int i=0;i<chooseStatus.size();i++)	{
			if(i==4) {
				WebElement element = chooseStatus.get(i);
				OnHold = Elements.CLICK(driver, element);
				break;
			}
		}
		return OnHold;
	}
	
	public Map<Boolean,String> clickCancelledStatus()	{
		Map<Boolean,String> Cancelled = null;
		for(int i=0;i<chooseStatus.size();i++)	{
			if(i==5) {
				WebElement element = chooseStatus.get(i);
				Cancelled = Elements.CLICK(driver, element);
				break;
			}
		}
		return Cancelled;
	}
	
	public Map<Boolean,String> clickDeliveredStatus()	{
		Map<Boolean,String> Delivered = null;
		for(int i=0;i<chooseStatus.size();i++)	{
			if(i==6) {
				WebElement element = chooseStatus.get(i);
				Delivered = Elements.CLICK(driver, element);
				break;
			}
		}
		return Delivered;
	}
	
	public Map<Boolean,String> clickEditDeliveryButton()	{
		
		return Elements.CLICK(driver, editDeliveryButton);
		
	}
	
	public String alertMessage1()	{
		String alertMess1 = alertMsg1.getText();
		return alertMess1;
	}
	
	public String verifyEditPage() {
		
		return breadCrumb.getText();
		
	}
	

}
