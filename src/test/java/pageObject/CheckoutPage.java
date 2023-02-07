package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
	
	public WebDriver driver;
	
	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By CartBag = By.xpath("//img[@alt='Cart']");
	By CheckOutButton = By.xpath("//button[text()='PROCEED TO CHECKOUT']");
	By Promobtn = By.xpath("//button[@class='promoBtn']");
	By PlaceOrder = By.xpath("//button[text()='Place Order']");
	By productnames = By.xpath("//p[@class='product-name']");

	public void CheckItems() 
	{
		driver.findElement(CartBag).click();
		driver.findElement(CheckOutButton).click();
	}
	
	public boolean VerifyPromoBtn() 
	{
		return driver.findElement(Promobtn).isDisplayed();
	}
	
	public boolean VerifyPlaceOrder() 
	{
		return driver.findElement(PlaceOrder).isDisplayed();
	}
	
	public String productNames() 
	{
		return driver.findElement(productnames).getText();
	}

}
