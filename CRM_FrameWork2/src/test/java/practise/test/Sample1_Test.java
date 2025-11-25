package practise.test;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.crm.BaseClassUtility.BaseClass;
import com.comcast.crm.ListenerUtility.ThreadLocalClass;
@Listeners(com.comcast.crm.ListenerUtility.LIstenerImpClass.class)
public class Sample1_Test  extends BaseClass
{
	@Test
	public void sampleTest() 
	{
		System.out.println("SampleTest1");
		ThreadLocalClass.getTest().log(Status.INFO, "Compare Title of the Page");
		//Assert.assertEquals("home", driver.getTitle());
	}
//	
//	@Test
//	public void sampleTest2() 
//	{
//		System.out.println("SampleTest2");
//	} 
}
