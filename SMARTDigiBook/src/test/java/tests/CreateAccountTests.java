package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.microsoft.playwright.Page;

import generic.BaseTest;
import repository.CreateAccountPage;

public class CreateAccountTests extends BaseTest{
	
	private Page page;
	CreateAccountPage createAccountPage;
	
	@BeforeClass
	public void initiazition() {
		page = BaseTest.page;
		createAccountPage = new CreateAccountPage(page);
	}
	
	@Test(enabled = true, priority = 1, description = "Verify that user is able to see all fields of create account page.")
	public void verifyCreateAccountElements() {
		createAccountPage.verifyCreateAccountElements();
		createAccountPage.navigateLoingPage();
	}
}
