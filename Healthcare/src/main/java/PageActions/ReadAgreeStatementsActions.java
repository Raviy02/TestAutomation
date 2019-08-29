package PageActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import commonmethods.ActionSelenium;

public class ReadAgreeStatementsActions {
	static WebDriver driver;

	public ReadAgreeStatementsActions(WebDriver driver) {
		this.driver = driver;
	}

	public static void verifyPageTitle(String text) {
		ActionSelenium.waitUtilAtNextPage(text, driver);
	}

	public static void clickSave() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ActionSelenium.waitForPageLoad(driver);
		ActionSelenium.javaScrollIntoView(driver, driver.findElement(By.xpath("//*[text()='Save & continue']")));
		ActionSelenium.click(driver, By.xpath("//*[text()='Save & continue']"));
	}

	public static void acceptAgreement() {
		ActionSelenium.selectMultipleAnswers(driver, By.xpath("//*[@value='true']"));
	}

}
