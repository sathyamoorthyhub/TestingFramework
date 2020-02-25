package pageobjects;

import java.awt.AWTException;
import java.awt.GraphicsEnvironment;
import java.awt.HeadlessException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import basepage.Basetesting;
import basepage.GoogleChrome;
import basepage.GoogleFirefox;
import okhttp3.internal.http2.Settings;
import java.net.MalformedURLException;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;


public class ParallelTestA extends Basetesting {
	


public  void testGooglePageTitleInFirefox() throws Exception
{
	System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
	browserinitialise1("firefox");
//ystem.setProperty("webdriver.chrome.driver","C:\\Users\\sathyamoorthy.p\\Eclipse Helios\\SAIFramework\\chrome\\chromedriver.exe");
	
	/*System.setProperty("webdriver.chrome.driver","C:\\Users\\sathyamoorthy.p\\Eclipse Helios\\SAIFramework\\chrome\\chromedriver.exe");
	ChromeOptions options=new ChromeOptions();
	options.setExperimentalOption("debuggingAddress","172.25.11.66:4444");
	driver=new ChromeDriver(options);*/
	
//river=new ChromeDriver();
driver.get("https://www.google.com/");
	//System.setProperty("webdriver.ie.driver","C:\\Users\\sathyamoorthy.p\\Eclipse Helios\\SAIFramework\\ie\\IEDriverServer.exe");
	//driver=new InternetExplorerDriver();
	//driver.get("https://www.google.com/");
	String winHandleBefore = driver.getWindowHandle();
	System.out.println("First Browser  "+winHandleBefore);
	// Perform the click operation that opens new window

	// Switch to new window opened
	for(String winHandle : driver.getWindowHandles())
	{
		int count=0;count++;
	    driver.switchTo().window(winHandle);
	    System.out.println("++++++++++++++++++++++++++++++ "+ driver.getTitle());
	    if(count==2)
	    {
	    	break;
	    }
	}
System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
//System.setProperty("webdriver.ie.driver","C:\\Users\\sathyamoorthy.p\\Eclipse Helios\\SAIFramework\\IE\\IEDriverServer.exe");
//driver=new InternetExplorerDriver();
//browserinitialise1("firefox");

//driver.get("https://teams.microsoft.com/"); Thread.sleep(1000);
//String firstwindow=driver.getWindowHandle();
driver.findElement(By.xpath("//*[@id=\"i0116\"]")).sendKeys("Jebas.Ebenezer@tryviumbotdev.onmicrosoft.com");
driver.findElement(By.xpath("//*[@id=\"idSIButton9\"]")).click();
driver.findElement(By.xpath("//*[@id=\"i0118\"]")).sendKeys("Kom54610");
// Create object of Robot class
Robot r=new Robot();

 // Press Enter
 r.keyPress(KeyEvent.VK_ENTER);

//  Release Enter
 r.keyRelease(KeyEvent.VK_ENTER);

Thread.sleep(2000);

Robot r1=new Robot();


Thread.sleep(5000);
driver.findElement(By.xpath("//*[@id=\'idSIButton9\']")).click();
driver.navigate().back();
Thread.sleep(5000);
driver.findElement(By.xpath("/html/body/promote-desktop/div/div/div/div[1]/div[2]/div/a")).click();
System.out.println("title testing: "+ driver.getTitle());
String tit=driver.getTitle();	
Thread.sleep(5000);
//driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[1]/app-bar/nav/ul/li[1]/button/ng-include/svg")).click();
driver.findElement(By.xpath(".//*[@class='app-svg icons-chat']")).click();
Thread.sleep(5000);
//error();
if(driver.findElement(By.xpath(".//*[@role='button']")).isDisplayed());
{
driver.findElement(By.xpath(".//*[@role='button']")).click();
}
//error();

driver.findElement(By.xpath(".//*[@role='textbox']")).sendKeys("Hi");
driver.findElement(By.xpath(".//*[@class='app-svg icons-send icons-rtl-flip']")).click();
Thread.sleep(2000);
//driver.findElement(By.xpath("//*[@id='discover-apps-button']")).click();
Thread.sleep(500);
//String s2=driver.getCurrentUrl();

/*Set<String> handleserror = driver.getWindowHandles();
for(String switching: handleserror)
{
	int count=0;count++;
	driver.switchTo().window(switching);
	if(count==1)
	{
		count=count*0;
		System.out.println("js window "+ driver.getTitle());
		break;
	}
}*/

/*((JavascriptExecutor) driver).executeScript("window.open('about:blank','_blank');");
Thread.sleep(5000);
String subWindowHandler = null;

Set<String> handles = driver.getWindowHandles();
Iterator<String> iterator = handles.iterator();
while (iterator.hasNext())
{
 subWindowHandler = iterator.next();
}
driver.switchTo().window(subWindowHandler);

System.out.println("title   "+ driver.getTitle());

Thread.sleep(5000);
System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
//browserinitialise1("firefox");
//System.setProperty("webdriver.ie.driver","C:\\Users\\sathyamoorthy.p\\Eclipse Helios\\SAIFramework\\IE\\IEDriverServer.exe");
//driver=new InternetExplorerDriver();
driver.get("https://tryviumteamsqa.azurewebsites.net/teamsqaac/Home/Dashboard");
driver.manage().window().maximize();

System.out.println("titleeeeeeeeeee "+ driver.getTitle());
driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);

WebElement UN=driver.findElement(By.xpath(".//*[@name='useremail']"));
UN.click();
UN.clear();UN.sendKeys("admin@sensipleucx.com");
Thread.sleep(1000);
WebElement pwd=driver.findElement(By.xpath("//*[@name='password']"));
pwd.sendKeys("s3n5i9l3");
Thread.sleep(1000);
WebElement signin=driver.findElement(By.xpath(".//*[@type='submit']"));
signin.click();
Thread.sleep(1000);
driver.navigate().back();
Thread.sleep(2000); driver.manage().deleteAllCookies();*/



browserinitialise1("firefox");
driver.get("https://teams.microsoft.com/");Actions a=new Actions(driver); driver.manage().window().maximize(); driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
String winHandleBefore2 = driver.getWindowHandle();
System.out.println("First Browser  "+winHandleBefore2);
driver.findElement(By.xpath("//*[@id=\"i0116\"]")).sendKeys("varshini.a@tryviumbotdev.onmicrosoft.com");
driver.findElement(By.xpath("//*[@id=\"idSIButton9\"]")).click();
driver.findElement(By.xpath("//*[@id=\"i0118\"]")).sendKeys("Welcome@123");
// Press Enter
Robot r3=new Robot();
r3.keyPress(KeyEvent.VK_ENTER);

// Release Enter
r3.keyRelease(KeyEvent.VK_ENTER);
Thread.sleep(5000);
driver.findElement(By.xpath("//*[@id=\'idSIButton9\']")).click();
driver.navigate().back();	
Thread.sleep(5000);
driver.findElement(By.xpath("/html/body/promote-desktop/div/div/div/div[1]/div[2]/div/a")).click();
Thread.sleep(5000);

System.out.println("title   "+ driver.getTitle());
driver.findElement(By.xpath(".//*[@class='app-svg icons-chat']")).click();
Thread.sleep(1000);
if(driver.findElement(By.xpath(".//*[@role='button']")).isDisplayed());
{
driver.findElement(By.xpath(".//*[@role='button']")).click();
}
driver.findElement(By.xpath(".//*[@role='textbox']")).sendKeys("Hi");
//driver.findElement(By.xpath(".//*[@class='app-svg icons-send icons-rtl-flip']")).click();
//Thread.sleep(2000);

//ndowswitch();Thread.sleep(10000);
//webdriver.WebDriver.attachToSession(executor, session_id);
driver.manage().window().maximize(); driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);

System.out.println("window titleeeeeeeeeeeeeeeeeeeeeeeee  "+driver.getTitle());

Thread.sleep(5000);
//driver.get(driver.getCurrentUrl());
//driver.navigate().refresh();
//driver.manage().window().maximize();	
 
//Robot refresh= new Robot();
//refresh.keyPress(KeyEvent.VK_F5);
//refresh.keyRelease(KeyEvent.VK_F5);
//	Thread.sleep(1000);
//	driver.manage().window().setPosition(new Point(0, -2000)); Thread.sleep(1000);
	driver.manage().window().maximize();
	
