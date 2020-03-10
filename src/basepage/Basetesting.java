package basepage;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Calendar;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Properties;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Platform;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.ITestAnnotation;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;


import Datadriven.Datareading;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class Basetesting implements IRetryAnalyzer,IAnnotationTransformer,ITestListener, Runnable 

{
	 public static WebDriver driver;  
	   
	     
	 private int counter = 0; public static  String url=null;  static Properties props=null; public static String Browsertype=null; public static String resultname=null; public static int rowcounter=2; public static String today=null;public static DesiredCapabilities cap;
	 private int retryMaxLimit = 1; private static int number; private static int number1; public static ExtentReports report=null; public static ExtentTest test=null;public static RemoteWebDriver driver1;public static String appURL = "http://www.google.com";
		
	 public static  int monthdifference=0; public static int fdates; public static int numberr;public static int expectedmonth=0; public static int countforbutton=0;  public static int numericvalue=0;
	 
	 @BeforeTest
	 public static void startTest()
	 {
	 report = new ExtentReports(System.getProperty("user.dir")+"\\ExtentReportResults.html");
	 test = report.startTest("ExtentDemo");
	 }
	
		 
	public static WebDriver  browserinitialise( ) throws InterruptedException, IOException
	{
	    // Creates an empty property list
	    props = new Properties();
	    // A connection is created to config.properties file
	    FileInputStream fis = new FileInputStream("C:\\Users\\sathyamoorthy.p\\Eclipse Helios\\SAIFramework\\Config.properties");
	    // Reads the properties from the input byte stream
	    props.load(fis);
	    // Get the firefox Browser name from property file
	    Browsertype = props.getProperty("Browsertype");
	    // Assign the URL to be invoked to a String variable
	    url = props.getProperty("url");
		 	
	   if(Browsertype.equalsIgnoreCase("firefox"))
	   {
		System.setProperty("webdriver.gecko.driver","C:\\Users\\sathyamoorthy.p\\Eclipse Helios\\SAIFramework\\Geckodrive\\geckodriver.exe");
	    driver = new FirefoxDriver();
	    Thread.sleep(300);	 
	    driver.get(url);
	   }
	   else if(Browsertype.equalsIgnoreCase("chrome"))
	  {
	   System.setProperty("webdriver.chrome.driver","C:\\Users\\sathyamoorthy.p\\Eclipse Helios\\SAIFramework\\Drivers\\chomedriver.exe");
	   driver = new ChromeDriver();
	  }
	  else if(Browsertype.equalsIgnoreCase("ie"))
	  {
	  System.setProperty("webdriver.ie.driver","C:\\Users\\sathyamoorthy.p\\Eclipse Helios\\SAIFramework\\Drivers\\ieexplorerdriver.exe");
	  driver=new InternetExplorerDriver();
	  }
	  driver.manage().window().maximize();
	  driver.manage().deleteAllCookies(); 
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	  return driver;
	}
	
	
	/*  @BeforeClass 
	  public static void startTest()
	  
	   { 
	   report = new
	   ExtentReports(System.getProperty("user.dir")+"\\ExtentReportResults.html");
	   test = report.startTest("ExtentDemo");
	   
	   }*/
	 
	/*
	 * @Test public void Browseropen() throws InterruptedException, IOException {
	 * browserinitialise();
	 * Assert.assertEquals(driver.getTitle(),"Googleeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee"
	 * ); }
	 */
	 
	 
	

 @Override  
 public void onTestStart(ITestResult result)
 {  
	

 }  
   
 @Override  
 public void onTestSuccess(ITestResult result) 
 { 
	
 number= result.getStatus(); String resultname = result.getName();
 fullsscreen();
	
 System.out.println("Success of test cases and its details are");  
 }  
   
 @Override  
 public void onTestFailure(ITestResult result) {  
 number1=result.getStatus(); String resultname = result.getName();
 fullsscreen();
 System.out.println("Failure of test cases and its details are  ");  
 }  
   
 @Override  
 public void onTestSkipped(ITestResult result)
 {  

 }  
   
 @Override  
 public void onTestFailedButWithinSuccessPercentage(ITestResult result) 
 {  

 System.out.println("Failure of test cases and its details are:");  
 }  
   
 @Override  
 public void onStart(ITestContext context) 
 {  
	
 }  
   
 @Override  
 public void onFinish(ITestContext context) 
 {  
	
 } 
 


	public static void fullsscreen() 
	{
		
		Screenshot screenshot1=new AShot().shootingStrategy(ShootingStrategies.viewportPasting(500)).takeScreenshot(driver);
		System.out.println("scrollllllllllllllllllllll:");
		
        try {
        	System.out.println("scrolling:");
        	if(number==1)
        	{
        	//String path1=System.getProperty("user.dir")+"\\test-output\\Passedscreen\\" +System.currentTimeMillis()+".jpg"; 
        	String path1=System.getProperty("user.dir")+"/PASSEDScreenCapturesPNG/"+System.currentTimeMillis()+".png";
        	Reporter.setEscapeHtml(false);System.setProperty("org.uncommons.reportng.escape-output", "false");
        	ImageIO.write(screenshot1.getImage(),"png",new File(path1));  
            Reporter.log("<td><a href='"+ path1+ "'> <img src='"+ path1 + "' height='100' width='100'/> </a></td>");
           	}
        	else if(number1==2 )
        	{
        	String path2=System.getProperty("user.dir")+"/FAILEDScreenCapturesPNG/"+System.currentTimeMillis()+".jpg";
            ImageIO.write(screenshot1.getImage(),"jpg",new File(path2)); 
            Reporter.log("<a href='"+ path2+ "'> <img src='"+ path2 + "' height='100' width='100'/> </a>"); //Reporter.log("<br> <img src='"+ path2 + "' height='100' width='100'/> </br>");
        	}
       
        } catch (IOException e) {
        	
        	System.out.println("scrolling   scrolling");
        }
        
	}
	
	public static void driving(String url) throws InterruptedException
	{
		
	if(rowcounter<Datareading.TotalNumberOfRows)
	{
		driver.navigate().to(url);
		rowcounter++;Thread.sleep(5000);
	}
	else 
	{
		rowcounter=(rowcounter*0)+2;	
	}
	}
	
	
	public static String gettoday()
	{
		 //Create a Calendar Object
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
 
        //Get Current Day as a number
        int todayInt = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println("Today Int: " + todayInt +"\n");
 
        //Integer to String Conversion
        String todayStr = Integer.toString(todayInt);
        System.out.println("Today Str: " + todayStr + "\n");
        
        return todayStr;
	}
	
	public static String futureday(int num)
	{
		 //Create a Calendar Object
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
 
      
        //Get Current Day as a number
        int todayInt = calendar.get(Calendar.DAY_OF_MONTH)+num;
        System.out.println("Today Int: " + todayInt +"\n");
       
        //Integer to String Conversion
        String todayStr = Integer.toString(todayInt);
        System.out.println("Today Str: " + todayStr + "\n");
 
        return todayStr;
	}
	
	
	//@SuppressWarnings("unlikely-arg-type")

	
	
	public static String futureday_in_nextmonth(int num1,int num2)
	{
		 //Create a Calendar Object
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
 
        int month = calendar.get(Calendar.MONTH) + num1; 
        System.out.println("Today Int: " + month +"\n");
        
        //Get Current Day as a number
        int todayInt = calendar.get(Calendar.DAY_OF_MONTH)+num2;
        System.out.println("Today Int: " + todayInt +"\n");
       
        //Integer to String Conversion
        String todayStr = Integer.toString(todayInt);
        System.out.println("Today Str: " + todayStr + "\n");
 
        return todayStr;
	}
	
	public static String futuremonth1(int num)
	{
		Calendar now = Calendar.getInstance();
	    System.out.println("Current date : " + (now.get(Calendar.MONTH) + 1) + "-"
	        + now.get(Calendar.DATE) + "-" + now.get(Calendar.YEAR));
            int thismonth=now.get(Calendar.MONTH) + 1;
	  
            // add days to current date using Calendar.add method
	         now.add(Calendar.MONTH, num+1);
              int fm=now.get(Calendar.MONTH);
              System.out.println("future month for current date   "+fm); System.out.println("future month for current dateeee   "+fm);
              
             now.add(Calendar.DATE, 15);
              int fdates=now.get(Calendar.DATE);
              System.out.println("future datessssssssssssssssssssss   "+fdates);   System.out.println("future dates   "+fdates);
            
  
              monthdifference=fm-thismonth;
              
              System.out.println("month difference: " + monthdifference);
              String fmstring=Integer.toString(fm);
	    System.out.println("dated after six month : " + (now.get(Calendar.MONTH) ) + "-"
	        + now.get(Calendar.DATE) + "-" + now.get(Calendar.YEAR));
		return fmstring;
	}
	
	public static String futuremonth(int num)
	{
		Calendar now = Calendar.getInstance();
	    System.out.println("Current date : " + (now.get(Calendar.MONTH) + 1) + "-"
	     + now.get(Calendar.DATE) + "-" + now.get(Calendar.YEAR));
           
	     int pastdays=now.get(Calendar.DATE);
	     System.out.println("past daysssssssssssssssss "+pastdays);
       
         now.add(Calendar.DATE, num);
         fdates=now.get(Calendar.DATE);  expectedmonth=pastdays+num; 
         System.out.println("Expected monthhhhhhhhhhhhhh   "+expectedmonth); 
               
        System.out.println("future datessssssssssssssssssssss   "+fdates);
        String fdatesin=Integer.toString(fdates);
        return fdatesin;
	}
	
	public static int monthselection_number()
	{
		LinkedHashMap<Integer,Integer> lh=new LinkedHashMap<Integer,Integer>();
		 lh.put(31, 1);
		 lh.put(60, 2);
		 lh.put(91, 3);
		
		Set<Integer> it1=lh.keySet();
	
	    Iterator<Integer> iteratorr=it1.iterator();


		while(iteratorr.hasNext())
		{
		     numberr=(iteratorr.next());
		     if(expectedmonth<=numberr)
			{
				countforbutton=lh.get(numberr);
				System.out.println("numberrrrrrrrr  "+numberr);
				System.out.println("monthhhhhhh numberrrrrrrrrrr " +lh.get(numberr));
				break;
			}
			else
			{
				continue;
			}
						  	    
		  }
		return countforbutton;
	}
	
	public static int monthselection_number1(String month)
	{
		LinkedHashMap<String,Integer> lh1=new LinkedHashMap<String,Integer>();
		 lh1.put("Jan", 1);
		 lh1.put("Feb", 2);
		 lh1.put("Mar", 3);
		
		Set<String> it1=lh1.keySet();
	    Iterator<String> iteratorr=it1.iterator();
	
		System.out.println("LinkedHashMapppppppppppppppppppppppppppppppppppppppppp ");
		System.out.println("LinkedHashMap::");
				
		while(iteratorr.hasNext())
		{
		    String monthchoose=(iteratorr.next());
		    if(monthchoose.equalsIgnoreCase(month))
			{
				System.out.println("Month Values "+ monthchoose );
				numericvalue=lh1.get(monthchoose);
				break;
			}
			
						  	    
		  }
		return numericvalue;
	
	}
	/*
	 * public static void extent() throws IOException {
	 * test.log(LogStatus.FAIL,test.addScreenCapture(capture(driver))+
	 * "Test Failed"); }
	 */
	/*public static String capture(WebDriver driver) throws IOException {

	File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

	File Dest = new File("C:\\Users\\sathyamoorthy.p\\Eclipse Helios\\SAIFramework\\extent" + System.currentTimeMillis()

	+ ".png");

	String errflpath = Dest.getAbsolutePath();

	FileUtils.copyFile(scrFile, Dest);

	return errflpath;

	}*/
	/*public static String fullsscreen1() 
	{
		
		Screenshot screenshot=new AShot().shootingStrategy(ShootingStrategies.viewportPasting(500)).takeScreenshot(driver);
		System.out.println("scrollllllllllllllllllllll:");
        try {
        	System.out.println("scrolling:");
        	if(number==1)
        	{
        path11=System.getProperty("user.dir")+"/PASSEDScreenCapturesPNG/"+System.currentTimeMillis()+".jpg";
        	 ImageIO.write(screenshot.getImage(),"jpg",new File(path11));
            // Reporter.log("<a href='"+ path1+ "'> <img src='"+ path1 + "' height='100' width='100'/> </a>");
        	}
        	else if(number1==2 )
        	{
        	 path21=System.getProperty("user.dir")+"/FAILEDScreenCapturesPNG/"+System.currentTimeMillis()+".jpg";
            ImageIO.write(screenshot.getImage(),"jpg",new File(path21));
           // Reporter.log("<a href='"+ path2+ "'> <img src='"+ path2 + "' height='100' width='100'/> </a>");
        	}
       
        } catch (IOException e) {
        	
        	System.out.println("scrolling   scrolling");
        }
		return path11 ;
        
	}*/
	/*public static void fullsscreen1()
	{
		
		Screenshot screenshot=new AShot().shootingStrategy(ShootingStrategies.viewportPasting(500)).takeScreenshot(driver);
		System.out.println("fullsscreen1:");
        try {
        	System.out.println("Testing:");
        	String path1=System.getProperty("user.dir")+"/TestingstepsScreenCapturesPNG/"+System.currentTimeMillis()+".jpg";
        	 ImageIO.write(screenshot.getImage(),"jpg",new File(path1));
             Reporter.log("<a href='"+ path1+ "'> <img src='"+ path1 + "' height='100' width='100'/> </a>");
        	}
        	
        catch (IOException e)
        {
       	System.out.println("scrolling   scrolling");
        }
        
	}*/
	/*public static void entirescreen()
	{
		
		 try {
	            Robot robot = new Robot();
	            String format = "jpg";
	            String fileName = "C:/selenium/" + format;
	            Rectangle screenRect1 = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
	            BufferedImage screenFullImage = robot.createScreenCapture(screenRect1);
	            ImageIO.write(screenFullImage, format, new File(fileName));
	             
	            System.out.println("A full screenshot saved!");
	        } catch (AWTException | IOException ex) {
	            System.err.println(ex);
	        }
	    }*/
	
	/*public static void partialscreen(int nu1,int nu2)
	{
		  try {
	            Robot robot = new Robot();
	            String format = "jpg";
	            String fileName = "C:/selenium/" + format;
	             
	            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	            Rectangle captureRect = new Rectangle(nu1, nu2, screenSize.width / 2, screenSize.height / 2);
	            BufferedImage screenFullImage = robot.createScreenCapture(captureRect);
	            ImageIO.write(screenFullImage, format, new File(fileName));
	             
	            System.out.println("A partial screenshot saved!");
	        } catch (AWTException | IOException ex) {
	            System.err.println(ex);
	        }
	    
	}*/
	
 /*public static void screencapture() throws IOException
 {
	 
		
	 
 File src= ((TakesScreenshot)driver). getScreenshotAs(OutputType. FILE); 
	        
  FileHandler.copy(src, new File("C:/selenium/"+System. currentTimeMillis()+".png"));  
  File screenShotName = new File("C:/selenium/"+System. currentTimeMillis()+".png");
  String s = String.class.getName();
  
  System.out.println("class name"+ s);
  String filePath = screenShotName.toString();
  String path = ("<br><img src='"+filePath+"' height='300' width='300'/><br>");
  Reporter.log(path);
	 
 }*/



public  boolean retry(ITestResult result) {
if (counter < retryMaxLimit)
{
    counter++;
    return true;
     
}
	return false;
}

@Override
public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod)
{

annotation.setRetryAnalyzer(Basetesting.class);
return;
}

