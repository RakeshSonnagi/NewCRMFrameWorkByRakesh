import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.comcast.crm.FileUtility.FileUtility;
import com.comcast.crm.JavaUtility.JavaUtility;
import com.comcast.crm.ObjectRepository.AddEventform;
import com.comcast.crm.ObjectRepository.CalendarPage;
import com.comcast.crm.ObjectRepository.HomePage;
import com.comcast.crm.ObjectRepository.LoginPage;
import com.comcast.crm.WebDriverUtility.WebDriverUtility;

public class CreatecalendarEvent {

	
	WebDriver driver;
	@Test
	public void createlead() throws IOException, InterruptedException 
	{
		FileUtility plib = new FileUtility();
		String browser = plib.getDataFromProperties("browser");
		String url = plib.getDataFromProperties("url");
		String username = plib.getDataFromProperties("username");
		String password = plib.getDataFromProperties("password");

		WebDriverUtility wlib = new WebDriverUtility();
		if (browser.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equals("firefox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new ChromeDriver();
		}

		driver.get(url);
		wlib.maxBrowser(driver);
		wlib.waitForPageToLoad(driver);
		
		LoginPage lp = new LoginPage(driver);
		lp.loginactions(username, password);
		
		HomePage hp=new HomePage(driver);
		hp.getCaledarLnk().click();
		
		CalendarPage cp= new CalendarPage(driver);
		WebElement addBtn = cp.getAddBtn();
		wlib.ActionsMoveToElement(driver, addBtn);
		cp.getMeetingLnk().click();
		
		
		AddEventform af= new AddEventform(driver);
		WebElement eventDp = af.getEventtype();
		wlib.select(eventDp, "Meeting");
		af.getEventname().sendKeys("NewLaunch");
		JavaUtility jlib=new JavaUtility();
		String startDate = jlib.getpresentDate();
		String endDate = jlib.getFutureDate(0);
		//System.out.println(endDate);
		af.getStartDate().clear();
		af.getStartDate().sendKeys(startDate);
		Thread.sleep(2000);
		af.getEndDate().clear();
		af.getEndDate().sendKeys(endDate);
		
		af.getAvailableUser().click();
		
		af.getAddBtn().click();
		af.getSaveBtn().click();
		wlib.alertAccept(driver);
	
		driver.quit();
	
	}
}
