package PageActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import commonmethods.ActionSelenium;

public class TellUsAboutYoutSelfActions {

	static WebDriver driver;

	public TellUsAboutYoutSelfActions(WebDriver driver) {
		this.driver = driver;
	}

	public static void verifyPageTitle(String text) {
		ActionSelenium.waitUtilAtNextPage(text, driver);
	}

	public static void typeMonth(String text) {
		ActionSelenium.typeSlowly(driver, By.xpath("//input[@name='month']"), text);
	}

	public static void typeDay(String text) {
		ActionSelenium.typeSlowly(driver, By.xpath("//input[@name='day']"), text);
	}

	public static void typeYear(String text) {
		ActionSelenium.typeSlowly(driver, By.xpath("//input[@name='year']"), text);
	}

	public static void selectSex(String text) {
		switch (text) {
		case "Female":
			ActionSelenium.click(driver, By.xpath("//input[@value='FEMALE']"));
			break;

		default:
			break;
		}
	}

	public static void clickSave() {
		ActionSelenium.waitForPageLoad(driver);
		ActionSelenium.click(driver, By.xpath("//*[text()='Save & continue']"));
	}

}
