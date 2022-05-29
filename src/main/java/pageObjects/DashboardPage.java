package pageObjects;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import commonMethods.Elements;
import commonMethods.Validations;

public class DashboardPage {
	
	private WebDriver driver;
	
	public DashboardPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	@FindBy(how = How.XPATH, using = "//div[@id='sidebar_menu']//ul//li[@class='mm_sales mm_quotes mm_saleorders mm_pos']//a")
	private WebElement clickSalesInSideMenu;
	
	@FindBy(how = How.ID, using = "sales_index")
	private WebElement clickInvoice;
	
	@FindBy(how = How.ID, using = "quotes_index")
	private WebElement clickQuotations;
	
	@FindBy(how = How.XPATH, using = "//div[@id='sidebar_menu']//ul//li[@id='mm_deliveries']//a")
	private WebElement clickDeliveriesInSideMenu;
	
	@FindBy(how = How.XPATH, using="//a[@data-title='Dashboard Widgets']")
	private WebElement dashboardWidgetIcon;
	
	@FindBy(how = How.XPATH, using="//div[@id='sidebar_menu']//ul//li[@class='mm_products mm_bundleproduct vv_warehouses mm_pricebook']")
	private WebElement clickInventoryInSideMenu;
	
	@FindBy(how = How.ID, using="products_index")
	private WebElement clickItems;
	
	@FindBy(how = How.ID, using="dtFilter-filter--PRData-4")
	private WebElement searchItem;
	
	
	
	
	public Map<Boolean,String> clickSalesInSideMenu() {

		return Elements.CLICK(driver, clickSalesInSideMenu);
		
	}
	
	public Map<Boolean,String> clickInvoice() {

		return Elements.CLICK(driver, clickInvoice);
		
	}
	
	public Map<Boolean,String> clickDeliveriesInSideMenu()	{
		
		return Elements.CLICK(driver, clickDeliveriesInSideMenu);
		
	}
	
	public Map<Boolean,String> clickQuotations() {
		
		return Elements.CLICK(driver, clickQuotations);
		
	}
	
	public boolean verifyDashboard()	{
		
		return Validations.IFELEMENTPRESENT(dashboardWidgetIcon);
		
	}
	
	public Map<Boolean,String> clickInventoryInSideMenu()	{
		
		return Elements.CLICK(driver, clickInventoryInSideMenu);
		
	}
	
	public Map<Boolean,String> clickItems()	{
		
		return Elements.CLICK(driver, clickItems);
		
	}
	
	
	
	

}
