package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.microsoft.playwright.Page;

import generic.BaseTest;
import repository.CreateAccountPage;
import repository.ForgetPasswordPage;
import repository.LoginPage;

public class CreateAccountTests extends BaseTest{

	private Page page;
	LoginPage loginPage;
	CreateAccountPage createAccountPage;
	ForgetPasswordPage forgetPasswordPage;

	@BeforeClass
	public void initiazition() {
		page = BaseTest.page;
		loginPage = new LoginPage(page);
		createAccountPage = new CreateAccountPage(page);
		forgetPasswordPage = new ForgetPasswordPage(page);
	}

	@Test(enabled = true, priority = 1, description = "Verify that user is able to see all fields of create account page.")
	public void verifyCreateAccountElements() {
		loginPage.navigateCreateAccountPage();
		createAccountPage.verifyCreateAccountElements();
		createAccountPage.navigateLoingPage();
	}

	@Test(enabled = true, priority = 2, description = "Verify that user is able to see all fields of reset pin page.")
	public void verifyResetPinElements() {
		loginPage.navigateResetPinPage();
		forgetPasswordPage.verifyAllElementOfForgetPasswordPage("7702425817");
		forgetPasswordPage.navigaterLoginPage();
	}


}