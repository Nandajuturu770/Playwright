package generic;

import org.testng.asserts.SoftAssert;

import com.microsoft.playwright.Locator;

import io.qameta.allure.Allure;

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
			Allure.step(locator +" is displayed.");
			return true;
		}catch (Exception exception) {
			softAssert.fail(locator+" element is not found.");
		}
		softAssert.assertAll();
		return false;
	}

	/**
	 * @description this method is used to check the element is presented or not.
	 * @param locator <code>Locator</code>
	 * @return result <code>boolean</code>
	 */
	public static boolean checkElementIsPresented(Locator locator) {
		try{
			locator.isDisabled();
			Allure.step(locator +" is displayed.");
			return true;
		}catch (Exception exception) {
			Allure.step(locator +" is not displayed.");
			return false;
		}
	}

	/**
	 * @description this method is used to click on element.
	 * @param locator <code>Locator</code>
	 */
	public static void click(Locator locator) {
		try{
			locator.click();
			Allure.step(locator+" is clicked.");
		}catch (Exception exception) {
			softAssert.fail(locator+" element is not found, please check below :: \n"+exception.getMessage());
			softAssert.assertAll();
		}
	}

	/**
	 * @description this method is used to double
	 * @param locator
	 */
	public static void doubleClick(Locator locator) {
		try{
			locator.dblclick();;
			Allure.step(locator+" is double clicked.");
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
			Allure.step(input +" value is enter into "+locator+" field.");
		}catch (Exception exception) {
			softAssert.fail(locator+" element is not found, please check below :: \n"+exception.getMessage());
			softAssert.assertAll();
		}
	}	
}