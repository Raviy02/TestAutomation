package tests;

import java.io.IOException;
import java.util.ArrayList;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

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
import commonmethods.Driverinit;

public class TestScriptPOM {
	WebDriver driver;
	String url = "https://www.healthcare.gov/login";

	@BeforeTest
	@Parameters("browser")
	public void init(@Optional("chrome") String Browser) throws IOException {
		driver = Driverinit.init(Browser);
		driver.manage().deleteAllCookies();
	}

//press ctrl+f11 to run the script
	@Test
	public void createAccount() throws InterruptedException {

		LandingPageActions.openLandingPage(url);
		LandingPageActions.verifyPageTitle("Health Insurance Marketplace for Individuals | HealthCare.gov");

//Yop id generation start

		/*
		 * RandonEmailActions.generateRandomEmailId(); String email =
		 * RandonEmailActions.recordEmailId(); System.out.println(email);
		 * LandingPageActions.clickCreateOne();
		 * CreateAccountActions.selectState("Delaware");
		 * CreateAccountActions.enterFirstName("Susan");
		 * CreateAccountActions.enterLastName("Griffith");
		 * CreateAccountActions.enterEmailId(email);
		 * CreateAccountActions.enterPassword("Test123#");
		 * CreateAccountActions.reEnterPassword("Test123#");
		 * CreateAccountActions.pickFirstQuestion("What is your favorite radio station?"
		 * ); CreateAccountActions.enterFirstAnswer("station"); CreateAccountActions.
		 * pickSecondQuestion("What was your favorite toy when you were a child?");
		 * CreateAccountActions.enterSecondAnswer("child");
		 * CreateAccountActions.pickThirdQuestion("What is your favorite cuisine?");
		 * CreateAccountActions.enterThirdAnswer("cuisine");
		 * CreateAccountActions.acceptAgreement();
		 * CreateAccountActions.clickCreateAccount();
		 * RandonEmailActions.clickCheckMails();
		 * RandonEmailActions.clickCheckForNewMails();
		 * RandonEmailActions.clickVerificationLink();
		 * AccountConfirmationActions.clickContinueToLogin();
		 * LandingPageActions.enterUserName(email);
		 */

// Yop id generation end

// Using of Existing ID

		LandingPageActions.enterUserName("aqottaroc-4975@yopmail.com");
		LandingPageActions.enterPassword("Test123#");
		LandingPageActions.clickLoginButton();
		MarketPlacePageActions.verifyPageTitle("Welcome to the Marketplace");
		MarketPlacePageActions.clickUserPorfile();

//Comment this guy to use exiting mail ID 

		MarketPlacePageActions.clickMyProfileOption();
		MyProfileActions.verifyPageTitle("My Profile");
		MyProfileActions.clickVerifyNow();
		VerifyYourIdentitityActions.clickGetStarted();
		ContactInformationActions.verifyPageTitle("Contact Information");
		ContactInformationActions.enterLastName("Griffith");
		ContactInformationActions.enterDOB("01011990");
		ContactInformationActions.enterStreetAddress("34 Elsmere Blvd");
		ContactInformationActions.enterCity("Wilmington");
		ContactInformationActions.enterZipCode("19805");
		ContactInformationActions.enterPhoneNumber("2025547416");
		ContactInformationActions.selectPhoneType("Home");
		ContactInformationActions.clickContinueButton();
		IdentityQuestionsActions.verifyPageTitle("Identity Questions");
		IdentityQuestionsActions.answerAllQuestions("NONE OF THE ABOVE/DOES NOT APPLY");
		IdentityQuestionsActions.clickContinueButton();
		IdentityVerifiedActions.verifyPageTitle("Identity Verified");
		IdentityVerifiedActions.clickContinueButton();
		MyProfileActions.verifyPageTitle("My Profile");

		MyProfileActions.clickMyApplicationsAndCoverage();
		MyApplicationsAndCoverageActions.verifyPageTitle("My Applications & Coverage");
		MyApplicationsAndCoverageActions.selectYear("2019");
		MyApplicationsAndCoverageActions.selectState("DE");
		MyApplicationsAndCoverageActions.clickApplyOrRenewButton();
		StartApplicationActions.verifyPageTitle("Start Application");
		StartApplicationActions.clickNextButton();
		StartApplicationActions.acceptTerms();
		StartApplicationActions.clickTakeMeToApplicationButton();
		StartApplicationActions.selectMaritialStatue("single");
		StartApplicationActions.selectTaxDependents("0");
		StartApplicationActions.selectIncome("Below51000");
		StartApplicationActions.selectHelpforCoverage("Yes");
		StartApplicationActions.clickContinueButton();
		TellUsAboutYoutSelfActions.verifyPageTitle("Tell us about yourself");
		TellUsAboutYoutSelfActions.typeMonth("01");
		TellUsAboutYoutSelfActions.typeDay("01");
		TellUsAboutYoutSelfActions.typeYear("1990");
		TellUsAboutYoutSelfActions.selectSex("Female");
		TellUsAboutYoutSelfActions.clickSave();
		HomeAddressActions.verifyPageTitle("Home address");
		HomeAddressActions.enterStreetAddress("34 Elsmere Blvd");
		HomeAddressActions.enterCity("Wilmington");
		HomeAddressActions.enterZipCode("19805");
		HomeAddressActions.clickSave();
		HomeAddressActions.selectUSPSAddress();
		HomeAddressActions.clickSave();
		MailingAddressActions.verifyPageTitle("Mailing address");
		MailingAddressActions.acceptMailingAddress();
		MailingAddressActions.clickSave();
		ContactInformationActionsNewApplication.verifyPageTitle("Contact information");
		ContactInformationActionsNewApplication.enterPhoneNumber("2025547416");
		ContactInformationActionsNewApplication.selectPhoneType("Home");
		ContactInformationActionsNewApplication.clickSave();
		PreferredLanguageActions.verifyPageTitle("Contact information");
		PreferredLanguageActions.clickSave();
		ContactPreferencesActions.verifyPageTitle("Contact preferences");
		ContactPreferencesActions.selectPreference("Paper");
		ContactPreferencesActions.clickSave();
		ApplicationHelpActions.verifyPageTitle("Application help");
		ApplicationHelpActions.selectOption("No");
		ApplicationHelpActions.clickSave();
		WhoNeedsHealthCoverageActions.verifyPageTitle("Who needs health coverage?");
		WhoNeedsHealthCoverageActions.clickSave();
		MaritalStatusActions.verifyPageTitle("Marital status");
		MaritalStatusActions.selectMaritialStatue("single");
		MaritalStatusActions.clickSave();
		TaxRelationshipsActions.verifyPageTitle("Tax relationships");
		TaxRelationshipsActions.answerFirstQuestion("Yes");
		TaxRelationshipsActions.answerSecondQuestion("No");
		TaxRelationshipsActions.answerThirdQuestion("No");
		TaxRelationshipsActions.clickSave();
		ParentsCaretakerRelativesActions.verifyPageTitle("Parents & caretaker relatives");
		ParentsCaretakerRelativesActions.selectDependent("No");
		ParentsCaretakerRelativesActions.clickSave();
		HouseholdInformationActions.verifyPageTitle("Household information");
		HouseholdInformationActions.selectOption("No");
		HouseholdInformationActions.clickSave();
		UserInformationActions.verifyPageTitle("Susan's information");
		UserInformationActions.clickSave();
		UserInformationActions.selectNoSSN();
		UserInformationActions.clickSave();
		CitizenshipImmigrationStatusActions.verifyPageTitle("Citizenship & Immigration Status");
		CitizenshipImmigrationStatusActions.selectOption("Yes");
		CitizenshipImmigrationStatusActions.clickSave();
		UserCitizenshipActions.verifyPageTitle("Susan's citizenship");
		UserCitizenshipActions.selectOption("No");
		UserCitizenshipActions.clickSave();
		DisabilitiesHelpWithActivitiesActions.verifyPageTitle("Disabilities & help with activities");
		DisabilitiesHelpWithActivitiesActions.clickSave();
		MedicaidCHIPDenialActions.verifyPageTitle("Medicaid or CHIP denial");
		MedicaidCHIPDenialActions.clickSave();
		ChangesInCoverageActions.verifyPageTitle("Changes in coverage");
		ChangesInCoverageActions.clickSave();
		HouseholdIncomeActions.verifyPageTitle("Household income");
		HouseholdIncomeActions.clickSave();
		ReviewUserIncomeExpensesActions.verifyPageTitle("Review Susan's income & expenses");
		ReviewUserIncomeExpensesActions.acceptIncome();
		ReviewUserIncomeExpensesActions.clickSave();
		CurrentCoverageActions.verifyPageTitle("Current coverage");
		CurrentCoverageActions.clickSave();
		HelpPayingMedicalBillsActions.verifyPageTitle("Help paying medical bills");
		HelpPayingMedicalBillsActions.clickSave();
		ReviewYourApplicationActions.verifyPageTitle("Review your application");
		ReviewYourApplicationActions.clickSave();

		ReadAgreeStatementsActions.verifyPageTitle("Read & agree to these statements");
		ReadAgreeStatementsActions.acceptAgreement();
		ReadAgreeStatementsActions.clickSave();
		SignSubmitActions.verifyPageTitle("Sign & submit");
		SignSubmitActions.acceptAgreement();
		SignSubmitActions.enterName("Susan Griffith");
		SignSubmitActions.clickSave();
		/*
		 * IndividualApplicationEligibilityDeterminationActions.
		 * verifyPageTitle("Individual Application - Eligibility determination");
		 * IndividualApplicationEligibilityDeterminationActions.
		 * clickViewEligibilityNoticeButton();
		 */

	}

	/*
	 * @AfterTest public void shutDown() { driver.quit(); }
	 * 
	 * @AfterClass public void cleanUp() { try {
	 * Runtime.getRuntime().exec("taskkill /F /IM chromedriver_Win.exe /T");
	 * Runtime.getRuntime().exec("taskkill /F /IM geckodriver_Win.exe /T");
	 * Runtime.getRuntime().exec("taskkill /F /IM Microsoft Edge.exe /T"); } catch
	 * (IOException e) { // TODO Auto-generated catch block e.printStackTrace();
	 * 
	 * } }
	 */

}
