package com.comcast.crm.createContactTest;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;
import com.comcast.crm.BaseClassUtility.BaseClass;
import com.comcast.crm.FileUtility.ExcelUtility;
import com.comcast.crm.ObjectRepository.ContactsPage;
import com.comcast.crm.ObjectRepository.CreateCampaignPopup;
import com.comcast.crm.ObjectRepository.HomePage;
import com.comcast.crm.ObjectRepository.OraganizationPopupPage;

public class CreateOrgWithContactTest extends BaseClass {
	@Test(groups="smokeTest")
	public void createOrgwithcontact() throws IOException, InterruptedException {

		String pageTitle = driver.getTitle();
		wlib.waitForSomeCondition(driver, pageTitle);

		int ran = jlib.getRandomNumber();

		HomePage hp = new HomePage(driver);
		hp.clickOnContactLnk();

		ContactsPage cp = new ContactsPage(driver);
		cp.clickOnCreateImg();

		ExcelUtility elib = new ExcelUtility();
		String lastName = elib.getDataFromExcelUtility("create", 4, 3) + ran;
		cp.enterLastNameAndClickOnOrgImg(lastName);
		OraganizationPopupPage op = new OraganizationPopupPage(driver);
		String orgName = elib.getDataFromExcelUtility("create", 4, 2);

		String parentwindow = driver.getWindowHandle();
		wlib.switchNewBrowsertab(driver, "action=Popup");
		op.searchOrgAndSelectOrgAndClickOnSave(orgName);
		driver.switchTo().window(parentwindow);
		cp.clickOnSaveBtn();
		Reporter.log("contact is created with org name successfully",true);

	}

	@Test(groups="smokeTest")
	public void createCampaign() throws IOException {

		String pageTitle = driver.getTitle();
		wlib.waitForSomeCondition(driver, pageTitle);

		int ran = jlib.getRandomNumber();

		HomePage hp = new HomePage(driver);
		WebElement quickDP = hp.getQuickcreateDp();
		wlib.select(quickDP, "Campaigns");

		ExcelUtility elib = new ExcelUtility();
		String campaignName = elib.getDataFromExcelUtility("create", 10, 0) + ran;
		CreateCampaignPopup ccp = new CreateCampaignPopup(driver);
		ccp.enterCampaignNameAndClickOnSave(campaignName);
		Reporter.log(campaignName + "\t campaign created successfully", true);

	}

	@Test(groups="regressionTest")
	public void createcontactwithSupportDate() throws EncryptedDocumentException, IOException, InterruptedException {

		String pageTitle = driver.getTitle();
		wlib.waitForSomeCondition(driver, pageTitle);

		int ran = jlib.getRandomNumber();

		HomePage hp = new HomePage(driver);
		hp.clickOnContactLnk();

		ContactsPage cp = new ContactsPage(driver);
		cp.clickOnCreateImg();

		ExcelUtility elib = new ExcelUtility();
		String lastName = elib.getDataFromExcelUtility("create", 4, 3) + ran;
		cp.enterLastName(lastName);

		String currentDate = jlib.getpresentDate();
		String supportDate = jlib.getFutureDate(30);
		cp.enterCurrentDateAndEndDate(currentDate, supportDate);
		Reporter.log("contact created successfully with support Date",true);
		

	}

}
