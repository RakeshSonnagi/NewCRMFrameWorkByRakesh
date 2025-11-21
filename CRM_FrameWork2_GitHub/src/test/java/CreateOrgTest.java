
import java.io.IOException;

import org.testng.annotations.Test;

import com.comcast.crm.BaseClassUtility.BaseClass;
import com.comcast.crm.FileUtility.ExcelUtility;
import com.comcast.crm.ObjectRepository.HomePage;
import com.comcast.crm.ObjectRepository.OrgPage;
/**
 * @author HP class for creating Organization
 */
public class CreateOrgTest extends BaseClass {

	@Test(invocationCount=2)
	public void createOrg() throws IOException {

		String pageTitle = driver.getTitle();
		wlib.waitForSomeCondition(driver, pageTitle);

		int ran = jlib.getRandomNumber();
		HomePage hp = new HomePage(driver);
		hp.getOrgLnk().click();

		OrgPage op = new OrgPage(driver);
		op.getCreateimg().click();

		/* read testscript data from excel sheet */

		ExcelUtility elib = new ExcelUtility();
		String orgName = elib.getDataFromExcelUtility("org", 1, 2) + ran;

		op.getAccName().sendKeys(orgName);
		op.getSavebtn().click();

		// Verify the Organization Name
		String actualOrgName = op.getActOrgName().getText();
		String exp = orgName;
		if (actualOrgName.contains(exp)) {
			System.out.println("Organization created Successfully");
		}
	}

}
