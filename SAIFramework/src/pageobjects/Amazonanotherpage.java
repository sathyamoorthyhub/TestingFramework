package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;


import pageobjects.Loginpages;

import basepage.Basetesting;

public class Amazonanotherpage extends Basetesting {
	Loginpages lp=new Loginpages();

	By textheadline = By.xpath("/html/body/div[1]/div[4]/div/div[1]/div/div[2]/div[1]/div[1]");
	By sigininwindow=By.xpath("/html/body/div[1]/header/div/div[1]/div[4]/div[3]/div[2]/div/div[1]/div/a/span");
	By signinnavigation=By.xpath("//*[@id=\"nav-link-accountList\"]");
	By signinbutton=By.xpath("/html/body/div[1]/div[4]/div/div[1]/div/div[2]/div[1]/a/span");
	By createnew=By.xpath("//*[@id=\"createAccountSubmit\"]");
	
	
	public String verify_first_texting()
	{
	driver.findElement(lp.Search).clear();	
	String textobtain=driver.findElement(textheadline).getText();
	return textobtain;
	}
	
	public void signin_button_click() throws InterruptedException
	{

	driver.findElement(signinnavigation).click();Thread.sleep(2000); String windowhandle=driver.getWindowHandle();
	driver.switchTo().window(windowhandle);
	driver.findElement(sigininwindow).click();
	
	
	}
	
	public Logincredential createnew_account() throws InterruptedException
	{
	driver.findElement(createnew).click();
	
	return new Logincredential();
	}
	
	
	
	
	
	
	
	
	
	



	
}