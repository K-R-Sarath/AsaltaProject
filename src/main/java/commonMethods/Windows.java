package commonMethods;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Windows {
	
	public static Map<Boolean, String> REFRESHPAGE(WebDriver driver) {
		Map<Boolean,String> kywdResult = new HashMap<Boolean,String>();
		try {
			driver.navigate().refresh();
			kywdResult.put(true, "REFRESHPAGE");
		} catch (Exception e) {
			kywdResult.put(false, e.toString());
		}
		return kywdResult;
	}
	
	public static Map<Boolean,String> FOCUSWINDOW(WebDriver driver)	{
		Map<Boolean,String> kywdResult = new HashMap<Boolean,String>();
		try {
		String parentTab = driver.getWindowHandle();
		Set<String> childTab = driver.getWindowHandles();
		for(String newTab : childTab)	{
			if(!newTab.equalsIgnoreCase(parentTab)) {
				driver.switchTo().window(newTab);
			}
		}
		kywdResult.put(true, "FOCUSWINDOW");
		} catch(Exception e)	{
			kywdResult.put(false, e.toString());
		}
		return kywdResult;
	}
	
	public static Map<Boolean,String> SWITCHTOPARENTWINDOW(WebDriver driver) {
		Map<Boolean,String> kywdResult = new HashMap<Boolean,String>();
		try {
			String tab = driver.getWindowHandle();
			driver.switchTo().window(tab).close();
			kywdResult.put(true, "TABCLOSED");
		} catch(Exception e) {
			kywdResult.put(false, e.toString());
		}
		return kywdResult;
	}
	
	public static Map<Boolean,String> SWITCHTOIFRAME(WebDriver driver, WebElement element) {
		Map<Boolean,String> kywdResult = new HashMap<Boolean,String>();
		try {
			driver.switchTo().frame(element);
			kywdResult.put(true, "SWITCHED TO IFRAME");
		} catch(Exception e) {
			kywdResult.put(false, e.toString());
		}
		return kywdResult;
	}
	

}