/*public static String CaptureScreenShotWithTestStepName(WebDriver driver, String testStepsName)
{
	try{
		// down casting WebDriver to use getScreenshotAs method.
		TakesScreenshot ts= (TakesScreenshot)driver;
		// capturing screen shot as output type file
		File screenshotSRC= ts.getScreenshotAs(OutputType.FILE);
		// Defining path and extension of image
		String path=System.getProperty("user.dir")+"/ScreenCapturesPNG/"+testStepsName+System.currentTimeMillis()+".png";
		// copying file from temp folder to desired location
		File screenshotDest= new File(path);
		FileUtils.copyFile(screenshotSRC, screenshotDest);
		return path;
	}catch(Exception e)
	{
		System.out.println("Some exception occured." + e.getMessage());
		return "";
	}
}*/


/*public static void screens(String testStepsName) throws InterruptedException
{
	// Down casting driver to JavascriptExecutor
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	// It returns height of view part. You can say it as page height. When you click on page down key
	// Page scroll by one page. 
	long pageHeight= (long)js.executeScript("return window.innerHeight");
	System.out.println("Page height: "+pageHeight);
	
	// It is how much you can scroll. It is height if you scroll, you will reach to bottom of page.
	long scrollableHeight= (long)js.executeScript("return document.body.scrollHeight");
	System.out.println("Total scrollable height: "+scrollableHeight);
	
	// Finding number of pages. Adding 1 extra to consider decimal part.
	int numberOfPages=(int) (scrollableHeight/pageHeight)+1;
	
	System.out.println("Total pages: "+numberOfPages);
	

	// Now scrolling page by page
	for(int i=0;i<numberOfPages;i++)
	{
		CaptureScreenShotWithTestStepName(driver, testStepsName+(i+1));
		js.executeScript("window.scrollBy(0,"+pageHeight+")");
		Thread.sleep(2000);
	}
}*/


