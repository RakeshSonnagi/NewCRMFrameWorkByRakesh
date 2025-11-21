package com.comcast.crm.createOrgTest;

import java.io.IOException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.comcast.crm.BaseClassUtility.BaseClass;
import com.comcast.crm.FileUtility.ExcelUtility;
import com.comcast.crm.ObjectRepository.HomePage;
import com.comcast.crm.ObjectRepository.OrgPage;

/**
 * @author HP class for creating Organization
 */
public class CreateOrgTest extends BaseClass {

	@Test(groups = "smokeTest")
	public void createOrg() throws IOException {

		String pageTitle = driver.getTitle();
		wlib.waitForSomeCondition(driver, pageTitle);

		int ran = jlib.getRandomNumber();
		HomePage hp = new HomePage(driver);
		hp.clickOrgLnk();

		OrgPage op = new OrgPage(driver);
		op.clickOnCreateImg();

		/* read testscript data from excel sheet */

		ExcelUtility elib = new ExcelUtility();
		String orgName = elib.getDataFromExcelUtility("org", 1, 2) + ran;
		op.enterAccountNameAndClickOnSave(orgName);

		// Verify the Organization Name
		String actualOrgName = op.getActOrgName().getText();
		String exp = orgName;
		Assert.assertEquals(true,actualOrgName.contains(exp));
		Reporter.log(actualOrgName+ " created successfully" , true);

	}

	@Test(groups = "regressionTest")
	public void createOrgwithIndusrty() throws IOException, InterruptedException {

		String pageTitle = driver.getTitle();
		wlib.waitForSomeCondition(driver, pageTitle);

		int ran = jlib.getRandomNumber();
		HomePage hp = new HomePage(driver);
		hp.clickOrgLnk();

		OrgPage op = new OrgPage(driver);
		op.clickOnCreateImg();

		// read testscript data from excel sheet

		ExcelUtility elib = new ExcelUtility();
		String orgName = elib.getDataFromExcelUtility("org", 1, 2) + ran;
		op.enterAccountName(orgName);

		WebElement industryDrop = op.getIndustryDp();
		String industryName = elib.getDataFromExcelUtility("org", 4, 3);
		wlib.select(industryName, industryDrop);

		Thread.sleep(2000);
		WebElement typeDrop = op.getAccttype();
		String typeName = elib.getDataFromExcelUtility("org", 4, 4);
		wlib.select(typeName, typeDrop);

		op.clickOnSaveBtn();
		

		// Verify The IndustryName and Type
		String actIndustryName = op.getActIndustryName().getText();
		Assert.assertEquals(actIndustryName, industryName);
		Reporter.log(actIndustryName+"\t industry Name is correct",true);

		String acttypeName = op.getActtypeName().getText();
		Assert.assertEquals(acttypeName, typeName);
		Reporter.log(acttypeName + "\tfor Indusrty type is correct", true);
	}

	@Test(groups = "regressionTest")
	public void createOrgwithPhoneNumber() throws IOException {

		String pageTitle = driver.getTitle();
		wlib.waitForSomeCondition(driver, pageTitle);

		int ran = jlib.getRandomNumber();
		HomePage hp = new HomePage(driver);
		hp.clickOrgLnk();

		OrgPage op = new OrgPage(driver);
		op.clickOnCreateImg();

		// read testscript data from excel sheet
		ExcelUtility elib = new ExcelUtility();
		String orgName = elib.getDataFromExcelUtility("org", 7, 2) + ran;
		op.enterAccountName(orgName);

		String phonenum = elib.getDataFromExcelUtility("org", 7, 3);
		op.enterPhoneNumberAndClickOnSaveBtn(phonenum);

		String actphonenum = op.getActPhoneNumber().getText();
		Assert.assertEquals(actphonenum, phonenum);
		Reporter.log(actphonenum + "===phone number is verified successfully===", true);

	}

}
