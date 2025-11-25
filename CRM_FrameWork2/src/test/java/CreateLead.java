import java.io.IOException;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;
import com.comcast.crm.BaseClassUtility.BaseClass;
import com.comcast.crm.ObjectRepository.CalendarEventPage;
import com.comcast.crm.ObjectRepository.HomePage;
import com.comcast.crm.ObjectRepository.LeadsPage;

public class CreateLead extends BaseClass {
	@Test
	public void createlead() throws IOException {

		wlib.waitForPageToLoad(driver);

		HomePage hp = new HomePage(driver);
		hp.clickOnLeadLnk();

		LeadsPage lep = new LeadsPage(driver);
		lep.clickOnCreateImg();
		WebElement salDp = lep.getSalutationDp();
		wlib.select(salDp, "Mr.");
		lep.enterDetailsOfLead();

		CalendarEventPage cp = new CalendarEventPage(driver);
		WebElement activityDp = cp.getActivityDp();
		wlib.select(activityDp, "Meeting");
		cp.enterEventName();
		wlib.alertAccept(driver);
		Reporter.log("Lead is created successfully with Event Name", true);
	}

}
