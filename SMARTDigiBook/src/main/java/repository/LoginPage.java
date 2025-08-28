package repository;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import generic.WebElementActions;

public class LoginPage extends WebElementActions{

	//* locators declaration
	private Locator smartDigiBookLogo;
	private Locator loginIntoApplicationTxt;
	private Locator indianFlag;
	private Locator indianPinNum;
	private Locator loginPinTxt;
	private Locator mobileTxtfd;
	private Locator passwordTxtfd;
	private Locator loginBtn;
	private Locator forgetPinLnk;
	private Locator areYouAccount;
	private Locator createAccountBtn;
	private Locator haveYouAccount;
	private Locator howToUseLnk;
	private Locator navNeetImg;

	//* locators initialization
	public LoginPage(Page page) {
		this.smartDigiBookLogo = page.locator("img.logo");
		this.loginIntoApplicationTxt = page.locator("img.logo+p");
		this.indianFlag = page.locator("div.india-flag-div>img");
		this.indianPinNum = page.locator("div.india-flag-div>p");
		this.loginPinTxt = page.locator("//span[text()='Login PIN ']/span");
		this.mobileTxtfd = page.locator("id=contactNumber");
		this.passwordTxtfd = page.locator("input.otp-input");
		this.loginBtn = page.locator("id=btn_login");
		this.forgetPinLnk = page.locator("span.forgot-pin > a");
		this.areYouAccount = page.locator("//*[contains(text(),'Are you ')]");
		this.createAccountBtn = page.locator("//button[text()='Create New Account']");
		this.haveYouAccount = page.locator("p.newUserText");
		this.howToUseLnk = page.locator("a.howToUseText");
		this.navNeetImg = page.locator("div.bg");
	}

	/**
	 * @description this method is used to verify login page elements.
	 */
	public void verifyLoginPage() {
		isDisplayed(smartDigiBookLogo);
		isDisplayed(loginIntoApplicationTxt);
		isDisplayed(indianFlag);
		isDisplayed(indianPinNum);
		isDisplayed(loginPinTxt);
		isDisplayed(mobileTxtfd);
		passwordTxtfd.all().forEach(locator -> {isDisplayed(locator);});
		isDisplayed(loginBtn);
		isDisplayed(forgetPinLnk);
		isDisplayed(areYouAccount);
		isDisplayed(createAccountBtn);
		isDisplayed(haveYouAccount);
		isDisplayed(howToUseLnk);
		isDisplayed(navNeetImg);
	}

	/**
	 * @descripton this method is used to user login to application.
	 * @param mobileNumber <code>String</code>
	 * @param password     <code>String</code>
	 */
	public void loginIntoApplication(String mobileNumber, String password) {
		enter(mobileTxtfd, mobileNumber);
		passwordTxtfd.all().forEach(locator -> {int i = 0;enter(locator, password.charAt(i++)+"");});

	}

	/**
	 * @description this method is used to navigate to create account page.
	 */
	public void navigateCreateAccountPage() {
		click(createAccountBtn);
	}

	/**
	 * @description this method is used to navigate to reset pin page.
	 */
	public void navigateResetPinPage() {
		click(forgetPinLnk);
	}
}