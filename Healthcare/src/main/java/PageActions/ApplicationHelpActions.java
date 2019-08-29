package PageActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import commonmethods.ActionSelenium;

public class ApplicationHelpActions {
	static WebDriver driver;

	public ApplicationHelpActions(WebDriver driver) {
		this.driver = driver;
	}

	public static void verifyPageTitle(String text) {
		ActionSelenium.waitUtilAtNextPage(text, driver);
	}

	public static void clickSave() {
		ActionSelenium.waitForPageLoad(driver);
		ActionSelenium.click(driver, By.xpath("//*[text()='Save & continue']"));
	}

	public static void selectOption(String text) {
		switch (text) {
		case "No":
			ActionSelenium.waitForPageLoad(driver);
			ActionSelenium.click(driver, By.xpath("//*[@value='false']"));
			break;

		default:
			break;
		}

	}

}
