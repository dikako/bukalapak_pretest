package setup;

import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import utilities.TakeScreenshot;

public class Controller {

	protected AppiumDriver<MobileElement> driver;
	protected WebDriverWait wait;
	private final static String APP_PACKAGE_NAME = "com.loginmodule.learning";
	private final static String APP_ACTIVITY_NAME = "com.loginmodule.learning.activities.LoginActivity";

	@BeforeMethod
	public void set() {

		try {

			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");
			caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.1.0");
			caps.setCapability(MobileCapabilityType.DEVICE_NAME, "pp");
			caps.setCapability(MobileCapabilityType.UDID, "2fe25216");
			caps.setCapability(MobileCapabilityType.NO_RESET, true);
			caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);
			caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, APP_PACKAGE_NAME);
			caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, APP_ACTIVITY_NAME);
			caps.setCapability(AndroidMobileCapabilityType.APP_WAIT_PACKAGE, APP_PACKAGE_NAME);
			caps.setCapability(AndroidMobileCapabilityType.APP_WAIT_ACTIVITY, APP_ACTIVITY_NAME);
			caps.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true);
			caps.setCapability(AndroidMobileCapabilityType.DISABLE_ANDROID_WATCHERS, true);
			caps.setCapability(AndroidMobileCapabilityType.IGNORE_UNIMPORTANT_VIEWS, true);
			

			URL url = new URL("http://localhost:4723/wd/hub");

			driver = new AppiumDriver<MobileElement>(url, caps);
			wait = new WebDriverWait(driver, 20);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		} catch (Exception exc) {
			System.out.println("Cause is : " + exc.getCause());
			System.out.println("Message is : " + exc.getMessage());
			exc.printStackTrace();
		}
	}

	@AfterMethod
	public void setdown(ITestResult result) throws InterruptedException {
		String name = result.getName();
		if(ITestResult.FAILURE==result.getStatus()) {
			TakeScreenshot.captureScreenshot(driver, "Error_" + name);
			
			System.out.println("*** Test execution " + result.getMethod().getMethodName() + " failed!");
			System.out.println(result.getMethod().getMethodName() + " failed!");
		} else {
			TakeScreenshot.captureScreenshot(driver, "Pass_" + name);		
		}
		Thread.sleep(5000);
		driver.quit();
	}
}
