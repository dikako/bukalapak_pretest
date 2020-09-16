package function;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import setup.Element;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy.ByAccessibilityId;
import io.appium.java_client.MobileElement;

public class Button {

	AppiumDriver<MobileElement> driver;
	Element root = new Element();

	public Button(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
	}
	
	public void ByAccessIdByIndex(String selector) {
		MobileElement element = driver.findElement(ByAccessibilityId.AccessibilityId(selector));
		element.click();
		System.out.println("Button is Clicked!");
	}
	
	public void ByIdByIndex(String selector, int index) {
		List<MobileElement> element = driver.findElements(By.id(root.element() + ":id/" + selector));
		element.get(index).click();
		System.out.println("Button is Clicked!");
	}

	public void ById(String selector) {
		MobileElement element = driver.findElement(By.id(root.element() + ":id/" + selector));
		waitForVisible(driver, element);
		element.isDisplayed();
		element.click();
		System.out.println("Button is Clicked!");
	}
	
	public void ByIdAndroid(String selector) {
		MobileElement element = driver.findElement(By.id(selector));
		waitForVisible(driver, element);
		element.isDisplayed();
		element.click();
		System.out.println("Button is Clicked!");
	}
	
	public void ByIdSize(String selector, int size) {
		List<MobileElement> element = driver.findElements(By.id(root.element() + ":id/" + selector));
		Assert.assertEquals(element.size(), size);
		System.out.println("Element is Found: " + size);
	}
	
	public void ByIds(String selector, int index) {
		List<MobileElement> element = driver.findElements(By.id(root.element() + ":id/" + selector));
		element.get(index).click();
		System.out.println("Button is Clicked!");
	}
	
	public void ByIdDisplay(String selector, boolean display) {
		MobileElement element = driver.findElement(By.id(root.element() + ":id/" + selector));
		waitForVisible(driver, element);
		boolean actual = element.isDisplayed();
		Assert.assertEquals(actual, display);
		System.out.println("Button is Display " + actual);
	}
	
	public void ByIdEnabled(String selector, boolean enabled) {
		MobileElement element = driver.findElement(By.id(root.element() + ":id/" + selector));
		waitForVisible(driver, element);
		boolean actual = element.isEnabled();
		Assert.assertEquals(actual, enabled);
		System.out.println("Button is Enabled " + actual);
	}

	private void waitForVisible(AppiumDriver<MobileElement> driver, MobileElement element) {
		try {
			Thread.sleep(5000);
			System.out.println("Waiting for element visibility");
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
