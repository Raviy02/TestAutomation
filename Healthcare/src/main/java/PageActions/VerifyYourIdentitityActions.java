package PageActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import commonmethods.ActionSelenium;

public class VerifyYourIdentitityActions {
	static WebDriver driver;

	public VerifyYourIdentitityActions(WebDriver driver) {
		this.driver = driver;
	}

	public static void verifyPageTitle(String text) {
		ActionSelenium.waitUtilAtNextPage(text, driver);
	}

	public static void clickGetStarted() {
	ActionSelenium.click(driver, By.xpath("//*[text()='Get started']"));
	}

}
