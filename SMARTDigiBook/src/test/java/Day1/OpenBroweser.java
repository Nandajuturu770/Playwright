package Day1;

import java.util.Arrays;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

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
	public void loginToApplication() {
		Locator mobileTxtfd = page.locator("id=contactNumber");
		mobileTxtfd.fill("7702425817");
		Locator passwordTxtfd = page.locator("input.otp-input");
		String password = "111111";
		for(int i = 0 ; i < password.length(); i++) {
			passwordTxtfd.nth(i).fill(password.charAt(i)+"");
		}
		Locator loginBtn = page.locator("id=btn_login");
		loginBtn.click();
		page.navigate("https://navdisha.navneet.com/");
	}
}
