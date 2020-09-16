package testcases;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import config.Setup;
import config.Url;
import function.Alert;
import function.Button;
import function.Input;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import utilities.ReadExcel;

public class SearchProduct extends Setup {

	public String path = "../bukalapak_pretest_web/src/test/java/datatest/data.xlsx";

	@DataProvider
	public String[][] search() throws InvalidFormatException, IOException {
		ReadExcel read = new ReadExcel();
		return read.getCellData(path, "search");
	}
	
	@Severity(SeverityLevel.CRITICAL)
	@Description("Test Search")
	@Test(priority = 0, testName = "Test Search")
	public void searchByClickPopulerSearch() throws InterruptedException {

		Url url = new Url(driver);
		Button button = PageFactory.initElements(driver, Button.class);
		Alert alert = PageFactory.initElements(driver, Alert.class);

		url.defaultUrl();
		System.out.println(driver.getCurrentUrl());
		
		//Click Search
		button.byId("v-omnisearch__input");
		
		//Validate Item Popular Search & Popular Category Is Displayed
		alert.byClassByIndex(0, "v-omnisearch__before-result", "Pencarian Populer");
		alert.byClassByIndex(1, "v-omnisearch__before-result", "Kategori Populer");
		
		//Validate List Popular Search is Not Null
		button.byClassNotNull("v-omnisearch-result--popular-search");
		
		//Return Text Before Click List Popular Search index 0
		String popularSearch = alert.byClassReturnTexByIndext("v-omnisearch-result--popular-search", 0);
		
		//Click on of List List Popular Search index 0
		button.byClassByIndex("v-omnisearch-result--popular-search", 0);
		Thread.sleep(5000);
		
		//Validate breadcrum match with Item Clicked
		alert.byClassByIndex(1, "bl-breadcrumb__item", popularSearch);		
	}
	
	@Severity(SeverityLevel.CRITICAL)
	@Description("Test Search")
	@Test(priority = 1, testName = "Test Search")
	public void searchByClickPopulerCatgory() throws InterruptedException {

		Url url = new Url(driver);
		Button button = PageFactory.initElements(driver, Button.class);
		Alert alert = PageFactory.initElements(driver, Alert.class);

		url.defaultUrl();
		System.out.println(driver.getCurrentUrl());
		
		//Click Search
		button.byId("v-omnisearch__input");
		
		//Validate Item Popular Search & Popular Category Is Displayed
		alert.byClassByIndex(0, "v-omnisearch__before-result", "Pencarian Populer");
		alert.byClassByIndex(1, "v-omnisearch__before-result", "Kategori Populer");
		
		//Validate List Popular Search is Not Null
		button.byClassNotNull("v-omnisearch-result--popular-search");
		
		//Return Text Before Click List Popular Search index 0
		String popularSearch = alert.byClassReturnTexByIndexAttr("v-omnisearch-result--popular-categories", 0, "title");
		
		//Click on of List List Popular Category index 0
		button.byClassByIndex("v-omnisearch-result--popular-categories", 0);
		Thread.sleep(5000);
		
		//Validate breadcrum match with Item Clicked
		alert.byClassByIndex(1, "bl-breadcrumb__item", popularSearch);	
		
		//Validate Content Not Null
		button.byClassNotNull("bl-thumbnail--slider");
	}
	
	@Severity(SeverityLevel.CRITICAL)
	@Description("Test Search")
	@Test(priority = 2, testName = "Test Search", dataProvider = "search")
	public void searchByKeyword(String keyword) throws InterruptedException {

		Url url = new Url(driver);
		Button button = PageFactory.initElements(driver, Button.class);
		Input input = PageFactory.initElements(driver, Input.class);
		Alert alert = PageFactory.initElements(driver, Alert.class);

		url.defaultUrl();
		System.out.println(driver.getCurrentUrl());
		
		//Click Search
		input.byId("v-omnisearch__input", keyword);
		button.byClass("v-omnisearch__submit");
		Thread.sleep(5000);
		
		//Validate Breadcrumb
		alert.byClassByIndex(1, "bl-breadcrumb__item", keyword);	
	}
	
	@Severity(SeverityLevel.CRITICAL)
	@Description("Test Search")
	@Test(priority = 3, testName = "Test Search")
	public void searchByKeywordNotFound() throws InterruptedException {

		Url url = new Url(driver);
		Button button = PageFactory.initElements(driver, Button.class);
		Input input = PageFactory.initElements(driver, Input.class);
		Alert alert = PageFactory.initElements(driver, Alert.class);

		url.defaultUrl();
		System.out.println(driver.getCurrentUrl());
		
		//Click Search
		input.byId("v-omnisearch__input", "fhasjgfsjhgfasjhfgasjhfgasjhfgsjhkf");
		button.byClass("v-omnisearch__submit");
		Thread.sleep(5000);
		
		//Validate Error Message
		alert.byXpath("//p[contains(text(),'Maaf, barangnya tidak ketemu')]", "Maaf, barangnya tidak ketemu");
		
	}
}
