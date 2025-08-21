package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.microsoft.playwright.Page;

import generic.BaseTest;
import repository.LoginPage;

public class LoginPageTests extends BaseTest {

	private Page page;
	LoginPage loginPage;
	String mobileNumber = "7702425817";
	String password = "111111";

	@BeforeClass(alwaysRun = true)
	public void intialization() {
		this.page = BaseTest.page;
		loginPage = new LoginPage(page);
	}

	@Test(enabled =  true, priority = 1, description = "Verify that user is able to see all elements of login page.")
	public void verifyLoginPageElemets() {
		loginPage.verifyLoginPage();
	}

	@Test(enabled =  true, priority = 2, description = "Verify that user is able to login to application with valid.")
	public void loginIntoApplication() {
		loginPage.loginIntoApplication(mobileNumber, password);
	}
}
