package generic;

import java.io.IOException;
import java.util.Arrays;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.Cookie;

import static utils.DataReaderEnum.*;

import com.microsoft.playwright.BrowserType.LaunchOptions;

public class BaseTest {

	private static DataReader dataReader;
	private static Playwright playwright;
	private static Browser browser;
	private static BrowserContext browserContext;
	public  static Page page;

	@BeforeClass
	public void openBrowsser() throws IOException {
		// getting from properties file
		dataReader = new DataReader(CONF_PATH.getDataReader());
		playwright = Playwright.create();
		BrowserType browserType = playwright.chromium();
		LaunchOptions launchOptions = new LaunchOptions();
		launchOptions.setHeadless(false);
		//.setArgs(Arrays.asList("--start-maximized"));
		browser = browserType.launch(launchOptions);
		browserContext = browser.newContext();//new Browser.NewContextOptions().setViewportSize(null)
		Cookie cookie = new Cookie("App_promotion_popup", "true");
		cookie.setDomain("reader.smartdigibook.com");
		cookie.setPath("/");
		browserContext.addCookies(Arrays.asList(cookie));
		page = browserContext.newPage();
		page.navigate(dataReader.getValueOfKey(PROD_URL.getDataReader()));
	}

	@AfterClass
	public void closeBrowser() {
		page.close();
		browser.close();
		playwright.close();
	}

	public static BrowserContext getBrowserContext() {
		return browserContext;
	}
}