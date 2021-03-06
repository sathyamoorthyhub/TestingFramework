package testrunner;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Datadriven.Datareading;
import basepage.Basetesting;
import pageobjects.Logincredential;

public class Logincredentialtestrun extends Basetesting{
	
	String text1="Create Account";
	
 Logincredential lc=new Logincredential();

@DataProvider(name="inputdata")
public static Object[][] entermail() throws Exception
{

return Datareading.getExcelData("Logincredentials");

}

@Test(priority=0,groups= {"Smoke testing","Functional testing","Regression testing"})
public void amazonregtitleverify() throws InterruptedException
{
	
assertEquals(lc.create_account_textline(),text1);
long id = Thread.currentThread().getId();
System.out.println("amazonregtitleverify. Thread id is: " + id);


}
/*@Test(priority=1)
public void signinbuttonclick() throws InterruptedException
{
lc.signin_button_click();
Thread.sleep(100);
}*/

/*@Test(priority=2)
public void createaccount() throws InterruptedException
{
lc.createnew_account();	
}*/

/*@Test(priority=3)
public void readingthedata()
{
lc.click_name();
lc.enter_values_excel();	
}


@Test
public void readingmobile()
{
lc.enter_values_excel_mobile();
}

@Test
public void readingemail()
{
lc.enter_values_excel_email();
}*/

@Test(dataProvider="inputdata",priority=1,groups= {"Smoke testing","Functional testing"})
public  void enterthename(String namevalue,String mobilenumber,String email) throws InterruptedException
{

lc.enter_the_values(namevalue, mobilenumber, email);
long id = Thread.currentThread().getId();
System.out.println("enter the name Thread id is: " + id);
}

@Test(priority=2,groups={"Smoke testing","Functional testing"})
public void dateselection() throws InterruptedException
{
	lc.navigate_to_datepicker("https://jqueryui.com/datepicker/");
	Thread.sleep(100);
	lc.click_datepicker_field();
	Thread.sleep(100);
    lc.click_required_days(36);
	//lc.click_required_by_entering("Mar","27");
	Assert.assertEquals(driver.getTitle(), "Datepicker | jQuery UI");
	
}

@Test(priority=3,groups={"Smoke testing","Functional testing"})
public void getthetitle()
{
	System.out.println("Title of jquerypage: "+ driver.getTitle());
}

}


