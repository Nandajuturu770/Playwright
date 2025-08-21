package generic;

import org.testng.asserts.SoftAssert;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;
import com.microsoft.playwright.options.WaitForSelectorState;

public class Synchronize {

	public static SoftAssert softAssert;

	static {
		softAssert = new SoftAssert();
	}
	
	/**
	 * @description this method is used to wait until page load is completed within time
	 * @param page    <code>Page</code>
	 * @param seconds <code>int</code>
	 */
	public static void waitForPageLoad(Page page, int seconds) {
	    page.waitForLoadState(LoadState.NETWORKIDLE, new Page.WaitForLoadStateOptions().setTimeout(seconds*1000));
	}


	/**
	 * @description this is method is used to wait till element is visible till 15 seconds.
	 * @param locator <code>Locator</code>
	 */
	public static void waitTillElementVisible(Locator locator) {
		try{
			locator.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE).setTimeout(15000));
		}catch (Exception exception) {
			softAssert.fail(locator+" element is not found, please check below :: \n"+exception.getMessage());
			softAssert.assertAll();
		}
	}

	/**
	 * @description this is method is used to wait till element is visible till given seconds.
	 * @param locator <code>Locator</code>
	 * @param second  <code>int</code>
	 */
	public static void waitTillElementVisibleWithinTime(Locator locator , int second) {
		try{
			locator.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE).setTimeout(second*1000));
		}catch (Exception exception) {
			softAssert.fail(locator+" element is not found with in givem "+second+" second time, please check below :: \n"+exception.getMessage());
			softAssert.assertAll();
		}
	}
}