    WebElement e =driver.findElement(By.xpath("//*[@id='discover-apps-button']"));
    //safeJavaScriptClick(e);
    System.out.println("----------------------------");
  
    
//    Actions action = new Actions(driver);
//    action.moveToElement(e).click().perform();
//    ((JavascriptExecutor)driver).executeScript("window.scrollTo(0,"+e.getLocation().y+")");
//    e.click();
    WebDriverWait wait = new WebDriverWait(driver, 1000);
    wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id='discover-apps-button']")))); 
    wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@id='discover-apps-button']"))));
    driver.findElement(By.xpath("//*[@id='discover-apps-button']")).sendKeys("");
    driver.findElement(By.xpath("//*[@id='discover-apps-button']")).click();
    
//	WebDriverWait wait = new WebDriverWait(driver, 120);
//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='discover-apps-button']")));
	//e.click();
	 //Thread.sleep(1000); Actions a1=new Actions(driver);
      //a1.moveToElement(e).click().build().perform();

	//JavascriptClick(FindElementWithWait(By.xpath("//*[@id='discover-apps-button']"), 20));
//	WebDriverWait wait1 = new WebDriverWait(driver, 100);
//	WebElement element1 = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='discover-apps-button']")));
//	element1.click();
//((JavascriptExecutor)driver).executeScript("arguments[0].click();",driver.findElement(By.xpath("//*[@id='discover-apps-button']")));

    
driver.switchTo().window(driver.getWindowHandle());Thread.sleep(5000);
//scrollToTop(driver);
//scrollToElementBottom(driver,e);
try 
{
driver.findElement(By.xpath("//*[@id='discover-apps-button']")).click();
}
catch(Exception ex)
{
	System.out.println("exceptionnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn     "+ ex.getMessage() );
}
Thread.sleep(5000);

