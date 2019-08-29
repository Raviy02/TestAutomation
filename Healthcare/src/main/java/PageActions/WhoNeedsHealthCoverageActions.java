package PageActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import commonmethods.ActionSelenium;

public class WhoNeedsHealthCoverageActions {
	static WebDriver driver;

	public WhoNeedsHealthCoverageActions(WebDriver driver) {
		this.driver = driver;
	}

	public static void verifyPageTitle(String text) {
		ActionSelenium.waitUtilAtNextPage(text, driver);
	}

	public static void clickSave() {
		ActionSelenium.waitForPageLoad(driver);
		ActionSelenium.click(driver, By.xpath("//*[text()='Save & continue']"));
	}

}
