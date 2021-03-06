package Homepage_positive_scenarios;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import Reusable_Functions.Generic_function;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class Homepage_positive_scenarios extends Generic_function {
	public static boolean value;
	WebElement ele;
	String ere;
	@Given("Browser is open")
	public static void browser_is_open() {
		try {
			browser_launch();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/*Validate that the user is navigated to Welcome page*/
	@And("User clicks on Welcome Login button")
	public static void home_positive_tc_001() throws IOException {
		try {
			click("welcome_login");
			value = driver.findElement(By.xpath(OR_reader("Object_Locator", "login_title"))).isDisplayed();
			Assert.assertEquals(true,value);
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("home_positive_tc_001");
		}
	}
	/*Validate that the user is able to Login with valid credentials*/

	@When("User enters valid phonenumber and password and User click on login")
	public static void home_positive_tc_002() throws InterruptedException, IOException {
		try {

			driver.findElement(By.xpath(OR_reader("Object_Locator", "login_phone_number"))).sendKeys(td_reader("login_phone_number",6));
			driver.findElement(By.xpath(OR_reader("Object_Locator", "login_password"))).sendKeys(td_reader("login_password",7));
			click("login");
			browser_wait(12);

		} catch (IOException e) {
			e.printStackTrace();
			takeScreenShot("home_positive_tc_002");
		}
		browser_wait(5);
	}

	/*Validate that the user is navigated to  the Home page and User should be able to click on all the grid tiles */
	@When("User should be able to click on all the grid tiles and it should be navigated to tile landing page according to that tile")
	public static void home_positive_tc_003() throws IOException {
		try {
			grid_tiles(OR_reader("Object_Locator", "grid_path"));

		}catch(Exception e) {
			e.printStackTrace();
			takeScreenShot("home_positive_tc_003");
		}
}
	/*Validate that the user is navigated to the Second Opinion page on clicking 'Request for second opinion' button*/
	@When("User should be able to click on the Request for second opinion button and navigated to the Second opinion page successfully")
	public void home_positive_tc_004() throws InterruptedException, IOException {
		try {
			ele = driver.findElement(By.xpath(OR_reader("Object_Locator","grid_opinion")));
			ere= ele.getText();
			if(ere.equalsIgnoreCase("Request a Second Opinion")) {
				ele.click();
				value1=driver.findElement(By.xpath(OR_reader("Object_Locator", "Request a Second Opinion"))).isDisplayed();
				Assert.assertEquals(true,value1);
			}
		}catch(Exception e) {
			e.printStackTrace();
			takeScreenShot("home_positive_tc_004");
		}
		browser_wait(5);
		browser_back();
	}

	/*Validate that the user is navigated to the  Refer a friend page on clicking 'Refer a friend' button*/
	@When("User should be able to click on Refer a friend button and navigated to the Refer a friend page successfully")
	public static void home_positive_tc_005() throws InterruptedException, IOException {
		try {
			click("grid_refer");
			value1=driver.findElement(By.xpath(OR_reader("Object_Locator", "Refer a Friend"))).isDisplayed();
			Assert.assertEquals(true,value1);
		}catch(Exception e) {
			e.printStackTrace();
			takeScreenShot("home_positive_tc_005");
		}
		browser_wait(5);	
		browser_back();
		browser_close();
	}
}
