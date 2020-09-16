package function;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import setup.Element;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Input {
	AppiumDriver<MobileElement> driver;
	Element root = new Element();

	public Input(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	public void ById(String selector, String textValue) {
		MobileElement element = driver.findElement(By.id(root.element() + ":id/" + selector));
		waitForVisible(driver, element);
		element.isDisplayed();
		element.click();
		element.sendKeys(textValue);
		System.out.println("Input: " + textValue);
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
