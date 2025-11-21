package practise.test;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerImpClass implements ITestListener ,ISuiteListener
{
	public void onStart(ISuite suite) 
	{
		System.out.println("onStart suite Config");
	}
	public void onFinish(ISuite suite)
	{
		System.out.println("onFinish suite Config");
	}
	public void onStart(ITestContext c)
	{
		System.out.println("onStart Test Config");
	}
	public void onFinish(ITestContext result)
	{
		System.out.println("onFinish Test Config");
	}	
	public void onTestStart(ITestResult result)
	{
		System.out.println("onTestStart Test Config");
	}
	public void onTestFinish(ITestResult result)
	{
		System.out.println("onTestFinish Test Config");
	}
	public void onTestFailure(ITestResult result)
	{
		System.out.println("onTestFailure Test config");
	}
	public void onTestSuccess(ITestResult result)
	{
		System.out.println("onTestSuccess Test Config");
	}
	
	
}
