package PageActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import commonmethods.ActionSelenium;

public class UserInformationActions {
	static WebDriver driver;

	public UserInformationActions(WebDriver driver) {
		this.driver = driver;
	}

	public static void verifyPageTitle(String text) {
		ActionSelenium.waitUtilAtNextPage(text, driver);
	}

	public static void clickSave() {
		ActionSelenium.click(driver, By.xpath("//*[text()='Save & continue']"));
	}

	public static void selectNoSSN() {
		ActionSelenium.waitForPageLoad(driver);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ActionSelenium.click(driver, By.xpath("//*[@value='none']"));
	}

}
