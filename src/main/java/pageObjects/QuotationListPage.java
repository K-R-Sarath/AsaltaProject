package pageObjects;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import commonMethods.Elements;

public class QuotationListPage {
	
	private WebDriver driver;
	
	public QuotationListPage(WebDriver driver)	{
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	@FindBy(how = How.XPATH, using="//div[@class='col-md-12 text-right']//a")
	private WebElement clickNewQuotationButton;
	
	
	public Map<Boolean,String> clickNewQuotationButton()	{
		
		return Elements.CLICK(driver, clickNewQuotationButton);
		
	}

}
