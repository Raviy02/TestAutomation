package PageActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import commonmethods.ActionSelenium;

public class AccountConfirmationActions {

	static WebDriver driver;

	public AccountConfirmationActions(WebDriver driver) {
		this.driver = driver;
	}

	public static void clickContinueToLogin() {
		ActionSelenium.switchToWindow(driver, "window2");
		ActionSelenium.click(driver, By.xpath("//*[text()='Continue to login']"));		
	}

}
