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
import pageObject.LandingPage;
import pageObject.OfferPage;
import pageObject.PageObjectManager;
import utils.TestContextSetup;

public class OfferPageStepDefination 
{
	public WebDriver driver;
	public String offerPageProductName;
	public String landingPageProductName;
	TestContextSetup testContextSetup;
	PageObjectManager pageObjectManager;
	
	public OfferPageStepDefination(TestContextSetup testContextSetup)
	{
		this.testContextSetup = testContextSetup;
	}
	
	
	@Then("^User search for (.+) shortname in offers page$")
	public void user_search_for_shortname_in_offers_page(String shortname) throws InterruptedException {
		// calling switchtoofferpage directly instead of writing complete code
		switchtoofferpage();
		OfferPage offerPage = testContextSetup.pageObjectManager.getOffersPage();
		offerPage.searchItem(shortname);
		//testContextSetup.driver.findElement(By.xpath("//input[@id='search-field']")).sendKeys(shortname);
		Thread.sleep(3000);
		testContextSetup.offerPageProductName = offerPage.product();
		//testContextSetup.offerPageProductName = testContextSetup.driver.findElement(By.cssSelector("tr td:nth-child(1)")).getText();
		System.out.println(testContextSetup.offerPageProductName);
	    
	}
	
	public void switchtoofferpage() {
		
		LandingPage landingPage = testContextSetup.pageObjectManager.getLandingPage();
		landingPage.deals();
		
		//testContextSetup.driver.findElement(By.linkText("Top Deals")).click();
		testContextSetup.genericUtils.SwitchWindowToChild();
	}

	
	@Then("Validate product name in offers page matches with home page")
	public void validate_product_name_in_offers_page_matches_with_home_page() {
		
		Assert.assertEquals(testContextSetup.offerPageProductName, testContextSetup.landingPageProductName);
	   
	}
}
