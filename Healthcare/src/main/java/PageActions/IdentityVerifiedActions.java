package PageActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import commonmethods.ActionSelenium;

public class IdentityVerifiedActions {
	
	static WebDriver driver;

	public IdentityVerifiedActions(WebDriver driver) {
		this.driver = driver;
	}

	public static void verifyPageTitle(String text) {
		ActionSelenium.waitUtilAtNextPage(text, driver);
	}

	public static void clickContinueButton() {
		ActionSelenium.click(driver, By.xpath("//button[contains(@class,'checkForCCRApplication')]"));		
	}


}
