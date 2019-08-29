package PageActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import commonmethods.ActionSelenium;

public class SignSubmitActions {
	static WebDriver driver;

	public SignSubmitActions(WebDriver driver) {
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
		ActionSelenium.javaScrollIntoView(driver, driver.findElement(By.xpath("//button[text()='Sign & submit']")));
		ActionSelenium.click(driver, By.xpath("//button[text()='Sign & submit']"));
	}

	public static void acceptAgreement() {
		ActionSelenium.click(driver, By.xpath("//*[@value='true']"));
	}

	public static void enterName(String text) {
		ActionSelenium.Type(driver, text, By.xpath("//*[@name='applicationSignatureText']"));
	}

}
