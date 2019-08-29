package PageActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import commonmethods.ActionSelenium;

public class ReviewUserIncomeExpensesActions {
	static WebDriver driver;

	public ReviewUserIncomeExpensesActions(WebDriver driver) {
		this.driver = driver;
	}

	public static void verifyPageTitle(String text) {
		ActionSelenium.waitUtilAtNextPage(text, driver);
	}

	public static void clickSave() {
		ActionSelenium.click(driver, By.xpath("//*[text()='Save & continue']"));
	}

	public static void acceptIncome() {
		ActionSelenium.click(driver, By.xpath("//*[@value='true']"));
	}

}
