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
import utils.TestBase;
import utils.TestContextSetup;




public class LandingPageStepDefination 
{
	public WebDriver driver;
	public String offerPageProductName;
	public String landingPageProductName;
	public LandingPage landingPage;
	TestContextSetup testContextSetup;
	
	public LandingPageStepDefination(TestContextSetup testContextSetup)
	{
		this.testContextSetup = testContextSetup;
		this.landingPage = testContextSetup.pageObjectManager.getLandingPage();
	}
	
	
	@Given("User is on GreenKart landing page")
	public void user_is_on_green_kart_landing_page() {
		
		// This is getting executed by TestBase which is called in testcontextsetup
		/*
		 * System.setProperty("webdriver.chrome.driver",
		 * "C:\\Selenium\\chromedriver_win32\\chromedriver.exe"); driver = new
		 * ChromeDriver(); driver.get(url);
		 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		 * driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		 */
	    Assert.assertTrue(landingPage.getTitleLandingPage().contains("GreenKart"));
	}
	
	@When("^User searched with shortname (.+) in homepage and extract actual name of product$")
	public void user_searched_with_shortname_in_homepage_and_extract_actual_name_of_product(String shortname) throws InterruptedException {
	   
		
		landingPage.searchItem(shortname);
		
		//testContextSetup.driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortname);
		Thread.sleep(3000);
		testContextSetup.landingPageProductName = landingPage.getSearchText().split("-")[0].trim();
		System.out.println(testContextSetup.landingPageProductName);
	}
	
	@When("Added {string} items of the selected product item")
	public void Added_items_product(String quantity)
	{
		landingPage.IncrementQuantity(Integer.parseInt(quantity));
		landingPage.addToCart();
	}
	
}
