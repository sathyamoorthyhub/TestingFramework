package testrunner;

import org.testng.annotations.Test;

import basepage.Basetesting;
import pageobjects.ParallelTestA;

public class ParallelTestATes extends Basetesting {
	ParallelTestA pt=new ParallelTestA();
	
	@Test
	public void testingmethod() throws Exception
	{
		pt.testGooglePageTitleInFirefox();
	}

}
