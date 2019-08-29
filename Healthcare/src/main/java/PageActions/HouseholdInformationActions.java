package PageActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import commonmethods.ActionSelenium;

public class HouseholdInformationActions {
	static WebDriver driver;

	public HouseholdInformationActions(WebDriver driver) {
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
		case "No":
			ActionSelenium.click(driver, By.xpath("//*[@value='none']"));
			break;
		case "incarcerated":
			ActionSelenium.click(driver, By.xpath("//*[@value='currentlyIncarcerated']"));
			break;
			 

		default:
			break;
		}
	}

}
