package pageobjects;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.google.common.base.Defaults;

import basepage.Basetesting;
import basepage.Browser;

public class ParallelTestA1 extends Basetesting  {
	
	public static RemoteWebDriver driver;
	public static String appURL = "https://www.google.com/";
	
	@BeforeClass
	@Parameters({ "browser" })
	public void setUp(String browser) throws MalformedURLException {
		System.out.println("*******************");
		driver = Browser.getDriver(browser);
		driver.manage().window().maximize();
	}
	
	@Test
	public void testGooglePageTitleInFirefox() throws InterruptedException, AWTException {
		driver.navigate().to(appURL);
		/*driver.findElement(By.xpath("//*[@id=\"i0116\"]")).sendKeys("Jebas.Ebenezer@tryviumbotdev.onmicrosoft.com");
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
		String s2=driver.getCurrentUrl();
		Windowswitch();
		
	
		//String strPageTitle = driver.getTitle();
		//Assert.assertTrue(strPageTitle.equalsIgnoreCase("Google"), "Page title doesn't match");
	}

//	@AfterClass
//	public void tearDown() {
//		if(driver!=null) {
//			System.out.println("Closing browser");
//			driver.quit();
//		}
//	}*/
	
}
}