/*// target day, month, year
public static int targetDay = 0;
public static int targetMonth = 0;
public static int targetYear = 0;

// current day, month, year
public static int currentDay = 0;
public static int currentMonth = 0;
public static int currentYear = 0;

// Difference in target and current month. Target could be a future date or past
// date
public static int differenceInMonths = 0;

// counter to track if the target date is future or past date
public static boolean counter1 = true;

public static void getCurrentDateMonthYear() {
    Calendar cal = Calendar.getInstance();
    currentDay = cal.get(Calendar.DAY_OF_MONTH);
    currentMonth = cal.get(Calendar.MONTH) + 1;
    currentYear = cal.get(Calendar.YEAR);
}

public static void getTargetDateMonthYear(String rawString) {
    // Breaking the date 18/02/2019 to get only values
    int firstIndex = rawString.indexOf("/");
    
    // get the positions where the two / are present
    int lastIndex = rawString.lastIndexOf("/");

    String day = rawString.substring(0, firstIndex);
    targetDay = Integer.parseInt(day);

    String month = rawString.substring(firstIndex + 1, lastIndex);
    targetMonth = Integer.parseInt(month);

    String year = rawString.substring(lastIndex + 1, rawString.length());
    targetYear = Integer.parseInt(year);
}

public static void calculateDifferenceInMonths() {
    if ((targetMonth - currentMonth) > 0) {
        differenceInMonths = targetMonth - currentMonth;
    } else {
        differenceInMonths = currentMonth - targetMonth;
        counter1 = false;
    }
}*/
/*public static RemoteWebDriver getDriver(String browser) throws MalformedURLException 
{
	
System.out.println("------------------------------------------------");
	return new RemoteWebDriver(new URL("http://172.25.11.66:4444/wd/hub"), getBrowserCapabilities(browser));
}

public static DesiredCapabilities getBrowserCapabilities(String browser) {
	if(browser.equalsIgnoreCase("firefox"))
	{
	System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
	
	return DesiredCapabilities.firefox();
	}
	else if(browser.equalsIgnoreCase("chrome"))
	{
		
		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
		return DesiredCapabilities.chrome();
	}
	else if(browser.equalsIgnoreCase("ie"))	
	{
		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
		//System.out.println("++++++++++++++++++++++++  "+ DesiredCapabilities.internetExplorer());
		return DesiredCapabilities.internetExplorer();
			
	}
	else
	{
		System.out.println("browser : " + browser + " is invalid, Launching Firefox as browser of choice..");
		return DesiredCapabilities.firefox();
	}
	
}*/
public static WebDriver  browserinitialise1(String Browsertype ) throws InterruptedException, IOException
{
  /*  // Creates an empty property list
    props = new Properties();
    // A connection is created to config.properties file
    FileInputStream fis = new FileInputStream("C:\\Users\\sathyamoorthy.p\\Eclipse Helios\\SAIFramework\\Config.properties");
    // Reads the properties from the input byte stream
    props.load(fis);
    // Get the firefox Browser name from property file
    Browsertype = props.getProperty("Browsertype");
    // Assign the URL to be invoked to a String variable
    url = props.getProperty("url");*/
	 	
   if(Browsertype.equalsIgnoreCase("firefox"))
   {
	System.setProperty("webdriver.gecko.driver","C:\\Users\\sathyamoorthy.p\\Eclipse Helios\\SAIFramework\\Geckodrive\\geckodriver.exe");
    driver = new FirefoxDriver();
    Thread.sleep(300);	 
   // driver.get(url);
   }
   else if(Browsertype.equalsIgnoreCase("ie"))
  {
  System.setProperty("webdriver.ie.driver","C:\\Users\\sathyamoorthy.p\\Eclipse Helios\\SAIFramework\\IE\\IEDriverServer.exe");
  driver=new InternetExplorerDriver();
  }
  driver.manage().window().maximize();
  driver.manage().deleteAllCookies(); 
  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
  return driver;
}
public void gridtest() throws MalformedURLException
{
	
	String nodeurl="http://172.25.11.66:5556/wd/hub";
	DesiredCapabilities cap= DesiredCapabilities.firefox();
	cap.setBrowserName("firefox");
	cap.setPlatform(Platform.WIN10);
	cap.setVersion("72.02");
	//cap.setVersion("42.17134.1098.0");
	driver1=new  RemoteWebDriver(new URL(nodeurl),cap);
	driver1.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver1.manage().window().maximize();
	driver1.get("https://www.google.com/");
}
//@AfterTest
//public static void endTest()
//{
//report.endTest(test);
//report.flush();
//}
public static void error() {
	Alert alert = driver.switchTo().alert();
	
	System.out.println("js windowwwwwwwwwwwwwwww "+ driver.getTitle());
	// Will click on Cancel button.
	alert.dismiss();
	
}

