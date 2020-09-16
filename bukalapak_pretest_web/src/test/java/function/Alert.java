package function;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Alert {
	WebDriver driver;

	public Alert(WebDriver driver) {
		this.driver = driver;
	}

	public void byId(String selector, String alertText) {
		WebElement element = driver.findElement(By.id(selector));
		waitForVisible(driver, element);
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		Assert.assertEquals(element.getText().toLowerCase().replace(" ", "").replace("\n", "").replace("\n", ""),
				alertText.toLowerCase().replace(" ", "").replace("\n", "").replace("\n", ""));
		actions.build().perform();
		System.out.println(element.getText());
	}

	public void byClass(String selector, String alertText) {
		WebElement element = driver.findElement(By.className(selector));
		waitForVisible(driver, element);
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		Assert.assertEquals(element.getText().toLowerCase().replace(" ", "").replace("\n", "").replace("\n", ""),
				alertText.toLowerCase().replace(" ", "").replace("\n", "").replace("\n", ""));
		actions.build().perform();
		System.out.println(element.getText());
	}

	public void byXpath(String selector, String alertText) {
		WebElement element = driver.findElement(By.xpath(selector));
		waitForVisible(driver, element);
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		Assert.assertEquals(element.getText().toLowerCase().replace(" ", "").replace("\n", ""),
				alertText.toLowerCase().replace(" ", "").replace("\n", ""));
		actions.build().perform();
		System.out.println(element.getText());
	}

	public void byCss(String selector, String alertText) {
		WebElement element = driver.findElement(By.cssSelector(selector));
		waitForVisible(driver, element);
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		Assert.assertEquals(element.getText().toLowerCase().replace(" ", "").replace("\n", ""),
				alertText.toLowerCase().replace(" ", "").replace("\n", ""));
		actions.build().perform();
		System.out.println(element.getText());
	}

	public void bytagName(String selector, String alertText) {
		WebElement element = driver.findElement(By.tagName(selector));
		waitForVisible(driver, element);
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		Assert.assertEquals(element.getText().toLowerCase().replace(" ", "").replace("\n", ""),
				alertText.toLowerCase().replace(" ", "").replace("\n", ""));
		actions.build().perform();
		System.out.println(element.getText());
	}

	public void byLinkText(String selector, String alertText) {
		WebElement element = driver.findElement(By.linkText(selector));
		waitForVisible(driver, element);
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		Assert.assertEquals(element.getText().toLowerCase().replace(" ", "").replace("\n", ""),
				alertText.toLowerCase().replace(" ", "").replace("\n", ""));
		actions.build().perform();
		System.out.println(element.getText());
	}

	public void byName(String selector, String alertText) {
		WebElement element = driver.findElement(By.name(selector));
		waitForVisible(driver, element);
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		Assert.assertEquals(element.getText().toLowerCase().replace(" ", "").replace("\n", ""),
				alertText.toLowerCase().replace(" ", "").replace("\n", ""));
		actions.build().perform();
		System.out.println(element.getText());
	}

	// Display

	public void byIdDisplay(String selector, boolean display) {
		WebElement element = driver.findElement(By.id(selector));
		waitForVisible(driver, element);
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		Assert.assertEquals(element.isDisplayed(), display);
		actions.build().perform();
		System.out.println("Alert is Display");
	}

	public void byXpathDisplay(String selector, boolean display) {
		WebElement element = driver.findElement(By.xpath(selector));
		waitForVisible(driver, element);
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		Assert.assertEquals(element.isDisplayed(), display);
		actions.build().perform();
		System.out.println("Alert is Display");
	}

	public void byNameDisplay(String selector, boolean display) {
		WebElement element = driver.findElement(By.name(selector));
		waitForVisible(driver, element);
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		Assert.assertEquals(element.isDisplayed(), display);
		actions.build().perform();
		System.out.println("Alert is Display");
	}

	public void byCssDisplay(String selector, boolean display) {
		WebElement element = driver.findElement(By.cssSelector(selector));
		waitForVisible(driver, element);
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		Assert.assertEquals(element.isDisplayed(), display);
		actions.build().perform();
		System.out.println("Alert is Display");
	}

	public void byTagDisplay(String selector, boolean display) {
		WebElement element = driver.findElement(By.tagName(selector));
		waitForVisible(driver, element);
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		Assert.assertEquals(element.isDisplayed(), display);
		actions.build().perform();
		System.out.println("Alert is Display");
	}

	public void byClassDisplay(String selector, boolean display) {
		WebElement element = driver.findElement(By.className(selector));
		waitForVisible(driver, element);
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		Assert.assertEquals(element.isDisplayed(), display);
		actions.build().perform();
		System.out.println("Alert is Display");
	}

	// Get Text
	
	public void byIdGetText(String selector) {
		WebElement element = driver.findElement(By.id(selector));
		waitForVisible(driver, element);
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		String text = element.getText();
		actions.build().perform();
		System.out.println("Text : " + text);
	}
	
	public void byXpathGetText(String selector) {
		WebElement element = driver.findElement(By.xpath(selector));
		waitForVisible(driver, element);
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		String text = element.getText();
		actions.build().perform();
		System.out.println("Text : " + text);
	}
	
	public void byClassGetText(String selector) {
		WebElement element = driver.findElement(By.id(selector));
		waitForVisible(driver, element);
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		String text = element.getText();
		actions.build().perform();
		System.out.println("Text : " + text);
	}
	
	public void byTagGetText(String selector) {
		WebElement element = driver.findElement(By.id(selector));
		waitForVisible(driver, element);
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		String text = element.getText();
		actions.build().perform();
		System.out.println("Text : " + text);
	}
	
	public void byLinkTextGetText(String selector) {
		WebElement element = driver.findElement(By.id(selector));
		waitForVisible(driver, element);
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		String text = element.getText();
		actions.build().perform();
		System.out.println("Text : " + text);
	}
	
	public void byCssGetText(String selector) {
		WebElement element = driver.findElement(By.id(selector));
		waitForVisible(driver, element);
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		String text = element.getText();
		actions.build().perform();
		System.out.println("Text : " + text);
	}

	public void byNameGetText(String selector) {
		WebElement element = driver.findElement(By.name(selector));
		waitForVisible(driver, element);
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		String text = element.getText();
		actions.build().perform();
		System.out.println("Text : " + text);
	}
	
	// Get Text By Index
	public void byTagGetTextIndex(String selector, int index, String expected) {
		List<WebElement> element = driver.findElements(By.tagName(selector));
		Assert.assertEquals(element.get(index).getText().replace(" ", "").toLowerCase(), expected.replace(" ", "").toLowerCase());
		System.out.println(element.get(index).getText());
	}
	
	public void byIdGetTextIndex(String selector, int index, String expected) {
		List<WebElement> element = driver.findElements(By.id(selector));
		Assert.assertEquals(element.get(index).getText().replace(" ", "").toLowerCase(), expected.replace(" ", "").toLowerCase());
		System.out.println(element.get(index).getText());
	}
	
	public void byXpathGetTextIndex(String selector, int index, String expected) {
		List<WebElement> element = driver.findElements(By.xpath(selector));
		Assert.assertEquals(element.get(index).getText().replace(" ", "").toLowerCase(), expected.replace(" ", "").toLowerCase());
		System.out.println(element.get(index).getText());
	}
	
	public void byClassGetTextIndex(String selector, int index, String expected) {
		List<WebElement> element = driver.findElements(By.className(selector));
		Assert.assertEquals(element.get(index).getText().replace(" ", "").toLowerCase(), expected.replace(" ", "").toLowerCase());
		System.out.println(element.get(index).getText());
	}
	
	public void byNameGetTextIndex(String selector, int index, String expected) {
		List<WebElement> element = driver.findElements(By.name(selector));
		Assert.assertEquals(element.get(index).getText().replace(" ", "").toLowerCase(), expected.replace(" ", "").toLowerCase());
		System.out.println(element.get(index).getText());
	}
	
	public void byLinkTextGetTextIndex(String selector, int index, String expected) {
		List<WebElement> element = driver.findElements(By.linkText(selector));
		Assert.assertEquals(element.get(index).getText().replace(" ", "").toLowerCase(), expected.replace(" ", "").toLowerCase());
		System.out.println(element.get(index).getText());
	}
	
	public void byCssGetTextIndex(String selector, int index, String expected) {
		List<WebElement> element = driver.findElements(By.cssSelector(selector));
		Assert.assertEquals(element.get(index).getText().replace(" ", "").toLowerCase(), expected.replace(" ", "").toLowerCase());
		System.out.println(element.get(index).getText());
	}
	
	// Return Text
	
	public String byClassReturnTexByIndext(String selector, int index) {
		List<WebElement> element = driver.findElements(By.className(selector));
		String text = element.get(index).getText();
		return text;
	}
	
	public String byClassReturnTexByIndexAttr(String selector, int index, String attr) {
		List<WebElement> element = driver.findElements(By.className(selector));
		String text = element.get(index).getAttribute(attr).toString();
		return text;
	}

	public String byClassReturnText(String selector) {
		WebElement element = driver.findElement(By.className(selector));
		waitForVisible(driver, element);
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		String text = element.getText();
		return text;
	}
	
	public String byIdReturnText(String selector) {
		WebElement element = driver.findElement(By.id(selector));
		waitForVisible(driver, element);
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		String text = element.getText();
		return text;
	}
	
	public String byXpathReturnText(String selector) {
		WebElement element = driver.findElement(By.xpath(selector));
		waitForVisible(driver, element);
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		String text = element.getText();
		return text;
	}
	
	public String byTagReturnText(String selector) {
		WebElement element = driver.findElement(By.tagName(selector));
		waitForVisible(driver, element);
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		String text = element.getText();
		return text;
	}
	
	public String byCssReturnText(String selector) {
		WebElement element = driver.findElement(By.cssSelector(selector));
		waitForVisible(driver, element);
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		String text = element.getText();
		return text;
	}
	
	public String byLinkTextReturnText(String selector) {
		WebElement element = driver.findElement(By.linkText(selector));
		waitForVisible(driver, element);
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		String text = element.getText();
		return text;
	}
	
	public String byNameReturnText(String selector) {
		WebElement element = driver.findElement(By.name(selector));
		waitForVisible(driver, element);
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		String text = element.getText();
		return text;
	}
	
	// Return Text By Index
	
	public String byNameReturnTextIndex(String selector, int index) {
		List<WebElement> element = driver.findElements(By.name(selector));
		String actualText = element.get(index).getText();
		return actualText;
	}
	
	public String byIdReturnTextIndex(String selector, int index) {
		List<WebElement> element = driver.findElements(By.id(selector));
		String actualText = element.get(index).getText();
		return actualText;
	}
	
	public String byCssReturnTextIndex(String selector, int index) {
		List<WebElement> element = driver.findElements(By.cssSelector(selector));
		String actualText = element.get(index).getText();
		return actualText;
	}
	
	public String byTagNameReturnTextIndex(String selector, int index) {
		List<WebElement> element = driver.findElements(By.tagName(selector));
		String actualText = element.get(index).getText();
		return actualText;
	}
	
	public String byXpathReturnTextIndex(String selector, int index) {
		List<WebElement> element = driver.findElements(By.xpath(selector));
		String actualText = element.get(index).getText();
		return actualText;
	}
	
	public String byLinkTextReturnTextIndex(String selector, int index) {
		List<WebElement> element = driver.findElements(By.linkText(selector));
		String actualText = element.get(index).getText();
		return actualText;
	}

	// By selector, Tagname

	public void byIdByTag(String selector, String tag, String alertText) {
		WebElement element = driver.findElement(By.id(selector));
		waitForVisible(driver, element);
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		String tagnameText = element.findElement(By.tagName(tag)).getText();
		Assert.assertEquals(tagnameText.toLowerCase().replace(" ", "").replace("\n", "").replace(",", ""),
				alertText.toLowerCase().replace(" ", "").replace("\n", "").replace(",", ""));
		actions.build().perform();
		System.out.println("Text : " + tagnameText);
	}

	// Alert Contains

	public void byClassContains(String selector, String alertText) {
		WebElement element = driver.findElement(By.className(selector));
		waitForVisible(driver, element);
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		element.getText().toLowerCase().replace(" ", "").replace("\n", "").replace("\n", "").replace("-", "")
				.contains(alertText.toLowerCase().replace(" ", "").replace("\n", "").replace("\n", "").replace("\n", "")
						.replace("-", ""));
		actions.build().perform();
		System.out.println(element.getText());
	}
	
	public void byIdContains(String selector, String alertText) {
		WebElement element = driver.findElement(By.id(selector));
		waitForVisible(driver, element);
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		element.getText().toLowerCase().replace(" ", "").replace("\n", "").replace("\n", "").replace("-", "")
				.contains(alertText.toLowerCase().replace(" ", "").replace("\n", "").replace("\n", "").replace("\n", "")
						.replace("-", ""));
		actions.build().perform();
		System.out.println(element.getText());
	}
	
	public void byCssContains(String selector, String alertText) {
		WebElement element = driver.findElement(By.cssSelector(selector));
		waitForVisible(driver, element);
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		element.getText().toLowerCase().replace(" ", "").replace("\n", "").replace("\n", "").replace("-", "")
				.contains(alertText.toLowerCase().replace(" ", "").replace("\n", "").replace("\n", "").replace("\n", "")
						.replace("-", ""));
		actions.build().perform();
		System.out.println(element.getText());
	}
	
	public void byTagNameContains(String selector, String alertText) {
		WebElement element = driver.findElement(By.tagName(selector));
		waitForVisible(driver, element);
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		element.getText().toLowerCase().replace(" ", "").replace("\n", "").replace("\n", "").replace("-", "")
				.contains(alertText.toLowerCase().replace(" ", "").replace("\n", "").replace("\n", "").replace("\n", "")
						.replace("-", ""));
		actions.build().perform();
		System.out.println(element.getText());
	}
	
	public void byXpathContains(String selector, String alertText) {
		WebElement element = driver.findElement(By.xpath(selector));
		waitForVisible(driver, element);
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		element.getText().toLowerCase().replace(" ", "").replace("\n", "").replace("\n", "").replace("-", "")
				.contains(alertText.toLowerCase().replace(" ", "").replace("\n", "").replace("\n", "").replace("\n", "")
						.replace("-", ""));
		actions.build().perform();
		System.out.println(element.getText());
	}
	
	public void byLinkTextContains(String selector, String alertText) {
		WebElement element = driver.findElement(By.linkText(selector));
		waitForVisible(driver, element);
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		element.getText().toLowerCase().replace(" ", "").replace("\n", "").replace("\n", "").replace("-", "")
				.contains(alertText.toLowerCase().replace(" ", "").replace("\n", "").replace("\n", "").replace("\n", "")
						.replace("-", ""));
		actions.build().perform();
		System.out.println(element.getText());
	}
	
	public void byNameContains(String selector, String alertText) {
		WebElement element = driver.findElement(By.name(selector));
		waitForVisible(driver, element);
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		element.getText().toLowerCase().replace(" ", "").replace("\n", "").replace("\n", "").replace("-", "")
				.contains(alertText.toLowerCase().replace(" ", "").replace("\n", "").replace("\n", "").replace("\n", "")
						.replace("-", ""));
		actions.build().perform();
		System.out.println(element.getText());
	}
	
	//Validate text Contains
	public void byNameContainsIndex(String selector, int index, String alertText) {
		List<WebElement> element = driver.findElements(By.name(selector));
		element.get(index).getText().toLowerCase().replace(" ", "").replace("\n", "").replace("\n", "").replace("-", "")
				.contains(alertText.toLowerCase().replace(" ", "").replace("\n", "").replace("\n", "").replace("\n", "")
						.replace("-", ""));
		System.out.println(element.get(index).getText());
	}
	
	public void byIdContainsIndex(String selector, int index, String alertText) {
		List<WebElement> element = driver.findElements(By.id(selector));
		element.get(index).getText().toLowerCase().replace(" ", "").replace("\n", "").replace("\n", "").replace("-", "")
				.contains(alertText.toLowerCase().replace(" ", "").replace("\n", "").replace("\n", "").replace("\n", "")
						.replace("-", ""));
		System.out.println(element.get(index).getText());
	}
	
	public void byCssContainsIndex(String selector, int index, String alertText) {
		List<WebElement> element = driver.findElements(By.cssSelector(selector));
		element.get(index).getText().toLowerCase().replace(" ", "").replace("\n", "").replace("\n", "").replace("-", "")
				.contains(alertText.toLowerCase().replace(" ", "").replace("\n", "").replace("\n", "").replace("\n", "")
						.replace("-", ""));
		System.out.println(element.get(index).getText());
	}
	
	public void byTagNameContainsIndex(String selector, int index, String alertText) {
		List<WebElement> element = driver.findElements(By.tagName(selector));
		element.get(index).getText().toLowerCase().replace(" ", "").replace("\n", "").replace("\n", "").replace("-", "")
				.contains(alertText.toLowerCase().replace(" ", "").replace("\n", "").replace("\n", "").replace("\n", "")
						.replace("-", ""));
		System.out.println(element.get(index).getText());
	}
	
	public void byXpathContainsIndex(String selector, int index, String alertText) {
		List<WebElement> element = driver.findElements(By.xpath(selector));
		element.get(index).getText().toLowerCase().replace(" ", "").replace("\n", "").replace("\n", "").replace("-", "")
				.contains(alertText.toLowerCase().replace(" ", "").replace("\n", "").replace("\n", "").replace("\n", "")
						.replace("-", ""));
		System.out.println(element.get(index).getText());
	}
	
	public void byLinkTextContainsIndex(String selector, int index, String alertText) {
		List<WebElement> element = driver.findElements(By.linkText(selector));
		element.get(index).getText().toLowerCase().replace(" ", "").replace("\n", "").replace("\n", "").replace("-", "")
				.contains(alertText.toLowerCase().replace(" ", "").replace("\n", "").replace("\n", "").replace("\n", "")
						.replace("-", ""));
		System.out.println(element.get(index).getText());
	}
	
	public void byClassContainsIndex(String selector, int index, String alertText) {
		List<WebElement> element = driver.findElements(By.className(selector));
		element.get(index).getText().toLowerCase().replace(" ", "").replace("\n", "").replace("\n", "").replace("-", "")
				.contains(alertText.toLowerCase().replace(" ", "").replace("\n", "").replace("\n", "").replace("\n", "")
						.replace("-", ""));
		System.out.println(element.get(index).getText());
	}

	// By Attribute Display

	public void byClassByAttrValidateValueAttr(String selector, String attr, String attrValue) {
		WebElement element = driver.findElement(By.className(selector));
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		boolean validateAttr = element.getAttribute(attr).contains(attrValue);
		Assert.assertEquals(validateAttr, true);
		actions.build().perform();
		System.out.println("Attribut: " + validateAttr);
	}

	public void byXpathByAttrValidateValueAttr(String selector, String attr, String attrValue) {
		WebElement element = driver.findElement(By.xpath(selector));
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		boolean validateAttr = element.getAttribute(attr).contains(attrValue);
		Assert.assertEquals(validateAttr, true);
		actions.build().perform();
		System.out.println("Attribut: " + validateAttr);
	}

	// validate url

	public boolean urlValidated(String url) {
		boolean u = driver.getCurrentUrl().contains(url);
		Assert.assertEquals(u, true);
		System.out.println("Url: " + driver.getCurrentUrl());
		return u;
	}
	
	public void urlValidate(String url) {
		boolean u = driver.getCurrentUrl().contains(url);
		Assert.assertEquals(u, true);
		System.out.println("Url: " + driver.getCurrentUrl());
	}

	// validate Class by index
	public void byClassByIndex(int index, String selector, String alertText) {
		List<WebElement> element = driver.findElements(By.className(selector));
		Assert.assertEquals(
				element.get(index).getText().toLowerCase().replace(" ", "").replace("\n", "").replace("\n", ""),
				alertText.toLowerCase().replace(" ", "").replace("\n", "").replace("\n", ""));
		System.out.println(element.get(index).getText());
	}
	
	public void byNameByIndex(int index, String selector, String alertText) {
		List<WebElement> element = driver.findElements(By.name(selector));
		Assert.assertEquals(
				element.get(index).getText().toLowerCase().replace(" ", "").replace("\n", "").replace("\n", ""),
				alertText.toLowerCase().replace(" ", "").replace("\n", "").replace("\n", ""));
		System.out.println(element.get(index).getText());
	}
	
	public void byXpathByIndex(int index, String selector, String alertText) {
		List<WebElement> element = driver.findElements(By.xpath(selector));
		Assert.assertEquals(
				element.get(index).getText().toLowerCase().replace(" ", "").replace("\n", "").replace("\n", ""),
				alertText.toLowerCase().replace(" ", "").replace("\n", "").replace("\n", ""));
		System.out.println(element.get(index).getText());
	}
	
	public void byCssByIndex(int index, String selector, String alertText) {
		List<WebElement> element = driver.findElements(By.cssSelector(selector));
		Assert.assertEquals(
				element.get(index).getText().toLowerCase().replace(" ", "").replace("\n", "").replace("\n", ""),
				alertText.toLowerCase().replace(" ", "").replace("\n", "").replace("\n", ""));
		System.out.println(element.get(index).getText());
	}
	
	public void byIdByIndex(String selector, int index, String alertText) {	
		List<WebElement> element = driver.findElements(By.id(selector));
		Assert.assertEquals(
				element.get(index).getText().toLowerCase().replace(" ", "").replace("\n", "").replace("\n", ""),
				alertText.toLowerCase().replace(" ", "").replace("\n", "").replace("\n", ""));
		System.out.println(element.get(index).getText());
	}
	
	public void byLinkTextByIndex(int index, String selector, String alertText) {
		List<WebElement> element = driver.findElements(By.linkText(selector));
		Assert.assertEquals(
				element.get(index).getText().toLowerCase().replace(" ", "").replace("\n", "").replace("\n", ""),
				alertText.toLowerCase().replace(" ", "").replace("\n", "").replace("\n", ""));
		System.out.println(element.get(index).getText());
	}
	
	public void byTagByIndex(int index, String selector, String alertText) {
		List<WebElement> element = driver.findElements(By.tagName(selector));
		Assert.assertEquals(
				element.get(index).getText().toLowerCase().replace(" ", "").replace("\n", "").replace("\n", ""),
				alertText.toLowerCase().replace(" ", "").replace("\n", "").replace("\n", ""));
		System.out.println(element.get(index).getText());
	}

	private void waitForVisible(WebDriver driver, WebElement element) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
