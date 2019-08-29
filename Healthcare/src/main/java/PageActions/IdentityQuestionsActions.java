package PageActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import commonmethods.ActionSelenium;

public class IdentityQuestionsActions {
	static WebDriver driver;

	public IdentityQuestionsActions(WebDriver driver) {
		this.driver = driver;
	}

	public static void verifyPageTitle(String text) {
		ActionSelenium.waitUtilAtNextPage(text, driver);
	}

	public static void answerAllQuestions(String text) {
		ActionSelenium.waitForPageLoad(driver);
		ActionSelenium.selectMultipleAnswers(driver, By.xpath("//label[text()='"+text+"']/preceding-sibling::input"));
	}

	public static void clickContinueButton() {
		ActionSelenium.click(driver, By.xpath("//button[text()='CONTINUE'][contains(@class,'goToIDProofResults')]"));
	}

}
