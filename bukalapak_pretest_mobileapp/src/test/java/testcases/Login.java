package testcases;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import function.Alert;
import function.Button;
import function.Input;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import setup.Controller;
import utilities.ReadExcel;

public class Login extends Controller {
	
	public String path = "../bukalapak_pretest_mobileapp/src/test/java/datatest/data.xlsx";

	@DataProvider
	public String[][] login_success() throws InvalidFormatException, IOException{
		ReadExcel read = new ReadExcel();
		return read.getCellData(path, "login");
	}
	
	public String[][] login_alert() throws InvalidFormatException, IOException{
		ReadExcel read = new ReadExcel();
		return read.getCellData(path, "loginAlert");
	}
	
	@Severity(SeverityLevel.CRITICAL)
	@Test(priority = 0, testName = "Login Success", dataProvider = "login_alert")
	public void login_alert(String username, String password, String alertText) throws InterruptedException {
		Button button = new Button(driver);
		Input input = new Input(driver);
		Alert alert = new Alert(driver);

		input.ById("textInputEditTextEmail", username);
		input.ById("textInputEditTextPassword", password);
		button.ById("appCompatButtonLogin");
		
		alert.ById("snackbar_text", alertText);
	}

	@Severity(SeverityLevel.CRITICAL)
	@Test(priority = 1, testName = "Login Success", dataProvider = "login_success")
	public void login_success(String username, String password) throws InterruptedException {
		Button button = new Button(driver);
		Input input = new Input(driver);
		Alert alert = new Alert(driver);

		input.ById("textInputEditTextEmail", username);
		input.ById("textInputEditTextPassword", password);
		button.ById("appCompatButtonLogin");
		
		button.ById("menuAccount");
		alert.ById("textViewEmail", username);
	}
}
