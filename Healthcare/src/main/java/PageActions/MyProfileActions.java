package PageActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import commonmethods.ActionSelenium;

public class MyProfileActions {

	static WebDriver driver;

	public MyProfileActions(WebDriver driver) {
		this.driver = driver;
	}

	public static void verifyPageTitle(String text) {
		ActionSelenium.waitUtilAtNextPage(text, driver);
	}

	public static void clickVerifyNow() throws InterruptedException {
		ActionSelenium.waitForElementDisappear(By.xpath("//div[@id='saveBlocker']"), driver);
		ActionSelenium.waitForClickableElement(By.xpath("//a[text()='Verify now']"), driver);
		ActionSelenium.clickException(driver, By.xpath("//a[text()='Verify now']"));
	}

	public static void clickMyApplicationsAndCoverage() {
		ActionSelenium.click(driver, By.xpath("//li[@id='myAppCoverageIcon']//*[text()='My Applications & Coverage']"));
	}

}
