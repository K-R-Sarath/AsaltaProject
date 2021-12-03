package commonMethods;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class Validations {
	
	public static Map<Boolean, String> VERIFYOBJECT(WebDriver driver,WebElement element) {
		Map<Boolean,String> kywdResult = new HashMap<Boolean,String>();
		try {
			WaitConditions.WAITFORELEMENT(driver, element).isDisplayed();
			kywdResult.put(true, "VERIFYOBJECT");
		} catch (Exception e) {
			kywdResult.put(false, e.toString());
		}
		return kywdResult;
	}
	
	public static Map<Boolean, String> VERIFYOBJECT(WebDriver driver,By by) {
		Map<Boolean,String> kywdResult = new HashMap<Boolean,String>();
		try {
			WaitConditions.WAITFORELEMENT(driver, by).isDisplayed();
			kywdResult.put(true, "VERIFYOBJECT");
		} catch (Exception e) {
			kywdResult.put(false, e.toString());
		}
		return kywdResult;
	}
	
	
	public static boolean ISSELECTED(WebElement element) {
		boolean kywdResult = false;
		try {
			if (!element.isSelected()) {
				element.click();
				kywdResult = true;
			}
		} catch (Exception e) {
			kywdResult = false;
		}
		return kywdResult;
	}
	
	public static boolean IFELEMENTPRESENT(WebElement element) {
		boolean kywdResult = false;
		try {
			element.isDisplayed();
			kywdResult = true;
		} catch (NoSuchElementException e) {
			kywdResult = false;
		}
		return kywdResult;
	}

}
