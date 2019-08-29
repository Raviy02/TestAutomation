package PageActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import commonmethods.ActionSelenium;

public class HomeAddressActions {

	static WebDriver driver;

	public HomeAddressActions(WebDriver driver) {
		this.driver = driver;
	}

	public static void verifyPageTitle(String text) {
		ActionSelenium.waitUtilAtNextPage(text, driver);
	}

	public static void clickSave() {
		ActionSelenium.waitForPageLoad(driver);
		ActionSelenium.click(driver, By.xpath("//*[text()='Save & continue']"));
	}

	public static void enterStreetAddress(String text) {
		ActionSelenium.Type(driver, text, By.xpath("//*[@name='streetName1']"));
	}

	public static void enterCity(String text) {
		ActionSelenium.Type(driver, text, By.xpath("//*[@name='cityName']"));
	}

	public static void enterZipCode(String text) {
		ActionSelenium.Type(driver, text, By.xpath("//*[@name='zipCode']"));
	}

	public static void selectUSPSAddress() {
		ActionSelenium.waitForPageLoad(driver);
		ActionSelenium.click(driver, By.xpath("//*[@name='geoAPIResult']"));
	}

}
