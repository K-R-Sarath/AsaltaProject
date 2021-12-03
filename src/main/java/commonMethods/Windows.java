package commonMethods;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.WebDriver;

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
	
	

}
