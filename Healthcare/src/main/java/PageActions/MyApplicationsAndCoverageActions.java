package PageActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import commonmethods.ActionSelenium;

public class MyApplicationsAndCoverageActions {

	static WebDriver driver;

	public MyApplicationsAndCoverageActions(WebDriver driver) {
		this.driver = driver;
	}

	public static void verifyPageTitle(String text) {
		ActionSelenium.waitUtilAtNextPage(text, driver);
	}

	public static void selectYear(String text) {
		ActionSelenium.selectValueFromDropDown(driver, By.xpath("//select[contains(@id,'yearDropdownview')]"), text);
	}

	public static void selectState(String text) {
		ActionSelenium.waitForStalenessOfElement(By.xpath("//select[contains(@id,'stateDropdownview')]"), driver);
		ActionSelenium.selectValueFromDropDown(driver, By.xpath("//select[contains(@id,'stateDropdownview')]"), text);
	}

	public static void clickApplyOrRenewButton() {
		ActionSelenium.click(driver, By.xpath("//*[@id='landingPage_Apply']"));
	}

}
