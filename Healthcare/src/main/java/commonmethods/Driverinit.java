package commonmethods;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;

import PageActions.AccountConfirmationActions;
import PageActions.ApplicationHelpActions;
import PageActions.ChangesInCoverageActions;
import PageActions.CitizenshipImmigrationStatusActions;
import PageActions.ContactInformationActions;
import PageActions.ContactInformationActionsNewApplication;
import PageActions.ContactPreferencesActions;
import PageActions.CreateAccountActions;
import PageActions.CurrentCoverageActions;
import PageActions.DisabilitiesHelpWithActivitiesActions;
import PageActions.HelpPayingMedicalBillsActions;
import PageActions.HomeAddressActions;
import PageActions.HouseholdIncomeActions;
import PageActions.HouseholdInformationActions;
import PageActions.IdentityQuestionsActions;
import PageActions.IdentityVerifiedActions;
import PageActions.LandingPageActions;
import PageActions.MailingAddressActions;
import PageActions.MaritalStatusActions;
import PageActions.MarketPlacePageActions;
import PageActions.MedicaidCHIPDenialActions;
import PageActions.MyApplicationsAndCoverageActions;
import PageActions.MyProfileActions;
import PageActions.ParentsCaretakerRelativesActions;
import PageActions.PreferredLanguageActions;
import PageActions.RandonEmailActions;
import PageActions.ReadAgreeStatementsActions;
import PageActions.ReviewUserIncomeExpensesActions;
import PageActions.ReviewYourApplicationActions;
import PageActions.SignSubmitActions;
import PageActions.StartApplicationActions;
import PageActions.Stub;
import PageActions.TaxRelationshipsActions;
import PageActions.TellUsAboutYoutSelfActions;
import PageActions.UserCitizenshipActions;
import PageActions.UserInformationActions;
import PageActions.VerifyYourIdentitityActions;
import PageActions.WhoNeedsHealthCoverageActions;

public class Driverinit {
	static WebDriver driver = null;

