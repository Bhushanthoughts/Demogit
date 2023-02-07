package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {
	
	public WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By search = By.xpath("//input[@type='search']");
	By productname = By.xpath("//h4[@class='product-name']");
	By topDeals = By.linkText("Top Deals");
	By increment = By.xpath("//a[@class='increment']");
	By add_to_cart = By.xpath("//button[text()='ADD TO CART']");
	

	public void searchItem(String name)
	{
		driver.findElement(search).sendKeys(name);
	}
	
	public String getSearchText()
	{
		return driver.findElement(productname).getText();
	}
	
	public void deals()
	{
		driver.findElement(topDeals).click();
	}
	
	public String getTitleLandingPage() 
	{
		return driver.getTitle();
	}
	
	public void IncrementQuantity(int quantity) 
	{
		int i = quantity-1;
		
		while(i>0)
		{
			driver.findElement(increment).click();
			i--;
		}
		
	}
	
	public void addToCart() 
	{
		driver.findElement(add_to_cart).click();
	}
}
