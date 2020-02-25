package pageobjects;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import basepage.Basetesting;

public class HubNodeTest extends Basetesting {
	
	
	
	//java -jar selenium-server-standalone-3.141.59.jar -role hub -hubConfig hubConfig.json -debug
	
	//java -Dwebdriver.ie.driver=C:\ie\IEDriverServer.exe -jar selenium-server-standalone-3.141.59.jar -role node -hub http://172.25.11.66:4444/grid/register -port 5432

	//java -Dwebdriver.gecko.driver=C:\gecko\geckodriver.exe -jar selenium-server-standalone-3.141.59.jar -role node -hub http://172.25.11.66:4444/grid/register -port 5432

		@BeforeTest

		@Parameters("node")

		public void beforeTest(String value) throws MalformedURLException,Exception

		{

		DesiredCapabilities ds=DesiredCapabilities.firefox();

		ds.setPlatform(Platform.ANY);

		driver=new RemoteWebDriver(new URL(value),ds);

		driver.manage().window().maximize();

		driver.get("https://www.google.com/");
	 	
		
		}

    	@AfterTest

		public void afterTest()

		{

		driver.close();

		}

		@Test

		public void testValidUsersDemoWebShop() throws MalformedURLException,Exception

		{
			
		driver.get("https://www.google.com/");

        }
}
