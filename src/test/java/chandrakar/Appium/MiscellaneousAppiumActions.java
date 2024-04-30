package chandrakar.Appium;

import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class MiscellaneousAppiumActions extends BaseTest {

	@Test
	public void miscellaneous() {

		// Automation code
		// xpath, id, accessibilityId, classname, androidUIAutomator
		//tagName[@attribute='value']
		
		//App Package and App Activity-->To jump directly on any mobile page
		//adb shell dumpsys window | find "mCurrentFocus"   ->Windows 
		
		Activity activity = new Activity("io.appium.android.apis", "io.appium.android.apis.preference.PreferenceDependencies");

		((JavascriptExecutor) driver).executeScript("mobile: startActivity",
				ImmutableMap.of("intent", "io.appium.android.apis/io.appium.android.apis.preference.PreferenceDependencies"));
    
		//Below two line get skipped due to use of activity    
	//	driver.findElement(AppiumBy.accessibilityId("Preference")).click();
	//	driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
		
        driver.findElement(By.id("android:id/checkbox")).click();
        
        //Mobile Rotation
        DeviceRotation landScape= new DeviceRotation(0, 0, 90);
        driver.rotate(landScape);
        
        driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
        
        String actTitle=driver.findElement(By.id("android:id/alertTitle")).getText();
        Assert.assertEquals(actTitle, "WiFi settings");
       
        // Copy paste
        //copy to clip board- paste it clip board
        driver.setClipboardText("Chandrakar Wifi");
        //driver.findElement(By.id("android:id/edit")).sendKeys("Chandrakar Wifi");
        
        driver.findElement(By.id("android:id/edit")).sendKeys(driver.getClipboardText());
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
        driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();
        
        //To press mobile Keys
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        driver.pressKey(new KeyEvent(AndroidKey.HOME));
        
        
	}
}
