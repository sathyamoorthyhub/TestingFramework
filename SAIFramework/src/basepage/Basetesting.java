package basepage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Calendar;
import java.util.Properties;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.ITestAnnotation;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import Datadriven.Datareading;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class Basetesting implements IRetryAnalyzer,IAnnotationTransformer,ITestListener

{
	 public static WebDriver driver;  
	   
	     
	 private int counter = 0; public static  String url=null;  static Properties props=null; public static String Browsertype=null; public static String resultname=null; public static int rowcounter=2; public static String today=null;
	 private int retryMaxLimit = 1; private static int number; private static int number1; public static ExtentReports report=null; public static ExtentTest test=null;
	 
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
        	String path1=System.getProperty("user.dir")+"/PASSEDScreenCapturesPNG/"+System.currentTimeMillis()+".png"; Reporter.setEscapeHtml(false);System.setProperty("org.uncommons.reportng.escape-output", "false");
        	ImageIO.write(screenshot1.getImage(),"png",new File(path1));  //String path = "<img src=\"file:///" + path1 + "\" alt=\"\"/>";  
             Reporter.log("<a href='"+ path1+ "'> <img src='"+ path1 + "' height='100' width='100'/> </a>");
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


@AfterTest
public static void endTest()
{
report.endTest(test);
report.flush();
}




}