package repository;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

import generic.WebElementActions;

public class CreateAccountPage extends WebElementActions{

	Page page;

	//* locators declaration
	private final Locator createAccountBtn;
	private final Locator smartDigiBookIcon;
	private final Locator createAccountHeadingTxt;
	private final Locator createAccountMessageTxt;
	private final Locator firstNameTxtfd;
	private final Locator lastNameTxtfd;
	private final Locator securityPinTxtfd;
	private final Locator securityPinMessageTxt;
	private final Locator emailTxtfd;
	private final Locator contactNumberTxtfd;
	private final Locator getOtpBtn;
	private final Locator stateDropdown;
	private final Locator cityDropdown;
	private final Locator checkbox;
	private final Locator agreeMessage;
	private final Locator privacyLnk;
	private final Locator continueBtn;
	private final Locator havingTroubleTxt;
	private final Locator havingTroubleAnimation;
	private final Locator alreadyHaveAccountTxt;
	private final Locator loginLnk;

	//* locators initialization
	public CreateAccountPage(Page page) {
		this.page = page;
		this.createAccountBtn = page.locator("//button[text()='Create New Account']");
		this.smartDigiBookIcon = page.locator("a[href='/login']>img");
		this.createAccountHeadingTxt = page.getByRole(AriaRole.HEADING,
				new Page.GetByRoleOptions().setName("Create Your Account To Join SMART DigiBook"));
		this.createAccountMessageTxt = page.locator("p.create-account-message");
		this.firstNameTxtfd = page.locator("id=firstName");
		this.lastNameTxtfd = page.locator("id=lastName");
		this.securityPinTxtfd = page.locator("id=securityPin");
		this.securityPinMessageTxt = page.locator("p.useDigitsNumbersText");
		this.emailTxtfd = page.locator("id=email");
		this.contactNumberTxtfd = page.locator("id=contactNumber");
		this.getOtpBtn = page.getByRole(AriaRole.BUTTON,
				new Page.GetByRoleOptions().setName("Get OTP"));
		this.stateDropdown = page.locator("div#state");
		this.cityDropdown = page.locator("div#city");
		this.checkbox = page.locator("id=agreement");
		this.agreeMessage = page.locator("//input[@id='agreement']/../../span").last();
		this.privacyLnk = page.locator("a.anchorTagPrivacy");
		this.continueBtn = page.locator("div.registration-loginButton");
		this.havingTroubleTxt = page.locator("p.havingTroubleText").first();
		this.havingTroubleAnimation = page.locator("p.havingTroubleText+div>img");
		this.alreadyHaveAccountTxt = page.locator("p.havingTroubleText").last();
		this.loginLnk = page.locator("span.how-to-use-link");
	}

	/**
	 * @description this method is used to verify elements of create account page.
	 */
	public void verifyCreateAccountElements() {
		click(createAccountBtn);
		waitTillElementVisible(createAccountHeadingTxt);
		isDisplayed(smartDigiBookIcon);
		isDisplayed(createAccountHeadingTxt);
		isDisplayed(createAccountMessageTxt);
		isDisplayed(firstNameTxtfd);
		isDisplayed(lastNameTxtfd);
		isDisplayed(securityPinTxtfd);
		isDisplayed(securityPinMessageTxt);
		isDisplayed(emailTxtfd);
		isDisplayed(contactNumberTxtfd);
		isDisplayed(getOtpBtn);
		isDisplayed(stateDropdown);
		isDisplayed(cityDropdown);
		isDisplayed(checkbox);
		isDisplayed(agreeMessage);
		isDisplayed(privacyLnk);
		isDisplayed(continueBtn);
		isDisplayed(havingTroubleTxt);
		isDisplayed(havingTroubleAnimation);
		isDisplayed(alreadyHaveAccountTxt);
		isDisplayed(loginLnk);
	}

	/**
	 * @description this method is used to navigate to login page.
	 */
	public void navigateLoingPage() {
		click(loginLnk);
		waitForPageLoad(page,30);
		isDisplayed(createAccountBtn);
	}

}
