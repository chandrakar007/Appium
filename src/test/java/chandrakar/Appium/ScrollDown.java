package chandrakar.Appium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;

public class ScrollDown extends BaseTest {

	@Test
	public void ScrollDownTest() throws InterruptedException {

		// Automation code
		// xpath, id, accessibilityId, classname, androidUIAutomator
		// tagName[@attribute='value']

		driver.findElement(AppiumBy.accessibilityId("Views")).click();

		// Where to scroll is known prior
    //  driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));"));

		// No prior idea
		scrollToEndAction();

		Thread.sleep(2000);

	}
}
