import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.comcast.crm.FileUtility.FileUtility;
import com.comcast.crm.ObjectRepository.CalendarEventPage;
import com.comcast.crm.ObjectRepository.HomePage;
import com.comcast.crm.ObjectRepository.LeadsPage;
import com.comcast.crm.ObjectRepository.LoginPage;
import com.comcast.crm.WebDriverUtility.WebDriverUtility;

public class CreateLead {
	WebDriver driver;
	@Test
	public void createlead() throws IOException 
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
		hp.getLeadLnk().click();
		
		LeadsPage lep= new LeadsPage(driver);
		lep.getCreateImg().click();
		WebElement salDp = lep.getSalutationDp();
		wlib.select(salDp, "Mr.");
		lep.getFirstNameEdt().sendKeys("sam");
		lep.getLastNameEdt().sendKeys("jam");
		lep.getCompanyNameEdt().sendKeys("HP");
		lep.getSaveBtn().click();
		lep.getEventLnk().click();
		
		CalendarEventPage cp=new CalendarEventPage(driver);
		WebElement activityDp = cp.getActivityDp();
		wlib.select(activityDp, "Meeting");
		cp.getEventName().sendKeys("NewLaunch");
		cp.getSaveBtn().click();
		
		driver.quit();
}


}

