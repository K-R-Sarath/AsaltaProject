package pageObjects;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import commonMethods.Elements;

public class EditSaleOrderPage {
	
	private WebDriver driver;
	
	public EditSaleOrderPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	@FindBy(how = How.ID, using="edit_saleorder")
	private WebElement editSaleOrder;
	
	@FindBy(how = How.ID, using="sorref")
	private WebElement saleOrderNO;
	
	
	
	public Map<Boolean,String> clickEditSaleButton()	{
		
		return Elements.CLICK(driver, editSaleOrder);
		
	}
	
	public Map<Boolean,String> duplicateSaleOrderNo()	{
		
		return Elements.ENTERVALUE(driver, saleOrderNO, "SO2022060322");
		
	}
	
	
	
	

}
