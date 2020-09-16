package function;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import setup.Element;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.MobileBy.ByAccessibilityId;

public class Alert {
	AppiumDriver<MobileElement> driver;
	Element elements = new Element();

	public Alert(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
	}
	
	public void ByAccessIdByIndex(String selector, String attr, String attrValue) {
		MobileElement element = driver.findElement(ByAccessibilityId.AccessibilityId(selector));
		waitForVisible(driver, element);
		Assert.assertEquals(element.getAttribute(attr).toString().toLowerCase().replace(" ", ""), attrValue.toString().toLowerCase().replace(" ", ""));
		System.out.println(element.getAttribute(attr).toString());
	}
	
	public void ByClassByIndex(String selector, int index, String textAlert) {
		List<MobileElement> element = driver.findElements(By.className(selector));
		String actual = element.get(index).getText();
		Assert.assertEquals(actual.replace(" ", "").replace("\n", "").toLowerCase(), textAlert.replace(" ", "").replace("\n", "").toLowerCase());
		System.out.println("Alert: " + actual);
	}
	
	public void ByTagByIndex(String selector, int index, String textAlert) {
		List<MobileElement> element = driver.findElements(By.tagName(selector));
		String actual = element.get(index).getText();
		Assert.assertEquals(actual.replace(" ", "").replace("\n", "").toLowerCase(), textAlert.replace(" ", "").replace("\n", "").toLowerCase());
		System.out.println("Alert: " + actual);
	}
	
	public void ByXpathByIndex(String selector, int index, String textAlert) {
		List<MobileElement> element = driver.findElements(By.xpath(selector));
		String actual = element.get(index).getText();
		Assert.assertEquals(actual.replace(" ", "").replace("\n", "").toLowerCase(), textAlert.replace(" ", "").replace("\n", "").toLowerCase());
		System.out.println("Alert: " + actual);
	}
	
	public void ByXpath(String selector, String textAlert) {
		MobileElement element = driver.findElement(By.xpath(selector));
		waitForVisible(driver, element);
		element.isDisplayed();
		String actual = element.getText();
		Assert.assertEquals(actual.replace(" ", "").replace("\n", "").toLowerCase(), textAlert.replace(" ", "").replace("\n", "").toLowerCase());
		System.out.println("Alert: " + actual);
	}

	public void ById(String selector, String textAlert) {
		MobileElement element = driver.findElement(By.id(elements.element() + ":id/" + selector));
		waitForVisible(driver, element);
		element.isDisplayed();
		String actual = element.getText();
		Assert.assertEquals(actual.replace(" ", "").replace("\n", "").toLowerCase(), textAlert.replace(" ", "").replace("\n", "").toLowerCase());
		System.out.println("Alert: " + actual);
	}
	
	public void ByIdByIndex(String selector, int index, String textAlert) {
		List<MobileElement> element = driver.findElements(By.id(elements.element() + ":id/" + selector));
		String actual = element.get(index).getText();
		Assert.assertEquals(actual.replace(" ", "").replace("\n", "").toLowerCase(), textAlert.replace(" ", "").replace("\n", "").toLowerCase());
		System.out.println("Alert: " + actual);
	}
	
	public void ByIdLastIndex(String selector, String textAlert) {
		List<MobileElement> element = driver.findElements(By.id(elements.element() + ":id/" + selector));
		int sz = element.size() - 1;
		
		for (int i = sz; i == sz; i++) {
			Assert.assertEquals(element.get(i).getText().toLowerCase().replace(" ", ""), textAlert.toLowerCase().replace(" ", ""));		
			System.out.println("Chat is Match!");
		}
	}
	
	public void ByIdNotNull(String selector) {
		List<MobileElement> element = driver.findElements(By.id(elements.element() + ":id/" + selector));
		Assert.assertEquals(element.size(), 1);
		System.out.println("Element is Found " + element.size());
	}
	
	public void ByIdAndroidNotNull(String selector) {
		List<MobileElement> element = driver.findElements(By.id(selector));
		Assert.assertEquals(element.size(), 1);
		System.out.println("Element is Found " + element.size());
	}
	
	public void ByIdSize(String selector, int size) {
		List<MobileElement> element = driver.findElements(By.id(elements.element() + ":id/" + selector));
		Assert.assertEquals(element.size(), size);
		System.out.println("Element Count: " + element.size());
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
