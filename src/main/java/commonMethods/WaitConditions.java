package commonMethods;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import managers.FileReaderManager;


public class WaitConditions {
	
	public static WebElement WAITFORELEMENT(WebDriver driver, WebElement element) {
		try {
			long WaitTime = FileReaderManager.getInstance().getConfigReader().getObjectWait();
			element = new WebDriverWait(driver, WaitTime).until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			e.printStackTrace();	
		} 
		return element;
	}
	
	public static WebElement WAITFORELEMENT(WebDriver driver, By by) {
		WebElement element =null;
		try {
			long WaitTime = FileReaderManager.getInstance().getConfigReader().getObjectWait();
			element = new WebDriverWait(driver, WaitTime).until(ExpectedConditions.visibilityOfElementLocated(by));
		} catch (Exception e) {
			throw(e);
		} 
		return element;
	}
	
	public static List<WebElement> WAITFORALLELEMENTS(WebDriver driver, List<WebElement> elements)	{
		try {
			long WaitTime = FileReaderManager.getInstance().getConfigReader().getObjectWait();
			elements = new WebDriverWait(driver, WaitTime).until(ExpectedConditions.visibilityOfAllElements(elements));
		} catch (Exception e) {
			throw(e);
		}
		return elements;
	}

}
