package setup;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class Dropdown {
	
	AppiumDriver<MobileElement> driver;
	Element root = new Element();

	public Dropdown(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
	}
	
	public void dropdownById(String selector,String text) {
		MobileElement element = driver.findElement(By.id(root.element() + ":id/" + selector));
		waitForVisible(driver, element);
		Select selectDropdown = new Select(element);
		selectDropdown.selectByVisibleText(text);
		System.out.println("Dropdown Selected: " + text);
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
