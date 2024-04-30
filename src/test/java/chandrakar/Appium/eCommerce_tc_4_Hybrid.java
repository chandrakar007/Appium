package chandrakar.Appium;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class eCommerce_tc_4_Hybrid extends BaseTest {

	@Test
	public void Fillform() throws InterruptedException {

		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("chandrakar");

		// to hide KeyBoard
		driver.hideKeyboard();
		driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
		driver.findElement(By.id("android:id/text1")).click();

		driver.findElement(
				AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"));

		driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();

		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();

		driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
		driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();

		// OR
		// driver.findElement(By.xpath("(//android.widget.TextView[@text='ADD TO
		// CART'])[1]")).click();

		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.attributeContains(
				driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")), "text", "Cart"));

		List<WebElement> productPrices = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));
		int count = productPrices.size();
		double totalSum = 0;

		// int productCount =
		// driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).size();
		for (int i = 0; i < count; i++) {

			String amountString = productPrices.get(i).getText();
			// $160.07
			Double price = Double.parseDouble(amountString.substring(1));
			totalSum = totalSum + price;
			System.out.println(totalSum);

		}
		String displaySum = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
		Double displayFormattedSum = getFormatedAmount(displaySum);
		Assert.assertEquals(totalSum, displayFormattedSum);
		
		WebElement ele = driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
		
		//For Long Press
		longPressAction(ele);
		driver.findElement(By.id("android:id/button1")).click();
		driver.findElement(AppiumBy.className("android.widget.CheckBox")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
		Thread.sleep(5000);
		
		//get all context from Native app to WebView
		
		Set<String> contexts=driver.getContextHandles();
		for(String contextName : contexts)
		{
			System.out.println(contextName);
			
		}
	    driver.context("WEBVIEW_com.androidsample.generalstore");
	    //For google search
	    driver.findElement(By.name("q")).sendKeys("Amazon.com");
	   //driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
	    
         driver.pressKey(new KeyEvent(AndroidKey.BACK));
	    
	    driver.context("NATIVE_APP");
	    
		// Hybrid --> Google Page
		
		

	}

}
