package commonMethods;

import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Elements {
	
	public static Map<Boolean, String> CLICK(WebDriver driver, WebElement element) {
		Map<Boolean,String> kywdResult = new HashMap<>();
		try {
			Validations.VERIFYOBJECT(driver, element);
			element.click();
			kywdResult.put(true, "Element Clicked");
		} catch (Exception e) {
			kywdResult.put(false, e.toString());
		} 
		return kywdResult;
	}
	
	public static Map<Boolean, String> CLICK(WebDriver driver, By by) {
		Map<Boolean,String> kywdResult = new HashMap<>();
		try {
			Validations.VERIFYOBJECT(driver, by);
			driver.findElement(by).click();
			kywdResult.put(true, "Element Located");
		} catch (Exception e) {
			kywdResult.put(false, e.toString());
		} 
		return kywdResult;
	}
	
	public static Map<Boolean, String> ENTERVALUE(WebDriver driver, WebElement element, String sValue) {
		Map<Boolean,String> kywdResult = new HashMap<Boolean,String>();
		try {
			Validations.VERIFYOBJECT(driver, element);
			element.click();
			element.clear();
			element.click();
			element.sendKeys(sValue);
			Thread.sleep(1000);
			kywdResult.put(true, sValue);
		} catch (Exception e) {
			kywdResult.put(false, e.toString());
		}
		return kywdResult;
	}
	
	public static Map<Boolean, String> ENTERVALUE1(WebDriver driver, WebElement element, String sValue) {
		Map<Boolean,String> kywdResult = new HashMap<Boolean,String>();
		try {
			Validations.VERIFYOBJECT(driver, element);
			element.click();
			element.sendKeys(Keys.BACK_SPACE);
			element.click();
			element.sendKeys(sValue);
			Thread.sleep(1000);
			kywdResult.put(true, sValue);
		} catch (Exception e) {
			kywdResult.put(false, e.toString());
		}
		return kywdResult;
	}
	
	public static Map<Boolean, String> ERASEVALUE(WebDriver driver, WebElement element)	{
		Map<Boolean,String> kywdResult = new HashMap<Boolean,String>();
		try	{
			Validations.VERIFYOBJECT(driver, element);
			element.click();
			element.sendKeys(Keys.CONTROL+"A");
			element.sendKeys(Keys.BACK_SPACE);
			Thread.sleep(1000);
			kywdResult.put(true, "Value Erased");
		} catch (Exception e) {
			kywdResult.put(false, e.toString());
		} 
		return kywdResult;
		
	}
	
	public static Map<Boolean, String> CTRLAWITHDELETE(WebDriver driver, WebElement element) {
		Map<Boolean,String> kywdResult = new HashMap<Boolean,String>();
		try {
			Validations.VERIFYOBJECT(driver, element);
			Thread.sleep(2000);
			element.click();
			element.sendKeys(Keys.CONTROL+"A");
			element.sendKeys(Keys.DELETE);
			element.click();
			kywdResult.put(true, "Passed");
		} catch (Exception e) {
			kywdResult.put(false, e.toString());
		}
		return kywdResult;
	}
	
	
	public static Map<Boolean, String> UPLOADFILE(WebDriver driver, WebElement element, String sValue) {
		Map<Boolean,String> kywdResult = new HashMap<Boolean,String>();
		try {
			element.sendKeys(sValue);
			Thread.sleep(1000);
			kywdResult.put(true, sValue);
		} catch (Exception e) {
			kywdResult.put(false, e.toString());
		}
		return kywdResult;
	}
	
	
	public static Map<Boolean, String> MOUSECLICK(WebDriver driver, WebElement element) {
		Map<Boolean,String> kywdResult = new HashMap<Boolean,String>();
		try {
			Actions actions = new Actions(driver);
			actions.moveToElement(element).click(element).build().perform();
			kywdResult.put(true, "Element MOUSEHOVERED");
		} catch (Exception e) {
			kywdResult.put(false, e.toString());
		}
		return kywdResult;
	}
	
	
	

}
