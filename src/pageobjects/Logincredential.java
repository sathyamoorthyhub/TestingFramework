package pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;

import Datadriven.Datareading;
import basepage.Basetesting;

public class Logincredential extends Basetesting {
		
	Loginpages lp1=new Loginpages();
	
	public static String values=null;
	
	By signin = By.xpath("//*[@id=\'nav-link-accountList\']");
	By signinbutton=By.xpath("/html/body/div[1]/div[4]/div/div[1]/div/div[2]/div[1]/a/span");
	public By name=By.xpath("//*[@id=\"ap_customer_name\"]");
	public By mobile =By.xpath("//*[@id=\"ap_phone_number\"]");
	By email=By.xpath("//*[@id=\"ap_email\"]");
	By createnew=By.xpath("//*[@id=\'createAccountSubmit\']");
	public By mailid=By.xpath("//*[@id=\"ap_email\"]");
	By continuebutton=By.xpath("//*[@id=\'continue\']");
	By password=By.xpath("//*[@id=\"ap_password\"]");
	By login=By.xpath("//*[@id=\"signInSubmit\"]");
	By creataccounttextline=By.xpath("/html/body/div[1]/div[1]/div[2]/div/div[2]/div/form/div/div/h1");
    By datepickerfield=By.xpath("//*[@id=\"datepicker\"]");
	By datepickertable=By.xpath("/html/body/div/table");
	By rowvalues=By.tagName("tr");
	By cellvalues=By.tagName("td");
	//By value=By.linkText(values);
	
	
	
	/*public void Signin_click() throws InterruptedException
	{
	driver.findElement(signin).click();
	Thread.sleep(100);
	
	}*/
	
	/*public void signin_button_click()
	{
		driver.findElement(signinbutton).click();
	}*/
	

	
	public void mobile_button_click() throws InterruptedException
	{
		driver.findElement(mobile).clear();
		Thread.sleep(100);
	}
	
	public void email_button_click()
	{
		driver.findElement(email).click();
	}
	
	public void enterthemailid(String mailid)
	{
		driver.findElement(email).sendKeys(mailid);
	}
	/*public void createnew_account() throws InterruptedException
	{
	driver.findElement(createnew).click();
	Thread.sleep(200);
	}*/
	
	public void click_name()
	{
		
	driver.findElement(name).clear();
	}
	 
	public void mailidfield_click() throws InterruptedException
	{
	 driver.findElement(mailid).click(); Thread.sleep(100);
	 }
	 
	public void press_continue_button() throws InterruptedException
	{
	driver.findElement(continuebutton).click();
	Thread.sleep(100);
	}
	
	public void enter_password(String passwordtext) throws InterruptedException
	{
	driver.findElement(password).sendKeys(passwordtext);
	Thread.sleep(200);
	}
	
	public void press_signin_button()
	{
	driver.findElement(signin).click();	
	}
	
	public void enter_values_excel()
	{
		driver.findElement(name).sendKeys(Datareading.getCellData( "Logincredentials", "username", 2));
	}
	
	public void enter_values_excel_mobile()
	{
		driver.findElement(mobile).sendKeys(Datareading.getCellData( "Logincredentials", "mobile", 2));
	}

	public void enter_values_excel_email()
	{
		driver.findElement(mailid).sendKeys(Datareading.getCellData( "Logincredentials", "email", 2));
	}
	
	
   public void enter_the_values(String namevalue,String mobilenumber,String email)
   {
		
	 
      driver.findElement(name).sendKeys(namevalue);	
	  
	  driver.findElement(mobile).sendKeys(mobilenumber);
	
	  
	  driver.findElement(mailid).sendKeys(email);
	 
	  
   
   }
   public String create_account_textline() throws InterruptedException
   {
	   Thread.sleep(100);
	  return driver.findElement(creataccounttextline).getText();
   }


   public void navigate_to_datepicker(String url) throws InterruptedException
   {
	   driver.get(url);
	   Thread.sleep(200);
   }
   
   public void click_datepicker_field() throws InterruptedException
   {
	   driver.switchTo().frame(0);
	   WebElement ele=driver.findElement(datepickerfield);
	   ele.click();
	   Thread.sleep(100);
	
   }
   
 public  void click_datetable(String daytoday) 
 {
	WebElement table=driver.findElement(datepickertable);
	List<WebElement> trs=table.findElements(rowvalues);
	for(WebElement trows:trs)
	{
	List<WebElement> cells=trows.findElements(cellvalues);
	for(WebElement tcells: cells)
	{
	    values=tcells.getText();
	   	if(values.equals(daytoday))
		{
		System.out.println("Matched");
		driver.findElement(By.linkText(values)).click();
		break;
		}
	}
	}	
	}
 
 
		
public void click_required_days(int num)
 {
	 String expectedclicknumber= futuremonth(num);
	 for(int i=0;i<monthselection_number()-1;i++)
		{
		driver.findElement(By.xpath("/html/body/div/div/a[2]")).click();
		}
	 click_datetable(expectedclicknumber);
	
 }
public void click_required_by_entering(String num,String num1)
{
	 int expectedmonthselection=monthselection_number1(num);
	 for(int i=0;i<expectedmonthselection-1;i++)
		{
		driver.findElement(By.xpath("/html/body/div/div/a[2]")).click();
		}
	 click_datetable(num1);
	
}


 
 }






