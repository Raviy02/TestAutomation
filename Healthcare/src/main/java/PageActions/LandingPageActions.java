package PageActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import commonmethods.ActionSelenium;

public class LandingPageActions {

	static WebDriver driver;

	public LandingPageActions(WebDriver driver) {
		this.driver = driver;
	}

	public static void openLandingPage(String url) {
		Stub.init();
		//ActionSelenium.OpenBrowser(driver, url);
		ActionSelenium.setMainWindow(driver.getWindowHandle());
	}

	public static void verifyPageTitle(String text) {
		ActionSelenium.waitUtilAtNextPage(text, driver);
		Assert.assertTrue(ActionSelenium.getPageTitle(driver).equals(text));
	}

	public static void clickCreateOne() {
		ActionSelenium.switchToMainWindow(driver);
		ActionSelenium.click(driver, By.xpath("//*[text()='Create one']"));
	}

	public static void enterUserName(String text) {
		ActionSelenium.Type(driver, text, By.xpath("//*[contains(@id,'Username')]"));
	}

	public static void enterPassword(String text) {
		ActionSelenium.Type(driver, text, By.xpath("//*[contains(@id,'Password')]"));
	}

	public static void clickLoginButton() {
		ActionSelenium.click(driver, By.xpath("//button[@type='submit']"));
	}

}
