import java.io.IOException;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.comcast.crm.BaseClassUtility.BaseClass;
import com.comcast.crm.JavaUtility.JavaUtility;
import com.comcast.crm.ObjectRepository.AddEventform;
import com.comcast.crm.ObjectRepository.CalendarPage;
import com.comcast.crm.ObjectRepository.HomePage;
import com.comcast.crm.WebDriverUtility.WebDriverUtility;

public class CreatecalendarEvent extends BaseClass {
	@Test
	public void createlead() throws IOException, InterruptedException 
	{
	
		WebDriverUtility wlib = new WebDriverUtility();
	
		wlib.waitForPageToLoad(driver);
		
		HomePage hp=new HomePage(driver);
		hp.clickOnCalendarLnk();		
		CalendarPage cp= new CalendarPage(driver);
		WebElement addBtn = cp.getAddBtn();
		wlib.ActionsMoveToElement(driver, addBtn);
		cp.clickOnMeetingLnk();
		
		
		AddEventform af= new AddEventform(driver);
		WebElement eventDp = af.getEventtype();
		wlib.select(eventDp, "Meeting");
		af.enterEventName();
		JavaUtility jlib=new JavaUtility();
		String startDate = jlib.getpresentDate();
		String endDate = jlib.getFutureDate(0);
		af.entersupportdateAndSelectUserAndClickOnSave(startDate, endDate);
		wlib.alertAccept(driver);
		Reporter.log("Lead is Created Successfully",true);
	}
}
