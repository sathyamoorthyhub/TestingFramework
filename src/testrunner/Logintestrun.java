package testrunner;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Datadriven.Datareading;
import basepage.Basetesting;
import pageobjects.Loginpages;

public class Logintestrun extends Basetesting {

 Loginpages lp=new Loginpages();

 @DataProvider(name="Fruitnames")
 public static Object[][] entermail() throws Exception
 {

 return Datareading.getExcelData("Fruitlist");

 }
@Test(priority=1,description="Title verify",groups= {"Smoke testing","Functional testing","Regression testing"})
public static void Testing() throws InterruptedException, IOException
{
browserinitialise();	
Thread.sleep(2000);
System.out.println("Title   " + driver.getTitle());
assertEquals(driver.getTitle(),"Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");
long id = Thread.currentThread().getId();
System.out.println("Testing. Thread id is: " + id);

}	


@Test(priority=2,description="Navigate to next page",groups= {"Smoke testing","Functional testing","Regression testing"},dataProvider="Fruitnames")
public  void naviagate(String text) throws InterruptedException
{
	lp.entertext(text);
	
	lp.pressenter();
	
	Thread.sleep(3000);
	//assertEquals(driver.getTitle(),"Amazon.in: fruits");
	//Thread.sleep(3000);
	driving("https://www.amazon.in/");
	Thread.sleep(3000);
	//assertEquals(driver.getTitle(),"Amazon.in: fruits");
	 long id = Thread.currentThread().getId();
     System.out.println("navigate. Thread id is: " + id);
	
		
}

/*@Test(priority=3)
public void nextpagenavigation() throws InterruptedException
{
	lp.navigatetonextpage();
	Thread.sleep(2000);
}*/
	

}

 