public static void scrollToTop(WebDriver driver) {
    ((JavascriptExecutor) driver)
      .executeScript("window.scrollTo(0,0)");
  }

  public static void scrollToBottom(WebDriver driver) {
    ((JavascriptExecutor) driver)
      .executeScript("window.scrollTo(0, document.body.scrollHeight)");
  }

  public static void scrollToElementTop(WebDriver driver, WebElement element) {
    ((JavascriptExecutor) driver).executeScript(
      "arguments[0].scrollIntoView(true);", element);
  }

  public static void scrollToElementBottom(WebDriver driver, WebElement element) {
    ((JavascriptExecutor) driver).executeScript(
      "arguments[0].scrollIntoView(false);", element);
  }
public  void firefoxprofile()
{
	FirefoxProfile profile = new FirefoxProfile();
    profile.setPreference("network.proxy.no_proxies_on", "localhost, 127.0.0.1");
   // FirefoxOptions.setProfile(profile);
}

public static WebDriver getFirefoxDriver()
        throws Exception
{

   // String path = "src/test/resources/geckodriver";
    //System.out.println("******** " + path);
	System.setProperty("webdriver.gecko.driver","C:\\Users\\sathyamoorthy.p\\Eclipse Helios\\SAIFramework\\Geckodrive\\geckodriver.exe");

    DesiredCapabilities capabilities =  DesiredCapabilities.firefox();
	capabilities.setCapability("marionette", true);
    capabilities.setCapability("networkConnectionEnabled", true);
    capabilities.setCapability("browserConnectionEnabled", true);


//    WebDriver driver = new RemoteWebDriver(
//            new URL("http://localhost:4444"),
//            capabilities);

//	WebDriver driver = new MarionetteDriver(capabilities);

	return driver;
}
public static void Switch() throws AWTException
{
LOOPA:for(int i1=0;i1<=0;i1++)
{
String s1="Global Service Desk QA | Microsoft Teams";	

Robot rob=new Robot();
 rob.keyPress(KeyEvent.VK_ALT);
 rob.keyPress(KeyEvent.VK_TAB); rob.keyRelease(KeyEvent.VK_TAB);rob.keyRelease(KeyEvent.VK_ALT);
//https://www.edureka.co/community/49746/how-to-do-session-handling-in-selenium-webdriver
 //System.out.println("new titleeeeeeeeeeeeeeeeeeeee   "+ driver.getTitle());
 // Press Enter
 rob.keyPress(KeyEvent.VK_ENTER);

//  Release Enter
 rob.keyRelease(KeyEvent.VK_ENTER);
 
 if(s1.equalsIgnoreCase(driver.getTitle()))
 {
	 System.out.println("new titleeeeeeeeeeeeeeeeeeeee   "+ driver.getTitle());
	// driver.navigate().refresh();
	 break;
 }
 else
 {
	 continue LOOPA;
 }
}
}

