package PageActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import commonmethods.ActionSelenium;

public class MaritalStatusActions {
	static WebDriver driver;

	public MaritalStatusActions(WebDriver driver) {
		this.driver = driver;
	}

	public static void verifyPageTitle(String text) {
		ActionSelenium.waitUtilAtNextPage(text, driver);
	}

	public static void clickSave() {
		ActionSelenium.waitForPageLoad(driver);
		ActionSelenium.click(driver, By.xpath("//*[text()='Save & continue']"));
	}

	public static void selectMaritialStatue(String text) {
		switch (text) {
		case "single":
			ActionSelenium.waitForPageLoad(driver);
			ActionSelenium.click(driver, By.xpath("//*[@value='UNMARRIED']"));
			break;

		default:
			break;
		}
	}

}
