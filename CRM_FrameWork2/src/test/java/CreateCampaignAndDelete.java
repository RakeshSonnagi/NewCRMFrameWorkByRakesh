import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;
import com.comcast.crm.BaseClassUtility.BaseClass;
import com.comcast.crm.FileUtility.ExcelUtility;
import com.comcast.crm.JavaUtility.JavaUtility;
import com.comcast.crm.ObjectRepository.CampaignPage;
import com.comcast.crm.ObjectRepository.CreateCampaignPopup;
import com.comcast.crm.ObjectRepository.HomePage;

public class CreateCampaignAndDelete extends BaseClass {
	@Test
	public void campaignTest() throws IOException, InterruptedException {
		wlib.waitForPageToLoad(driver);

		JavaUtility jlib = new JavaUtility();
		int ran = jlib.getRandomNumber();

		HomePage hp = new HomePage(driver);
		WebElement createDp = hp.getDropDown();
		wlib.select(createDp, "Campaigns");

		ExcelUtility elib = new ExcelUtility();
		String campaignName = elib.getDataFromExcelUtility("create", 10, 0) + ran;
		CreateCampaignPopup cp = new CreateCampaignPopup(driver);
		cp.enterCampaignNameAndClickOnSave(campaignName);

		hp.clickOnCampaignLnk();

		CampaignPage cp1 = new CampaignPage(driver);
		WebElement cDW = cp1.getCampaignInDp();
		wlib.select("Campaign Name", cDW);
		cp1.searchCampaignNameAndClickOnSearchBtn(campaignName);
		driver.findElement(By.xpath("//a[text()='" + campaignName
				+ "' and @title='Campaigns']/parent::td/following-sibling::td//a[text()='del']")).click();

		wlib.alertAccept(driver);
		Reporter.log(campaignName+" is created successfully and deleted same campaign successfully",true);
	}

}
