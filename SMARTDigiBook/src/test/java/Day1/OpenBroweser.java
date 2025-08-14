package Day1;

import java.util.Arrays;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class OpenBroweser {

	public Playwright playwright;
	public Browser browser;
	public Page page;

	@BeforeClass
	public void openBrowsser() {
		playwright = Playwright.create();
		BrowserType browserType = playwright.chromium();
		LaunchOptions launchOptions = new LaunchOptions();
		launchOptions.setHeadless(false)
		.setArgs(Arrays.asList("--start-maximized"));
		browser = browserType.launch(launchOptions);
		BrowserContext browserContext = browser.newContext(new Browser.NewContextOptions().setViewportSize(null));
		page = browserContext.newPage();
		page.navigate("https://reader.smartdigibook.com/");
	}

	@Test
	public void verifyLoginPage() {
		Locator smartDigiBookLogo = page.locator("img.logo");
		assertThat(smartDigiBookLogo).isVisible();
		Locator loginIntoApplicationTxt = page.locator("img.logo+p");
		assertThat(loginIntoApplicationTxt).isVisible();
		Locator indianFlag = page.locator("div.india-flag-div>img");
		assertThat(indianFlag).isVisible();
		Locator indianPinNum = page.locator("div.india-flag-div>p");
		assertThat(indianPinNum).isVisible();
		Locator loginPinTxt = page.locator("//span[text()='Login PIN ']/span");
		assertThat(loginPinTxt).isVisible();
		Locator mobileTxtfd = page.locator("id=contactNumber");
		assertThat(mobileTxtfd).isVisible();
		Locator passwordTxtfd = page.locator("input.otp-input");
		for(int i = 0 ; i < 5; i++) {
			Locator password = passwordTxtfd.nth(i);
			assertThat(password).isVisible();
		}
		Locator loginBtn = page.locator("id=btn_login");
		assertThat(loginBtn).isVisible();
		Locator forgetPinLnk = page.locator("span.forgot-pin > a");
		assertThat(forgetPinLnk).isVisible();
		Locator areYouAccount = page.locator("//*[contains(text(),'Are you ')]");
		assertThat(areYouAccount).isVisible();
		Locator createAccountBtn = page.locator("//button[text()='Create New Account']");
		assertThat(createAccountBtn).isVisible();
		Locator haveYouAccount = page.locator("p.newUserText");
		assertThat(haveYouAccount).isVisible();
		Locator howToUseLnk = page.locator("a.howToUseText");
		assertThat(howToUseLnk).isVisible();
		Locator navNeetImg = page.locator("div.bg");
		assertThat(navNeetImg).isVisible();

	}

	@Test(dependsOnMethods = "verifyLoginPage")
	public void loginIntoApplication() {
		Locator mobileTxtfd = page.locator("id=contactNumber");
		mobileTxtfd.fill("7702425817");
		Locator passwordTxtfd = page.locator("input.otp-input");
		String password = "111111";		
		for(int i = 0 ; i < password.length(); i++) {
			passwordTxtfd.nth(i).fill(password.charAt(i)+"");
		}
		Locator loginBtn = page.locator("id=btn_login");
		loginBtn.click();
		loginBtn.click();
		Locator myLibraryTxt = page.locator("h1.myLibrary-title");
		assertThat(myLibraryTxt).isVisible();
	}

	@AfterClass
	public void closeBrowser() {
		page.close();
		browser.close();
		playwright.close();
	}
}
