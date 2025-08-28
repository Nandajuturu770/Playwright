package generic;

import org.testng.asserts.SoftAssert;

import com.microsoft.playwright.Locator;

public class WebElementActions extends Synchronize{

	public static SoftAssert softAssert = Synchronize.softAssert;

	/**
	 * @description this method is used to verify element is displayed or not.
	 * @param locator <code>Locator</code>
	 * @return result <code>boolean</code>
	 */
	public static boolean isDisplayed(Locator locator) {
		try{
			softAssert.assertEquals(true, locator.isDisabled(), locator+" element is not found");
			return true;
		}catch (Exception exception) {
			softAssert.fail(locator+" element is not found");
		}
		softAssert.assertAll();
		return false;
	}

	/**
	 * @description this method is used to click on element.
	 * @param locator <code>Locator</code>
	 */
	public static void click(Locator locator) {
		try{
			locator.click();
		}catch (Exception exception) {
			softAssert.fail(locator+" element is not found, please check below :: \n"+exception.getMessage());
			softAssert.assertAll();
		}
	}

	/**
	 * @description this method is used to enter into element.
	 * @param locator <code>Locator</code>
	 * @param input   <code>String</code>
	 */
	public static void enter(Locator locator, String input) {
		try{
			locator.fill(input);
		}catch (Exception exception) {
			softAssert.fail(locator+" element is not found, please check below :: \n"+exception.getMessage());
			softAssert.assertAll();
		}
	}	
}