public static void Windowswitch() throws AWTException
{
//driver.switchTo().window(firstwindow);
for(int i=0;i<=0;i++)
{
 Robot r5=new Robot();
 r5.keyPress(KeyEvent.VK_ALT);
 r5.keyPress(KeyEvent.VK_TAB); r5.keyRelease(KeyEvent.VK_TAB);r5.keyRelease(KeyEvent.VK_ALT);
 
 /*String s=driver.getTitle();
 if(s.equalsIgnoreCase(driver.getTitle()))
 {
 //driver.navigate().refresh();
// System.out.println("another titleeeeeeeeeeeeeeeeeeeee   "+ driver.getTitle());
 break;

}
 else
 {
	 continue;
 }*/

}
}
public static void sendShortCut(WebDriver driver) {
    Actions action = new Actions(driver);
     action.sendKeys(Keys.chord(Keys.CONTROL, "T")).build().perform();
}
public WebElement FindElementWithWait(By xpath, int timeout) throws InterruptedException
{
    boolean found = false;
    int loop = 0;
    WebElement element = null;
    int i = timeout * 10;
    while (!found && loop < i)
    {
        try
        {
            element = driver.findElement(xpath);
            found = true;
        }
        catch (Exception e)
        {
            found = false;
        }
        finally
        {
            loop++;

            Thread.sleep(100);
        }
    }

    return element;
}

public static void JavascriptClick(WebElement element)
{
	((JavascriptExecutor)driver).executeScript("arguments[0].click();",element);
}

public static void safeJavaScriptClick(WebElement element) throws Exception {
	try {
		if (element.isEnabled() && element.isDisplayed()) {
			System.out.println("enableeeeeeeeeeeeeeeeeeeeeeeeee   "+ "   " +element.isEnabled() + "   "+"displayeeeeeeeeeeeeeeee  "   +element.isDisplayed());
			System.out.println("Clicking on element with using java script click");
            
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
			 System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
	    	
		}
            else
            {
			System.out.println("Unable to click on element");
		     }
	} catch (StaleElementReferenceException e) {
		System.out.println("Element is not attached to the page document "+ e.getStackTrace());
	} catch (NoSuchElementException e) {
		System.out.println("Element was not found in DOM "+ e.getStackTrace());
	} catch (Exception e) {
		System.out.println("Unable to click on element "+ e.getStackTrace());
	}
}


@Override
public void run() {
	
	
}


}
