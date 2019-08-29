package PageActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import commonmethods.ActionSelenium;

public class ContactInformationActionsNewApplication {

	static WebDriver driver;

	public ContactInformationActionsNewApplication(WebDriver driver) {
		this.driver = driver;
	}

	public static void verifyPageTitle(String text) {
		ActionSelenium.waitUtilAtNextPage(text, driver);
	}

	public static void clickSave() {
		ActionSelenium.waitForPageLoad(driver);
		ActionSelenium.click(driver, By.xpath("//*[text()='Save & continue']"));
	}

	public static void enterPhoneNumber(String text) {
		ActionSelenium.Type(driver, text, By.xpath("//*[@name='primaryPhoneNumber']"));
	}

	public static void selectPhoneType(String text) {
		switch (text) {
		case "Home":
			ActionSelenium.click(driver, By.xpath("//*[@value='HOME']"));
			break;

		default:
			break;
		}
	}

}
