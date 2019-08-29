package PageActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import commonmethods.ActionSelenium;

public class TaxRelationshipsActions {
	static WebDriver driver;

	public TaxRelationshipsActions(WebDriver driver) {
		this.driver = driver;
	}

	public static void verifyPageTitle(String text) {
		ActionSelenium.waitUtilAtNextPage(text, driver);
	}

	public static void clickSave() {
		ActionSelenium.waitForPageLoad(driver);
		ActionSelenium.click(driver, By.xpath("//*[text()='Save & continue']"));
	}

	public static void answerFirstQuestion(String text) {
		switch (text) {
		case "Yes":
			ActionSelenium.waitForPageLoad(driver);
			ActionSelenium.click(driver, By.xpath("//*[@name='filingTaxes'][@value='true']"));
			break;

		default:
			break;
		}

	}

	public static void answerSecondQuestion(String text) {
		switch (text) {
		case "No":
			ActionSelenium.waitForPageLoad(driver);
			ActionSelenium.click(driver, By.xpath("//*[@name='claimsDependent'][@value='false']"));
			break;

		default:
			break;
		}
	}

	public static void answerThirdQuestion(String text) {
		switch (text) {
		case "No":
			ActionSelenium.waitForPageLoad(driver);
			ActionSelenium.click(driver, By.xpath("//*[@name='claimedAsADependent'][@value='false']"));
			break;

		default:
			break;
		}
	}

}
