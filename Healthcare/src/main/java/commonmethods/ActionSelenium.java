package commonmethods;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

public class ActionSelenium {
	final static int WAITING_TIME = 30;
	private static boolean HIGHLIGHT_SWITCH = true;
	static String mainwindow;

	public static void OpenBrowser(WebDriver driver, String url) {
		driver.get(url);
	}

	public static boolean javascript_highlight(WebDriver driver, By by, String borderColor, String borderType,
			int borderThickness) {
		try {
			WebElement pageElement = driver.findElement(by);
			if (HIGHLIGHT_SWITCH) {
				if (borderColor.isEmpty()) {
					borderColor = "red";
				}
				if (borderType.isEmpty()) {
					borderType = "solid";
				}
				if (driver instanceof JavascriptExecutor) {
					((JavascriptExecutor) driver).executeScript("arguments[0].style.border='" + borderThickness + "px "
							+ borderType + " " + borderColor + "'", pageElement);
				}
			}
			return true;
		} catch (ElementNotVisibleException | NoSuchElementException | StaleElementReferenceException e) {
			return false;
		}
	}

	public static boolean javascript_highlight(WebDriver driver, WebElement pageElement, String borderColor,
			String borderType, int borderThickness) {
		try {
			if (HIGHLIGHT_SWITCH) {
				if (borderColor.isEmpty()) {
					borderColor = "red";
				}
				if (borderType.isEmpty()) {
					borderType = "solid";
				}
				if (driver instanceof JavascriptExecutor) {
					((JavascriptExecutor) driver).executeScript("arguments[0].style.border='" + borderThickness + "px "
							+ borderType + " " + borderColor + "'", pageElement);
				}
			}
			return true;
		} catch (ElementNotVisibleException | NoSuchElementException | StaleElementReferenceException e) {
			return false;
		}
	}

	public static void Type(WebDriver driver, String value, By locator) {
		javascript_highlight(driver, locator, "blue", "dotted", 3);
		waitForElement(locator, driver);
		driver.findElement(locator).clear();
		driver.findElement(locator).sendKeys(value);
	}

	public static void Type(WebDriver driver, String text, WebElement element) {
		javascript_highlight(driver, element, "blue", "dotted", 3);
		waitForElement(element, driver);
		element.sendKeys(text);
	}

	public static void click(WebDriver driver, By locator) {
		javascript_highlight(driver, locator, "blue", "dotted", 3);
		waitForElement(locator, driver);
		javaClick(driver, locator);
	}

	public static void click(WebDriver driver, WebElement element) {
		javascript_highlight(driver, element, "blue", "dotted", 3);
		waitForVisibleElement(element, driver);
		element.click();
	}

	public static int validateResult(WebDriver driver, By locator) {
		javascript_highlight(driver, locator, "blue", "dotted", 3);
		waitForElement(locator, driver);
		List<WebElement> list = driver.findElements(locator);
		return list.size();

	}