	public static WebDriver init(String Browser) {
		if (Browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "src/test/java/drivers/chromedriver_Win.exe");
			ChromeOptions chromeoptions = new ChromeOptions();
			// chromeoptions.setBinary("C:\\Program Files
			// (x86)\\BraveSoftware\\Brave-Browser\\Application\\brave.exe");
			chromeoptions.setPageLoadStrategy(PageLoadStrategy.NONE);
			chromeoptions.addArguments("start-maximized");
			chromeoptions.addArguments("enable-automation");
			// options.addArguments("--headless");
			chromeoptions.addArguments("--no-sandbox");
			chromeoptions.addArguments("--disable-infobars");
			chromeoptions.addArguments("--disable-dev-shm-usage");
			chromeoptions.addArguments("--disable-browser-side-navigation");
			chromeoptions.addArguments("--disable-gpu");
			chromeoptions.setAcceptInsecureCerts(true);
			driver = new ChromeDriver(chromeoptions);
			Driverinit.initPage(driver);
			return driver;
		} else if (Browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "src/test/java/drivers/geckodriver_Win.exe");
			ProfilesIni prof = new ProfilesIni();
			FirefoxProfile ffProfile = prof.getProfile("default");
			FirefoxOptions ffoptions = new FirefoxOptions();
			ffoptions.setProfile(ffProfile);
			ffoptions.setAcceptInsecureCerts(true);
			ffoptions.setCapability("marionette", true);
			ffoptions.setPageLoadStrategy(PageLoadStrategy.NONE);
			driver = new FirefoxDriver(ffoptions);
			Driverinit.initPage(driver);
			return driver;
		} else if (Browser.equalsIgnoreCase("edge")) {
			EdgeOptions edgeoptions = new EdgeOptions();
			driver = new EdgeDriver(edgeoptions);
			Driverinit.initPage(driver);
			return driver;
		}

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return driver;

	}

	public static void initPage(WebDriver driver) {
		LandingPageActions landingPageActions = new LandingPageActions(driver);
		RandonEmailActions randonEmailActions = new RandonEmailActions(driver);
		CreateAccountActions createAccountActions = new CreateAccountActions(driver);
		AccountConfirmationActions accountConfirmationActions = new AccountConfirmationActions(driver);
		Stub stub= new Stub(driver);
		MarketPlacePageActions marketPlacePageActions= new MarketPlacePageActions(driver);
		MyProfileActions myProfileActions = new MyProfileActions(driver);
		VerifyYourIdentitityActions verifyYourIdentitityActions = new VerifyYourIdentitityActions(driver);
		ContactInformationActions contactInformationActions = new ContactInformationActions(driver);
		IdentityQuestionsActions identityQuestionsActions = new IdentityQuestionsActions(driver);
		IdentityVerifiedActions identityVerifiedActions = new IdentityVerifiedActions(driver);
		MyApplicationsAndCoverageActions myApplicationsAndCoverageActions= new MyApplicationsAndCoverageActions(driver);
		StartApplicationActions StartApplicationActions = new StartApplicationActions(driver);
		TellUsAboutYoutSelfActions TellUsAboutYoutSelf= new TellUsAboutYoutSelfActions(driver);
		HomeAddressActions HomeAddressActions = new HomeAddressActions(driver);
		MailingAddressActions MailingAddressActions = new MailingAddressActions(driver);
		ContactInformationActionsNewApplication ContactInformationActionsNewApplication = new ContactInformationActionsNewApplication(driver);
		PreferredLanguageActions PreferredLanguageActions = new PreferredLanguageActions(driver);
		ContactPreferencesActions ContactPreferencesActions= new ContactPreferencesActions(driver);
		ApplicationHelpActions ApplicationHelpActions= new ApplicationHelpActions(driver);
		WhoNeedsHealthCoverageActions WhoNeedsHealthCoverageActions = new WhoNeedsHealthCoverageActions(driver);
		MaritalStatusActions MaritalStatusActions= new MaritalStatusActions(driver);
		TaxRelationshipsActions TaxRelationshipsActions = new TaxRelationshipsActions(driver);
		ParentsCaretakerRelativesActions ParentsCaretakerRelativesActions = new ParentsCaretakerRelativesActions(driver);
		HouseholdInformationActions HouseholdInformationActions= new HouseholdInformationActions(driver);
		UserInformationActions UserInformationActions = new UserInformationActions(driver);
		CitizenshipImmigrationStatusActions CitizenshipImmigrationStatusActions = new CitizenshipImmigrationStatusActions(driver);
		UserCitizenshipActions UserCitizenshipActions = new UserCitizenshipActions(driver);
		DisabilitiesHelpWithActivitiesActions DisabilitiesHelpWithActivitiesActions = new DisabilitiesHelpWithActivitiesActions(driver);
		MedicaidCHIPDenialActions MedicaidCHIPDenialActions = new MedicaidCHIPDenialActions(driver);
		ChangesInCoverageActions ChangesInCoverageActions = new ChangesInCoverageActions(driver);
		HouseholdIncomeActions HouseholdIncomeActions = new HouseholdIncomeActions(driver);
		ReviewUserIncomeExpensesActions ReviewUserIncomeExpensesActions = new ReviewUserIncomeExpensesActions(driver);
		CurrentCoverageActions CurrentCoverageActions= new CurrentCoverageActions(driver);
		HelpPayingMedicalBillsActions HelpPayingMedicalBillsActions= new HelpPayingMedicalBillsActions(driver);
		ReviewYourApplicationActions ReviewYourApplicationActions= new ReviewYourApplicationActions(driver);
		ReadAgreeStatementsActions ReadAgreeStatementsActions = new ReadAgreeStatementsActions(driver);
		SignSubmitActions SignSubmitActions = new SignSubmitActions(driver);
	}

}
