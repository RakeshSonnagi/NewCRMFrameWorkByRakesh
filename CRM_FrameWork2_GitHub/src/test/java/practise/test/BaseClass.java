package practise.test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.comcast.crm.DatabaseUtility.DataBaseUtility;
import com.comcast.crm.FileUtility.ExcelUtility;
import com.comcast.crm.FileUtility.FileUtility;
import com.comcast.crm.WebDriverUtility.WebDriverUtility;

public class BaseClass {
	FileUtility flib = new FileUtility();
	ExcelUtility elib = new ExcelUtility();
	WebDriverUtility wlib = new WebDriverUtility();
	DataBaseUtility dblib = new DataBaseUtility();
	WebDriver driver;

	@BeforeSuite
	public void configBS() throws IOException 
	{
		System.out.println("execute Before Suite");
	}

	@BeforeTest
	public void configBT() throws IOException 
	{
		System.out.println("execute Before Test");
	}

	@BeforeClass
	public void configBC() throws IOException {
		System.out.println("execute Before Class");

	}

	@BeforeMethod
	public void configBM() throws IOException {
		System.out.println("execute Before Method");
		String BROWSER = flib.getDataFromProperties("browser");
		if (BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new ChromeDriver();
		}
		wlib.waitForPageToLoad(driver);
		wlib.maxBrowser(driver);
		String url = flib.getDataFromProperties("url");
		driver.get(url);
	}

	@AfterMethod
	public void configAM() {
		System.out.println("execute After Method");
	}

	@AfterClass
	public void configAC() {
		System.out.println("execute After Class");
		driver.quit();
	}

	@AfterTest
	public void configAT() {
		System.out.println("execute After Test");
		// driver.quit();
	}

	@AfterSuite
	public void configAS() {
		System.out.println("execute After Suite");
	}

}
