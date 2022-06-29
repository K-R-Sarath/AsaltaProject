package pageObjects;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import commonMethods.Elements;
import commonMethods.Validations;

public class ReturnInvoiceSalePage {
	
	private WebDriver driver;
	
	public ReturnInvoiceSalePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	@FindBy(how = How.XPATH, using="//table[@id='returnTable']//thead//tr//th//div")
	private WebElement selectItemsForReturn;
	
	@FindBy(how = How.ID, using="add_return")
	private WebElement returnCheckedItems;
	
	@FindBy(how = How.ID, using="cancel")
	private WebElement cancelButton;
	
	@FindBy(how = How.ID, using="add_exchange")
	private WebElement addExchangebutton;
	
	@FindBy(how = How.ID, using="add_exchange_item")
	private WebElement addItemForExchange;
	
	@FindBy(how = How.XPATH, using="//ul[@id='ui-id-1']//li//a")
	private WebElement selectItemForExchange;
	
	@FindBy(how = How.NAME, using="ex_quantity[]")
	private WebElement exchangeItemQuantityField;
	
	@FindBy(how = How.ID, using="ex_amount_paid")
	private WebElement amountForExchangingItem;
	
	
	
	public boolean selectItems()	{
		
		return Validations.ISSELECTED(selectItemsForReturn);
		
	}
	
	public Map<Boolean,String> clickReturnCheckedItemsButton()	{
		
		return Elements.CLICK(driver, returnCheckedItems);
		
	}
	
	public Map<Boolean,String> clickCancelButton()	{
		
		return Elements.CLICK(driver, cancelButton);
		
	}
	
	public Map<Boolean,String> clickAddExchangeButton()	{
		
		return Elements.CLICK(driver, addExchangebutton);
		
	}
	
	public Map<Boolean,String> enterItemForExchange()	{
		
		return Elements.ENTERVALUE(driver, addItemForExchange, "Water Jar");
		
	}
	
	public Map<Boolean,String> selectItemForExchange()	{
		
		return Elements.CLICK(driver, selectItemForExchange);
		
	}
	
	public Map<Boolean,String> enterQtyForExchange()	{
		
		return Elements.ENTERVALUE1(driver, exchangeItemQuantityField, "10000");
		
	}
	
	public Map<Boolean,String> eraseAmount()	{
		
		return Elements.ERASEVALUE(driver, amountForExchangingItem);
		
	}
	
	
	

}
