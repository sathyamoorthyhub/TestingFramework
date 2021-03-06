package testrunner;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import basepage.Basetesting;
import pageobjects.Amazonanotherpage;

public class Amazongoogletestrun extends Basetesting{
	
	public static String verifytext_line="See personalized recommendations";
	
	Amazonanotherpage ap= new Amazonanotherpage();
	Logintestrun lr=new Logintestrun();
	
	/*@Test
	public void verifytitle()
	{
	System.out.println("Title   " + driver.getTitle());
	assertEquals(driver.getTitle(),"Amazon.in: fruits");
	}*/
	
	@Test(priority=1,description="verify the textingline present",groups= {"Smoke testing","Functional testing","Regression testing"})
	public void verifyfirstlineee() throws InterruptedException
	{
	assertEquals(ap.verify_first_texting(),verifytext_line );
	Thread.sleep(500);
	 long id = Thread.currentThread().getId();
     System.out.println("verifyfirstline. Thread id is: " + id);
	
	}
	
	@Test(priority=2,description="click the signin button",groups= {"Smoke testing","Functional testing","Regression testing"})
	public void signinbuttonclick() throws InterruptedException
	{
	 ap.signin_button_click();
	 long id = Thread.currentThread().getId();
     System.out.println("Signinbutton click. Thread id is: " + id);

	}
	
	@Test(priority=3,description="Navigate to the next page create account",groups= {"Smoke testing","Functional testing","Regression testing"})
	public void movetothenextpagecreateaccount() throws InterruptedException
	{
	ap.createnew_account();	
	 long id = Thread.currentThread().getId();
     System.out.println("movetothenextpagecreateaccount. Thread id is: " + id);

	}

}
