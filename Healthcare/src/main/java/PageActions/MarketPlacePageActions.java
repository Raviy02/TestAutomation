package PageActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import commonmethods.ActionSelenium;

public class MarketPlacePageActions {

	static WebDriver driver;

	public MarketPlacePageActions(WebDriver driver) {
		this.driver = driver;
	}

	public static void verifyPageTitle(String text) {
		ActionSelenium.waitUtilAtNextPage(text, driver);
	}

	public static void clickUserPorfile() throws InterruptedException {
		ActionSelenium.waitForElementDisappear(By.xpath("//div[@id='saveBlocker']"), driver);
		ActionSelenium.clickException(driver, By.xpath("//span[@id='headerUserName']"));
	}

	public static void clickMyProfileOption() {
		ActionSelenium.click(driver, By.xpath("//a[@id='helpProfile']"));
	}

}
