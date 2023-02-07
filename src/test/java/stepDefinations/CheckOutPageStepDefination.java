package stepDefinations;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.CheckoutPage;
import pageObject.LandingPage;
import utils.TestBase;
import utils.TestContextSetup;




public class CheckOutPageStepDefination 
{
	public WebDriver driver;
	public String offerPageProductName;
	public String landingPageProductName;
	public CheckoutPage checkOutPage;
	TestContextSetup testContextSetup;
	
	public CheckOutPageStepDefination(TestContextSetup testContextSetup)
	{
		this.testContextSetup = testContextSetup;
		this.checkOutPage = testContextSetup.pageObjectManager.getCheckoutPage();
	}
	
	@Then("^User proceeds to checkout page and validate the (.+) items to checkout page$")
	public void user_proceeds_to_checkout_page_and_validate_the_tom_items_to_checkout_page(String name) 
	{
	    checkOutPage.CheckItems();
	    System.out.println(checkOutPage.productNames());
	    //write code to extract name and validate
	    
	}
	@Then("verify user has ability to enter promocode and place the order")
	public void verify_user_has_ability_to_enter_promocode_and_place_the_order()
	{
		
		Assert.assertTrue(checkOutPage.VerifyPromoBtn());
		Assert.assertTrue(checkOutPage.VerifyPlaceOrder());
	}
	
	
}
