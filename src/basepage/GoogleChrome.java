package basepage;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleChrome extends Basetesting implements Runnable
{
	  public void run() {
	      
//
		  System.setProperty("webdriver.ie.driver","C:\\Users\\sathyamoorthy.p\\Eclipse Helios\\SAIFramework\\IE\\IEDriverServer.exe");
		
	        try {
	        	driver = new InternetExplorerDriver();
	        	driver.manage().window().maximize();
	           driver.get("https://teams.microsoft.com/");
	         /*  driver.findElement(By.xpath("//*[@id=\"i0116\"]")).sendKeys("varshini.a@tryviumbotdev.onmicrosoft.com");
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
	          /* driver.findElement(By.xpath("//*[@id=\"i0116\"]")).sendKeys("varshini.a@tryviumbotdev.onmicrosoft.com");
	           driver.findElement(By.xpath("//*[@id=\"idSIButton9\"]")).click();
	           driver.findElement(By.xpath("//*[@id=\"i0118\"]")).sendKeys("Welcome@123");
	           Windowswitch();
	           WebElement e =driver.findElement(By.xpath("//*[@id='discover-apps-button']"));
	           e.click();
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

	           Windowswitch();Thread.sleep(10000);
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
//	           	Thread.sleep(1000);
//	           	driver.manage().window().setPosition(new Point(0, -2000)); Thread.sleep(1000);
	           	driver.manage().window().maximize();
	           	
	             //  WebElement e =driver.findElement(By.xpath("//*[@id='discover-apps-button']"));
	               //safeJavaScriptClick(e);
	               System.out.println("----------------------------");
	             
	               
//	               Actions action = new Actions(driver);
//	               action.moveToElement(e).click().perform();
//	               ((JavascriptExecutor)driver).executeScript("window.scrollTo(0,"+e.getLocation().y+")");
//	               e.click();
	               WebDriverWait wait = new WebDriverWait(driver, 1000);
	               wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id='discover-apps-button']")))); 
	               wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@id='discover-apps-button']"))));
	               driver.findElement(By.xpath("//*[@id='discover-apps-button']")).sendKeys("");
	               driver.findElement(By.xpath("//*[@id='discover-apps-button']")).click();
	               
//	           	WebDriverWait wait = new WebDriverWait(driver, 120);
//	           	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='discover-apps-button']")));
	           	//e.click();
	           	 //Thread.sleep(1000); Actions a1=new Actions(driver);
	                 //a1.moveToElement(e).click().build().perform();

	           	//JavascriptClick(FindElementWithWait(By.xpath("//*[@id='discover-apps-button']"), 20));
//	           	WebDriverWait wait1 = new WebDriverWait(driver, 100);
//	           	WebElement element1 = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='discover-apps-button']")));
//	           	element1.click();
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

	           Windowswitch();

	           driver.findElement(By.xpath("//*[@id='discover-apps-button']")).click();
	           String subWindowHandler=null;
	           Set<String> handles = driver.getWindowHandles();
	           Iterator<String> iterator = handles.iterator();
	           while (iterator.hasNext())
	           {
	            subWindowHandler = iterator.next();
	            System.out.println("^^^^^^^^^^^^^^  "+ subWindowHandler);
	           }

	           Thread.sleep(2000);*/
	           Thread.sleep(2000);
	  
             // Windowswitch();

             // driver.findElement(By.xpath("//*[@id='discover-apps-button']")).click();
	  
	        } catch (Exception e) {
	            System.out.println(e);
	        }
	        

		       
		        
	    }
	}

