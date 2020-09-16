package config;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import utilities.TakeScreenshot;

public class Setup {
	protected WebDriver driver;

	@BeforeMethod
	public void set() throws MalformedURLException {
		System.setProperty("webdriver.chrome.driver", "D:\\Library\\dr\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}

	@AfterMethod
	public void done(ITestResult result) throws InterruptedException {
		String name = result.getName();
		if (ITestResult.FAILURE == result.getStatus()) {
			TakeScreenshot.captureScreenshot(driver, "Error_" + name);
			System.out.println("*** Test execution " + result.getMethod().getMethodName() + " failed!");
			System.out.println(result.getMethod().getMethodName() + " failed!");
			driver.quit();
		} else {
			TakeScreenshot.captureScreenshot(driver, "Pass_" + name);
			driver.quit();
		}
	}
}
