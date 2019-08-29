package PageActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import commonmethods.ActionSelenium;

public class StartApplicationActions {
	static WebDriver driver;

	public StartApplicationActions(WebDriver driver) {
		this.driver = driver;
	}

	public static void verifyPageTitle(String text) {
		ActionSelenium.waitUtilAtNextPage(text, driver);
	}

	public static void clickNextButton() {
		ActionSelenium.click(driver, By.xpath("//*[@id='indvLink']"));
	}

	public static void acceptTerms() {
		ActionSelenium.selectMultipleAnswers(driver, By.xpath("//*[@type='checkbox']"));
	}

	public static void clickTakeMeToApplicationButton() {
		ActionSelenium.click(driver, By.xpath("//*[text()='Take me to the application']"));
	}

	public static void selectMaritialStatue(String text) {
		switch (text) {
		case "single":
			ActionSelenium.click(driver, By.xpath("//input[@name='isMarried'][@value='false']"));
			break;
		case "married":
			ActionSelenium.click(driver, By.xpath("//input[@name='isMarried'][@value='true']"));
			break;
		default:
			break;
		}

	}

	public static void selectTaxDependents(String text) {
		ActionSelenium.selectValueFromDropDown(driver, By.xpath("//*[@name='tendon:numDependents']"), text);
	}

	public static void selectIncome(String text) {
		switch (text) {
		case "Below51000":
			ActionSelenium.click(driver, By.xpath("//*[@id='income-0']"));
			break;

		default:
			break;
		}
	}

	public static void selectHelpforCoverage(String text) {
		switch (text) {
		case "Yes":
			ActionSelenium.click(driver, By.xpath("//*[@id='fa-choice-0']"));
			break;

		default:
			break;
		}

	}

	public static void clickContinueButton() {
		ActionSelenium.click(driver, By.xpath("//*[text()='Continue']"));
	}
}
