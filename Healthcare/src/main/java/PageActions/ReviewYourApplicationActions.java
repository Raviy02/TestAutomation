package PageActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import commonmethods.ActionSelenium;

public class ReviewYourApplicationActions {
	static WebDriver driver;

	public ReviewYourApplicationActions(WebDriver driver) {
		this.driver = driver;
	}

	public static void verifyPageTitle(String text) {
		ActionSelenium.waitUtilAtNextPage(text, driver);
	}

	public static void clickSave() {
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ActionSelenium.waitForPageLoad(driver);
		ActionSelenium.javaScrollIntoView(driver, driver.findElement(By.xpath("//*[text()='Save & continue']")));
		ActionSelenium.actionClick(By.xpath("//*[text()='Save & continue']"), driver);
	}

	public static void acceptIncome() {

		ActionSelenium.click(driver, By.xpath("//*[@value='true']"));
	}
}
