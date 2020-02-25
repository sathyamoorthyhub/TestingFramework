package pageobjects;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import basepage.Basetesting;
import basepage.Browser;

public class ParallelTestB extends Basetesting {
	
	public static RemoteWebDriver driver;
	public static String appURL = "https://teams.microsoft.com/";
	
	@BeforeClass
	@Parameters({ "browser" })
	public void setUp(String browser) throws MalformedURLException {
		System.out.println("*******************");
		driver = Browser.getDriver(browser);
		driver.manage().window().maximize();
	}
	
	@Test
	public void testGooglePageTitleInChrome() throws AWTException, InterruptedException {
		driver.navigate().to(appURL);
		
	    Thread.sleep(20000);
	    
	   // driver.findElement(By.xpath("//*[@id='discover-apps-button']")).click(); Thread.sleep(1000);
	
		//String strPageTitle = driver.getTitle();
		/*driver.findElement(By.xpath("//*[@id=\"i0116\"]")).sendKeys("varshini.a@tryviumbotdev.onmicrosoft.com");
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
		driver.findElement(By.xpath("/html/body/promote-desktop/div/div/div/div[1]/div[2]/div/a")).click();*/
		Thread.sleep(5000);

		System.out.println("title   "+ driver.getTitle());
		//Assert.assertTrue(strPageTitle.equalsIgnoreCase("Google"), "Page title doesn't match");
	}
	
	/*@Test
	public void testSearchGoogle() {
		System.out.println("Opening Google..");
		driver.navigate().to(appURL);
		driver.findElement(By.name("q")).sendKeys("Selenium Easy Grid Tutorials");
		driver.findElement(By.name("btnG")).click();
	}*/

//	@AfterClass
//	public void tearDown() {
//		if(driver!=null) {
//			System.out.println("Closing browser");
//			driver.quit();
//		}
//	}
}
