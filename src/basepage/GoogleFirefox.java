package basepage;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GoogleFirefox extends Basetesting implements Runnable
{
	
	public void run() {
	      

		System.setProperty("webdriver.gecko.driver","C:\\Users\\sathyamoorthy.p\\Eclipse Helios\\SAIFramework\\Geckodrive\\geckodriver.exe");
		
	        try {
	            driver = new FirefoxDriver();
	           driver.get("https://teams.microsoft.com/");
	         //driver.get("https://teams.microsoft.com/"); Thread.sleep(1000);
	           String firstwindow=driver.getWindowHandle();
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
	           Thread.sleep(10000);
	          
	           //driver.findElement(By.xpath(".//*[@class='app-svg icons-chat']")).click();
	           //driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[1]/app-bar/nav/ul/li[1]/button/ng-include/svg")).click();
	           /*driver.findElement(By.xpath(".//*[@class='app-svg icons-chat']")).click();
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
	           driver.findElement(By.xpath("//*[@id=\"i0118\"]")).sendKeys("Welcome@123");*/
	          
	        } catch (Exception e) {
	            System.out.println(e);
	        }
	    }
	}

	
	

