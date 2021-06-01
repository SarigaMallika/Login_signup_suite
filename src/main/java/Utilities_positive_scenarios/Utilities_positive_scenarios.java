package Utilities_positive_scenarios;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import Reusable_Functions.Generic_function;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Utilities_positive_scenarios extends Generic_function{
	static boolean value;
	static String balance,text,ere;
	static WebElement ele;

	/*Browser opens and user is on home page*/ 	
	@When("User is on home page")
	public static void user_on_homepage() throws Exception{
		try {
			browser_launch();
			click("welcome_login");
			driver.findElement(By.xpath(OR_reader("Object_Locator", "login_phone_number"))).sendKeys(td_reader("login_phone_number",8));
			driver.findElement(By.xpath(OR_reader("Object_Locator", "login_password"))).sendKeys(td_reader("login_password",9));
			click("login");
			browser_wait(40);
			value = driver.findElement(By.xpath(OR_reader("Object_Locator", "logout"))).isDisplayed();
			Assert.assertEquals(true,value);
		}catch (Exception e) {
			e.printStackTrace();
		}		
	}

	/* TC_001 -Validate that the user is able to navigate to Utilities screen */
	@Then("User should redirect to Utilities Dashboard when clicks on Utilities tab")
	public static void utilities_positive_tc_001() throws Exception {
		try {
			click("utilities");
			browser_wait(20);
			value = driver.findElement(By.xpath(OR_reader("Object_Locator", "Wallet"))).isDisplayed();
			Assert.assertEquals(true,value);
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("utilities_positive_tc_001");
		}	
	}

	/* TC_002-Validate that user can click options provided in the left side navigator */
	@Then("User should able to click on left side navigator options")
	public static void utilities_positive_tc_002() throws Exception {
		try {
			browser_wait(30);
			click("home");
			value = driver.findElement(By.xpath(OR_reader("Object_Locator", "home_page_title"))).isDisplayed();
			Assert.assertEquals(true,value);
			click("services");
			value = driver.findElement(By.xpath(OR_reader("Object_Locator", "services_page_title"))).isDisplayed();
			Assert.assertEquals(true,value);
			click("circles");
			Thread.sleep(1000);
			value = driver.findElement(By.xpath(OR_reader("Object_Locator", "circles_page_title"))).isDisplayed();
			Assert.assertEquals(true,value);
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("utilities_positive_tc_002");
		}	
	}

	/* TC_003 - Validate that user can check the Tiles in the Utilities dashboard */
	@Then("User should able to click all tiles in utilities dashboard")
	public static void utilities_positive_tc_003() throws Exception {
		try {
			click("utilities");
			browser_wait(20);
			utilities_grid_tile(OR_reader("Object_Locator", "utilities_gridpath"));
			browser_wait(10);
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("utilities_positive_tc_003");
		}	
	}

	/* TC_004 - Validate that user is able to add card details  in the Wallet dashboard.*/
	@Then("User should able to add card details")
	public static void utilities_positive_tc_004() throws Exception {
		try {
			browser_wait(10);
			click("utilities");
			click("wallet");
			browser_wait(30);
			click("utilities_add_card");
			browser_wait(30);
			driver.findElement(By.xpath(OR_reader("Object_Locator","utilities_save_as"))).sendKeys(td_reader("utilities_save_as"));
			driver.findElement(By.xpath(OR_reader("Object_Locator","utilities_name_on_card"))).sendKeys(td_reader("utilities_name_on_card"));
			Thread.sleep(2000);
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_TAB);
			Thread.sleep(1000);
			for (int i=0; i<5;i++) {
				robot.keyPress(KeyEvent.VK_NUMPAD4);
				robot.keyPress(KeyEvent.VK_NUMPAD2);
				robot.keyPress(KeyEvent.VK_NUMPAD4);
				robot.keyPress(KeyEvent.VK_NUMPAD2);
			}
			robot.keyPress(KeyEvent.VK_TAB);
			Thread.sleep(1000);
			robot.keyPress(KeyEvent.VK_NUMPAD1);
			robot.keyPress(KeyEvent.VK_NUMPAD2);
			robot.keyPress(KeyEvent.VK_BACK_SLASH);
			robot.keyPress(KeyEvent.VK_NUMPAD2);
			robot.keyPress(KeyEvent.VK_NUMPAD6);
			robot.keyPress(KeyEvent.VK_TAB);
			Thread.sleep(1000);
			robot.keyPress(KeyEvent.VK_NUMPAD1);
			robot.keyPress(KeyEvent.VK_NUMPAD2);
			robot.keyPress(KeyEvent.VK_NUMPAD3);
			driver.findElement(By.xpath(OR_reader("Object_Locator","utilities_zip_code"))).sendKeys(td_reader("utilities_zip_code"));
			driver.findElement(By.xpath(OR_reader("Object_Locator","utilities_phone_number"))).sendKeys(td_reader("utilities_phone_number"));
			driver.findElement(By.xpath(OR_reader("Object_Locator","utilities_address"))).sendKeys(td_reader("utilities_address"));
			Thread.sleep(1000);
			driver.findElement(By.xpath(OR_reader("Object_Locator","utilities_country"))).sendKeys(td_reader("utilities_country"));
			Thread.sleep(1000);
			driver.findElement(By.xpath(OR_reader("Object_Locator","utilities_state"))).sendKeys(td_reader("utilities_state"));
			driver.findElement(By.xpath(OR_reader("Object_Locator","utilities_city"))).sendKeys(td_reader("utilities_city"));
			Thread.sleep(2000);
			click("utilities_save_button");
			Thread.sleep(4000);
			click("card_ok");
			Thread.sleep(3000);
			//			value = driver.findElement(By.xpath(OR_reader("Object_Locator", "card_page_title"))).isDisplayed();
			//			Assert.assertEquals(true,value);
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("utilities_positive_tc_004");
		}	
	}

	/* TC_005 - Validate that user is able to add bank details  in the Wallet dashboard*/
	@Then("User should able to add bank details")
	public static void utilities_positive_tc_005() throws Exception {
		try {
			browser_wait(20);	
			click("utilities");
			click("wallet");
			click("utilities_add_bank");
			driver.findElement(By.xpath(OR_reader("Object_Locator","utilities_bank_saveas"))).sendKeys(td_reader("utilities_bank_saveas"));
			driver.findElement(By.xpath(OR_reader("Object_Locator","utilities_account_name"))).sendKeys(td_reader("utilities_account_name"));
			driver.findElement(By.xpath(OR_reader("Object_Locator","utilities_routing_no"))).sendKeys(td_reader("utilities_routing_no"));
			click("utilities_account_type");
			text = td_reader("utilities_account_type");
			drop_down(OR_reader("Object_Locator", "utilities_account_type_list"),text);  
			browser_wait(10);
			driver.findElement(By.xpath(OR_reader("Object_Locator","utilities_account_number"))).sendKeys(td_reader("utilities_account_number"));
			driver.findElement(By.xpath(OR_reader("Object_Locator","utilities_bank_address"))).sendKeys(td_reader("utilities_address"));
			driver.findElement(By.xpath(OR_reader("Object_Locator","utilities_bank_state"))).sendKeys(td_reader("utilities_state"));
			driver.findElement(By.xpath(OR_reader("Object_Locator","utilities_bank_city"))).sendKeys(td_reader("utilities_city"));
			driver.findElement(By.xpath(OR_reader("Object_Locator","utilities_bank_zipcode"))).sendKeys(td_reader("utilities_zip_code"));
			click("utilities_bank_checkbox");
			click("utilities_save_button");
			browser_wait(10);	
			click("card_ok");
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("utilities_positive_tc_005");
		}	
	}

	/* TC_006 -Validate that user is able to redeem points  in the Award points dashboard */
	@Then("User is able to redeem points")
	public static void utilities_positive_tc_006() throws Exception{
		try {
			click("utilities");
			browser_wait(40);
			click("award_points");
			Thread.sleep(4000);
			value=driver.findElement(By.xpath(OR_reader("Object_Locator", "awardpoints_redeem_button"))).isEnabled();
			if(value==true) {
				Thread.sleep(6000);
				click("awardpoints_redeem_button");
				Thread.sleep(6000);
				ele=driver.findElement(By.xpath(OR_reader("Object_Locator","redeem_points_giftcard")));
				ele.sendKeys(td_reader("redeem_points_giftcard"));
				ele.sendKeys(Keys.ARROW_DOWN);
				ele.sendKeys(Keys.ENTER);
				click("redeem_points_amount");
				ele=driver.findElement(By.xpath(OR_reader("Object_Locator","redeem_points_amount")));
				ele.sendKeys(Keys.BACK_SPACE);
				ele.sendKeys(td_reader("redeem_points_amount"));
				click("redeem_points_email");
				Thread.sleep(4000);
				click("redeem_points");
				Thread.sleep(4000);
				value = driver.findElement(By.xpath(OR_reader("Object_Locator", "redeem_points_title"))).isDisplayed();
				Assert.assertEquals(true,value);
				click("goto_dashboard_button");
				browser_back();
			}
			else
			{
				browser_back();
			}
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("utilities_positive_tc_006");
		}	
	}

	/* TC_007 - Validate that user is able to view your award points history */
	@When("User should able to view award points history")
	public static void utilities_positive_tc_007() throws Exception{
		try {
			click("home");
			browser_wait(40);
			click("utilities");
			browser_wait(40);
			click("award_points");
			Thread.sleep(5000);
			value = driver.findElement(By.xpath(OR_reader("Object_Locator", "redeem_points_history"))).isDisplayed();
			Assert.assertEquals(true,value);	
			click("utilities");
			browser_close();
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("utilities_positive_tc_007");
		}	
	}
}