	public static void waitForElement(final WebElement element, WebDriver driver) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(WAITING_TIME, TimeUnit.SECONDS)
				.pollingEvery(5, TimeUnit.SECONDS).ignoring(NoSuchElementException.class)
				.ignoring(ElementNotVisibleException.class).ignoring(TimeoutException.class)
				.ignoring(StaleElementReferenceException.class);
		WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return element;
			}
		});
	}

	public static void waitForElement(final By by, WebDriver driver) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(WAITING_TIME, TimeUnit.SECONDS)
				.pollingEvery(5, TimeUnit.SECONDS).ignoring(NoSuchElementException.class)
				.ignoring(ElementNotVisibleException.class).ignoring(TimeoutException.class)
				.ignoring(StaleElementReferenceException.class);
		WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(by);
			}
		});
	}

	public static void waitForStalenessOfElement(final By by, WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, WAITING_TIME);
		wait.until(ExpectedConditions.presenceOfElementLocated(by));

	}
	
	public static void waitFoEnabledElement(final By by, WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, WAITING_TIME);
		wait.until((ExpectedCondition<Boolean>) driver1 -> driver.findElement(by).isEnabled());

	}

	public static void waitForVisibleElement(final By by, WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, WAITING_TIME);
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}

	public static void waitForVisibleElement(final WebElement element, WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, WAITING_TIME);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public static void waitForClickableElement(final By by, WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, WAITING_TIME);
		wait.until(ExpectedConditions.elementToBeClickable(by));
	}

	public static void waitForElementDisappear(final By by, WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, WAITING_TIME);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
	}

	public static void waitForElementDisappear(WebDriver driver, final By by) {
		WebDriverWait wait = new WebDriverWait(driver, WAITING_TIME);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
	}

	public static boolean waitUtilAtNextPage(String titlePage, WebDriver driver) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, WAITING_TIME);
			wait.ignoring(TimeoutException.class).until(ExpectedConditions.titleContains(titlePage));
			return true;
		} catch (TimeoutException e) {
			return false;
		}
	}

	public static void switchToWindow(WebDriver driver, String window) throws NoSuchElementException {
		Set<String> set = driver.getWindowHandles();
		LinkedHashMap<String, String> tabs = new LinkedHashMap<String, String>();
		Iterator<String> itr = set.iterator();
		int i = 1;
		while (itr.hasNext()) {
			String child = itr.next();
			if (tabs.isEmpty()) {
				tabs.putIfAbsent("window0", mainwindow);
			} else if (!tabs.containsValue(child)) {
				tabs.putIfAbsent("window" + i, child);
				i++;
			}

		}
		if (!mainwindow.equalsIgnoreCase(tabs.get(window))) {
			driver.switchTo().window(tabs.get(window));
		}

	}

	public static void switchToMainWindow(WebDriver driver) {
		driver.switchTo().window(mainwindow);

	}

	public static void setMainWindow(String windowHandle) {
		mainwindow = windowHandle;
	}

	public static void openNewTab(WebDriver driver) {
		((JavascriptExecutor) driver).executeScript("window.open()");
	}

	public static String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}

	public static String recordText(WebDriver driver, By locator) {
		return driver.findElement(locator).getText();
	}

	public static String getAttribute(WebDriver driver, By locator, String text) {
		return driver.findElement(locator).getAttribute(text);
	}

	public static void closeWebDriver(WebDriver driver) {
		driver.close();
	}

	public static void selectValueFromDropDown(WebDriver driver, By locator, String option) {
		javascript_highlight(driver, locator, "blue", "dotted", 3);
		Select select = new Select(driver.findElement(locator));
		select.selectByVisibleText(option);
	}

	public static void switchFrame(WebDriver driver, String idOrName) {
		WebDriverWait wait = new WebDriverWait(driver, WAITING_TIME);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(idOrName));
	}

	public static void switchToTopFrame(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

	public static void actionClick(By by, WebDriver driver) {
		javascript_highlight(driver, by, "blue", "dotted", 3);
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(by)).click(driver.findElement(by)).build().perform();
	}

	public static void clickException(WebDriver driver, By locator) throws InterruptedException {
		try {
			javascript_highlight(driver, locator, "blue", "dotted", 3);
			waitForElement(locator, driver);
			driver.findElement(locator).click();
		} catch (Exception e) {
			Thread.sleep(2000);
			javascript_highlight(driver, locator, "blue", "dotted", 3);
			driver.findElement(locator).click();
		}
	}

	public static void typeSlowly(WebDriver driver, By locator, String text) {
		waitForElement(locator, driver);
		do {
			javascript_highlight(driver, locator, "blue", "dotted", 3);
			try {
				// driver.findElement(locator).clear();
				for (String letter : text.split("")) {
					driver.findElement(locator).sendKeys(letter);
					Thread.sleep(150);
				}
				break;
			} catch (Exception e) {

			}
		} while (true);
	}

	public static void javaScrollIntoView(WebDriver driver, WebElement webElement) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView();", webElement);
	}

	public static void waitForPageLoad(WebDriver driver) {
		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString()
						.equals("complete");
			}
		};
		try {
			Thread.sleep(1000);
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(expectation);
		} catch (Throwable error) {
			//
		}
	}

	public static void javaClick(WebDriver driver, By by) {
		javascript_highlight(driver, by, "blue", "dotted", 3);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", driver.findElement(by));
	}

	public static void javaClick(WebDriver driver, WebElement pageElement) {
		javascript_highlight(driver, pageElement, "blue", "dotted", 3);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", pageElement);
	}

	public static void selectMultipleAnswers(WebDriver driver, By locator) {
		waitForElement(locator, driver);
		List<WebElement> list = driver.findElements(locator);
		for (WebElement webElement : list) {
			javaScrollIntoView(driver, webElement);
			javascript_highlight(driver, webElement, "blue", "dotted", 3);
			javaClick(driver, webElement);
		}
	}

	public static boolean isDisplayed(WebDriver driver, By by) {
		try {
			waitForVisibleElement(by, driver);
			javascript_highlight(driver, by, "green", "dotted", 3);
			boolean displayed = driver.findElement(by).isDisplayed();
			return displayed;
		} catch (NoSuchElementException | TimeoutException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean isEnabled(WebDriver driver, By by) {
		try {
			waitForVisibleElement(by, driver);
			javascript_highlight(driver, by, "green", "dotted", 3);
			boolean displayed = driver.findElement(by).isEnabled();
			return displayed;
		} catch (NoSuchElementException | TimeoutException e) {
			e.printStackTrace();
			return false;
		}
	}

}
