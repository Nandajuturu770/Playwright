package tests;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.microsoft.playwright.Page;

import generic.BaseTest;
import generic.DataReader;
import repository.LoginPage;
import static utils.DataReaderEnum.*;

public class LoginPageTests extends BaseTest {

	private Page page;
	LoginPage loginPage;
	DataReader dataReader;
	String mobileNumber;
	String password;

	@BeforeClass(alwaysRun = true)
	public void intialization() throws IOException {
		this.page = BaseTest.page;
		loginPage = new LoginPage(page);
		dataReader = new DataReader(CONF_PATH.getDataReader());
		mobileNumber = dataReader.getValueOfKey(PROD_USERNAME.getDataReader());
		password = dataReader.getValueOfKey(PROD_PASSWORD.getDataReader());
	}

	@Test(enabled = true, priority = 1, description = "Verify that user is able to see all elements of login page.")
	public void verifyLoginPageElemets() {
		loginPage.verifyLoginPage();
	}

	@Test(enabled = true, priority = 2, description = "Verify that user is able to login to application with valid.")
	public void loginIntoApplication() throws InterruptedException {
		loginPage.loginIntoApplication(mobileNumber, password);
	}
}