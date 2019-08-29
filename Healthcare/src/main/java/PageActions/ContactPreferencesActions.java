package PageActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import commonmethods.ActionSelenium;

public class ContactPreferencesActions {

	static WebDriver driver;

	public ContactPreferencesActions(WebDriver driver) {
		this.driver = driver;
	}

	public static void verifyPageTitle(String text) {
		ActionSelenium.waitUtilAtNextPage(text, driver);
	}

	public static void clickSave() {
		ActionSelenium.waitForPageLoad(driver);
		ActionSelenium.click(driver, By.xpath("//*[text()='Save & continue']"));
	}

	public static void selectPreference(String text) {
		switch (text) {
		case "Paper":
			ActionSelenium.waitForPageLoad(driver);
			ActionSelenium.click(driver, By.xpath("//*[@value='PAPER']"));
			break;

		default:
			break;
		}
	}

}
