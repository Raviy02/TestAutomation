package PageActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import commonmethods.ActionSelenium;

public class CreateAccountActions {

	static WebDriver driver;
	static String url = "http://www.yopmail.com";

	public CreateAccountActions(WebDriver driver) {
		this.driver = driver;
	}

	public static void selectState(String text) {
		ActionSelenium.waitForElement(By.xpath("//*[contains(@id,'homeState')]"), driver);
		ActionSelenium.selectValueFromDropDown(driver, By.xpath("//*[contains(@id,'homeState')]"), text);
	}

	public static void enterFirstName(String text) {
		ActionSelenium.Type(driver, text, By.xpath("//*[contains(@id,'First-name')]"));
	}

	public static void enterLastName(String text) {
		ActionSelenium.Type(driver, text, By.xpath("//*[contains(@id,'Last-name')]"));
	}

	public static void enterEmailId(String text) {
		ActionSelenium.Type(driver, text, By.xpath("//*[contains(@id,'Email-address')]"));
	}

	public static void enterPassword(String text) {
		ActionSelenium.Type(driver, text, By.xpath("//*[contains(@id,'Password')]"));
	}

	public static void reEnterPassword(String text) {
		ActionSelenium.Type(driver, text, By.xpath("//*[contains(@id,'Retype-password')]"));
	}

	public static void pickFirstQuestion(String text) {
		ActionSelenium.selectValueFromDropDown(driver, By.xpath("//*[contains(@id,'securityQuestions[0]')]"), text);
	}

	public static void enterFirstAnswer(String text) {
		ActionSelenium.Type(driver, text, By.xpath("//*[contains(@name,'securityAnswers[0]')]"));
	}

	public static void pickSecondQuestion(String text) {
		ActionSelenium.selectValueFromDropDown(driver, By.xpath("//*[contains(@id,'securityQuestions[1]')]"), text);
	}

	public static void enterSecondAnswer(String text) {
		ActionSelenium.Type(driver, text, By.xpath("//*[contains(@name,'securityAnswers[1]')]"));
	}

	public static void pickThirdQuestion(String text) {
		ActionSelenium.selectValueFromDropDown(driver, By.xpath("//*[contains(@id,'securityQuestions[2]')]"), text);
	}

	public static void enterThirdAnswer(String text) {
		ActionSelenium.Type(driver, text, By.xpath("//*[contains(@name,'securityAnswers[2]')]"));
	}

	public static void acceptAgreement() {
		ActionSelenium.click(driver, By.xpath("//*[contains(@name,'privacy')]"));
	}

	public static void clickCreateAccount() {
		ActionSelenium.actionClick(By.xpath("//*[contains(text(),'Create account')]"), driver);
		ActionSelenium.waitForElement(By.xpath("//div[@class='click-cover']"), driver);
	}

}
