package locators;

import java.util.Arrays;
import java.util.List;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Browser.NewContextOptions;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Page.GetByRoleOptions;
import com.microsoft.playwright.Playwright;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import com.microsoft.playwright.options.AriaRole;

public class GetLocators {

	Playwright playwright;
	BrowserType browserType;
	BrowserContext browserContext;
	LaunchOptions launchOptions;
	Browser browser;
	Page page;

	String URL = "https://reader.smartdigibook.com/";

	@BeforeClass
	public void openBrowser() {
		playwright = Playwright.create();
		browserType = playwright.chromium();
		launchOptions = new LaunchOptions();
		launchOptions.setHeadless(false)
		.setArgs(Arrays.asList("--start-maximized"));
		browser = browserType.launch(launchOptions);
		browserContext = browser.newContext(new NewContextOptions().setViewportSize(null));
		page = browserContext.newPage();
		page.navigate(URL);
	}

	@Test
	public void verifyCreateAccount() {
		// locators
		Locator smartDigiBookIcon = page.locator("a[href='/login']>img");
		Locator createAccountHeadingTxt = page.getByRole(AriaRole.HEADING, new GetByRoleOptions().setName("Create Your Account To Join SMART DigiBook"));
		Locator createAccountMessageTxt = page.locator("p.create-account-message");
		Locator firstNameTxtfd = page.locator("id=firstName");
		Locator lastNameTxtfd = page.locator("id=lastName");
		Locator securityPinTxtfd = page.locator("id=securityPin");
		Locator securityPinMessageTxt = page.locator("p.useDigitsNumbersText");
		Locator emailTxtfd = page.locator("id=email");
		Locator contactNumberTxtfd = page.locator("id=contactNumber");
		Locator getOtpBtn = page.getByRole(AriaRole.BUTTON, new GetByRoleOptions().setName("Get OTP"));
		Locator stateDropdown = page.locator("name=state");
		stateDropdown.click();
		List<Locator> stateValues = page.getByRole(AriaRole.LISTITEM).all();
		stateValues.forEach(locator -> {System.out.println(locator.textContent());});
		Locator cityDropdown = page.locator("name=city");
		Locator cityValues = page.getByRole(AriaRole.LISTITEM);
		int citiesCount = cityValues.count();
		for (int i = 0; i < citiesCount; i++) {
			Locator city = cityValues.nth(i);
			System.out.println(city.textContent());			
		}
		Locator checkbox = page.locator("id=agreement");
		Locator agreeMessage = page.locator("//input[@id='agreement']/../../span").last();
		Locator privacyLnk = page.locator("a.anchorTagPrivacy");
		Locator continueBtn = page.locator("div.registration-loginButton");
		Locator havingTroubleTxt = page.locator("p.havingTroubleText").first();
		Locator havingTroubleAnimation = page.locator("p.havingTroubleText+div>img");
		Locator alreadyHaveAccountTxt = page.locator("p.havingTroubleText").last();
		Locator loginLnk = page.locator("span.how-to-use-link");
		// validation
		isVisibled(smartDigiBookIcon);
		isVisibled(createAccountHeadingTxt);
		isVisibled(createAccountMessageTxt);
		isVisibled(firstNameTxtfd);
		isVisibled(lastNameTxtfd);
		isVisibled(securityPinTxtfd);
		isVisibled(securityPinMessageTxt);
		isVisibled(emailTxtfd);
		isVisibled(contactNumberTxtfd);
		isVisibled(getOtpBtn);
		isVisibled(checkbox);
		isVisibled(agreeMessage);
		isVisibled(privacyLnk);
		isVisibled(continueBtn);
		isVisibled(havingTroubleTxt);
		isVisibled(havingTroubleAnimation);
		isVisibled(alreadyHaveAccountTxt);
		isVisibled(loginLnk);
	}

	public void isVisibled(Locator locator) {
		assertThat(locator).isVisible();
	}

}
