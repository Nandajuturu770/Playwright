package repository;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import generic.WebElementActions;

public class ForgetPasswordPage extends WebElementActions{

	Page page;

	//* elements declaration
	private Locator smartDigiBookLogo;
	private Locator resetPinTitleTxt;
	private Locator pleaseEnterTxt;
	private Locator indiaFlagImg;
	private Locator indiaPinTxt;
	private Locator mobileTxtFd;
	private Locator sentNoficationBtn;

	//* elements initialization
	public ForgetPasswordPage(Page page) {
		this.page = page;
		this.smartDigiBookLogo = page.locator("a[href='/login']");
		this.resetPinTitleTxt = page.locator("h1.forgot-security-pin");
		this.pleaseEnterTxt = page.locator("p.forgot-security-pin-message");
		this.indiaFlagImg = page.locator("div.india-flag-div>img");
		this.indiaPinTxt = page.locator("div.india-flag-div>p");
		this.mobileTxtFd = page.locator("#contactNumber");
		this.sentNoficationBtn = page.locator("button[type='button']");
	}

	/**
	 * @description this method is used to verify the forget password page.
	 * @param mobileNumber <code>String</code>
	 */
	public void verifyAllElementOfForgetPasswordPage(String mobileNumber) {
		isDisplayed(resetPinTitleTxt);
		isDisplayed(pleaseEnterTxt);
		isDisplayed(indiaFlagImg);
		isDisplayed(indiaPinTxt);
		isDisplayed(mobileTxtFd);
		isDisplayed(sentNoficationBtn);
		enter(mobileTxtFd, mobileNumber);
		click(sentNoficationBtn);
	}

	/**
	 * @description this method is used to navigate to login page.
	 */
	public void navigaterLoginPage() {
		click(smartDigiBookLogo);
	}

}
