package PageActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import commonmethods.ActionSelenium;

public class CitizenshipImmigrationStatusActions {
	static WebDriver driver;

	public CitizenshipImmigrationStatusActions(WebDriver driver) {
		this.driver = driver;
	}

	public static void verifyPageTitle(String text) {
		ActionSelenium.waitUtilAtNextPage(text, driver);
	}

	public static void clickSave() {
		ActionSelenium.click(driver, By.xpath("//*[text()='Save & continue']"));
	}

	public static void selectOption(String text) {
		switch (text) {
		case "Yes":
			ActionSelenium.click(driver, By.xpath("//*[@value='true']"));
			break;

		default:
			break;
		}

	}
}
