package pageObjects;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import commonMethods.Elements;
import commonMethods.Scrolling;

public class CreateSaleOrderPage {
	
	private WebDriver driver;
	
	public CreateSaleOrderPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	
	@FindBy(how = How.XPATH, using="//div[@id='s2id_sorcustomer']//a//span[@class='select2-chosen']")
	private WebElement clickCustomerField;
	
	@FindBy(how = How.XPATH, using = "//div[@id='select2-drop']//div[@class='select2-search']//input")
	private WebElement enterCustName;
	
	@FindBy(how = How.XPATH, using = "//ul[@class='select2-results']//li")
	private List<WebElement> selectCust;
	
	@FindBy(how = How.ID, using="add_saleorder")
	private WebElement saveSaleOrderButton;
	
	@FindBy(how = How.ID, using="sordiscount")
	private WebElement discount;
	
	@FindBy(how = How.XPATH, using="//table[@id='sorTable']//th[contains(text(),'Discount')]")
	private WebElement clickOutOfDisc;
	
	@FindBy(how = How.XPATH, using="//tr[@id='tfoot']//th[@class='text-right']")
	private List<WebElement> discAmount;
	
	@FindBy(how = How.XPATH, using="//button[contains(text(),'OK')]")
	private WebElement clickOK;
	
	@FindBy(how = How.XPATH, using="//button[@class='close']")
	private List<WebElement> closeCustomFieldPopup;
	
	@FindBy(how = How.ID, using="chck")
	private WebElement closeAddNewCustomerPopup;
	
	@FindBy(how = How.XPATH, using="//div[@id='s2id_sorcustomer']//a//span[@class='select2-chosen']")
	private WebElement scrollBackToCustField;
	
	@FindBy(how = How.ID, using="document")
	private WebElement attachDocument;
	
	public Map<Boolean,String> clickCustomerField()	{
		
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
				selectCustomer = Elements.CLICK(driver, element);
				break;
			}
		}
		return selectCustomer;
	}
	
	public Map<Boolean,String> clickSaveSaleOrderButton()	{
		
		return Elements.CLICK(driver, saveSaleOrderButton);
		
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
	
	public Long amount()	{
		long amount;
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
	    
	    amount = add + 1;
		return amount;
	}
	
	public Map<Boolean,String> enterDiscount()	{
		
		return Elements.ENTERVALUE(driver, discount, Long.toString(amount()));
		
	}
	
	public Map<Boolean,String> clickOutOfDiscount()	{
		
		return Elements.CLICK(driver, clickOutOfDisc);
		
	}
	
	public Map<Boolean,String> clickOKinBootbox()	{
		
		return Elements.CLICK(driver, clickOK);
		
	}
	
	public Map<Boolean,String> closeCustomfieldPopup() throws Exception	{
		Map<Boolean,String> closeCustom = null;
		
		for(int i=closeCustomFieldPopup.size()-1;i>=0;i--)	{
			if(i==4){
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
	
	public void scroll1()	{
		Scrolling.SCROLLINTOVIEW(driver, scrollBackToCustField);
	}
	
	public String afterReset()	{
		String value = scrollBackToCustField.getText();
		return value;
	}
	
	public Map<Boolean,String> attachFile()	{
		
		return Elements.UPLOADFILE(driver, attachDocument, "F:\\document_attach.docx");
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
