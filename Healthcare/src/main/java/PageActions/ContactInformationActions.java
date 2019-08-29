package PageActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import commonmethods.ActionSelenium;

public class ContactInformationActions {
	static WebDriver driver;

	public ContactInformationActions(WebDriver driver) {
		this.driver = driver;
	}

	public static void verifyPageTitle(String text) {
		ActionSelenium.waitUtilAtNextPage(text, driver);
	}

	public static void enterLastName(String text) {
		ActionSelenium.Type(driver, text, By.xpath("//*[@id='iDProofLastName']"));
	}

	public static void enterDOB(String text) {
		ActionSelenium.Type(driver, text, By.xpath("//*[@id='iDProofDOB']"));
	}

	public static void enterStreetAddress(String text) {
		ActionSelenium.Type(driver, text, By.xpath("//*[@id='iDProofAddressLine1']"));
	}

	public static void enterCity(String text) {
		ActionSelenium.Type(driver, text, By.xpath("//*[@id='iDProofCity']"));
	}

	public static void enterZipCode(String text) {
		ActionSelenium.typeSlowly(driver, By.xpath("//*[@id='iDProofZipCode']"), text);
	}

	public static void enterPhoneNumber(String text) {
		ActionSelenium.typeSlowly(driver, By.xpath("//*[@id='iDProofPhone']"), text);
	}

	public static void selectPhoneType(String text) {
		ActionSelenium.selectValueFromDropDown(driver, By.xpath("//*[@id='iDProofPhoneType']"), text);
	}

	public static void clickContinueButton() {
		ActionSelenium.click(driver, By.xpath("//*[@id='goToIDProofIdentityQuestions']"));
	}

}
