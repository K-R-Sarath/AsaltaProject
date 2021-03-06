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

public class CreateQuotationPage {
	
	private WebDriver driver;
	
	public CreateQuotationPage(WebDriver driver)	{
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	@FindBy(how = How.ID, using="select2-chosen-8")
	private WebElement chooseCustomer;
	
	@FindBy(how = How.ID, using="s2id_autogen8_search")
	private WebElement enterCustName;
	
	@FindBy(how = How.XPATH, using="//ul[@id='select2-results-8']//li")
	private WebElement selectCust;
	
	@FindBy(how = How.ID, using="search_items-selectized")
	private WebElement searchItem;
	
	@FindBy(how = How.XPATH, using="//div[@class='selectize-dropdown-content']//div[@class='row']")
	private List<WebElement> selectItem;
	
	@FindBy(how = How.ID, using="add_quote")
	private WebElement saveQuoteButton;
	
	@FindBy(how = How.XPATH, using="//div[@class='bootbox-body']")
	private WebElement message;
	
	@FindBy(how = How.NAME, using="quantity[]")
	private WebElement quantity;
	
	@FindBy(how = How.XPATH, using="//table[@id='quTable']//thead/tr/th")
	private List<WebElement> clickOut;
	
	
	public Map<Boolean,String> clickCustomer()	{
		
		return Elements.CLICK(driver, chooseCustomer);
		
	}
	
	public Map<Boolean,String> enterCust()	{
		
		return Elements.ENTERVALUE(driver, enterCustName, "Walk");
		
	}
	
	public Map<Boolean,String> selectCustomer()	{
		
		return Elements.CLICK(driver, selectCust);
		
	}
	
	public Map<Boolean,String> searchItem()	{
		
		return Elements.ENTERVALUE(driver, searchItem, "men silver");
		
	}
	
	public Map<Boolean,String> selectItem()	{
		Map<Boolean,String> item = null;
		
		for(int i=0;i<selectItem.size();i++) {
			if(i==1) {
				WebElement element = selectItem.get(i);
				item = Elements.CLICK(driver, element);
				break;
			}
		}
		return item;	
	}
	
	public void scroll()	{
		Scrolling.SCROLLINTOVIEW(driver, saveQuoteButton);
	}
	
	public Map<Boolean,String> clickSaveQuote()	{
		
		return Elements.CLICK(driver, saveQuoteButton);
		
	}
	
	public String message()	 {
		String msg = message.getText();
		return msg;
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
	

}
