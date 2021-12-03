package pageObjects;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import commonMethods.Elements;
import commonMethods.Scrolling;
import commonMethods.Windows;

public class AddDeliveryPage {
	
	private WebDriver driver;
	
	public AddDeliveryPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	@FindBy(how = How.NAME, using="add_delivery")
	private WebElement saveDeliveryButton;
	
	public Map<Boolean,String> clickSaveDelivery()	{
		
		return Elements.CLICK(driver, saveDeliveryButton);
		
	}
	
	public Map<Boolean,String> switchToNewWindow()	{
		
		return Windows.FOCUSWINDOW(driver);
		
	}
	
	public void scrollToDeliveryStatus()	{
		Scrolling.SCROLLINTOVIEW(driver, saveDeliveryButton);
	}

}
