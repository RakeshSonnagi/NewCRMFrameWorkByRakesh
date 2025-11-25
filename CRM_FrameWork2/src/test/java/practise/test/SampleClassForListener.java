package practise.test;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(practise.test.ListenerImpClass.class)
public class SampleClassForListener  extends BaseClass1 {

	@Test
	public void sample() 
	{
		System.out.println("Sample");
	}
	@Test
	public void sample1()
	{
		System.out.println("Sample1");
	}
}
