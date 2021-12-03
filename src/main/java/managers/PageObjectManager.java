package managers;

import org.openqa.selenium.WebDriver;

import pageObjects.AddDeliveryPage;
import pageObjects.AddPaymentPage;
import pageObjects.CreateQuotationPage;
import pageObjects.DashboardPage;
import pageObjects.DeliveryListPage;
import pageObjects.EditDeliveryPage;
import pageObjects.EditInvoicePage;
import pageObjects.InvoiceCreationPage;
import pageObjects.InvoiceListPage;
import pageObjects.LoginPage;
import pageObjects.QuotationListPage;
import pageObjects.ViewPaymentPage;

public class PageObjectManager {
	
	private WebDriver driver;
	private LoginPage login;
	private DashboardPage dashboard;
	private InvoiceListPage invoice;
	private InvoiceCreationPage invoiceCreation;
	private EditInvoicePage editInvoice;
	private ViewPaymentPage viewPayments;
	private AddPaymentPage addPayments;
	private AddDeliveryPage addDelivery;
	private DeliveryListPage delivery;
	private EditDeliveryPage editDelivery;
	private CreateQuotationPage createQuotation;
	private QuotationListPage quotation;
	
	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}

	public LoginPage getLoginPage(){
		return (login == null) ? login = new LoginPage(driver) : login;
	}

	public DashboardPage getDashboardPage() {
		return (dashboard == null) ? dashboard = new DashboardPage(driver) : dashboard;
	}

	public InvoiceListPage getInvoiceListPage() {
		return (invoice == null) ? invoice = new InvoiceListPage(driver) : invoice;
	}

	public InvoiceCreationPage getInvoiceCreationPage() {
		return (invoiceCreation == null) ? invoiceCreation = new InvoiceCreationPage(driver) : invoiceCreation;
	}
	
	public EditInvoicePage getEditInvoicePage()	{
		return (editInvoice == null) ? editInvoice = new EditInvoicePage(driver) : editInvoice;
	}
	
	public ViewPaymentPage getViewPaymentPage()	{
		return (viewPayments == null) ? viewPayments = new ViewPaymentPage(driver) : viewPayments;
	}
	
	public AddPaymentPage getAddPaymentPage()	{
		return (addPayments == null) ? addPayments = new AddPaymentPage(driver) : addPayments;
	}
	
	public AddDeliveryPage getAddDeliveryPage()	{
		return (addDelivery == null) ? addDelivery = new AddDeliveryPage(driver) : addDelivery;
	}
	
	public DeliveryListPage getDeliveryListPage()	{
		return (delivery == null) ? delivery = new DeliveryListPage(driver) : delivery;
	}
	
	public EditDeliveryPage getEditDeliveryPage()	{
		return (editDelivery == null) ? editDelivery = new EditDeliveryPage(driver) : editDelivery;
	}
	
	public CreateQuotationPage getCreateQuotationPage()	{
		return (createQuotation == null) ? createQuotation = new CreateQuotationPage(driver) : createQuotation;
	}
	
	public QuotationListPage getQuotationListPage()	{
		return (quotation == null) ? quotation = new QuotationListPage(driver) : quotation;
	}

}
