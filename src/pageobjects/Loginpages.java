package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import basepage.Basetesting;

public class Loginpages extends Basetesting {
	
	By Search = By.xpath("//*[@id=\"twotabsearchtextbox\"]");
	
	
	public void searchbox()
	{
	driver.findElement(Search).click();
	}
	
	public void entertext(String text)
	{
		
	driver.findElement(Search).sendKeys(text);
	}
	
   public Amazonanotherpage pressenter()
   {
	driver.findElement(Search).sendKeys(Keys.ENTER);
	return new Amazonanotherpage();
	
   }
   
   public Amazonanotherpage navigatetonextpage()
   {
	driver.navigate().to("https://www.amazon.in/s?k=apple&ref=nb_sb_noss");
	return new Amazonanotherpage();
   }
   

}
