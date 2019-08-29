package PageActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import commonmethods.ActionSelenium;

public class Stub {

	static WebDriver driver;

	public Stub(WebDriver driver) {
		this.driver = driver;
	}

	public static void init() {
		String url="file:///C:/Users/ravikumar.yanamaddi/Desktop/Environments%20(3).html";
		ActionSelenium.OpenBrowser(driver,url);
		ActionSelenium.waitForClickableElement(By.xpath("//a[contains(@href,'test3')]"), driver);
		ActionSelenium.click(driver, By.xpath("//a[contains(@href,'test3')]"));
		ActionSelenium.waitForVisibleElement(By.xpath("//a[text()='Log in']"), driver);
		ActionSelenium.click(driver, By.xpath("//a[text()='Log in']"));
	}

}
