package PageActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import commonmethods.ActionSelenium;

public class RandonEmailActions {
	static WebDriver driver;
	static String url = "http://www.yopmail.com";

	public RandonEmailActions(WebDriver driver) {
		this.driver = driver;
	}

	public static void generateRandomEmailId() {
		ActionSelenium.openNewTab(driver);
		ActionSelenium.switchToWindow(driver, "window1");
		ActionSelenium.OpenBrowser(driver, url);
		ActionSelenium.click(driver, By.xpath("//*[contains(text(),'Random Email Address')]"));
	}

	public static String recordEmailId() {
		ActionSelenium.waitForElement(By.xpath("//input[@id='login']"), driver);
		return ActionSelenium.getAttribute(driver, By.xpath("//input[@id='login']"), "value");
	}

	public static void clickCheckMails() {
		ActionSelenium.switchToWindow(driver, "window1");
		ActionSelenium.click(driver, By.xpath("//input[@value='Check mails']"));
	}

	public static void clickCheckForNewMails() {
		int count = 4;
		for (int i = 0; i <= count; i++) {
			ActionSelenium.click(driver, By.xpath("//span[@class='slientext']"));
			if (isEmailReceived()) {
				break;
			}
		}

	}

	public static void clickVerificationLink() {
		try {
			ActionSelenium.switchFrame(driver, "ifmail");
			ActionSelenium.click(driver, By.xpath("//*[text()='HealthCare.gov']"));
		} finally {
			ActionSelenium.switchToTopFrame(driver);
			System.out.println("main window");
		}

	}

	public static boolean isEmailReceived() {
		boolean result = false;
		ActionSelenium.switchFrame(driver, "ifinbox");
		result = ActionSelenium.isDisplayed(driver, By.xpath("//span[text()='marketplace@healthcare.gov']"));
		ActionSelenium.switchToTopFrame(driver);
		return result;

	}

}