//ndowswitch();
Thread.sleep(5000);
System.setProperty("webdriver.chrome.driver","C:\\Users\\sathyamoorthy.p\\Eclipse Helios\\SAIFramework\\chrome\\chromedriver.exe");
ChromeOptions options1=new ChromeOptions();
options1.setExperimentalOption("debuggingAddress","localhost:4444");
driver=new ChromeDriver(options1);

driver.findElement(By.xpath("//*[@id='discover-apps-button']")).click();

//ndowswitch();
Thread.sleep(5000);

String subWindowHandler=null;
Set<String> handles = driver.getWindowHandles();
Iterator<String> iterator = handles.iterator();
while (iterator.hasNext())
{
 subWindowHandler = iterator.next();
 System.out.println("^^^^^^^^^^^^^^  "+ subWindowHandler);
}

Thread.sleep(2000);

/*Switch();
//driver.findElement(By.xpath("//*[@class='treeview ng-star-inserted active']")).click();
Thread.sleep(5000);
Windowswitch();Thread.sleep(5000);
Switch();Thread.sleep(5000);
driver.findElement(By.xpath("//*[@class='app-bar-text']")).click();
System.out.println("+++++++++++++++++++++++++++++++++++++");
driver.navigate().refresh();
/*System.out.println("+++++++++++++++++++++++++++++++++++++");
Thread.sleep(5000);
driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"\t");
Thread.sleep(5000);

Set<String> handles1 = driver.getWindowHandles();
for( String windowswi:handles1)
{
String ti="Microsoft Teams";
 driver.switchTo().window(windowswi);
 System.out.println("+++++++++++++++++++++++++++++++++++++");
 if(ti.equalsIgnoreCase(driver.getTitle()))
 {
 break;
}
}
 driver.close();*/

//System.out.println(")))))))))))))))) "+driver.findElement(By.xpath("//*[@class='avg-chat-duaration text-center pull-left']")).getText());
//driver.navigate().refresh();
Thread.sleep(5000);
//String winHandleBefore2 = driver.getWindowHandle();
System.out.println("second browser  "+winHandleBefore);
 //driver.findElement(By.xpath("//*[@class='side-menu-icon']")).click();
 //Thread.sleep(300);
driver.switchTo().window(winHandleBefore);
//Windowswitch();
Thread.sleep(5000);
//if(driver.getTitle().contains("Global Service Desk QA1 | Microsoft Teams"));
//{
//	
//    driver.findElement(By.xpath("//*[@id='discover-apps-button']")).click();
//}
//}


/*public static void Switch() throws AWTException
{
LOOPA:for(int i1=0;i1<=50;i1++)
{
String s1="Global Service Desk QA | Microsoft Teams";	
Robot rob=new Robot();
 rob.keyPress(KeyEvent.VK_ALT);
 rob.keyPress(KeyEvent.VK_TAB); rob.keyRelease(KeyEvent.VK_TAB);rob.keyRelease(KeyEvent.VK_ALT);
//https://www.edureka.co/community/49746/how-to-do-session-handling-in-selenium-webdriver
 System.out.println("new titleeeeeeeeeeeeeeeeeeeee   "+ driver.getTitle());
 // Press Enter
 rob.keyPress(KeyEvent.VK_ENTER);

//  Release Enter
 rob.keyRelease(KeyEvent.VK_ENTER);
 
 if(s1.equalsIgnoreCase(driver.getTitle()))
 {
	 System.out.println("new titleeeeeeeeeeeeeeeeeeeee   "+ driver.getTitle());
	 driver.navigate().refresh();
	 break;
 }
 else
 {
	 continue LOOPA;
 }
}
}

public void Windowswitch() throws AWTException
{
//driver.switchTo().window(firstwindow);
for(int i=0;i<=50;i++)
{
 Robot r5=new Robot();
 r5.keyPress(KeyEvent.VK_ALT);
 r5.keyPress(KeyEvent.VK_TAB); r5.keyRelease(KeyEvent.VK_TAB);r5.keyRelease(KeyEvent.VK_ALT);
 
 String s=driver.getTitle();
 if(s.equalsIgnoreCase(driver.getTitle()))
 {
 driver.navigate().refresh();
 System.out.println("another titleeeeeeeeeeeeeeeeeeeee   "+ driver.getTitle());
 break;

}
 else
 {
	 continue;
 }

}
}*/
}

}