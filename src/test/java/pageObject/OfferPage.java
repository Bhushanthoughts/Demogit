package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OfferPage {
	
public WebDriver driver;
	
	public OfferPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By search = By.xpath("//input[@type='search']");
	By productname = By.cssSelector("tr td:nth-child(1)");
	

	public void searchItem(String name)
	{
		driver.findElement(search).sendKeys(name);
	}
	
	public String product()
	{
		return driver.findElement(productname).getText();
	}
}
